package com.example.meskius.attemp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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
        setContentView(R.layout.grupes_svmf);
        ww();
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/groups.php");
        ww.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                hide();
            }
        });
        final Spinner program = (Spinner) findViewById(R.id.programGSMF);
        final Spinner metai = (Spinner) findViewById(R.id.yearGSMF);
        final Spinner grupe = (Spinner) findViewById(R.id.groupGSMF);
        final TextView metaiText = (TextView) findViewById(R.id.metaiGsmf);
        final TextView grupeText = (TextView) findViewById(R.id.grupeGsmf);
        Button refresh = (Button) findViewById(R.id.refresh);
        Button atgal = (Button) findViewById(R.id.back);
        metai.setVisibility(View.GONE);
        grupe.setVisibility(View.GONE);
        metaiText.setVisibility(View.GONE);
        grupeText.setVisibility(View.GONE);

        spinner(programText, program);
        atgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GrupesSVMF.this, SVMFMenu.class);
                startActivity(intent);
            }
        });
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_svmf/groups.php");
            }
        });
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
                if (programSpinnerText.contains("Bendrosios praktikos slauga") && yearSpinnerText.contains("1"))
                    grupes_bps1(spinnerText);
                if (programSpinnerText.contains("Bendrosios praktikos slauga") && yearSpinnerText.contains("2"))
                    grupes_bps2(spinnerText);
                if (programSpinnerText.contains("Bendrosios praktikos slauga") && yearSpinnerText.contains("3"))
                    grupes_bps3(spinnerText);
                if (programSpinnerText.contains("Bendrosios praktikos slauga") && yearSpinnerText.contains("4"))
                    grupes_bps4(spinnerText);
                if (programSpinnerText.contains("Burnos higiena") && yearSpinnerText.contains("1"))
                    grupes_bh1(spinnerText);
                if (programSpinnerText.contains("Burnos higiena") && yearSpinnerText.contains("2"))
                    grupes_bh2(spinnerText);
                if (programSpinnerText.contains("Burnos higiena") && yearSpinnerText.contains("3"))
                    grupes_bh3(spinnerText);
                if (programSpinnerText.contains("Dietetika") && yearSpinnerText.contains("1"))
                    grupes_d1(spinnerText);
                if (programSpinnerText.contains("Dietetika") && yearSpinnerText.contains("2"))
                    grupes_d2(spinnerText);
                if (programSpinnerText.contains("Dietetika") && yearSpinnerText.contains("3"))
                    grupes_d3(spinnerText);
                if (programSpinnerText.contains("Grožio terapija") && yearSpinnerText.contains("1"))
                    grupes_gt1(spinnerText);
                if (programSpinnerText.contains("Grožio terapija") && yearSpinnerText.contains("2"))
                    grupes_gt2(spinnerText);
                if (programSpinnerText.contains("Grožio terapija") && yearSpinnerText.contains("3"))
                    grupes_gt3(spinnerText);
                if (programSpinnerText.contains("Kineziterapija") && yearSpinnerText.contains("1"))
                    grupes_k1(spinnerText);
                if (programSpinnerText.contains("Kineziterapija") && yearSpinnerText.contains("2"))
                    grupes_k2(spinnerText);
                if (programSpinnerText.contains("Kineziterapija") && yearSpinnerText.contains("3"))
                    grupes_k3(spinnerText);
                if (programSpinnerText.contains("Odontologinė priežiūra") && yearSpinnerText.contains("1"))
                    grupes_op1(spinnerText);
                if (programSpinnerText.contains("Odontologinė priežiūra") && yearSpinnerText.contains("2"))
                    grupes_op2(spinnerText);
                if (programSpinnerText.contains("Odontologinė priežiūra") && yearSpinnerText.contains("3"))
                    grupes_op3(spinnerText);
                if (programSpinnerText.contains("Socialinis darbas") && yearSpinnerText.contains("1"))
                    grupes_sd1(spinnerText);
                if (programSpinnerText.contains("Socialinis darbas") && yearSpinnerText.contains("2"))
                    grupes_sd2(spinnerText);
                if (programSpinnerText.contains("Socialinis darbas") && yearSpinnerText.contains("3"))
                    grupes_sd3(spinnerText);
                if (programSpinnerText.contains("Socialinis darbas") && yearSpinnerText.contains("4"))
                    grupes_sd4(spinnerText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void grupes_sd1(String spinnerText) {
        switch (spinnerText) {
            case "SD 16-1":
                selection("group", "45");
                click();
                break;
            case "SD 16-1, 1-2":
                selection("group", "46");
                click();
                break;
            case "SD 16-1, 2-2":
                selection("group", "47");
                click();
                break;
            case "SDs 1-1":
                selection("group", "42");
                click();
                break;
            case "SDs 1-1, 1-2":
                selection("group", "43");
                click();
                break;
            case "SDs 1-1, 2-2":
                selection("group", "44");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_sd2(String spinnerText) {
        switch (spinnerText) {
            case "SD 14-2":
                selection("group", "48");
                click();
                break;
            case "SD 14-2, 1-2":
                selection("group", "49");
                click();
                break;
            case "SD 14-2, 2-2":
                selection("group", "50");
                click();
                break;
            case "SD 15-2":
                selection("group", "51");
                click();
                break;
            case "SD 15-2, 1-2":
                selection("group", "52");
                click();
                break;
            case "SD 15-2, 2-2":
                selection("group", "53");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_sd3(String spinnerText) {
        switch (spinnerText) {
            case "SD 12-3":
                selection("group", "142");
                click();
                break;
            case "SD 12-3, 1-2":
                selection("group", "143");
                click();
                break;
            case "SD 12-3, 2-2":
                selection("group", "144");
                click();
                break;
            case "SD 13-3":
                selection("group", "54");
                click();
                break;
            case "SD 13-3, 1-2":
                selection("group", "55");
                click();
                break;
            case "SD 13-3, 2-2":
                selection("group", "107");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_sd4(String spinnerText) {
        switch (spinnerText) {
            case "SDi 6-4":
                selection("group", "159");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_op3(String spinnerText) {
        switch (spinnerText) {
            case "OP8-3":
                selection("group", "103");
                click();
                break;
            case "OP8-3, 1-3":
                selection("group", "104");
                click();
                break;
            case "OP8-3, 2-3":
                selection("group", "105");
                click();
                break;
            case "OP8-3, 3-3":
                selection("group", "106");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_op2(String spinnerText) {
        switch (spinnerText) {
            case "OP9-2":
                selection("group", "102");
                click();
                break;
            case "OP9-2, 1-2":
                selection("group", "145");
                click();
                break;
            case "OP9-2, 2-2":
                selection("group", "146");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_op1(String spinnerText) {
        switch (spinnerText) {
            case "OP10-1":
                selection("group", "101");
                click();
                break;
            case "OP10-1, 1-2":
                selection("group", "181");
                click();
                break;
            case "OP10-1, 2-2":
                selection("group", "180");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_k1(String spinnerText) {
        switch (spinnerText) {
            case "KT 16-1":
                //selection("group","59");
                selection("group", "59");
                //click();
                break;
            case "KT 16-1, 1-2":
                selection("group", "60");
                click();
                break;
            case "KT 16-1, 2-2":
                selection("group", "61");
                click();
                break;
            case "KT 17-1":
                selection("group", "56");
                click();
                break;
            case "KT 17-1, 1-2":
                selection("group", "57");
                click();
                break;
            case "KT 17-1, 2-2":
                selection("group", "58");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_k2(String spinnerText) {
        switch (spinnerText) {
            case "KT 14-2":
                selection("group", "129");
                click();
                break;
            case "KT 14-2  2-2":
                selection("group", "131");
                click();
                break;
            case "KT 14-2, 1-2":
                selection("group", "130");
                click();
                break;
            case "KT 14-2, 1-3":
                selection("group", "132");
                click();
                break;
            case "KT 14-2, 2-3":
                selection("group", "133");
                click();
                break;
            case "KT 14-2, 3-3":
                selection("group", "134");
                click();
                break;
            case "KT 15-2":
                selection("group", "62");
                click();
                break;
            case "KT 15-2, 1-2":
                selection("group", "63");
                click();
                break;
            case "KT 15-2, 1-3":
                selection("group", "65");
                click();
                break;
            case "KT 15-2, 2-2":
                selection("group", "64");
                click();
                break;
            case "KT 15-2, 2-3":
                selection("group", "66");
                click();
                break;
            case "KT 15-2, 3-3":
                selection("group", "67");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_k3(String spinnerText) {
        switch (spinnerText) {
            case "KT 12-3":
                selection("group", "138");
                click();
                break;
            case "KT 12-3, 1-2":
                selection("group", "139");
                click();
                break;
            case "KT 12-3, 2-2":
                selection("group", "140");
                click();
                break;
            case "KT 13-3":
                selection("group", "135");
                click();
                break;
            case "KT 13-3, 1-2":
                selection("group", "136");
                click();
                break;
            case "KT 13-3, 2-2":
                selection("group", "137");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_gt1(String spinnerText) {
        switch (spinnerText) {
            case "GT 17-1":
                selection("group", "123");
                click();
                break;
            case "GT 17-1, 1-2":
                selection("group", "124");
                click();
                break;
            case "GT 17-1, 1-3":
                selection("group", "126");
                click();
                break;
            case "GT 17-1, 2-2":
                selection("group", "125");
                click();
                break;
            case "GT 17-1, 2-3":
                selection("group", "127");
                click();
                break;
            case "GT 17-1, 3-3":
                selection("group", "128");
                click();
                break;
            case "GT 18-1":
                selection("group", "25");
                click();
                break;
            case "GT 18-1, 1-2":
                selection("group", "26");
                click();
                break;
            case "GT 18-1, 1-3":
                selection("group", "28");
                click();
                break;
            case "GT 18-1, 2-2":
                selection("group", "27");
                click();
                break;
            case "GT 18-1, 2-3":
                selection("group", "29");
                click();
                break;
            case "GT 18-1, 3-3":
                selection("group", "30");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_gt2(String spinnerText) {
        switch (spinnerText) {
            case "GT 15-2":
                selection("group", "37");
                click();
                break;
            case "GT 15-2, 1-2":
                selection("group", "38");
                click();
                break;
            case "GT 15-2, 1-3":
                selection("group", "119");
                click();
                break;
            case "GT 15-2, 2-2":
                selection("group", "39");
                click();
                break;
            case "GT 15-2, 2-3":
                selection("group", "120");
                click();
                break;
            case "GT 15-2, 3-3":
                selection("group", "121");
                click();
                break;
            case "GT 16-2":
                selection("group", "31");
                click();
                break;
            case "GT 16-2, 1-2":
                selection("group", "32");
                click();
                break;
            case "GT 16-2, 1-3":
                selection("group", "34");
                click();
                break;
            case "GT 16-2, 2-2":
                selection("group", "33");
                click();
                break;
            case "GT 16-2, 2-3":
                selection("group", "35");
                click();
                break;
            case "GT 16-2, 3-3":
                selection("group", "36");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_gt3(String spinnerText) {
        switch (spinnerText) {
            case "GT 13-3":
                selection("group", "111");
                click();
                break;
            case "GT 13-3, 1-2":
                selection("group", "112");
                click();
                break;
            case "GT 13-3, 1-3":
                selection("group", "166");
                click();
                break;
            case "GT 13-3, 2-2":
                selection("group", "113");
                click();
                break;
            case "GT 13-3, 2-3":
                selection("group", "167");
                click();
                break;
            case "GT 13-3, 3-3":
                selection("group", "168");
                click();
                break;
            case "GT 14-3":
                selection("group", "114");
                click();
                break;
            case "GT 14-3, 1-2":
                selection("group", "115");
                click();
                break;
            case "GT 14-3, 1-3":
                selection("group", "163");
                click();
                break;
            case "GT 14-3, 2-2":
                selection("group", "116");
                click();
                break;
            case "GT 14-3, 2-3":
                selection("group", "164");
                click();
                break;
            case "GT 14-3, 3-3":
                selection("group", "165");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_d1(String spinnerText) {
        switch (spinnerText) {
            case "DT 4-1":
                selection("group", "100");
                click();
                break;
            case "DT 4-1, 1-2":
                selection("group", "177");
                click();
                break;
            case "DT 4-1, 2-2":
                selection("group", "176");
                click();
                break;
            case "DTs 1-1":
                selection("group", "160");
                click();
                break;
            case "DTs 1-1, 1-2":
                selection("group", "161");
                click();
                break;
            case "DTs 1-1, 2-2":
                selection("group", "162");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_d2(String spinnerText) {
        switch (spinnerText) {
            case "DT 3-2":
                selection("group", "141");
                click();
                break;
            case "DT 3-2, 1-2":
                selection("group", "171");
                click();
                break;
            case "DT 3-2, 2-2":
                selection("group", "170");
                click();
                break;
            case "DTi 2-2":
                selection("group", "173");
                click();
                break;
            case "DTi 2-2, 1-2":
                selection("group", "175");
                click();
                break;
            case "DTi 2-2, 2-2":
                selection("group", "174");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_d3(String spinnerText) {
        switch (spinnerText) {
            case "DT 2-3":
                selection("group", "172");
                click();
                break;
            case "DTi 1-3":
                selection("group", "182");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_bh3(String spinnerText) {
        switch (spinnerText) {
            case "BH8-3":
                selection("group", "97");
                click();
                break;
            case "BH8-3, 1-2":
                selection("group", "98");
                click();
                break;
            case "BH8-3, 1-3":
                selection("group", "147");
                click();
                break;
            case "BH8-3, 2-2":
                selection("group", "99");
                click();
                break;
            case "BH8-3, 2-3":
                selection("group", "148");
                click();
                break;
            case "BH8-3, 3-3":
                selection("group", "149");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_bh2(String spinnerText) {
        switch (spinnerText) {
            case "BH9-2":
                selection("group", "94");
                click();
                break;
            case "BH9-2, 1-2":
                selection("group", "95");
                click();
                break;
            case "BH9-2, 2-2":
                selection("group", "96");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_bh1(String spinnerText) {
        switch (spinnerText) {
            case "BH 10-1":
                selection("group", "92");
                click();
                break;
            case "BH 10-1, 1-2":
                selection("group", "179");
                click();
                break;
            case "BH 10-1, 2-2":
                selection("group", "178");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_bps4(String spinnerText) {
        switch (spinnerText) {
            case "SL 13-4":
                selection("group", "150");
                click();
                break;
            case "SL 13-4, 1-2":
                selection("group", "151");
                click();
                break;
            case "SL 13-4, 2-2":
                selection("group", "152");
                click();
                break;
            case "SL 14-4":
                selection("group", "153");
                click();
                break;
            case "SL 14-4, 1-2":
                selection("group", "154");
                click();
                break;
            case "SL 14-4, 2-2":
                selection("group", "155");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_bps3(String spinnerText) {
        switch (spinnerText) {
            case "SL 15-3":
                selection("group", "86");
                click();
                break;
            case "SL 15-3, 1-2":
                selection("group", "87");
                click();
                break;
            case "SL 15-3, 2-2":
                selection("group", "88");
                click();
                break;
            case "SL 16-3":
                selection("group", "89");
                click();
                break;
            case "SL 16-3, 1-2":
                selection("group", "90");
                click();
                break;
            case "SL 16-3, 2-2":
                selection("group", "91");
                click();
                break;
            default:
                break;
        }
    }

    private void grupes_bps2(String spinnerText) {
        switch (spinnerText) {
            case "SL 17-2":
                selection("group", "80");
                click();
                break;
            case "SL 17-2, 1-2":
                selection("group", "81");
                click();
                break;
            case "SL 17-2, 2-2":
                selection("group", "82");
                click();
                break;
            case "SL 18-2":
                selection("group", "83");
                click();
                break;
            case "SL 18-2, 1-2":
                selection("group", "84");
                click();
                break;
            case "SL 18-2, 2-2":
                selection("group", "85");
                click();
                break;
            default:
                break;
        }
    }

    private void ww() {
        ww = (WebView) findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
    }

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

    private void grupes_bps1(String spinnerText) {
        switch (spinnerText) {
            case "SL 19-1":
                selection("group", "68");
                click();
                break;
            case "SL 19-1, 1-2":
                selection("group", "69");
                click();
                break;
            case "SL 19-1, 1-3":
                selection("group", "71");
                click();
                break;
            case "SL 19-1, 2-2":
                selection("group", "70");
                click();
                break;
            case "SL 19-1, 2-3":
                selection("group", "72");
                click();
                break;
            case "SL 19-1, 3-3":
                selection("group", "73");
                click();
                break;
            case "SL 20-1":
                selection("group", "74");
                click();
                break;
            case "SL 20-1, 1-2":
                selection("group", "75");
                click();
                break;
            case "SL 20-1, 1-3":
                selection("group", "77");
                click();
                break;
            case "SL 20-1, 2-2":
                selection("group", "76");
                click();
                break;
            case "SL 20-1, 2-3":
                selection("group", "78");
                click();
                break;
            case "SL 20-1, 3-3":
                selection("group", "79");
                click();
                break;
            case "SL 21-1":
                selection("group", "188");
                click();
                break;
            case "SL 21-1, 1-2":
                selection("group", "184");
                click();
                break;
            case "SL 21-1, 2-2":
                selection("group", "183");
                click();
                break;
            case "SL 21-1,2-3":
                selection("group", "186");
                click();
                break;
            case "SL 21-1,3-3":
                selection("group", "187");
                click();
                break;
            case "SL 21-1.1-3":
                selection("group", "185");
                click();
                break;
        }
    }

    public void click() {
        // ww.loadUrl("javascript:$(document.querySelector(\"input.inputbutton.special\")).click();");
        ww.loadUrl("javascript:viewWeek();");
    }

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
    }

    public void selection(String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas + "').val('" + val + "').change();");

    }

    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }

}
