package com.example.meskius.attemp2;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


public class GrupesTF extends AppCompatActivity {
    TextView text;
    WebView ww;
   // <-------------------------
    String programSpinnerText;
    String yearSpinnerText;
    String programTipas[] = {"--pasirinkti--", "IŠT","NL"};
    String yearMetaiNL[] = {"--pasirinkti--", "1","2","3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1","2","3","4"};
    String groupGrupeNL1[] = {"--pasirinkti--", "AT 39-1", "AT 39-1, 2 p. ", "AT 39-1, 3 p. ", "AT 39-1,1 p. ", "EA 32-1", "EA 32-1, 1 p.", "EA 32-1, 2 p.", "G 21-1", "I 13-1", "I 13-1, 1 p.", "I 13-1, 2 p.", "IN 2-1", "MCH 18-1", "MT 15-1", "MT 15-1, 1 p.", "MT 15-1, 2 p.", "S 38-1", "S 38-1, 1 p.", "S 38-1, 2 p.", "TL 15-1"};
    String groupGrupeNL2[] = {"--pasirinkti--", "ATE 37-2", "ATE 37-2, 1 p.", "ATE 37-2, 2 p.", "EA 30-2", "EA 30-2, 1 p.", "EA 30-2, 2 p.", "G 20-2", "I 12-2", "IN 1-2", "MCH 16-2", "MT 13-2", "MT 13-2, 1 p.", "MT 13-2, 2 p.", "S 36-2", "S 36-2, 1 p.", "S 36-2, 2 p.", "T 13-2"};
    String groupGrupeNL3[] = {"--pasirinkti--", "ATE 35-3", "ATE 35-3, 1 p.", "ATE 35-3, 2 p.", "EA 28-3", "EA 28-3, 1 p.", "EA 28-3, 2 p.", "G 19-3", "I 11-3", "KD 8-3", "MCH 14-3", "MT 11-3", "MT 11-3, 1 p.", "MT 11-3, 2 p.", "S 34-3", "S 34-3, 1 p.", "S 34-3, 2 p.", "T 11-3"};
    String groupGrupeIST1[] = {"--pasirinkti--", "AT i 40-1", "EA i 33-1", "EA i 33-1, 1 p.", "EA i 33-1, 2 p.", "IN i 3-1", "MCH i 19-1", "MT i 16-1", "MT i 16-1, 1 p.", "MT i 16-1, 2 p.", "S i 39-1", "S i 39-1, 1 p.", "S i 39-1, 2 p.", "S i 39-1, 3 p.", "TL i 16-1"};
    String groupGrupeIST2[] = {"--pasirinkti--", "ATE i 38-2", "EA i 31-2", "MCH i 17-2", "MT i 14-2", "S i 37-2", "T i 14-2"};
    String groupGrupeIST3[] = {"--pasirinkti--", "ATE i 36-3", "EA i 29-3", "GRV - 3", "MCH i 15-3", "MT i 12-3", "S i 35-3", "T i 12-3"};
    String groupGrupeIST4[] = {"--pasirinkti--", "ATE i 34-4", "EA i 27-4", "MCH i 13-4", "MT i 10-4", "MT i 10-4, 1 p.", "MT i 10-4, 2 p.", "S i 33-4", "T i 10-4"};

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grupes_tf);
        text=(TextView)findViewById(R.id.text);
        Intent intent= getIntent();
        final Spinner programID=(Spinner)findViewById(R.id.program);
        final Spinner metaiID = (Spinner)findViewById(R.id.year);
        final Spinner grupeID = (Spinner)findViewById(R.id.group);
        final TextView grupe = (TextView)findViewById(R.id.group_text);
        final TextView metai =(TextView) findViewById(R.id.year_text);
        //<------------------------- Deklaruojamas Hashmap
        final HashMap<String,String> grupesHashmap = new  HashMap<>();
        String[] grupes_str = getResources().getStringArray(R.array.grupes_TF_str);
        String[] grupes_values = getResources().getStringArray(R.array.grupes_TF_value);
        //Log.e("Duck",""+grupes_values.length+" "+ grupes_str.length );
        for(int i = 0;i<grupes_str.length; i++)
           // Log.i("Duck",grupes_str[i]+" "+grupes_values[i]);
            grupesHashmap.put(grupes_str[i], grupes_values[i]);
        //<-------------------------

        metaiID.setVisibility(View.GONE);
        grupeID.setVisibility(View.GONE);

        metai.setVisibility(View.GONE);

        grupe.setVisibility(View.GONE);
        spinner(programTipas,programID);

        programID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                programSpinnerText = adapterView.getSelectedItem().toString();

                switch (programSpinnerText){
                    case "IŠT":
                        spinner(yearMetaiIST,metaiID);
                        selection("program","2");
                        metai.setVisibility(View.VISIBLE);
                        metaiID.setVisibility(View.VISIBLE);
                        break;
                    case "NL":
                        spinner(yearMetaiNL,metaiID);
                        selection("program","1");
                        metai.setVisibility(View.VISIBLE);
                        metaiID.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        metaiID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                yearSpinnerText = adapterView.getSelectedItem().toString();
                if(programSpinnerText.indexOf("IŠT")!=-1)
                switch (yearSpinnerText){
                    case "1":
                        spinner(groupGrupeIST1,grupeID);
                        selection("year","1");
                        selection("branch","8");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "2":
                        spinner(groupGrupeIST2,grupeID);
                        selection("year","2");
                        selection("branch","5");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "3":
                        spinner(groupGrupeIST3,grupeID);
                        selection("year","3");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "4":
                        spinner(groupGrupeIST4,grupeID);
                        selection("year","4");
                        selection("branch","7");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                    default:
                        break;

                }else switch (yearSpinnerText){
                    case "1":
                        spinner(groupGrupeNL1,grupeID);
                        selection("year","1");
                        selection("branch","1");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "2":
                        spinner(groupGrupeNL2,grupeID);
                        selection("year","2");
                        selection("branch","2");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "3":
                        spinner(groupGrupeNL3,grupeID);
                        selection("year","3");
                        selection("branch","3");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        grupeID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                if (!grupesHashmap.get(spinnerText).equals("duck")){
                    selection("group",""+grupesHashmap.get(spinnerText)+"");
                    ww.setVisibility(View.VISIBLE);
                    click();}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        wwShiet();
    }

    private void wwShiet() {
        ww= (WebView)findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/groups.php");
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
    }

    public void click(){
        // ww.loadUrl("javascript:$(document.querySelector(\"input.inputbutton.special\")).click();");
        ww.loadUrl("javascript:viewWeek();");
    }
    public void hide(){
        //ww.loadUrl("javascript:$(document.querySelector(\"#data_form\")).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[0]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[1]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[2]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[3]).hide()");

        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr td\")[8]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr button\")[0]).hide()");


        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[5]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[6]).hide()");

        ww.loadUrl("javascript:$(document.querySelector(\".main_menu\")).hide()");

        ww.loadUrl("javascript:$(document.querySelector(\"#customMessage\")).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\"#adminError\")).hide()");
        ww.loadUrl("javascript:$(\"html\").css(\"margin-top\", 0);");
        ww.loadUrl("javascript:document.body.style.marginTop=-10");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[4]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[3]).hide()");
    }
    public void selection( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tf_grupes,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
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