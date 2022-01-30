package com.network;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductInterface {

    @GET("android_product")
    Call<GetProduct> getAllProduct(
            @Query("key_query") String key_query
    );
}
