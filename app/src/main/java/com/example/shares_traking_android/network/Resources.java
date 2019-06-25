package com.example.shares_traking_android.network;

import android.os.CountDownTimer;
import android.util.Log;

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


        private static User currentUser;
        //
        private static Boolean checker;
        private static Share[] shares;
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
        // UPDATE

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
        // DELETE

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
        // !! UPDATES USER LIBRARY !! //
        // RETURNS NULL ON FAILURE !! //
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

}
