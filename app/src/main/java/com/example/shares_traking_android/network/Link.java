package com.example.shares_traking_android.network;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Link {


    // THIS IS RETROFIT INTERFACE //

    @POST("users?")
    Call<Object> registerUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("users/authorization?")
    Call<Object> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    @PUT("users/:{id}?")
    Call<Object> updateUser(
            @Path("id") int id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("users/:{id}?")
    Call<Object> getUser(
            @Path("id") int id
    );

    @DELETE("users/:{id}?")
    Call<Object> deleteUser(
            @Path("id") int id
    );

    @GET("shares")
    Call<Object> getShares();

    @GET("shares/companies")
    Call<Object> getCompanies();
}
