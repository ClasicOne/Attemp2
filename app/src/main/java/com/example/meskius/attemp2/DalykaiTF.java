package com.example.meskius.attemp2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
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
 * Created by Meskius on 10/23/2017.
 */

public class DalykaiTF extends AppCompatActivity {
    WebView ww;
    String programSpinnerText;
    String yearSpinnerText;
    String programTipas[] = {"--pasirinkti--", "IŠT","NL"};
    String yearMetaiNL[] = {"--pasirinkti--", "1","2","3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1","2","3","4"};
    String dalykaiNL1[] = {"--pasirinkti--", "Anglų kalba","Bendroji chemija","Ekonomikos teorija","Fizika","Geologija","Grandinių teorija","Informacijos technologijos G","Informacijos technologijos I","Informacijos technologijos II","Informacijos technologijos MT","Informatika","Inžinerinė grafika","Inžinerinė ir kompiuterinė grafika","Inžinerinė ir specialioji grafika","Inžinerinės mechanikos pagrindai","Inžinerinės medžiagos","Įvadas į maisto technologijas","Įvadas į programavimą I","Įvadas į programavimą II","Įvadas į studijas","Kalbos kultūra","Kartografija","Kelių transporto priemonės I","Kelių transporto priemonės II","Kompiuterinė grafika I","Kompiuterinė grafika II","Kompiuterių architektūra","Kompiuterių architektūra ir operacinės sistemos","Logika","Matematika","Mechanika","Medžiagotyra","Psichologija","Skaitmeninė logika","Socialinė psichologija","Statybinės medžiagos","Taikomoji chemija","Teorinė mechanika","Transporto sistemos"};
    String dalykaiNL2[] = {"--pasirinkti--", "Anglų kalba","Aplinkos ir žmonių sauga","Augalinio maisto technologijos ir įrengimai","Aukštoji geodezija","Automatinio valdymo teorija","Automobilių elektros įrenginiai ir valdymo sistemos","Automobilių teorija","Biochemijos pagrindai","Duomenų struktūros","Ekonomika","Elektrinių matavimų praktika","Elektros mašinos ir pavaros","Elektrotechnika ir elektronika","Ergonomika inžinerijoje","Fotogrametrija","Grąfinės naudotojo sąsajos kūrimas","Grąfinės sąsajos programavimas","Išmaniųjų įrenginių technologijos","Keleivių vežimas","Kompiuterinio projektavimo praktika","Kompiuterių tinklai","Kompiuterizuotos projektavimo sistemos","Krovinių vežimas I","Krovinių vežimas II","Mašinų elementai ir mechanizmai","Mechanika","Mechatroninės sistemos","Medžiagų apdirbimo procesai","Mikrobiologija","Mikroprocesoriai","Mikrovaldikliai","Nekilnojamojo turto vertinimas","Papildytos realybės technologijos pagrindai","Pastatų konstrukcijos","Pramoninių pastatų konstrukcijos","Programavimo praktika","Programų sistemų inžinerija","Sistemų inžinerija","Specialybės praktika","Statybos darbų praktika","Statybos darbų technologija","Statybos darbų technologija I","Statybos darbų technologija II","Taikomųjų tyrimų metodika","Taikomųjų tyrimų metodologija","Technologinė įranga","Teisė","Teritorijų planavimas","Transporto geografija","Transporto priemonės ir techninė priežiūra","Užsienio kalba","Vadyba","Vadybos pagrindai","Verslo praktika (VPMF)","Žmonių sauga"};
    String dalykaiNL3[] = {"--pasirinkti--", "3D kraštovaizdžio projektavimas","Augalų kompozicija ir spalvininkystė","Automobilių defektacija ir techninė ekspertizė","Ekologiškų maisto produkų gamyba","Ekonomikos teorija","Elektros energetika","Elektros technologijos įrenginiai","Fizinė ir kosminė geodezija","Geodeziniai darbai statyboje","Geodeziniai prietaisai ir matavimų optimizavimas","Hidraulinės ir pneumatinės sistemos","Įmonių energetikos ūkis","Informatikos teisė","Inžinerinė geodezija","Inžineriniai geodezijos tyrinėjimai","Juslinė analizė","Keleivių ir krovinių vežimo taikomieji tyrimai","Komercinis transportas","Kompiuterizuotas mechanizmų valdymas","Konstrukcijų skaičiavimo pagrindai","Krovos darbų organizavimas","Laboratoriniai maisto tyrimai I","Laboratoriniai maisto tyrimai II","Logistika","Maisto įmonių ekonomika","Maisto kokybės valdymas ir užtikrinimas","Maisto pramonės technologiniai procesai ir įrengimai","Mityba","Paskirstytas programavimas su Java","Programavimas C# (I)","Programavimas C# (II)","Programavimo kursinis darbas","Saugomos teritorijos","Sodybų apželdinimo projektavimas","Specialybės kalba","Statybos verslo ekonomika","Taikomųjų tyrimų metodika","Technologiniai įrenginiai","Technologinių procesų automatizavimas","Teisė","Transporto įmonių ekonomika","Verslo praktika","Žuvų produktų gamyba","Žuvų produktų gamybos įrengimai"};
    String dalykaiIST1[] = {"--pasirinkti--", "Anglų kalba","Bendroji chemija","Fizika","Grandinių teorija","Informacijos technologijos","Informatika","Inžinerinė ir kompiuterinė grafika","Inžinerinė ir specialioji grafika","Įvadas į maisto technologijas","Įvadas į programavimą I","Įvadas į programavimą II","Įvadas į studijas","Įvadinė paskaita","Kalbos kultūra I","Kelių transporto priemonės","Matematika","Mechanika","Medžiagotyra","Psichologija","Skaitmeninė logika","Statybinės medžiagos","Taikomoji chemija","Teorinė mechanika","Transporto sistemos"};
    String dalykaiIST2[] = {"--pasirinkti--", "Aplinkos kokybės vertinimas","Augalinio maisto technologijos ir įrengimai","Eismo psichologija","Ekonomikos teorija","Elektronika","Elektrotechnika ir elektronika","Elektrotechninės medžiagos ir matavimai","Geležinkeliai","Grandinių teorija","Informacijos technologijos I","Informacijos technologijos II","Inžinerinė ir kompiuterinė grafika","Inžinerinė mechanika","Inžinerinė taikomųjų programų praktika I","Inžinerinė taikomųjų programų praktika II","Kalbos kultūra","Kalbos kultūra I","Krovinių dinamika","Logistika","Matavimai I","Matavimai II","Medžiagotyra","Medžiagų atsparumas","Mikrobiologija","Mokomoji vežimo technologijų praktika I","Mokomoji vežimo technologijų praktika II","Nekilnojamo turto vertinimas","Pastatų konstrukcijos","Psichologija","Saugus automobilių eksploatavimas","Taikomoji mechanika","Taikomųjų tyrimų metodika","Toksikologija","Užsienio kalba","Vadyba","Verslo praktika (VPMF)"};
    String dalykaiIST3[] = {"--pasirinkti--", "Aplinkos ir žmonių sauga","Aplinkos ir žmonių sauga I","Automatinio valdymo teorija","Automatinis valdymas","Automobilių defektacija ir techninė ekspertizė","Eismo psichologija","Elektrinių matavimų praktika","Elektros mašinos ir pavaros","Gyvūninio maisto technologijos ir įrengimai","Įmonių elektros sistemos","Inžinerinės pastatų sistemos","Komercinis transportas","Konstrukcijų skaičiavimo pagrindai","Krovinių vežimas","Krovos darbų organizavimas","Maisto kokybės valdymas ir užtikrinimas","Mechatronika","Medžiagų apdirbimo procesai","Personalo valdymas","Projektų valdymas","Psichologija","Rinkodaros pagrindai","Statybos darbų technologija","Strateginis valdymas","Taikomųjų tyrimų metodika","Taikomųjų tyrimų metodologija","Termodinamika ir hidromechanika","Toksikologija","Vadybos pagrindai","Verslo praktika","Verslo praktika (VPMF)","Verslo valdymo informacinės sistemos"};
    String dalykaiIST4[] = {"--pasirinkti--", "Aplinkos ir žmonių sauga","Bendravimas su klientais","Hidraulinės ir pneumatinės sistemos","Laboratoriniai maisto tyrimai I","Laboratoriniai maisto tyrimai II","Logistika","Maisto įmonių ekonomika","Maisto ruošimo technologija","Maisto saugos valdymas","Maitinimo įmonių darbo organizavimas","Programuojamieji loginiai vardikliai","Sandėliai","Statybos ekonomika","Statybos teisė, Si1","Statybos teisė, Si2","Taikomųjų tyrimų metodika","Technologinių procesų automatizavimas","Technologinių sistemų automatizavimas","Teisės pagrindai","Transporto įmonių ekonomika","Vadyba"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dalykai_tf);
        ww= (WebView)findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/groups.php");

        ww.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hide();
            }
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });
        Spinner program = (Spinner)findViewById(R.id.programGrTF);
        final Spinner year = (Spinner)findViewById(R.id.yearGrTF);
        final Spinner dalykas = (Spinner)findViewById(R.id.brachGrTF);
        Button back = (Button)findViewById(R.id.backGrTF);
        spinner(programTipas,program);
        year.setVisibility(View.GONE);
        dalykas.setVisibility(View.GONE);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DalykaiTF.this,TFMenu.class);
                startActivity(intent);
            }
        });
        program.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                programSpinnerText = adapterView.getSelectedItem().toString();

                switch (programSpinnerText){
                    case "IŠT":
                        spinner(yearMetaiIST,year);
                        selection("program","2");
                        year.setVisibility(View.VISIBLE);

                        break;
                    case "NL":
                        spinner(yearMetaiNL,year);
                        selection("program","1");
                        year.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                yearSpinnerText = adapterView.getSelectedItem().toString();
                if(programSpinnerText.indexOf("IŠT")!=-1)
                    switch (yearSpinnerText){
                        case "1":
                            spinner(dalykaiIST1,dalykas);
                            selection("year","1");
                            selection("branch","8");
                            dalykas.setVisibility(View.VISIBLE);
                            break;
                        case "2":
                            spinner(dalykaiIST2,dalykas);
                            selection("year","2");
                            selection("branch","5");
                            dalykas.setVisibility(View.VISIBLE);
                            break;
                        case "3":
                            spinner(dalykaiIST3,dalykas);
                            selection("year","3");
                            selection("branch","4");
                            dalykas.setVisibility(View.VISIBLE);
                            break;
                        case "4":
                            spinner(dalykaiIST4,dalykas);
                            selection("year","4");
                            selection("branch","7");
                            dalykas.setVisibility(View.VISIBLE);
                        default:
                            break;

                    }else switch (yearSpinnerText){
                    case "1":
                        spinner(dalykaiNL1,dalykas);
                        selection("year","1");
                        selection("branch","1");
                        dalykas.setVisibility(View.VISIBLE);
                        break;
                    case "2":
                        spinner(dalykaiNL2,dalykas);
                        selection("year","2");
                        selection("branch","2");
                        dalykas.setVisibility(View.VISIBLE);
                        break;
                    case "3":
                        spinner(dalykaiNL3,dalykas);
                        selection("year","3");
                        selection("branch","3");
                        dalykas.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dalykas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                if(programSpinnerText.contains("NL") && yearSpinnerText.contains("1"))
                   nl1(spinnerText);
                if(programSpinnerText.contains("NL") && yearSpinnerText.contains("2"))
                    nl2(spinnerText);
                if(programSpinnerText.contains("NL") && yearSpinnerText.contains("3"))
                    nl3(spinnerText);
                if(programSpinnerText.contains("IŠT")  && yearSpinnerText.contains("1"))
                    ist1(spinnerText);
                if(programSpinnerText.contains("IŠT")  && yearSpinnerText.contains("2"))
                    ist2(spinnerText);
                if(programSpinnerText.contains("IŠT")  && yearSpinnerText.contains("3"))
                    ist3(spinnerText);
                if(programSpinnerText.contains("IŠT")  && yearSpinnerText.contains("4"))
                    ist4(spinnerText);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
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
    }
    public void click(){
        ww.loadUrl("javascript:$(document.querySelector(\"input.inputbutton.special\")).click();");
    }
    public void selection( String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas +"').val('"+val+"').change();");

    }
    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
    public void nl1(String spinnerText){
        switch (spinnerText){
            case "Anglų kalba":
                selection("courses","159");
                click();
                break;
            case "Bendroji chemija":
                selection("courses","160");
                click();
                break;
            case "Ekonomikos teorija":
                selection("courses","142");
                click();
                break;
            case "Fizika":
                selection("courses","129");
                click();
                break;
            case "Geologija":
                selection("courses","143");
                click();
                break;
            case "Grandinių teorija":
                selection("courses","138");
                click();
                break;
            case "Informacijos technologijos G":
                selection("courses","144");
                click();
                break;
            case "Informacijos technologijos I":
                selection("courses","130");
                click();
                break;
            case "Informacijos technologijos II":
                selection("courses","131");
                click();
                break;
            case "Informacijos technologijos MT":
                selection("courses","161");
                click();
                break;
            case "Informatika":
                selection("courses","139");
                click();
                break;
            case "Inžinerinė grafika":
                selection("courses","145");
                click();
                break;
            case "Inžinerinė ir kompiuterinė grafika":
                selection("courses","132");
                click();
                break;
            case "Inžinerinė ir specialioji grafika":
                selection("courses","163");
                click();
                break;
            case "Inžinerinės mechanikos pagrindai":
                selection("courses","167");
                click();
                break;
            case "Inžinerinės medžiagos":
                selection("courses","133");
                click();
                break;
            case "Įvadas į maisto technologijas":
                selection("courses","162");
                click();
                break;
            case "Įvadas į programavimą I":
                selection("courses","149");
                click();
                break;
            case "Įvadas į programavimą II":
                selection("courses","150");
                click();
                break;
            case "Įvadas į studijas":
                selection("courses","270");
                click();
                break;
            case "Kalbos kultūra":
                selection("courses","140");
                click();
                break;
            case "Kartografija":
                selection("courses","146");
                click();
                break;
            case "Kelių transporto priemonės I":
                selection("courses","134");
                click();
                break;
            case "Kelių transporto priemonės II":
                selection("courses","135");
                click();
                break;
            case "Kompiuterinė grafika I":
                selection("courses","151");
                click();
                break;
            case "Kompiuterinė grafika II":
                selection("courses","152");
                click();
                break;
            case "Kompiuterių architektūra":
                selection("courses","153");
                click();
                break;
            case "Kompiuterių architektūra ir operacinės sistemos":
                selection("courses","155");
                click();
                break;
            case "Logika":
                selection("courses","154");
                click();
                break;
            case "Matematika":
                selection("courses","136");
                click();
                break;
            case "Mechanika":
                selection("courses","141");
                click();
                break;
            case "Medžiagotyra":
                selection("courses","157");
                click();
                break;
            case "Psichologija":
                selection("courses","147");
                click();
                break;
            case "Skaitmeninė logika":
                selection("courses","156");
                click();
                break;
            case "Socialinė psichologija":
                selection("courses","164");
                click();
                break;
            case "Statybinės medžiagos":
                selection("courses","165");
                click();
                break;
            case "Taikomoji chemija":
                selection("courses","166");
                click();
                break;
            case "Teorinė mechanika":
                selection("courses","158");
                click();
                break;
            case "Transporto sistemos":
                selection("courses","168");
                click();
                break;
        }
    }
    public void nl2(String spinnerText){
        switch (spinnerText){
            case "Anglų kalba":
                selection("courses","195");
                click();
                break;
            case "Aplinkos ir žmonių sauga":
                selection("courses","213");
                click();
                break;
            case "Augalinio maisto technologijos ir įrengimai":
                selection("courses","207");
                click();
                break;
            case "Aukštoji geodezija":
                selection("courses","183");
                click();
                break;
            case "Automatinio valdymo teorija":
                selection("courses","176");
                click();
                break;
            case "Automobilių elektros įrenginiai ir valdymo sistemos":
                selection("courses","169");
                click();
                break;
            case "Automobilių teorija":
                selection("courses","170");
                click();
                break;
            case "Biochemijos pagrindai":
                selection("courses","208");
                click();
                break;
            case "Duomenų struktūros":
                selection("courses","196");
                click();
                break;
            case "Ekonomika":
                selection("courses","177");
                click();
                break;
            case "Elektrinių matavimų praktika":
                selection("courses","178");
                click();
                break;
            case "Elektros mašinos ir pavaros":
                selection("courses","179");
                click();
                break;
            case "Elektrotechnika ir elektronika":
                selection("courses","171");
                click();
                break;
            case "Ergonomika inžinerijoje":
                selection("courses","172");
                click();
                break;
            case "Fotogrametrija":
                selection("courses","184");
                click();
                break;
            case "Grąfinės naudotojo sąsajos kūrimas":
                selection("courses","197");
                click();
                break;
            case "Grąfinės sąsajos programavimas":
                selection("courses","189");
                click();
                break;
            case "Išmaniųjų įrenginių technologijos":
                selection("courses","198");
                click();
                break;
            case "Keleivių vežimas":
                selection("courses","271");
                click();
                break;
            case "Kompiuterinio projektavimo praktika":
                selection("courses","201");
                click();
                break;
            case "Kompiuterių tinklai":
                selection("courses","190");
                click();
                break;
            case "Kompiuterizuotos projektavimo sistemos":
                selection("courses","185");
                click();
                break;
            case "Krovinių vežimas I":
                selection("courses","220");
                click();
                break;
            case "Krovinių vežimas II":
                selection("courses","267");
                click();
                break;
            case "Mašinų elementai ir mechanizmai":
                selection("courses","202");
                click();
                break;
            case "Mechanika":
                selection("courses","180");
                click();
                break;
            case "Mechatroninės sistemos":
                selection("courses","203");
                click();
                break;
            case "Medžiagų apdirbimo procesai":
                selection("courses","204");
                click();
                break;
            case "Mikrobiologija":
                selection("courses","209");
                click();
                break;
            case "Mikroprocesoriai":
                selection("courses","181");
                click();
                break;
            case "Mikrovaldikliai":
                selection("courses","199");
                click();
                break;
            case "Nekilnojamojo turto vertinimas":
                selection("courses","186");
                click();
                break;
            case "Papildytos realybės technologijos pagrindai":
                selection("courses","182");
                click();
                break;
            case "Pastatų konstrukcijos":
                selection("courses","215");
                click();
                break;
            case "Pramoninių pastatų konstrukcijos":
                selection("courses","214");
                click();
                break;
            case "Programavimo praktika":
                selection("courses","191");
                click();
                break;
            case "Programų sistemų inžinerija":
                selection("courses","192");
                click();
                break;
            case "Sistemų inžinerija":
                selection("courses","200");
                click();
                break;
            case "Specialybės praktika":
                selection("courses","266");
                click();
                break;
            case "Statybos darbų praktika":
                selection("courses","216");
                click();
                break;
            case "Statybos darbų technologija":
                selection("courses","219");
                click();
                break;
            case "Statybos darbų technologija I":
                selection("courses","217");
                click();
                break;
            case "Statybos darbų technologija II":
                selection("courses","218");
                click();
                break;
            case "Taikomųjų tyrimų metodika":
                selection("courses","187");
                click();
                break;
            case "Taikomųjų tyrimų metodologija":
                selection("courses","210");
                click();
                break;
            case "Technologinė įranga":
                selection("courses","173");
                click();
                break;
            case "Teisė":
                selection("courses","211");
                click();
                break;
            case "Teritorijų planavimas":
                selection("courses","188");
                click();
                break;
            case "Transporto geografija":
                selection("courses","221");
                click();
                break;
            case "Transporto priemonės ir techninė priežiūra":
                selection("courses","222");
                click();
                break;
            case "Užsienio kalba":
                selection("courses","205");
                click();
                break;
            case "Vadyba":
                selection("courses","212");
                click();
                break;
            case "Vadybos pagrindai":
                selection("courses","174");
                click();
                break;
            case "Verslo praktika (VPMF)":
                selection("courses","175");
                click();
                break;
            case "Žmonių sauga":
                selection("courses","193");
                click();
                break;
        }
    }
    public void nl3(String spinnerText){
        switch (spinnerText){
            case "3D kraštovaizdžio projektavimas":
                selection("courses","245");
                click();
                break;
            case "Augalų kompozicija ir spalvininkystė":
                selection("courses","246");
                click();
                break;
            case "Automobilių defektacija ir techninė ekspertizė":
                selection("courses","223");
                click();
                break;
            case "Ekologiškų maisto produkų gamyba":
                selection("courses","251");
                click();
                break;
            case "Ekonomikos teorija":
                selection("courses","142");
                click();
                break;
            case "Elektros energetika":
                selection("courses","227");
                click();
                break;
            case "Elektros technologijos įrenginiai":
                selection("courses","228");
                click();
                break;
            case "Fizinė ir kosminė geodezija":
                selection("courses","233");
                click();
                break;
            case "Geodeziniai darbai statyboje":
                selection("courses","234");
                click();
                break;
            case "Geodeziniai prietaisai ir matavimų optimizavimas":
                selection("courses","235");
                click();
                break;
            case "Hidraulinės ir pneumatinės sistemos":
                selection("courses","229");
                click();
                break;
            case "Įmonių energetikos ūkis":
                selection("courses","230");
                click();
                break;
            case "Informatikos teisė":
                selection("courses","240");
                click();
                break;
            case "Inžinerinė geodezija":
                selection("courses","236");
                click();
                break;
            case "Inžineriniai geodezijos tyrinėjimai":
                selection("courses","238");
                click();
                break;
            case "Juslinė analizė":
                selection("courses","252");
                click();
                break;
            case "Keleivių ir krovinių vežimo taikomieji tyrimai":
                selection("courses","262");
                click();
                break;
            case "Komercinis transportas":
                selection("courses","224");
                click();
                break;
            case "Kompiuterizuotas mechanizmų valdymas":
                selection("courses","249");
                click();
                break;
            case "Konstrukcijų skaičiavimo pagrindai":
                selection("courses","260");
                click();
                break;
            case "Krovos darbų organizavimas":
                selection("courses","263");
                click();
                break;
            case "Laboratoriniai maisto tyrimai I":
                selection("courses","253");
                click();
                break;
            case "Laboratoriniai maisto tyrimai II":
                selection("courses","254");
                click();
                break;
            case "Logistika":
                selection("courses","264");
                click();
                break;
            case "Maisto įmonių ekonomika":
                selection("courses","255");
                click();
                break;
            case "Maisto kokybės valdymas ir užtikrinimas":
                selection("courses","256");
                click();
                break;
            case "Maisto pramonės technologiniai procesai ir įrengimai":
                selection("courses","257");
                click();
                break;
            case "Mityba":
                selection("courses","231");
                click();
                break;
            case "Paskirstytas programavimas su Java":
                selection("courses","241");
                click();
                break;
            case "Programavimas C# (I)":
                selection("courses","242");
                click();
                break;
            case "Programavimas C# (II)":
                selection("courses","243");
                click();
                break;
            case "Programavimo kursinis darbas":
                selection("courses","244");
                click();
                break;
            case "Saugomos teritorijos":
                selection("courses","237");
                click();
                break;
            case "Sodybų apželdinimo projektavimas":
                selection("courses","247");
                click();
                break;
            case "Specialybės kalba":
                selection("courses","265");
                click();
                break;
            case "Statybos verslo ekonomika":
                selection("courses","261");
                click();
                break;
            case "Taikomųjų tyrimų metodika":
                selection("courses","225");
                click();
                break;
            case "Technologiniai įrenginiai":
                selection("courses","250");
                click();
                break;
            case "Technologinių procesų automatizavimas":
                selection("courses","232");
                click();
                break;
            case "Teisė":
                selection("courses","211");
                click();
                break;
            case "Transporto įmonių ekonomika":
                selection("courses","226");
                click();
                break;
            case "Verslo praktika":
                selection("courses","248");
                click();
                break;
            case "Žuvų produktų gamyba":
                selection("courses","258");
                click();
                break;
            case "Žuvų produktų gamybos įrengimai":
                selection("courses","259");
                click();
                break;
        }
    }
    public void ist1(String spinnerText){
        switch (spinnerText){
            case "Anglų kalba":
                selection("courses","12");
                click();
                break;
            case "Bendroji chemija":
                selection("courses","23");
                click();
                break;
            case "Fizika":
                selection("courses","8");
                click();
                break;
            case "Grandinių teorija":
                selection("courses","13");
                click();
                break;
            case "Informacijos technologijos":
                selection("courses","24");
                click();
                break;
            case "Informatika":
                selection("courses","15");
                click();
                break;
            case "Inžinerinė ir kompiuterinė grafika":
                selection("courses","17");
                click();
                break;
            case "Inžinerinė ir specialioji grafika":
                selection("courses","27");
                click();
                break;
            case "Įvadas į maisto technologijas":
                selection("courses","25");
                click();
                break;
            case "Įvadas į programavimą I":
                selection("courses","20");
                click();
                break;
            case "Įvadas į programavimą II":
                selection("courses","21");
                click();
                break;
            case "Įvadas į studijas":
                selection("courses","270");
                click();
                break;
            case "Įvadinė paskaita":
                selection("courses","269");
                click();
                break;
            case "Kalbos kultūra I":
                selection("courses","28");
                click();
                break;
            case "Kelių transporto priemonės":
                selection("courses","10");
                click();
                break;
            case "Matematika":
                selection("courses","11");
                click();
                break;
            case "Mechanika":
                selection("courses","16");
                click();
                break;
            case "Medžiagotyra":
                selection("courses","18");
                click();
                break;
            case "Psichologija":
                selection("courses","26");
                click();
                break;
            case "Skaitmeninė logika":
                selection("courses","22");
                click();
                break;
            case "Statybinės medžiagos":
                selection("courses","29");
                click();
                break;
            case "Taikomoji chemija":
                selection("courses","30");
                click();
                break;
            case "Teorinė mechanika":
                selection("courses","19");
                click();
                break;
            case "Transporto sistemos":
                selection("courses","31");
                click();
                break;
        }
    }
    public void ist2(String spinnerText){
        switch (spinnerText){
            case "Aplinkos kokybės vertinimas":
                selection("courses","54");
                click();
                break;
            case "Augalinio maisto technologijos ir įrengimai":
                selection("courses","55");
                click();
                break;
            case "Eismo psichologija":
                selection("courses","33");
                click();
                break;
            case "Ekonomikos teorija":
                selection("courses","56");
                click();
                break;
            case "Elektronika":
                selection("courses","41");
                click();
                break;
            case "Elektrotechnika ir elektronika":
                selection("courses","35");
                click();
                break;
            case "Elektrotechninės medžiagos ir matavimai":
                selection("courses","42");
                click();
                break;
            case "Geležinkeliai":
                selection("courses","65");
                click();
                break;
            case "Grandinių teorija":
                selection("courses","43");
                click();
                break;
            case "Informacijos technologijos I":
                selection("courses","36");
                click();
                break;
            case "Informacijos technologijos II":
                selection("courses","37");
                click();
                break;
            case "Inžinerinė ir kompiuterinė grafika":
                selection("courses","44");
                click();
                break;
            case "Inžinerinė mechanika":
                selection("courses","38");
                click();
                break;
            case "Inžinerinė taikomųjų programų praktika I":
                selection("courses","39");
                click();
                break;
            case "Inžinerinė taikomųjų programų praktika II":
                selection("courses","40");
                click();
                break;
            case "Kalbos kultūra":
                selection("courses","45");
                click();
                break;
            case "Kalbos kultūra I":
                selection("courses","28");
                click();
                break;
            case "Krovinių dinamika":
                selection("courses","66");
                click();
                break;
            case "Logistika":
                selection("courses","46");
                click();
                break;
            case "Matavimai I":
                selection("courses","49");
                click();
                break;
            case "Matavimai II":
                selection("courses","50");
                click();
                break;
            case "Medžiagotyra":
                selection("courses","51");
                click();
                break;
            case "Medžiagų atsparumas":
                selection("courses","52");
                click();
                break;
            case "Mikrobiologija":
                selection("courses","57");
                click();
                break;
            case "Mokomoji vežimo technologijų praktika I":
                selection("courses","68");
                click();
                break;
            case "Mokomoji vežimo technologijų praktika II":
                selection("courses","69");
                click();
                break;
            case "Nekilnojamo turto vertinimas":
                selection("courses","60");
                click();
                break;
            case "Pastatų konstrukcijos":
                selection("courses","61");
                click();
                break;
            case "Psichologija":
                selection("courses","26");
                click();
                break;
            case "Saugus automobilių eksploatavimas":
                selection("courses","67");
                click();
                break;
            case "Taikomoji mechanika":
                selection("courses","63");
                click();
                break;
            case "Taikomųjų tyrimų metodika":
                selection("courses","87");
                click();
                break;
            case "Toksikologija":
                selection("courses","58");
                click();
                break;
            case "Užsienio kalba":
                selection("courses","64");
                click();
                break;
            case "Vadyba":
                selection("courses","47");
                click();
                break;
            case "Verslo praktika (VPMF)":
                selection("courses","59");
                click();
                break;
        }
    }
    public void ist3(String spinnerText){
        switch (spinnerText){
            case "Aplinkos ir žmonių sauga":
                selection("courses","77");
                click();
                break;
            case "Aplinkos ir žmonių sauga I":
                selection("courses","93");
                click();
                break;
            case "Automatinio valdymo teorija":
                selection("courses","78");
                click();
                break;
            case "Automatinis valdymas":
                selection("courses","84");
                click();
                break;
            case "Automobilių defektacija ir techninė ekspertizė":
                selection("courses","71");
                click();
                break;
            case "Eismo psichologija":
                selection("courses","33");
                click();
                break;
            case "Elektrinių matavimų praktika":
                selection("courses","79");
                click();
                break;
            case "Elektros mašinos ir pavaros":
                selection("courses","80");
                click();
                break;
            case "Gyvūninio maisto technologijos ir įrengimai":
                selection("courses","89");
                click();
                break;
            case "Įmonių elektros sistemos":
                selection("courses","81");
                click();
                break;
            case "Inžinerinės pastatų sistemos":
                selection("courses","94");
                click();
                break;
            case "Komercinis transportas":
                selection("courses","73");
                click();
                break;
            case "Konstrukcijų skaičiavimo pagrindai":
                selection("courses","95");
                click();
                break;
            case "Krovinių vežimas":
                selection("courses","98");
                click();
                break;
            case "Krovos darbų organizavimas":
                selection("courses","99");
                click();
                break;
            case "Maisto kokybės valdymas ir užtikrinimas":
                selection("courses","90");
                click();
                break;
            case "Mechatronika":
                selection("courses","85");
                click();
                break;
            case "Medžiagų apdirbimo procesai":
                selection("courses","86");
                click();
                break;
            case "Personalo valdymas":
                selection("courses","101");
                click();
                break;
            case "Projektų valdymas":
                selection("courses","102");
                click();
                break;
            case "Psichologija":
                selection("courses","74");
                click();
                break;
            case "Rinkodaros pagrindai":
                selection("courses","103");
                click();
                break;
            case "Statybos darbų technologija":
                selection("courses","97");
                click();
                break;
            case "Strateginis valdymas":
                selection("courses","104");
                click();
                break;
            case "Taikomųjų tyrimų metodika":
                selection("courses","87");
                click();
                break;
            case "Taikomųjų tyrimų metodologija":
                selection("courses","91");
                click();
                break;
            case "Termodinamika ir hidromechanika":
                selection("courses","88");
                click();
                break;
            case "Toksikologija":
                selection("courses","58");
                click();
                break;
            case "Vadybos pagrindai":
                selection("courses","75");
                click();
                break;
            case "Verslo praktika":
                selection("courses","76");
                click();
                break;
            case "Verslo praktika (VPMF)":
                selection("courses","100");
                click();
                break;
            case "Verslo valdymo informacinės sistemos":
                selection("courses","105");
                click();
                break;
        }
    }
    public void ist4(String spinnerText){
        switch (spinnerText){
            case "Aplinkos ir žmonių sauga":
                selection("courses","106");
                click();
                break;
            case "Bendravimas su klientais":
                selection("courses","107");
                click();
                break;
            case "Hidraulinės ir pneumatinės sistemos":
                selection("courses","108");
                click();
                break;
            case "Laboratoriniai maisto tyrimai I":
                selection("courses","117");
                click();
                break;
            case "Laboratoriniai maisto tyrimai II":
                selection("courses","118");
                click();
                break;
            case "Logistika":
                selection("courses","127");
                click();
                break;
            case "Maisto įmonių ekonomika":
                selection("courses","119");
                click();
                break;
            case "Maisto ruošimo technologija":
                selection("courses","120");
                click();
                break;
            case "Maisto saugos valdymas":
                selection("courses","121");
                click();
                break;
            case "Maitinimo įmonių darbo organizavimas":
                selection("courses","122");
                click();
                break;
            case "Programuojamieji loginiai vardikliai":
                selection("courses","115");
                click();
                break;
            case "Sandėliai":
                selection("courses","128");
                click();
                break;
            case "Statybos ekonomika":
                selection("courses","123");
                click();
                break;
            case "Statybos teisė, Si1":
                selection("courses","125");
                click();
                break;
            case "Statybos teisė, Si2":
                selection("courses","124");
                click();
                break;
            case "Taikomųjų tyrimų metodika":
                selection("courses","109");
                click();
                break;
            case "Technologinių procesų automatizavimas":
                selection("courses","114");
                click();
                break;
            case "Technologinių sistemų automatizavimas":
                selection("courses","116");
                click();
                break;
            case "Teisės pagrindai":
                selection("courses","110");
                click();
                break;
            case "Transporto įmonių ekonomika":
                selection("courses","111");
                click();
                break;
            case "Vadyba":
                selection("courses","126");
                click();
                break;
        }
    }
}