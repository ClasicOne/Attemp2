package lt.kvk.i12_2.tvakarastis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Meskius on 2017-12-06.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "destytojai.db";
    public static final String TABLE_PROF = "TF";
    public static final String COLMN_ID = "_id";
    public static final String COLMN_VALUE = "value";
    public static final String COLMN_PROF = "str";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE "+ TABLE_PROF + " (" +
                COLMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLMN_VALUE + " TEXT, " +
                COLMN_PROF + " TEXT);";
        db.execSQL(createTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVertion, int newVersion) {
        db.execSQL("drop table "+ TABLE_PROF);
    }
    public void addProduct(String str, String value){
        ContentValues values = new ContentValues();
        values.put(COLMN_PROF, str);
        values.put(COLMN_VALUE,value);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PROF, null, values);
        db.close();
    }
    public void createTable(){
        String createTable = "CREATE TABLE "+ TABLE_PROF + " (" +
                COLMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLMN_VALUE + " TEXT, " +
                COLMN_PROF + " TEXT);";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(createTable);
    }
    public void deleteDB(){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("drop table if exists "+ TABLE_PROF +"; ");
    }
    // Delete a row in db

    public void  deleteRow(String name){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from "+ TABLE_PROF + " where "+ COLMN_PROF + " =\""+name+ "\";");
    }
    // Print out db as string
    public String dbToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PROF +" WHERE 1";

        Cursor cursor = db.rawQuery(query, null );
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            if (cursor.getString(cursor.getColumnIndex("str")) != null){
                dbString += cursor.getString(cursor.getColumnIndex("str"));
                dbString += "\n";
            }
        }
        db.close();
        return dbString;
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select "+COLMN_VALUE+", "+COLMN_PROF+" from "+ TABLE_PROF;
        Cursor data = db.rawQuery(query,null);
        return data;
    }
}
