package com.androidbegin.menuviewpagertutorial;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.actionbarsherlock.app.SherlockFragment;
import com.androidbegin.controlblok.controlblok5e;

public class blok5e extends SherlockFragment implements OnClickListener{
	EditText b5r27_input;
    EditText b5r28_input;
    EditText b5r29apa_input;
    EditText b5r29api_input;
    EditText b5r29bpa_input;
    EditText b5r29bpi_input;
    EditText b5r29cpa_input;
    EditText b5r29cpi_input;
    RadioGroup b5r30;
    RadioButton b5r30a;
    RadioButton b5r30b;
    RadioButton b5r30c;
    Spinner spinner;
    Button simpan;

    String[] items={
            "MOW/tubektomi",
            "MOP/vasektomi",
            "AKDR/IUD/spiral",
            "Suntikan KB",
            "Susuk KB",
            "Pil KB",
            "Kondom",
            "Intravag",
            "Cara tradisional"};

    ArrayAdapter<String> aa;

    private controlblok5e b5e=new controlblok5e();
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Get the view from fragmenttab2.xml
		View view = inflater.inflate(R.layout.blok5e, container, false);
		b5r27_input=(EditText) view.findViewById(R.id.b5r27);
        b5r28_input=(EditText) view.findViewById(R.id.b5r28);
        b5r29apa_input=(EditText) view.findViewById(R.id.b5r29apa);
        b5r29api_input=(EditText) view.findViewById(R.id.b5r29api);
        b5r29bpa_input=(EditText) view.findViewById(R.id.b5r29bpa);
        b5r29bpi_input=(EditText) view.findViewById(R.id.b5r29bpi);
        b5r29cpa_input=(EditText) view.findViewById(R.id.b5r29cpa);
        b5r29cpi_input=(EditText) view.findViewById(R.id.b5r29cpi);
        b5r30a=(RadioButton) view.findViewById(R.id.b5r30a);
        b5r30b=(RadioButton) view.findViewById(R.id.b5r30b);
        b5r30c=(RadioButton) view.findViewById(R.id.b5r30b);
        spinner =(Spinner) view.findViewById(R.id.spinner1);
        simpan=(Button) view.findViewById(R.id.simpan);

        b5r30a.setOnClickListener(this);
        b5r30b.setOnClickListener(this);
        b5r30c.setOnClickListener(this);
        simpan.setOnClickListener(this);

        aa=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,items);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
		
		return view;
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.b5r30a){
            spinner.setEnabled(true);
        }else if(v.getId()==R.id.b5r30b){
            spinner.setEnabled(false);
        }else if(v.getId()==R.id.b5r30c){
            spinner.setEnabled(false);
        }

        if(v.getId()==R.id.simpan){
            setVar();
            reset();
            b5r27_input.setSelected(true);
        }
		
	}
	
	public int getVar(EditText et){
        Editable editable=et.getEditableText();
        String s=String.valueOf(editable);
        if(!s.equalsIgnoreCase("")){
            return Integer.parseInt(s);
        } else
            return 0;
    }

    public void setVar(){
        b5e.setb5r27(getVar(b5r27_input));
        b5e.setb5r28(getVar(b5r28_input));
        b5e.setb5r29(getVar(b5r29apa_input),
                getVar(b5r29api_input),
                getVar(b5r29bpa_input),
                getVar(b5r29bpi_input),
                getVar(b5r29cpa_input),
                getVar(b5r29cpi_input));

        if(b5r30a.isChecked()){
            b5e.setb5r30(1);
        }else if(b5r30b.isChecked()){
            b5e.setb5r30(2);
        }else if(b5r30c.isChecked()){
            b5e.setb5r30(3);
        }else b5e.setb5r30(0);

        b5e.setb5r31(spinner.getSelectedItemPosition()+1);
    }


    public void reset(){
        b5r27_input.setText("");
        b5r28_input.setText("");
        b5r29apa_input.setText("");
        b5r29api_input.setText("");
        b5r29bpa_input.setText("");
        b5r29bpi_input.setText("");
        b5r29cpa_input.setText("");
        b5r29cpi_input.setText("");
        b5r30a.setChecked(false);
        b5r30b.setChecked(false);
        b5r30c.setChecked(false);
        spinner.setSelection(0);
    }
}
