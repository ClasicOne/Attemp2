package com.example.meskius.attemp2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Meskius on 10/23/2017.
 */

public class TFMenu extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tfmenu);
        Intent intent= getIntent();

        TextView grupes = (TextView)findViewById(R.id.grupesTF);

        TextView destytojai = (TextView)findViewById(R.id.destytojaiTF);
        TextView auditorijos = (TextView)findViewById(R.id.auditorijosTF);

        grupes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TFMenu.this,GrupesTF.class);
                startActivity(intent);
            }
        });
        destytojai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TFMenu.this,DestytojaiTF.class);
                startActivity(intent);
            }
        });
        auditorijos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TFMenu.this,AuditorijosTF.class);
                startActivity(intent);
            }
        });

    }

}
