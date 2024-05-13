package com.example.glamvaultcosmeticsshimmer.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.glamvaultcosmeticsshimmer.R;
import com.example.glamvaultcosmeticsshimmer.model.ProductGla;
import com.example.glamvaultcosmeticsshimmer.view.ProductViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private ArrayList<ProductGla> products;

    public PostAdapter(ArrayList<ProductGla> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_makeup, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        ProductGla product = products.get(position);
        holder.textViewName.setText(product.getProductName());
        holder.textViewPrice.setText(product.getProductPrice());

        int placeholderResource = R.drawable.bg;
        int errorResource = R.drawable.lo;

        Picasso.get()
                .load(product.getImage())
                .placeholder(placeholderResource)
                .error(errorResource)
                .into(holder.imageView);
    }





    @Override
    public int getItemCount() {
        return products.size();
    }

    // ViewHolder class

}
