package com.example.meskius.attemp2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    TextView text;
    //DoIt data;
    //
    WebView ww;
    String programSpinnerText;
    //String programaDuomenys[] = new String[2];
    String programTipas[] = {"--pasirinkti--", "IŠT","NL"};
    String yearMetaiNL[] = {"--pasirinkti--", "1","2","3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1","2","3","4"};
    String groupGrupeNL1[] = {"--pasirinkti--", "AT 39-1", "AT 39-1, 2 p. ", "AT 39-1, 3 p. ", "AT 39-1,1 p. ", "EA 32-1", "EA 32-1, 1 p.", "EA 32-1, 2 p.", "G 21-1", "I 13-1", "I 13-1, 1 p.", "I 13-1, 2 p.", "IN 2-1", "MCH 18-1", "MT 15-1", "MT 15-1, 1 p.", "MT 15-1, 2 p.", "S 38-1", "S 38-1, 1 p.", "S 38-1, 2 p.", "TL 15-1"};
    String groupGrupeNL2[] = {"--pasirinkti--", "ATE 37-2", "ATE 37-2, 1 p.", "ATE 37-2, 2 p.", "EA 30-2", "EA 30-2, 1 p.", "EA 30-2, 2 p.", "G 20-2", "I 12-2", "IN 1-2", "MCH 16-2", "MT 13-2", "MT 13-2, 1 p.", "MT 13-2, 2 p.", "S 36-2", "S 36-2, 1 p.", "S 36-2, 2 p.", "T 13-2"};
    String groupGrupeNL3[] = {"--pasirinkti--", "ATE 35-3", "ATE 35-3, 1 p.", "ATE 35-3, 2 p.", "EA 28-3", "EA 28-3, 1 p.", "EA 28-3, 2 p.", "G 19-3", "I 11-3", "KD 8-3", "MCH 14-3", "MT 11-3", "MT 11-3, 1 p.", "MT 11-3, 2 p.", "S 34-3", "S 34-3, 1 p.", "S 34-3, 2 p.", "T 11-3"};
    String groupGrupeIST1[] = {"--pasirinkti--", "AT i 40-1", "EA i 33-1", "EA i 33-1, 1 p.", "EA i 33-1, 2 p.", "IN i 3-1", "MCH i 19-1", "MT i 16-1", "MT i 16-1, 1 p.", "MT i 16-1, 2 p.", "S i 39-1", "S i 39-1, 1 p.", "S i 39-1, 2 p.", "S i 39-1, 3 p.", "TL i 16-1"};
    String groupGrupeIST2[] = {"--pasirinkti--", "ATE i 38-", "EA i 31-", "MCH i 17-", "MT i 14-", "S i 37-", "T i 14-"};
    String groupGrupeIST3[] = {"--pasirinkti--", "ATE i 36-3", "EA i 29-3", "GRV - 3", "MCH i 15-3", "MT i 12-3", "S i 35-3", "T i 12-3"};
    String groupGrupeIST4[] = {"--pasirinkti--", "ATE i 34-4", "EA i 27-4", "MCH i 13-4", "MT i 10-4", "MT i 10-4, 1 p.", "MT i 10-4, 2 p.", "S i 33-4", "T i 10-4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
       /*/*//*//* Button but=(Button)findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DoIt().execute();

            }

        });*/
        final Spinner programID=(Spinner)findViewById(R.id.tipasID);
        final Spinner metaiID = (Spinner)findViewById(R.id.metaiID);
        final Spinner grupeID = (Spinner)findViewById(R.id.grupeID);
        final Button brachID = (Button)findViewById(R.id.branchID);
        final Button savaite = (Button)findViewById(R.id.savaitinis);

        //Button myg1 =(Button)findViewById(R.id.programData);
        spinner(programTipas,programID);
        programID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                programSpinnerText = adapterView.getSelectedItem().toString();

                switch (programSpinnerText){
                    case "IŠT":
                        spinner(yearMetaiIST,metaiID);
                        selection("program","2");
                        break;
                    case "NL":
                        spinner(yearMetaiNL,metaiID);
                        selection("program","1");
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
                String spinnerText = adapterView.getSelectedItem().toString();
                if(programSpinnerText.indexOf("IŠT")!=-1)
                switch (spinnerText){
                    case "1":
                        spinner(groupGrupeIST1,grupeID);
                        selection("year","1");
                        break;
                    case "2":
                        spinner(groupGrupeIST2,grupeID);
                        selection("year","2");
                        break;
                    case "3":
                        spinner(groupGrupeIST3,grupeID);
                        selection("year","3");
                        break;
                    case "4":
                        spinner(groupGrupeIST4,grupeID);
                        selection("year","4");
                    default:
                        break;

                }else switch (spinnerText){
                    case "1":
                        spinner(groupGrupeNL1,grupeID);
                        selection("year","1");
                        break;
                    case "2":
                        spinner(groupGrupeNL2,grupeID);
                        selection("year","2");
                        break;
                    case "3":
                        spinner(groupGrupeNL3,grupeID);
                        selection("year","3");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        brachID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selection("branch","1");
            }
        });
        grupeID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
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
        /*myg1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String test = text.getText().toString();
                String[] programData = new String[2];
                programData=test.split("\n",3);
                Log.i("Duck",programData[0]);
                spinner(programData,programID);
            }
        });*/
        savaite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ww.loadUrl("javascript:viewWeek();");
            }
        });
        ww= (WebView)findViewById(R.id.webView);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.setWebChromeClient(new WebChromeClient());
        //myWebView.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/groups.php");
        //ww.loadUrl("http://google.com");
        ww.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hide();
               // String tekstas ="Puslapis baiges krautis";
                //ww.loadUrl("javascript:changeHappened('program',2)");
                //Toast.makeText(this,tekstas,Toast.LENGTH_SHORT).show();

            }
        });


        //changeHappen("program",2);


     /* //  class JsObject

      {
            @JavascriptInterface
            public String toString() { return "injectedObject"; }
        }
        ww.addJavascriptInterface(new JsObject(), "injectedObject");
        ww.loadData("", "text/html", null);
        ww.loadUrl("javascript:alert('ssd')");*/
    }
    public void hide(){
        ww.loadUrl("javascript:$(document.querySelector(\"#data_form\")).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\".main_menu\")).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\"#customMessage\")).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\"#adminError\")).hide()");

    }
    public void selection( String pasirinkimas, String val) {

        // ww.loadUrl("javascript:changeHappened('program',2)");
        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }



    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
   /* public class DoIt extends AsyncTask<Void,Void,Void>{
        String words;

        MainActivity main;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document d = Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/groups.php").get();
                Elements el=d.select("#program");
                String programa;
                String method = null;
                for(Element step : el){

                    method = step.select("option").html();
                    words=method;
                }
                programa = method;


                //main.temp(programData);

                // Iterpia informacija i spiineri

                //spinner(programData,metai);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            text.setText(words);
        }
    }

*/

}
