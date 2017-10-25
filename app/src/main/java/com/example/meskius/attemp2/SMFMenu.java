package com.example.meskius.attemp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Meskius on 10/24/2017.
 */

public class SMFMenu extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smfmenu);
        Intent intent= getIntent();

        TextView grupes = (TextView)findViewById(R.id.grupesTF);
        TextView dalykai = (TextView)findViewById(R.id.dalykaiTF);
        TextView destytojai = (TextView)findViewById(R.id.destytojaiTF);
        TextView auditorijos = (TextView)findViewById(R.id.auditorijosTF);
        TextView auditorijosvaiz = (TextView)findViewById(R.id.auditorijuvaizTF);
        auditorijosvaiz.setVisibility(View.GONE);

        Button back=(Button)findViewById(R.id.backTF);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SMFMenu.this,Fakultetai.class);
                startActivity(intent);
            }
        });
        grupes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SMFMenu.this,GrupesSMF.class);
                startActivity(intent);
            }
        });
        /*dalykai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SMFMenu.this,DalykaiTF.class);
                startActivity(intent);
            }
        });
        destytojai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SMFMenu.this,DestytojaiTF.class);
                startActivity(intent);
            }
        });
        auditorijos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SMFMenu.this,AuditorijosTF.class);
                startActivity(intent);
            }
        });
        auditorijosvaiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SMFMenu.this,AuditorijuVaizdavimasTF.class);
                startActivity(intent);
            }
        });*/



    }
}
