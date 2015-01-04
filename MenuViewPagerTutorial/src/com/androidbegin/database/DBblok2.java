package com.androidbegin.database;

/**
 * Created by dinar on 12/31/2014.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBblok2 {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_R1 = "namaKRT";
    public static final String KEY_R2A = "0-4 tahun";
    public static final String KEY_R2B = "5-9 tahun";
    public static final String KEY_R2C = "10+ tahun";
    public static final String KEY_R2D = "jumlah ART";

    private static final String TAG = "DBAdapter";

    private static final String DATABASE_NAME = "Blok2";
    private static final String DATABASE_TABLE = "Dua";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table Dua (_id integer primary key autoincrement, "
            +KEY_R1+" text not null,  "+KEY_R2A+" text not null, "+
             KEY_R2B+ "text not null, "+KEY_R2C+ "text not null, "+
             KEY_R2D+ "text not null);";

    private final Context context;

    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBblok2(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " +oldVersion
            +" to " + newVersion +",which will destroy all old data");
                    db.execSQL("DROP TABLE IF EXIST titles");
            onCreate(db);
        }
    }

    //---opens the database---
    public DBblok2 open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }

    //---insert a title into the database---
    public long insertDiutang(String nama, String nominal)
    {
        ContentValues initialValues = new ContentValues();
        //  initialValues.put(KEY_NAMA, nama);
        //  initialValues.put(KEY_NOMINAL, nominal);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }


    public boolean deleteDiutang(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID +
                "=" + rowId, null) > 0;
    }
}