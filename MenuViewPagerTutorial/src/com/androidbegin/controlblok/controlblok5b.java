package com.androidbegin.controlblok;

import java.sql.SQLException;

import com.androidbegin.database.DBblok5b;
import com.androidbegin.objekblok.objekblok5b;

import android.content.Context;
import android.database.Cursor;

public class controlblok5b {
	public objekblok5b model = new objekblok5b();
	private static DBblok5b db;

	public controlblok5b(Context konteks){
        db=new DBblok5b(konteks);
    }
	
	public void masukkanDataToDB() {
        db.open();
        db.insertData(model.getB5R9a(), model.getB5R9b(), model.getB5R10a(), model.getB5R10b(), model.getB5R11a(), model.getB5R11b(),
                	  model.getB5R11c(), model.getB5R11d(), model.getB5R11e(), model.getB5R12a(), model.getB5R12b1(), model.getB5R12b2()
                	  , model.getB5R12b3());
        db.close();
    }

    public Cursor ambilData() throws SQLException {
        db.open();
        Cursor c;
        c=db.getAllData();
        return c;
    }
    
    

}
