package com.murugan.durai.mvvm_example_01.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.murugan.durai.mvvm_example_01.Model.Model;
import com.murugan.durai.mvvm_example_01.Model.UserRepository;

public class MainActivityViewModel extends AndroidViewModel {
UserRepository  userRepository;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        userRepository=new UserRepository(application);
    }

    public LiveData<Model[]> getalldata(){
        return userRepository.GetUserData();
    }
}
