package lt.kvk.i12_2.tvakarastis;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Meskius on 10/25/2017.
 */
/* */


/*function a(){for(var i=0;i<document.querySelectorAll('#prof option').length;i++){
        str += 'case "'+document.querySelectorAll('#prof option')[i].innerText+'":\n'+'selection("prof","'+document.querySelectorAll('#prof option')[i].value+'");\nbreak;\n'}
        str += 'default:\nbreak;'}*/
public class DestytojaiSMF extends AppCompatActivity{

    WebView ww;
    String[] value = null;
    String[] prof = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destytojai_tf);
        Intent intent= getIntent();
        final Spinner profID = (Spinner)findViewById(R.id.profID);
        spinner(getResources().getStringArray(R.array.destytojai_SMF_str),profID);
        wwShit();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }}, (Calendar.getInstance().getTimeInMillis()+1000)-Calendar.getInstance().getTimeInMillis());

        //<------------------------- Deklaruojamas Hashmap
        final HashMap<String,String> grupesHashmap = new  HashMap<>();
        final String[] destytojai_str = getResources().getStringArray(R.array.destytojai_SMF_str);
        final String[] destytojai_value = getResources().getStringArray(R.array.destytojai_SMF_value);
        for(int i = 0;i<destytojai_str.length; i++)
            grupesHashmap.put(destytojai_str[i], destytojai_value[i]);
        //<-------------------------
        profID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String destytojai = adapterView.getSelectedItem().toString();

                if (!grupesHashmap.get(destytojai).equals("duck")){
                    selection("prof",""+grupesHashmap.get(destytojai)+"");
                   //click();
                    ww.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.e("Duck",""+value.length +"   "+ destytojai_str.length);
                if(value.length != destytojai_str.length){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int a =0;
                            while (true) {
                                Toast.makeText(DestytojaiSMF.this, "Reikia atnaujinimo\nkreipkitės į Džiuga Ramančioni", Toast.LENGTH_LONG).show();
                                if (a==49)
                                    break;
                                a++;
                            }
                        }
                    });

                }
                Log.e("Duck","as");
            }        }, (Calendar.getInstance().getTimeInMillis()+2000)-Calendar.getInstance().getTimeInMillis());

    }
    public  void update() {
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    String el="";
                    String temp;
                    String[] array;
                    Document doc = Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_smf/prof.php").get();
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
                    // Toast.makeText(DestytojaiTF.this, "Need UPDATE!!", Toast.LENGTH_LONG).show();
                    if (getResources().getStringArray(R.array.destytojai_TF_value).length == value.length-1){

                    }
                }catch (Exception e){
                    Log.e("Duck",""+ e.getMessage()+":" );
                    e.printStackTrace();

                }
            }
        }).start();
    }
    private void wwShit() {
        ww= (WebView)findViewById(R.id.wwID);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_smf/prof.php");
        ww.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //hideD();
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
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
    public void selection( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
    public void click(){
        // ww.loadUrl("javascript:$(document.querySelector(\"input.inputbutton.special\")).click();");
        ww.loadUrl("javascript:viewWeek();");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smf_destytojai,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_smf/prof.php");
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