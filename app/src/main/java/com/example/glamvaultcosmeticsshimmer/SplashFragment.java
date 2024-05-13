package com.example.glamvaultcosmeticsshimmer;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.glamvaultcosmeticsshimmer.view.LoginFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SplashFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SplashFragment extends AppCompatActivity {

    private static final int SPLASH_TIMEOUT = 500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_splash);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashFragment.this, LoginFragment.class);
                startActivity(intent);


                finish();
            }
        }, SPLASH_TIMEOUT);
    }
}