package com.androidbegin.menuviewpagertutorial;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

import com.androidbegin.database.DBblok6;


public class lihat_hasil extends Fragment {


    DBblok6 DB;
    View view;
    Cursor kumpulan_hasil;
    StringBuffer text=new StringBuffer();

    TextView Hasil;
    Button BACK;
    Button EXIT;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lihat_hasil, container, false);

        Hasil=(TextView)view.findViewById(R.id.textViewHasil);
        BACK=(Button)view.findViewById(R.id.buttonBack);
        BACK.setOnClickListener(clickBACK);
        EXIT=(Button)view.findViewById(R.id.buttonExit);
        EXIT.setOnClickListener(clickEXIT);

        DB=new DBblok6(getActivity());

        try {
            DB.open();
            kumpulan_hasil=DB.getAllTitles();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(kumpulan_hasil.moveToFirst()){
            do{
                masukkanData();
            } while (kumpulan_hasil.moveToNext());
        }

        Hasil.setText(text);
        DB.close();
        return view;

    }

    private void masukkanData(){
        text.append("\n\nKKSB6 :"+kumpulan_hasil.getString(0));
        text.append("\nKKS :"+kumpulan_hasil.getString(1));
        text.append("\nB1R1 :"+kumpulan_hasil.getString(2));
        text.append("\nB1R2 :"+kumpulan_hasil.getString(3));
        text.append("\nB1R3 :"+kumpulan_hasil.getString(4));
        text.append("\nB1R4 :"+kumpulan_hasil.getString(5));
        text.append("\nB1R5 :"+kumpulan_hasil.getString(6));
        text.append("\nB1R6a :"+kumpulan_hasil.getString(7));
        text.append("\nB1R6b :"+kumpulan_hasil.getString(8));
        text.append("\nB1R7 :"+kumpulan_hasil.getString(9));
        text.append("\nB1R8 :"+kumpulan_hasil.getString(10));
        text.append("\nB1R9a :"+kumpulan_hasil.getString(11));
        text.append("\nB1R9b :"+kumpulan_hasil.getString(12));
        text.append("\nB1R9c :"+kumpulan_hasil.getString(13));
        text.append("\nB1R10 :"+kumpulan_hasil.getString(14));
    }

    View.OnClickListener clickBACK=new View.OnClickListener() {
    	
        @Override
        public void onClick(View v) {
            //FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            
            //transaction.replace(R.id.tempat_fragment, new blok6a());
            
            //transaction.addToBackStack(null);
            //transaction.commit();
        }
    };

    View.OnClickListener clickEXIT=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.exit(0);
        }
    };


}
