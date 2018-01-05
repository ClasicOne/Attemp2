package lt.kvk.i12_2.tvakarastis;

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
        setContentView(R.layout.tfmenu);

        Button grupes = (Button)findViewById(R.id.btnGrupes);

        Button destytojai = (Button)findViewById(R.id.btnDestytojai);
        Button auditorijos = (Button)findViewById(R.id.btnAuditorijos);


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
