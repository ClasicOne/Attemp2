package com.example.meskius.attemp2;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
                String programa;
                String method = null;
                Spinner program = (Spinner)findViewById(R.id.program);
                Spinner metai = (Spinner)findViewById(R.id.year);
                Spinner grupe = (Spinner)findViewById(R.id.group);
                for(Element step : el){

                    method = step.select("option").html();
                    words=method;


                }

                programa = method;
                String[] programData = new String[2];
                programData= programa.split("\n",3);
                String test[] = {"guck","asd"};
                List<String> list = new ArrayList<String>();
                list.add("one");
                list.add("two");
                list.add("three");
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                program.setAdapter(adapter);




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
