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

public class AuditorijosSVMF extends AppCompatActivity{

    WebView ww;

    String auditorijosText[] = {"--pasirinkti--","Dariaus ir Girėno 8, 34a. ","Dariaus ir Girėno 8, 36","Dariaus ir Girėno g. 8, 10a. ","Dariaus ir Girėno g. 8, 11a. ","Dariaus ir Girėno g. 8, 19a. ","Dariaus ir Girėno g. 8, 23a. ","Dariaus ir Girėno g. 8, 24a. ","Dariaus ir Girėno g. 8, 29 a.","Gulbių g. 8, salė","Gulbių g.8, 1a. (masažas)","Gulbių g. 8, 2a. (fizioterapija)","Dariaus ir Girėno 8, 12a. ","Dariaus ir Girėno g. 8, 13a. ","Dariaus ir Girėno 8, 14a. ","Dariaus ir Girėno 8, 17a. ","Donelaičio 10, 2a. ","Donelaičio g. 10, 3a. ","Donelaičio 10, 4a. ","Donelaičio g. 10, 11a. ","Donelaičio g. 10, 12a. ","Donelaičio g. 10, 13a. ","Donelaičio g. 10, 16a. ","Donelaičio g. 10, 19a. ","Donelaičio g. 10, 21a. (vaiko slauga)","Dariaus ir Girėno g. 8, 3a. (foto studija)","Dariaus ir Girėno g. 8, 4a. (kūno priežiūros)","Dariaus ir Girėno g. 8, 4A a. (veido priežiūros)","Dariaus ir Girėno g. 8, 6a. ","Gulbių g. 8, veido priežiūros laboratorija","Gulbių g. 8, manikiūro ir pedikiūro laboratorija","Gulbių g. 8, spa procedūros","Gulbių g. 8, spa procedūros (vychy)","Klaipėdos sutrikusio vystymosi kūdikių namai, Turistų g. 18","Taikos g. 76, Klaipėdos m. socialinės paramos centras","Naujakiemio g. 26, odontologijos klinika 'Lela'","Dariaus ir Girėno 8, 26a. ","Dariaus ir Girėno 8, 27a. ","Klaipėdos universitetinė ligoninė, infekcinių ligų departamentas","Dariaus ir Girėno 8, 28a. ","BĮŠVGC, Turgaus g. 22","Klaipėdos jūrininkų ligoninė, reabilitacijos skyrius","Klaipėdos universitetinė ligoninė, akušerijos departamentas","Palangos reabilitacinė ligoninė ","Jaunystės g. 2, 317 a.","Jaunystės g.2, 309a. ","Jaunystės g. 2, 314 ","Jaunystės g. 2, 316 a.","Jaunystės g. 2, 313a. ","Jaunystės g. 2, salė","Klaipėdos respublikinė ligoninė","Maisto chemijos laboratorija 137","TF (Bijūnų g. 10)  212 aud.","Jaunystės 2, 417 a. (informacinių technologijų)","Greitosios pagalbos stotis ","Delfinų terapijos centras ","Gulbių g.8, Bendrosios funkcinės diagnostikos laboratorija ","Jaunystės g. 2, 310 a. ","Jaunystės g. 2,  322 a.","Jaunystės g. 2, 324 a. ","Ikiklinikinių studijų laboratorija, Gulbių g. 8","Klaipėdos universitetinė ligoninė ","Jaunystės g. 2, 310 a."};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auditorijos_svmf);

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
                    case "Dariaus ir Girėno 8, 34a. ":
                        selection("room","2");
                        click();
                        break;
                    case "Dariaus ir Girėno 8, 36":
                        selection("room","1");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 10a. ":
                        selection("room","3");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 11a. ":
                        selection("room","4");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 19a. ":
                        selection("room","5");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 23a. ":
                        selection("room","6");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 24a. ":
                        selection("room","7");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 29 a.":
                        selection("room","8");
                        click();
                        break;
                    case "Gulbių g. 8, salė":
                        selection("room","15");
                        click();
                        break;
                    case "Gulbių g.8, 1a. (masažas)":
                        selection("room","16");
                        click();
                        break;
                    case "Gulbių g. 8, 2a. (fizioterapija)":
                        selection("room","17");
                        click();
                        break;
                    case "Dariaus ir Girėno 8, 12a. ":
                        selection("room","18");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 13a. ":
                        selection("room","19");
                        click();
                        break;
                    case "Dariaus ir Girėno 8, 14a. ":
                        selection("room","20");
                        click();
                        break;
                    case "Dariaus ir Girėno 8, 17a. ":
                        selection("room","21");
                        click();
                        break;
                    case "Donelaičio 10, 2a. ":
                        selection("room","22");
                        click();
                        break;
                    case "Donelaičio g. 10, 3a. ":
                        selection("room","23");
                        click();
                        break;
                    case "Donelaičio 10, 4a. ":
                        selection("room","24");
                        click();
                        break;
                    case "Donelaičio g. 10, 11a. ":
                        selection("room","25");
                        click();
                        break;
                    case "Donelaičio g. 10, 12a. ":
                        selection("room","26");
                        click();
                        break;
                    case "Donelaičio g. 10, 13a. ":
                        selection("room","27");
                        click();
                        break;
                    case "Donelaičio g. 10, 16a. ":
                        selection("room","28");
                        click();
                        break;
                    case "Donelaičio g. 10, 19a. ":
                        selection("room","29");
                        click();
                        break;
                    case "Donelaičio g. 10, 21a. (vaiko slauga)":
                        selection("room","30");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 3a. (foto studija)":
                        selection("room","31");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 4a. (kūno priežiūros)":
                        selection("room","32");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 4A a. (veido priežiūros)":
                        selection("room","33");
                        click();
                        break;
                    case "Dariaus ir Girėno g. 8, 6a. ":
                        selection("room","34");
                        click();
                        break;
                    case "Gulbių g. 8, veido priežiūros laboratorija":
                        selection("room","35");
                        click();
                        break;
                    case "Gulbių g. 8, manikiūro ir pedikiūro laboratorija":
                        selection("room","36");
                        click();
                        break;
                    case "Gulbių g. 8, spa procedūros":
                        selection("room","37");
                        click();
                        break;
                    case "Gulbių g. 8, spa procedūros (vychy)":
                        selection("room","38");
                        click();
                        break;
                    case "Klaipėdos sutrikusio vystymosi kūdikių namai, Turistų g. 18":
                        selection("room","39");
                        click();
                        break;
                    case "Taikos g. 76, Klaipėdos m. socialinės paramos centras":
                        selection("room","41");
                        click();
                        break;
                    case "Naujakiemio g. 26, odontologijos klinika 'Lela'":
                        selection("room","42");
                        click();
                        break;
                    case "Dariaus ir Girėno 8, 26a. ":
                        selection("room","43");
                        click();
                        break;
                    case "Dariaus ir Girėno 8, 27a. ":
                        selection("room","44");
                        click();
                        break;
                    case "Klaipėdos universitetinė ligoninė, infekcinių ligų departamentas":
                        selection("room","45");
                        click();
                        break;
                    case "Dariaus ir Girėno 8, 28a. ":
                        selection("room","46");
                        click();
                        break;
                    case "BĮŠVGC, Turgaus g. 22":
                        selection("room","47");
                        click();
                        break;
                    case "Klaipėdos jūrininkų ligoninė, reabilitacijos skyrius":
                        selection("room","48");
                        click();
                        break;
                    case "Klaipėdos universitetinė ligoninė, akušerijos departamentas":
                        selection("room","49");
                        click();
                        break;
                    case "Palangos reabilitacinė ligoninė ":
                        selection("room","50");
                        click();
                        break;
                    case "Jaunystės g. 2, 317 a.":
                        selection("room","51");
                        click();
                        break;
                    case "Jaunystės g.2, 309a. ":
                        selection("room","52");
                        click();
                        break;
                    case "Jaunystės g. 2, 314 ":
                        selection("room","54");
                        click();
                        break;
                    case "Jaunystės g. 2, 316 a.":
                        selection("room","55");
                        click();
                        break;
                    case "Jaunystės g. 2, 313a. ":
                        selection("room","56");
                        click();
                        break;
                    case "Jaunystės g. 2, salė":
                        selection("room","57");
                        click();
                        break;
                    case "Klaipėdos respublikinė ligoninė":
                        selection("room","58");
                        click();
                        break;
                    case "Maisto chemijos laboratorija 137":
                        selection("room","63");
                        click();
                        break;
                    case "TF (Bijūnų g. 10)  212 aud.":
                        selection("room","64");
                        click();
                        break;
                    case "Jaunystės 2, 417 a. (informacinių technologijų)":
                        selection("room","65");
                        click();
                        break;
                    case "Greitosios pagalbos stotis ":
                        selection("room","66");
                        click();
                        break;
                    case "Delfinų terapijos centras ":
                        selection("room","67");
                        click();
                        break;
                    case "Gulbių g.8, Bendrosios funkcinės diagnostikos laboratorija ":
                        selection("room","68");
                        click();
                        break;
                    case "Jaunystės g. 2, 310 a. ":
                        selection("room","69");
                        click();
                        break;
                    case "Jaunystės g. 2,  322 a.":
                        selection("room","70");
                        click();
                        break;
                    case "Jaunystės g. 2, 324 a. ":
                        selection("room","71");
                        click();
                        break;
                    case "Ikiklinikinių studijų laboratorija, Gulbių g. 8":
                        selection("room","72");
                        click();
                        break;
                    case "Klaipėdos universitetinė ligoninė ":
                        selection("room","73");
                        click();
                        break;
                    case "Jaunystės g. 2, 310 a.":
                        selection("room","74");
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
                Intent intent = new Intent(AuditorijosSVMF.this,SVMFMenu.class);
                startActivity(intent);
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
                ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/classrooms.php");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
