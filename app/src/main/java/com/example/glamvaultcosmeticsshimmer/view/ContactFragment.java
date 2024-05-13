package com.example.glamvaultcosmeticsshimmer.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.glamvaultcosmeticsshimmer.R;
import com.example.glamvaultcosmeticsshimmer.model.Usercontact;
import com.example.glamvaultcosmeticsshimmer.utilities.ApiClient;


public class ContactFragment extends  Fragment {
    private EditText nameText;
    private EditText emailText;
    private EditText messageDescText;
    private Button sendButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        nameText = view.findViewById(R.id.name);
        emailText = view.findViewById(R.id.email1);
        messageDescText = view.findViewById(R.id.msg);
        sendButton = view.findViewById(R.id.Sendbtn);

        sendButton.setOnClickListener(v -> {
            String fullName = nameText.getText().toString();
            String email = emailText.getText().toString();
            String message = messageDescText.getText().toString();

            Log.d("ContactFragment", "Full Name: " + fullName);
            Log.d("ContactFragment", "Email: " + email);
            Log.d("ContactFragment", "Message: " + message);
            if (fullName.isEmpty() || email.isEmpty() || message.isEmpty()) {
                Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Usercontact contact = new Usercontact(fullName, email, message);
                Log.d("ContactFra", "Full Name: " + fullName);
                Log.d("ContactFragment", "Email: " + email);
                Log.d("ContactFragment", "Message: " + message);
                contactUser(contact);
            }
        });

        return view;
    }

    private void contactUser(Usercontact contact) {
        ApiClient.contactUser(contact,getContext());
    }


}