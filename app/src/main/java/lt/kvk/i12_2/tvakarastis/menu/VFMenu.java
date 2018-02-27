package lt.kvk.i12_2.tvakarastis.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import lt.kvk.i12_2.tvakarastis.classroom.AuditorijosVF;
import lt.kvk.i12_2.tvakarastis.prof.DestytojaiVF;
import lt.kvk.i12_2.tvakarastis.group.GrupesVF;
import lt.kvk.i12_2.tvakarastis.R;

/**
 * Created by Meskius on 10/24/2017.
 */

public class VFMenu extends AppCompatActivity{
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
                Intent intent = new Intent(VFMenu.this,GrupesVF.class);
                startActivity(intent);
            }
        });
        destytojai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VFMenu.this,DestytojaiVF.class);
                startActivity(intent);
            }
        });
        auditorijos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VFMenu.this,AuditorijosVF.class);
                startActivity(intent);
            }
        });
    }

}
