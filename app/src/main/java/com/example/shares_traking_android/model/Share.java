package com.example.shares_traking_android.model;

public class Share {

    public Share(int id, String symbol, String name, float price, float change, String persentChange, String volume, String marketCap, String ratio) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.change = change;
        this.persentChange = persentChange;
        this.volume = volume;
        this.marketCap = marketCap;
        this.ratio = ratio;
    }

    // FIELDS //

    private int id;
    private String symbol;
    private String name;
    private float price;
    private float change;
    private String persentChange;
    private String volume;
    private String marketCap;
    private String ratio;


    // GETTERS //


    public int getId() { return id; }

    public String getSymbol() { return symbol; }

    public String getName() { return name; }

    public float getPrice() { return price; }

    public float getChange() { return change; }

    public String getPersentChange() { return persentChange; }

    public String getVolume() { return volume; }

    public String getMarketCap() { return marketCap; }

    public String getRatio() { return ratio; }
}
