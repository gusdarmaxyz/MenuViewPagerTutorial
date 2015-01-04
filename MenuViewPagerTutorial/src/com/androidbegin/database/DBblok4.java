package com.androidbegin.database;

import java.util.List;

import com.androidbegin.objekblok.objekblok4;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBblok4 {
    public static final String KEY_B4R1 = "b4r1";
    public static final String KEY_B4R2 = "b4r2";
    public static final String KEY_B4R3 = "b4r3";
    public static final String KEY_B4R4 = "b4r4";
    public static final String KEY_B4R5 = "b4r5";
    public static final String KEY_B4R6 = "b4r6";
    public static final String KEY_B4R7 = "b4r7";
    public static final String KEY_B4R8 = "b4r8";
    public static final String KEY_KKSART = "kksArt";
    public static final String KEY_KKSB1 = "kksb1";
    
    
    
    private static final String TAG = "DBAdapter";
    
    private static final String DATABASE_NAME = "susenaskor2007";
    private static final String DATABASE_TABLE = "b4";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
        "create table b4 ("+KEY_B4R1+" int(2) not null, "
        +KEY_B4R2+" text not null, "+KEY_B4R3+" int(1) not null, " +
        KEY_B4R4+" int(1) not null, "+KEY_B4R5+" int(2) not null, "+
        KEY_B4R6+" int(1) not null, " +KEY_B4R7+" int(1) , "+
        KEY_B4R8+" text(1), "+KEY_KKSART+" text(20) primary key not null, "+
        KEY_KKSB1+" text(18) not null);";
        
    private final Context context; 
    
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBblok4(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS titles");
            onCreate(db);
        }
    }    
    
    //---opens the database---
    public DBblok4 open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
    
    public void insert(List<objekblok4> listB4){//ini method buat insert data ke DB. data diambil dari arraylist
		for(objekblok4 mb4: listB4){
			ContentValues value=new ContentValues();
			value.put(KEY_B4R1, mb4.getB4R1());
			value.put(KEY_B4R2, mb4.getB4R2());
			value.put(KEY_B4R3, mb4.getB4R3());
			value.put(KEY_B4R4, mb4.getB4R4());
			value.put(KEY_B4R5, mb4.getB4R5());
			value.put(KEY_B4R6, mb4.getB4R6());
			value.put(KEY_B4R7, mb4.getB4R7());
			value.put(KEY_B4R8, mb4.getB4R8());
			value.put(KEY_KKSART, mb4.getKksArt());
			value.put(KEY_KKSB1, mb4.getKksb1());
			db.insert(DATABASE_TABLE, null, value);
		}
	}

}