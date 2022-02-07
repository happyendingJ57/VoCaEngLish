package com.example.vocaenglish.luyentap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TuVung_LuyenTap {

    String tuVung;
    String phienAm;
    String dichNghia;
    String img;
    String example;
    String phatAm;

    public String getTuVung() {
        return tuVung;
    }

    public void setTuVung(String tuVung) {
        this.tuVung = tuVung;
    }

    public String getPhienAm() {
        return phienAm;
    }

    public void setPhienAm(String phienAm) {
        this.phienAm = phienAm;
    }

    public String getDichNghia() {
        return dichNghia;
    }

    public void setDichNghia(String dichNghia) {
        this.dichNghia = dichNghia;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getPhatAm() {
        return phatAm;
    }

    public void setPhatAm(String phatAm) {
        this.phatAm = phatAm;
    }

    public TuVung_LuyenTap(String tuVung, String phienAm, String dichNghia, String img, String example, String phatAm) {
        this.tuVung = tuVung;
        this.phienAm = phienAm;
        this.dichNghia = dichNghia;
        this.img = img;
        this.example = example;
        this.phatAm = phatAm;
    }
}
