package com.murugan.durai.mvvm_example_01.Model;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;



public class UserRepository {
    Model[] user;
    Application application;
    MutableLiveData<Model[]> mutableLiveData;

    public UserRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<Model[]> GetUserData() {

        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
        }
        String url = "https://api.github.com/users";
        RequestQueue requestQueue = Volley.newRequestQueue(application);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                user = gson.fromJson(response, Model[].class);
                mutableLiveData.setValue(user);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(request);

        return mutableLiveData;
    }
}
