package com.example.glamvaultcosmeticsshimmer.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glamvaultcosmeticsshimmer.ProductGlam;
import com.example.glamvaultcosmeticsshimmer.R;
import com.example.glamvaultcosmeticsshimmer.model.ProductGla;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<ProductGlam> {
    private ArrayList<ProductGla> products;

    public PostAdapter(ArrayList<ProductGla> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductGlam onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder, parent, false);
        return new ProductGlam(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ProductGlam holder, int position) {
        ProductGla product = products.get(position);
        holder.textViewName.setText(product.getProductName());
        holder.textViewPrice.setText(product.getProductPrice());

        int placeholderResource = R.drawable.bg;
        int errorResource = R.drawable.lo;

        Picasso.get()
                .load(product.getImage())
                .placeholder(placeholderResource)
                .error(errorResource)
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    // ViewHolder class
    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
