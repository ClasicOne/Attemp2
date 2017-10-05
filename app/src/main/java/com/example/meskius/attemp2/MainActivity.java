package com.example.meskius.attemp2;
import android.content.Intent;

import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

                // iskaido tipa


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
