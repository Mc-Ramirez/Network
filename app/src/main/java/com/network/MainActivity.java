package com.network;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ProductInterface mProductInterface;
    EditText filterProduct;
    FloatingActionButton addProduct;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_layout);
        recyclerView = findViewById(R.id.rv_product);
        filterProduct = findViewById(R.id.filter_product);
        addProduct = findViewById(R.id.add_product);

        mLayoutManager =  new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        getAllProduct();
        addProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddProductActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getAllProduct() {
        mProductInterface = ApiClient.getClient().create(ProductInterface.class);
        Call<GetProduct> productCall = mProductInterface.getAllProduct("all");
        productCall.enqueue(new Callback<GetProduct>() {
            @Override
            public void onResponse(Call<GetProduct> call, Response<GetProduct> response) {
                List<Product> productList = response.body().getListDataProduct();
                mAdapter = new AdapterProduct(productList, MainActivity.this);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetProduct> call, Throwable t) {
                System.out.println("Error get Data");
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
