package lt.kvk.i12_2.tvakarastis;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Meskius on 2017-12-04.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String TAG = "Databasehelper";
    private static final String TABLE_NAME = "destytojai_tf_table";
    private static final String COL0 = "ID";
    private static final String COL1 = "name";
    private static final String COL2 = "value";

    public DatabaseHelper(Context context) {
        super(context, "Destytojai.db", null, 1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+ TABLE_NAME + " (ID INTEGER PRImaryY KEY AUTOINCREMENT, " + COL1 + " TEXT, "+ COL2 +" TEXT)";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(String item, String value){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "insert into "+ TABLE_NAME + " ("+COL1+", " + COL2 +") values ('"+item+"', '"+value+"')";
        db.execSQL(query);
        Log.i(TAG,"addData: Adding " + item + " to "+ TABLE_NAME);

        //long result = db.insert(TABLE_NAME,null,contentValues);
        if(item != null)
            return false;
        else
            return true;
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select "+COL1+" from "+ TABLE_NAME;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}
