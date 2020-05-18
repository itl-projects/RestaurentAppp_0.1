package com.example.demoapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.RecyclerView;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {
    private List<DataModel> moviesList;
    Fragment fragment;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textview2;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            textview2 = (TextView) view.findViewById(R.id.text1);
            image=(ImageView)view.findViewById(R.id.image);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
              //      AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                    Intent i =new Intent(activity,BlankFragment.class);
//                    activity.startActivity(i);
                     fragment=new BlankFragment();
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FragmentManager fragmentManager =activity.getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame,fragment).addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }
    }


    public CustomAdaptor(List<DataModel> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.carddesign, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataModel list = moviesList.get(position);
        holder.textview2.setText(list.getName());
        holder.image.setImageResource(list.getImage());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}