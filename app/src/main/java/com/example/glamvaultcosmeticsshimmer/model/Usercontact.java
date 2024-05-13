package com.example.glamvaultcosmeticsshimmer.model;

import com.google.gson.annotations.SerializedName;

public class Usercontact {
    @SerializedName("Fullname")
    private String Fullname;

    @SerializedName("Email")
    private String Email;

    @SerializedName("Description")
    private String Description;

    public Usercontact(String fullname, String email, String description) {
        Fullname = fullname;
        Email = email;
        Description = description;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
