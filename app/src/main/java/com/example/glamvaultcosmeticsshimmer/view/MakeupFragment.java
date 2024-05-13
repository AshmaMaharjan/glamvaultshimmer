package com.example.glamvaultcosmeticsshimmer.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.glamvaultcosmeticsshimmer.R;
import com.example.glamvaultcosmeticsshimmer.model.ProductGla;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiCallBack;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiClient;
import com.example.glamvaultcosmeticsshimmer.view.adapter.PostAdapter;

import java.util.ArrayList;


public class MakeupFragment extends Fragment {

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private ArrayList<ProductGla> products = new ArrayList<>();

    public MakeupFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_activity, container, false);
        recyclerView = view.findViewById(R.id.rvPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        adapter = new PostAdapter(products);
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
        return view;
    }

}