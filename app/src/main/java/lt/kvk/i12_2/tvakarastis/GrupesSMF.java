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

public class GrupesSMF extends AppCompatActivity {
    WebView ww;
    String programText[] = {"--pasirinkti--","Ištestinės","Nuolatinės"};
    String yearMetaiNL[] = {"--pasirinkti--", "1","2","3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1","2","3","4"};
    String groupNL1[] = {"--pasirinkti--","A 16-1","As 15-1","As 15-1 1 pog","As 15-1 2 pog","BA 23-1","BA 23-1 1 pog","BA 23-1 2 pog","F 19-1","F 19-1 1 pog","F 19-1 2 pog","F 19-1 3 pog","F 19-1 4 pog","F 19-1 5 pog","IPP 7-1","IPP 7-1 1 pog","LV 20-1","LV 20-1 1 pog","LV 20-1 2 pog","LV 20-1 3 pog","LV 20-1 4 pog","LV 20-1 5 pog","LV 20-1 6 pog","SP 4-1","TA 19-1","TA 19-1 1 pog","TA 19-1 2 pog","TA-1"};
    String groupNL2[] = {"--pasirinkti--","A 15-2","A 15-2 1 pog","A 15-2 2 pog","A 15-2 3 pog","A 15-2 4 pog","BA 22-2","BA 22-2 1 pog","BA 22-2 2 pog","BA 22-2 3 pog","ERASMUS","F 18-2","F 18-2 1 pog","F 18-2 2 pog","F 18-2 3 pog","F 18-2 4 pog","IPP 6-2","IPP 6-2 3 pog","IPP 6-2 4 pog","IPP 6-2 5 pog","IPP 6-2 6 pog","IPP 6-2 7 pog","IPP 6-2 8 pog","IPP 6-2 9 pog","LV 19-2","LV 19-2 1 pog","LV 19-2 2 pog","LV 19-2 3 pog","LV 19-2 4 pog","LV 19-2 5 pog","LV 19-2 6 pog","LV 19-2 7 pog","SP 3-2","TA 18-2","TA 18-2 1 pog","TA 18-2 2 pog","TA 18-2 3 pog","TA 18-2 4 pog","TA-3","VV 23-2"};
    String groupNL3[] = {"--pasirinkti--","A 14-3","BA 21-3","BA 21-3 1 pog","BA 21-3 2 pog","F 17-3","F 17-3 1 pog","F 17-3 2 pog","IPP 5-3","KV 13-3","LV 18-3","SP 2-3","SPV 6-3","TA 17-3","TA 17-3 3 pog","TA 17-3 4 pog","TA 17-3 5 pog","TA 17-3 6 pog","VV 22-3"};
    String groupIST1[] = {"--pasirinkti--","BAi 18-1","BAi 18-1 1pog","BAi 18-1 2 pog","Fi 14-1","IPPi 6-1","IPPi 6-1 1 pog","IPPi 6-1 2 pog","IPPi 6-1 3 pog","IPPi 6-1 4 pog","LVi 15-1","LVi 15-1 1 pog","LVi 15-1 2 pog"};
    String groupIST2[] = {"--pasirinkti--","BAi 17-2","BAi 17-2 1 pog","BAi 17-2 2 pog","BAi 17-2 3 pog","BAi 17-2 4 pog","BAi 17-2 5 pog","Fi 13-2","Fi 13-2 1 pog","Fi 13-2 2 pog","IPPi 5-2","IPPi 5-2 1 pog","IPPi 5-2 2 pog","IPPi 5-2 3 pog","IPPi 5-2 4 pog","LVi 14-2","LVi 14-2 1 pog","LVi 14-2 2 pog"};
    String groupIST3[] = {"--pasirinkti--","Ai 14-3","BAi 16-3","Fi 12-3","LVi1 3-3","VVi 11-3","VVi 11-3 1 pog","VVi 11-3 2 pog"};
    String groupIST4[] = {"--pasirinkti--","Ai 13-4","BAi 15-4","Fi 11-4","LVi 12-4","LVi 12-4 1 pog","LVi 12-4 2 pog"};

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
                    spinner(groupIST1,grupe);
                    selection("year","1");
                    selection("branch","6");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(groupIST2,grupe);
                    selection("year","2");
                    selection("branch","7");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(groupIST3,grupe);
                    selection("year","4");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "4":
                    spinner(groupIST4,grupe);
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
                    spinner(groupNL1,grupe);
                    selection("year","1");
                    selection("branch","5");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    spinner(groupNL2,grupe);
                    selection("year","2");
                    selection("branch","3");
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    spinner(groupNL3,grupe);
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
