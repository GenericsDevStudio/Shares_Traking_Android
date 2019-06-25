package com.example.shares_traking_android.model;

import java.util.ArrayList;

public class User {

    // FULL-STACK CONSTRUCTOR

    User(String name, String email, String password, ArrayList<Share> library, Settings currentSettings, int id){
        this.name = name;
        this.email = email;
        this.password = password;
        this.library = library;
        this.currentSettings = currentSettings;
        this.id = id;
    }

    // CONSTRUCTOR WITHOUT LIBRARY & CURRENT SETTINGS

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
    private ArrayList<Share> library;
    private Settings currentSettings;
    private int id;

    // GETTERS //

    public String getName() { return name; }

    public String getPassword() { return password; }

    public ArrayList<Share> getLibrary() { return library; }

    public Settings getCurrentSettings() { return currentSettings; }

    public String getEmail() { return email; }

    public int getId() { return id; }
}
