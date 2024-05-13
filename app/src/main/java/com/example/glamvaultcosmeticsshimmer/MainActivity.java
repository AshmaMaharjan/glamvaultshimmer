package com.example.glamvaultcosmeticsshimmer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.glamvaultcosmeticsshimmer.model.ProductGla;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiCallBack;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiClient;
import com.example.glamvaultcosmeticsshimmer.view.AboutUsFragment;
import com.example.glamvaultcosmeticsshimmer.view.ContactFragment;
import com.example.glamvaultcosmeticsshimmer.view.HomeFragment;
import com.example.glamvaultcosmeticsshimmer.view.MakeupFragment;
import com.example.glamvaultcosmeticsshimmer.view.ProfileFragment;
import com.example.glamvaultcosmeticsshimmer.view.adapter.PostAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.FirebaseApp;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
        ProfileFragment profileFragment = new ProfileFragment();
    MakeupFragment productFragment = new MakeupFragment();
    AboutUsFragment aboutusFragment = new AboutUsFragment();
    ContactFragment contactFragment = new ContactFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_home_screen);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
//
        }else if(item.getItemId() == R.id.profile){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
            return true;
        }else if(item.getItemId() == R.id.product){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, productFragment).commit();
            return true;
      }else if(item.getItemId() == R.id.aboutus){
          getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutusFragment).commit();
        return true;
        }else if(item.getItemId() == R.id.contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, contactFragment).commit();
            return true;
        } else {
            return false;
        }
    }
}