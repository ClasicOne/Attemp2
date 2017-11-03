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
            case "Abunevičius Romas":
                selection("prof","64");
                break;
            case "Albrechtienė Kristina":
                selection("prof","78");
                break;
            case "Altuchova Aida":
                selection("prof","79");
                break;
            case "Andriuškevičiūtė Gerda":
                selection("prof","176");
                break;
            case "Andruška Marius":
                selection("prof","141");
                break;
            case "Andruškienė Jurgita":
                selection("prof","37");
                break;
            case "Arlauskienė Renata":
                selection("prof","183");
                break;
            case "Arnašiūtė Roberta":
                selection("prof","80");
                break;
            case "Auglienė A.":
                selection("prof","161");
                break;
            case "Bačiulienė Kristina":
                selection("prof","81");
                break;
            case "Bagdonienė Irena":
                selection("prof","181");
                break;
            case "Bardžiukienė Elytė":
                selection("prof","16");
                break;
            case "Barsevičienė Šarūnė":
                selection("prof","32");
                break;
            case "Barzdžiukienė Elytė":
                selection("prof","36");
                break;
            case "Beinorienė Jūratė":
                selection("prof","83");
                break;
            case "Bertašiūtė A.":
                selection("prof","143");
                break;
            case "Beržanskienė Justė":
                selection("prof","70");
                break;
            case "Bikuličienė Roberta":
                selection("prof","164");
                break;
            case "Bylaitė-Žakaitienė Andželika":
                selection("prof","84");
                break;
            case "Boltutienė Jurgita":
                selection("prof","50");
                break;
            case "Buivydaitė Eglė":
                selection("prof","85");
                break;
            case "Bumbliauskytė Dalia":
                selection("prof","86");
                break;
            case "Burdulis Dainius":
                selection("prof","87");
                break;
            case "Čekmariova J.":
                selection("prof","169");
                break;
            case "Dambrauskaitė Angelija":
                selection("prof","69");
                break;
            case "Dambrauskienė Nijolė":
                selection("prof","88");
                break;
            case "Danieliienė Jūratė":
                selection("prof","179");
                break;
            case "Daubarienė Jolanda":
                selection("prof","185");
                break;
            case "Daukantienė Danutė":
                selection("prof","89");
                break;
            case "Dėdinienė Ingrida":
                selection("prof","90");
                break;
            case "Derkintienė Jūratė":
                selection("prof","163");
                break;
            case "Dudėnė Jurgita":
                selection("prof","134");
                break;
            case "Dvarionaitė Lijana":
                selection("prof","63");
                break;
            case "Einars Bronius":
                selection("prof","68");
                break;
            case "Eismontienė Jekaterina":
                selection("prof","91");
                break;
            case "Freitakaitė V.":
                selection("prof","146");
                break;
            case "Gaižauskienė Ina":
                selection("prof","74");
                break;
            case "Galčionkova Ana":
                selection("prof","92");
                break;
            case "Galdikienė Nijolė":
                selection("prof","93");
                break;
            case "Gedrimė Lina":
                selection("prof","47");
                break;
            case "Gedrimienė Bernadeta":
                selection("prof","76");
                break;
            case "Gedvilienė L.":
                selection("prof","162");
                break;
            case "Giedraitienė Neringa":
                selection("prof","75");
                break;
            case "Girdžiūnienė Rasa":
                selection("prof","21");
                break;
            case "Indriuškienė Rasa":
                selection("prof","177");
                break;
            case "Jakubaitienė Vanda":
                selection("prof","23");
                break;
            case "Jankauskienė Rita":
                selection("prof","53");
                break;
            case "Janušas Leonas":
                selection("prof","95");
                break;
            case "Jonelienė Romena":
                selection("prof","140");
                break;
            case "Jonelys Valdas":
                selection("prof","96");
                break;
            case "Juknevičienė Aurelija":
                selection("prof","97");
                break;
            case "Juodienė Stasė":
                selection("prof","98");
                break;
            case "Juškienė Vaineta":
                selection("prof","99");
                break;
            case "Karpavičė Irma":
                selection("prof","187");
                break;
            case "Karpavičiūtė Solmita":
                selection("prof","59");
                break;
            case "Karžauskienė Edita":
                selection("prof","167");
                break;
            case "Kasnauskienė Jolanta":
                selection("prof","42");
                break;
            case "Kasperavičiūtė Simona":
                selection("prof","31");
                break;
            case "Kaunienė Jūratė":
                selection("prof","51");
                break;
            case "Kemzūrienė Deimantė":
                selection("prof","41");
                break;
            case "Kraniauskas Liutauras":
                selection("prof","155");
                break;
            case "Kraniauskienė Sigita":
                selection("prof","58");
                break;
            case "Kreišmonienė Jolanta":
                selection("prof","171");
                break;
            case "Kreivinienė B.":
                selection("prof","157");
                break;
            case "Kukštienė Viktorija":
                selection("prof","28");
                break;
            case "Lenčiauskienė Daiva":
                selection("prof","52");
                break;
            case "Letkauskaitė Kristina":
                selection("prof","27");
                break;
            case "Levickienė L.":
                selection("prof","142");
                break;
            case "Levickytė Greta":
                selection("prof","101");
                break;
            case "Levuškinas 0.":
                selection("prof","139");
                break;
            case "Liukienė Ramunė":
                selection("prof","44");
                break;
            case "Maniušienė Margarita":
                selection("prof","65");
                break;
            case "Mataitienė Angelija":
                selection("prof","102");
                break;
            case "Mauricaitė Ugnė":
                selection("prof","103");
                break;
            case "Mažionienė Asta":
                selection("prof","8");
                break;
            case "Mažionytė Indrė":
                selection("prof","168");
                break;
            case "Mickus Alvydas":
                selection("prof","158");
                break;
            case "Mockienė Aldona":
                selection("prof","2");
                break;
            case "Morkūnienė Rimantė":
                selection("prof","43");
                break;
            case "Morkūnienė Sonata":
                selection("prof","104");
                break;
            case "Muranovaitė Rūta":
                selection("prof","186");
                break;
            case "Narbutė Jūratė":
                selection("prof","40");
                break;
            case "Narutavičiūtė Evelina":
                selection("prof","62");
                break;
            case "Narvilienė Daiva":
                selection("prof","14");
                break;
            case "Nikolajevienė Aušra":
                selection("prof","13");
                break;
            case "Norbutaitė Asta":
                selection("prof","35");
                break;
            case "Pakalniškienė Jūratė":
                selection("prof","105");
                break;
            case "Pakštytė Aušra":
                selection("prof","106");
                break;
            case "Palijanskė Ugnė":
                selection("prof","137");
                break;
            case "Penkauskaitė Lina":
                selection("prof","107");
                break;
            case "Petrauskas Remigijus":
                selection("prof","49");
                break;
            case "Piekuvienė Vaida":
                selection("prof","100");
                break;
            case "Piklaps Arnoldas":
                selection("prof","159");
                break;
            case "Pleskonosova Irina":
                selection("prof","184");
                break;
            case "Pocienė Kristina":
                selection("prof","109");
                break;
            case "Pocienė Monika":
                selection("prof","56");
                break;
            case "Pocienė V.":
                selection("prof","170");
                break;
            case "Poimanskienė Vida":
                selection("prof","11");
                break;
            case "Poškienė Gintarė":
                selection("prof","132");
                break;
            case "Pranauskienė Dovilė":
                selection("prof","110");
                break;
            case "Pudžemienė Ernesta":
                selection("prof","111");
                break;
            case "Račkauskienė Skaidrė":
                selection("prof","112");
                break;
            case "Radavičienė A.":
                selection("prof","73");
                break;
            case "Ramanauskas Rimantas":
                selection("prof","113");
                break;
            case "Ramanauskienė Sigita":
                selection("prof","160");
                break;
            case "Razgutė Dovilė":
                selection("prof","131");
                break;
            case "Remeikienė Jurgita":
                selection("prof","136");
                break;
            case "Rimgailaitė A.":
                selection("prof","166");
                break;
            case "Rimkuvienė Daliuta":
                selection("prof","57");
                break;
            case "Romeraitė-Kuklierienė Laura":
                selection("prof","25");
                break;
            case "Rudžianskienė Aušra":
                selection("prof","60");
                break;
            case "Saudargė Odeta":
                selection("prof","114");
                break;
            case "Simonaitienė Gintarė":
                selection("prof","165");
                break;
            case "Sirtautaitė Ksavera":
                selection("prof","30");
                break;
            case "Smagurienė Aida":
                selection("prof","115");
                break;
            case "Spiriajevienė Irma":
                selection("prof","154");
                break;
            case "Stančaitytė Daiva":
                selection("prof","29");
                break;
            case "Staniulienė Vida":
                selection("prof","3");
                break;
            case "Stankaitienė Diana":
                selection("prof","45");
                break;
            case "Staražinskienė Aušra":
                selection("prof","71");
                break;
            case "Stončienė Vida":
                selection("prof","54");
                break;
            case "Stonkienė Asta":
                selection("prof","116");
                break;
            case "Stonkutė Renata":
                selection("prof","117");
                break;
            case "Stoukuvienė Žaneta":
                selection("prof","178");
                break;
            case "Stratkauskienė Rūta":
                selection("prof","172");
                break;
            case "Šatienė Salomėja":
                selection("prof","46");
                break;
            case "Šereikienė Vida":
                selection("prof","24");
                break;
            case "Šiaulinskienė R.":
                selection("prof","175");
                break;
            case "Šilanskaitė Jolita":
                selection("prof","148");
                break;
            case "Šlepetienė Asta":
                selection("prof","118");
                break;
            case "Šniepienė Gražina":
                selection("prof","22");
                break;
            case "Šoparienė Raimonda":
                selection("prof","119");
                break;
            case "Šostakienė Nijolė":
                selection("prof","120");
                break;
            case "Špiliauskaitė J":
                selection("prof","121");
                break;
            case "Šukienė Ingrida":
                selection("prof","6");
                break;
            case "Šulcaitė-Vasiljeva Mercedes":
                selection("prof","26");
                break;
            case "Šumskienė Aldona":
                selection("prof","39");
                break;
            case "Šutrajevienė Daina":
                selection("prof","4");
                break;
            case "Tauraitė-Janušauskienė Gitana":
                selection("prof","122");
                break;
            case "Trumpulytė Martyna":
                selection("prof","174");
                break;
            case "Urbonas Vincas":
                selection("prof","19");
                break;
            case "Urbonienė Dijana":
                selection("prof","48");
                break;
            case "Uselienė Daiva":
                selection("prof","20");
                break;
            case "Vaitiekienė Jurgita":
                selection("prof","123");
                break;
            case "Vaitkuvienė Jolanta":
                selection("prof","124");
                break;
            case "Valaitienė Aurelija":
                selection("prof","125");
                break;
            case "Valatkienė Dovilė":
                selection("prof","55");
                break;
            case "Valeckienė Ina":
                selection("prof","156");
                break;
            case "Venevičienė Viktorija":
                selection("prof","72");
                break;
            case "Vilčinskienė Irena":
                selection("prof","180");
                break;
            case "Viluckienė Jolita":
                selection("prof","182");
                break;
            case "Virbalienė Akvilė":
                selection("prof","33");
                break;
            case "Virbalis Tomas":
                selection("prof","34");
                break;
            case "Virketienė Diana":
                selection("prof","135");
                break;
            case "Vyšniauskas Julius":
                selection("prof","67");
                break;
            case "Zabitienė Rūta":
                selection("prof","94");
                break;
            case "Zavackienė Anželika":
                selection("prof","12");
                break;
            case "Zelenienė Irina":
                selection("prof","133");
                break;
            case "Zuzaitė Nijolė":
                selection("prof","18");
                break;
            case "Žakaitis Povilas":
                selection("prof","149");
                break;
            case "Žebrauskaitė Aurelija":
                selection("prof","126");
                break;
            case "Žernienė Aušra":
                selection("prof","127");
                break;
            case "Žičkuvienė Kristina":
                selection("prof","128");
                break;
            case "Žydžiūnaitė Vilma":
                selection("prof","7");
                break;
            case "Žymantienė Eglė":
                selection("prof","108");
                break;
            case "Žubrickienė Irena":
                selection("prof","61");
                break;
            case "Žukauskienė D.":
                selection("prof","173");
                break;
            case "Žulpienė Loreta":
                selection("prof","129");
                break;
            case "Žuravliova Olesia":
                selection("prof","130");
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
