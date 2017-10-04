package com.example.meskius.attemp2;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView text;

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
    }
    public class DoIt extends AsyncTask<Void,Void,Void>{
    String words;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document d = Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/groups.php").get();
                Elements el=d.select("#program");

                for(Element step : el){
                    String method = step.select("option").html();
                    words = method;
                }

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
