package lt.kvk.i12_2.tvakarastis.prof;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
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

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import lt.kvk.i12_2.tvakarastis.R;
import lt.kvk.i12_2.tvakarastis.imageview.SavedImage_Prof_TF;

/**
 * Created by Meskius on 10/21/2017.
 */

public class DestytojaiTF extends AppCompatActivity {
    WebView ww;

    String[] value = null;
    String[] prof = null;
    ProgressDialog progress;
    String[] email = {"v.zalys@kvk.lt"};
    final HashMap<String,String> grupesHashmap = new  HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destytojai_tf);
        wwShit();
        update();
        final Spinner profID = (Spinner)findViewById(R.id.profID);
        ProgressDialog progress = new ProgressDialog(this,R.style.MyAlertDialogStyle);
        progress.setTitle("Palaukite");
        progress.setMessage("Gaunnamas dėstytojų sąrašas");
        progress.setIndeterminate(true);
        progress.setCancelable(true); // disable dismiss by tapping outside of the dialog
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.getWindow().setGravity(Gravity.CENTER);

        progress.show();

        //<---------- Deklaruojamas Hashmap --------

        final String[] destytojai_value= getResources().getStringArray(R.array.destytojai_TF_value);
        final String[] destytojai_str = getResources().getStringArray(R.array.destytojai_TF_str);
        newFill(destytojai_str, destytojai_value);
        //<-------------------------


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
        timer( progress, profID);
checkIfWorking();
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
    private void newFill(String[] destytojai_str, String[] destytojai_value) {

        for(int i = 0;i<destytojai_str.length; i++)
            grupesHashmap.put(destytojai_str[i], destytojai_value[i]);
        //<-------------------------

    }
    public void timer(final ProgressDialog progress, final Spinner profID){
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try{
                    if(value != null){
                        newFill(prof,value);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                spinner(prof,profID);
                            }
                        });
                        progress.cancel();
                    }else timer(progress, profID);

                }catch (Exception e){
                    // Log.e("Duck",""+e);
                    e.fillInStackTrace();
                }


                // Log.e("Duck","as");
            }        }, (Calendar.getInstance().getTimeInMillis()+50)-Calendar.getInstance().getTimeInMillis());
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
                        Log.i("Duck","Value :"+ value[i]+ "  Prof : " + prof[i] );
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

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val("+val+").change();");

    }
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                restartActivity();
                break;
            case R.id.saveImage:
                ww.getSettings().setUseWideViewPort(true);
                ww.setInitialScale(1);

                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    saveImage();

                                }
                            });

                            // ww.setInitialScale(0);
                            Log.e("Duck", ": Timer");
                        }catch (Exception e) {
                            // Log.e("Duck", "" + e.getMessage() + ": Timer");
                            // e.printStackTrace();

                        }
                    }        }, (300));


                break;
            case R.id.showImage:

                try{
                    File temp = new File  ("/data/user/0/lt.kvk.i12_2.tvakarastis/files/TF_prof.jpg");
                    Intent intent = new Intent(DestytojaiTF.this, SavedImage_Prof_TF.class);
                    startActivity(intent);
                }catch (NullPointerException e){
                }


        }
        return super.onOptionsItemSelected(item);
    }

    private void saveImage() {


        Picture picture = ww.capturePicture();
        Bitmap b = Bitmap.createBitmap(picture.getWidth(),
                picture.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);

        picture.draw(c);
        FileOutputStream fos;
        try {
            fos = openFileOutput("TF_prof.jpg", Context.MODE_PRIVATE);
            if (fos != null) {
                b.compress(Bitmap.CompressFormat.JPEG, 100, fos);

                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            String a = e.getMessage();
            Log.e("Duck", e.getMessage());
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            ww.getSettings().setUseWideViewPort(false);
                            ww.setInitialScale(0);
                        }
                    });
                    Log.e("Duck", ": Timer");
                } catch (Exception e) {
                    // Log.e("Duck", "" + e.getMessage() + ": Timer");
                    // e.printStackTrace();

                }
            }
        }, (550));


    }
    public void restartActivity(){
        Intent mIntent = getIntent();
        finish();
        startActivity(mIntent);
    }
    public  void checkIfWorking() {
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/prof.php").get();
                }catch (Exception e){
                    Log.e("Duck",""+ e.getMessage()+":" );
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progress = new ProgressDialog(DestytojaiTF.this);
                            progress.setTitle("Napavyksta gauti duomenų iš serverio");
                            progress.setMessage("Galimos priežastys: \n1. Nesate pasijungę interneto ryšį,\n" +
                                    "2. Gali būti problemos serverio pusėje.\n" +
                                    "Sprendimas:\n" +
                                    "Pasitikrinkite interneto prieigą ir bandykite patikrinti vėliau. ");
                            progress.setIndeterminate(true);
                            progress.setCancelable(true); // disable dismiss by tapping outside of the dialog
                            progress.setButton(DialogInterface.BUTTON_POSITIVE, "Pranešti administratoriui", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    composeEmail(email,"Neveikia tvarkaraščiai",
                                            "Sveiki,\n" +
                                                    "Neina pamatyti tvarkaraščių, todėl reikia patikrinti ar jie yra tinkamai publikuojami.");

                                    //dialogInterface.dismiss();
                                }
                            });
                            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progress.show();
                            timerIfWorking();
                        }
                    });
                }
            }
        }).start();
    }
    public void timerIfWorking(){
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/prof.php").get();
                    progress.cancel();
                }catch (Exception e) {
                    // Log.e("Duck", "" + e.getMessage() + ": Timer");
                    // e.printStackTrace();
                    timerIfWorking();
                }
            }        }, (50));
    }
    public void composeEmail(String[] addresses, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
