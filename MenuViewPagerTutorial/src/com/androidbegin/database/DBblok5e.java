package com.androidbegin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.androidbegin.objekblok.objekblok5e;;


/**
 * Created by aspire on 29/12/2014.
 */
public class DBblok5e {
    public static final String KEY_ID="id";
    public static final String KEY_B5R27="b5r27";
    public static final String KEY_B5R28="b5r28";
    public static final String KEY_B5R29AL="b5r29aL";
    public static final String KEY_B5R29AP="b5r29aP";
    public static final String KEY_B5R29APL="b5r29aLP";
    public static final String KEY_B5R29BL="b5r29bL";
    public static final String KEY_B5R29BP="b5r29bP";
    public static final String KEY_B5R29BLP="b5r29bLP";
    public static final String KEY_B5R29CL="b5r29cL";
    public static final String KEY_B5R29CP="b5r29cP";
    public static final String KEY_B5R29CLP="b5r29LP";
    public static final String KEY_B5R30="b5r30";
    public static final String KEY_B5R31="b5r31";

    public static final String[] KEY={KEY_ID,
            KEY_B5R27,
            KEY_B5R28,
            KEY_B5R29AL,
            KEY_B5R29AP,
            KEY_B5R29APL,
            KEY_B5R29BL,
            KEY_B5R29BP,
            KEY_B5R29BLP,
            KEY_B5R29CL,
            KEY_B5R29CP,
            KEY_B5R29CLP,
            KEY_B5R30,
            KEY_B5R31
    };

    public static final String DATABASE_NAME="susenaskor2007";
    public static final String DATABASE_TABLE="b5e";
    public static final int DATABASE_VERSION=1;

    private static final String DATABASE_CREATE=
            "create table "+DATABASE_TABLE+" (" +
            KEY_ID +" integer primary key autoincrement, " +
            KEY_B5R27+" integer, " +
            KEY_B5R28+" integer, " +
            KEY_B5R29AL+" integer, " +
            KEY_B5R29AP+" integer, " +
            KEY_B5R29APL+" integer, " +
            KEY_B5R29BL+" integer, " +
            KEY_B5R29BP+" integer, " +
            KEY_B5R29BLP+" integer, " +
            KEY_B5R29CL+" integer, " +
            KEY_B5R29CP+" integer, " +
            KEY_B5R29CLP+" integer, " +
            KEY_B5R30+" integer, " +
            KEY_B5R31+" integer " +
            ");";

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBblok5e(Context context){
        this.context=context;
        DBHelper=new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
            onCreate(db);
        }
    }

    public DBblok5e open() throws SQLException{
        db=DBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        DBHelper.close();
    }

    public long insertRow(objekblok5e b5e){

        ContentValues init=new ContentValues();
        init.put(KEY_B5R27,b5e.getB5R27());
        init.put(KEY_B5R28,b5e.getB5R28());
        init.put(KEY_B5R29AL,b5e.getB5R29aL());
        init.put(KEY_B5R29AP,b5e.getB5R29aP());
        init.put(KEY_B5R29APL,b5e.getB5R29aLP());
        init.put(KEY_B5R29BL,b5e.getB5R29bL());
        init.put(KEY_B5R29BP,b5e.getB5R29bP());
        init.put(KEY_B5R29BLP,b5e.getB5R29bLP());
        init.put(KEY_B5R29CL,b5e.getB5R29cL());
        init.put(KEY_B5R29CP,b5e.getB5R29cP());
        init.put(KEY_B5R29CLP,b5e.getB5R29cLP());
        init.put(KEY_B5R30,b5e.getB5R30());
        init.put(KEY_B5R31,b5e.getB5R31());

        return db.insert(DATABASE_TABLE,null,init);
    }
    public Cursor getAll(){
        return db.query(DATABASE_TABLE,KEY,null,null,null,null,null,null);
    }
}
