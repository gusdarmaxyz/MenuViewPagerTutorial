package com.androidbegin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;

import java.sql.SQLException;

public class DBblok6 {
    public static final String kksb6="kksb6";
    public static final String kks="kks";
    public static final String b6r1="b6r1";
    public static final String b6r2="b6r2";
    public static final String b6r3="b6r3";
    public static final String b6r4="b6r4";
    public static final String b6r5="b6r5";
    public static final String b6r6a="b6r6a";
    public static final String b6r6b="b6r6b";
    public static final String b6r7="b6r7";
    public static final String b6r8="b6r8";
    public static final String b6r9a="b6r9a";
    public static final String b6r9b="b6r9b";
    public static final String b6r9c="b6r9c";
    public static final String b6r10="b6r10";

    private static final String TAG="DBblok6";
    private static final String DATABASE_NAME="SusenasKor2007";
    private static final String DATABASE_TABLE="b6";
    private static final int DATABASE_VERSION=1;
    private static String DATABASE_CREATE;
    private final Context konteks;
    private SQLiteDatabase db;
    private DatabaseHelper DBHelper;

    public DBblok6(Context context){
        this.konteks=context;
        DBHelper = new DatabaseHelper(konteks);
        StringBuffer Field_DB=new StringBuffer();
        Field_DB.append(kksb6+" varchar(18) not null, ");
        Field_DB.append(kks+" varchar(18) not null, ");
        Field_DB.append(b6r1+" Int(1) not null, ");
        Field_DB.append(b6r2+" Int(1) not null, ");
        Field_DB.append(b6r3+" Int(1) not null, ");
        Field_DB.append(b6r4+" Int(1) not null, ");
        Field_DB.append(b6r5+" Int(3) not null, ");
        Field_DB.append(b6r6a+" Int(1) not null, ");
        Field_DB.append(b6r6b+" Int(1), ");
        Field_DB.append(b6r7+" Int(1), ");
        Field_DB.append(b6r8+" Int(1), ");
        Field_DB.append(b6r9a+" Int(1) not null, ");
        Field_DB.append(b6r9b+" Int(1) not null, ");
        Field_DB.append(b6r9c+" Int(1) not null, ");
        Field_DB.append(b6r10+" Int(1) not null");

        DATABASE_CREATE="CREATE TABLE "+DATABASE_TABLE+" ( "+Field_DB+" );";
    }


    public class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context konteks){
            super(konteks, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            Log.w(TAG, "Upgrading database from version "+oldVersion+"to"+newVersion+", which destroy all old data");
            db.execSQL("DROP TABLE IF EXIST titles");
            onCreate(db);
        }
    }

    public DBblok6 open() throws SQLException{
        db=DBHelper.getWritableDatabase();
        return  this;
    }

    public void close(){
        DBHelper.close();
    }

    public long insertTitle(int[] bundle){
        ContentValues initialValues=new ContentValues();
        initialValues.put(kksb6, bundle[0]);
        initialValues.put(kks, bundle[1]);
        initialValues.put(b6r1, bundle[2]);
        initialValues.put(b6r2, bundle[3]);
        initialValues.put(b6r3, bundle[4]);
        initialValues.put(b6r4, bundle[5]);
        initialValues.put(b6r5, bundle[6]);
        initialValues.put(b6r6a, bundle[7]);
        initialValues.put(b6r6b, bundle[8]);
        initialValues.put(b6r7, bundle[9]);
        initialValues.put(b6r8, bundle[10]);
        initialValues.put(b6r9a, bundle[11]);
        initialValues.put(b6r9b, bundle[12]);
        initialValues.put(b6r9c, bundle[13]);
        initialValues.put(b6r10, bundle[14]);

        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    public boolean deleteTitle(String rowId){
        return db.delete(DATABASE_TABLE, kksb6+"="+rowId, null)>0;
    }

    public Cursor getAllTitles(){
        return db.query(DATABASE_TABLE, new String[]{
                        kksb6,
                        kks,
                        b6r1,
                        b6r2,
                        b6r3,
                        b6r4,
                        b6r5,
                        b6r6a,
                        b6r6b,
                        b6r7,
                        b6r8,
                        b6r9a,
                        b6r9b,
                        b6r9c,
                        b6r10},
                null, null, null, null, null);
    }

    public Cursor getTitle(int rowId) throws SQLException{
        return db.query(DATABASE_TABLE, new String[]{
                        kksb6,
                        kks,
                        b6r1,
                        b6r2,
                        b6r3,
                        b6r4,
                        b6r5,
                        b6r6a,
                        b6r6b,
                        b6r7,
                        b6r8,
                        b6r9a,
                        b6r9b,
                        b6r9c,
                        b6r10},
                kksb6+"="+rowId, null, null, null, null);
    }

    public boolean updateTitle(String[] bundle, int rowId){
        ContentValues initialValues=new ContentValues();
        initialValues.put(kksb6, bundle[0]);
        initialValues.put(kks, bundle[1]);
        initialValues.put(b6r1, bundle[2]);
        initialValues.put(b6r2, bundle[3]);
        initialValues.put(b6r3, bundle[4]);
        initialValues.put(b6r4, bundle[5]);
        initialValues.put(b6r5, bundle[6]);
        initialValues.put(b6r6a, bundle[7]);
        initialValues.put(b6r6b, bundle[8]);
        initialValues.put(b6r7, bundle[9]);
        initialValues.put(b6r8, bundle[10]);
        initialValues.put(b6r9a, bundle[11]);
        initialValues.put(b6r9b, bundle[12]);
        initialValues.put(b6r9c, bundle[13]);
        initialValues.put(b6r10, bundle[14]);

        return db.update(DATABASE_TABLE, initialValues, kksb6+"="+rowId,null)>0;
    }
}
