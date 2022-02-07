package com.example.vocaenglish;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static final String BASE_URL = "https://demo7176889.mockable.io/";

    public static Retrofit retrofit = null;

    public static APIClient_lpm create() {
        return getClient(BASE_URL).create(APIClient_lpm.class);
    }

    public static Retrofit getClient(String url) {
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit ;
    }
}


