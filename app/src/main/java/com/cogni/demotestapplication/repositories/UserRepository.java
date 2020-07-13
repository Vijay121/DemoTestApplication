package com.cogni.demotestapplication.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.cogni.demotestapplication.model.UserContentData;
import com.cogni.demotestapplication.responseapi.UserResponseApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserRepository {
    private MutableLiveData<UserContentData> userContentDataMutableLiveData = new MutableLiveData<>();

    public UserRepository() {
    }

    public LiveData<UserContentData> getMutableUserData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UserResponseApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserResponseApi api = retrofit.create(UserResponseApi.class);
        Call<UserContentData> call = api.getUserContentData();


        call.enqueue(new Callback<UserContentData>() {
            @Override
            public void onResponse(Call<UserContentData> call, Response<UserContentData> response) {
                userContentDataMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserContentData> call, Throwable t) {
                Log.i("Repository", "onFailure: " + t.getMessage());
            }
        });
        return userContentDataMutableLiveData;
    }

}
