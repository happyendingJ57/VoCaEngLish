package com.example.vocaenglish.List.chitietchude;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDe {

    @SerializedName("tenChuDe")
    @Expose
    String tenChuDe;


    @SerializedName("soTu")
    @Expose
    String soTu;


    @SerializedName("imgChuDe")
    @Expose
    String imgChuDe;


    public ChuDe(String tenChuDe, String soTu, String imgChuDe) {
        this.tenChuDe = tenChuDe;
        this.soTu = soTu;
        this.imgChuDe = imgChuDe;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getSoTu() {
        return soTu;
    }

    public void setSoTu(String soTu) {
        this.soTu = soTu;
    }

    public String getImgChuDe() {
        return imgChuDe;
    }

    public void setImgChuDe(String imgChuDe) {
        this.imgChuDe = imgChuDe;
    }
}
