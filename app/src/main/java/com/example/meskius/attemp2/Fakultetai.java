package com.example.meskius.attemp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Meskius on 10/23/2017.
 */

public class Fakultetai extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fakultetai);

        Intent intent= getIntent();

        TextView tf=(TextView)findViewById(R.id.tf);
        TextView smf=(TextView)findViewById(R.id.socialiniuMF);
        TextView sveikatosmf=(TextView)findViewById(R.id.sveikatosMF);

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

    }
}