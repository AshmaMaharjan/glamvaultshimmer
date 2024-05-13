package com.example.glamvaultcosmeticsshimmer.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glamvaultcosmeticsshimmer.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView textViewName;
   public TextView textViewPrice;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
    }
}
