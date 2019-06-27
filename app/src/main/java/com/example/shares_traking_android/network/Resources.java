package com.example.shares_traking_android.network;

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

        public static void createFavoriteShare(int user_id, int share_id, final CallBackAPI api){
                checker = null;
                Call<Object> call = link.createFavoriteShare(user_id, share_id);
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

        public static void removeFavoriteShare(int user_id, int share_id, final CallBackAPI api){
                checker = null;
                Call<Object> call = link.removeFavoriteShare(user_id, share_id);
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

        public static void getFavoriteCompanies(int user_id, final CallBackAPI api){
                companies = null;
                checker = null;
                Call<Object> call = link.getFavoriteCompanies(user_id);
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
}
