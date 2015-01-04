package com.androidbegin.menuviewpagertutorial;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Beranda extends Activity implements OnClickListener{
	TextView beranda, menu1, menu2, menu3, menu4,menu5, capi54;
	RelativeLayout mulaicacah,logout;
	Typeface ft,tt;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ft=Typeface.createFromAsset(getAssets(), "fonts/MonoglycerideDemiBold.ttf");
		tt=Typeface.createFromAsset(getAssets(), "fonts/TT.TTF");
		
		setContentView(R.layout.beranda);
		
		beranda=(TextView) findViewById(R.id.Beranda);
		menu1=(TextView) findViewById(R.id.home1);
		menu2=(TextView) findViewById(R.id.home2);
		menu3=(TextView) findViewById(R.id.home3);
		menu4=(TextView) findViewById(R.id.home4);
		menu5=(TextView) findViewById(R.id.home5);
		capi54=(TextView) findViewById(R.id.capi54);
		
		
		menu1.setTypeface(tt);
		menu2.setTypeface(tt);
		menu3.setTypeface(tt);
		menu4.setTypeface(tt);
		menu5.setTypeface(tt);
		capi54.setTypeface(ft);
		beranda.setTypeface(tt);
		
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
		beranda.setText("Selamat datang "+sp.getString("Username", "Kosong"));
		
		mulaicacah=(RelativeLayout) findViewById(R.id.mulaicacah);
		logout=(RelativeLayout) findViewById(R.id.logout);
		
		mulaicacah.setOnClickListener(this);
		logout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent ok=null;
		if(v.getId()==R.id.mulaicacah){
			ok=new Intent(this, MainActivity.class);
			startActivity(ok);
		}
		else if(v.getId()==R.id.logout){
			finish();
		}

		
	}

	

}
