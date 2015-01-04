package com.androidbegin.menuviewpagertutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.androidbegin.controlblok.Controlblok5c;

public class blok5c extends SherlockFragment implements OnClickListener {
	Controlblok5c blok5c = new Controlblok5c();

	TextView R13t, R14ta, R14tb, R14_bln, R14_thn, R15t, R16t, R17t, R18t;

	RadioButton  R13_1, R13_2, R13_3
				,R15_1,R15_2,R15_3,R15_4,R15_5,R15_6,R15_7,R15_8,R15_9,R15_10,R15_11
				,R16_1,R16_2,R16_3,R16_4,R16_5,R16_6,R16_7,R16_8
				,R17_1,R17_2,R17_3,R17_4,R17_5,R17_6,R17_7,R17_8,R17_9,R17_10,R17_11
				,R18_1,R18_2,R18_3,R18_4;
	RadioGroup R13_RG,R15_RG,R16_RG,R17_RG,R18_RG;
	EditText R14bln_et, R14thn_et;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.blok5c, container, false);
		R13t=(TextView)view.findViewById(R.id.textview_B5CR13);
		R14_bln=(TextView)view.findViewById(R.id.textview_B5CR14_Bulan);
		R14_thn=(TextView)view.findViewById(R.id.textview_B5CR14_Tahun);
		R15t=(TextView)view.findViewById(R.id.textview_B5CR15);
		R16t=(TextView)view.findViewById(R.id.textview_B5CR16);
		R17t=(TextView)view.findViewById(R.id.textview_B5CR17);
		R18t=(TextView)view.findViewById(R.id.textview_B5CR18);
		
		R14bln_et=(EditText)view.findViewById(R.id.edittext_B5CR14_Bulan);
		R14thn_et=(EditText)view.findViewById(R.id.edittext_B5CR14_Tahun);
		
		R13_1=(RadioButton)view.findViewById(R.id.radiobutton_B5CR13_Tidak);
		R13_2=(RadioButton)view.findViewById(R.id.radiobutton_B5CR13_Masih);
		R13_3=(RadioButton)view.findViewById(R.id.radiobutton_B5CR13_TidakBersekolah);
		
		R13_RG=(RadioGroup)view.findViewById(R.id.radiogroup_B5CR13);
		
		myInitial(false);
		
		
		R13_RG.setOnClickListener(this);
		R14bln_et.setOnClickListener(this);
		R14thn_et.setOnClickListener(this);
		R15_RG.setOnClickListener(this);
		R16_RG.setOnClickListener(this);
		R17_RG.setOnClickListener(this);
		R18_RG.setOnClickListener(this);
		return view;
	}
	
	public void onClick(View v){
		int a=0;
		switch (a) {
		case 0:
			if(v.getId()==R.id.BVCR131){
				R18_RG.setEnabled(true);
				a=5;
				break;
			}
			else if(v.getId()==R.id.BVCR132){
				R15_RG.setEnabled(true);
				a=2;
				break;
			}
			else if(v.getId()==R.id.BVCR133){
				R14bln_et.setEnabled(true);
				R14thn_et.setEnabled(true);
				a=1;
				break;
			}
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			break;
		default:
			break;
		}
	}
	public void myInitial(boolean set){
		R14bln_et.setEnabled(set);
		R14thn_et.setEnabled(set);
		R15_RG.setEnabled(set);
		R16_RG.setEnabled(set);
		R17_RG.setEnabled(set);
		R18_RG.setEnabled(set);
	}
}
