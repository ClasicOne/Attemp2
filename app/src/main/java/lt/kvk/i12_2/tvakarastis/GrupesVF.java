package lt.kvk.i12_2.tvakarastis;

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
 * Created by Meskius on 10/24/2017.
 */

public class GrupesVF extends AppCompatActivity {
    WebView ww;
    String programText[] = {"--pasirinkti--","Ištestinės","Nuolatinės"};
    String yearMetaiNL[] = {"--pasirinkti--", "1","2","3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1","2","3","4"};


    String programSpinnerText,
            yearSpinnerText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grupes_tf);
        wwShit();

        final Spinner program =(Spinner)findViewById(R.id.program);
        final Spinner metai = (Spinner)findViewById(R.id.year);
        final Spinner grupe = (Spinner)findViewById(R.id.group);
        final TextView metaiText =(TextView) findViewById(R.id.year_text);
        final TextView grupeText = (TextView)findViewById(R.id.group_text);
        //<------------------------- Deklaruojamas Hashmap
        final HashMap<String,String> grupesHashmap = new  HashMap<>();
        String[] grupes_str = getResources().getStringArray(R.array.grupes_SMF_str);
        String[] grupes_values = getResources().getStringArray(R.array.grupes_SMF_value);
        Log.e("Duck",""+grupes_values.length+" "+ grupes_str.length );
        for(int i = 0;i<grupes_str.length; i++)
            grupesHashmap.put(grupes_str[i], grupes_values[i]);
        //<-------------------------

        metai.setVisibility(View.GONE);
        grupe.setVisibility(View.GONE);
        metaiText.setVisibility(View.GONE);
        grupeText.setVisibility(View.GONE);

        spinner(programText,program);

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
        grupe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
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
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_smf/groups.php");
        ww.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hide();
            }
        });
    }
    private void ww() {
        ww= (WebView)findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
    }

    private void year(Spinner grupe, TextView grupeText) {
        if(programSpinnerText.contains("Ištestinės"))
            switch (yearSpinnerText){
                case "1":
                    spinner(getResources().getStringArray(R.array.G_VF_ist_1),grupe);
                    selection("year","1");
                    selection("branch","6");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_VF_ist_2),grupe);
                    selection("year","2");
                    selection("branch","7");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_VF_ist_3),grupe);
                    selection("year","4");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "4":
                    spinner(getResources().getStringArray(R.array.G_VF_ist_4),grupe);
                    selection("year","4");
                    selection("branch","1");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                default:
                    break;
            }
        if(programSpinnerText.contains("Nuolatinės"))
            switch (yearSpinnerText){
                case "1":
                    spinner(getResources().getStringArray(R.array.G_VF_n_1),grupe);
                    selection("year","1");
                    selection("branch","5");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(getResources().getStringArray(R.array.G_VF_n_2),grupe);
                    selection("year","2");
                    selection("branch","3");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(getResources().getStringArray(R.array.G_VF_n_3),grupe);
                    selection("year","3");
                    selection("branch","2");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                default:
            break;
    }
    }
    private void program(Spinner metai, TextView metaiText) {
        switch (programSpinnerText){
            case "Ištestinės":
                spinner(yearMetaiIST,metai);
                selection("program","1");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            case "Nuolatinės":
                spinner(yearMetaiNL,metai);
                selection("program","2");
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    public void click(){
       // ww.loadUrl("javascript:$(document.querySelector(\"input.inputbutton.special\")).click();");
        ww.loadUrl("javascript:viewWeek();");
    }
    public void hide(){
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
    public void selection( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smf_grupes,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                //ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_smf/groups.php");
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
