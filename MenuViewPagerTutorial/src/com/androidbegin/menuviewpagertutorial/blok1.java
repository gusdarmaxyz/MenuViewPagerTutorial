package com.androidbegin.menuviewpagertutorial;
import com.androidbegin.controlblok.controlblok1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.actionbarsherlock.app.SherlockFragment;

public class blok1 extends SherlockFragment {
	
	//mengambil kelas controllerblok1
    static controlblok1 controller;
    
	Spinner provinsi, 					//mendefinisikan atribut Spinner untuk Spinner B1R1, B1R2, B1R3 dan B1R4
			kabupaten, 
			kecamatan, 
			kelurahan;
	RadioButton b1r5_kota, 				//mendefinisikan atribut RadioButton yang terdapat pada B1R5 dan B1R9
				b1r5_desa, 
				b1r9_ya, 
				b1r9_tdk1, 
				b1r9_tdk2;
	EditText no_BS, 					//mendefinisikan atribut EditText untuk B1R5, B1R6a, B1R6b, B1R7, B1R8, dan B1R10
			 noSub_BS, 
			 no_Sampel, 
			 no_UrutRT, 
			 alamatJl, 
			 alamatRT, 
			 alamatRW, 
			 alamatDsn;
	Button simpan;						//mendefinisikan atribut untuk Button save
	
	
	String b1r1,		//Atribut ini nantinya akan digunakan untuk mengambil nilai inputan dalam bentuk String
		   b1r2,		//(digunakan untuk membuat summary dan memasukkan nilai ke dalam model Objekblok1
		   b1r3,
		   b1r4,
		   b1r5,
		   b1r6a,
		   b1r6b,
		   b1r7,
		   b1r8,
		   b1r9,
		   b1r10;
	
	//mendefinisikan seluruh daftar provinsi, kabupaten, kecamatan dan kelurahan yang diperlukan untuk Spinner B1R1,b1R2,B1R3,B1R4 
	String[] daftarProvinsiCoba,		//hanya berisi Provinsi Bangka Belitung 
			 daftarProvinsi, 		    //berisi daftar seluruh Provinsi 
			 daftarKabupatenBabel,
			 daftarKecamatan00_Babel,	//kecamatan di Kota Pangkal Pinang
			 daftarKecamatan01_Babel,	//kecamatan di Kabupaten Bangka
			 daftarKecamatan02_Babel,	//kecamatan di Kabupaten Bangka Barat
			 daftarKecamatan03_Babel,	//kecamatan di Kabupaten Bangka Selatan
			 daftarKecamatan04_Babel, 	//kecamatan di Kabupaten Bangka Tengah
			 daftarKecamatan05_Babel,	//kecamatan di Kabupaten Belitung
			 daftarKecamatan06_Babel,	//kecamatan di Kabupaten Belitung Timur
			 daftarKelurahan00_1_Babel,
			 daftarKelurahan00_2_Babel,
			 daftarKelurahan00_3_Babel,
			 daftarKelurahan00_4_Babel,			//00 adalah kelurahan pada kota PANGKAL PINANG
			 daftarKelurahan00_5_Babel,
			 daftarKelurahan01_1_Babel,
			 daftarKelurahan01_2_Babel,
			 daftarKelurahan01_3_Babel,
			 daftarKelurahan01_4_Babel,
			 daftarKelurahan01_5_Babel,			//01 adalah kelurahan pada kabupaten BANGKA
			 daftarKelurahan01_6_Babel,
			 daftarKelurahan01_7_Babel,
			 daftarKelurahan01_8_Babel,
			 daftarKelurahan02_1_Babel,
			 daftarKelurahan02_2_Babel,
			 daftarKelurahan02_3_Babel,			//BANGKA BARAT
			 daftarKelurahan02_4_Babel,
			 daftarKelurahan02_5_Babel,
			 daftarKelurahan03_1_Babel,
			 daftarKelurahan03_2_Babel,
			 daftarKelurahan03_3_Babel,			//BANGKA SELATAN
			 daftarKelurahan03_4_Babel,
			 daftarKelurahan03_5_Babel,
			 daftarKelurahan03_6_Babel,
			 daftarKelurahan03_7_Babel,
			 daftarKelurahan04_1_Babel,
			 daftarKelurahan04_2_Babel,
			 daftarKelurahan04_3_Babel,			//BANGKA TENGAH
			 daftarKelurahan04_4_Babel,
			 daftarKelurahan04_5_Babel,
			 daftarKelurahan04_6_Babel,
			 daftarKelurahan05_1_Babel,
			 daftarKelurahan05_2_Babel,			//BELITUNG
			 daftarKelurahan05_3_Babel,
			 daftarKelurahan05_4_Babel,
			 daftarKelurahan05_5_Babel,
			 daftarKelurahan06_1_Babel,
			 daftarKelurahan06_2_Babel,			//BELITUNG TIMUR
			 daftarKelurahan06_3_Babel,
			 daftarKelurahan06_4_Babel;	
			 
	//mendefinisikan adapter yang akan digunakan sebagai sumber data pada Spinner
	ArrayAdapter <String> arrayProv, 
						  arrayKabBabel, 
						  arrayKabJogja, 
						  arrayKecBabel_00, 
						  arrayKecBabel_01,
						  arrayKecBabel_02,
						  arrayKecBabel_03,
						  arrayKecBabel_04,
						  arrayKecBabel_05,
						  arrayKecBabel_06,
						  arrayKelBabel00,
						  arrayKelBabel01,
						  arrayKelBabel02,
						  arrayKelBabel03,
						  arrayKelBabel04,
						  arrayKelBabel05,
						  arrayKelBabel06,
						  arrayKelBabel07,
						  arrayKelBabel08,
						  arrayKelBabel09,
						  arrayKelBabel10,
						  arrayKelBabel11,
						  arrayKelBabel12,
						  arrayKelBabel13,
						  arrayKelBabel14,
						  arrayKelBabel15,
						  arrayKelBabel16,
						  arrayKelBabel17,
						  arrayKelBabel18,
						  arrayKelBabel19,
						  arrayKelBabel20,
						  arrayKelBabel21,
						  arrayKelBabel22,
						  arrayKelBabel23,
						  arrayKelBabel24,
						  arrayKelBabel25,
						  arrayKelBabel26,
						  arrayKelBabel27,
						  arrayKelBabel28,
						  arrayKelBabel29,
						  arrayKelBabel30,
						  arrayKelBabel31,
						  arrayKelBabel32,
						  arrayKelBabel33,
						  arrayKelBabel34,
						  arrayKelBabel35,
						  arrayKelBabel36,
						  arrayKelBabel37,
						  arrayKelBabel38,
						  arrayKelBabel39;					 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab1.xml
		View view = inflater.inflate(R.layout.blok1, container, false);
		
		controller = new controlblok1(getActivity());
		
		provinsi  = (Spinner) view.findViewById(R.id.spinner_B1R1);
        kabupaten = (Spinner) view.findViewById(R.id.spinner_B1R2);
        kecamatan = (Spinner) view.findViewById(R.id.spinner_B1R3);
        kelurahan = (Spinner) view.findViewById(R.id.spinner_B1R4);
        b1r5_kota = (RadioButton) view.findViewById(R.id.radiobutton_B1R5_Perkotaan);
        b1r5_desa = (RadioButton) view.findViewById(R.id.radiobutton_B1R5_Pedesaan);
        b1r9_ya   = (RadioButton) view.findViewById(R.id.radiobutton_B1R9_Ya);
        b1r9_tdk1 = (RadioButton) view.findViewById(R.id.radiobutton_B1R9_TidakPengganti);
        b1r9_tdk2 = (RadioButton) view.findViewById(R.id.radiobutton_B1R9_TidakBaru);
        no_BS 	  = (EditText) view.findViewById(R.id.edittext_B1R6_NoBS);
        noSub_BS  = (EditText) view.findViewById(R.id.edittext_B1R6_NoSBS);
        no_Sampel = (EditText) view.findViewById(R.id.edittext_B1R7);
        no_UrutRT = (EditText) view.findViewById(R.id.edittext_B1R8);
        alamatJl  = (EditText) view.findViewById(R.id.edittext_B1R10_Jalan);
        alamatRT  = (EditText) view.findViewById(R.id.edittext_B1R10_RT);
        alamatRW  = (EditText) view.findViewById(R.id.edittext_B1R10_RW);
        alamatDsn = (EditText) view.findViewById(R.id.edittext_B1R10_Dusun);
        simpan	  = (Button) view.findViewById(R.id.button_SaveBlok1);
        
        
        //digunakan untuk memperoleh isi array yang telah didefinisikan sebelumnya pada file strings.xml
        daftarProvinsi 	   	       = getResources().getStringArray(R.array.provinsi);
        daftarProvinsiCoba		   = getResources().getStringArray(R.array.provinsiUji);
        daftarKabupatenBabel       = getResources().getStringArray(R.array.kabupatenBabel);
        daftarKecamatan00_Babel    = getResources().getStringArray(R.array.kecamatanPangkalPinang);
        daftarKecamatan01_Babel    = getResources().getStringArray(R.array.kecamatanBangka);
        daftarKecamatan02_Babel    = getResources().getStringArray(R.array.kecamatanBangkaBarat);
        daftarKecamatan03_Babel    = getResources().getStringArray(R.array.kecamatanBangkaSelatan);
        daftarKecamatan04_Babel    = getResources().getStringArray(R.array.kecamatanBangkaTengah);
        daftarKecamatan05_Babel    = getResources().getStringArray(R.array.kecamatanBelitung);
        daftarKecamatan06_Babel    = getResources().getStringArray(R.array.kecamatanBelitungTimur);
        daftarKelurahan00_1_Babel  = getResources().getStringArray(R.array.kelurahanBukitIntan);
        daftarKelurahan00_2_Babel  = getResources().getStringArray(R.array.kelurahanGerunggang);
        daftarKelurahan00_3_Babel  = getResources().getStringArray(R.array.kelurahanPangkalBalam);
		daftarKelurahan00_4_Babel  = getResources().getStringArray(R.array.kelurahanRangkui);
		daftarKelurahan00_5_Babel  = getResources().getStringArray(R.array.kelurahanTamanSari);
		daftarKelurahan01_1_Babel  = getResources().getStringArray(R.array.kelurahanBakam);
		daftarKelurahan01_2_Babel  = getResources().getStringArray(R.array.kelurahanBelinyu);
		daftarKelurahan01_3_Babel  = getResources().getStringArray(R.array.kelurahanMendoBarat);
		daftarKelurahan01_4_Babel  = getResources().getStringArray(R.array.kelurahanMerawang);
		daftarKelurahan01_5_Babel  = getResources().getStringArray(R.array.kelurahanPemali);
		daftarKelurahan01_6_Babel  = getResources().getStringArray(R.array.kelurahanPudingBesar);
		daftarKelurahan01_7_Babel  = getResources().getStringArray(R.array.kelurahanRiauSilip);
		daftarKelurahan01_8_Babel  = getResources().getStringArray(R.array.kelurahanSungaiLiat);
		daftarKelurahan02_1_Babel  = getResources().getStringArray(R.array.kelurahanJebus);
		daftarKelurahan02_2_Babel  = getResources().getStringArray(R.array.kelurahanKelapa);
		daftarKelurahan02_3_Babel  = getResources().getStringArray(R.array.kelurahanMuntok);
		daftarKelurahan02_4_Babel  = getResources().getStringArray(R.array.kelurahanSimpangTeritip);
		daftarKelurahan02_5_Babel  = getResources().getStringArray(R.array.kelurahanTempilang);
		daftarKelurahan03_1_Babel  = getResources().getStringArray(R.array.kelurahanAirGegas);
		daftarKelurahan03_2_Babel  = getResources().getStringArray(R.array.kelurahanLeparPongok);
		daftarKelurahan03_3_Babel  = getResources().getStringArray(R.array.kelurahanPayung);
		daftarKelurahan03_4_Babel  = getResources().getStringArray(R.array.kelurahanPulauBesar);
		daftarKelurahan03_5_Babel  = getResources().getStringArray(R.array.kelurahanSimpangRimba);
		daftarKelurahan03_6_Babel  = getResources().getStringArray(R.array.kelurahanToboali);
		daftarKelurahan03_7_Babel  = getResources().getStringArray(R.array.kelurahanTukakSadai);
		daftarKelurahan04_1_Babel  = getResources().getStringArray(R.array.kelurahanKoba);
		daftarKelurahan04_2_Babel  = getResources().getStringArray(R.array.kelurahanLubukBesar);
		daftarKelurahan04_3_Babel  = getResources().getStringArray(R.array.kelurahanNamang);
		daftarKelurahan04_4_Babel  = getResources().getStringArray(R.array.kelurahanPangkalanBaru);
		daftarKelurahan04_5_Babel  = getResources().getStringArray(R.array.kelurahanSimpangKatis);
		daftarKelurahan04_6_Babel  = getResources().getStringArray(R.array.kelurahanSelan);
		daftarKelurahan05_1_Babel  = getResources().getStringArray(R.array.kelurahanBadau);
		daftarKelurahan05_2_Babel  = getResources().getStringArray(R.array.kelurahanMembalong);
		daftarKelurahan05_3_Babel  = getResources().getStringArray(R.array.kelurahanNasik);
		daftarKelurahan05_4_Babel  = getResources().getStringArray(R.array.kelurahanSijuk);
		daftarKelurahan05_5_Babel  = getResources().getStringArray(R.array.kelurahanTanjungPandang);
		daftarKelurahan06_1_Babel  = getResources().getStringArray(R.array.kelurahanDendang);
		daftarKelurahan06_2_Babel  = getResources().getStringArray(R.array.kelurahanGantung);
		daftarKelurahan06_3_Babel  = getResources().getStringArray(R.array.kelurahanKelapaKampit);
		daftarKelurahan06_4_Babel  = getResources().getStringArray(R.array.kelurahanManggar);
        
		
		//Membuat spinnerB1R1(Spinner Provinsi) yang berisikan daftarProvinsiCoba
        arrayProv = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarProvinsiCoba);
        arrayProv.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provinsi.setAdapter(arrayProv);
        provinsi.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
					//Mengatur perubahan pada Spinner Kabupaten sesuai dengan item pada Spinner Provinsi yang diklik
					String prov = daftarProvinsiCoba[arg0.getSelectedItemPosition()];
					
					if (prov.equals("Kepulauan Bangka Belitung")){
						//mengatur isi Spinner Kabupaten yang berisi daftar Kabupaten pada provinsi Babel
						arrayKabBabel = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKabupatenBabel);
						arrayKabBabel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
						kabupaten.setAdapter(arrayKabBabel);
					}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {	
			}
		});
        
        kabupaten.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				//Mengatur perubahan pada Spinner Kecamatan sesuai dengan item pada Spinner Kabupaten yang diklik
				String kab = arg0.getSelectedItem().toString();
				//Mengatur perubahan pada Spinner Kecamatan sesuai dengan item pada Spinner Kabupaten yang diklik
				if(kab.equals("Bangka")){
					arrayKecBabel_00 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKecamatan01_Babel);
					arrayKecBabel_00.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kecamatan.setAdapter(arrayKecBabel_00);
				}else if(kab.equals("Bangka Barat")){
					arrayKecBabel_01 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKecamatan02_Babel);
					arrayKecBabel_01.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kecamatan.setAdapter(arrayKecBabel_01);
				}else if(kab.equals("Bangka Selatan")){
					arrayKecBabel_02 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKecamatan03_Babel);
					arrayKecBabel_02.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kecamatan.setAdapter(arrayKecBabel_02);
				}else if(kab.equals("Bangka Tengah")){
					arrayKecBabel_03 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKecamatan04_Babel);
					arrayKecBabel_03.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kecamatan.setAdapter(arrayKecBabel_03);
				}else if(kab.equals("Belitung")){
					arrayKecBabel_04 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKecamatan05_Babel);
					arrayKecBabel_04.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kecamatan.setAdapter(arrayKecBabel_04);
				}else if(kab.equals("Belitung Timur")){
					arrayKecBabel_05 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKecamatan06_Babel);
					arrayKecBabel_05.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kecamatan.setAdapter(arrayKecBabel_05);
				}else if(kab.equals("Pangkal Pinang")){
					arrayKecBabel_06 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKecamatan00_Babel);
					arrayKecBabel_06.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kecamatan.setAdapter(arrayKecBabel_06);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			
			}
		});
		
        
        kecamatan.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				//Mengatur perubahan pada Spinner Kelurahan sesuai dengan item pada Spinner Kecamatan yang diklik
				String kec = arg0.getSelectedItem().toString();
				if(kec.equals("Bukit Intan")){
					arrayKelBabel00 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan00_1_Babel);
					arrayKelBabel00 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel00);
				}else if(kec.equals("Gerunggang")){
					arrayKelBabel01 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan00_2_Babel);
					arrayKelBabel01 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel01);
				}else if(kec.equals("Pangkalbalam")){
					arrayKelBabel02 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan00_3_Babel);
					arrayKelBabel02 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel02);
				}else if(kec.equals("Rangkui")){
					arrayKelBabel03 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan00_4_Babel);
					arrayKelBabel03 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel03);
				}else if(kec.equals("Taman Sari")){
					arrayKelBabel04 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan00_5_Babel);
					arrayKelBabel04 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel04);
				}else if(kec.equals("Bakam")){
					arrayKelBabel05 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan01_1_Babel);
					arrayKelBabel05 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel05);
				}else if(kec.equals("Belinyu")){
					arrayKelBabel06 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan01_2_Babel);
					arrayKelBabel06 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel06);
				}else if(kec.equals("Mendo Barat")){
					arrayKelBabel07 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan01_3_Babel);
					arrayKelBabel07 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel07);
				}else if(kec.equals("Merawang")){
					arrayKelBabel08 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan01_4_Babel);
					arrayKelBabel08 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel08);
				}else if(kec.equals("Pemali")){
					arrayKelBabel09 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan01_5_Babel);
					arrayKelBabel09 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel09);
				}else if(kec.equals("Puding Besar")){
					arrayKelBabel10 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan01_6_Babel);
					arrayKelBabel10 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel10);
				}else if(kec.equals("Riau Silip")){
					arrayKelBabel11 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan01_7_Babel);
					arrayKelBabel11 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel11);
				}else if(kec.equals("Sungailiat")){
					arrayKelBabel12 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan01_8_Babel);
					arrayKelBabel12 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel12);
				}else if(kec.equals("Jebus")){
					arrayKelBabel13 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan02_1_Babel);
					arrayKelBabel13 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel13);
				}else if(kec.equals("Kelapa")){
					arrayKelBabel14 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan02_2_Babel);
					arrayKelBabel14 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel14);
				}else if(kec.equals("Muntok")){
					arrayKelBabel15 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan02_3_Babel);
					arrayKelBabel15 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel15);
				}else if(kec.equals("Simpang Teritip")){
					arrayKelBabel16 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan02_4_Babel);
					arrayKelBabel16 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel16);
				}else if(kec.equals("Tempilang")){
					arrayKelBabel17 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan02_5_Babel);
					arrayKelBabel17 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel17);
				}else if(kec.equals("Air Gegas")){
					arrayKelBabel18 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan03_1_Babel);
					arrayKelBabel18 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel18);
				}else if(kec.equals("Lepar Pongok")){
					arrayKelBabel19 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan03_2_Babel);
					arrayKelBabel19 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel19);
				}else if(kec.equals("Payung")){
					arrayKelBabel20 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan03_3_Babel);
					arrayKelBabel20 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel20);
				}else if(kec.equals("Pulau Besar")){
					arrayKelBabel21 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan03_4_Babel);
					arrayKelBabel21 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel21);
				}else if(kec.equals("Simpang Rimba")){
					arrayKelBabel22 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan03_5_Babel);
					arrayKelBabel22 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel22);
				}else if(kec.equals("Toboali")){
					arrayKelBabel23 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan03_6_Babel);
					arrayKelBabel23 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel23);
				}else if(kec.equals("Tukak Sadai")){
					arrayKelBabel24 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan03_7_Babel);
					arrayKelBabel24 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel24);
				}else if(kec.equals("Koba")){
					arrayKelBabel25 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan04_1_Babel);
					arrayKelBabel25 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel25);
				}else if(kec.equals("Lubuk Besar")){
					arrayKelBabel26 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan04_2_Babel);
					arrayKelBabel26 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel26);
				}else if(kec.equals("Namang")){
					arrayKelBabel27 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan04_3_Babel);
					arrayKelBabel27 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel27);
				}else if(kec.equals("Pangkalan Baru")){
					arrayKelBabel28 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan04_4_Babel);
					arrayKelBabel28 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel28);
				}else if(kec.equals("Simpang Katis")){
					arrayKelBabel29 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan04_5_Babel);
					arrayKelBabel29 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel29);
				}else if(kec.equals("Sungai Selan")){
					arrayKelBabel30 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan04_6_Babel);
					arrayKelBabel30 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel30);
				}else if(kec.equals("Badau")){
					arrayKelBabel31 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan05_1_Babel);
					arrayKelBabel31 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel31);
				}else if(kec.equals("Membalong")){
					arrayKelBabel32 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan05_2_Babel);
					arrayKelBabel32 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel32);
				}else if(kec.equals("Selat Nasik")){
					arrayKelBabel33 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan05_3_Babel);
					arrayKelBabel33 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel33);
				}else if(kec.equals("Sijuk")){
					arrayKelBabel34 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan05_4_Babel);
					arrayKelBabel34 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel34);
				}else if(kec.equals("Tanjung Pandan")){
					arrayKelBabel35 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan05_5_Babel);
					arrayKelBabel35 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel35);
				}else if(kec.equals("Dendang")){
					arrayKelBabel36 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan06_1_Babel);
					arrayKelBabel36 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel36);
				}else if(kec.equals("Gantung")){
					arrayKelBabel37 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan06_2_Babel);
					arrayKelBabel37 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel37);
				}else if(kec.equals("Kelapa Kampit")){
					arrayKelBabel38 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan06_3_Babel);
					arrayKelBabel38 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel38);
				}else if(kec.equals("Manggar")){
					arrayKelBabel39 = new ArrayAdapter<String>(context(), android.R.layout.simple_spinner_dropdown_item, daftarKelurahan06_4_Babel);
					arrayKelBabel39 .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
					kelurahan.setAdapter(arrayKelBabel39);
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			
				}
			});
		//ketika tombol simpan di klik
        simpan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				boolean isTerisiSemua;

	            isTerisiSemua = !no_BS.getText().toString().equals("")&&
	                            !no_BS.getText().toString().equals(null)&&
	                            !noSub_BS.getText().toString().equals("")&&
	                            !noSub_BS.getText().toString().equals(null)&&
	                            !no_Sampel.getText().toString().equals("")&&
	                            !no_Sampel.getText().toString().equals(null)&&
	                            !no_UrutRT.getText().toString().equals("")&&
	                            !no_UrutRT.getText().toString().equals(null)&&
	                            !alamatJl.getText().toString().equals("")&&
	                            !alamatJl.getText().toString().equals(null)&&
	                            !alamatRT.getText().toString().equals("")&&
	                            !alamatRT.getText().toString().equals(null)&&
	                            !alamatRW.getText().toString().equals("")&&
	                            !alamatRW.getText().toString().equals(null)&&
	                            !alamatDsn.getText().toString().equals("")&&
	                            !alamatDsn.getText().toString().equals(null);
	            //validasi field harus terisi semua
	            if(isTerisiSemua) {
	            	b1r1 = provinsi.getSelectedItem().toString();
	            	b1r2 = kabupaten.getSelectedItem().toString();
	            	b1r3 = kecamatan.getSelectedItem().toString();
	            	b1r4 = kelurahan.getSelectedItem().toString();
	            	b1r6a= no_BS.getText().toString();
	            	b1r6b= noSub_BS.getText().toString();
	            	b1r7 = no_Sampel.getText().toString();
	            	b1r8 = no_UrutRT.getText().toString();
	            	b1r10= alamatJl.getText().toString() + " RT " + alamatRT.getText().toString() + 
  						  " RW " + alamatRW.getText().toString() + " " + alamatDsn.getText().toString();
	            	if(b1r5_kota.isChecked())
	                	b1r5 = "Perkotaan";
	                else if(b1r5_desa.isChecked())
	                	b1r5 = "Pedesaan";
	                
	                if(b1r9_ya.isChecked())
	                	b1r9 = "Ya";
	                else if(b1r9_tdk1.isChecked())
	                	b1r9 = "Tidak, RT pengganti";
	                else if(b1r9_tdk2.isChecked())
	                	b1r9 = "Tidak, RT baru";
	                
	                //Memunculkan Kotak Dialog Konfirmasi
	                AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());
	                ab.setMessage("Provinsi : " + b1r1 + "\nKabupaten : " + b1r2 + "\nKecamatan : " + b1r3 + "\nKelurahan : " + b1r4 + "\nKlasifikasi : " + b1r5 + "\nNo BS : " + b1r6a + "\nNoSub BS : " + b1r6b + "\nNo Sampel : " + b1r7 + "\nNo Urut RT : " + b1r8 + "\nSampel Lalu? " + b1r9 + "\nAlamat : " + b1r10   	
	                			   + "\n\n Anda yakin akan menyimpan?");
	                ab.setTitle("SUMMARY");
	                ab.setCancelable(false);
	                ab.setNegativeButton("Ya", new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int which) {
	                    	
	                    	controller.model.setB1R1(b1r1);
	    	                controller.model.setB1R2(b1r2);
	    	                controller.model.setB1R3(b1r3);
	    	                controller.model.setB1R4(b1r4);
	    	                controller.model.setB1R5(b1r5);
	    	                controller.model.setB1R6a(b1r6a);
	    	                controller.model.setB1R6b(b1r6b);
	    	                controller.model.setB1R7(b1r7);
	    	                controller.model.setB1R8(b1r8);
	    	                controller.model.setB1R9(b1r9);
	    	                controller.model.setB1R10(b1r10);
	    	                
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
    	 no_BS.setText(null); 
		 noSub_BS.setText(null); 
		 no_Sampel.setText(null);
		 no_UrutRT.setText(null);
		 alamatJl.setText(null);
		 alamatRT.setText(null);
		 alamatRW.setText(null); 
		 alamatDsn.setText(null);
		 b1r5_kota.setChecked(true);
		 b1r9_ya.setChecked(true);
    }

}
