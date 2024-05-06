package com.example.glamvaultcosmeticsshimmer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.glamvaultcosmeticsshimmer.model.ProductGla;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiCallBack;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiClient;
import com.example.glamvaultcosmeticsshimmer.view.adapter.PostAdapter;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    private PostAdapter adapter;
    private ArrayList<ProductGla> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        RecyclerView recyclerView = findViewById(R.id.rvPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter(products);
        recyclerView.setAdapter(adapter);

        ApiClient apiClient = new ApiClient();
        apiClient.getProducts(new ApiCallBack() {
            @Override
            public void onSuccess(ArrayList<ProductGla> productList) {
                products.clear();
                products.addAll(productList);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String message) {
                // Handle failure
            }
        });
    }
}
