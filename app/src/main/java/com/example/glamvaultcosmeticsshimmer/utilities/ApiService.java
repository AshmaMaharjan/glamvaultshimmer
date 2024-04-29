package com.example.glamvaultcosmeticsshimmer.utilities;

import com.example.glamvaultcosmeticsshimmer.model.LogUser;
import com.example.glamvaultcosmeticsshimmer.model.User;


import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.POST;

public interface ApiService {
    @POST("user_login.php")
    Call<Object> loginUser(LogUser user);

    @POST("register.php")
    Call<Object> registerUser(@Body User user);

}
