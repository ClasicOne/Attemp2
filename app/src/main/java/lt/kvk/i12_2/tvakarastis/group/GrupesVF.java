package lt.kvk.i12_2.tvakarastis.group;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import lt.kvk.i12_2.tvakarastis.R;
import lt.kvk.i12_2.tvakarastis.SpinnerManipulation;
import lt.kvk.i12_2.tvakarastis.WebViewControls;
import lt.kvk.i12_2.tvakarastis.imageview.SavedImage_Group_VF;

/**
 * Created by Meskius on 10/24/2017.
 */

public class GrupesVF extends AppCompatActivity {
    WebView ww;
    String programText[] = {"--pasirinkti--", "Ištestinės", "Nuolatinės"};
    String yearMetaiNL[] = {"--pasirinkti--", "1", "2", "3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1", "2", "3", "4"};
    ProgressDialog progress;
    String[] email = {"v.zalys@kvk.lt"};


    String programSpinnerText,
            yearSpinnerText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grupes_tf);
        wwShit();
        ww = (WebView) findViewById(R.id.ww);
        final Spinner program = (Spinner) findViewById(R.id.program);
        final Spinner metai = (Spinner) findViewById(R.id.year);
        final Spinner grupe = (Spinner) findViewById(R.id.group);
        final TextView metaiText = (TextView) findViewById(R.id.year_text);
        final TextView grupeText = (TextView) findViewById(R.id.group_text);
        //<------------------------- Deklaruojamas Hashmap
        final HashMap<String, String> grupesHashmap = new HashMap<>();
        String[] grupes_str = getResources().getStringArray(R.array.grupes_SMF_str);
        String[] grupes_values = getResources().getStringArray(R.array.grupes_SMF_value);
        Log.e("Duck", "" + grupes_values.length + " " + grupes_str.length);
        for (int i = 0; i < grupes_str.length; i++)
            grupesHashmap.put(grupes_str[i], grupes_values[i]);
        //<-------------------------

        metai.setVisibility(View.GONE);
        grupe.setVisibility(View.GONE);
        metaiText.setVisibility(View.GONE);
        grupeText.setVisibility(View.GONE);

       SpinnerManipulation.spinnerFill(programText, program,this);

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
                if (!grupesHashmap.get(spinnerText).equals("duck")) {
                   WebViewControls.selectionOption("group", "" + grupesHashmap.get(spinnerText) + "",ww);
                    WebViewControls.click(ww,"javascript:viewWeek();");
                    ww.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        update();
    }

    private void wwShit() {
        WebViewControls.webViewSetting(ww);
        //ww.loadUrl("http://google.com");
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_smf/groups.php");
        ww.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                WebViewControls.hide(ww,"group");
            }
        });
    }



    private void year(Spinner grupe, TextView grupeText) {
        if (programSpinnerText.contains("Ištestinės"))
            switch (yearSpinnerText) {
                case "1":
                    SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_VF_ist_1), grupe,this);
                    WebViewControls.selectionOption("year", "1",ww);
                    WebViewControls.selectionOption("branch", "6",ww);
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_VF_ist_2), grupe,this);
                    WebViewControls.selectionOption("year", "2",ww);
                    WebViewControls.selectionOption("branch", "7",ww);
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_VF_ist_3), grupe,this);
                    WebViewControls.selectionOption("year", "3",ww);
                    WebViewControls.selectionOption("branch", "4",ww);
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "4":
                    SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_VF_ist_4), grupe,this);
                    WebViewControls.selectionOption("year", "4",ww);
                    WebViewControls.selectionOption("branch", "1",ww);
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                default:
                    break;
            }
        if (programSpinnerText.contains("Nuolatinės"))
            switch (yearSpinnerText) {
                case "1":
                    SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_VF_n_1), grupe,this);
                    WebViewControls.selectionOption("year", "1",ww);
                    WebViewControls.selectionOption("branch", "5",ww);
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "2":
                    SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_VF_n_2), grupe,this);
                    WebViewControls.selectionOption("year", "2",ww);
                    WebViewControls.selectionOption("branch", "3",ww);
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                case "3":
                    SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_VF_n_3), grupe,this);
                    WebViewControls.selectionOption("year", "3",ww);
                    WebViewControls.selectionOption("branch", "2",ww);
                    grupe.setVisibility(View.VISIBLE);
                    grupeText.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
    }

    private void program(Spinner metai, TextView metaiText) {
        switch (programSpinnerText) {
            case "Ištestinės":
                SpinnerManipulation.spinnerFill(yearMetaiIST, metai,this);
                WebViewControls.selectionOption("program", "1",ww);
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            case "Nuolatinės":
                SpinnerManipulation.spinnerFill(yearMetaiNL, metai,this);
                WebViewControls.selectionOption("program", "2",ww);
                metai.setVisibility(View.VISIBLE);
                metaiText.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.smf_grupes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                restartActivity();
                break;
            case R.id.saveImage:
                ww.getSettings().setUseWideViewPort(true);
                ww.setInitialScale(1);

                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    saveImage();

                                }
                            });

                            // ww.setInitialScale(0);
                            Log.e("Duck", ": Timer");
                        } catch (Exception e) {
                            // Log.e("Duck", "" + e.getMessage() + ": Timer");
                            // e.printStackTrace();

                        }
                    }
                }, (300));


                break;
            case R.id.showImage:

                try {
                    File temp = new File("/data/user/0/lt.kvk.i12_2.tvakarastis/files/VF.jpg");
                    Intent intent = new Intent(GrupesVF.this, SavedImage_Group_VF.class);
                    startActivity(intent);
                } catch (NullPointerException e) {
                }


        }
        return super.onOptionsItemSelected(item);
    }

    private void saveImage() {


        Picture picture = ww.capturePicture();
        Bitmap b = Bitmap.createBitmap(picture.getWidth(),
                picture.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);

        picture.draw(c);
        FileOutputStream fos;
        try {
            fos = openFileOutput("VF.jpg", Context.MODE_PRIVATE);
            if (fos != null) {
                b.compress(Bitmap.CompressFormat.JPEG, 100, fos);

                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            String a = e.getMessage();
            Log.e("Duck", e.getMessage());
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            ww.getSettings().setUseWideViewPort(false);
                            ww.setInitialScale(0);
                        }
                    });
                    Log.e("Duck", ": Timer");
                } catch (Exception e) {
                    // Log.e("Duck", "" + e.getMessage() + ": Timer");
                    // e.printStackTrace();

                }
            }
        }, (550));


    }

    public void restartActivity() {
        Intent mIntent = getIntent();
        finish();
        startActivity(mIntent);
    }

    public void update() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/prof.php").get();
                } catch (Exception e) {
                    Log.e("Duck", "" + e.getMessage() + ":");
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progress = new ProgressDialog(GrupesVF.this);
                            progress.setTitle("Napavyksta gauti duomenų iš serverio");
                            progress.setMessage("Galimos priežastys: \n1. Nesate pasijungę interneto ryšį,\n" +
                                    "2. Gali būti problemos serverio pusėje.\n" +
                                    "Sprendimas:\n" +
                                    "Pasitikrinkite interneto prieigą ir bandykite patikrinti vėliau. ");
                            progress.setIndeterminate(true);
                            progress.setCancelable(true); // disable dismiss by tapping outside of the dialog
                            progress.setButton(DialogInterface.BUTTON_POSITIVE, "Pranešti administratoriui", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    composeEmail(email, "Neveikia tvarkaraščiai",
                                            "Sveiki,\n" +
                                                    "Neina pamatyti tvarkaraščių, todėl reikia patikrinti ar jie yra tinkamai publikuojami.");

                                    //dialogInterface.dismiss();
                                }
                            });
                            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progress.show();
                            timer();
                        }
                    });
                }
            }
        }).start();
    }

    public void timer() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/prof.php").get();
                    progress.cancel();
                } catch (Exception e) {
                    // Log.e("Duck", "" + e.getMessage() + ": Timer");
                    // e.printStackTrace();
                    timer();
                }
            }
        }, (50));
    }

    public void composeEmail(String[] addresses, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
