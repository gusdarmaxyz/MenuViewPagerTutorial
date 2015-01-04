package com.androidbegin.menuviewpagertutorial;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragment;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link blok7.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link blok7#newInstance} factory method to
 * create an instance of this fragment.
 */
public class blok7 extends SherlockFragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RadioGroup b7r1,b7r2a,b7r2b,b7r3a,b7r4a,b7r4b;
    private RadioButton b7r2b1,b7r2b2,b7r2b3,b7r2b4,b7r4b1,b7r4b2,b7r4b3,b7r4b4,b7r4b5,b7r4b6,b7r4b7;
    private EditText b7r3b,b7r3c;
    private Button b7Save,b7Cancel;

    private LinearLayout b7r2bLayout,b7r3bLayout,b7r3cLayout,b7r4bLayout,sep1,sep2,sep3,sep4;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Blok7Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static blok7 newInstance(String param1, String param2) {
        blok7 fragment = new blok7();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public blok7() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blok7, container, false);

        b7r2bLayout = (LinearLayout)rootView.findViewById(R.id.R_2_b_Layout);
        b7r3bLayout = (LinearLayout)rootView.findViewById(R.id.R_3_b_layout);
        b7r3cLayout = (LinearLayout)rootView.findViewById(R.id.R_3_c_layout);
        b7r4bLayout = (LinearLayout)rootView.findViewById(R.id.R_4_b_layout);
        sep1 = (LinearLayout)rootView.findViewById(R.id.sep_1);
        sep2 = (LinearLayout)rootView.findViewById(R.id.sep_2);
        sep3 = (LinearLayout)rootView.findViewById(R.id.sep_3);
        sep4 = (LinearLayout)rootView.findViewById(R.id.sep_4);

        b7r2b1 = (RadioButton)rootView.findViewById(R.id.R_2_b_1);
        b7r2b2 = (RadioButton)rootView.findViewById(R.id.R_2_b_2);
        b7r2b3 = (RadioButton)rootView.findViewById(R.id.R_2_b_3);
        b7r2b4 = (RadioButton)rootView.findViewById(R.id.R_2_b_4);
        b7r4b1 = (RadioButton)rootView.findViewById(R.id.R_4_b_1);
        b7r4b2 = (RadioButton)rootView.findViewById(R.id.R_4_b_2);
        b7r4b3 = (RadioButton)rootView.findViewById(R.id.R_4_b_3);
        b7r4b4 = (RadioButton)rootView.findViewById(R.id.R_4_b_4);
        b7r4b5 = (RadioButton)rootView.findViewById(R.id.R_4_b_5);
        b7r4b6 = (RadioButton)rootView.findViewById(R.id.R_4_b_6);
        b7r4b7 = (RadioButton)rootView.findViewById(R.id.R_4_b_7);

        b7r3b = (EditText)rootView.findViewById(R.id.R_3_b_field);
        b7r3c = (EditText)rootView.findViewById(R.id.R_3_c_field);

        b7r1 = (RadioGroup)rootView.findViewById(R.id.RadioGroup1);
        b7r2a = (RadioGroup)rootView.findViewById(R.id.RadioGroup2a);
        b7r2a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.R_2_a_ya){
                    b7r2bLayout.setVisibility(View.VISIBLE);
                    sep1.setVisibility(View.VISIBLE);
                    b7r2b1.setEnabled(true);
                    b7r2b2.setEnabled(true);
                    b7r2b3.setEnabled(true);
                    b7r2b4.setEnabled(true);
                }else if(checkedId == R.id.R_2_a_Tidak){
                    b7r2bLayout.setVisibility(View.GONE);
                    sep1.setVisibility(View.GONE);
                    b7r2b1.setEnabled(false);
                    b7r2b2.setEnabled(false);
                    b7r2b3.setEnabled(false);
                    b7r2b4.setEnabled(false);
                }
            }
        });
        b7r2b = (RadioGroup)rootView.findViewById(R.id.RadioGroup2b);
        b7r3a = (RadioGroup)rootView.findViewById(R.id.RadioGroup3a);
        b7r3a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.R_3_a_ya){
                    b7r3bLayout.setVisibility(View.VISIBLE);
                    sep2.setVisibility(View.VISIBLE);
                    b7r3b.setEnabled(true);
                    b7r3cLayout.setVisibility(View.VISIBLE);
                    sep3.setVisibility(View.VISIBLE);
                    b7r3c.setEnabled(true);
                }else{
                    b7r3bLayout.setVisibility(View.GONE);
                    sep2.setVisibility(View.GONE);
                    b7r3b.setEnabled(false);
                    b7r3cLayout.setVisibility(View.GONE);
                    sep3.setVisibility(View.GONE);
                    b7r3c.setEnabled(false);
                }
            }
        });
        b7r4a = (RadioGroup)rootView.findViewById(R.id.RadioGroup4a);
        b7r4a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.R_4_a_ya){
                    b7r4bLayout.setVisibility(View.VISIBLE);
                    sep4.setVisibility(View.VISIBLE);
                    b7r4b.setEnabled(true);
                    b7r4b1.setEnabled(true);
                    b7r4b2.setEnabled(true);
                    b7r4b3.setEnabled(true);
                    b7r4b4.setEnabled(true);
                    b7r4b5.setEnabled(true);
                    b7r4b6.setEnabled(true);
                    b7r4b7.setEnabled(true);
                }else{
                    b7r4bLayout.setVisibility(View.GONE);
                    sep4.setVisibility(View.GONE);
                    b7r4b1.setEnabled(false);
                    b7r4b2.setEnabled(false);
                    b7r4b3.setEnabled(false);
                    b7r4b4.setEnabled(false);
                    b7r4b5.setEnabled(false);
                    b7r4b6.setEnabled(false);
                    b7r4b7.setEnabled(false);
                }
            }
        });
        b7r4b = (RadioGroup)rootView.findViewById(R.id.RadioGroup4b);

        b7Save = (Button)rootView.findViewById(R.id.blok7_save);
        b7Save.setOnClickListener(this);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        boolean valid = true;
        String b7r1v,b7r2av,b7r2bv = "",b7r3av,b7r3bv = "",b7r3cv = "",b7r4av,b7r4bv = "";
        if(v.getId() == R.id.blok7_save){
            if(b7r1.getCheckedRadioButtonId() == R.id.R_1_a_ya){
                b7r1v = "1";
            }else{
                b7r1v = "2";
            }

            if(b7r2a.getCheckedRadioButtonId() == R.id.R_2_a_ya){
                b7r2av = "1";
                if(b7r2b.getCheckedRadioButtonId() == R.id.R_2_b_1){
                    b7r2bv = "1";
                }else if(b7r2b.getCheckedRadioButtonId() == R.id.R_2_b_2){
                    b7r2bv = "2";
                }else if(b7r2b.getCheckedRadioButtonId() == R.id.R_2_b_3){
                    b7r2bv = "3";
                }else if(b7r2b.getCheckedRadioButtonId() == R.id.R_2_b_4){
                    b7r2bv = "4";
                }
            }else{
                b7r2av = "2";
                b7r2bv = "";
            }

            if(b7r3a.getCheckedRadioButtonId() == R.id.R_3_a_ya){
                b7r3av = "1";
                if(b7r3b.getText().toString().length()>0){
                    b7r3bv = b7r3b.getText().toString();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Jawaban 3B kosong",Toast.LENGTH_SHORT).show();
                    valid = false;
                }
                if(b7r3c.getText().toString().length()>0){
                    b7r3cv = b7r3c.getText().toString();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(),"Jawaban 3C kosong",Toast.LENGTH_SHORT).show();
                    valid = false;
                }
            }else{
                b7r3av = "2";
                b7r3bv = "";
                b7r3cv = "";
            }

            if(b7r4a.getCheckedRadioButtonId() == R.id.R_4_a_ya){
                b7r4av = "1";
                if(b7r4b.getCheckedRadioButtonId() == R.id.R_4_b_1){
                    b7r4bv = "1";
                }else if(b7r4b.getCheckedRadioButtonId() == R.id.R_4_b_2){
                    b7r4bv = "2";
                }else if(b7r4b.getCheckedRadioButtonId() == R.id.R_4_b_3){
                    b7r4bv = "3";
                }else if(b7r4b.getCheckedRadioButtonId() == R.id.R_4_b_4){
                    b7r4bv = "4";
                }else if(b7r4b.getCheckedRadioButtonId() == R.id.R_4_b_5){
                    b7r4bv = "5";
                }else if(b7r4b.getCheckedRadioButtonId() == R.id.R_4_b_6){
                    b7r4bv = "6";
                }else if(b7r4b.getCheckedRadioButtonId() == R.id.R_4_b_7){
                    b7r4bv = "7";
                }
            }else{
                b7r4av = "2";
            }
            if(valid){
                ((Blok7)getActivity()).goToSummaryFragment();
                ((Blok7)getActivity()).controller.enterModel(b7r1v,b7r2av,b7r2bv,b7r3av,b7r3bv,b7r3cv,b7r4av,b7r4bv);
            }
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
