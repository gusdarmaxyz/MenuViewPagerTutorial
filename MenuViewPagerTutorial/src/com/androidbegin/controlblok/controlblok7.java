package com.androidbegin.controlblok;

import capi54.subseksi.pkl54blok7.model.Blok7Model;

/**
 * Created by EKI on 01/01/2015.
 */
public class controlblok7 {

    objekblok7 model = new objekblok7();

    public void enterModel(String value1,String value2,String value3,String value4,String value5,String value6,String value7,String value8){
        model.setB7r1(value1);
        model.setB7r2a(value2);
        model.setB7r2b(value3);
        model.setB7r3a(value4);
        model.setB7r3b(value5);
        model.setB7r3c(value6);
        model.setB7r4a(value7);
        model.setB7r4b(value8);
    }

    public String getB7r1(){
        if(model.getB7r1().equals("1")){
            return "Ya";
        }else{
            return "Tidak";
        }
    }

    public String getB7r2a(){
        if(model.getB7r2a().equals("1")){
            return "Ya";
        }else{
            return "Tidak";
        }
    }

    public String getB7r2b(){
        if(model.getB7r2b().equals("1")){
            return "Askeskin";
        }else if(model.getB7r2b().equals("2")){
            return "KKB";
        }else if(model.getB7r2b().equals("3")){
            return "Kartu Sehat";
        }else if(model.getB7r2b().equals("4")){
            return "Lainnya";
        }else
            return "";
    }

    public String getB7r3a(){
        if(model.getB7r3a().equals("1")){
            return "Ya";
        }else{
            return "Tidak";
        }
    }

    public String getB7r3b(){
        return model.getB7r3b();
    }

    public String getB7r3c(){
        return model.getB7r3c();
    }

    public String getB7r4a(){
        if(model.getB7r4a().equals("1")){
            return "Ya";
        }else{
            return "Tidak";
        }
    }

    public String getB7r4b(){
        if(model.getB7r4b().equals("1")){
            return "Program Pembangunan Kecamatan";
        }else if(model.getB7r4b().equals("2")){
            return "Program P2KP";
        }else if(model.getB7r4b().equals("3")) {
            return "Program Pemerintah Lainnya";
        }else if(model.getB7r4b().equals("4")) {
            return "Program Bank";
        }else if(model.getB7r4b().equals("5")) {
            return "Program Koperasi/Yayasan";
        }else if(model.getB7r4b().equals("6")) {
            return "Perorangan";
        }else if(model.getB7r4b().equals("7")) {
            return "Lainnya";
        }else
            return "";
    }

}
