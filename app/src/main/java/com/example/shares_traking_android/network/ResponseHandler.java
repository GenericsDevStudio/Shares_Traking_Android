package com.example.shares_traking_android.network;

import android.util.Log;
import com.example.shares_traking_android.model.Company;
import com.example.shares_traking_android.model.Share;
import com.example.shares_traking_android.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Response;

// THIS CLASS IS A STORAGE OF RETROFIT METHODS IMPLEMENTATIONS WITHOUT ADDITIONAL ACTIONS
// YOU CAN USE IT AS EXAMPLE, AS SHORTCUT FOR CLEANER CODE OR/AND AS DEFAULT METHOD CALL

public class ResponseHandler {

    // FIELDS

    private static Gson gson = new GsonBuilder().create();

    // INTERFACE IMPLEMENTATIONS WITH GETTERS

    private static CallBackAPI toRegisterUser = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.setCurrentUser(gson.fromJson(response.body().toString(), User.class));
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.setCurrentUser(null);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToRegisterUser() { return toRegisterUser; }

    //////////////////////////////////////////

    private static CallBackAPI toLoginUser = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.setCurrentUser(gson.fromJson(response.body().toString(), User.class));
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.setCurrentUser(null);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToLoginUser() { return toLoginUser; }

    //////////////////////////////////////////

    private static CallBackAPI toUpdateUser = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.setChecker(true);
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.setChecker(false);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToUpdateUser() { return toUpdateUser; }

    //////////////////////////////////////////

    private static CallBackAPI toDeleteUser = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.setChecker(true);
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.setChecker(false);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToDeleteUser() { return toDeleteUser; }

    //////////////////////////////////////////

    private static CallBackAPI toGetShares = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.setShares(gson.fromJson(response.body().toString(), Share[].class));
            Resources.setChecker(true);
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.setShares(null);
            Resources.setChecker(false);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToGetShares() { return toGetShares; }

    //////////////////////////////////////////

    private static CallBackAPI toGetCompanies = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.setCompanies(gson.fromJson(response.body().toString(), Company[].class));
            Resources.setChecker(true);
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.setCompanies(null);
            Resources.setChecker(false);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToGetCompanies() { return toGetCompanies; }

    //////////////////////////////////////////

    private static CallBackAPI toCreateFavorite = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.setChecker(true);
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.setChecker(false);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToCreateFavorite() { return toCreateFavorite; }

    //////////////////////////////////////////

    private static CallBackAPI toRemoveFavorite = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.setChecker(true);
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.setChecker(false);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToRemoveFavorite() { return toRemoveFavorite; }

    //////////////////////////////////////////

    private static CallBackAPI toGetFavoriteShares = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.getCurrentUser().setSharesLibrary(gson.fromJson(response.body().toString(), Share[].class));
            Resources.setChecker(true);
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.getCurrentUser().setSharesLibrary(null);
            Resources.setChecker(false);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToGetFavoriteShares() { return toGetFavoriteShares; }

    //////////////////////////////////////////

    private static CallBackAPI toGetFavoriteCompanies = new CallBackAPI() {
        @Override
        public void onResponse(Response response) {
            Resources.getCurrentUser().setCompaniesLibrary(gson.fromJson(response.body().toString(), Company[].class));
            Resources.setChecker(true);
        }

        @Override
        public void onFailure(Throwable t) {
            Resources.getCurrentUser().setCompaniesLibrary(null);
            Resources.setChecker(false);
            Log.d("HANDLER - ", "ONFAILURE", t);
        }
    };

    public static CallBackAPI getToGetFavoriteCompanies() { return toGetFavoriteCompanies; }

}
