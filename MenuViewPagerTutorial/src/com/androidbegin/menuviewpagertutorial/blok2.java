package com.androidbegin.menuviewpagertutorial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockFragment;

public class blok2 extends SherlockFragment implements View.OnClickListener,View.OnFocusChangeListener {
	
	private EditText edittextB2R1,edittextB2R2_0,edittextB2R2_5,edittextB2R2_10,edittextB2R2_Jumlah;
	private Button buttonSave,buttonCancel;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.blok2, container, false);
		
		edittextB2R1 = (EditText)view.findViewById(R.id.edittext_B2R1);
		edittextB2R2_0 = (EditText)view.findViewById(R.id.edittext_B2R2_0Tahun);
		edittextB2R2_5 = (EditText)view.findViewById(R.id.edittext_B2R2_5Tahun);
		edittextB2R2_10 = (EditText)view.findViewById(R.id.edittext_B2R2_10Tahun);
		edittextB2R2_Jumlah = (EditText)view.findViewById(R.id.edittext_B2R2_Jumlah);
		
		buttonSave = (Button)view.findViewById(R.id.button_SaveBlok2);
		
		return view;
	}
	
	public void showErrorAlertDialog(String title,String message){
		AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.show();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.button_SaveBlok2){
			
		}
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.edittext_B2R2_0Tahun){
			if(edittextB2R1.getText().toString().length() == 0){
				showErrorAlertDialog("Error","Pertanyaan 1 belum diisi");
				edittextB2R2_0.clearFocus();
				edittextB2R1.requestFocus();
			}
		}else if(v.getId() == R.id.edittext_B2R2_5Tahun){
			if(edittextB2R2_0.getText().toString().length() == 0){
				showErrorAlertDialog("Error","Pertanyaan 2A belum diisi");
				edittextB2R2_5.clearFocus();
				edittextB2R2_0.requestFocus();
			}
		}else if(v.getId() == R.id.edittext_B2R2_10Tahun){
			if(edittextB2R2_5.getText().toString().length() == 0){
				showErrorAlertDialog("Error","Pertanyaan 2B belum diisi");
				edittextB2R2_10.clearFocus();
				edittextB2R2_5.requestFocus();
			}else{
				
			}
		}
	}
}
