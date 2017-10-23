package com.example.meskius.attemp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

public class AuditorijosTF extends AppCompatActivity{
    GrupesTF main;
    WebView ww;

    String auditorijosText[] ={"--pasirinkti--","101","102","103-komp.","104","105","106","120 Konferencijų salė","129- komp.","130-komp.","131-komp.","132-komp.","133-Statybos lab.","134-lab.","135-lab.","136-lab.","137-chem.lab.","139 auditorija","140 auditorija","141 auditorija","203 auditorija","204 auditorija","206 auditorija","208","212 salė","210","214","215","216 auditorija","219-komp.","220-komp.","223--IT","226-komp.","227-lab.","228 ","231","232-komp.","233- komp.","234-GIS","235","237-komp.","238 auditorija","304","305","306","308 auditorija","309","310","311","313","315","318","319","320","322","323","324","325","326","328","329","330","331","332","333-334 VPMF","335","401 auditorija","Klaipėdos laivų remonto ir statybos mokykla, Statybininkų pr. 39","002","KU, JTF, 216 a.","115","336"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auditorijos_main);

        Intent intent= getIntent();
        ww= (WebView)findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/classrooms.php");
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

        Button back = (Button)findViewById(R.id.back);
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
                    case "--pasirinkti--":
                        selection("room","");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "101":
                        selection("room","1");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "102":
                        selection("room","2");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "103-komp.":
                        selection("room","3");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "104":
                        selection("room","4");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "105":
                        selection("room","5");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "106":
                        selection("room","6");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "120 Konferencijų salė":
                        selection("room","7");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "129- komp.":
                        selection("room","8");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "130-komp.":
                        selection("room","9");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "131-komp.":
                        selection("room","10");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "132-komp.":
                        selection("room","11");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "133-Statybos lab.":
                        selection("room","12");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "134-lab.":
                        selection("room","13");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "135-lab.":
                        selection("room","14");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "136-lab.":
                        selection("room","15");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "137-chem.lab.":
                        selection("room","16");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "139 auditorija":
                        selection("room","17");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "140 auditorija":
                        selection("room","18");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "141 auditorija":
                        selection("room","19");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "203 auditorija":
                        selection("room","20");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "204 auditorija":
                        selection("room","21");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "206 auditorija":
                        selection("room","22");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "208":
                        selection("room","23");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "212 salė":
                        selection("room","24");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "210":
                        selection("room","25");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "214":
                        selection("room","26");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "215":
                        selection("room","27");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "216 auditorija":
                        selection("room","28");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "219-komp.":
                        selection("room","29");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "220-komp.":
                        selection("room","30");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "223--IT":
                        selection("room","31");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "226-komp.":
                        selection("room","32");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "227-lab.":
                        selection("room","33");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "228 ":
                        selection("room","34");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "231":
                        selection("room","35");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "232-komp.":
                        selection("room","36");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "233- komp.":
                        selection("room","37");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "234-GIS":
                        selection("room","38");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "235":
                        selection("room","39");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "237-komp.":
                        selection("room","40");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "238 auditorija":
                        selection("room","41");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "304":
                        selection("room","42");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "305":
                        selection("room","43");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "306":
                        selection("room","44");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "308 auditorija":
                        selection("room","45");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "309":
                        selection("room","46");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "310":
                        selection("room","47");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "311":
                        selection("room","48");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "313":
                        selection("room","49");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "315":
                        selection("room","50");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "318":
                        selection("room","51");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "319":
                        selection("room","52");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "320":
                        selection("room","53");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "322":
                        selection("room","54");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "323":
                        selection("room","55");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "324":
                        selection("room","56");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "325":
                        selection("room","57");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "326":
                        selection("room","58");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "328":
                        selection("room","59");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "329":
                        selection("room","60");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "330":
                        selection("room","61");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "331":
                        selection("room","62");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "332":
                        selection("room","63");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "333-334 VPMF":
                        selection("room","64");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "335":
                        selection("room","65");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "401 auditorija":
                        selection("room","66");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "Klaipėdos laivų remonto ir statybos mokykla, Statybininkų pr. 39":
                        selection("room","68");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "002":
                        selection("room","69");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "KU, JTF, 216 a.":
                        selection("room","70");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "115":
                        selection("room","75");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
                        break;
                    case "336":
                        selection("room","76");
                        ww.loadUrl("javascript:$(document.querySelector(\".glyphicon.glyphicon-search\")).click()");
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
                Intent intent = new Intent(AuditorijosTF.this,TFMenu.class);
                startActivity(intent);
            }
        });


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
}
