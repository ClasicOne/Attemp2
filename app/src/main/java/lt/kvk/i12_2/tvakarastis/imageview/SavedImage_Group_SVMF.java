package lt.kvk.i12_2.tvakarastis.imageview;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import lt.kvk.i12_2.tvakarastis.R;


/**
 * Created by Meskius on 2/6/2018.
 */

public class SavedImage_Group_SVMF extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);
        ZoomableImageView imageView1 = (ZoomableImageView)findViewById(R.id.zoomableImageView);
        try {
            imageView1.setImageBitmap(BitmapFactory.decodeFile("/data/user/0/lt.kvk.i12_2.tvakarastis/files/SVMF.jpg"));
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
}