package com.example.glamvaultcosmeticsshimmer.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;



import com.example.glamvaultcosmeticsshimmer.R;
import com.example.glamvaultcosmeticsshimmer.model.User;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiClient;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class RegisterFragment extends AppCompatActivity {
    private EditText fullNameEditText;
    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register);

        fullNameEditText = findViewById(R.id.signup_fullanme);
        usernameEditText = findViewById(R.id.signup_username);
        emailEditText = findViewById(R.id.signup_email);
        passwordEditText = findViewById(R.id.signup_confirm);
        registerButton = findViewById(R.id.signup_button);

        registerButton.setOnClickListener(v -> {
            String fullName = fullNameEditText.getText().toString();
            String username = usernameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Inside registerButton.setOnClickListener
            Log.d("RegisterPage", "Full Name: " + fullName);
            Log.d("RegisterPage", "Username: " + username);
            Log.d("RegisterPage", "Email: " + email);
            Log.d("RegisterPage", "Password: " + password);

            if (fullName.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(RegisterFragment.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else if (!isFullnameValid(fullName)) {
                Toast.makeText(RegisterFragment.this, "Full Name cannot contain symbols", Toast.LENGTH_SHORT).show();
            } else if (!isUsernameValid(username)) {
                Toast.makeText(RegisterFragment.this, "Username cannot contain symbols", Toast.LENGTH_SHORT).show();
            }   else {
                User user = new User(fullName, username, email, password);
                System.out.println(user.getFullName());
                registerUser(user);
            }
        });
    }
    private boolean isFullnameValid(String fullName) {
        // Regular expression to check if full name contains only letters, spaces, and hyphens
        String regex = "^[a-zA-Z\\s-]*$";
        return fullName.matches(regex);
    }

    private boolean isUsernameValid(String username) {
        // Regular expression to check if username contains only letters, digits, and underscores
        String regex = "^[a-zA-Z0-9_]*$";
        return username.matches(regex);
    }
    private void registerUser(User user) {
        ApiClient.registerUser(user, this);
    }
}