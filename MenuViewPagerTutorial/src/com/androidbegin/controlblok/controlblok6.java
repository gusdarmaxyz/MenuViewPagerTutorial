package com.androidbegin.controlblok;


import android.content.Context;
import android.database.Cursor;

import java.sql.SQLException;

import com.androidbegin.database.DBblok6;
import com.androidbegin.objekblok.objekblok6;

/**
 * Created by ASUS on 1/1/2015.
 */
public class controlblok6 {
	static objekblok6 objek;
    static DBblok6 DB;

   public controlblok6(Context context){
        objek=new objekblok6();
        DB=new DBblok6(context);
    }

    public void masukkanDataToModel(int isi[]){
        objek.setKksb6(isi[0]);
        objek.setKks(isi[1]);
        objek.setR_1(isi[2]);
        objek.setR_2(isi[3]);
        objek.setR_3(isi[4]);
        objek.setR_4(isi[5]);
        objek.setR_5(isi[6]);
        objek.setR_6a(isi[7]);
        objek.setR_6b(isi[8]);
        objek.setR_7(isi[9]);
        objek.setR_8(isi[10]);
        objek.setR_9a(isi[11]);
        objek.setR_9b(isi[12]);
        objek.setR_9c(isi[13]);
        objek.setR_10(isi[14]);
    }


    public void masukkanDataToDB(){
        int[] bundle=new int[15];

        bundle[0]=objek.getKksb6();
        bundle[1]=objek.getKks();
        bundle[2]=objek.getR_1();
        bundle[3]=objek.getR_2();
        bundle[4]=objek.getR_3();
        bundle[5]=objek.getR_4();
        bundle[6]=objek.getR_5();
        bundle[7]=objek.getR_6a();
        bundle[8]=objek.getR_6b();
        bundle[9]=objek.getR_7();
        bundle[10]=objek.getR_8();
        bundle[11]=objek.getR_9a();
        bundle[12]=objek.getR_9b();
        bundle[13]=objek.getR_9c();
        bundle[14]=objek.getR_10();

        try {
            DB.open();
            DB.insertTitle(bundle);
            DB.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

    public String ambilDataFromDB(){
        StringBuffer isi=new StringBuffer();
        Cursor cursor=null;

        try {
            DB.open();
            cursor=DB.getAllTitles();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(cursor.moveToFirst()){
            do{
                isi.append("\nkksb6 : "+cursor.getString(0));
                isi.append("\nkks : "+cursor.getString(1));
                isi.append("\nB6R1 : "+cursor.getString(2));
                isi.append("\nB6R2 : "+cursor.getString(3));
                isi.append("\nB6R3 : "+cursor.getString(4));
                isi.append("\nB6R4 : "+cursor.getString(5));
                isi.append("\nB6R5 : "+cursor.getString(6));
                isi.append("\nB6R6a : "+cursor.getString(7));
                isi.append("\nB6R6b : "+cursor.getString(8));
                isi.append("\nB6R7 : "+cursor.getString(9));
                isi.append("\nB6R8 : "+cursor.getString(10));
                isi.append("\nB6R9a : "+cursor.getString(11));
                isi.append("\nB6R9b : "+cursor.getString(12));
                isi.append("\nB6R9c : "+cursor.getString(13));
                isi.append("\nB6R10 : "+cursor.getString(14));
                isi.append("\n");

            } while(cursor.moveToNext());
        }

        return isi.toString();
    }


}
