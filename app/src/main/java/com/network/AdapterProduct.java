package com.network;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import static com.network.R.layout.bottom_sheet_menu;
import static com.network.R.layout.test_reflow_chipgroup;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.MyViewHolder> {
    public static List<Product> mProductList;
    private Context ctx;
    public AdapterProduct(List<Product> productList, Context context) {
        this.mProductList = mProductList;
        this.ctx = context;
    }

    @NonNull
    @Override
    public AdapterProduct.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(mView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduct.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.id_name_product.setText(mProductList.get(position).getProduct_name());
        holder.id_stock.setText(mProductList.get(position).getProduct_stock());
        holder.id_unit_product.setText(mProductList.get(position).getUnit_product());
        String productID = mProductList.get(position).getProduct_id();
        System.out.println("Precio del producto: " + mProductList.get(position).getProduct_price());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBottonSheetBottom(view, position, productID, mProductList.get(position).getProduct_name(), mProductList.get(position).getProduct_price(), mProductList.get(position).getUnit_product());
            }
        });
    }

    private void openBottonSheetBottom(View view, int position, String productID, String productName, Double productPrice, String unitProduct) {
        Context context = view.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(bottom_sheet_menu, null);
        Button buttonEdit = v.findViewById(R.id.button_edit);
        Button buttonDelete = v.findViewById(R.id.button_delete);
        TextView title = v.findViewById(R.id.title);

        title.setText(productName);
        final Dialog mBottomSheetDialog = new Dialog(context, R.style.Theme_Design_BottomSheetDialog);
        mBottomSheetDialog.setContentView(v);
        mBottomSheetDialog.setCancelable(true);
        mBottomSheetDialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mBottomSheetDialog.getWindow().setGravity(Gravity.BOTTOM);
        mBottomSheetDialog.show();

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_edit = new Intent(ctx, AddProductActivity.class);
                AddProductActivity.add_or_edit = "edit";
                AddProductActivity.add_or_edit = productID;
                intent_edit.putExtra("product_name", productName);
                intent_edit.putExtra("product_price", productPrice);
                intent_edit.putExtra("unit_product", unitProduct);

                ctx.startActivity(intent_edit);
            }
        });
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
