package com.androidbegin.menuviewpagertutorial;

import android.R.color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;
import com.androidbegin.controlblok.controlblok5a;
import com.androidbegin.database.DBBlok5a;
import com.androidbegin.viewPager.ViewPagerAdapter5;

public class blok5a extends SherlockFragment implements OnClickListener{
CheckBox R1a,R1b,R1c,R1d,R1e,R1f,R1g,R1h;
controlblok5a blok5a;
LinearLayout R2_L,R3_L,R4_L,R5_L,R6_L,R7_L,R8_L;
Button simpan,kembali;

Typeface ft;

TextView R1t, R2t,R3t,R4t,R5t,R6ta, R6tb, R6a_t
		,R6b_t,R6c_t, R6d_t, R6e_t, R6f_t, R6g_t
		,R6h_t,R7t,R8t,R8a_t,R8b_t,R8c_t,R8d_t,
		R8e_t,R8f_t;

RadioButton R2_y,R2_t,R4_y,R4_t,R5_y,R5_t,R7_y,R7_t;

EditText R3,R6a,R6b,R6c, R6d, R6e, R6f, R6g, R6h,R8a,
		R8b,R8c,R8d,R8e,R8f;

DBBlok5a db;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		blok5a=new controlblok5a(getActivity());
		View view = inflater.inflate(R.layout.blok5a, container, false);
		ft=Typeface.createFromAsset(context().getAssets(), "fonts/MonoglycerideDemiBold.ttf");
		
		R1t =(TextView)view.findViewById(R.id.b5ar_1_Teks);
		R2t =(TextView)view.findViewById(R.id.b5ar_2_Teks);
		R3t =(TextView)view.findViewById(R.id.b5ar_3_Teks);
		R4t =(TextView)view.findViewById(R.id.b5ar_4_Teks);
		R5t =(TextView)view.findViewById(R.id.b5ar_5_Teks);
		R6ta =(TextView)view.findViewById(R.id.b5ar_6_Teksa);
		R6tb =(TextView)view.findViewById(R.id.b5ar_6_Teksb);
		R6a_t =(TextView)view.findViewById(R.id.b5ar_6_a_Teks);
		R6b_t =(TextView)view.findViewById(R.id.b5ar_6_b_Teks);
		R6c_t =(TextView)view.findViewById(R.id.b5ar_6_c_Teks);
		R6d_t =(TextView)view.findViewById(R.id.b5ar_6_d_Teks);
		R6e_t =(TextView)view.findViewById(R.id.b5ar_6_e_Teks);
		R6f_t =(TextView)view.findViewById(R.id.b5ar_6_f_Teks);
		R6g_t =(TextView)view.findViewById(R.id.b5ar_6_g_Teks);
		R6h_t =(TextView)view.findViewById(R.id.b5ar_6_h_Teks);
		R7t =(TextView)view.findViewById(R.id.b5ar_7_Teks);
		R8t =(TextView)view.findViewById(R.id.b5ar_8_Teks);
		R8a_t =(TextView)view.findViewById(R.id.b5ar_8_a_Teks);
		R8b_t =(TextView)view.findViewById(R.id.b5ar_8_b_Teks);
		R8c_t =(TextView)view.findViewById(R.id.b5ar_8_c_Teks);
		R8d_t =(TextView)view.findViewById(R.id.b5ar_8_d_Teks);
		R8e_t =(TextView)view.findViewById(R.id.b5ar_8_e_Teks);
		R8f_t =(TextView)view.findViewById(R.id.b5ar_8_f_Teks);
		
		R1t.setTypeface(ft);
		R2t.setTypeface(ft);
		R3t.setTypeface(ft);
		R4t.setTypeface(ft);
		R5t.setTypeface(ft);
		R6ta.setTypeface(ft);
		R6tb.setTypeface(ft);
		R6a_t.setTypeface(ft);
		R6b_t.setTypeface(ft);
		R6c_t.setTypeface(ft);
		R6d_t.setTypeface(ft);
		R6e_t.setTypeface(ft);
		R6f_t.setTypeface(ft);
		R6g_t.setTypeface(ft);
		R6h_t.setTypeface(ft);
		R7t.setTypeface(ft);
		R8t.setTypeface(ft);
		R8a_t.setTypeface(ft);
		R8b_t.setTypeface(ft);
		R8c_t.setTypeface(ft);
		R8d_t.setTypeface(ft);
		R8e_t.setTypeface(ft);
		R8f_t.setTypeface(ft);
		
		R2_L=(LinearLayout) view.findViewById(R.id.b5ar_2_Layout);
		R3_L=(LinearLayout) view.findViewById(R.id.b5ar_3_Layout);
		R4_L=(LinearLayout) view.findViewById(R.id.b5ar_4_Layout);
		R5_L=(LinearLayout) view.findViewById(R.id.b5ar_5_Layout);
		R6_L=(LinearLayout) view.findViewById(R.id.b5ar_6_Layout);
		R7_L=(LinearLayout) view.findViewById(R.id.b5ar_7_Layout);
		R8_L=(LinearLayout) view.findViewById(R.id.b5ar_8_Layout);
		
		R1a=(CheckBox)view.findViewById(R.id.b5ar_1_a_panas);
		R1b=(CheckBox)view.findViewById(R.id.b5ar_1_b_batuk);
		R1c=(CheckBox)view.findViewById(R.id.b5ar_1_c_Pilek);
		R1d=(CheckBox)view.findViewById(R.id.b5ar_1_d_Asma);
		R1e=(CheckBox)view.findViewById(R.id.b5ar_1_e_Diare);
		R1f=(CheckBox)view.findViewById(R.id.b5ar_1_f_Sakitkpl);
		R1g=(CheckBox)view.findViewById(R.id.b5ar_1_g_Sakitgigi);
		R1h=(CheckBox)view.findViewById(R.id.b5ar_1_h_lainnya);
		
		R1a.setTypeface(ft);
		R1b.setTypeface(ft);
		R1c.setTypeface(ft);
		R1d.setTypeface(ft);
		R1e.setTypeface(ft);
		R1f.setTypeface(ft);
		R1g.setTypeface(ft);
		R1h.setTypeface(ft);
		
		
		db=new DBBlok5a(getActivity());
		
		R2_y=(RadioButton)view.findViewById(R.id.b5ar_2_ya);
		R2_t=(RadioButton)view.findViewById(R.id.b5ar_2_Tidak);
		R4_y=(RadioButton)view.findViewById(R.id.b5ar_4_ya);
		R4_t=(RadioButton)view.findViewById(R.id.b5ar_4_Tidak);
		R5_y=(RadioButton)view.findViewById(R.id.b5ar_5_Ya);
		R5_t=(RadioButton)view.findViewById(R.id.b5ar_5_Tidak);
		R7_y=(RadioButton)view.findViewById(R.id.b5ar_7_ya);
		R7_t=(RadioButton)view.findViewById(R.id.b5ar_7_Tidak);
		
		R2_y.setTypeface(ft);
		R2_t.setTypeface(ft);
		R4_y.setTypeface(ft);
		R4_t.setTypeface(ft);
		R5_y.setTypeface(ft);
		R5_t.setTypeface(ft);
		R7_y.setTypeface(ft);
		R7_t.setTypeface(ft);
		
		
		R3=(EditText)view.findViewById(R.id.b5ar_3);
		R6a=(EditText)view.findViewById(R.id.b5ar_6_a);
		R6b=(EditText)view.findViewById(R.id.b5ar_6_b);
		R6c=(EditText)view.findViewById(R.id.b5ar_6_c);
		R6d=(EditText)view.findViewById(R.id.b5ar_6_d);
		R6e=(EditText)view.findViewById(R.id.b5ar_6_e);
		R6f=(EditText)view.findViewById(R.id.b5ar_6_f);
		R6g=(EditText)view.findViewById(R.id.b5ar_6_g);
		R6h=(EditText)view.findViewById(R.id.b5ar_6_h);
		R8a=(EditText)view.findViewById(R.id.b5ar_8_a);
		R8b=(EditText)view.findViewById(R.id.b5ar_8_b);
		R8c=(EditText)view.findViewById(R.id.b5ar_8_c);
		R8d=(EditText)view.findViewById(R.id.b5ar_8_d);
		R8e=(EditText)view.findViewById(R.id.b5ar_8_e);
		R8f=(EditText)view.findViewById(R.id.b5ar_8_f);
		simpan=(Button) view.findViewById(R.id.b5a_save);
		kembali=(Button) view.findViewById(R.id.b5a_cancel);
		
		R3.setTypeface(ft);
		R6a.setTypeface(ft);
		R6b.setTypeface(ft);
		R6c.setTypeface(ft);
		R6d.setTypeface(ft);
		R6e.setTypeface(ft);
		R6f.setTypeface(ft);
		R6g.setTypeface(ft);
		R6h.setTypeface(ft);
		R8a.setTypeface(ft);
		R8b.setTypeface(ft);
		R8c.setTypeface(ft);
		R8d.setTypeface(ft);
		R8e.setTypeface(ft);
		R8f.setTypeface(ft);
		simpan.setTypeface(ft);
		kembali.setTypeface(ft);
		
		
		
		myInitial(false);
		myInitial4(false);
		
		R1a.setOnClickListener(this);
		R1b.setOnClickListener(this);
		R1c.setOnClickListener(this);
		R1d.setOnClickListener(this);
		R1e.setOnClickListener(this);
		R1f.setOnClickListener(this);
		R1g.setOnClickListener(this);
		R1h.setOnClickListener(this);
		R2_y.setOnClickListener(this);
		R2_t.setOnClickListener(this);
		R4_y.setOnClickListener(this);
		R4_t.setOnClickListener(this);
		R5_y.setOnClickListener(this);
		R5_t.setOnClickListener(this);
		R7_y.setOnClickListener(this);
		R7_t.setOnClickListener(this);
		simpan.setOnClickListener(this);
		kembali.setOnClickListener(this);
		
		return view;
		
		
		
		
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.b5ar_1_a_panas||v.getId()==R.id.b5ar_1_b_batuk||
		v.getId()==R.id.b5ar_1_c_Pilek||v.getId()==R.id.b5ar_1_d_Asma||
		v.getId()==R.id.b5ar_1_e_Diare||v.getId()==R.id.b5ar_1_f_Sakitkpl||
		v.getId()==R.id.b5ar_1_g_Sakitgigi||v.getId()==R.id.b5ar_1_h_lainnya)
		{	
			boolean R1_Array[]={R1a.isChecked(),R1b.isChecked(),R1c.isChecked(),R1d.isChecked(),
					R1e.isChecked(),R1f.isChecked(),R1g.isChecked(),R1h.isChecked()};
			if(blok5a.getValidasiR_1(R1_Array)){
				myInitial(true);
			}
			else 
				myInitial(false);
		}
		else if(v.getId()==R.id.b5ar_2_ya){
			boolean cek=blok5a.getValidasiR_2(R2_y.isChecked());
			myInitial2(cek);
		}
		else if(v.getId()==R.id.b5ar_2_Tidak){
			boolean cek=blok5a.getValidasiR_2(R2_t.isChecked());
			myInitial2(!cek);
		}
		else if(v.getId()==R.id.b5ar_4_ya){
			blok5a.setR_4(R4_y.isChecked());
			
		}
		else if(v.getId()==R.id.b5ar_4_Tidak){
			blok5a.setR_4(R4_t.isChecked());
			
		}
		else if(v.getId()==R.id.b5ar_5_Ya){
			boolean cek=blok5a.getValidasiR_5(R5_y.isChecked());
			myInitial3(cek);
		}
		else if(v.getId()==R.id.b5ar_5_Tidak){
			boolean cek=blok5a.getValidasiR_5(R5_t.isChecked());
			myInitial3(!cek);
		}
		else if(v.getId()==R.id.b5ar_7_ya){
			boolean cek=blok5a.getValidasiR_7(R7_y.isChecked());
			myInitial4(cek);
		}
		else if(v.getId()==R.id.b5ar_7_Tidak){
			boolean cek=blok5a.getValidasiR_7(R7_t.isChecked());
			myInitial4(!cek);
		}
		else if(v.getId()==R.id.b5a_save){
						
			int eR3=Integer.parseInt(R3.getText().toString());
			blok5a.setR_3(eR3);
			
			int eR6[]={Integer.parseInt(R6a.getText().toString()),
					Integer.parseInt(R6b.getText().toString()),
					Integer.parseInt(R6c.getText().toString()),
					Integer.parseInt(R6d.getText().toString()),
					Integer.parseInt(R6e.getText().toString()),
					Integer.parseInt(R6f.getText().toString()),
					Integer.parseInt(R6g.getText().toString()),
					Integer.parseInt(R6h.getText().toString()),
						};
						
			blok5a.setR_6(eR6);
			
			int eR8[]={Integer.parseInt(R8a.getText().toString()),
					Integer.parseInt(R8b.getText().toString()),
					Integer.parseInt(R8c.getText().toString()),
					Integer.parseInt(R8d.getText().toString()),
					Integer.parseInt(R8e.getText().toString()),
					Integer.parseInt(R8f.getText().toString()),
					};
			
			blok5a.setR_8(eR8);
			Toast.makeText(getActivity(), "Mulai", Toast.LENGTH_SHORT).show();
			
			blok5a.insertDB();
			
			Toast.makeText(getActivity(), "Save", Toast.LENGTH_SHORT).show();
		
			
		}
		else if(v.getId()==R.id.b5a_cancel){
			
		}
		
	}
	
	public void myInitial(boolean set)
	{
		
		R2t.setEnabled(set);
		R3t.setEnabled(set);
		R4t.setEnabled(set);
		R5t.setEnabled(set);
		R6ta.setEnabled(set);
		R6tb.setEnabled(set);
		R6a_t.setEnabled(set);
		R6b_t.setEnabled(set);
		R6c_t.setEnabled(set);
		R6d_t.setEnabled(set);
		R6e_t.setEnabled(set);
		R6f_t.setEnabled(set);
		R6g_t.setEnabled(set);
		R6h_t.setEnabled(set);
		R2_y.setEnabled(set);
		R2_t.setEnabled(set);
		R3.setEnabled(set);
		R4_y.setEnabled(set);
		R4_t.setEnabled(set);
		R5_y.setEnabled(set);
		R5_t.setEnabled(set);
		R6a.setEnabled(set);
		R6b.setEnabled(set);
		R6c.setEnabled(set);
		R6d.setEnabled(set);
		R6e.setEnabled(set);
		R6f.setEnabled(set);
		R6g.setEnabled(set);
		R6h.setEnabled(set);
		
		if(!set){
			R2_L.setBackgroundResource(R.drawable.disable);
			R3_L.setBackgroundResource(R.drawable.disable);
			R4_L.setBackgroundResource(R.drawable.disable);
			R5_L.setBackgroundResource(R.drawable.disable);
			R6_L.setBackgroundResource(R.drawable.disable);
			R2_t.setChecked(!set);
			R2_y.setChecked(set);
			R4_t.setChecked(!set);
			R4_y.setChecked(set);
			R5_t.setChecked(!set);
			R5_y.setChecked(set);
			R7_t.setChecked(!set);
			R7_y.setChecked(set);
			
			R3.setBackgroundResource(R.drawable.disable_textfield);

			R6a.setBackgroundResource(R.drawable.disable_textfield);
			R6b.setBackgroundResource(R.drawable.disable_textfield);
			R6c.setBackgroundResource(R.drawable.disable_textfield);
			R6d.setBackgroundResource(R.drawable.disable_textfield);
			R6e.setBackgroundResource(R.drawable.disable_textfield);
			R6f.setBackgroundResource(R.drawable.disable_textfield);
			R6g.setBackgroundResource(R.drawable.disable_textfield);
			R6h.setBackgroundResource(R.drawable.disable_textfield);
			
						
			R3.setText("0");

			R6a.setText("0");
			R6b.setText("0");
			R6c.setText("0");
			R6d.setText("0");
			R6e.setText("0");
			R6f.setText("0");
			R6g.setText("0");
			R6h.setText("0");
			
			R8a.setText("0");
			R8b.setText("0");
			R8c.setText("0");
			R8d.setText("0");
			R8e.setText("0");
			R8f.setText("0");
		
		}
		else {
			R2_L.setBackgroundResource(R.drawable.enable);
			R3_L.setBackgroundResource(R.drawable.enable);
			R4_L.setBackgroundResource(R.drawable.enable);
			R5_L.setBackgroundResource(R.drawable.enable);
			R6_L.setBackgroundResource(R.drawable.enable);
			
			R3.setBackgroundResource(R.drawable.enable_textfield);

			R6a.setBackgroundResource(R.drawable.enable_textfield);
			R6b.setBackgroundResource(R.drawable.enable_textfield);
			R6c.setBackgroundResource(R.drawable.enable_textfield);
			R6d.setBackgroundResource(R.drawable.enable_textfield);
			R6e.setBackgroundResource(R.drawable.enable_textfield);
			R6f.setBackgroundResource(R.drawable.enable_textfield);
			R6g.setBackgroundResource(R.drawable.enable_textfield);
			R6h.setBackgroundResource(R.drawable.enable_textfield);
			R2_t.setChecked(!set);
			R2_y.setChecked(set);
			R4_t.setChecked(!set);
			R4_y.setChecked(set);
			R5_t.setChecked(!set);
			R5_y.setChecked(set);
			R7_t.setChecked(!set);
			R7_y.setChecked(set);
			
		}
	}
	
	public void myInitial2(boolean set)
	{
		R3t.setEnabled(set);
		R3.setEnabled(set);
		
		if(!set){
			R3_L.setBackgroundResource(R.drawable.disable);
			R3.setBackgroundResource(R.drawable.disable_textfield);
			
			R3.setText("0");

			
		}
		else {
			R3_L.setBackgroundResource(R.drawable.enable);
			R3.setBackgroundResource(R.drawable.enable_textfield);
		}
			
	}
	
	public void myInitial3(boolean set)
	{
		
		R6ta.setEnabled(set);
		R6tb.setEnabled(set);
		R6a_t.setEnabled(set);
		R6b_t.setEnabled(set);
		R6c_t.setEnabled(set);
		R6d_t.setEnabled(set);
		R6e_t.setEnabled(set);
		R6f_t.setEnabled(set);
		R6g_t.setEnabled(set);
		R6h_t.setEnabled(set);
		R6a.setEnabled(set);
		R6b.setEnabled(set);
		R6c.setEnabled(set);
		R6d.setEnabled(set);
		R6e.setEnabled(set);
		R6f.setEnabled(set);
		R6g.setEnabled(set);
		R6h.setEnabled(set);	
		
		
		if(!set){
			
			R6_L.setBackgroundResource(R.drawable.disable);
			R6a.setBackgroundResource(R.drawable.disable_textfield);
			R6b.setBackgroundResource(R.drawable.disable_textfield);
			R6c.setBackgroundResource(R.drawable.disable_textfield);
			R6d.setBackgroundResource(R.drawable.disable_textfield);
			R6e.setBackgroundResource(R.drawable.disable_textfield);
			R6f.setBackgroundResource(R.drawable.disable_textfield);
			R6g.setBackgroundResource(R.drawable.disable_textfield);
			R6h.setBackgroundResource(R.drawable.disable_textfield);
			
			R6a.setText("0");
			R6b.setText("0");
			R6c.setText("0");
			R6d.setText("0");
			R6e.setText("0");
			R6f.setText("0");
			R6g.setText("0");
			R6h.setText("0");
			
			
		}
		else {
			
			R6_L.setBackgroundResource(R.drawable.enable);
			R6a.setBackgroundResource(R.drawable.enable_textfield);
			R6b.setBackgroundResource(R.drawable.enable_textfield);
			R6c.setBackgroundResource(R.drawable.enable_textfield);
			R6d.setBackgroundResource(R.drawable.enable_textfield);
			R6e.setBackgroundResource(R.drawable.enable_textfield);
			R6f.setBackgroundResource(R.drawable.enable_textfield);
			R6g.setBackgroundResource(R.drawable.enable_textfield);
			R6h.setBackgroundResource(R.drawable.enable_textfield);
			
		}
	}
	
	public void myInitial4(boolean set)
	{
		
		
		R8t.setEnabled(set);
		R8a_t.setEnabled(set);
		R8b_t.setEnabled(set);
		R8c_t.setEnabled(set);
		R8d_t.setEnabled(set);
		R8e_t.setEnabled(set);
		R8f_t.setEnabled(set);
		
		R8a.setEnabled(set);
		R8b.setEnabled(set);
		R8c.setEnabled(set);
		R8d.setEnabled(set);
		R8e.setEnabled(set);
		R8f.setEnabled(set);
		
		if(!set){
			R8_L.setBackgroundResource(R.drawable.disable);
			R8a.setBackgroundResource(R.drawable.disable_textfield);
			R8b.setBackgroundResource(R.drawable.disable_textfield);
			R8c.setBackgroundResource(R.drawable.disable_textfield);
			R8d.setBackgroundResource(R.drawable.disable_textfield);
			R8e.setBackgroundResource(R.drawable.disable_textfield);
			R8f.setBackgroundResource(R.drawable.disable_textfield);
			
			R8a.setText("0");
			R8b.setText("0");
			R8c.setText("0");
			R8d.setText("0");
			R8e.setText("0");
			R8f.setText("0");
		}
		else {
			
			R8_L.setBackgroundResource(R.drawable.enable);
			R8a.setBackgroundResource(R.drawable.enable_textfield);
			R8b.setBackgroundResource(R.drawable.enable_textfield);
			R8c.setBackgroundResource(R.drawable.enable_textfield);
			R8d.setBackgroundResource(R.drawable.enable_textfield);
			R8e.setBackgroundResource(R.drawable.enable_textfield);
			R8f.setBackgroundResource(R.drawable.enable_textfield);
		}
			
	}
	
	
}
