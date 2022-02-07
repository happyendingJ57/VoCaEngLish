package com.example.vocaenglish.luyentap;

public class V_TuVung {

    String tuVung;
    String phienAm;
    String dichNghia;
    String img;
    String vidu;
    String phatAm;

    public V_TuVung(String tuVung, String phienAm, String dichNghia, String img, String vidu, String phatAm) {
        this.tuVung = tuVung;
        this.phienAm = phienAm;
        this.dichNghia = dichNghia;
        this.img = img;
        this.vidu = vidu;
        this.phatAm = phatAm;
    }

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

    public String getVidu() {
        return vidu;
    }

    public void setVidu(String vidu) {
        this.vidu = vidu;
    }

    public String getPhatAm() {
        return phatAm;
    }

    public void setPhatAm(String phatAm) {
        this.phatAm = phatAm;
    }
}
