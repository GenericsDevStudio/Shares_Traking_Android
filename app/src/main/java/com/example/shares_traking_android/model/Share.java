package com.example.shares_traking_android.model;

public class Share {

    Share(String company, double price, double lastPrice){
        this.company = company;
        this.price = price;
        this.lastPrice = lastPrice;
    }


    // FIELDS //

    private String company;
    private double price;
    private double lastPrice;


    // GETTERS //


    public double getLastPrice() { return lastPrice; }

    public double getPrice() { return price; }

    public String getCompany() { return company; }

}
