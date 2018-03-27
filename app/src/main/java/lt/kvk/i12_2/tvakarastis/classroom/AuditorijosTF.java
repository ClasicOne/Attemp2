package lt.kvk.i12_2.tvakarastis.classroom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

import lt.kvk.i12_2.tvakarastis.R;
import lt.kvk.i12_2.tvakarastis.SpinnerManipulation;
import lt.kvk.i12_2.tvakarastis.WebViewControls;

/**
 * Created by Meskius on 10/23/2017.
 */

public class AuditorijosTF extends AppCompatActivity {

    WebView ww;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auditorijos_tf);

        Intent intent = getIntent();
        wwShit();

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerATF);
        //<------------------------- Deklaruojamas Hashmap
        final HashMap<String, String> grupesHashmap = new HashMap<>();
        String[] auditorijos_str = getResources().getStringArray(R.array.auditorijos_TF_str);
        String[] auditorijos_value = getResources().getStringArray(R.array.auditorijos_TF_value);
        for (int i = 0; i < auditorijos_str.length; i++)
            grupesHashmap.put(auditorijos_str[i], auditorijos_value[i]);
        //<-------------------------
        //Spinner uzpildumas
        SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.auditorijos_TF_str), spinner, this);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                if (!grupesHashmap.get(spinnerText).equals("duck")) {
                    WebViewControls.selectionOption("room", "" + grupesHashmap.get(spinnerText) + "", ww);
                    ww.setVisibility(View.VISIBLE);
                    //click selection
                    WebViewControls.click(ww, "javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void wwShit() {
        ww = (WebView) findViewById(R.id.ww);
        WebViewControls.webViewSetting(ww);
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/classrooms.php");
        ww.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                WebViewControls.hide(ww,"classroom");
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tf_auditorijos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                //ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/classrooms.php");
                restartActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void restartActivity() {
        Intent mIntent = getIntent();
        finish();
        startActivity(mIntent);
    }
}
