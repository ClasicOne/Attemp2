package lt.kvk.i12_2.tvakarastis;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Meskius on 10/21/2017.
 */

public class DestytojaiTF extends AppCompatActivity {
    WebView ww;
    DBHandler dbHandler;
    String[] value = null;
    String[] prof = null;
    String str = "",valuen = "";
    Set<String> setStr = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destytojai_tf);
        wwShit();
        Intent intent= getIntent();
        final Spinner profID = (Spinner)findViewById(R.id.profID);
        Timer timer = new Timer();











        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }}, (Calendar.getInstance().getTimeInMillis()+1000)-Calendar.getInstance().getTimeInMillis());



        //<---------- Deklaruojamas Hashmap --------
        final HashMap<String,String> grupesHashmap = new  HashMap<>();
        final String[] destytojai_value= getResources().getStringArray(R.array.destytojai_TF_value);
        final String[] destytojai_str = getResources().getStringArray(R.array.destytojai_TF_str);

        for(int i = 0;i<destytojai_str.length; i++)
            grupesHashmap.put(destytojai_str[i], destytojai_value[i]);
        //<-------------------------


        dbHandler = new DBHandler(this, null, null,1);






        spinner(destytojai_str,profID);

        profID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String destytojai = adapterView.getSelectedItem().toString();
                if (!grupesHashmap.get(destytojai).equals("duck")){
                    selection("prof",""+grupesHashmap.get(destytojai)+"");
                    ww.setVisibility(View.VISIBLE);
                    //click();
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                Log.i("Database","dump : "+ str);
                Log.i("Database","dump : "+ valuen);
                Log.i("Database","dump : end");
                Set<String> strSet1 = new HashSet<>(Arrays.asList(destytojai_str));
                if(setStr.containsAll(strSet1)){
                    Log.i("Database","dump : "+ str);
                    Log.i("Database","dump : "+ valuen);
                    Log.i("Database","dump : end");
                }else{
                    // Isvalo db
                    dbHandler.deleteDB();
                    dbHandler.createTable();
                    dbHandler.deleteRow("null");
                    // Ideda Destytojus ir values i db
                    for (int i=0;i<prof.length;i++){
                        dbHandler.addProduct(prof[i].toString(), value[i].toString());
                    }
                }
                try {
                    getData();
                    //str.replaceAll("null","");
                    str.replaceAll(" - - "," ");
                    valuen.replaceAll(" 101 "," ");
                   // valuen.replaceAll("null","");
                }catch (Exception e){
                    e.printStackTrace();
                }

                // Isvalo db
                //dbHandler.deleteDB();
                //dbHandler.createTable();

                // Ideda Destytojus ir values i db
               /* for (int i=0;i<prof.length;i++){
                    dbHandler.addProduct(prof[i].toString(), value[i].toString());
                }*/

                //  String dbString = dbHandler.dbToString().toString();

            }        }, (Calendar.getInstance().getTimeInMillis()+5000)-Calendar.getInstance().getTimeInMillis());



    }
    public void getData(){

        int i=0;
        Cursor cursor = dbHandler.getData();
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            if (cursor.getString(cursor.getColumnIndex("str")) != "null"){
            str += cursor.getString(cursor.getColumnIndex("str"));
            valuen += cursor.getString(cursor.getColumnIndex("value"));
            }
            setStr.add(str);
        }


    }
    private void wwShit() {
        ww = (WebView)findViewById(R.id.wwID);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/prof.php");
        ww.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hideD();
                //ww.loadUrl("javascript:$(document.querySelector(\".tableMain\")).hide()");

            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public  void update() {
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    String el="";
                    String temp;
                    String[] array;
                    Document doc = Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/prof.php").get();
                    Elements elements = doc.select("select#prof option");
                    StringBuilder builder = new StringBuilder();
                    for (Element things : elements)
                        builder.append(things);
                    el = builder.toString();
                    temp =el.replaceAll("<option","")
                            .replaceAll("/option>","")
                            .replaceAll("extra_attribute","")
                            .replaceAll("disabled value=\"","")
                            .replaceAll("[{{}}]","")
                            .replaceAll("\" selected>--pasirinkti-- value=\"101\" >- -","")
                            .replaceAll("value=\"","")
                            .replaceAll("\" selected>","")
                            .replaceAll("\" >","_ ")
                            .replaceAll("<",":");
                    array = temp.split(":");
                    value = new String[array.length];
                    prof = new String[array.length];
                    int a=0;
                    String[] d1 ;
                    for (int i=0;i<array.length;i++){
                        //Log.i("Duck",""+array[i]);
                        for (String retval: array[i].split("_")){
                            if (a==0){
                                prof[i] = retval;
                                a++;}
                            else {
                                value[i] = retval;
                                a=0;
                            }
                        }
                        value[0]="duck";
                       // Log.i("Duck","Value :"+ value[i]+ "  Prof : " + prof[i] );
                    }
                }catch (Exception e){
                    Log.e("Duck",""+ e.getMessage()+":" );
                    e.printStackTrace();

                }
            }
        }).start();
    }
    public void hideD(){
       //ww.loadUrl("javascript:$(document.querySelector(\".hdrTable\")).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\".main_menu\")).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[0]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr td table td table tbody tr td\")[2]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[2]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[3]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr button\")[0]).hide();");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr\")[6]).hide();");
        ww.loadUrl("javascript:$(document.querySelector(\"#customMessage\")).hide()");
        ww.loadUrl("javascript:$(document.querySelector(\"#adminError\")).hide()");
        ww.loadUrl("javascript:$(\"html\").css(\"margin-top\", 0);");
        ww.loadUrl("javascript:document.body.style.marginTop=-10");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[3]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[2]).hide()");
    }public void selectionD( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tf_destytojai,menu);
        return true;
    }
    public void selection( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
    public void click(){
        // ww.loadUrl("javascript:$(document.querySelector(\"input.inputbutton.special\")).click();");
        ww.loadUrl("javascript:viewWeek();");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                //ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/prof.php");
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
