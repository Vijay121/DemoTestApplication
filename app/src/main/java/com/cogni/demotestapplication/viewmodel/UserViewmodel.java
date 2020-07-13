package com.cogni.demotestapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.cogni.demotestapplication.model.UserContentData;
import com.cogni.demotestapplication.repositories.UserRepository;

import retrofit2.Retrofit;

public class UserViewmodel extends AndroidViewModel {

    private UserRepository userRepository;

    public UserViewmodel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository();
    }

    //This method is using Retrofit to get the JSON data from Repository
    public LiveData<UserContentData> loadUsers() {
        return userRepository.getMutableUserData();
    }

}
