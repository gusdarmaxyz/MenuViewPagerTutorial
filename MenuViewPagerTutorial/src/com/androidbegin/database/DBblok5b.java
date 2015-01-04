package com.androidbegin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBblok5b {
	public final static String B5R9a="b5r9a";
	public final static String B5R9b="b5r9b";
	public final static String B5R10a="b5r10a";
	public final static String B5R10b="b5r10b";
	public final static String B5R11a="b5r11a";
	public final static String B5R11b="b5r11b";
	public final static String B5R11c="b5r11c";
	public final static String B5R11d="b5r11d";
	public final static String B5R11e="b5r11e";
	public final static String B5R12a="b5r12a";
	public final static String B5R12b1="b5r12b1";
	public final static String B5R12b2="b5r12b2";
	public final static String B5R12b3="b5r12b3";
	
	public final static String NAMA_DATABASE = "susenaskor2007";
	public final static String NAMA_TABLE = "blok5b";
	public final static int VERSI_DATABASE = 1;
	private final static String TAG = "DBAdapter";
	
	private SQLiteDatabase db;
	private final Context context;
	private final DatabaseHelper dbhelper;
	
	public DBblok5b(Context ctx) 
    {
        this.context = ctx;
        dbhelper = new DatabaseHelper(context);
    }

private static class DatabaseHelper extends SQLiteOpenHelper 
    {
	
	//SQL untuk menciptakan tabel bernama Blok 1
	private final static String DATABASE_CREATE = "create table " + 
				NAMA_TABLE + " (" + 
				B5R9a + " text not null, " +
				B5R9b + " text not null, " +
				B5R10a + " text not null, " +
				B5R10b + " text not null, " +
				B5R11a + " text not null, " +
				B5R11b + " text not null, " +
				B5R11c + " text not null, " +
				B5R11d + " text not null, " +
				B5R11e + " text not null, " +
				B5R12a + " text not null, " +
				B5R12b1 + " text not null, " +
				B5R12b2 + " text not null, " +
				B5R12b3 + " text not null);";
	
        DatabaseHelper(Context context) 
        	{
            super(context, NAMA_DATABASE, null, VERSI_DATABASE);
        	}

        @Override
        public void onCreate(SQLiteDatabase db) 
        	{
        	try{
            db.execSQL(DATABASE_CREATE);
        	} catch (SQLiteException e){
        		
        	}
        	}

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
        	{
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + NAMA_TABLE);
            onCreate(db);
        	}
    }    
		

	//---opens the database---
public void open() throws SQLiteException 
	{
		try {
			db = dbhelper.getWritableDatabase();
		}catch(SQLiteException e){
			db = dbhelper.getReadableDatabase();
		}
	}

	//---closes the database---    
public void close() 
	{
    	db.close();
	}

	//Menyisipkan Data
public long insertData(String b5r9a, String b5r9b, String b5r10a, String b5r10b, String b5r11a, String b5r11b, String b5r11c, String b5r11d, String b5r11e, String b5r12a, String b5r12b1, String b5r12b2, String b5r12b3) {
	try {
		ContentValues databaru = new ContentValues();
		databaru.put(B5R9a, b5r9a);
		databaru.put(B5R9b, b5r9b);
		databaru.put(B5R10a, b5r10a);
		databaru.put(B5R10b, b5r10b);
		databaru.put(B5R11a, b5r11a);
		databaru.put(B5R11b, b5r11b);
		databaru.put(B5R11c, b5r11c);
		databaru.put(B5R11d, b5r11d);
		databaru.put(B5R11e, b5r11e);
		databaru.put(B5R12a, b5r12a);
		databaru.put(B5R12b1, b5r12b1);
		databaru.put(B5R12b2, b5r12b2);
		databaru.put(B5R12b3, b5r12b3);
		
		return db.insert(NAMA_TABLE, null, databaru);
		}
	catch (SQLException e){
		return -1;
	}
}

	
	//Mengambil seluruh data
public Cursor getAllData(){
	return db.query(NAMA_TABLE, new String[]{B5R9a,
											 B5R9b,
											 B5R10a,
											 B5R10b,
											 B5R11a,
											 B5R11b,
											 B5R11c,
											 B5R11d,
											 B5R11e,
											 B5R12a,
											 B5R12b1,
											 B5R12b2,
											 B5R12b3}, null, null, null, null, null);
}

	
}
