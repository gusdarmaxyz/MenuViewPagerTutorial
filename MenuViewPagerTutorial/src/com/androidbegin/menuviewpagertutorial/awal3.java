package com.androidbegin.menuviewpagertutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;


public class awal3 extends SherlockFragment implements OnClickListener{
Button daftar, cancel;
EditText nama, nim, pass;
Typeface ft;

Intent oke;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.awal3, container, false);
		ft=Typeface.createFromAsset(context().getAssets(), "fonts/MonoglycerideDemiBold.ttf");
				
		nama=(EditText) view.findViewById(R.id.editnama);
		nim=(EditText) view.findViewById(R.id.editnim);
		pass=(EditText) view.findViewById(R.id.editPass);
		
		daftar=(Button)view.findViewById(R.id.daftar);
		daftar.setOnClickListener(this);
		
		cancel=(Button)view.findViewById(R.id.cancel);
		cancel.setOnClickListener(this);
		
		nama.setTypeface(ft);
		nim.setTypeface(ft);
		pass.setTypeface(ft);
		daftar.setTypeface(ft);
		cancel.setTypeface(ft);
		
		return view;
	}
	@Override
	public void onClick(View v) {
		
	if(nama.getText().toString().equals("")||nim.getText().toString().equals("")||pass.getText().toString().equals("")){	
		Toast.makeText(getActivity(), "Username,NIM atau Password tidak boleh kosong",Toast.LENGTH_SHORT).show();
	}
	else
	
	{
		if(v.getId()==R.id.daftar)
		{
			savePrefs("Username", nama.getText().toString());
			savePrefs("NIM", nim.getText().toString());
			savePrefs("Password",pass.getText().toString());
			
		oke=new Intent(context(), Beranda.class);
		startActivity(oke);
		context().finish();
		
		}
		else
		System.exit(0);
		
	}
	}
	String name1,pass1,nim1;
	boolean cbValue;
	
	private void loadPrefs(){
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getActivity());
		cbValue=sp.getBoolean("isLogin", false);
		name1=sp.getString("Username", "");
		pass1=sp.getString("Password", "");
		nim1=sp.getString("NIM", "");
		
		
	}
	
	private void savePrefs(String key, boolean value){
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getActivity());
		Editor edit=sp.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}
	
	private void savePrefs(String key, String value){
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(getActivity());
		Editor edit=sp.edit();
		edit.putString(key, value);
		edit.commit();
	}
	
	
	
	
}
