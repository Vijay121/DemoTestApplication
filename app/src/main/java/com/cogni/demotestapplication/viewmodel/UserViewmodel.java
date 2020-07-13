package com.cogni.demotestapplication.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cogni.demotestapplication.model.UserContentData;
import com.cogni.demotestapplication.responseapi.UserResponseApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserViewmodel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<UserContentData> userContentDataMutableLiveData;

    //we will call this method to get the data
    public LiveData<UserContentData> getUserData() {
        //if the list is null
        if (userContentDataMutableLiveData == null) {
            userContentDataMutableLiveData = new MutableLiveData<>();
            //we will load it asynchronously from server in this method
            loadUsers();
        }

        //finally we will return the list
        return userContentDataMutableLiveData;
    }


    //This method is using Retrofit to get the JSON data from URL
    private void loadUsers() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UserResponseApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserResponseApi api = retrofit.create(UserResponseApi.class);
        Call<UserContentData> call = api.getUserContentData();


        call.enqueue(new Callback<UserContentData>() {
            @Override
            public void onResponse(Call<UserContentData> call, Response<UserContentData> response) {

                //finally we are setting the list to our MutableLiveData
                userContentDataMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<UserContentData> call, Throwable t) {
                Log.i("UserViewmodel", "onFailure: " + t.getMessage());
            }
        });
    }

}
