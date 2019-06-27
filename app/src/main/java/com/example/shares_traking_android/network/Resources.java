package com.example.shares_traking_android.network;

import android.os.CountDownTimer;
import android.util.Log;
import com.example.shares_traking_android.model.Company;
import com.example.shares_traking_android.model.Share;
import com.example.shares_traking_android.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resources {


        // THIS CLASS IS A NETWORK METHODS STORAGE //

        // CHECK LOGS FOR DEBUGGING //
        // PAY ATTENTION TO COMMENTS //


        private static User currentUser;
        //
        private static Boolean checker;
        private static Share[] shares;
        private static Company[] companies;
        //
        private static final String SERVER_URL = "https://peaceful-springs-30870.herokuapp.com/api/v1/";
        private static Gson gson = new GsonBuilder().create();
        private static Retrofit main = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        private static Link link = main.create(Link.class);

        // METHODS //

         // GETTERS

        public static User getCurrentUser() { return currentUser; }

        public static Boolean getChecker() { return checker; }

        public static Company[] getCompanies() { return companies; }

        public static Share[] getShares() { return shares; }

         // SETTERS

        static void setCurrentUser(User currentUser) {
                if(currentUser == null){
                        Resources.currentUser = currentUser;
                }else{
                        // ACCESS DENIED YOU STUPID HACKER
                }
        }

        static void setChecker(Boolean checker) {
                Resources.checker = checker;
        }

        static void setShares(Share[] shares) {
                Resources.shares = shares;
        }

        static void setCompanies(Company[] companies) {
                Resources.companies = companies;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // REGISTRATION

        // !! UPDATES CURRENT USER !! //

        public static void registerUser(String name, String email, String password, final CallBackAPI api){
                Call<Object> call = link.registerUser(name, email, password);
                currentUser = null;
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // LOGIN

        // !! UPDATES CURRENT USER !! //

        public static void loginUser(String email, String password, final CallBackAPI api){
                Call<Object> call = link.loginUser(email, password);
                currentUser = null;
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // UPDATE USER

        // !! UPDATES CURRENT USER !! //

        public static void updateUser(String name, String email, String password, int id, final CallBackAPI api){
                Call<Object> call = link.updateUser(id, name, email, password);
                checker = null;
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // DELETE USER

        public static void deleteUser(int id, final CallBackAPI api){
                Call<Object> call = link.deleteUser(id);
                checker = null;
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET SHARES

        public static void getShares(final CallBackAPI api){
                shares = null;
                checker = null;
                Call<Object> call = link.getShares();
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET COMPANIES

        // UPDATES NOTHING //

        public static void getCompanies(final CallBackAPI api){
                checker = null;
                companies = null;
                Call<Object> call = link.getCompanies();
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // CREATE FAVORITE

        // UPDATES NOTHING //

        public static void createFavorite(int user_id, int share_id, final CallBackAPI api){
                checker = null;
                Call<Object> call = link.createFavorite(user_id, share_id);
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // REMOVE FAVORITE

        // UPDATES NOTHING //

        public static void removeFavorite(int user_id, int share_id, final CallBackAPI api){
                checker = null;
                Call<Object> call = link.removeFavorite(user_id, share_id);
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");

                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET FAVORITE SHARES

        // UPDATES CURRENT USER SHARES LIBRARY //

        public static void getFavoriteShares(int user_id, final CallBackAPI api){
                shares = null;
                checker = null;
                Call<Object> call = link.getFavoriteShares(user_id);
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                api.onResponse(response);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                api.onFailure(t);
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET FAVORITE COMPANIES

        // UPDATES CURRENT USER COMPANIES LIBRARY //

        public static void getFavoriteCompanies(int user_id, final CallBackAPI api){
                companies = null;
                checker = null;
                Call<Object> call = link.getFavoriteCompanies(user_id);
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                companies = gson.fromJson(response.body().toString(), Company[].class);
                                checker = true;
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                companies = null;
                                checker = false;
                        }
                });
                if(companies != null){
                        currentUser.setCompaniesLibrary(companies);
                }
        }
}
