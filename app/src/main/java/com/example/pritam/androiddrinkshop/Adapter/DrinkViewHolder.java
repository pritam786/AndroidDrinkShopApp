package com.example.pritam.androiddrinkshop.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pritam.androiddrinkshop.Interface.ItemClickListener;
import com.example.pritam.androiddrinkshop.R;

public class DrinkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img_product;
    TextView txt_drink_name, txt_price;

    ItemClickListener itemClickListener;

    ImageView btn_add_to_cart, btn_favourite;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DrinkViewHolder(@NonNull View itemView) {
        super(itemView);

        img_product = (ImageView) itemView.findViewById(R.id.image_product);
        txt_drink_name = (TextView) itemView.findViewById(R.id.txt_drink_name);
        txt_price = (TextView) itemView.findViewById(R.id.txt_price);
        btn_add_to_cart = (ImageView) itemView.findViewById(R.id.btn_add_cart);
        btn_favourite = (ImageView) itemView.findViewById(R.id.btn_favourite);

        itemView.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v);

    }
}
