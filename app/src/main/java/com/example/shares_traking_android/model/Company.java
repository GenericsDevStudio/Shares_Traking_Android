package com.example.shares_traking_android.model;

import android.widget.ImageView;

public class Company {

    public Company(int id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    // FIELDS //

    private int id;
    private String name;
    private String symbol;
    private ImageView logo;


    // GETTERS //


    public int getId() { return id; }

    public String getName() { return name; }

    public String getSymbol() { return symbol; }

    public ImageView getLogo() { return logo; }
}
