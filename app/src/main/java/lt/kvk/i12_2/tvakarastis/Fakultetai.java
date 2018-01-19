package lt.kvk.i12_2.tvakarastis;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.jsoup.Jsoup;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Meskius on 10/23/2017.
 */

public class Fakultetai extends AppCompatActivity {
    ProgressDialog progress;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fakultetai);

        ImageButton tf=(ImageButton) findViewById(R.id.tf);
        ImageButton smf=(ImageButton) findViewById(R.id.smf);
        ImageButton svsmf=(ImageButton) findViewById(R.id.svmf);
        TextView about =(TextView) findViewById(R.id.about);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fakultetai.this,Renginiai.class);
                startActivity(intent);
            }
        });

        tf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fakultetai.this,TFMenu.class);
                startActivity(intent);
            }
        });
        tf.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Fakultetai.this,GrupesTF.class);
                startActivity(intent);
                return false;
            }
        });
        smf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fakultetai.this,VFMenu.class);
                startActivity(intent);
            }
        });
        smf.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Fakultetai.this,GrupesVF.class);
                startActivity(intent);
                return false;
            }
        });


        svsmf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fakultetai.this,SVMFMenu.class);
                startActivity(intent);
            }
        });
        svsmf.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Fakultetai.this,GrupesSVMF.class);
                startActivity(intent);
                return false;
            }
        });


        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fakultetai.this,About.class);
                startActivity(intent);
            }
        });
        update();

    }

    public  void update() {
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/prof.php").get();
                }catch (Exception e){
                    Log.e("Duck",""+ e.getMessage()+":" );
                    e.printStackTrace();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progress = new ProgressDialog(Fakultetai.this);
                            progress.setTitle("Atsiprašome už nepatogumus");
                            progress.setMessage("Serveris nepasiekiamas. \nBandykite vėliau    (._.)");
                            progress.setIndeterminate(true);
                            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
                            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progress.show();
                            timer();
                        }
                    });
                }
            }
        }).start();
    }
    public void timer(){
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Jsoup.connect("http://is.kvk.lt/Tvarkarasciai_tf/prof.php").get();
                    progress.cancel();
                }catch (Exception e) {
                    Log.e("Duck", "" + e.getMessage() + ": Timer");
                    e.printStackTrace();
                    timer();
                }
            }        }, (50));
    }
}
