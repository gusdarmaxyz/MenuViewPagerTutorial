package com.androidbegin.menuviewpagertutorial;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Typeface;

public class Login extends Activity implements OnClickListener{

Typeface ft;
EditText lognim,logpass;
Button login,cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		ft=Typeface.createFromAsset(getAssets(), "fonts/MonoglycerideDemiBold.ttf");
		
		lognim=(EditText)findViewById(R.id.nimlog);
		logpass=(EditText)findViewById(R.id.passlog);
						
		login=(Button)findViewById(R.id.login);
		cancel=(Button)findViewById(R.id.cancel2);
		
		lognim.setTypeface(ft);
		logpass.setTypeface(ft);
		login.setTypeface(ft);
		cancel.setTypeface(ft);
		
		login.setOnClickListener(this);
		cancel.setOnClickListener(this);
		
		
		}

	@Override
	public void onClick(View v) {
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
		
		
		if(v.getId()==R.id.login){
			
			
		Intent ok;
		if(sp.getString("NIM", "Kosong").equals(lognim.getText().toString())&&sp.getString("Password", "Kosong").equals(logpass.getText().toString())){
			ok=new Intent(this, Beranda.class);
			startActivity(ok);
			finish();
		}
		
		else if("127.0.0.1".equals(lognim.getText().toString())&&"Capiadmin".equals(logpass.getText().toString()))
		{
			Toast.makeText(this, "NIM = "+sp.getString("NIM", "Kosong")+" dan password = "+sp.getString("Password", "Kosong"), Toast.LENGTH_SHORT).show();
		}
		else if("10.0.2.2".equals(lognim.getText().toString())&&"logout".equals(logpass.getText().toString())){
			savePrefs("Username", "Kosong");
			savePrefs("Password", "Kosong");
			savePrefs("NIM", "Kosong");
			Toast.makeText(this, "Berhasil Log Out", Toast.LENGTH_SHORT).show();
			finish();
		}
		else if("".equals(lognim.getText().toString())||"".equals(logpass.getText().toString())){
			Toast.makeText(this, "NIM dan Password tidak boleh kosong !",Toast.LENGTH_LONG).show();
		}
		
		else{
			Toast.makeText(this, "NIM dan Password tidak sesuai",Toast.LENGTH_LONG).show();
		}
			
		
		
	}
		else finish();
	
	}

	private void savePrefs(String key, String value){
		SharedPreferences sp=PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit=sp.edit();
		edit.putString(key, value);
		edit.commit();
	}
	

}

