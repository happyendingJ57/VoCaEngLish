package com.example.vocaenglish;

import com.example.vocaenglish.List.chitietchude.ChuDe;
import com.example.vocaenglish.List.chitiettuvung.TuVung;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClient_lpm {

    @GET("chuDe")
    Call<List<ChuDe>> onGetContact();

    @GET("Unit01")
    Call<List<TuVung>> onGetContactUnit1();

}
