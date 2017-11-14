package com.example.meskius.attemp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Meskius on 10/21/2017.
 */

public class DestytojaiTF extends GrupesTF {
    WebView wwD;


    String profText[] = {"--pasirinkti--","- -","Adomkus Aidas","Andriušienė Liudmila","Andriušis Algimantas","Anužis Mantas","Arlauskienė Renata","Artemčiukas Edgaras","Baronaitė Jolanta","Beniušienė Gražina","Beniušis Mantas","Berlinskas Šarūnas","Bernotas Almantas","Bernotienė Liolita","Bernotienė Rima","Bradauskienė Vijolė","Breivė Juozas","Budrytė-Ausiejienė Laurencija","Dikun Jelena","Doroševas Viktoras","Drizgaitė Jurgita","Drungilas Darius","Eglynas Tomas","Eidukaitis Edvinas","Ežerskienė Sigutė","Freitakaitė Vitalija","Garnienė Birutė","Gedmintas Donatas","Gerikienė Vida","Gotautienė Eglė","Grinkevičius Saulius","Gudlekis Romanas","Ivavičiūtė Giedrė","Jakubauskienė Vilma","Jankauskas Evaldas","Jankauskienė Dainora","Janulevičius Algirdas","Jokubynienė Vida","Juknienė Danguolė","Juknys Vigandas","Juškienė Rita","Kairienė Virginija","Karbauskas Antanas","Kasparaitis Vytautas","Kinderis Remigijus","Kirkilis Rolandas","Kučinskas Gintaras","Kučinskas Tadas","Kučinskienė Jurga","Kuklienė Lina","Kuklys Indrius","Kurmis Mindaugas","Laučys Mindaugas","Laureckas Evaldas","Levuškinas Orestas","Liebuvienė Jūratė","Liorančas Viktoras","Luzin Maksim","Malkus Ričardas","Martinkus Narūnas","Mauricienė Ingrida","Mickus Tautvydas","Montrimaitė Kristina","Moščenkova Elena","Narščius Aleksas","NEVARDINĖS NEVARDINĖS","Ovaltaitė Vida","Ozbinaitė Rasa","Paulauskas Donatas","Petkus Saulius","Petraitienė Lilija","Piauliokas Nerijus","Piklaps Arnoldas","Pocius Antanas","Povilavičius Marius","Pridotkienė Lina","Rataitė Birutė","Rutė Jevgenija","Ruzgienė Birutė","Savickas Tytas","Savickienė Sigutė","Simoneit Genovaitė","Sinkevičius Vytenis","Stanelytė Daiva","Staponkienė Ramutė","Statnickė Gita","Stonienė Adelė","Strumilienė Laima","Sūdžiuvienė Raimonda","Šateikienė Diana","Šilas Giedrius","Šneiderienė Valda","Tadžijevas Artūras","Tamelienė Reda","Tamokaitis Saulius","Tamošaitienė Loreta","Tautavičienė Benita","Tekutov Jurij","Tranavičius Ramūnas","Tumėnienė Virginija","Urmonienė Lionė","Uskovas Gediminas","Vaičekauskienė Vilma","Vaitekonienė Jūratė","Vaitiekus Antanas","Vaitkus Arvydas","Valevičius Romas","Verpečinskas Arūnas","Vrubliauskienė Rasida","Žvinienė Vida"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destytojai_tf);
        Intent intent= getIntent();
        final Spinner profID = (Spinner)findViewById(R.id.profID);



        spinner(profText,profID);


        wwD= (WebView)findViewById(R.id.wwID);
        WebSettings webSettings = wwD.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wwD.getSettings().setSupportZoom(true);
        wwD.getSettings().setBuiltInZoomControls(true);
        wwD.getSettings().setDisplayZoomControls(false);
        wwD.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        wwD.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/prof.php");
        wwD.setWebViewClient(new WebViewClient(){
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

    }

    private void destytojai(String destytojai) {
        switch (destytojai){
            case "--pasirinkti--":
                selectionD("prof","");
                break;
            case "- -":
                selectionD("prof","101");
                break;
            case "Adomkus Aidas":
                selectionD("prof","1");
                break;
            case "Andriušienė Liudmila":
                selectionD("prof","2");
                break;
            case "Andriušis Algimantas":
                selectionD("prof","3");
                break;
            case "Anužis Mantas":
                selectionD("prof","4");
                break;
            case "Arlauskienė Renata":
                selectionD("prof","5");
                break;
            case "Artemčiukas Edgaras":
                selectionD("prof","6");
                break;
            case "Baronaitė Jolanta":
                selectionD("prof","7");
                break;
            case "Beniušienė Gražina":
                selectionD("prof","8");
                break;
            case "Beniušis Mantas":
                selectionD("prof","9");
                break;
            case "Berlinskas Šarūnas":
                selectionD("prof","10");
                break;
            case "Bernotas Almantas":
                selectionD("prof","11");
                break;
            case "Bernotienė Liolita":
                selectionD("prof","102");
                break;
            case "Bernotienė Rima":
                selectionD("prof","96");
                break;
            case "Bradauskienė Vijolė":
                selectionD("prof","12");
                break;
            case "Breivė Juozas":
                selectionD("prof","13");
                break;
            case "Budrytė-Ausiejienė Laurencija":
                selectionD("prof","14");
                break;
            case "Dikun Jelena":
                selectionD("prof","15");
                break;
            case "Doroševas Viktoras":
                selectionD("prof","16");
                break;
            case "Drizgaitė Jurgita":
                selectionD("prof","17");
                break;
            case "Drungilas Darius":
                selectionD("prof","18");
                break;
            case "Eglynas Tomas":
                selectionD("prof","99");
                break;
            case "Eidukaitis Edvinas":
                selectionD("prof","19");
                break;
            case "Ežerskienė Sigutė":
                selectionD("prof","20");
                break;
            case "Freitakaitė Vitalija":
                selectionD("prof","21");
                break;
            case "Garnienė Birutė":
                selectionD("prof","22");
                break;
            case "Gedmintas Donatas":
                selectionD("prof","23");
                break;
            case "Gerikienė Vida":
                selectionD("prof","24");
                break;
            case "Gotautienė Eglė":
                selectionD("prof","25");
                break;
            case "Grinkevičius Saulius":
                selectionD("prof","26");
                break;
            case "Gudlekis Romanas":
                selectionD("prof","27");
                break;
            case "Ivavičiūtė Giedrė":
                selectionD("prof","28");
                break;
            case "Jakubauskienė Vilma":
                selectionD("prof","29");
                break;
            case "Jankauskas Evaldas":
                selectionD("prof","30");
                break;
            case "Jankauskienė Dainora":
                selectionD("prof","31");
                break;
            case "Janulevičius Algirdas":
                selectionD("prof","32");
                break;
            case "Jokubynienė Vida":
                selectionD("prof","33");
                break;
            case "Juknienė Danguolė":
                selectionD("prof","34");
                break;
            case "Juknys Vigandas":
                selectionD("prof","35");
                break;
            case "Juškienė Rita":
                selectionD("prof","36");
                break;
            case "Kairienė Virginija":
                selectionD("prof","105");
                break;
            case "Karbauskas Antanas":
                selectionD("prof","37");
                break;
            case "Kasparaitis Vytautas":
                selectionD("prof","38");
                break;
            case "Kinderis Remigijus":
                selectionD("prof","39");
                break;
            case "Kirkilis Rolandas":
                selectionD("prof","106");
                break;
            case "Kučinskas Gintaras":
                selectionD("prof","40");
                break;
            case "Kučinskas Tadas":
                selectionD("prof","109");
                break;
            case "Kučinskienė Jurga":
                selectionD("prof","41");
                break;
            case "Kuklienė Lina":
                selectionD("prof","42");
                break;
            case "Kuklys Indrius":
                selectionD("prof","43");
                break;
            case "Kurmis Mindaugas":
                selectionD("prof","44");
                break;
            case "Laučys Mindaugas":
                selectionD("prof","45");
                break;
            case "Laureckas Evaldas":
                selectionD("prof","100");
                break;
            case "Levuškinas Orestas":
                selectionD("prof","46");
                break;
            case "Liebuvienė Jūratė":
                selectionD("prof","47");
                break;
            case "Liorančas Viktoras":
                selectionD("prof","48");
                break;
            case "Luzin Maksim":
                selectionD("prof","110");
                break;
            case "Malkus Ričardas":
                selectionD("prof","49");
                break;
            case "Martinkus Narūnas":
                selectionD("prof","50");
                break;
            case "Mauricienė Ingrida":
                selectionD("prof","51");
                break;
            case "Mickus Tautvydas":
                selectionD("prof","95");
                break;
            case "Montrimaitė Kristina":
                selectionD("prof","53");
                break;
            case "Moščenkova Elena":
                selectionD("prof","54");
                break;
            case "Narščius Aleksas":
                selectionD("prof","55");
                break;
            case "NEVARDINĖS NEVARDINĖS":
                selectionD("prof","93");
                break;
            case "Ovaltaitė Vida":
                selectionD("prof","56");
                break;
            case "Ozbinaitė Rasa":
                selectionD("prof","97");
                break;
            case "Paulauskas Donatas":
                selectionD("prof","57");
                break;
            case "Petkus Saulius":
                selectionD("prof","104");
                break;
            case "Petraitienė Lilija":
                selectionD("prof","94");
                break;
            case "Piauliokas Nerijus":
                selectionD("prof","58");
                break;
            case "Piklaps Arnoldas":
                selectionD("prof","59");
                break;
            case "Pocius Antanas":
                selectionD("prof","60");
                break;
            case "Povilavičius Marius":
                selectionD("prof","61");
                break;
            case "Pridotkienė Lina":
                selectionD("prof","62");
                break;
            case "Rataitė Birutė":
                selectionD("prof","63");
                break;
            case "Rutė Jevgenija":
                selectionD("prof","64");
                break;
            case "Ruzgienė Birutė":
                selectionD("prof","65");
                break;
            case "Savickas Tytas":
                selectionD("prof","66");
                break;
            case "Savickienė Sigutė":
                selectionD("prof","67");
                break;
            case "Simoneit Genovaitė":
                selectionD("prof","68");
                break;
            case "Sinkevičius Vytenis":
                selectionD("prof","69");
                break;
            case "Stanelytė Daiva":
                selectionD("prof","70");
                break;
            case "Staponkienė Ramutė":
                selectionD("prof","98");
                break;
            case "Statnickė Gita":
                selectionD("prof","71");
                break;
            case "Stonienė Adelė":
                selectionD("prof","72");
                break;
            case "Strumilienė Laima":
                selectionD("prof","107");
                break;
            case "Sūdžiuvienė Raimonda":
                selectionD("prof","73");
                break;
            case "Šateikienė Diana":
                selectionD("prof","74");
                break;
            case "Šilas Giedrius":
                selectionD("prof","75");
                break;
            case "Šneiderienė Valda":
                selectionD("prof","76");
                break;
            case "Tadžijevas Artūras":
                selectionD("prof","77");
                break;
            case "Tamelienė Reda":
                selectionD("prof","78");
                break;
            case "Tamokaitis Saulius":
                selectionD("prof","79");
                break;
            case "Tamošaitienė Loreta":
                selectionD("prof","108");
                break;
            case "Tautavičienė Benita":
                selectionD("prof","80");
                break;
            case "Tekutov Jurij":
                selectionD("prof","81");
                break;
            case "Tranavičius Ramūnas":
                selectionD("prof","82");
                break;
            case "Tumėnienė Virginija":
                selectionD("prof","83");
                break;
            case "Urmonienė Lionė":
                selectionD("prof","84");
                break;
            case "Uskovas Gediminas":
                selectionD("prof","103");
                break;
            case "Vaičekauskienė Vilma":
                selectionD("prof","85");
                break;
            case "Vaitekonienė Jūratė":
                selectionD("prof","86");
                break;
            case "Vaitiekus Antanas":
                selectionD("prof","87");
                break;
            case "Vaitkus Arvydas":
                selectionD("prof","88");
                break;
            case "Valevičius Romas":
                selectionD("prof","89");
                break;
            case "Verpečinskas Arūnas":
                selectionD("prof","90");
                break;
            case "Vrubliauskienė Rasida":
                selectionD("prof","91");
                break;
            case "Žvinienė Vida":
                selectionD("prof","92");
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

        wwD.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tf_destytojai,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh:
                ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/prof.php");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
