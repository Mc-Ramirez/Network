package com.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetProduct {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Product> listDataProduct;
    @SerializedName("filter")
    List<Product> filterListProduct;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getListDataProduct() {
        return listDataProduct;
    }

    public void setListDataProduct(List<Product> listDataProduct) {
        this.listDataProduct = listDataProduct;
    }

    public List<Product> getFilterListProduct() {
        return filterListProduct;
    }

    public void setFilterListProduct(List<Product> filterListProduct) {
        this.filterListProduct = filterListProduct;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
