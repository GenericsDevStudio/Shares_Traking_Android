package com.example.shares_traking_android.model;

public class User {

    User(String name, String email, String password, Action[] library, Settings currentSettings){
        this.name = name;
        this.email = email;
        this.password = password;
        this.library = library;
        this.currentSettings = currentSettings;
    }


    // FIELDS //

    private String name;
    private String email;
    private String password;
    private Action[] library;
    private Settings currentSettings;


    // GETTERS //

    public String getName() { return name; }

    public String getPassword() { return password; }

    public Action[] getLibrary() { return library; }

    public Settings getCurrentSettings() { return currentSettings; }

    public String getEmail() { return email; }

}
