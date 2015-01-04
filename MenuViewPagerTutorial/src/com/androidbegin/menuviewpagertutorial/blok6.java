import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by ASUS on 12/31/2014.
 */
public class blok6 extends Fragment implements AdapterView.OnItemSelectedListener{

    Fragment next=new lihat_hasil();

    static controlblok6 controllerb6;
    View view;
    TextView R1t, R2t, R3t, R4t, R5t, R6at, R6bt, R7t, R8t, R9at, R9bt, R9ct, R10t;
    EditText R5;
    Spinner R1, R2, R3, R4, R6a, R6b, R7, R8, R9a, R9b, R9c, R10;
    LinearLayout R1l, R2l, R3l, R4l, R5l, R6al, R6bl, R7l, R8l, R9al, R9bl, R9cl, R10l;
    Button save, cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.blok6, container, false);

        controllerb6=new controlblok6(getActivity());

        R1t=(TextView)view.findViewById(R.id.B6_R_1_Teks);
        R2t=(TextView)view.findViewById(R.id.B6_R_2_Teks);
        R3t=(TextView)view.findViewById(R.id.B6_R_3_Teks);
        R4t=(TextView)view.findViewById(R.id.B6_R_4_Teks);
        R5t=(TextView)view.findViewById(R.id.B6_R_5_Teks);
        R6at=(TextView)view.findViewById(R.id.B6_R_6a_Teks);
        R6bt=(TextView)view.findViewById(R.id.B6_R_6b_Teks);
        R7t=(TextView)view.findViewById(R.id.B6_R_7_Teks);
        R8t=(TextView)view.findViewById(R.id.B6_R_8_Teks);
        R9at=(TextView)view.findViewById(R.id.B6_R_9a_Teks);
        R9bt=(TextView)view.findViewById(R.id.B6_R_9b_Teks);
        R9ct=(TextView)view.findViewById(R.id.B6_R_9c_Teks);
        R10t=(TextView)view.findViewById(R.id.B6_R_10_Teks);


        R1=(Spinner)view.findViewById(R.id.B6_R_1_Spinner);
        R2=(Spinner)view.findViewById(R.id.B6_R_2_Spinner);
        R3=(Spinner)view.findViewById(R.id.B6_R_3_Spinner);
        R4=(Spinner)view.findViewById(R.id.B6_R_4_Spinner);
        R5=(EditText)view.findViewById(R.id.B6_R_5_EditText);
        R6a=(Spinner)view.findViewById(R.id.B6_R_6a_Spinner);
        R6b=(Spinner)view.findViewById(R.id.B6_R_6b_Spinner);
        R7=(Spinner)view.findViewById(R.id.B6_R_7_Spinner);
        R8=(Spinner)view.findViewById(R.id.B6_R_8_Spinner);
        R9a=(Spinner)view.findViewById(R.id.B6_R_9a_Spinner);
        R9b=(Spinner)view.findViewById(R.id.B6_R_9b_Spinner);
        R9c=(Spinner)view.findViewById(R.id.B6_R_9c_Spinner);
        R10=(Spinner)view.findViewById(R.id.B6_R_10_Spinner);
        isiSpinner();

        R1l=(LinearLayout)view.findViewById(R.id.B6_R_1_Layout);
        R2l=(LinearLayout)view.findViewById(R.id.B6_R_2_Layout);
        R3l=(LinearLayout)view.findViewById(R.id.B6_R_3_Layout);
        R4l=(LinearLayout)view.findViewById(R.id.B6_R_4_Layout);
        R5l=(LinearLayout)view.findViewById(R.id.B6_R_5_Layout);
        R6al=(LinearLayout)view.findViewById(R.id.B6_R_6a_Layout);
        R6bl=(LinearLayout)view.findViewById(R.id.B6_R_6b_Layout);
        R7l=(LinearLayout)view.findViewById(R.id.B6_R_7_Layout);
        R8l=(LinearLayout)view.findViewById(R.id.B6_R_8_Layout);
        R9al=(LinearLayout)view.findViewById(R.id.B6_R_9a_Layout);
        R9bl=(LinearLayout)view.findViewById(R.id.B6_R_9b_Layout);
        R9cl=(LinearLayout)view.findViewById(R.id.B6_R_9c_Layout);
        R10l=(LinearLayout)view.findViewById(R.id.B6_R_10_Layout);

        R6a.setOnItemSelectedListener(this);
        R9a.setOnItemSelectedListener(this);

        save=(Button)view.findViewById(R.id.blok6_save);
        cancel=(Button)view.findViewById(R.id.blok6_cancel);

        save.setOnClickListener(click);
        cancel.setOnClickListener(click);

        return view;
    }

    //method untuk mengisi isian spinner setiap rincian
    private void isiSpinner(){
        String[] listIsi;
        ArrayAdapter<String> adapterIsi;

        listIsi= new String[]{
                " ",
                "Milik sendiri",
                "Kontrak",
                "Sewa",
                "Bebas Sewa",
                "Dinas",
                "Rumah Milik Orang Tua/Sanak/Saudara",
                "Lainnya"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R1.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Beton",
                "Genteng",
                "Sirap",
                "Seng",
                "Asbes",
                "Ijuk/rumbia",
                "Lainnya"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R2.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Tembok",
                "Kayu",
                "Bambu",
                "Lainnya"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R3.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Bukan Tanah",
                "Tanah",};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R4.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Air Dalam Kemasan",
                "Leding",
                "Pompa",
                "Sumur Terlindung",
                "Sumur Tak Terlindung",
                "Mata Air Terlindung",
                "Mata Air Tak Terlindung",
                "Air Sungai",
                "Air Hujan",
                "Lainnya"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R6a.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "<=10",
                ">10",
                "Tidak Tahu"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R6b.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Sendiri",
                "Bersama",
                "Umum",
                "Tidak Ada"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R7.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Membeli",
                "Tidak Membeli"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R8.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Sendiri",
                "Bersama",
                "Umum",
                "Tidak Ada"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R9a.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Leher Angsa",
                "Plengsengan",
                "Cemplung/Cubluk",
                "Tidak Pakai"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R9b.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Tangki/SPAL",
                "Kolam/Sawah",
                "Sungai/Danau/Laut",
                "Lobang Tanah",
                "Pantai/Tanah Lapangan/Kebun",
                "Lainnya"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R9c.setAdapter(adapterIsi);

        listIsi= new String[]{
                " ",
                "Listrik PLN",
                "Listrik Non PLN",
                "Petromak/Aladin",
                "Pelita/Sentir/Obor",
                "Lainnya"};
        adapterIsi = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, listIsi);
        R10.setAdapter(adapterIsi);
    }


    //method untuk memberikan validasi ketika memilih spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        String pilihan;

        //BLOK 6 RINCIAN 6a
        if (parent.getId() == R.id.B6_R_6a_Spinner) {
            pilihan = R6a.getSelectedItem().toString();

            //Jika B6R6a dipilih air dalam kemasa atau leding eceran maka B6R8 dan B6R8 aktif
            if (pilihan.equals("Air Dalam Kemasan")) {
                R8l.setBackgroundColor(Color.parseColor("#a8cf45"));
                R8.setBackgroundColor(Color.parseColor("#ff94bc2c"));
                R8.setEnabled(true);
                R7l.setBackgroundColor(Color.parseColor("#a8cf45"));
                R7.setBackgroundColor(Color.parseColor("#ff94bc2c"));
                R7.setEnabled(true);
            } else {
                R8l.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                R8.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                R8.setEnabled(false);
                R7l.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                R7.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                R7.setEnabled(false);
            }

            //Jika B6R6a dipilih sumur atau mata air maka B6R6b aktif
            if (pilihan.equals("Pompa") | pilihan.equals("Sumur Terlindung") | pilihan.equals("Sumur Tak Terlindung") | pilihan.equals("Mata Air Terlindung") | pilihan.equals("Mata Air Tak Terlindung")) {
                R6bl.setBackgroundColor(Color.parseColor("#a8cf45"));
                R6b.setBackgroundColor(Color.parseColor("#ff94bc2c"));
                R6b.setEnabled(true);
            } else {
                R6bl.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                R6b.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                R6b.setEnabled(false);
            }
        }

        //BLOK 6 RINCIAN 9a
        if (parent.getId() == R.id.B6_R_9a_Spinner) {
                pilihan = R9a.getSelectedItem().toString();

                //Jika B6R9a dipilih tidak ada maka B6R9c aktif
                if (pilihan.equals("Tidak Ada")) {
                    R9cl.setBackgroundColor(Color.parseColor("#a8cf45"));
                    R9c.setBackgroundColor(Color.parseColor("#ff94bc2c"));
                    R9c.setEnabled(true);
                    R9bl.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                    R9b.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                    R9b.setEnabled(false);
                } else {
                    R9cl.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                    R9c.setBackgroundColor(Color.parseColor("#ffcf2c21"));
                    R9c.setEnabled(false);
                    R9bl.setBackgroundColor(Color.parseColor("#a8cf45"));
                    R9b.setBackgroundColor(Color.parseColor("#ff94bc2c"));
                    R9b.setEnabled(true);
                }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.blok6_save){
                boolean is6b;
                boolean is7;
                boolean is8;
                boolean is9c;
                boolean is9b;

                is6b=R6b.isEnabled();
                is7=R7.isEnabled();
                is8=R8.isEnabled();
                is9c=R9c.isEnabled();
                is9b=R9b.isEnabled();


                boolean isLengkap;
                isLengkap=  R1.getSelectedItemPosition()!=0&&
                            R2.getSelectedItemPosition()!=0&&
                            R3.getSelectedItemPosition()!=0&&
                            R4.getSelectedItemPosition()!=0&&
                            (!R5.getText().toString().equals(null)||!R5.getText().toString().equals(""))&&
                            R6a.getSelectedItemPosition()!=0&&
                            (is6b&&R6b.getSelectedItemPosition()!=0||!is6b)&&
                            (is7&&R7.getSelectedItemPosition()!=0||!is7)&&
                            (is8&&R8.getSelectedItemPosition()!=0||!is8)&&
                            R9a.getSelectedItemPosition()!=0&&
                            (is9b&&R9b.getSelectedItemPosition()!=0||!is9b)&&
                            (is9c&&R9c.getSelectedItemPosition()!=0||!is9c)&&
                            R10.getSelectedItemPosition()!=0;

                if(!isLengkap){
                    final AlertDialog peringatan = new AlertDialog.Builder(getActivity()).create();
                    peringatan.setMessage("Belum Lengkap \nLengkapi dahulu sebelum ke halaman selanjutnya");
                    peringatan.setButton("OK",new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            peringatan.cancel();
                        }
                    });
                    peringatan.show();
                }
                else {

                int[] bundle=new int[15];

                bundle[0]=127315;
                bundle[1]=127315;
                bundle[2]=R1.getSelectedItemPosition();
                bundle[3]=R2.getSelectedItemPosition();
                bundle[4]=R3.getSelectedItemPosition();
                bundle[5]=R4.getSelectedItemPosition();
                bundle[6]=Integer.parseInt(R5.getText().toString());
                bundle[7]=R6a.getSelectedItemPosition();
                bundle[8]=R6b.getSelectedItemPosition();
                bundle[9]=R7.getSelectedItemPosition();
                bundle[10]=R8.getSelectedItemPosition();
                bundle[11]=R9a.getSelectedItemPosition()-1;
                bundle[12]=R9b.getSelectedItemPosition();
                bundle[13]=R9c.getSelectedItemPosition();
                bundle[14]=R10.getSelectedItemPosition();

                controllerb6.masukkanDataToModel(bundle);
                controllerb6.masukkanDataToDB();

                Toast.makeText(getActivity(), "tersimpan di database", Toast.LENGTH_LONG).show();
                }

            }

            if(v.getId()==R.id.blok6_cancel){
                System.exit(0);
            }
        }
    };
}

