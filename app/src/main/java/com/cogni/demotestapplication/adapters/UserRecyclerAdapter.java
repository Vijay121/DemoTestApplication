package com.cogni.demotestapplication.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cogni.demotestapplication.R;
import com.cogni.demotestapplication.model.RowsItem;

import java.util.List;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {

    Context mCtx;
    List<RowsItem> heroList;

    public UserRecyclerAdapter(Context mCtx, List<RowsItem> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        RowsItem hero = heroList.get(position);

        Glide.with(mCtx)
                .load(hero.getImageHref())
                .into(holder.mImageView);

        holder.mTextviewTitle.setText(hero.getTitle());
        holder.mTextViewDescription.setText(hero.getDescription());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextviewTitle;
        TextView mTextViewDescription;

        public UserViewHolder(View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.img_user);
            mTextviewTitle = itemView.findViewById(R.id.txt_title);
            mTextViewDescription = itemView.findViewById(R.id.txt_description);
        }
    }
}