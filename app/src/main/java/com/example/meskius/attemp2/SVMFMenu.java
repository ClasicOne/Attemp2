package com.example.meskius.attemp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Meskius on 10/25/2017.
 */

public class SVMFMenu extends AppCompatActivity {
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
        dalykai.setVisibility(View.GONE);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SVMFMenu.this,Fakultetai.class);
                startActivity(intent);
            }
        });
        grupes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SVMFMenu.this,GrupesSVMF.class);
                startActivity(intent);
            }
        });

        destytojai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SVMFMenu.this,DestytojaiSVMF.class);
                startActivity(intent);
            }
        });
        auditorijos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SVMFMenu.this,AuditorijosSVMF.class);
                startActivity(intent);
            }
        });




    }
}
