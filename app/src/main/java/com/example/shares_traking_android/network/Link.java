package com.example.shares_traking_android.network;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Link {


    // THIS IS RETROFIT INTERFACE //

    @POST("users?")
    Call<Object> registerUser(
            @Query("name") String name,
            @Query("email") String email,
            @Query("password") String password
    );

    @GET("users/authorization?")
    Call<Object> loginUser(
            @Query("email") String email,
            @Query("password") String password
    );

    @GET("users/{id}?")
    Call<Object> updateUser(
            @Path("id") int id,
            @Query("name") String name,
            @Query("email") String email,
            @Query("password") String password
    );

    @GET("users/{id}?")
    Call<Object> getUser(
            @Path("id") int id
    );

    @DELETE("users/{id}?")
    Call<Object> deleteUser(
            @Path("id") int id
    );

    @GET("shares")
    Call<Object> getShares();

    @GET("shares/companies")
    Call<Object> getCompanies();

    @POST("users/{user_id}/favorites?")
    Call<Object> createFavoriteShare(
        @Path("user_id") int user_id,
        @Query("share_id") int share_id
    );

    @DELETE("users/{user_id}/favorites/remove?")
    Call<Object> removeFavoriteShare(
            @Path("user_id") int user_id,
            @Query("share_id") int share_id
    );

    @GET("users/{user_id}/favorites")
    Call<Object> getFavoriteShares(
        @Path("user_id") int user_id
    );

    @GET("users/{user_id}/favorites/companies")
    Call<Object> getFavoriteCompanies(
            @Path("user_id") int user_id
    );
 }
