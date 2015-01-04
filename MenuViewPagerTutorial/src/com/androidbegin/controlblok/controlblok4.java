package com.androidbegin.controlblok;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.androidbegin.database.DBblok4;
import com.androidbegin.objekblok.objekblok4;;

public class controlblok4 {
	private objekblok4 model1;
	final DBblok4 db;
	private List<objekblok4> listMode_Blok4= new ArrayList();
	
	public controlblok4(Context ctx) {
	db=new DBblok4(ctx);
	db.open();
	}
	
	//nah disini nih data disimpan dalam bentuk arraylist
	public void setModel(int b4r1, String b4r2,int b4r3,int b4r4,int b4r5,int b4r6,int b4r7,int b4r8, String kksArt, String kksb1){
		model1=new objekblok4();
		model1.setB4R1(b4r1);
		model1.setB4R2(b4r2);
		model1.setB4R3(b4r3);
		model1.setB4R4(b4r4);
		model1.setB4R5(b4r5);
		model1.setB4R6(b4r6);
		model1.setB4R7(b4r7);
		model1.setB4R8(b4r8);
		model1.setKksArt(kksArt);
		model1.setKksb1(kksb1);
		listMode_Blok4.add(model1);
	}
	
	public List<objekblok4> getModel() {
		return listMode_Blok4;
	}
	public void save(List<objekblok4> list){
		db.insert(list);
	}
	
	public boolean validasi(int a, int b, int c, String d, String e){
		boolean valid=true;
		if(a==0){
			valid=false;
		}else if(b==0){
			valid=false;
		}else if(c==0){
			valid=false;
		}else if(d==""){
			valid=false;
		}else if(e==""){
			valid=false;
		}
		return valid;
	}
	public boolean validasi1(int a, int b, int c, String d, String e){
		boolean valid=true;
		if(a==0){
			valid=false;
		}else if(b==0){
			valid=false;
		}else if(c==0){
			valid=false;
		}else if(d==""){
			valid=false;
		}else if(e==""){
			valid=false;
		}
		return valid;
	}
	public boolean umur0_4(int umur){
		boolean valid=false;
		if(umur>=0 && umur<=4){
			valid=true;
		}
		return valid;
	}
	
	public boolean umur2_6(int umur){
		boolean valid=false;
		if(umur>=2 && umur<=6){
			valid=true;
		}
		return valid;
	}

//	public void save(DBAdapter db,List<Model_Blok4> list){
	//	query=new QueryBlok4(db);
//		query.insert(list);//lihat di class QueryBlok4 untuk query insertnya
//	}
	
	
}
