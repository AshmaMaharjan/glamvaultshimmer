package com.example.glamvaultcosmeticsshimmer.utilities;

import com.example.glamvaultcosmeticsshimmer.model.LogUser;
import com.example.glamvaultcosmeticsshimmer.model.ProductGla;
import com.example.glamvaultcosmeticsshimmer.model.User;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    @POST("login.php")
    Call<Object> loginUser(@Body LogUser user);

    @POST("registerglam.php")
    Call<Object> registerUser(@Body User user);
    @GET("productGlam.php")
    Call<List<ProductGla>> getProducts();
}
