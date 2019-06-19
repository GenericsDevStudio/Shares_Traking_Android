package com.example.shares_traking_android.model;

import android.widget.ImageView;

public class Company {

    Company(String name, String description, int rating, ImageView logo){
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.logo = logo;
    }


    // FIELDS //

    private String name;
    private String description;
    private int rating;
    private ImageView logo;


    // GETTERS //


    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getRating() { return rating; }

    public ImageView getLogo() { return logo; }

}
