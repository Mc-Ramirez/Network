package com.network;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.MyViewHolder> {
    public static List<Product> mProductList;
    private Context context;
    public AdapterProduct(List<Product> productList, Context context) {
        this.mProductList = mProductList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterProduct.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduct.MyViewHolder holder, int position) {
        holder.id_name_product.setText(mProductList.get(position).getProduct_name());
        holder.id_stock.setText(mProductList.get(position).getProduct_stock());
        holder.id_unit_product.setText(mProductList.get(position).getUnit_product());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id_name_product, id_stock, id_unit_product;
        public MyViewHolder(View itemView){
            super(itemView);
            id_name_product = itemView.findViewById(R.id.id_name_product);
            id_stock = itemView.findViewById(R.id.id_stock);
            id_unit_product = itemView.findViewById(R.id.id_unit_product);
        }

    }
}
