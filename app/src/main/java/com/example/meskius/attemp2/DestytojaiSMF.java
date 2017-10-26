package com.example.meskius.attemp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Meskius on 10/25/2017.
 */
/*function b(){for(var i=0;i<document.querySelectorAll('#prof option').length;i++){
        str += '"'+document.querySelectorAll('#prof option')[i].innerText+'",';}}*/


/*function a(){for(var i=0;i<document.querySelectorAll('#prof option').length;i++){
        str += 'case "'+document.querySelectorAll('#prof option')[i].innerText+'":\n'+'selection("prof","'+document.querySelectorAll('#prof option')[i].value+'");\nbreak;\n'}
        str += 'default:\nbreak;'}*/
public class DestytojaiSMF extends AppCompatActivity{

    WebView ww;
    String profText[] = {"--pasirinkti--","Aleliūnaitė Asta","Anužienė Aušra","Balkytė Giedrė","Baronaitė Jolanta","Bylaitė-Žakaitienė Andželika","Bytautienė Nijolė","Bojorovienė Jolanta","Bridikienė Vilma","Budrienė Liucija","Budrytė - Ausiejienė Laurencija","Čistienė Audronė","Danielienė Jūratė","Daubarienė Jolanda","Docienė Violeta","Dreižienė Lina","Ežerskienė Rima","Galdikienė Nijolė","Gotautienė Eglė","Grublienė Violeta","Ivanauskas Nerijus","Jonikas Donatas","Jonuševičienė Judita","Jurevičienė Jadvyga","Jurkaitienė Sabina","Kareivaitė Gintarė","Kasparienė Jurgita","Kavaliauskas Jonas","Kaveckė Ieva","Kavolius Robertas","Kiyak Deimena","Kinderis Remigijus","Klizaitė Jūratė","Kreišmonienė Jolanta","Kuprienė Laima","Kustienė Aurelija","Kvasaitė Virginija","Kvekšienė Milda","Leonavičienė Jūratė","Levickienė Lina","Mauricaitė Aurelija","Mecelienė Audronė","Meškelienė Audronė","Mickus Alvydas","Mikalauskas Rimantas","Nutautienė Rasa","Palubinskaitė Daiva","Pancerovienė Asta","Parišauskienė Dalia","Petraitienė Birutė","Petrauskienė Vita","Piklaps Arnoldas","Pikturnaitė Ilvija","Plačienė Birutė","Pocienė Monika","Pranauskienė Dovilė","Pranckūnienė Virginija","Rupkuvienė Silva","Sėlenienė Laura","Slušnienė Giedrė","Spiriajevas Eduardas","Statkuvienė Daiva","Statnickė Gita","Stonienė Adelė","Striaukaitė Lina","Šatienė Salomėja","Šikšnienė Aušra","Tamašauskienė Rūta","Tamošauskaitė Živilė","Uselienė Daiva","Vaitiekienė Janina","Vaitiekus Antanas","Valaitienė Aurelija","Valandos Nevardinės","Varneckienė Aniuta","Venckevičė Loreta","Zonienė Aurelija","Žakaitis Povilas","Žegunienė Vaida","Žvinienė Vida"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destytojai_smf);

        Intent intent= getIntent();
        final Spinner profID = (Spinner)findViewById(R.id.profID);
        Button back = (Button)findViewById(R.id.back);
        //Button auditorijos =(Button)findViewById(R.id.auditorijD);
        Button refreshID = (Button)findViewById(R.id.refreshID);

        spinner(profText,profID);


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
                hideD();
                //wwD.loadUrl("javascript:$(document.querySelector(\".tableMain\")).hide()");
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DestytojaiSMF.this,SMFMenu.class);
                startActivity(intent);
            }
        });

        profID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String destytojai = adapterView.getSelectedItem().toString();

                destytojai(destytojai);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        refreshID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/prof.php");
            }
        });
    }

    private void destytojai(String destytojai) {
        switch (destytojai){
            case "Aleliūnaitė Asta":
                selection("prof","1");
                break;
            case "Anužienė Aušra":
                selection("prof","4");
                break;
            case "Balkytė Giedrė":
                selection("prof","6");
                break;
            case "Baronaitė Jolanta":
                selection("prof","7");
                break;
            case "Bylaitė-Žakaitienė Andželika":
                selection("prof","9");
                break;
            case "Bytautienė Nijolė":
                selection("prof","10");
                break;
            case "Bojorovienė Jolanta":
                selection("prof","11");
                break;
            case "Bridikienė Vilma":
                selection("prof","12");
                break;
            case "Budrienė Liucija":
                selection("prof","13");
                break;
            case "Budrytė - Ausiejienė Laurencija":
                selection("prof","14");
                break;
            case "Čistienė Audronė":
                selection("prof","15");
                break;
            case "Danielienė Jūratė":
                selection("prof","16");
                break;
            case "Daubarienė Jolanda":
                selection("prof","17");
                break;
            case "Docienė Violeta":
                selection("prof","18");
                break;
            case "Dreižienė Lina":
                selection("prof","19");
                break;
            case "Ežerskienė Rima":
                selection("prof","20");
                break;
            case "Galdikienė Nijolė":
                selection("prof","21");
                break;
            case "Gotautienė Eglė":
                selection("prof","23");
                break;
            case "Grublienė Violeta":
                selection("prof","24");
                break;
            case "Ivanauskas Nerijus":
                selection("prof","25");
                break;
            case "Jonikas Donatas":
                selection("prof","26");
                break;
            case "Jonuševičienė Judita":
                selection("prof","27");
                break;
            case "Jurevičienė Jadvyga":
                selection("prof","28");
                break;
            case "Jurkaitienė Sabina":
                selection("prof","29");
                break;
            case "Kareivaitė Gintarė":
                selection("prof","30");
                break;
            case "Kasparienė Jurgita":
                selection("prof","31");
                break;
            case "Kavaliauskas Jonas":
                selection("prof","32");
                break;
            case "Kaveckė Ieva":
                selection("prof","33");
                break;
            case "Kavolius Robertas":
                selection("prof","34");
                break;
            case "Kiyak Deimena":
                selection("prof","35");
                break;
            case "Kinderis Remigijus":
                selection("prof","36");
                break;
            case "Klizaitė Jūratė":
                selection("prof","37");
                break;
            case "Kreišmonienė Jolanta":
                selection("prof","38");
                break;
            case "Kuprienė Laima":
                selection("prof","39");
                break;
            case "Kustienė Aurelija":
                selection("prof","40");
                break;
            case "Kvasaitė Virginija":
                selection("prof","41");
                break;
            case "Kvekšienė Milda":
                selection("prof","42");
                break;
            case "Leonavičienė Jūratė":
                selection("prof","43");
                break;
            case "Levickienė Lina":
                selection("prof","44");
                break;
            case "Mauricaitė Aurelija":
                selection("prof","46");
                break;
            case "Mecelienė Audronė":
                selection("prof","94");
                break;
            case "Meškelienė Audronė":
                selection("prof","48");
                break;
            case "Mickus Alvydas":
                selection("prof","49");
                break;
            case "Mikalauskas Rimantas":
                selection("prof","50");
                break;
            case "Nutautienė Rasa":
                selection("prof","53");
                break;
            case "Palubinskaitė Daiva":
                selection("prof","54");
                break;
            case "Pancerovienė Asta":
                selection("prof","55");
                break;
            case "Parišauskienė Dalia":
                selection("prof","56");
                break;
            case "Petraitienė Birutė":
                selection("prof","58");
                break;
            case "Petrauskienė Vita":
                selection("prof","59");
                break;
            case "Piklaps Arnoldas":
                selection("prof","60");
                break;
            case "Pikturnaitė Ilvija":
                selection("prof","61");
                break;
            case "Plačienė Birutė":
                selection("prof","62");
                break;
            case "Pocienė Monika":
                selection("prof","63");
                break;
            case "Pranauskienė Dovilė":
                selection("prof","64");
                break;
            case "Pranckūnienė Virginija":
                selection("prof","65");
                break;
            case "Rupkuvienė Silva":
                selection("prof","66");
                break;
            case "Sėlenienė Laura":
                selection("prof","67");
                break;
            case "Slušnienė Giedrė":
                selection("prof","69");
                break;
            case "Spiriajevas Eduardas":
                selection("prof","70");
                break;
            case "Statkuvienė Daiva":
                selection("prof","71");
                break;
            case "Statnickė Gita":
                selection("prof","72");
                break;
            case "Stonienė Adelė":
                selection("prof","73");
                break;
            case "Striaukaitė Lina":
                selection("prof","75");
                break;
            case "Šatienė Salomėja":
                selection("prof","76");
                break;
            case "Šikšnienė Aušra":
                selection("prof","77");
                break;
            case "Tamašauskienė Rūta":
                selection("prof","78");
                break;
            case "Tamošauskaitė Živilė":
                selection("prof","79");
                break;
            case "Uselienė Daiva":
                selection("prof","81");
                break;
            case "Vaitiekienė Janina":
                selection("prof","82");
                break;
            case "Vaitiekus Antanas":
                selection("prof","83");
                break;
            case "Valaitienė Aurelija":
                selection("prof","84");
                break;
            case "Valandos Nevardinės":
                selection("prof","85");
                break;
            case "Varneckienė Aniuta":
                selection("prof","86");
                break;
            case "Venckevičė Loreta":
                selection("prof","88");
                break;
            case "Zonienė Aurelija":
                selection("prof","90");
                break;
            case "Žakaitis Povilas":
                selection("prof","91");
                break;
            case "Žegunienė Vaida":
                selection("prof","92");
                break;
            case "Žvinienė Vida":
                selection("prof","93");
                break;
            default:
                break;
        }
    }

    public void hideD(){
        //wwD.loadUrl("javascript:$(document.querySelector(\".hdrTable\")).hide()");
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
}
