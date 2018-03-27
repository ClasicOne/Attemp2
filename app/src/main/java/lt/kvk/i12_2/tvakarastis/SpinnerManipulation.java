package lt.kvk.i12_2.tvakarastis;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by Meskius on 3/12/2018.
 */

public class SpinnerManipulation {
    public static void spinnerFill(String[] program, Spinner metai, Context context) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, program);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        metai.setAdapter(adapter);
    }
}
