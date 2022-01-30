package com.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String url_website = "http://192.168.1.131:8080/master_zainsoft_ci_restapi/";
    private static Retrofit retrofit = null;

    static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(3, TimeUnit.MINUTES).readTimeout(3, TimeUnit.MINUTES).build();

    public static Retrofit getClient() {
        if (retrofit ==  null){
            retrofit =  new Retrofit.Builder().baseUrl(url_website).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
