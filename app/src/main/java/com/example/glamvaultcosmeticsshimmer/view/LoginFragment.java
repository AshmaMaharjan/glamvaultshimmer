package com.example.glamvaultcosmeticsshimmer.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.glamvaultcosmeticsshimmer.R;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiClient;

public class LoginFragment extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        usernameEditText = findViewById(R.id.loginemail);
        passwordEditText = findViewById(R.id.loginpassword);
        loginButton = findViewById(R.id.loginbutton);
        TextView signupText = findViewById(R.id.signup);
        signupText.setOnClickListener(v -> {
            Intent intent = new Intent(LoginFragment.this, RegisterFragment.class);
            startActivity(intent);
            finish(); // Optional, to close the current activity
        });
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            Log.d("LoginPage", "Username: " + username);
            Log.d("LoginPage", "Password: " + password);

            // Validate input fields
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginFragment.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            } else {
                // Call loginUser method with username, password, and context
                ApiClient.loginUser(username, password, LoginFragment.this);
            }
        });

    }

//    private void loginUser(loginUser user) {
//        ApiClient.loginUser( this);
//    }

}