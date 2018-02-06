package lt.kvk.i12_2.tvakarastis;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Meskius on 2/6/2018.
 */

public class SavedImageTF extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);
        ImageView imageView ;
        imageView = (ImageView) findViewById(R.id.imageViewSaved);
        imageView.setImageBitmap(BitmapFactory.decodeFile("/data/user/0/lt.kvk.i12_2.tvakarastis/files/saved.jpg"));
    }
}