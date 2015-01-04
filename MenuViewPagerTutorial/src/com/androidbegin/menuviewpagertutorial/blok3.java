package com.androidbegin.menuviewpagertutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockFragment;

public class blok3 extends SherlockFragment {
	
	EditText edittextB3R1,edittextB3R2_Nama,edittextB3R3_Nama;
	Button buttonSave,buttonCancel;
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.blok3, container, false);
		
		edittextB3R1 = (EditText)view.findViewById(R.id.edittext_B3R1);
		edittextB3R2_Nama = (EditText)view.findViewById(R.id.edittext_B3R2_Nama);
		edittextB3R3_Nama = (EditText)view.findViewById(R.id.edittext_B3R3_Nama);
		buttonSave = (Button)view.findViewById(R.id.button_SaveBlok3);
		buttonCancel = (Button)view.findViewById(R.id.button_CancelBlok3);

        return view;
	}
}
