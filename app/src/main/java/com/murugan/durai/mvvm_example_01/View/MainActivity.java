package com.murugan.durai.mvvm_example_01.View;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.murugan.durai.mvvm_example_01.Adapter.RecyclerAdapter;
import com.murugan.durai.mvvm_example_01.Model.Model;
import com.murugan.durai.mvvm_example_01.R;
import com.murugan.durai.mvvm_example_01.ViewModel.MainActivityViewModel;



public class MainActivity extends AppCompatActivity {
MainActivityViewModel mainActivityViewModel;
RecyclerView recyclerView;
RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mainActivityViewModel= ViewModelProviders.of(MainActivity.this).get(MainActivityViewModel.class);
        mainActivityViewModel.getalldata().observe(MainActivity.this, new Observer<Model[]>() {
            @Override
            public void onChanged(@Nullable Model[] models) {
                Log.i("TAG", "onChanged: "+models);
                recyclerAdapter=new RecyclerAdapter(models,MainActivity.this);
                recyclerView.setAdapter(recyclerAdapter);
            }
        });

    }
}
