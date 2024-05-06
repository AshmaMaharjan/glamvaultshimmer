package com.example.glamvaultcosmeticsshimmer.utilities;

import com.example.glamvaultcosmeticsshimmer.model.ProductGla;

import java.util.ArrayList;

public interface ApiCallBack {
    void onSuccess(ArrayList<ProductGla> productList);
    void onFailure(String message);
}
