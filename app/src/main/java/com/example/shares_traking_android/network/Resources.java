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

        public static User getCurrentUser() { return currentUser; }

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

        // !! RETURNS NULL ON FAILURE !! //
        // !! UPDATES CURRENT USER !! //

        public static User registerUser(String name, String email, String password, final CallBackAPI api){
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
                return currentUser;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // LOGIN

        // !! RETURNS NULL ON FAILURE !! //
        // !! UPDATES CURRENT USER !! //

        public static User loginUser(String email, String password, final CallBackAPI api){
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
                return currentUser;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // UPDATE USER

        // !! RETURNS NULL ON FAILURE, TRUE IF UPDATED & FALSE IF NOT !! //
        // !! UPDATES CURRENT USER !! //

        public static Boolean updateUser(String name, String email, String password, int id, final CallBackAPI api){
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
                return checker;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // DELETE USER

        // !! RETURNS NULL ON FAILURE, TRUE IF DELETED, FALSE IF NOT //

        public static Boolean deleteUser(int id, final CallBackAPI api){
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
                return checker;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET SHARES

        // UPDATES NOTHING //
        // !! RETURNS NULL ON FAILURE !! //

        public static Share[] getShares(final CallBackAPI api){
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
                return shares;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET COMPANIES

        // !! RETURNS NULL ON FAILURE !! //
        // UPDATES NOTHING //

        public static Company[] getCompanies(CallBackAPI api){
                checker = null;
                companies = null;
                Call<Object> call = link.getCompanies();
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
                return companies;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // CREATE FAVORITE

        // !! RETURNS NULL ON FAILURE, TRUE IF CREATED AND FALSE IF NOT!! //
        // UPDATES NOTHING //

        public static Boolean createFavorite(int user_id, int share_id){
                checker = null;
                Call<Object> call = link.createFavorite(user_id, share_id);
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                checker = true;
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                checker = false;
                        }
                });
                return checker;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // REMOVE FAVORITE

        // !! RETURNS NULL ON FAILURE, TRUE IF REMOVED AND FALSE IF NOT!! //
        // UPDATES NOTHING //

        public static Boolean removeFavorite(int user_id, int share_id){
                checker = null;
                Call<Object> call = link.removeFavorite(user_id, share_id);
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                checker = true;
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                checker = false;
                        }
                });
                return checker;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET FAVORITE SHARES

        // !! RETURNS NULL ON FAILURE, ARRAY ALSO CAN BE NULL !! //
        // UPDATES CURRENT USER SHARES LIBRARY //

        public static Share[] getFavoriteShares(int user_id){
                shares = null;
                checker = null;
                Call<Object> call = link.getFavoriteShares(user_id);
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                shares = gson.fromJson(response.body().toString(), Share[].class);
                                checker = true;
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                shares = null;
                                checker = false;
                        }
                });
                if(shares != null){
                        currentUser.setSharesLibrary(shares);
                }
                return shares;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET FAVORITE COMPANIES

        // !! RETURNS NULL ON FAILURE, ARRAY ALSO CAN BE NULL !! //
        // UPDATES CURRENT USER COMPANIES LIBRARY //

        public static Company[] getFavoriteCompanies(int user_id){
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
                return companies;
        }
}
