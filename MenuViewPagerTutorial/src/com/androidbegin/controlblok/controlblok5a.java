package com.androidbegin.controlblok;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.androidbegin.objekblok.objekblok5a;
import com.androidbegin.database.DBBlok5a;

public class controlblok5a {

objekblok5a a=new objekblok5a();
DBBlok5a db;

public controlblok5a(Context context){
	db=new DBBlok5a(context);
}

public void setR_1(boolean R_1[]){
	a.setR_1(R_1[0], R_1[1], R_1[2], R_1[3], R_1[4], R_1[5], R_1[6], R_1[7]);
	a.setR_1(R_1);
}

public boolean getTotalR_1(){
	return a.isR_1a()||a.isR_1b()||a.isR_1c()||a.isR_1d()||a.isR_1e()||a.isR_1f()||a.isR_1g()||a.isR_1h();
}

public boolean getValidasiR_1(boolean R_1[]){
	setR_1(R_1);
	if(getTotalR_1()) return true;
	else return false;
}

public boolean getValidasiR_2(boolean R_2){
	a.setR_2(R_2);
	if(a.isR_2()) return true;
	else return false;
}

public void setR_3(int R_3){
	a.setR_3(R_3);
	
}
public void setR_4(boolean R_4){
	a.setR_5(R_4);
	
}
public boolean getValidasiR_5(boolean R_5){
	a.setR_5(R_5);
	if(a.isR_5()) return true;
	else return false;
}

public void setR_6(int R_6[]){
	a.setR_6(R_6[0], R_6[1], R_6[2], R_6[3], R_6[4], R_6[5], R_6[6], R_6[7]);
	a.setR_6(R_6);
	
}



public boolean getValidasiR_7(boolean R_7){
	a.setR_7(R_7);
	if(a.isR_7()) return true;
	else return false;
}

public void setR_8(int R_8[]){
	a.setR_8(R_8[0], R_8[1], R_8[2], R_8[3], R_8[4], R_8[5]);
	a.setR_8(R_8);
}

public void insertDB(){
	db.open();
	db.insertBlok5a(BooleantoString(a.getR_1()),BooleantoString(a.isR_2()), 
			IntegertoString(a.getR_3()), BooleantoString(a.isR_4())
			, BooleantoString(a.isR_5()),IntegertoString( a.getR_6())
			, BooleantoString(a.isR_7()), IntegertoString(a.getR_8()));
	db.close();
	
}

public String[] getAllData(){
	db.open();
	Cursor c=db.getAllBlok5a();
	String data[]=new String[c.getColumnCount()];
	if(c.moveToLast()){
		String nama[]=c.getColumnNames();
		for(int i=0;i<c.getColumnCount();i++){
			
			data[i]=nama[i]+": "+c.getString(i);
			
		}
	}
	db.close();
	
	return data;
	
}

public String[] BooleantoString(boolean[] bs){
	String baru[]=new String[bs.length];	
	for(int i=0;i<bs.length;i++){
		if(bs[i]) baru[i]="1";
		else baru[i]="2";
			
	}
	return baru;
}

public String BooleantoString(Boolean a){
	if(a) return "1";
	else return "2";
}


public String[] IntegertoString(int []a){
	String baru[]=new String[a.length];	
	for(int i=0;i<a.length;i++){
		baru[i]=String.valueOf(a[i]);
				
	}
	return baru;
}

public String IntegertoString(int a){
	return String.valueOf(a);
}

}
