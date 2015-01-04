package com.androidbegin.controlblok;

import android.content.Context;
import android.database.Cursor;

import com.androidbegin.objekblok.objekblok1;
import com.androidbegin.database.DBblok1;

import java.sql.SQLException;

public class controlblok1 {

	public objekblok1 model = new objekblok1();
	private static DBblok1 db;

	public controlblok1(Context konteks){
        db=new DBblok1(konteks);
    }
	
	public void masukkanDataToDB() {
        db.open();
        db.insertData(model.getB1R1(), model.getB1R2(), model.getB1R3(), model.getB1R4(), model.getB1R5(), model.getB1R6a(),
                	  model.getB1R6b(), model.getB1R7(), model.getB1R8(), model.getB1R9(), model.getB1R10());
        db.close();
    }

    public Cursor ambilData() throws SQLException {
        db.open();
        Cursor c;
        c=db.getAllData();
        return c;
    }

    public void UpdateData(Long Id) throws SQLException {
        db.open();
        db.updateData(Id, model.getB1R1(), model.getB1R2(), model.getB1R3(), model.getB1R4(), model.getB1R5(), model.getB1R6a(),
          	  model.getB1R6b(), model.getB1R7(), model.getB1R8(), model.getB1R9(), model.getB1R10());
        db.close();
    }

    public void DeleteData(Long Id) throws SQLException {
        db.open();
        db.deleteData(Id);
        db.close();
    }
    
    public String tampilkanData(){
    	db.open();
    	Cursor c = db.getAllData();
    	 
    	String larik = " ";
    	if(c!= null){
    		c.moveToLast();
    		String b1r1 = c.getString(0);
			String b1r2 = c.getString(1);
			String b1r3 = c.getString(2);
			String b1r4 = c.getString(3);
			String b1r5 = c.getString(4);
			String b1r6a = c.getString(5);
			String b1r6b = c.getString(6);
			String b1r7 = c.getString(7);
			String b1r8 = c.getString(8);
			String b1r9 = c.getString(9);
			String b1r10 = c.getString(10);
			
			larik = "Provinsi : " + b1r1 + 
					"\nKabupaten : " + b1r2 + 
					"\nKecamatan : " + b1r3 + 
					"\nKelurahan : " + b1r4 + 
					"\nKlasifikasi : " + b1r5 + 
					"\nNo BS :" + b1r6a + 
					"\nNoSub BS : " + b1r6b + 
					"\n No Sampel : " + b1r7 + 
					"\nNo Urut RT : " + b1r8 + 
					"\nSampel Lalu? " + b1r9 + 
					"\nAlamat : " + b1r10;   	
			return larik;
    	}
    			
    db.close();
    return larik;
}
    }
	

