package lt.kvk.i12_2.tvakarastis.classroom;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import lt.kvk.i12_2.tvakarastis.R;

/**
 * Created by Meskius on 10/23/2017.
 */


/*function a(){for(var i=0;i<document.querySelectorAll('#room option').length;i++){
        str += 'case "'+document.querySelectorAll('#room option')[i].innerText+'":\n'+'selection("prof","'+document.querySelectorAll('#prof option')[i].value+'");\n click();\nbreak;\n'}
        str += 'default:\nbreak;'}*/

public class AuditorijosSVMF extends AppCompatActivity{

    WebView ww;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auditorijos_tf);

        Intent intent= getIntent();
        ww();
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/classrooms.php");
        ww.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hide();
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });


        //Button savaite = (Button)findViewById(R.id.savaiteATF);
        final Spinner spinner = (Spinner)findViewById(R.id.spinnerATF);
        //<------------------------- Deklaruojamas Hashmap
        final HashMap<String,String> grupesHashmap = new  HashMap<>();
        String[] auditorijos_str = getResources().getStringArray(R.array.auditorijos_SVMF_str);
        String[] auditorijos_value = getResources().getStringArray(R.array.auditorijos_SVMF_value);
        for(int i = 0;i<auditorijos_str.length; i++)
            grupesHashmap.put(auditorijos_str[i], auditorijos_value[i]);
        //<-------------------------
        spinner(getResources().getStringArray(R.array.auditorijos_SVMF_str),spinner);
        TextView textView= (TextView)findViewById(R.id.textA);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
               // Log.e("Duck",spinnerText+" "+grupesHashmap.get(spinnerText));
                if (!grupesHashmap.get(spinnerText).equals("duck") && !grupesHashmap.get(spinnerText).equals(null)){
                    selection("room",""+grupesHashmap.get(spinnerText)+"");
                    click();
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

    private void ww() {
        ww= (WebView)findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
    }

    public void click(){
        // ww.loadUrl("javascript:$(document.querySelector(\"input.inputbutton.special\")).click();");
        ww.loadUrl("javascript:view();");
    }
    public void selection( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
    public void hide(){
        //ww.loadUrl("javascript:$(document.querySelector(\"#data_form\")).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[0]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[2]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"table td\")[3]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"table button\")[0]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr\")[4]).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\".main_menu\")).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\"#customMessage\")).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\"#adminError\")).hide()");
        ww.loadUrl("javascript:$(\"html\").css(\"margin-top\", 0);");
        ww.loadUrl("javascript:document.body.style.marginTop=-10");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[3]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[2]).hide()");
    }
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smvf_auditorijos,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                //ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/classrooms.php");
                restartActivity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void restartActivity(){
        Intent mIntent = getIntent();
        finish();
        startActivity(mIntent);
    }
}
