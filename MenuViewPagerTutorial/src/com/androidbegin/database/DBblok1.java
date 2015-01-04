package com.androidbegin.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;

public class DBblok1 {

	public final static String B1R1 = "b1r1";
	public final static String B1R2 = "b1r2";
	public final static String B1R3 = "b1r3";
	public final static String B1R4 = "b1r4";
	public final static String B1R5 = "b1r5";
	public final static String B1R6a = "b1r6a";
	public final static String B1R6b = "b1r6b";
	public final static String B1R7 = "b1r7";
	public final static String B1R8 = "b1r8";
	public final static String B1R9 = "b1r9";
	public final static String B1R10 = "b1r10";
	
	public final static String NAMA_DATABASE = "susenaskor2007";
	public final static String NAMA_TABLE = "blok1";
	public final static int VERSI_DATABASE = 1;
	private final static String TAG = "DBAdapter";
	
	private SQLiteDatabase db;
	private final Context context;
	private final DatabaseHelper dbhelper;
	
	
	
	public DBblok1(Context ctx) 
	    {
	        this.context = ctx;
	        dbhelper = new DatabaseHelper(context);
	    }
	
	private static class DatabaseHelper extends SQLiteOpenHelper 
	    {
		
		//SQL untuk menciptakan tabel bernama Blok 1
		private final static String DATABASE_CREATE = "create table " + 
					NAMA_TABLE + " (" + 
					B1R1 + " text not null, " +
					B1R2 + " text not null, " +
					B1R3 + " text not null, " +
					B1R4 + " text not null, " +
					B1R5 + " text not null, " +
					B1R6a + " text not null, " +
					B1R6b + " text not null, " +
					B1R7 + " text not null, " +
					B1R8 + " text not null, " +
					B1R9 + " text not null, " +
					B1R10 + " text not null);";
		
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
	public long insertData(String b1r1, String b1r2, String b1r3, String b1r4, String b1r5, String b1r6a,String b1r6b, String b1r7, String b1r8, String b1r9, String b1r10) {
		try {
			ContentValues databaru = new ContentValues();
			databaru.put(B1R1, b1r1);
			databaru.put(B1R2, b1r2);
			databaru.put(B1R3, b1r3);
			databaru.put(B1R4, b1r4);
			databaru.put(B1R5, b1r5);
			databaru.put(B1R6a, b1r6a);
			databaru.put(B1R6b, b1r6b);
			databaru.put(B1R7, b1r7);
			databaru.put(B1R8, b1r8);
			databaru.put(B1R9, b1r9);
			databaru.put(B1R10, b1r10);
			
			return db.insert(NAMA_TABLE, null, databaru);
			}
		catch (SQLException e){
			return -1;
		}
	}
	
		//Menghapus data menurut Nomor Urut Kolom (ROW ID)
	public boolean deleteData (long row_id){
		return db.delete(NAMA_TABLE, B1R7 + "=" + row_id, null) > 0;
	}
	
	
		//Mengambil seluruh data
	public Cursor getAllData(){
		return db.query(NAMA_TABLE, new String[]{B1R1,
												 B1R2,
												 B1R3,
												 B1R4,
												 B1R5,
												 B1R6a,
												 B1R6b,
												 B1R7,
												 B1R8,
												 B1R9,
												 B1R10}, null, null, null, null, null);
	}
	
	
		//Mengambil data berdasarkan kunci ROW_ID
	public Cursor getData (long kunci){
		Cursor c = db.query(NAMA_TABLE, new String[]{B1R1,
				   											 B1R2,
				  											 B1R3,
				  											 B1R4,
				  											 B1R5,
				  											 B1R6a,
				  											 B1R6b,
				  											 B1R7,
				  											 B1R8,
				  											 B1R9,
				  											 B1R10}, 
				   B1R7 + "=" + kunci, null, null, null, null);
		
		if(c!=null)
			c.moveToFirst();
		
		return c;
	}
	
		//Mengubah Data
	public boolean updateData(long kunci, String b1r1, String b1r2, String b1r3, String b1r4, String b1r5, String b1r6a,String b1r6b, String b1r7, String b1r8, String b1r9, String b1r10){
		ContentValues cv = new ContentValues();
		cv.put(B1R1, b1r1);
		cv.put(B1R2, b1r2);
		cv.put(B1R3, b1r3);
		cv.put(B1R4, b1r4);
		cv.put(B1R5, b1r5);
		cv.put(B1R6a, b1r6a);
		cv.put(B1R6b, b1r6b);
		cv.put(B1R7, b1r7);
		cv.put(B1R8, b1r8);
		cv.put(B1R9, b1r9);
		cv.put(B1R10, b1r10);
		
		return db.update(NAMA_TABLE, cv, B1R7 + "=" + kunci, null) > 0;
	}
}