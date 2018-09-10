package com.example.mohang.daggerexample.data;

import android.util.Log;

import com.example.mohang.daggerexample.feeds.Feed;
import com.example.mohang.daggerexample.feeds.FeedResponce;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

@Singleton
public class DataManager {


    FeedService feedService;

    public static final String TAG= "DataManager";

    @Inject
    public DataManager(FeedService feedService) {
        this.feedService = feedService;
    }

    public void fetch(final DatafetchCallback<List<Feed>> datafetchCallback) {

        feedService.getFeed("[\"cricket\"]").enqueue(new Callback<FeedResponce>() {
            @Override
            public void onResponse(Call<FeedResponce> call, Response<FeedResponce> response) {
                Log.d(TAG, "onResponse: ");
                FeedResponce feedResponce;
                if(response.isSuccessful() && (feedResponce=response.body())!=null) {
                    datafetchCallback.onFetch(feedResponce.getFeedList());
                }else {
                    datafetchCallback.onFail(new Throwable(response.message()));
                }
            }

            @Override
            public void onFailure(Call<FeedResponce> call, Throwable t) {
                datafetchCallback.onFail(t);
            }
        });

    }


}
