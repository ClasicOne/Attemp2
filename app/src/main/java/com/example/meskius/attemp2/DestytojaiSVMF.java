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
public class DestytojaiSVMF extends AppCompatActivity{

    WebView ww;
    String profText[] = {"--pasirinkti--","Abunevičius Romas","Albrechtienė Kristina","Altuchova Aida","Andriuškevičiūtė Gerda","Andruška Marius","Andruškienė Jurgita","Arlauskienė Renata","Arnašiūtė Roberta","Auglienė A.","Bačiulienė Kristina","Bagdonienė Irena","Bardžiukienė Elytė","Barsevičienė Šarūnė","Barzdžiukienė Elytė","Beinorienė Jūratė","Bertašiūtė A.","Beržanskienė Justė","Bikuličienė Roberta","Bylaitė-Žakaitienė Andželika","Boltutienė Jurgita","Buivydaitė Eglė","Bumbliauskytė Dalia","Burdulis Dainius","Čekmariova J.","Dambrauskaitė Angelija","Dambrauskienė Nijolė","Danieliienė Jūratė","Daubarienė Jolanda","Daukantienė Danutė","Dėdinienė Ingrida","Derkintienė Jūratė","Dudėnė Jurgita","Dvarionaitė Lijana","Einars Bronius","Eismontienė Jekaterina","Freitakaitė V.","Gaižauskienė Ina","Galčionkova Ana","Galdikienė Nijolė","Gedrimė Lina","Gedrimienė Bernadeta","Gedvilienė L.","Giedraitienė Neringa","Girdžiūnienė Rasa","Indriuškienė Rasa","Jakubaitienė Vanda","Jankauskienė Rita","Janušas Leonas","Jonelienė Romena","Jonelys Valdas","Juknevičienė Aurelija","Juodienė Stasė","Juškienė Vaineta","Karpavičė Irma","Karpavičiūtė Solmita","Karžauskienė Edita","Kasnauskienė Jolanta","Kasperavičiūtė Simona","Kaunienė Jūratė","Kemzūrienė Deimantė","Kraniauskas Liutauras","Kraniauskienė Sigita","Kreišmonienė Jolanta","Kreivinienė B.","Kukštienė Viktorija","Lenčiauskienė Daiva","Letkauskaitė Kristina","Levickienė L.","Levickytė Greta","Levuškinas 0.","Liukienė Ramunė","Maniušienė Margarita","Mataitienė Angelija","Mauricaitė Ugnė","Mažionienė Asta","Mažionytė Indrė","Mickus Alvydas","Mockienė Aldona","Morkūnienė Rimantė","Morkūnienė Sonata","Muranovaitė Rūta","Narbutė Jūratė","Narutavičiūtė Evelina","Narvilienė Daiva","Nikolajevienė Aušra","Norbutaitė Asta","Pakalniškienė Jūratė","Pakštytė Aušra","Palijanskė Ugnė","Penkauskaitė Lina","Petrauskas Remigijus","Piekuvienė Vaida","Piklaps Arnoldas","Pleskonosova Irina","Pocienė Kristina","Pocienė Monika","Pocienė V.","Poimanskienė Vida","Poškienė Gintarė","Pranauskienė Dovilė","Pudžemienė Ernesta","Račkauskienė Skaidrė","Radavičienė A.","Ramanauskas Rimantas","Ramanauskienė Sigita","Razgutė Dovilė","Remeikienė Jurgita","Rimgailaitė A.","Rimkuvienė Daliuta","Romeraitė-Kuklierienė Laura","Rudžianskienė Aušra","Saudargė Odeta","Simonaitienė Gintarė","Sirtautaitė Ksavera","Smagurienė Aida","Spiriajevienė Irma","Stančaitytė Daiva","Staniulienė Vida","Stankaitienė Diana","Staražinskienė Aušra","Stončienė Vida","Stonkienė Asta","Stonkutė Renata","Stoukuvienė Žaneta","Stratkauskienė Rūta","Šatienė Salomėja","Šereikienė Vida","Šiaulinskienė R.","Šilanskaitė Jolita","Šlepetienė Asta","Šniepienė Gražina","Šoparienė Raimonda","Šostakienė Nijolė","Špiliauskaitė J","Šukienė Ingrida","Šulcaitė-Vasiljeva Mercedes","Šumskienė Aldona","Šutrajevienė Daina","Tauraitė-Janušauskienė Gitana","Trumpulytė Martyna","Urbonas Vincas","Urbonienė Dijana","Uselienė Daiva","Vaitiekienė Jurgita","Vaitkuvienė Jolanta","Valaitienė Aurelija","Valatkienė Dovilė","Valeckienė Ina","Venevičienė Viktorija","Vilčinskienė Irena","Viluckienė Jolita","Virbalienė Akvilė","Virbalis Tomas","Virketienė Diana","Vyšniauskas Julius","Zabitienė Rūta","Zavackienė Anželika","Zelenienė Irina","Zuzaitė Nijolė","Žakaitis Povilas","Žebrauskaitė Aurelija","Žernienė Aušra","Žičkuvienė Kristina","Žydžiūnaitė Vilma","Žymantienė Eglė","Žubrickienė Irena","Žukauskienė D.","Žulpienė Loreta","Žuravliova Olesia"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destytojai_svmf);

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
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/prof.php");
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
                Intent intent = new Intent(DestytojaiSVMF.this,SVMFMenu.class);
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
                click();
                break;
            case "Albrechtienė Kristina":
                selection("prof","78");
                click();
                break;
            case "Altuchova Aida":
                selection("prof","79");
                click();
                break;
            case "Andriuškevičiūtė Gerda":
                selection("prof","176");
                click();
                break;
            case "Andruška Marius":
                selection("prof","141");
                click();
                break;
            case "Andruškienė Jurgita":
                selection("prof","37");
                click();
                break;
            case "Arlauskienė Renata":
                selection("prof","183");
                click();
                break;
            case "Arnašiūtė Roberta":
                selection("prof","80");
                click();
                break;
            case "Auglienė A.":
                selection("prof","161");
                click();
                break;
            case "Bačiulienė Kristina":
                selection("prof","81");
                click();
                break;
            case "Bagdonienė Irena":
                selection("prof","181");
                click();
                break;
            /*case "Bagdonienė Irena":
                selection("prof","181");
                click();
                break;*/
            case "Bardžiukienė Elytė":
                selection("prof","16");
                click();
                break;
            case "Barsevičienė Šarūnė":
                selection("prof","32");
                click();
                break;
            case "Barzdžiukienė Elytė":
                selection("prof","36");
                click();
                break;
            case "Beinorienė Jūratė":
                selection("prof","83");
                click();
                break;
            case "Bertašiūtė A.":
                selection("prof","143");
                click();
                break;
            case "Beržanskienė Justė":
                selection("prof","70");
                click();
                break;
            case "Bikuličienė Roberta":
                selection("prof","164");
                click();
                break;
            case "Bylaitė-Žakaitienė Andželika":
                selection("prof","84");
                click();
                break;
            case "Boltutienė Jurgita":
                selection("prof","50");
                click();
                break;
            case "Buivydaitė Eglė":
                selection("prof","85");
                click();
                break;
            case "Bumbliauskytė Dalia":
                selection("prof","86");
                click();
                break;
            case "Burdulis Dainius":
                selection("prof","87");
                click();
                break;
            case "Čekmariova J.":
                selection("prof","169");
                click();
                break;
            case "Dambrauskaitė Angelija":
                selection("prof","69");
                click();
                break;
            case "Dambrauskienė Nijolė":
                selection("prof","88");
                click();
                break;
            case "Danieliienė Jūratė":
                selection("prof","179");
                click();
                break;
            case "Daubarienė Jolanda":
                selection("prof","185");
                click();
                break;
            case "Daukantienė Danutė":
                selection("prof","89");
                click();
                break;
            case "Dėdinienė Ingrida":
                selection("prof","90");
                click();
                break;
            case "Derkintienė Jūratė":
                selection("prof","163");
                click();
                break;
            case "Dudėnė Jurgita":
                selection("prof","134");
                click();
                break;
            case "Dvarionaitė Lijana":
                selection("prof","63");
                click();
                break;
            case "Einars Bronius":
                selection("prof","68");
                click();
                break;
            case "Eismontienė Jekaterina":
                selection("prof","91");
                click();
                break;
            case "Enzelienė Renata":
                selection("prof","144");
                click();
                break;
            /*case "Enzelienė Renata":
                selection("prof","145");
                click();
                break;*/
            case "Freitakaitė V.":
                selection("prof","146");
                click();
                break;
            /*case "Freitakaitė V.":
                selection("prof","147");
                click();
                break;*/
            case "Gaižauskienė Ina":
                selection("prof","74");
                click();
                break;
            case "Galčionkova Ana":
                selection("prof","92");
                click();
                break;
            case "Galdikienė Nijolė":
                selection("prof","93");
                click();
                break;
            case "Gedrimė Lina":
                selection("prof","47");
                click();
                break;
            case "Gedrimienė Bernadeta":
                selection("prof","76");
                click();
                break;
            case "Gedvilienė L.":
                selection("prof","162");
                click();
                break;
            case "Giedraitienė Neringa":
                selection("prof","75");
                click();
                break;
            case "Girdžiūnienė Rasa":
                selection("prof","21");
                click();
                break;
            case "Indriuškienė Rasa":
                selection("prof","177");
                click();
                break;
            case "Jakubaitienė Vanda":
                selection("prof","23");
                click();
                break;
            case "Jankauskienė Rita":
                selection("prof","53");
                click();
                break;
            case "Janušas Leonas":
                selection("prof","95");
                click();
                break;
            case "Jonelienė Romena":
                selection("prof","140");
                click();
                break;
            case "Jonelys Valdas":
                selection("prof","96");
                click();
                break;
            case "Juknevičienė Aurelija":
                selection("prof","97");
                click();
                break;
            case "Juodienė Stasė":
                selection("prof","98");
                click();
                break;
            case "Juškienė Vaineta":
                selection("prof","99");
                click();
                break;
            case "Karpavičė Irma":
                selection("prof","187");
                click();
                break;
            case "Karpavičiūtė Solmita":
                selection("prof","59");
                click();
                break;
            case "Karžauskienė Edita":
                selection("prof","167");
                click();
                break;
            case "Kasnauskienė Jolanta":
                selection("prof","42");
                click();
                break;
            case "Kasperavičiūtė Simona":
                selection("prof","31");
                click();
                break;
            case "Kaunienė Jūratė":
                selection("prof","51");
                click();
                break;
            case "Kemzūrienė Deimantė":
                selection("prof","41");
                click();
                break;
            case "Kraniauskas Liutauras":
                selection("prof","155");
                click();
                break;
            case "Kraniauskienė Sigita":
                selection("prof","58");
                click();
                break;
            case "Kreišmonienė Jolanta":
                selection("prof","171");
                click();
                break;
            case "Kreivinienė B.":
                selection("prof","157");
                click();
                break;
            case "Kukštienė Viktorija":
                selection("prof","28");
                click();
                break;
            case "Lenčiauskienė Daiva":
                selection("prof","52");
                click();
                break;
            case "Letkauskaitė Kristina":
                selection("prof","27");
                click();
                break;
            case "Levickienė L.":
                selection("prof","142");
                click();
                break;
            case "Levickytė Greta":
                selection("prof","101");
                click();
                break;
            case "Levuškinas 0.":
                selection("prof","139");
                click();
                break;
            case "Liukienė Ramunė":
                selection("prof","44");
                click();
                break;
            case "Maniušienė Margarita":
                selection("prof","65");
                click();
                break;
            case "Mataitienė Angelija":
                selection("prof","102");
                click();
                break;
            case "Mauricaitė Ugnė":
                selection("prof","103");
                click();
                break;
            case "Mažionienė Asta":
                selection("prof","8");
                click();
                break;
            case "Mažionytė Indrė":
                selection("prof","168");
                click();
                break;
            case "Mickus Alvydas":
                selection("prof","158");
                click();
                break;
            case "Mockienė Aldona":
                selection("prof","2");
                click();
                break;
            case "Morkūnienė Rimantė":
                selection("prof","43");
                click();
                break;
            case "Morkūnienė Sonata":
                selection("prof","104");
                click();
                break;
            case "Muranovaitė Rūta":
                selection("prof","186");
                click();
                break;
            case "Narbutė Jūratė":
                selection("prof","40");
                click();
                break;
            case "Narutavičiūtė Evelina":
                selection("prof","62");
                click();
                break;
            case "Narvilienė Daiva":
                selection("prof","14");
                click();
                break;
            case "Nikolajevienė Aušra":
                selection("prof","13");
                click();
                break;
            case "Norbutaitė Asta":
                selection("prof","35");
                click();
                break;
            case "Pakalniškienė Jūratė":
                selection("prof","105");
                click();
                break;
            case "Pakštytė Aušra":
                selection("prof","106");
                click();
                break;
            case "Palijanskė Ugnė":
                selection("prof","137");
                click();
                break;
            case "Penkauskaitė Lina":
                selection("prof","107");
                click();
                break;
            case "Petrauskas Remigijus":
                selection("prof","49");
                click();
                break;
            case "Piekuvienė Vaida":
                selection("prof","100");
                click();
                break;
            case "Piklaps Arnoldas":
                selection("prof","159");
                click();
                break;
            case "Pleskonosova Irina":
                selection("prof","184");
                click();
                break;
            case "Pocienė Kristina":
                selection("prof","109");
                click();
                break;
            case "Pocienė Monika":
                selection("prof","56");
                click();
                break;
            case "Pocienė V.":
                selection("prof","170");
                click();
                break;
            case "Poimanskienė Vida":
                selection("prof","11");
                click();
                break;
            case "Poškienė Gintarė":
                selection("prof","132");
                click();
                break;
            case "Pranauskienė Dovilė":
                selection("prof","110");
                click();
                break;
            case "Pudžemienė Ernesta":
                selection("prof","111");
                click();
                break;
            case "Račkauskienė Skaidrė":
                selection("prof","112");
                click();
                break;
            case "Radavičienė A.":
                selection("prof","73");
                click();
                break;
            case "Ramanauskas Rimantas":
                selection("prof","113");
                click();
                break;
            case "Ramanauskienė Sigita":
                selection("prof","160");
                click();
                break;
            case "Razgutė Dovilė":
                selection("prof","131");
                click();
                break;
            case "Remeikienė Jurgita":
                selection("prof","136");
                click();
                break;
            case "Rimgailaitė A.":
                selection("prof","166");
                click();
                break;
            case "Rimkuvienė Daliuta":
                selection("prof","57");
                click();
                break;
            case "Romeraitė-Kuklierienė Laura":
                selection("prof","25");
                click();
                break;
            case "Rudžianskienė Aušra":
                selection("prof","60");
                click();
                break;
            case "Saudargė Odeta":
                selection("prof","114");
                click();
                break;
            case "Simonaitienė Gintarė":
                selection("prof","165");
                click();
                break;
            case "Sirtautaitė Ksavera":
                selection("prof","30");
                click();
                break;
            case "Smagurienė Aida":
                selection("prof","115");
                click();
                break;
            case "Spiriajevienė Irma":
                selection("prof","154");
                click();
                break;
            case "Stančaitytė Daiva":
                selection("prof","29");
                click();
                break;
            case "Staniulienė Vida":
                selection("prof","3");
                click();
                break;
            case "Stankaitienė Diana":
                selection("prof","45");
                click();
                break;
            case "Staražinskienė Aušra":
                selection("prof","71");
                click();
                break;
            case "Stončienė Vida":
                selection("prof","54");
                click();
                break;
            case "Stonkienė Asta":
                selection("prof","116");
                click();
                break;
            case "Stonkutė Renata":
                selection("prof","117");
                click();
                break;
            case "Stoukuvienė Žaneta":
                selection("prof","178");
                click();
                break;
            case "Stratkauskienė Rūta":
                selection("prof","172");
                click();
                break;
            case "Šatienė Salomėja":
                selection("prof","46");
                click();
                break;
            case "Šereikienė Vida":
                selection("prof","24");
                click();
                break;
            case "Šiaulinskienė R.":
                selection("prof","175");
                click();
                break;
            case "Šilanskaitė Jolita":
                selection("prof","148");
                click();
                break;
            case "Šlepetienė Asta":
                selection("prof","118");
                click();
                break;
            case "Šniepienė Gražina":
                selection("prof","22");
                click();
                break;
            case "Šoparienė Raimonda":
                selection("prof","119");
                click();
                break;
            case "Šostakienė Nijolė":
                selection("prof","120");
                click();
                break;
            case "Špiliauskaitė J":
                selection("prof","121");
                click();
                break;
            case "Šukienė Ingrida":
                selection("prof","6");
                click();
                break;
            case "Šulcaitė-Vasiljeva Mercedes":
                selection("prof","26");
                click();
                break;
            case "Šumskienė Aldona":
                selection("prof","39");
                click();
                break;
            case "Šutrajevienė Daina":
                selection("prof","4");
                click();
                break;
            case "Tauraitė-Janušauskienė Gitana":
                selection("prof","122");
                click();
                break;
            case "Trumpulytė Martyna":
                selection("prof","174");
                click();
                break;
            case "Urbonas Vincas":
                selection("prof","19");
                click();
                break;
            case "Urbonienė Dijana":
                selection("prof","48");
                click();
                break;
            case "Uselienė Daiva":
                selection("prof","20");
                click();
                break;
            case "Vaitiekienė Jurgita":
                selection("prof","123");
                click();
                break;
            case "Vaitkuvienė Jolanta":
                selection("prof","124");
                click();
                break;
            case "Valaitienė Aurelija":
                selection("prof","125");
                click();
                break;
            case "Valatkienė Dovilė":
                selection("prof","55");
                click();
                break;
            case "Valeckienė Ina":
                selection("prof","156");
                click();
                break;
            case "Venevičienė Viktorija":
                selection("prof","72");
                click();
                break;
            case "Vilčinskienė Irena":
                selection("prof","180");
                click();
                break;
            case "Viluckienė Jolita":
                selection("prof","182");
                click();
                break;
            case "Virbalienė Akvilė":
                selection("prof","33");
                click();
                break;
            case "Virbalis Tomas":
                selection("prof","34");
                click();
                break;
            case "Virketienė Diana":
                selection("prof","135");
                click();
                break;
            case "Vyšniauskas Julius":
                selection("prof","67");
                click();
                break;
            case "Zabitienė Rūta":
                selection("prof","94");
                click();
                break;
            case "Zavackienė Anželika":
                selection("prof","12");
                click();
                break;
            case "Zelenienė Irina":
                selection("prof","133");
                click();
                break;
            case "Zuzaitė Nijolė":
                selection("prof","18");
                click();
                break;
            case "Žakaitis Povilas":
                selection("prof","149");
                click();
                break;
            case "Žebrauskaitė Aurelija":
                selection("prof","126");
                click();
                break;
            case "Žernienė Aušra":
                selection("prof","127");
                click();
                break;
            case "Žičkuvienė Kristina":
                selection("prof","128");
                click();
                break;
            case "Žydžiūnaitė Vilma":
                selection("prof","7");
                click();
                break;
            case "Žymantienė Eglė":
                selection("prof","108");
                click();
                break;
            case "Žubrickienė Irena":
                selection("prof","61");
                click();
                break;
            case "Žukauskienė D.":
                selection("prof","173");
                click();
                break;
            case "Žulpienė Loreta":
                selection("prof","129");
                click();
                break;
            case "Žuravliova Olesia":
                selection("prof","130");
                click();
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
