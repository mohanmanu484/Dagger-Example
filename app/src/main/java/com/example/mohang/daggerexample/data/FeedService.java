package com.example.mohang.daggerexample.data;

import com.example.mohang.daggerexample.feeds.Feed;
import com.example.mohang.daggerexample.feeds.FeedResponce;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FeedService {


    @GET("/api/posts?")
    Call<FeedResponce> getFeed(@Query("type")String type);

}
