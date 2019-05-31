package com.murugan.durai.mvvm_example_01.Adapter;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.murugan.durai.mvvm_example_01.Model.Model;
import com.murugan.durai.mvvm_example_01.R;
import com.squareup.picasso.Picasso;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewholder> {
    Model[] models;
    Context context;

    public RecyclerAdapter(Model[] models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,viewGroup,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
    Picasso.with(context).load(models[i].getAvatarUrl()).fit().into(viewholder.imageView);
        viewholder.name.setText(""+models[i].getLogin());
    }

    @Override
    public int getItemCount() {
        return models.length;
    }

    class viewholder extends RecyclerView.ViewHolder{
  ImageView imageView;
  TextView id,name;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview);
            name=itemView.findViewById(R.id.name);
        }
    }
}
