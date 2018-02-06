package lt.kvk.i12_2.tvakarastis;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;
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

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class GrupesTF extends AppCompatActivity {
    TextView text;
    WebView ww;
    //-------------------------
    String programSpinnerText;
    String yearSpinnerText;
    String programTipas[] = {"--pasirinkti--", "IŠT", "NL"};
    String yearMetaiNL[] = {"--pasirinkti--", "1", "2", "3"};
    String yearMetaiIST[] = {"--pasirinkti--", "1", "2", "3", "4"};

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

        spinner(programTipas, programID);

        programID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                programSpinnerText = adapterView.getSelectedItem().toString();

                switch (programSpinnerText) {
                    case "IŠT":
                        spinner(yearMetaiIST, metaiID);
                        selection("program", "2");
                        metai.setVisibility(View.VISIBLE);
                        metaiID.setVisibility(View.VISIBLE);
                        break;
                    case "NL":
                        spinner(yearMetaiNL, metaiID);
                        selection("program", "1");
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
                            spinner(getResources().getStringArray(R.array.G_TF_IST_1), grupeID);
                            selection("year", "1");
                            selection("branch", "8");
                            grupe.setVisibility(View.VISIBLE);
                            grupeID.setVisibility(View.VISIBLE);
                            break;
                        case "2":
                            spinner(getResources().getStringArray(R.array.G_TF_IST_2), grupeID);
                            selection("year", "2");
                            selection("branch", "5");
                            grupe.setVisibility(View.VISIBLE);
                            grupeID.setVisibility(View.VISIBLE);
                            break;
                        case "3":
                            spinner(getResources().getStringArray(R.array.G_TF_IST_3), grupeID);
                            selection("year", "3");
                            selection("branch", "4");
                            grupe.setVisibility(View.VISIBLE);
                            grupeID.setVisibility(View.VISIBLE);
                            break;
                        case "4":
                            spinner(getResources().getStringArray(R.array.G_TF_IST_4), grupeID);
                            selection("year", "4");
                            selection("branch", "7");
                            grupe.setVisibility(View.VISIBLE);
                            grupeID.setVisibility(View.VISIBLE);
                        default:
                            break;

                    }
                else switch (yearSpinnerText) {
                    case "1":
                        spinner(getResources().getStringArray(R.array.G_TF_NL_1), grupeID);
                        selection("year", "1");
                        selection("branch", "1");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "2":
                        spinner(getResources().getStringArray(R.array.G_TF_NL_2), grupeID);
                        selection("year", "2");
                        selection("branch", "2");
                        grupe.setVisibility(View.VISIBLE);
                        grupeID.setVisibility(View.VISIBLE);
                        break;
                    case "3":
                        spinner(getResources().getStringArray(R.array.G_TF_NL_3), grupeID);
                        selection("year", "3");
                        selection("branch", "3");
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
                    selection("group", "" + grupesHashmap.get(spinnerText) + "");
                    ww.setVisibility(View.VISIBLE);
                    click();
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
                hide();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                Context context = getApplicationContext();
                Toast.makeText(context, "Oh no!", Toast.LENGTH_SHORT).show();
            }
        });

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
        ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[4]).hide()");
        ww.loadUrl("javascript:$(document.querySelectorAll(\"div\")[3]).hide()");
    }

    public void selection(String pasirinkimas, String val) {

        ww.loadUrl("javascript:$('#" + pasirinkimas + "').val('" + val + "').change();");

    }

    public void spinner(String[] program, Spinner metai) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
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
                        }catch (Exception e) {
                            // Log.e("Duck", "" + e.getMessage() + ": Timer");
                            // e.printStackTrace();

                        }
                    }        }, (300));


                break;
            case R.id.showImage:

                try{
                  File temp = new File  ("/data/user/0/lt.kvk.i12_2.tvakarastis/files/saved.jpg");
                  Intent intent = new Intent(GrupesTF.this, SavedImage_Group_TF.class);
                  startActivity(intent);
                }catch (NullPointerException e){
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
}