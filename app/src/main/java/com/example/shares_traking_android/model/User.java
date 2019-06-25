package com.example.shares_traking_android.model;

import java.util.ArrayList;
import java.util.Arrays;

public class User {

    // FULL-STACK CONSTRUCTOR

    public User(String name, String email, String password, ArrayList<Share> sharesLibrary, ArrayList<Company> companiesLibrary, Settings currentSettings, int id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.sharesLibrary = sharesLibrary;
        this.companiesLibrary = companiesLibrary;
        this.currentSettings = currentSettings;
        this.id = id;
    }


    // CONSTRUCTOR WITHOUT LIBRARIES & CURRENT SETTINGS

    User(String name, String email, String password, int id){
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    // CONSTRUCTOR WITHOUT PASSWORD

    User(String name, String email, int id){
        this.name = name;
        this.email = email;
        this.id = id;
    }


    // FIELDS //

    private String name;
    private String email;
    private String password;
    private ArrayList<Share> sharesLibrary;
    private ArrayList<Company> companiesLibrary;
    private Settings currentSettings;
    private int id;

    // GETTERS //

    public String getName() { return name; }

    public String getPassword() { return password; }

    public ArrayList<Share> getSharesLibrary() { return sharesLibrary; }

    public ArrayList<Company> getCompaniesLibrary() { return companiesLibrary; }

    public Settings getCurrentSettings() { return currentSettings; }

    public String getEmail() { return email; }

    public int getId() { return id; }

    // SETTERS //

    public void setSharesLibrary(Share[] shares) {
        sharesLibrary.clear();
        sharesLibrary.addAll(Arrays.asList(shares));
    }
}
