package lt.kvk.i12_2.tvakarastis;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
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
                Intent intent = new Intent(Fakultetai.this,SMFMenu.class);
                startActivity(intent);
            }
        });
        smf.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Fakultetai.this,GrupesSMF.class);
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
    }
}