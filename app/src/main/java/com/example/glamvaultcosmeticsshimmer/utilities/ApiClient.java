package com.example.glamvaultcosmeticsshimmer.utilities;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.example.glamvaultcosmeticsshimmer.model.LogUser;
import com.example.glamvaultcosmeticsshimmer.model.ProductGla;
import com.example.glamvaultcosmeticsshimmer.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

//    private static final String BASE_URL = "http://192.168.137.210/api/";


   private static final String BASE_URL = "http://10.0.2.2/glamvault/";

    private static Retrofit retrofit;

    // Create the Retrofit instance
    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // Create ApiService instance
    public static ApiService createApiService() {
        return retrofit.create(ApiService.class);
    }

    // Method to register a user
    public static void registerUser(User user, Context context) {
        // Get the ApiService instance
        ApiService apiService = createApiService();

        // Call the registerUser method in ApiService and pass the user object
        apiService.registerUser(user).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    // Registration successful
                    Log.d("ApiClient", "User registration successful");
                    Toast.makeText(context, "User registered successfully", Toast.LENGTH_SHORT).show();
                    // Optionally, you can navigate to another activity upon successful registration
                    // startActivity(new Intent(context, MainActivity.class));
                } else {
                    // Registration failed
                    Log.d("ApiClient", "Failed to register user. Response code: " + response.code());
                    Toast.makeText(context, "Failed to register user. Please try again later.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Registration failed due to network error or other issues
                Log.e("ApiClient", "Registration failed: " + t.getMessage());
                String errorMessage;
                if (t instanceof IOException) {
                    errorMessage = "Network error. Please check your internet connection.";
                } else {
                    errorMessage = "Failed to register user. Error: " + t.getMessage();
                }
                // Display error message to the user
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void loginUser(String username, String password, Context context) {
        // Get the ApiService instance
        ApiService apiService = createApiService();

        // Call the loginUser method in ApiService and pass the username and password as query parameters

        LogUser user = new LogUser(username, password);
        apiService.loginUser(user).enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.code());
                    // Show a successful login message
                    Toast.makeText(context, "User logged in successfully", Toast.LENGTH_SHORT).show();
                    Log.d("ApiClient", "User login successful");
                } else {
                    // Show an error message based on the response code
                    if (response.code() == 401) { // Unauthorized - Incorrect username or password
                        Toast.makeText(context, "Incorrect username or password. Please try again.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(context, "Failed to login user. Please try again later.", Toast.LENGTH_SHORT).show();
                    }
                    Log.d("ApiClient", "Failed to login user. Response code: " + response.code());
                }
            }


            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                // Login failed due to network error or other issues
                String errorMessage;
                if (t instanceof IOException) {
                    errorMessage = "Network error. Please check your internet connection.";
                } else {
                    errorMessage = "Failed to login user. Error: " + t.getMessage();
                }
                // Display error message to the user
                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
                Log.e("ApiClient", "Login failed: " + errorMessage);
            }
        });
    }
    public void getProducts(ApiCallBack callback) {
        Call<List<ProductGla>> call = createApiService().getProducts();
        call.enqueue(new Callback<List<ProductGla>>() {
            @Override
            public void onResponse(Call<List<ProductGla>> call, Response<List<ProductGla>> response) {
                if (response.isSuccessful()) {
                    List<ProductGla> productList = response.body();
                    if (productList != null) {
                        for (ProductGla product : productList) {
                            Log.d("Product", "Name: " + product.getProductName() + ", Price: " + product.getProductPrice() + ", Image: " + product.getImage());
                        }
                        callback.onSuccess(new ArrayList<>(productList));
                    } else {
                        Log.e("Product", "Response body is null");
                        callback.onFailure("Failed to get products. Response body is null.");
                    }
                } else {
                    Log.e("Product", "Failed to get products. Response code: " + response.code());
                    callback.onFailure("Failed to get products. Response code: " + response.code());
                }
            }


            @Override
            public void onFailure(Call<List<ProductGla>> call, Throwable t) {
                callback.onFailure("Failed to get products: " + t.getMessage());
            }
        });
    }
}

