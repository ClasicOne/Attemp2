package lt.kvk.i12_2.tvakarastis;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Meskius on 10/25/2017.
 */
// Strings
/*function b(){for(var i=0;i<document.querySelectorAll("#program option").length;i++){
        str += "*"+document.querySelectorAll("#program option")[i].innerText+"*,";}}*/

// cases
/*function a(){for(var i=0;i<document.querySelectorAll('#group option').length;i++){
str += 'case "'+document.querySelectorAll('#group option')[i].innerText+'":\n'+'selection("group","'+document.querySelectorAll('#group option')[i].value+'");\n click();\nbreak;\n'}
str += 'default:\nbreak;'}*/

public class GrupesSVMF extends AppCompatActivity {
    WebView ww;

    String programText[] = {"--pasirinkti--", "Bendrosios praktikos slauga", "Burnos higiena", "Dietetika", "Grožio terapija", "Kineziterapija", "Odontologinė priežiūra", "Socialinis darbas"};
    String yearMetai3[] = {"--pasirinkti--", "1", "2", "3"};
    String yearMetai4[] = {"--pasirinkti--", "1", "2", "3", "4"};

    String programSpinnerText,
            yearSpinnerText;
    ProgressDialog progress;
    String[] email = {"v.zalys@kvk.lt"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grupes_smf);
        wwShit();
        final Spinner program = (Spinner) findViewById(R.id.program);
        final Spinner metai = (Spinner) findViewById(R.id.year);
        final Spinner grupe = (Spinner) findViewById(R.id.group);
        final TextView metaiText = (TextView) findViewById(R.id.year_text);
        final TextView grupeText = (TextView) findViewById(R.id.group_text);
        //<------------------------- Deklaruojamas Hashmap
        final HashMap<String,String> grupesHashmap = new  HashMap<>();
        String[] grupes_str = getResources().getStringArray(R.array.grupes_SVMF_str);
        String[] grupes_values = getResources().getStringArray(R.array.grupes_SVMF_value);

        Log.e("Duck",""+grupes_values.length+" "+ grupes_str.length );
        for(int i = 0;i<grupes_str.length; i++)
            grupesHashmap.put(grupes_str[i], grupes_values[i]);
        //<-------------------------

        spinner(programText, program);
        // spiiner paspaudimas tipas
        program.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                programSpinnerText = adapterView.getSelectedItem().toString();
                program(metai, metaiText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        // spiiner paspaudimas metai
        metai.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                yearSpinnerText = adapterView.getSelectedItem().toString();
                year(grupe, grupeText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        // spiiner paspaudimas grupe

        grupe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                Log.e("Duck",""+spinnerText+" "+grupesHashmap.get(spinnerText));

                if (!grupesHashmap.get(spinnerText).equals("duck")){
                selection("group",""+grupesHashmap.get(spinnerText)+"");
                click();
                ww.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        update();
    }

    private void wwShit() {
        ww();
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/groups.php");
        // Kai uzsikrauna puslapis isvkiecia metoda kad pasleptu nereikalingus puslapio elementus
        ww.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hide();
            }
        });
    }

    // ww stuf
    private void ww() {
        ww = (WebView) findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
    }
    // metai
    private void year(Spinner grupe, TextView grupeText) {
        if (programSpinnerText.contains("Bendrosios praktikos slauga"))
            switch (yearSpinnerText) {
                case "1":
                    spinner(getResources().getStringArray(R.array.G_SVMF_bps_1), grupe);
                    selection("year", "1");
                    selection("branch", "17");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_SVMF_bps_2), grupe);
                    selection("year", "2");
                    selection("branch", "19");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_SVMF_bps_3), grupe);
                    selection("year", "3");
                    selection("branch", "20");

                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "4":
                    spinner(getResources().getStringArray(R.array.G_SVMF_bps_4), grupe);
                    selection("year", "4");
                    selection("branch", "3");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                default:
                    break;
            }
        if (programSpinnerText.contains("Burnos higiena"))
            switch (yearSpinnerText) {
                case "1":
                    spinner(getResources().getStringArray(R.array.G_SVMF_bh_1), grupe);
                    selection("year", "1");
                    selection("branch", "22");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_SVMF_bh_2), grupe);
                    selection("year", "2");
                    selection("branch", "21");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_SVMF_bh_3), grupe);
                    selection("year", "3");
                    selection("branch", "7");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        if (programSpinnerText.contains("Dietetika"))
            switch (yearSpinnerText) {
                case "1":
                    spinner(getResources().getStringArray(R.array.G_SVMF_d_1), grupe);
                    selection("year", "1");
                    selection("branch", "23");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_SVMF_d_2), grupe);
                    selection("year", "2");
                    selection("branch", "26");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_SVMF_d_3), grupe);
                    selection("year", "3");
                    selection("branch", "8");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        if (programSpinnerText.contains("Grožio terapija"))
            switch (yearSpinnerText) {
                case "1":
                    spinner(getResources().getStringArray(R.array.G_SVMF_gt_1), grupe);
                    selection("year", "1");
                    selection("branch", "11");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_SVMF_gt_2), grupe);
                    selection("year", "2");
                    selection("branch", "12");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_SVMF_gt_3), grupe);
                    selection("year", "3");
                    selection("branch", "4");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        if (programSpinnerText.contains("Kineziterapija"))
            switch (yearSpinnerText) {
                case "1":
                    spinner(getResources().getStringArray(R.array.G_SVMF_k_1), grupe);
                    selection("year", "1");
                    selection("branch", "15");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_SVMF_k_2), grupe);
                    selection("year", "2");
                    selection("branch", "16");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_SVMF_k_3), grupe);
                    selection("year", "3");
                    selection("branch", "9");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        if (programSpinnerText.contains("Odontologinė priežiūra"))
            switch (yearSpinnerText) {
                case "1":
                    spinner(getResources().getStringArray(R.array.G_SVMF_op_1), grupe);
                    selection("year", "1");
                    selection("branch", "24");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_SVMF_op_2), grupe);
                    selection("year", "2");
                    selection("branch", "25");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_SVMF_op_3), grupe);
                    selection("year", "3");
                    selection("branch", "6");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        if (programSpinnerText.contains("Socialinis darbas"))
            switch (yearSpinnerText) {
                case "1":
                    spinner(getResources().getStringArray(R.array.G_SVMF_sd_1), grupe);
                    selection("year", "1");
                    selection("branch", "13");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_SVMF_sd_2), grupe);
                    selection("year", "2");
                    selection("branch", "14");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_SVMF_sd_3), grupe);
                    selection("year", "3");
                    selection("branch", "10");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "4":
                    spinner(getResources().getStringArray(R.array.G_SVMF_sd_4), grupe);
                    selection("year", "3");
                    selection("branch", "27");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }


    }
    // Tipas
    private void program(Spinner metai, TextView metaiText) {
        switch (programSpinnerText) {
            case "Bendrosios praktikos slauga":
                spinner(yearMetai4, metai);
                selection("program", "1");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            case "Burnos higiena":
                spinner(yearMetai3, metai);
                selection("program", "5");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            case "Dietetika":
                spinner(yearMetai3, metai);
                selection("program", "6");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            case "Grožio terapija":
                spinner(yearMetai3, metai);
                selection("program", "2");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            case "Kineziterapija":
                spinner(yearMetai3, metai);
                selection("program", "3");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            case "Odontologinė priežiūra":
                spinner(yearMetai3, metai);
                selection("program", "4");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            case "Socialinis darbas":
                spinner(yearMetai4, metai);
                selection("program", "7");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }
    // Rodyti savaite
    public void click() {
        // ww.loadUrl("javascript:$(document.querySelector(\"input.inputbutton.special\")).click();");
        ww.loadUrl("javascript:viewWeek();");
    }
    // Paslepia nereikalingus elementusa
    public void hide() {
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
    // Pasirinkimo grupes ww js
    public void selection(String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas + "').val('" + val + "').change();");

    }
    // Spinner idejimas duomenu (string array)
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }

    public  void update() {
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
                            progress = new ProgressDialog(GrupesSVMF.this);
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
                                                    "Neina pamatyti tvarkaraščių, todėl reikia patikrinti ar jie yra tinkkamai publikuojami.");

                                    //dialogInterface.dismiss();
                                }
                            });
                            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progress.show();
                            timer();
                        }
                    });
                }
            }
        }).start();
    }
    public void timer(){
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
                    timer();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smvf_grupes,menu);
        return true;
    }
    // Refresh mygtukas
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
                    File temp = new File  ("/data/user/0/lt.kvk.i12_2.tvakarastis/files/SVMF.jpg");
                    Intent intent = new Intent(GrupesSVMF.this, SavedImage_Group_SVMF.class);
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
            fos = openFileOutput("SVMF.jpg", Context.MODE_PRIVATE);
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
}
