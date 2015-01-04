package com.androidbegin.menuviewpagertutorial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.actionbarsherlock.app.SherlockFragment;
import com.androidbegin.controlblok.controlblok5b;
import com.androidbegin.objekblok.objekblok5b;

public class blok5b extends SherlockFragment {
	//mengambil kelas controllerblok1
    static controlblok5b controller;
    public objekblok5b model = new objekblok5b();
    
	
    TextView t_umurBln;
    EditText umurBln;
    TextView t_umurHari;
    EditText umurHari;
	TextView t_penolong1;
	Spinner spinnerPenolong1;
	TextView t_penolong2;
	Spinner spinnerPenolong2;
	TextView t_BCG;
	EditText imunisasi_BCG;
	TextView t_DPT;
	EditText imunisasi_DPT;
	TextView t_Polio;
	EditText imunisasi_Polio;
	TextView t_Campak;
	EditText imunisasi_Campak;
	TextView t_Hepatitis;
	EditText imunisasi_Hepatitis;
	TextView t_asi;
	RadioButton rbYa;
	RadioButton rbTidak;
	TextView t_lamaAsi;
	EditText asi_lamaPemberian;
	TextView t_lamaAsiSaja;
	EditText asi_saja;
	TextView t_lamaMakananPendamping;
	EditText asi_makananPendamping;
	Button Save, Cancel;
	String[] penolong = {"Dokter", "Bidan", "Tenaga Paramedis Lain", "Dukun Bersalin", "Famili/Keluarga", "Lainnya"}; 
	
	String b5r9a,		//Atribut ini nantinya akan digunakan untuk mengambil nilai inputan dalam bentuk String
	   b5r9b,		//(digunakan untuk membuat summary dan memasukkan nilai ke dalam model Objekblok1
	   b5r10a,
	   b5r10b,
	   b5r11a,
	   b5r11b,
	   b5r11c,
	   b5r11d,
	   b5r11e,
	   b5r12a,
	   b5r12b1,
	   b5r12b2,
	   b5r12b3;
	
	//mendefinisikan adapter yang akan digunakan sebagai sumber data pada Spinner
		ArrayAdapter <String> arrPenolong1, 
							  arrPenolong2; 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.blok5b, container, false);
		
		t_umurBln=(TextView) view.findViewById(R.id.textview_B5BR9_Bulan);
		umurBln=(EditText) view.findViewById(R.id.edittext_B5BR9_Bulan);
		t_umurHari=(TextView) view.findViewById(R.id.textview_B5BR9_Hari);
		umurHari=(EditText) view.findViewById(R.id.edittext_B5BR9_Hari);
		t_penolong1=(TextView) view.findViewById(R.id.textview_B5BR10_Pertama);
		spinnerPenolong1 = (Spinner) view.findViewById(R.id.spinner_B5BR10_Pertama); 
		t_penolong2=(TextView) view.findViewById(R.id.textview_B5BR10_Terakhir);
		spinnerPenolong2 = (Spinner) view.findViewById(R.id.spinner_B5BR10_Terakhir);
		t_BCG=(TextView) view.findViewById(R.id.textview_B5BR11_BCG);
		imunisasi_BCG=(EditText) view.findViewById(R.id.edittext_BCG);
		t_DPT=(TextView) view.findViewById(R.id.textview_B5BR11_DPT);
		imunisasi_DPT=(EditText) view.findViewById(R.id.edittext_B5BR11_DPT);
		t_Polio=(TextView) view.findViewById(R.id.textview_B5BR11_Polio);
		imunisasi_Polio=(EditText) view.findViewById(R.id.edittext_B5BR11_Polio);
		t_Campak=(TextView) view.findViewById(R.id.textview_B5BR11_Campak);
		imunisasi_Campak=(EditText) view.findViewById(R.id.edittext_B5BR11_Campak);
		t_Hepatitis=(TextView) view.findViewById(R.id.textview_B5BR11_Hepatitis);
		imunisasi_Hepatitis=(EditText) view.findViewById(R.id.edittext_B5BR11_Hepatitis);
		t_asi=(TextView) view.findViewById(R.id.textview_B5BR12_ASI);
		rbYa = (RadioButton) view.findViewById(R.id.radiobutton_B5BR12_ASI_Ya);
		rbTidak = (RadioButton) view.findViewById(R.id.radiobutton_B5BR12_ASI_Tidak);
		t_lamaAsi=(TextView) view.findViewById(R.id.textview_B5BR12_Lama_a);
		asi_lamaPemberian=(EditText) view.findViewById(R.id.edittext_B5BR12_Lama_a);
		t_lamaAsiSaja=(TextView) view.findViewById(R.id.textview_B5BR12_Lama_b);
		asi_saja=(EditText) view.findViewById(R.id.edittext_B5BR12_Lama_b);
		t_lamaMakananPendamping=(TextView) view.findViewById(R.id.textview_B5BR12_Lama_c);
		asi_makananPendamping=(EditText) view.findViewById(R.id.edittext_B5BR12_Lama_c);
		Save=(Button) view.findViewById(R.id.button_SaveBlok5B);
		Cancel=(Button) view.findViewById(R.id.button_CancelBlok2);
		
		myInitial(false);
		
		//Membuat spinnerB5R10a(Spinner Penolong1) 
        arrPenolong1 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, penolong);
        arrPenolong1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPenolong1.setAdapter(arrPenolong1);
        
        //Membuat spinnerB5R10b(Spinner Penolong2) 
        arrPenolong2 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, penolong);
        arrPenolong2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPenolong2.setAdapter(arrPenolong2);      
		
        Save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean isTerisiSemua;
				
				

	            isTerisiSemua = !umurBln.getText().toString().equals("") &&
                        		!umurHari.getText().toString().equals(null) &&
	                            !imunisasi_BCG.getText().toString().equals("")&&
	                            !imunisasi_DPT.getText().toString().equals(null)&&
	                            !imunisasi_Polio.getText().toString().equals("")&&
	                            !imunisasi_Campak.getText().toString().equals(null)&&
	                            !imunisasi_Hepatitis.getText().toString().equals("")&&
	                            !asi_lamaPemberian.getText().toString().equals(null)&&
	                            !asi_saja.getText().toString().equals("")&&
	                            !asi_makananPendamping.getText().toString().equals(null);

	            if(isTerisiSemua) {
	            	b5r9a = umurBln.getText().toString();
	            	b5r9b = umurHari.getText().toString();
	            	b5r10a = spinnerPenolong1.getSelectedItem().toString();
	            	b5r10b = spinnerPenolong2.getSelectedItem().toString();
	            	b5r11a = imunisasi_BCG.getText().toString();
	            	b5r11b = imunisasi_DPT.getText().toString();
	            	b5r11c = imunisasi_Polio.getText().toString();
	            	b5r11d = imunisasi_Campak.getText().toString();
	            	b5r11e = imunisasi_Hepatitis.getText().toString();
	            	if(rbYa.isChecked())
	                	b5r12a = "Ya";
	                else if(rbTidak.isChecked())
	                	b5r12a = "Tidak pernah";
	            	b5r12b1 = asi_lamaPemberian.getText().toString();
	            	b5r12b2 = asi_saja.getText().toString();
	            	b5r12b3 = asi_makananPendamping.getText().toString();
	            		                
	                //Memunculkan Kotak Dialog Konfirmasi
	                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
	                ab.setMessage("Umur : " + b5r9a + " bulan" + "\nUmur : " + b5r9b + " hari" + "\nPenolong proses kelahiran anak pertama : " + b5r10a +
	                				"\nPenolong proses kelahiran anak kedua : " + b5r10b + "\nFrekuensi mendapatkan imunisasi" + "\nBCG : " + b5r11a + 
	                				"\nDPT : " + b5r11b + "\nPolio : " + b5r11c + "\nCampak/Morbili : " + b5r11d + "\nHepatitis B : " + b5r11e + 
	                				"\nPernah di beri ASI? " + b5r12a + "\nLama pemberian ASI : " + b5r12b1 + "\nASI saja : " + b5r12b2 +	
	                				"\nASI dengan makanan pengganti : " + b5r12b1 + "\n\n Anda yakin akan menyimpan?");
	                ab.setTitle("SUMMARY");
	                ab.setCancelable(false);
	                ab.setNegativeButton("Ya", new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int which) {
	                    	
	                    	controller.model.setB5R9a(b5r9a);
	    	                controller.model.setB5R9b(b5r9b);
	    	                controller.model.setB5R10a(b5r10a);
	    	                controller.model.setB5R11a(b5r11a);
	    	                controller.model.setB5R11b(b5r11b);
	    	                controller.model.setB5R11c(b5r11c);
	    	                controller.model.setB5R11d(b5r11d);
	    	                controller.model.setB5R11e(b5r11e);
	    	                controller.model.setB5R12a(b5r12a);
	    	                controller.model.setB5R12b1(b5r12b1);
	    	                controller.model.setB5R12b2(b5r12b2);
	    	                controller.model.setB5R12b3(b5r12b3);
	    	                
	    	                try {
	    	                    controller.masukkanDataToDB();
	    	                   
	    	                } catch (SQLException e) {
	    	                    Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG);
	    	                }
	    	                
	    	               refresh();
	    	               dialog.cancel();
	    	               Toast.makeText(getActivity(), "Penyimpanan data telah berhasil dilakukan", Toast.LENGTH_SHORT).show();
	                    }}
	                );
	                ab.setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int which) {
	                    dialog.cancel();
	                    }}
	                );
	                ab.create().show();   
	            }
	            else {
	                final AlertDialog peringatan = new AlertDialog.Builder(getActivity()).create();
	                peringatan.setMessage("Belum Lengkap \nLengkapi dahulu sebelum ke halaman selanjutnya");
	                peringatan.setButton("OK", new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int which) {
	                    peringatan.cancel();
	                    }}
	                );
	                peringatan.show();
	            }
	        }
		});
        return view;
	}
		
		public void refresh(){
			umurBln.setText(null); 
			umurHari.setText(null); 
			imunisasi_BCG.setText(null);
			imunisasi_DPT.setText(null);
			imunisasi_Polio.setText(null);
			imunisasi_Campak.setText(null);
			imunisasi_Hepatitis.setText(null); 
			rbYa.setChecked(true);
			asi_lamaPemberian.setText(null);
			asi_makananPendamping.setText(null);
        	asi_saja.setText(null);
			
   }

	
		public void onClick(View v) {
			 if(v.getId()==R.id.radiobutton_B5BR12_ASI_Ya){
				myInitial1(true);
			}
			
		}

		public void myInitial(boolean set){
			t_umurHari.setEnabled(set);
			umurHari.setEnabled(set);
			t_penolong1.setEnabled(set);
			spinnerPenolong1.setEnabled(set);
			t_penolong2.setEnabled(set);
			spinnerPenolong2.setEnabled(set);
			t_BCG.setEnabled(set);
			imunisasi_BCG.setEnabled(set);
			t_DPT.setEnabled(set);
			imunisasi_DPT.setEnabled(set);
			t_Polio.setEnabled(set);
			imunisasi_Polio.setEnabled(set);
			t_Campak.setEnabled(set);
			imunisasi_Campak.setEnabled(set);
			t_Hepatitis.setEnabled(set);
			imunisasi_Hepatitis.setEnabled(set);
			t_asi.setEnabled(set);
			rbYa.setEnabled(set);
			rbTidak.setEnabled(set);
			t_lamaAsi.setEnabled(set);
			asi_lamaPemberian.setEnabled(set);
			t_lamaAsiSaja.setEnabled(set);
			asi_saja.setEnabled(set);
			t_lamaMakananPendamping.setEnabled(set);
			asi_makananPendamping.setEnabled(set);
		}
		
		public void myInitial1(boolean set){
			t_lamaAsi.setEnabled(set);
			asi_lamaPemberian.setEnabled(set);
			t_lamaAsiSaja.setEnabled(set);
			asi_saja.setEnabled(set);
			t_lamaMakananPendamping.setEnabled(set);
			asi_makananPendamping.setEnabled(set);
		}
}
