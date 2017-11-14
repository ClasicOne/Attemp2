package com.example.meskius.attemp2;

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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Meskius on 10/23/2017.
 */


/*function a(){for(var i=0;i<document.querySelectorAll('#room option').length;i++){
        str += 'case "'+document.querySelectorAll('#room option')[i].innerText+'":\n'+'selection("prof","'+document.querySelectorAll('#prof option')[i].value+'");\n click();\nbreak;\n'}
        str += 'default:\nbreak;'}*/

public class AuditorijosSMF extends AppCompatActivity{

    WebView ww;

    String auditorijosText[] ={"--pasirinkti--","2","3","7","9","11","126","207","211","216","302","304","306","307","308","309","310","311","312","315","317","402","405","406","407","408","410","411","412","409","209 VPMF","210 VPMF","216  (Jaunystės g. 2)","Debreceno g. 25","204","Biblioteka","417 (Jaunystės g. 2)","9.30 val.- Dariaus ir Girėno g. 8-  a. 26"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auditorijos_smf);

        Intent intent= getIntent();
        ww= (WebView)findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_smf/classrooms.php");
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

        Button back = (Button)findViewById(R.id.backTF);
        //Button savaite = (Button)findViewById(R.id.savaiteATF);
        final Spinner spinner = (Spinner)findViewById(R.id.spinnerATF);
        spinner(auditorijosText,spinner);
        TextView textView= (TextView)findViewById(R.id.textA);
        Button refresh=(Button)findViewById(R.id.refreshATF);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                switch (spinnerText){
                    case "2":
                        selection("room","1");
                        click();
                        break;
                    case "3":
                        selection("room","2");
                        click();
                        break;
                    case "7":
                        selection("room","3");
                        click();
                        break;
                    case "9":
                        selection("room","5");
                        click();
                        break;
                    case "11":
                        selection("room","6");
                        click();
                        break;
                    case "126":
                        selection("room","7");
                        click();
                        break;
                    case "207":
                        selection("room","8");
                        click();
                        break;
                    case "211":
                        selection("room","9");
                        click();
                        break;
                    case "216":
                        selection("room","11");
                        click();
                        break;
                    case "302":
                        selection("room","12");
                        click();
                        break;
                    case "304":
                        selection("room","13");
                        click();
                        break;
                    case "306":
                        selection("room","14");
                        click();
                        break;
                    case "307":
                        selection("room","15");
                        click();
                        break;
                    case "308":
                        selection("room","16");
                        click();
                        break;
                    case "309":
                        selection("room","17");
                        click();
                        break;
                    case "310":
                        selection("room","18");
                        click();
                        break;
                    case "311":
                        selection("room","19");
                        click();
                        break;
                    case "312":
                        selection("room","20");
                        click();
                        break;
                    case "315":
                        selection("room","21");
                        click();
                        break;
                    case "317":
                        selection("room","23");
                        click();
                        break;
                    case "402":
                        selection("room","24");
                        click();
                        break;
                    case "405":
                        selection("room","25");
                        click();
                        break;
                    case "406":
                        selection("room","26");
                        click();
                        break;
                    case "407":
                        selection("room","27");
                        click();
                        break;
                    case "408":
                        selection("room","28");
                        click();
                        break;
                    case "410":
                        selection("room","29");
                        click();
                        break;
                    case "411":
                        selection("room","30");
                        click();
                        break;
                    case "412":
                        selection("room","31");
                        click();
                        break;
                    case "409":
                        selection("room","32");
                        click();
                        break;
                    case "209 VPMF":
                        selection("room","33");
                        click();
                        break;
                    case "210 VPMF":
                        selection("room","34");
                        click();
                        break;
                    case "216  (Jaunystės g. 2)":
                        selection("room","35");
                        click();
                        break;
                    case "Debreceno g. 25":
                        selection("room","36");
                        click();
                        break;
                    case "204":
                        selection("room","37");
                        click();
                        break;
                    case "Biblioteka":
                        selection("room","38");
                        click();
                        break;
                    case "417 (Jaunystės g. 2)":
                        selection("room","39");
                        click();
                        break;
                    case "9.30 val.- Dariaus ir Girėno g. 8-  a. 26":
                        selection("room","40");
                        click();
                        break;
                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/classrooms.php");
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuditorijosSMF.this,SMFMenu.class);
                startActivity(intent);
            }
        });


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
    }
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smf_audotorijos,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                startActivity(new Intent(this,Fakultetai.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
