package com.network;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_id")
    private  String product_id;

    @SerializedName("product_name")
    private  String product_name;

    @SerializedName("product_price")
    private  Double product_price;

    @SerializedName("product_stock")
    private  Integer product_stock;

    @SerializedName("unit_product")
    private  String unit_product;

    @SerializedName("date_created")
    private  String date_created;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }

    public Integer getProduct_stock() {
        return product_stock;
    }

    public void setProduct_stock(Integer product_stock) {
        this.product_stock = product_stock;
    }

    public String getUnit_product() {
        return unit_product;
    }

    public void setUnit_product(String unit_product) {
        this.unit_product = unit_product;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }
}
