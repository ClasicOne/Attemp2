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
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import lt.kvk.i12_2.tvakarastis.R;
import lt.kvk.i12_2.tvakarastis.SpinnerManipulation;
import lt.kvk.i12_2.tvakarastis.WebViewControls;

/**
 * Created by Meskius on 10/23/2017.
 */


/*function a(){for(var i=0;i<document.querySelectorAll('#room option').length;i++){
        str += 'case "'+document.querySelectorAll('#room option')[i].innerText+'":\n'+'selection("prof","'+document.querySelectorAll('#prof option')[i].value+'");\n click();\nbreak;\n'}
        str += 'default:\nbreak;'}*/

public class AuditorijosSVMF extends AppCompatActivity {

    WebView ww;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auditorijos_tf);

        Intent intent = getIntent();
        ww = (WebView) findViewById(R.id.ww);
        WebViewControls.webViewSetting(ww);
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/classrooms.php");
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


        //Button savaite = (Button)findViewById(R.id.savaiteATF);
        final Spinner spinner = (Spinner) findViewById(R.id.spinnerATF);
        //<------------------------- Deklaruojamas Hashmap
        final HashMap<String, String> grupesHashmap = new HashMap<>();
        String[] auditorijos_str = getResources().getStringArray(R.array.auditorijos_SVMF_str);
        String[] auditorijos_value = getResources().getStringArray(R.array.auditorijos_SVMF_value);
        for (int i = 0; i < auditorijos_str.length; i++)
            grupesHashmap.put(auditorijos_str[i], auditorijos_value[i]);
        //<-------------------------
        //Spinner uzpildumas
        SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.auditorijos_SVMF_str), spinner,this);
        TextView textView = (TextView) findViewById(R.id.textA);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                // Log.e("Duck",spinnerText+" "+grupesHashmap.get(spinnerText));
                if (!grupesHashmap.get(spinnerText).equals("duck") && !grupesHashmap.get(spinnerText).equals(null)) {
                    WebViewControls.selectionOption("room", "" + grupesHashmap.get(spinnerText) + "",ww);
                    //click selection
                    WebViewControls.click(ww, "javascript:view();");
                    ww.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smvf_auditorijos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                //ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/classrooms.php");
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
