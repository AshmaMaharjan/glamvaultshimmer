package com.example.glamvaultcosmeticsshimmer.model;

import android.view.View;

import com.google.gson.annotations.SerializedName;

public class ProductGla {

    @SerializedName("name_glam")
        private String productName;

        @SerializedName("price_glam")
        private String productPrice;

        @SerializedName("image_glam")
        private String image;

        public ProductGla(String productName, String productPrice, String image) {
            this.productName = productName;
            this.productPrice = productPrice;
            this.image = image;
        }

    public ProductGla(View view) {
    }

    public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(String productPrice) {
            this.productPrice = productPrice;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
}
