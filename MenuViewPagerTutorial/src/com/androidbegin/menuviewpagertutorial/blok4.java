package com.androidbegin.menuviewpagertutorial;

import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockFragment;
import com.androidbegin.objekblok.objekblok4;
import com.androidbegin.controlblok.controlblok4;
import com.androidbegin.database.DBblok4;


public class blok4 extends SherlockFragment implements OnItemSelectedListener{

	private EditText nama, umur;
	String[] item_list1 = {  "pilih item","1. Kepala Rt",  "2. Istri/Suami","3. Anak","4. Menantu","5. Cucu","6. Orang tua/mertua","7. Famili lain","8. Pembantu Rt","9. Lainnya",};  
	String[] item_list2 = {  "pilih item","1. Laki-laki",  "2. Perempuan"};  
	String[] item_list3 = {  "pilih item","1. Belum kawin",  "2. Kawin","3. Cerai hidup","4. Cerai mati"}; 
	String[] item_list4 = {  "pilih item","1. Ya, Dapat ditunjukkan","2. Ya, Tidak dapat ditunjukkan","3. Tidak punya","4. Tidak tahu"};
	String[] item_list5 = {  "pilih item","1. Ya, TK/BA/RA",  "2. Ya, Kelompok bermain","3. Ya, Taman penitipan anak","4. Ya, PAUD terintegrasi BKB/Posyandu","5. Ya, Lembaga lainnya","6. Tidak"};  

	
	private Spinner sp3,sp4,sp6,sp7,sp8; 
	private Button loop,save;
	private objekblok4 m;
	private controlblok4 control;
	private int index1,index2,index3,index4,index5;
	private int x=0;
	private String kksArt="0", kksb1="0";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.blok4, container, false);
		control=new controlblok4(getActivity());
		
		//inisialisasi semua disini
				sp3 = (Spinner) view.findViewById(R.id.spB4R3);  
				sp4 = (Spinner) view.findViewById(R.id.spB4R4);  
				sp6 = (Spinner) view.findViewById(R.id.spB4R6);  
				sp7 = (Spinner) view.findViewById(R.id.spB4R7); 
				sp8 = (Spinner) view.findViewById(R.id.spB4R8); 
				
				loop=(Button) view.findViewById(R.id.bLoop);
				save=(Button) view.findViewById(R.id.bSave);
				
				nama=(EditText) view.findViewById(R.id.etB4R2);
		        umur=(EditText) view.findViewById(R.id.etB4R5);
		        
		        // buat array adapter untuk menginisialisasi item spinner dengan string array
		        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(context(), R.layout.sherlock_spinner_item, item_list1);  
		        sp3.setAdapter(adapter1);
		        sp3.setOnItemSelectedListener(this);
		        
		        ArrayAdapter<String> adapter2=new ArrayAdapter<String>(context(), R.layout.sherlock_spinner_item, item_list2);  
		        sp4.setAdapter(adapter2);
		        sp4.setOnItemSelectedListener(this);
		        ArrayAdapter<String> adapter3=new ArrayAdapter<String>(context(), R.layout.sherlock_spinner_item, item_list3);  
		        sp6.setAdapter(adapter3);
		        sp6.setOnItemSelectedListener(this);
		        ArrayAdapter<String> adapter4=new ArrayAdapter<String>(context(), R.layout.sherlock_spinner_item, item_list4);  
		        sp7.setAdapter(adapter4);
		        sp7.setOnItemSelectedListener(this);
		        ArrayAdapter<String> adapter5=new ArrayAdapter<String>(context(), R.layout.sherlock_spinner_item, item_list5);  
		        sp8.setAdapter(adapter5);
		        sp8.setOnItemSelectedListener(this);
		        /**
		        umur.addTextChangedListener(new TextWatcher() {
					
					@Override
					public void onTextChanged(CharSequence s, int start, int before, int count) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void beforeTextChanged(CharSequence s, int start, int count,
							int after) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void afterTextChanged(Editable s) {
						// TODO Auto-generated method stub
						int umur1=Integer.parseInt(umur.getText().toString());
						if(control.umur0_4(umur1)){
							sp7.setBackgroundColor(color.darker_gray);
							sp7.setEnabled(true);
						}else if(control.umur2_6(umur1)){
							sp8.setBackgroundColor(color.darker_gray);
							sp8.setEnabled(true);
						}
					}
				});**/
		            loop.setOnClickListener(new View.OnClickListener(){//action saat button loop diklik
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						///validasi dulu gan, pastikan semua data yang perlu diisi tidak boleh kosong
						if(control.validasi(sp3.getSelectedItemPosition(),sp4.getSelectedItemPosition(),sp6.getSelectedItemPosition(),nama.getText().toString(),umur.getText().toString())){
							x++;
							kksArt=kksb1+"_"+x+"";
							// simpan datanya dalam bentuk arraylist, klo gak percaya lihat saja ke objectnya
							control.setModel(x,nama.getText().toString(), index1, index2,Integer.parseInt(umur.getText().toString()) , index3, index4, index5,kksArt,kksb1);
							refresh();//refresh dulu kuesionernya. to default
						}else{
							message("Pastikan semua yang perlu diisi tidak boleh kosong !!");//nah ini pesan klo ada error
						}
					}
				});
		        save.setOnClickListener(new View.OnClickListener() {//action saat button save diklik
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						if(control.validasi(sp3.getSelectedItemPosition(),sp4.getSelectedItemPosition(),sp6.getSelectedItemPosition(),nama.getText().toString(),umur.getText().toString())){
							x++;
							control.setModel(x,nama.getText().toString(), index1, index2,Integer.parseInt(umur.getText().toString()) , index3, index4, index5,kksArt,kksb1);
							//nih syntax buat ngecek apakah ada data yg sudah diinput belum, walaupun gak bakal duplikat, tapi ini perlu. user perlu tau klo ada data yg tidak disimpan ke database
							control.save(control.getModel());
							refresh();
							
						}else{
							message("Pastikan semua yang perlu diisi tidak boleh kosong !!");
						}
					}
				});
	
		        return view;
	}

	

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		//untuk mendapatkan posisi (index) item yang dipilih
		index1=sp3.getSelectedItemPosition();
		index2=sp4.getSelectedItemPosition();
		index3=sp6.getSelectedItemPosition();
		index4=sp7.getSelectedItemPosition();
		index5=sp8.getSelectedItemPosition();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}
	public void refresh(){
		sp3.setSelection(0);
		sp4.setSelection(0);
		sp6.setSelection(0);
		sp7.setSelection(0);
		sp8.setSelection(0);
		umur.setText("");
		nama.setText("");
		nama.requestFocus();
		sp7.setBackgroundColor(color.background_light);
		sp7.setEnabled(false);
		sp8.setBackgroundColor(color.background_light);
		sp8.setEnabled(false);
	}
	public void message(String pesan){
		new AlertDialog.Builder(getActivity())
	    .setTitle("Peringatan")
	    .setMessage(pesan)
	    .setNeutralButton("Close", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		}).show();
	}
}
