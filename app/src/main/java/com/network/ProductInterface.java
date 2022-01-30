package com.network;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProductInterface {

    @GET("android_product")
    Call<GetProduct> getAllProduct(
            @Query("key_query") String key_query
    );

    @FormUrlEncoded
    @POST("android_product")
    Call<PostPutDelProduct> postProduct(
            @Field("product_name") String product_name,
            @Field("product_price") Integer product_price,
            @Field("unit_product") String unit_name
    );
}
