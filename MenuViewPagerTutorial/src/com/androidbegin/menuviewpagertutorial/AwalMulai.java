package com.androidbegin.menuviewpagertutorial;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;


public class AwalMulai extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading);
		
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
		Intent ok;
		if(sp.getString("NIM", "Kosong").equals("Kosong")&&sp.getString("Password", "Kosong").equals("Kosong")){
			ok=new Intent(this,MainAwal.class);
		}
		else ok=new Intent(this,Login.class);
		startActivity(ok);
		finish();
		
		
		}
		
		
		}
			

	

