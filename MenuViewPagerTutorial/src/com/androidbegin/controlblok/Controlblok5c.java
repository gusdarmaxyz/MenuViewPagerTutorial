package com.androidbegin.controlblok;

import com.androidbegin.objekblok.objekblok5c;

public class Controlblok5c {
	objekblok5c objek = new objekblok5c();
	
	public boolean getValidasiR_13(boolean R_13){
		objek.setR_13(R_13);
		if(objek.isR_13()) return true;
		else return false;
	}
	
	public void setR_14(int R_14[]){
		objek.setR_14(R_14[0], R_14[1]);
	}
	
	public boolean getValidasiR_15(boolean R_15){
		objek.setR_15(R_15);
		if(objek.isR_15()) return true;
		else return false;
	}
	public boolean getValidasiR_16(boolean R_16){
		objek.setR_16(R_16);
		if(objek.isR_16()) return true;
		else return false;
	}
	public boolean getValidasiR_17(boolean R_17){
		objek.setR_17(R_17);
		if(objek.isR_17()) return true;
		else return false;
	}
	public boolean getValidasiR_18(boolean R_18){
		objek.setR_18(R_18);
		if(objek.isR_18()) return true;
		else return false;
	}
}
