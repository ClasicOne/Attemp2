package com.example.meskius.attemp2;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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


public class GrupesTF extends AppCompatActivity {
    TextView text;
    WebView ww;


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
        final Spinner programID=(Spinner)findViewById(R.id.tipasID);
        final Spinner metaiID = (Spinner)findViewById(R.id.metaiID);
        final Spinner grupeID = (Spinner)findViewById(R.id.grupeID);
        final Button savaite = (Button)findViewById(R.id.savaitinis);
        final Button atgal = (Button)findViewById(R.id.backGTF);

        savaite.setVisibility(View.GONE);
        metaiID.setVisibility(View.GONE);
        grupeID.setVisibility(View.GONE);


        final TextView metai =(TextView) findViewById(R.id.year);
        metai.setVisibility(View.GONE);

        final TextView grupe = (TextView)findViewById(R.id.group);
        grupe.setVisibility(View.GONE);

        Button refresh = (Button)findViewById(R.id.refresh);
        spinner(programTipas,programID);
        atgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GrupesTF.this,TFMenu.class);
                startActivity(intent);
            }
        });
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
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/groups.php");
            }
        });
        grupeID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                savaite.setVisibility(View.VISIBLE);

                switch (spinnerText){
                    // NL 1
                    case "TL 15-1":
                        selection("group","1");

                        break;
                    case "S 38-1, 2 p.":
                        selection("group","2");
                        break;
                    case "S 38-1, 1 p.":
                        selection("group","3");
                        break;
                    case "S 38-1":
                        selection("group","4");
                        break;
                    case "MT 15-1, 2 p.":
                        selection("group","5");
                        break;
                    case "MT 15-1, 1 p.":
                        selection("group","6");
                        break;
                    case "MT 15-1":
                        selection("group","7");
                        break;
                    case "MCH 18-1":
                        selection("group","8");
                        break;
                    case "IN 2-1":
                        selection("group","9");
                        break;
                    case "I 13-1, 2 p.":
                        selection("group","10");
                        break;
                    case "I 13-1, 1 p.":
                        selection("group","11");
                        break;
                    case "I 13-1":
                        selection("group","12");
                        break;
                    case "G 21-1":
                        selection("group","13");
                        break;
                    case "EA 32-1, 2 p.":
                        selection("group","14");
                        break;
                    case "EA 32-1, 1 p.":
                        selection("group","15");
                        break;
                    case "EA 32-1":
                        selection("group","16");
                        break;
                    case "AT 39-1,1 p. ":
                        selection("group","17");
                        break;
                    case "AT 39-1, 3 p. ":
                        selection("group","18");
                        break;
                    case "AT 39-1, 2 p. ":
                        selection("group","19");
                        break;
                    case "AT 39-1":
                        selection("group","20");
                        break;
                    //NL 3
                    case "ATE 35-3":
                        selection("group", "53");
                        break;
                    case "ATE 35-3, 1 p.":
                        selection("group", "90");
                        break;
                    case "ATE 35-3, 2 p.":
                        selection("group", "89");
                        break;
                    case "EA 28-3":
                        selection("group", "52");
                        break;
                    case "EA 28-3, 1 p.":
                        selection("group", "92");
                        break;
                    case "EA 28-3, 2 p.":
                        selection("group", "91");
                        break;
                    case "G 19-3":
                        selection("group", "90");
                        break;
                    case "I 11-3":
                        selection("group", "50");
                        break;
                    case "KD 8-3":
                        selection("group", "49");
                        break;
                    case "MCH 14-3":
                        selection("group", "48");
                        break;
                    case "MT 11-3":
                        selection("group", "47");
                        break;
                    case "MT 11-3, 1 p.":
                        selection("group", "46");
                        break;
                    case "MT 11-3, 2 p.":
                        selection("group", "45");
                        break;
                    case "S 34-3":
                        selection("group", "56");
                        break;
                    case "S 34-3, 1 p.":
                        selection("group", "55");
                        break;
                    case "S 34-3, 2 p.":
                        selection("group", "54");
                        break;
                    case "T 11-3":
                        selection("group", "44");
                        break;
                    // IST 1
                    case "AT i 40-1":
                        selection("group", "63");
                        break;
                    case "EA i 33-1":
                        selection("group", "62");
                        break;
                    case "EA i 33-1, 1 p.":
                        selection("group", "61");
                        break;
                    case "EA i 33-1, 2 p.":
                        selection("group", "60");
                        break;
                    case "IN i 3-1":
                        selection("group", "58");
                        break;
                    case "MCH i 19-1":
                        selection("group", "59");
                        break;
                    case "MT i 16-1":
                        selection("group", "57");
                        break;
                    case "MT i 16-1, 1 p.":
                        selection("group", "93");
                        break;
                    case "MT i 16-1, 2 p.":
                        selection("group", "94");
                        break;
                    case "S i 39-1":
                        selection("group", "66");
                        break;
                    case "S i 39-1, 1 p.":
                        selection("group", "65");
                        break;
                    case "S i 39-1, 2 p.":
                        selection("group", "64");
                        break;
                    case "S i 39-1, 3 p.":
                        selection("group", "95");
                        break;
                    case "TL i 16-1":
                        selection("group", "67");
                        break;
                    // NL 2
                    case "ATE 37-2":
                        selection("group", "42");
                        break;
                    case "ATE 37-2, 1 p.":
                        selection("group", "41");
                        break;
                    case "ATE 37-2, 2 p.":
                        selection("group", "40");
                        break;
                    case "EA 30-2":
                        selection("group", "39");
                        break;
                    case "EA 30-2, 1 p.":
                        selection("group", "38");
                        break;
                    case "EA 30-2, 2 p.":
                        selection("group", "37");
                        break;
                    case "G 20-2":
                        selection("group", "36");
                        break;
                    case "I 12-2":
                        selection("group", "35");
                        break;
                    case "IN 1-2":
                        selection("group", "34");
                        break;
                    case "MCH 16-2":
                        selection("group", "33");
                        break;
                    case "MT 13-2":
                        selection("group", "32");
                        break;
                    case "MT 13-2, 1 p.":
                        selection("group", "31");
                        break;
                    case "MT 13-2, 2 p.":
                        selection("group", "30");
                        break;
                    case "S 36-2":
                        selection("group", "29");
                        break;
                    case "S 36-2, 1 p.":
                        selection("group", "28");
                        break;
                    case "S 36-2, 2 p.":
                        selection("group", "27");
                        break;
                    case "T 13-2":
                        selection("group", "26");
                        break;
                    // IST 2
                    case "ATE i 38-2":
                        selection("group", "73");
                        break;
                    case "EA i 31-2":
                        selection("group", "72");
                        break;
                    case "MCH i 17-2":
                        selection("group", "71");
                        break;
                    case "MT i 14-2":
                        selection("group", "70");
                        break;
                    case "S i 37-2":
                        selection("group", "69");
                        break;
                    case "T i 14-2":
                        selection("group", "68");
                        break;
                    // IST 3
                    case "ATE i 36-3":
                        selection("group", "80");
                        break;
                    case "EA i 29-3":
                        selection("group", "79");
                        break;
                    case "GRV - 3":
                        selection("group", "74");
                        break;
                    case "MCH i 15-3":
                        selection("group", "78");
                        break;
                    case "MT i 12-3":
                        selection("group", "77");
                        break;
                    case "S i 35-3":
                        selection("group", "76");
                        break;
                    case "T i 12-3":
                        selection("group", "75");
                        break;
                    // IST 4
                    case "ATE i 34-4":
                        selection("group", "86");
                        break;
                    case "EA i 27-4":
                        selection("group", "85");
                        break;
                    case "MCH i 13-4":
                        selection("group", "84");
                        break;
                    case "MT i 10-4":
                        selection("group", "83");
                        break;
                    case "MT i 10-4, 1 p.":
                        selection("group", "88");
                        break;
                    case "MT i 10-4, 2 p.":
                        selection("group", "87");
                        break;
                    case "S i 33-4":
                        selection("group", "82");
                        break;
                    case "T i 10-4":
                        selection("group", "81");
                        break;



                    default:
                        Log.i("Duck","error");
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        savaite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ww.loadUrl("javascript:viewWeek();");
                //ww.loadUrl("javascript:$(document.querySelector('.tdColor .inputButton').click();");
            }
        });
        ww= (WebView)findViewById(R.id.webView);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/groups.php");
        grupeID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                savaite.setVisibility(View.VISIBLE);

                switch (spinnerText){
                    // NL 1
                    case "TL 15-1":
                        selection("group","1");
                        click();

                        break;
                    case "S 38-1, 2 p.":
                        selection("group","2");
                        click();
                        break;
                    case "S 38-1, 1 p.":
                        selection("group","3");
                        click();
                        break;
                    case "S 38-1":
                        selection("group","4");
                        click();
                        break;
                    case "MT 15-1, 2 p.":
                        selection("group","5");
                        click();
                        break;
                    case "MT 15-1, 1 p.":
                        selection("group","6");
                        click();
                        break;
                    case "MT 15-1":
                        selection("group","7");
                        click();
                        break;
                    case "MCH 18-1":
                        selection("group","8");
                        click();
                        break;
                    case "IN 2-1":
                        selection("group","9");
                        click();
                        break;
                    case "I 13-1, 2 p.":
                        selection("group","10");
                        click();
                        break;
                    case "I 13-1, 1 p.":
                        selection("group","11");
                        click();
                        break;
                    case "I 13-1":
                        selection("group","12");
                        click();
                        break;
                    case "G 21-1":
                        selection("group","13");
                        click();
                        break;
                    case "EA 32-1, 2 p.":
                        selection("group","14");
                        click();
                        break;
                    case "EA 32-1, 1 p.":
                        selection("group","15");
                        click();
                        break;
                    case "EA 32-1":
                        selection("group","16");
                        click();
                        break;
                    case "AT 39-1,1 p. ":
                        selection("group","17");
                        click();
                        break;
                    case "AT 39-1, 3 p. ":
                        selection("group","18");
                        click();
                        break;
                    case "AT 39-1, 2 p. ":
                        selection("group","19");
                        click();
                        break;
                    case "AT 39-1":
                        selection("group","20");
                        click();
                        break;
                    //NL 3
                    case "ATE 35-3":
                        selection("group", "53");
                        click();
                        break;
                    case "ATE 35-3, 1 p.":
                        selection("group", "90");
                        click();
                        break;
                    case "ATE 35-3, 2 p.":
                        selection("group", "89");
                        click();
                        break;
                    case "EA 28-3":
                        selection("group", "52");
                        click();
                        break;
                    case "EA 28-3, 1 p.":
                        selection("group", "92");
                        click();
                        break;
                    case "EA 28-3, 2 p.":
                        selection("group", "91");
                        click();
                        break;
                    case "G 19-3":
                        selection("group", "90");
                        click();
                        break;
                    case "I 11-3":
                        selection("group", "50");
                        click();
                        break;
                    case "KD 8-3":
                        selection("group", "49");
                        click();
                        break;
                    case "MCH 14-3":
                        selection("group", "48");
                        click();
                        break;
                    case "MT 11-3":
                        selection("group", "47");
                        click();
                        break;
                    case "MT 11-3, 1 p.":
                        selection("group", "46");
                        click();
                        break;
                    case "MT 11-3, 2 p.":
                        selection("group", "45");
                        click();
                        break;
                    case "S 34-3":
                        selection("group", "56");
                        click();
                        break;
                    case "S 34-3, 1 p.":
                        selection("group", "55");
                        click();
                        break;
                    case "S 34-3, 2 p.":
                        selection("group", "54");
                        click();
                        break;
                    case "T 11-3":
                        selection("group", "44");
                        click();
                        break;
                    // IST 1
                    case "AT i 40-1":
                        selection("group", "63");
                        click();
                        break;
                    case "EA i 33-1":
                        selection("group", "62");
                        click();
                        break;
                    case "EA i 33-1, 1 p.":
                        selection("group", "61");
                        click();
                        break;
                    case "EA i 33-1, 2 p.":
                        selection("group", "60");
                        click();
                        break;
                    case "IN i 3-1":
                        selection("group", "58");
                        click();
                        break;
                    case "MCH i 19-1":
                        selection("group", "59");
                        click();
                        break;
                    case "MT i 16-1":
                        selection("group", "57");
                        click();
                        break;
                    case "MT i 16-1, 1 p.":
                        selection("group", "93");
                        click();
                        break;
                    case "MT i 16-1, 2 p.":
                        selection("group", "94");
                        click();
                        break;
                    case "S i 39-1":
                        selection("group", "66");
                        click();
                        break;
                    case "S i 39-1, 1 p.":
                        selection("group", "65");
                        click();
                        break;
                    case "S i 39-1, 2 p.":
                        selection("group", "64");
                        click();
                        break;
                    case "S i 39-1, 3 p.":
                        selection("group", "95");
                        click();
                        break;
                    case "TL i 16-1":
                        selection("group", "67");
                        click();
                        break;
                    // NL 2
                    case "ATE 37-2":
                        selection("group", "42");
                        click();
                        break;
                    case "ATE 37-2, 1 p.":
                        selection("group", "41");
                        click();
                        break;
                    case "ATE 37-2, 2 p.":
                        selection("group", "40");
                        click();
                        break;
                    case "EA 30-2":
                        selection("group", "39");
                        click();
                        break;
                    case "EA 30-2, 1 p.":
                        selection("group", "38");
                        click();
                        break;
                    case "EA 30-2, 2 p.":
                        selection("group", "37");
                        click();
                        break;
                    case "G 20-2":
                        selection("group", "36");
                        click();
                        break;
                    case "I 12-2":
                        selection("group", "35");
                        click();
                        break;
                    case "IN 1-2":
                        selection("group", "34");
                        click();
                        break;
                    case "MCH 16-2":
                        selection("group", "33");
                        click();
                        break;
                    case "MT 13-2":
                        selection("group", "32");
                        click();
                        break;
                    case "MT 13-2, 1 p.":
                        selection("group", "31");
                        click();
                        break;
                    case "MT 13-2, 2 p.":
                        selection("group", "30");
                        click();
                        break;
                    case "S 36-2":
                        selection("group", "29");
                        click();
                        break;
                    case "S 36-2, 1 p.":
                        selection("group", "28");
                        click();
                        break;
                    case "S 36-2, 2 p.":
                        selection("group", "27");
                        click();
                        break;
                    case "T 13-2":
                        selection("group", "26");
                        click();
                        break;
                    // IST 2
                    case "ATE i 38-2":
                        selection("group", "73");
                        click();
                        break;
                    case "EA i 31-2":
                        selection("group", "72");
                        click();
                        break;
                    case "MCH i 17-2":
                        selection("group", "71");
                        click();
                        break;
                    case "MT i 14-2":
                        selection("group", "70");
                        click();
                        break;
                    case "S i 37-2":
                        selection("group", "69");
                        click();
                        break;
                    case "T i 14-2":
                        selection("group", "68");
                        click();
                        break;
                    // IST 3
                    case "ATE i 36-3":
                        selection("group", "80");
                        click();
                        break;
                    case "EA i 29-3":
                        selection("group", "79");
                        click();
                        break;
                    case "GRV - 3":
                        selection("group", "74");
                        click();
                        break;
                    case "MCH i 15-3":
                        selection("group", "78");
                        click();
                        break;
                    case "MT i 12-3":
                        selection("group", "77");
                        click();
                        break;
                    case "S i 35-3":
                        selection("group", "76");
                        click();
                        break;
                    case "T i 12-3":
                        selection("group", "75");
                        click();
                        break;
                    // IST 4
                    case "ATE i 34-4":
                        selection("group", "86");
                        click();
                        break;
                    case "EA i 27-4":
                        selection("group", "85");
                        click();
                        break;
                    case "MCH i 13-4":
                        selection("group", "84");
                        click();
                        break;
                    case "MT i 10-4":
                        selection("group", "83");
                        click();
                        break;
                    case "MT i 10-4, 1 p.":
                        selection("group", "88");
                        click();
                        break;
                    case "MT i 10-4, 2 p.":
                        selection("group", "87");
                        click();
                        break;
                    case "S i 33-4":
                        selection("group", "82");
                        click();
                        break;
                    case "T i 10-4":
                        selection("group", "81");
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
    }
    public void selection( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
}