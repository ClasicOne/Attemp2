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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Meskius on 10/25/2017.
 */
/*function b(){for(var i=0;i<document.querySelectorAll('#prof option').length;i++){
        str += '"'+document.querySelectorAll('#prof option')[i].innerText+'",';}}*/
public class DestytojaiSVMF extends AppCompatActivity{
    GrupesSVMF g;
    WebView ww;
    String profText[] = {"--pasirinkti--","Abunevičius Romas","Albrechtienė Kristina","Altuchova Aida","Andriuškevičiūtė Gerda","Andruška Marius","Andruškienė Jurgita","Arlauskienė Renata","Arnašiūtė Roberta","Auglienė A.","Bačiulienė Kristina","Bagdonienė Irena","Bagdonienė Irena","Bardžiukienė Elytė","Barsevičienė Šarūnė","Barzdžiukienė Elytė","Beinorienė Jūratė","Bertašiūtė A.","Beržanskienė Justė","Bikuličienė Roberta","Bylaitė-Žakaitienė Andželika","Boltutienė Jurgita","Buivydaitė Eglė","Bumbliauskytė Dalia","Burdulis Dainius","Čekmariova J.","Dambrauskaitė Angelija","Dambrauskienė Nijolė","Danieliienė Jūratė","Daubarienė Jolanda","Daukantienė Danutė","Dėdinienė Ingrida","Derkintienė Jūratė","Dudėnė Jurgita","Dvarionaitė Lijana","Einars Bronius","Eismontienė Jekaterina","Enzelienė Renata","Enzelienė Renata","Freitakaitė V.","Freitakaitė V.","Gaižauskienė Ina","Galčionkova Ana","Galdikienė Nijolė","Gedrimė Lina","Gedrimienė Bernadeta","Gedvilienė L.","Giedraitienė Neringa","Girdžiūnienė Rasa","Indriuškienė Rasa","Jakubaitienė Vanda","Jankauskienė Rita","Janušas Leonas","Jonelienė Romena","Jonelys Valdas","Juknevičienė Aurelija","Juodienė Stasė","Juškienė Vaineta","Karpavičė Irma","Karpavičiūtė Solmita","Karžauskienė Edita","Kasnauskienė Jolanta","Kasperavičiūtė Simona","Kaunienė Jūratė","Kemzūrienė Deimantė","Kraniauskas Liutauras","Kraniauskienė Sigita","Kreišmonienė Jolanta","Kreivinienė B.","Kukštienė Viktorija","Lenčiauskienė Daiva","Letkauskaitė Kristina","Levickienė L.","Levickytė Greta","Levuškinas 0.","Liukienė Ramunė","Maniušienė Margarita","Mataitienė Angelija","Mauricaitė Ugnė","Mažionienė Asta","Mažionytė Indrė","Mickus Alvydas","Mockienė Aldona","Morkūnienė Rimantė","Morkūnienė Sonata","Muranovaitė Rūta","Narbutė Jūratė","Narutavičiūtė Evelina","Narvilienė Daiva","Nikolajevienė Aušra","Norbutaitė Asta","Pakalniškienė Jūratė","Pakštytė Aušra","Palijanskė Ugnė","Penkauskaitė Lina","Petrauskas Remigijus","Piekuvienė Vaida","Piklaps Arnoldas","Pleskonosova Irina","Pocienė Kristina","Pocienė Monika","Pocienė V.","Poimanskienė Vida","Poškienė Gintarė","Pranauskienė Dovilė","Pudžemienė Ernesta","Račkauskienė Skaidrė","Radavičienė A.","Ramanauskas Rimantas","Ramanauskienė Sigita","Razgutė Dovilė","Remeikienė Jurgita","Rimgailaitė A.","Rimkuvienė Daliuta","Romeraitė-Kuklierienė Laura","Rudžianskienė Aušra","Saudargė Odeta","Simonaitienė Gintarė","Sirtautaitė Ksavera","Smagurienė Aida","Spiriajevienė Irma","Stančaitytė Daiva","Staniulienė Vida","Stankaitienė Diana","Staražinskienė Aušra","Stončienė Vida","Stonkienė Asta","Stonkutė Renata","Stoukuvienė Žaneta","Stratkauskienė Rūta","Šatienė Salomėja","Šereikienė Vida","Šiaulinskienė R.","Šilanskaitė Jolita","Šlepetienė Asta","Šniepienė Gražina","Šoparienė Raimonda","Šostakienė Nijolė","Špiliauskaitė J","Šukienė Ingrida","Šulcaitė-Vasiljeva Mercedes","Šumskienė Aldona","Šutrajevienė Daina","Tauraitė-Janušauskienė Gitana","Trumpulytė Martyna","Urbonas Vincas","Urbonienė Dijana","Uselienė Daiva","Vaitiekienė Jurgita","Vaitkuvienė Jolanta","Valaitienė Aurelija","Valatkienė Dovilė","Valeckienė Ina","Venevičienė Viktorija","Vilčinskienė Irena","Viluckienė Jolita","Virbalienė Akvilė","Virbalis Tomas","Virketienė Diana","Vyšniauskas Julius","Zabitienė Rūta","Zavackienė Anželika","Zelenienė Irina","Zuzaitė Nijolė","Žakaitis Povilas","Žebrauskaitė Aurelija","Žernienė Aušra","Žičkuvienė Kristina","Žydžiūnaitė Vilma","Žymantienė Eglė","Žubrickienė Irena","Žukauskienė D.","Žulpienė Loreta","Žuravliova Olesia"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destytojai_svmf);
        setContentView(R.layout.destytojai_tf);
        Intent intent= getIntent();
        final Spinner profID = (Spinner)findViewById(R.id.profID);
        Button backID = (Button)findViewById(R.id.backDTF);
        //Button auditorijos =(Button)findViewById(R.id.auditorijD);
        Button refreshID = (Button)findViewById(R.id.refreshID);

        g.spinner(profText,profID);


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
        backID.setOnClickListener(new View.OnClickListener() {
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
                g.selection("group","64");
                break;
            case "Albrechtienė Kristina":
                g.selection("group","78");
                break;
            case "Altuchova Aida":
                g.selection("group","79");
                break;
            case "Andriuškevičiūtė Gerda":
                g.selection("group","176");
                break;
            case "Andruška Marius":
                g.selection("group","141");
                break;
            case "Andruškienė Jurgita":
                g.selection("group","37");
                break;
            case "Arlauskienė Renata":
                g.selection("group","183");
                break;
            case "Arnašiūtė Roberta":
                g.selection("group","80");
                break;
            case "Auglienė A.":
                g.selection("group","161");
                break;
            case "Bačiulienė Kristina":
                g.selection("group","81");
                break;
            case "Bagdonienė Irena":
                g.selection("group","82");
                break;
            case "Bagdonienė Irena":
                g.selection("group","181");
                break;
            case "Bardžiukienė Elytė":
                g.selection("group","16");
                break;
            case "Barsevičienė Šarūnė":
                g.selection("group","32");
                break;
            case "Barzdžiukienė Elytė":
                g.selection("group","36");
                break;
            case "Beinorienė Jūratė":
                g.selection("group","83");
                break;
            case "Bertašiūtė A.":
                g.selection("group","143");
                break;
            case "Beržanskienė Justė":
                g.selection("group","70");
                break;
            case "Bikuličienė Roberta":
                g.selection("group","164");
                break;
            case "Bylaitė-Žakaitienė Andželika":
                g.selection("group","84");
                break;
            case "Boltutienė Jurgita":
                g.selection("group","50");
                break;
            case "Buivydaitė Eglė":
                g.selection("group","85");
                break;
            case "Bumbliauskytė Dalia":
                g.selection("group","86");
                break;
            case "Burdulis Dainius":
                g.selection("group","87");
                break;
            case "Čekmariova J.":
                g.selection("group","169");
                break;
            case "Dambrauskaitė Angelija":
                g.selection("group","69");
                break;
            case "Dambrauskienė Nijolė":
                g.selection("group","88");
                break;
            case "Danieliienė Jūratė":
                g.selection("group","179");
                break;
            case "Daubarienė Jolanda":
                g.selection("group","185");
                break;
            case "Daukantienė Danutė":
                g.selection("group","89");
                break;
            case "Dėdinienė Ingrida":
                g.selection("group","90");
                break;
            case "Derkintienė Jūratė":
                g.selection("group","163");
                break;
            case "Dudėnė Jurgita":
                g.selection("group","134");
                break;
            case "Dvarionaitė Lijana":
                g.selection("group","63");
                break;
            case "Einars Bronius":
                g.selection("group","68");
                break;
            case "Eismontienė Jekaterina":
                g.selection("group","91");
                break;
            case "Enzelienė Renata":
                g.selection("group","144");
                break;
            case "Enzelienė Renata":
                g.selection("group","145");
                break;
            case "Freitakaitė V.":
                g.selection("group","146");
                break;
            case "Freitakaitė V.":
                g.selection("group","147");
                break;
            case "Gaižauskienė Ina":
                g.selection("group","74");
                break;
            case "Galčionkova Ana":
                g.selection("group","92");
                break;
            case "Galdikienė Nijolė":
                g.selection("group","93");
                break;
            case "Gedrimė Lina":
                g.selection("group","47");
                break;
            case "Gedrimienė Bernadeta":
                g.selection("group","76");
                break;
            case "Gedvilienė L.":
                g.selection("group","162");
                break;
            case "Giedraitienė Neringa":
                g.selection("group","75");
                break;
            case "Girdžiūnienė Rasa":
                g.selection("group","21");
                break;
            case "Indriuškienė Rasa":
                g.selection("group","177");
                break;
            case "Jakubaitienė Vanda":
                g.selection("group","23");
                break;
            case "Jankauskienė Rita":
                g.selection("group","53");
                break;
            case "Janušas Leonas":
                g.selection("group","95");
                break;
            case "Jonelienė Romena":
                g.selection("group","140");
                break;
            case "Jonelys Valdas":
                g.selection("group","96");
                break;
            case "Juknevičienė Aurelija":
                g.selection("group","97");
                break;
            case "Juodienė Stasė":
                g.selection("group","98");
                break;
            case "Juškienė Vaineta":
                g.selection("group","99");
                break;
            case "Karpavičė Irma":
                g.selection("group","187");
                break;
            case "Karpavičiūtė Solmita":
                g.selection("group","59");
                break;
            case "Karžauskienė Edita":
                g.selection("group","167");
                break;
            case "Kasnauskienė Jolanta":
                g.selection("group","42");
                break;
            case "Kasperavičiūtė Simona":
                g.selection("group","31");
                break;
            case "Kaunienė Jūratė":
                g.selection("group","51");
                break;
            case "Kemzūrienė Deimantė":
                g.selection("group","41");
                break;
            case "Kraniauskas Liutauras":
                g.selection("group","155");
                break;
            case "Kraniauskienė Sigita":
                g.selection("group","58");
                break;
            case "Kreišmonienė Jolanta":
                g.selection("group","171");
                break;
            case "Kreivinienė B.":
                g.selection("group","157");
                break;
            case "Kukštienė Viktorija":
                g.selection("group","28");
                break;
            case "Lenčiauskienė Daiva":
                g.selection("group","52");
                break;
            case "Letkauskaitė Kristina":
                g.selection("group","27");
                break;
            case "Levickienė L.":
                g.selection("group","142");
                break;
            case "Levickytė Greta":
                g.selection("group","101");
                break;
            case "Levuškinas 0.":
                g.selection("group","139");
                break;
            case "Liukienė Ramunė":
                g.selection("group","44");
                break;
            case "Maniušienė Margarita":
                g.selection("group","65");
                break;
            case "Mataitienė Angelija":
                g.selection("group","102");
                break;
            case "Mauricaitė Ugnė":
                g.selection("group","103");
                break;
            case "Mažionienė Asta":
                g.selection("group","8");
                break; case "Mažionytė Indrė":
                g.selection("group","168");
                break;
            case "Mickus Alvydas":
                g.selection("group","158");
                break;
            case "Mockienė Aldona":
                g.selection("group","2");
                break;
            case "Morkūnienė Rimantė":
                g.selection("group","43");
                break;
            case "Morkūnienė Sonata":
                g.selection("group","104");
                break;
            case "Muranovaitė Rūta":
                g.selection("group","186");
                break;
            case "Narbutė Jūratė":
                g.selection("group","40");
                break;
            case "Narutavičiūtė Evelina":
                g.selection("group","62");
                break;
            case "Narvilienė Daiva":
                g.selection("group","14");
                break;
            case "Nikolajevienė Aušra":
                g.selection("group","13");
                break;
            case "Norbutaitė Asta":
                g.selection("group","35");
                break;
            case "Pakalniškienė Jūratė":
                g.selection("group","105");
                break;
            case "Pakštytė Aušra":
                g.selection("group","106");
                break;
            case "Palijanskė Ugnė":
                g.selection("group","137");
                break;
            case "Penkauskaitė Lina":
                g.selection("group","107");
                break;
            case "Petrauskas Remigijus":
                g.selection("group","49");
                break;
            case "Piekuvienė Vaida":
                g.selection("group","100");
                break;
            case "Piklaps Arnoldas":
                g.selection("group","159");
                break;
            case "Pleskonosova Irina":
                g.selection("group","184");
                break;
            case "Pocienė Kristina":
                g.selection("group","109");
                break;
            case "Pocienė Monika":
                g.selection("group","56");
                break;
            case "Pocienė V.":
                g.selection("group","170");
                break;
            case "Poimanskienė Vida":
                g.selection("group","11");
                break;
            case "Poškienė Gintarė":
                g.selection("group","132");
                break;
            case "Pranauskienė Dovilė":
                g.selection("group","110");
                break;
            case "Pudžemienė Ernesta":
                g.selection("group","111");
                break;
            case "Račkauskienė Skaidrė":
                g.selection("group","112");
                break;
            case "Radavičienė A.":
                g.selection("group","73");
                break;
            case "Ramanauskas Rimantas":
                g.selection("group","113");
                break;
            case "Ramanauskienė Sigita":
                g.selection("group","160");
                break;
            case "Razgutė Dovilė":
                g.selection("group","131");
                break;
            case "Remeikienė Jurgita":
                g.selection("group","136");
                break;
            case "Rimgailaitė A.":
                g.selection("group","166");
                break;
            case "Rimkuvienė Daliuta":
                g.selection("group","57");
                break;
            case "Romeraitė-Kuklierienė Laura":
                g.selection("group","25");
                break;
            case "Rudžianskienė Aušra":
                g.selection("group","60");
                break;
            case "Saudargė Odeta":
                g.selection("group","114");
                break;
            case "Simonaitienė Gintarė":
                g.selection("group","165");
                break;
            case "Sirtautaitė Ksavera":
                g.selection("group","30");
                break;
            case "Smagurienė Aida":
                g.selection("group","115");
                break;
            case "Spiriajevienė Irma":
                g.selection("group","154");
                break;
            case "Stančaitytė Daiva":
                g.selection("group","29");
                break;
            case "Staniulienė Vida":
                g.selection("group","3");
                break;
            case "Stankaitienė Diana":
                g.selection("group","45");
                break;
            case "Staražinskienė Aušra":
                g.selection("group","71");
                break;
            case "Stončienė Vida":
                g.selection("group","54");
                break;
            case "Stonkienė Asta":
                g.selection("group","116");
                break;
            case "Stonkutė Renata":
                g.selection("group","117");
                break;
            case "Stoukuvienė Žaneta":
                g.selection("group","178");
                break;
            case "Stratkauskienė Rūta":
                g.selection("group","172");
                break;
            case "Šatienė Salomėja":
                g.selection("group","46");
                break;
            case "Šereikienė Vida":
                g.selection("group","24");
                break;
            case "Šiaulinskienė R.":
                g.selection("group","175");
                break;
            case "Šilanskaitė Jolita":
                g.selection("group","148");
                break;
            case "Šlepetienė Asta":
                g.selection("group","118");
                break;
            case "Šniepienė Gražina":
                g.selection("group","22");
                break;
            case "Šoparienė Raimonda":
                g.selection("group","119");
                break;
            case "Šostakienė Nijolė":
                g.selection("group","120");
                break;
            case "Špiliauskaitė J":
                g.selection("group","121");
                break;
            case "Šukienė Ingrida":
                g.selection("group","6");
                break;
            case "Šulcaitė-Vasiljeva Mercedes":
                g.selection("group","26");
                break;
            case "Šumskienė Aldona":
                g.selection("group","39");
                break;
            case "Šutrajevienė Daina":
                g.selection("group","4");
                break;
            case "Tauraitė-Janušauskienė Gitana":
                g.selection("group","122");
                break;
            case "Trumpulytė Martyna":
                g.selection("group","174");
                break;
            case "Urbonas Vincas":
                g.selection("group","19");
                break;
            case "Urbonienė Dijana":
                g.selection("group","48");
                break;
            case "Uselienė Daiva":
                g.selection("group","20");
                break;
            case "Vaitiekienė Jurgita":
                g.selection("group","123");
                break;
            case "Vaitkuvienė Jolanta":
                g.selection("group","124");
                break;
            case "Valaitienė Aurelija":
                g.selection("group","125");
                break;
            case "Valatkienė Dovilė":
                g.selection("group","55");
                break;
            case "Valeckienė Ina":
                g.selection("group","156");
                break;
            case "Venevičienė Viktorija":
                g.selection("group","72");
                break;
            case "Vilčinskienė Irena":
                g.selection("group","180");
                break;
            case "Viluckienė Jolita":
                g.selection("group","182");
                break;
            case "Virbalienė Akvilė":
                g.selection("group","33");
                break;
            case "Virbalis Tomas":
                g.selection("group","34");
                break;
            case "Virketienė Diana":
                g.selection("group","135");
                break;
            case "Vyšniauskas Julius":
                g.selection("group","67");
                break;
            case "Zabitienė Rūta":
                g.selection("group","94");
                break;
            case "Zavackienė Anželika":
                g.selection("group","12");
                break;
            case "Zelenienė Irina":
                g.selection("group","133");
                break;
            case "Zuzaitė Nijolė":
                g.selection("group","18");
                break;
            case "Žakaitis Povilas":
                g.selection("group","149");
                break;
            case "Žebrauskaitė Aurelija":
                g.selection("group","126");
                break;
            case "Žernienė Aušra":
                g.selection("group","127");
                break;
            case "Žičkuvienė Kristina":
                g.selection("group","128");
                break;
            case "Žydžiūnaitė Vilma":
                g.selection("group","7");
                break;
            case "Žymantienė Eglė":
                g.selection("group","108");
                break;
            case "Žubrickienė Irena":
                g.selection("group","61");
                break;
            case "Žukauskienė D.":
                g.selection("group","173");
                break;
            case "Žulpienė Loreta":
                g.selection("group","129")
                break;
            case "Žuravliova Olesia":
                g.selection("group","130");
                break;
            default:
                break;

        }
    }

    public void hideD(){
        //wwD.loadUrl("javascript:$(document.querySelector(\".hdrTable\")).hide()");
        wwD.loadUrl("javascript:$(document.querySelector(\".main_menu\")).hide()");
        wwD.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[0]).hide()");
        wwD.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr td table td table tbody tr td\")[2]).hide()");
        wwD.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[2]).hide()");
        wwD.loadUrl("javascript:$(document.querySelectorAll(\".hdrTable tbody tr\")[3]).hide()");
        wwD.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr button\")[0]).hide();");
        wwD.loadUrl("javascript:$(document.querySelectorAll(\"tbody tr\")[6]).hide();");
        wwD.loadUrl("javascript:$(document.querySelector(\"#customMessage\")).hide()");
        wwD.loadUrl("javascript:$(document.querySelector(\"#adminError\")).hide()");
        wwD.loadUrl("javascript:$(\"html\").css(\"margin-top\", 0);");
        wwD.loadUrl("javascript:document.body.style.marginTop=-10");
    }public void selectionD( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
}
