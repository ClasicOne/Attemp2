package com.example.meskius.attemp2;

import android.content.Intent;
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

import java.util.HashMap;

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
    // Bendrosios praktikos slauga
    String bps1[] = {"--pasirinkti--", "SL 19-1", "SL 19-1, 1-2", "SL 19-1, 1-3", "SL 19-1, 2-2", "SL 19-1, 2-3", "SL 19-1, 3-3", "SL 20-1", "SL 20-1, 1-2", "SL 20-1, 1-3", "SL 20-1, 2-2", "SL 20-1, 2-3", "SL 20-1, 3-3", "SL 21-1", "SL 21-1, 1-2", "SL 21-1, 2-2", "SL 21-1,2-3", "SL 21-1,3-3", "SL 21-1.1-3"};
    String bps2[] = {"--pasirinkti--", "SL 17-2", "SL 17-2, 1-2", "SL 17-2, 2-2", "SL 18-2", "SL 18-2, 1-2", "SL 18-2, 2-2"};
    String bps3[] = {"--pasirinkti--", "SL 15-3", "SL 15-3, 1-2", "SL 15-3, 2-2", "SL 16-3", "SL 16-3, 1-2", "SL 16-3, 2-2"};
    String bps4[] = {"--pasirinkti--", "SL 13-4", "SL 13-4, 1-2", "SL 13-4, 2-2", "SL 14-4", "SL 14-4, 1-2", "SL 14-4, 2-2"};
    // Burnos higiena
    String bh1[] = {"--pasirinkti--", "BH 10-1", "BH 10-1, 1-2", "BH 10-1, 2-2"};
    String bh2[] = {"--pasirinkti--", "BH9-2", "BH9-2, 1-2", "BH9-2, 2-2"};
    String bh3[] = {"--pasirinkti--", "BH8-3", "BH8-3, 1-2", "BH8-3, 1-3", "BH8-3, 2-2", "BH8-3, 2-3", "BH8-3, 3-3"};
    // Dietetika
    String d1[] = {"--pasirinkti--", "DT 4-1", "DT 4-1, 1-2", "DT 4-1, 2-2", "DTs 1-1", "DTs 1-1, 1-2", "DTs 1-1, 2-2"};
    String d2[] = {"--pasirinkti--", "DT 3-2", "DT 3-2, 1-2", "DT 3-2, 2-2", "DTi 2-2", "DTi 2-2, 1-2", "DTi 2-2, 2-2"};
    String d3[] = {"--pasirinkti--", "DT 2-3", "DTi 1-3"};
    // Grožio terapija
    String gt1[] = {"--pasirinkti--", "GT 17-1", "GT 17-1, 1-2", "GT 17-1, 1-3", "GT 17-1, 2-2", "GT 17-1, 2-3", "GT 17-1, 3-3", "GT 18-1", "GT 18-1, 1-2", "GT 18-1, 1-3", "GT 18-1, 2-2", "GT 18-1, 2-3", "GT 18-1, 3-3"};
    String gt2[] = {"--pasirinkti--", "GT 15-2", "GT 15-2, 1-2", "GT 15-2, 1-3", "GT 15-2, 2-2", "GT 15-2, 2-3", "GT 15-2, 3-3", "GT 16-2", "GT 16-2, 1-2", "GT 16-2, 1-3", "GT 16-2, 2-2", "GT 16-2, 2-3", "GT 16-2, 3-3"};
    String gt3[] = {"--pasirinkti--", "GT 13-3", "GT 13-3, 1-2", "GT 13-3, 1-3", "GT 13-3, 2-2", "GT 13-3, 2-3", "GT 13-3, 3-3", "GT 14-3", "GT 14-3, 1-2", "GT 14-3, 1-3", "GT 14-3, 2-2", "GT 14-3, 2-3", "GT 14-3, 3-3"};
    // Kineziterapija
    String k1[] = {"--pasirinkti--", "KT 16-1", "KT 16-1, 1-2", "KT 16-1, 2-2", "KT 17-1", "KT 17-1, 1-2", "KT 17-1, 2-2"};
    String k2[] = {"--pasirinkti--", "KT 14-2", "KT 14-2  2-2", "KT 14-2, 1-2", "KT 14-2, 1-3", "KT 14-2, 2-3", "KT 14-2, 3-3", "KT 15-2", "KT 15-2, 1-2", "KT 15-2, 1-3", "KT 15-2, 2-2", "KT 15-2, 2-3", "KT 15-2, 3-3"};
    String k3[] = {"--pasirinkti--", "KT 12-3", "KT 12-3, 1-2", "KT 12-3, 2-2", "KT 13-3", "KT 13-3, 1-2", "KT 13-3, 2-2"};
    // Odontologinė priežiūra
    String op1[] = {"--pasirinkti--", "OP10-1", "OP10-1, 1-2", "OP10-1, 2-2"};
    String op2[] = {"--pasirinkti--", "OP9-2", "OP9-2, 1-2", "OP9-2, 2-2"};
    String op3[] = {"--pasirinkti--", "OP8-3", "OP8-3, 1-3", "OP8-3, 2-3", "OP8-3, 3-3"};
    // Socialinis darbas
    String sd1[] = {"--pasirinkti--", "SD 16-1", "SD 16-1, 1-2", "SD 16-1, 2-2", "SDs 1-1", "SDs 1-1, 1-2", "SDs 1-1, 2-2"};
    String sd2[] = {"--pasirinkti--", "SD 14-2", "SD 14-2, 1-2", "SD 14-2, 2-2", "SD 15-2", "SD 15-2, 1-2", "SD 15-2, 2-2"};
    String sd3[] = {"--pasirinkti--", "SD 12-3", "SD 12-3, 1-2", "SD 12-3, 2-2", "SD 13-3", "SD 13-3, 1-2", "SD 13-3, 2-2"};
    String sd4[] = {"--pasirinkti--", "SDi 6-4"};

    String programSpinnerText,
            yearSpinnerText;

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

        // Paslepti spinner kuriu nereikia
       /* metai.setVisibility(View.INVISIBLE);
        grupe.setVisibility(View.INVISIBLE);
        metaiText.setVisibility(View.INVISIBLE);
        grupeText.setVisibility(View.INVISIBLE);*/

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
                    spinner(bps1, grupe);
                    selection("year", "1");
                    selection("branch", "17");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(bps2, grupe);
                    selection("year", "2");
                    selection("branch", "19");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(bps3, grupe);
                    selection("year", "3");
                    selection("branch", "20");

                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "4":
                    spinner(bps4, grupe);
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
                    spinner(bh1, grupe);
                    selection("year", "1");
                    selection("branch", "22");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(bh2, grupe);
                    selection("year", "2");
                    selection("branch", "21");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(bh3, grupe);
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
                    spinner(d1, grupe);
                    selection("year", "1");
                    selection("branch", "23");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(d2, grupe);
                    selection("year", "2");
                    selection("branch", "26");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(d3, grupe);
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
                    spinner(gt1, grupe);
                    selection("year", "1");
                    selection("branch", "11");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(gt2, grupe);
                    selection("year", "2");
                    selection("branch", "12");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(gt3, grupe);
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
                    spinner(k1, grupe);
                    selection("year", "1");
                    selection("branch", "15");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(k2, grupe);
                    selection("year", "2");
                    selection("branch", "16");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(k3, grupe);
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
                    spinner(op1, grupe);
                    selection("year", "1");
                    selection("branch", "24");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(op2, grupe);
                    selection("year", "2");
                    selection("branch", "25");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(op3, grupe);
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
                    spinner(sd1, grupe);
                    selection("year", "1");
                    selection("branch", "13");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(sd2, grupe);
                    selection("year", "2");
                    selection("branch", "14");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(sd3, grupe);
                    selection("year", "3");
                    selection("branch", "10");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "4":
                    spinner(sd4, grupe);
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
    // Atgal mygtukas
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smvf_grupes,menu);
        return true;
    }
    // Refresh mygtukas
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                //ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/groups.php");
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
