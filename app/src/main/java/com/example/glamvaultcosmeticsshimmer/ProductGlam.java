package com.example.glamvaultcosmeticsshimmer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glamvaultcosmeticsshimmer.R;

public class ProductGlam extends RecyclerView.ViewHolder {
    public TextView textViewName;
    public TextView textViewPrice;

    public ImageView imgView;

    public ProductGlam(@NonNull View itemView) {
        super(itemView);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewPrice = itemView.findViewById(R.id.textViewPrice);
        imgView = itemView.findViewById(R.id.imageView);
    }
}
