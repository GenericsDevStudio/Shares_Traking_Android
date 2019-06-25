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

        ////////////////////////////////////////////////////////////////////////////////////////////
        // REGISTRATION

        // !! RETURNS NULL ON FAILURE !! //
        // !! UPDATES CURRENT USER !! //

        public static User registerUser(String name, String email, String password){
                Call<Object> call = link.registerUser(name, email, password);
                currentUser = null;
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                currentUser = gson.fromJson(response.body().toString(), User.class);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                currentUser = null;
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(currentUser != null){
                                        Log.d("RESOURCES - ", "USER REGISTERED");
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
                return currentUser;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // LOGIN

        // !! RETURNS NULL ON FAILURE !! //
        // !! UPDATES CURRENT USER !! //

        public static User loginUser(String email, String password){
                Call<Object> call = link.loginUser(email, password);
                currentUser = null;
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                currentUser = gson.fromJson(response.body().toString(), User.class);
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                currentUser = null;
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(currentUser != null){
                                        Log.d("RESOURCES - ", "USER LOGGED IN");
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
                return currentUser;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // UPDATE USER

        // !! RETURNS NULL ON FAILURE, TRUE IF UPDATED & FALSE IF NOT !! //
        // !! UPDATES CURRENT USER !! //

        public static Boolean updateUser(String name, String email, String password, int id){
                Call<Object> call = link.updateUser(id, name, email, password);
                checker = null;
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                checker = true;
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                checker = false;
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(checker != null){
                                        Log.d("RESOURCES - ", "UPDATED? " + checker.toString());
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
                return checker;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // DELETE USER

        // !! RETURNS NULL ON FAILURE, TRUE IF DELETED, FALSE IF NOT //

        public static Boolean deleteUser(int id){
                Call<Object> call = link.deleteUser(id);
                checker = null;
                call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                                checker = true;
                                Log.d("RESOURCES - ", "CONNECTION SUCCESS");
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                                checker = false;
                                Log.d("RESOURCES - ", "CONNECTION FAILURE");
                        }
                });
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(checker != null){
                                        Log.d("RESOURCES - ", "DELETED? " + checker.toString());
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
                return checker;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET SHARES

        // UPDATES NOTHING //
        // !! RETURNS NULL ON FAILURE !! //

        public static Share[] getShares(){
                shares = null;
                checker = null;
                Call<Object> call = link.getShares();
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
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(checker != null){
                                        Log.d("RESOURCES - ", "SHARES GOT? " + checker.toString());
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
                return shares;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        // GET COMPANIES

        // !! RETURNS NULL ON FAILURE !! //
        // UPDATES NOTHING //

        public static Company[] getCompanies(){
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
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(checker != null){
                                        Log.d("RESOURCES - ", "COMPANIES GOT? " + checker.toString());
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
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
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(checker != null){
                                        Log.d("RESOURCES - ", "FAVORITE CREATED? " + checker.toString());
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
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
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(checker != null){
                                        Log.d("RESOURCES - ", "FAVORITE REMOVED? " + checker.toString());
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
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
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(checker != null){
                                        Log.d("RESOURCES - ", "FAVORITE SHARES GOT? " + checker.toString());
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
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
                CountDownTimer waitForResponse = new CountDownTimer(5000, 10) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                                if(checker != null){
                                        Log.d("RESOURCES - ", "FAVORITE COMPANIES GOT? " + checker.toString());
                                        cancel();
                                }
                        }

                        @Override
                        public void onFinish() {
                                Log.d("RESOURCES - ", "CONNECTION TIMEOUT");
                                cancel();
                        }
                };
                waitForResponse.start();
                if(companies != null){
                        currentUser.setCompaniesLibrary(companies);
                }
                return companies;
        }
}
