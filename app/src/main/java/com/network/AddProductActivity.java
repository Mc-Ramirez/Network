package com.network;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductActivity extends AppCompatActivity {
    TextInputEditText productName, productPrice, unitProduct;
    Button buttonSave;
    ProductInterface productInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
        unitProduct = findViewById(R.id.unit_product);
        buttonSave = findViewById(R.id.button_save);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveProduct();
            }
        });
    }

    private void saveProduct() {
        productInterface = ApiClient.getClient().create(ProductInterface.class);
        Call<PostPutDelProduct> postPutDelProductCall = productInterface.postProduct(
                productName.getText().toString(),
                Integer.parseInt(productPrice.getText().toString()),
                unitProduct.getText().toString()
        );
        postPutDelProductCall.enqueue(new Callback<PostPutDelProduct>() {
            @Override
            public void onResponse(Call<PostPutDelProduct> call, Response<PostPutDelProduct> response) {
                Toast.makeText(AddProductActivity.this, "Dato guardado correctamente", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }

            @Override
            public void onFailure(Call<PostPutDelProduct> call, Throwable t) {
                Toast.makeText(AddProductActivity.this, "Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}