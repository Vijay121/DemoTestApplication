package com.cogni.demotestapplication.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cogni.demotestapplication.R;
import com.cogni.demotestapplication.databinding.RecyclerviewLayoutBinding;
import com.cogni.demotestapplication.model.RowsItem;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {

    Context mCtx;
    List<RowsItem> userList;

    public UserRecyclerAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewLayoutBinding recyclerviewLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.recyclerview_layout, parent, false);
        return new UserViewHolder(recyclerviewLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        RowsItem hero = userList.get(position);
        holder.recyclerviewLayoutBinding.setUserdata(hero);
    }

    @Override
    public int getItemCount() {
        if(userList!= null){
            return userList.size();
        }else{
            return 0;
        }
    }

    public void setUserData(List<RowsItem> rowsItems) {
        this.userList = rowsItems;
        notifyDataSetChanged();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        RecyclerviewLayoutBinding recyclerviewLayoutBinding;

        public UserViewHolder(RecyclerviewLayoutBinding recyclerviewLayoutBinding) {
            super(recyclerviewLayoutBinding.getRoot());

            this.recyclerviewLayoutBinding = recyclerviewLayoutBinding;
        }
    }
}