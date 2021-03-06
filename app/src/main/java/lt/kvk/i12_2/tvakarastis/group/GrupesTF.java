package lt.kvk.i12_2.tvakarastis.group;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import lt.kvk.i12_2.tvakarastis.R;
import lt.kvk.i12_2.tvakarastis.SpinnerManipulation;
import lt.kvk.i12_2.tvakarastis.WebViewControls;
import lt.kvk.i12_2.tvakarastis.imageview.SavedImage_Group_TF;


public class GrupesTF extends AppCompatActivity {
    TextView text;
    WebView ww;
    //-------------------------
    String programSpinnerText;
    String yearSpinnerText;
    String programTipas[] = {"--pasirinkti--", "IŠT", "NL"};
    String yearMetaiNL[] = {"--pasirinkti--", "1", "2", "3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1", "2", "3", "4"};
    ProgressDialog progress;
    String[] email = {"v.zalys@kvk.lt"};

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grupes_tf);


        final Spinner programID = (Spinner) findViewById(R.id.program);
        final Spinner metaiID = (Spinner) findViewById(R.id.year);
        final Spinner grupeID = (Spinner) findViewById(R.id.group);
        final TextView grupe = (TextView) findViewById(R.id.group_text);
        final TextView metai = (TextView) findViewById(R.id.year_text);


        text = (TextView) findViewById(R.id.text);
        //<------ Deklaruojamas Hashmap
        final HashMap<String, String> grupesHashmap = new HashMap<>();
        String[] grupes_str = getResources().getStringArray(R.array.grupes_TF_str);
        String[] grupes_values = getResources().getStringArray(R.array.grupes_TF_value);
        //Log.e("Duck",""+grupes_values.length+" "+ grupes_str.length );
        for (int i = 0; i < grupes_str.length; i++) {
            Log.i("Duck", grupes_str[i] + " " + grupes_values[i]);
            grupesHashmap.put(grupes_str[i], grupes_values[i]);
        }
        //<-------------------------

        metaiID.setVisibility(View.GONE);
        grupeID.setVisibility(View.GONE);
        metai.setVisibility(View.GONE);
        grupe.setVisibility(View.GONE);

        SpinnerManipulation.spinnerFill(programTipas, programID, this);

        programID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                programSpinnerText = adapterView.getSelectedItem().toString();

                switch (programSpinnerText) {
                    case "IŠT":
                        SpinnerManipulation.spinnerFill(yearMetaiIST, metaiID,GrupesTF.this);
                        WebViewControls.selectionOption("program", "2",ww);
                        metai.setVisibility(View.VISIBLE);
                        metaiID.setVisibility(View.VISIBLE);
                        break;
                    case "NL":
                        SpinnerManipulation.spinnerFill(yearMetaiNL, metaiID,GrupesTF.this);
                        WebViewControls.selectionOption("program", "1",ww);
                        metai.setVisibility(View.VISIBLE);
                        metaiID.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        metaiID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                yearSpinnerText = adapterView.getSelectedItem().toString();
                if (programSpinnerText.indexOf("IŠT") != -1)
                    switch (yearSpinnerText) {
                        case "1":
                            SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_TF_IST_1), grupeID, GrupesTF.this);
                            WebViewControls.selectionOption("year", "1",ww);
                            WebViewControls.selectionOption("branch", "8",ww);
                            grupe.setVisibility(View.VISIBLE);
                            grupeID.setVisibility(View.VISIBLE);
                            break;
                        case "2":
                            SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_TF_IST_2), grupeID, GrupesTF.this);
                            WebViewControls.selectionOption("year", "2",ww);
                            WebViewControls.selectionOption("branch", "5",ww);
                            grupe.setVisibility(View.VISIBLE);
                            grupeID.setVisibility(View.VISIBLE);
                            break;
                        case "3":
                            SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_TF_IST_3), grupeID, GrupesTF.this);
                            WebViewControls.selectionOption("year", "3",ww);
                            WebViewControls.selectionOption("branch", "4",ww);
                            grupe.setVisibility(View.VISIBLE);
                            grupeID.setVisibility(View.VISIBLE);
                            break;
                        case "4":
                            SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_TF_IST_4), grupeID, GrupesTF.this);
                            WebViewControls.selectionOption("year", "4",ww);
                            WebViewControls.selectionOption("branch", "7",ww);
                            grupe.setVisibility(View.VISIBLE);
                            grupeID.setVisibility(View.VISIBLE);
                        default:
                            break;

                    }
                else switch (yearSpinnerText) {
                    case "1":
                        SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_TF_NL_1), grupeID, GrupesTF.this);
                        WebViewControls.selectionOption("year", "1",ww);
                        WebViewControls.selectionOption("branch", "1",ww);
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "2":
                        SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_TF_NL_2), grupeID, GrupesTF.this);
                        WebViewControls.selectionOption("year", "2",ww);
                        WebViewControls.selectionOption("branch", "2",ww);
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "3":
                        SpinnerManipulation.spinnerFill(getResources().getStringArray(R.array.G_TF_NL_3), grupeID, GrupesTF.this);
                        WebViewControls.selectionOption("year", "3",ww);
                        WebViewControls.selectionOption("branch", "3",ww);
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        grupeID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spinnerText = adapterView.getSelectedItem().toString();
                Log.e("Duck", "" + spinnerText + ":" + grupesHashmap.get(spinnerText));
                if (!grupesHashmap.get(spinnerText).equals("duck")) {
                    WebViewControls.selectionOption("group", "" + grupesHashmap.get(spinnerText) + "",ww);
                    ww.setVisibility(View.VISIBLE);
                    WebViewControls.click(ww, "javascript:viewWeek();");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        wwShiet();
    }

    private void wwShiet() {
        ww = (WebView) findViewById(R.id.ww);
        WebSettings webSettings = ww.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ww.getSettings().setSupportZoom(true);
        ww.getSettings().setBuiltInZoomControls(true);
        ww.getSettings().setDisplayZoomControls(false);
        ww.setWebChromeClient(new WebChromeClient());
        //  ww.buildDrawingCache(true);
        //webSettings.setLoadWithOverviewMode(true);
        //ww.loadUrl("http://google.com");
//
        ww.loadUrl("http://is.kvk.lt/Tvarkarasciai_tf/groups.php");
        ww.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //  saveImage();
                WebViewControls.hide(ww, "group");
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });
        update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tf_grupes, menu);
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
                    File temp = new File("/data/user/0/lt.kvk.i12_2.tvakarastis/files/saved.jpg");
                    Intent intent = new Intent(GrupesTF.this, SavedImage_Group_TF.class);
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
            fos = openFileOutput("TF.jpg", Context.MODE_PRIVATE);
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
                            progress = new ProgressDialog(GrupesTF.this);
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