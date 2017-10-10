package com.example.meskius.attemp2;
import android.content.Intent;

import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    TextView text;
    DoIt data;
    WebView ww;
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
        Button but=(Button)findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DoIt().execute();

            }

        });
        final Spinner program=(Spinner)findViewById(R.id.spinner);
        Button myg1 =(Button)findViewById(R.id.programData);
        myg1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String test = text.getText().toString();
                String[] programData = new String[2];
                programData=test.split("\n",3);
                Log.i("Duck",programData[0]);
                spinner(programData,program);
            }
        });
        ww= (WebView)findViewById(R.id.webView);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.setWebChromeClient(new WebChromeClient());
        //myWebView.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/groups.php");
        ww.setWebViewClient(new WebViewClient());
        ww.

     /*   class JsObject {
            @JavascriptInterface
            public String toString() { return "injectedObject"; }
        }
        ww.addJavascriptInterface(new JsObject(), "injectedObject");
        ww.loadData("", "text/html", null);
        ww.loadUrl("javascript:alert('ssd')");*/
    }




    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
    public class DoIt extends AsyncTask<Void,Void,Void>{
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



}
