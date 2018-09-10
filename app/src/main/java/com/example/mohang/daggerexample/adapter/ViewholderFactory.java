package com.example.mohang.daggerexample.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mohang.daggerexample.R;
import com.example.mohang.daggerexample.feeds.Feed;

public class ViewholderFactory {


    public static RecyclerView.ViewHolder create(View view){
        return new FeedViewHolder(view);
    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder implements Binder<Feed>{

        private ImageView postImage;
        private TextView postHeading;


        public FeedViewHolder(View itemView) {
            super(itemView);
            postImage=itemView.findViewById(R.id.postImage);
            postHeading=itemView.findViewById(R.id.postHeading);
        }

        @Override
        public void bind(Feed feed) {

            Glide.with(itemView).load(feed.getDisplay_url()).into(postImage);
            postHeading.setText(feed.getText());
        }
    }
}
