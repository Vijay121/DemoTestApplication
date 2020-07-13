package com.cogni.demotestapplication.responseapi;

import com.cogni.demotestapplication.model.UserContentData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserResponseApi {
    String BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";

    @GET("facts")
    Call<UserContentData> getUserContentData();
}
