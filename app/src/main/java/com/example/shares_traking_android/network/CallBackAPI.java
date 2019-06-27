package com.example.shares_traking_android.network;
import retrofit2.Response;

public interface CallBackAPI {
    void onResponse(Response response);
    void onFailure(Throwable t);
}
