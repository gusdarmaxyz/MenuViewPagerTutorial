package com.androidbegin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBBlok5a 
{
    public static final String KEY_ROWID = "_id";
    public static final String KEY_B5R1a = "b5ar1panas";
    public static final String KEY_B5R1b = "b5ar1batuk";
    public static final String KEY_B5R1c = "b5ar1pilek";
    public static final String KEY_B5R1d = "b5ar1asma";
    public static final String KEY_B5R1e = "b5ar1diare";
    public static final String KEY_B5R1f = "b5ar1sakitkepala";
    public static final String KEY_B5R1g = "b5ar1sakitgigi";
    public static final String KEY_B5R1h = "b5ar1lainnya";
    public static final String KEY_B5R2 = "b5ar2";
    public static final String KEY_B5R3 = "b5ar3";
    public static final String KEY_B5R4 = "b5ar4";
    public static final String KEY_B5R5 = "b5ar5";
    public static final String KEY_B5R6a = "b5ar6RSpemerintah";
    public static final String KEY_B5R6b = "b5ar6RSswasta";
    public static final String KEY_B5R6c = "b5ar6Poliklinik";
    public static final String KEY_B5R6d = "b5ar6Puskesmas";
    public static final String KEY_B5R6e = "b5ar6Nakes";
    public static final String KEY_B5R6f = "b5ar6Batra";
    public static final String KEY_B5R6g = "b5ar6Dukunbersalin";
    public static final String KEY_B5R6h = "b5ar6lainnya";
    public static final String KEY_B5R7 = "b5ar7";
    public static final String KEY_B5R8a = "b5ar8RSpemerintah";
    public static final String KEY_B5R8b = "b5ar8RSswasta";
    public static final String KEY_B5R8c = "b5ar8Puskesmas";
    public static final String KEY_B5R8d = "b5ar8Nakes";
    public static final String KEY_B5R8e = "b5ar8Batra";
    public static final String KEY_B5R8f = "b5ar8lainnya";
    
    
    
    private static final String TAG = "DBAdapter";
    
    private static final String DATABASE_NAME = "SusenasKor2007";
    private static final String DATABASE_TABLE = "blok5a";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
        "create table blok5a (_id integer primary key autoincrement, "
        + KEY_B5R1a+" TEXT ,"+ KEY_B5R1b+" TEXT ,"+ KEY_B5R1c +" TEXT ,"
        + KEY_B5R1d+" TEXT ,"+ KEY_B5R1e+" TEXT ,"+ KEY_B5R1f+" TEXT ,"
        + KEY_B5R1g+" TEXT ,"+ KEY_B5R1h+" TEXT ,"+ KEY_B5R2+" TEXT ,"
        + KEY_B5R3+" TEXT ,"+ KEY_B5R4+" TEXT ,"+ KEY_B5R5+" TEXT ,"
        + KEY_B5R6a+" TEXT ,"+ KEY_B5R6b+" TEXT ,"+ KEY_B5R6c+" TEXT ,"
        + KEY_B5R6d+" TEXT ,"+ KEY_B5R6e+" TEXT ,"+ KEY_B5R6f+" TEXT ,"
        + KEY_B5R6g+" TEXT ,"+ KEY_B5R6h+" TEXT ,"+ KEY_B5R7+" TEXT ,"
        + KEY_B5R8a+" TEXT ,"+ KEY_B5R8b+" TEXT ,"+ KEY_B5R8c+" TEXT ,"
        + KEY_B5R8d+" TEXT ,"+ KEY_B5R8e+" TEXT ,"+ KEY_B5R8f+" TEXT );";
        
    private final Context context; 
    
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBBlok5a(Context ctx) 
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
    public DBBlok5a open() throws SQLException 
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
    public long insertBlok5a(String R1[], String R2,String  R3, String R4, String R5, 
    		String R6[], String R7, String R8[]) 
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_B5R1a, R1[0]);
        initialValues.put(KEY_B5R1b, R1[1]);
        initialValues.put(KEY_B5R1c, R1[2]);
        initialValues.put(KEY_B5R1d, R1[3]);
        initialValues.put(KEY_B5R1e, R1[4]);
        initialValues.put(KEY_B5R1f, R1[5]);
        initialValues.put(KEY_B5R1g, R1[6]);
        initialValues.put(KEY_B5R1h, R1[7]);
        initialValues.put(KEY_B5R2, R2);
        initialValues.put(KEY_B5R3, R3);
        initialValues.put(KEY_B5R4, R4);
        initialValues.put(KEY_B5R5, R5);
        initialValues.put(KEY_B5R6a, R6[0]);
        initialValues.put(KEY_B5R6b, R6[1]);
        initialValues.put(KEY_B5R6c, R6[2]);
        initialValues.put(KEY_B5R6d, R6[3]);
        initialValues.put(KEY_B5R6e, R6[4]);
        initialValues.put(KEY_B5R6f, R6[5]);
        initialValues.put(KEY_B5R6g, R6[6]);
        initialValues.put(KEY_B5R6h, R6[7]);
        initialValues.put(KEY_B5R7, R7);
        initialValues.put(KEY_B5R8a, R8[0]);
        initialValues.put(KEY_B5R8b, R8[1]);
        initialValues.put(KEY_B5R8c, R8[2]);
        initialValues.put(KEY_B5R8d, R8[3]);
        initialValues.put(KEY_B5R8e, R8[4]);
        initialValues.put(KEY_B5R8f, R8[5]);
        
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---deletes a particular title---
    public boolean deleteBlok5a(long rowId) 
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + 
        		"=" + rowId, null) > 0;
    }

    //---retrieves all the titles---
    public Cursor getAllBlok5a() 
    {
        return db.query(DATABASE_TABLE, new String[] {
        		KEY_ROWID, 
        		KEY_B5R1a,
        		KEY_B5R1b,
        		KEY_B5R1c,
        		KEY_B5R1d,
        		KEY_B5R1e,
        		KEY_B5R1f,
        		KEY_B5R1g,
        		KEY_B5R1h,
        		KEY_B5R2,
        		KEY_B5R3,
        		KEY_B5R4,
        		KEY_B5R5, 
        		KEY_B5R6a,
        		KEY_B5R6b,
        		KEY_B5R6c,
        		KEY_B5R6d,
        		KEY_B5R6e,
        		KEY_B5R6f,
        		KEY_B5R6g,
        		KEY_B5R6h,
        		KEY_B5R7,
        		KEY_B5R8a,
        		KEY_B5R8b,
        		KEY_B5R8c,
        		KEY_B5R8d,
        		KEY_B5R8e,
        		KEY_B5R8f}, 
                null, 
                null, 
                null, 
                null, 
                null);
    }

    //---retrieves a particular title---
    public Cursor getBlok5a(long rowId) throws SQLException 
    {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {
                		KEY_ROWID, 
                		KEY_B5R1a,
                		KEY_B5R1b,
                		KEY_B5R1c,
                		KEY_B5R1d,
                		KEY_B5R1e,
                		KEY_B5R1f,
                		KEY_B5R1g,
                		KEY_B5R1h,
                		KEY_B5R2,
                		KEY_B5R3,
                		KEY_B5R4,
                		KEY_B5R5, 
                		KEY_B5R6a,
                		KEY_B5R6b,
                		KEY_B5R6c,
                		KEY_B5R6d,
                		KEY_B5R6e,
                		KEY_B5R6f,
                		KEY_B5R6g,
                		KEY_B5R6h,
                		KEY_B5R7,
                		KEY_B5R8a,
                		KEY_B5R8b,
                		KEY_B5R8c,
                		KEY_B5R8d,
                		KEY_B5R8e,
                		KEY_B5R8f}, 
                		KEY_ROWID + "=" + rowId, 
                		null,
                		null, 
                		null, 
                		null, 
                		null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---updates a title---
    public boolean updateDiutang(long rowId, String isbn, 
    String title) 
    {
    	//Nanti dulu lah
        ContentValues args = new ContentValues();
        //args.put(KEY_NAMA, isbn);
        //args.put(KEY_NOMINAL, title);
        return db.update(DATABASE_TABLE, args, 
                         KEY_ROWID + "=" + rowId, null) > 0;
    }
}
