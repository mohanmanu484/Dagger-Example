package com.example.mohang.daggerexample.di;

import com.example.mohang.daggerexample.data.FeedService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {



    @Provides
    public GsonConverterFactory provideGson(){
        return GsonConverterFactory.create();
    }

    @Provides
    @Named("url")
    public String provideURl(){
        return "http://139.59.40.160:3000";
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@Named("url") String url,GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .baseUrl( url)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }


    @Provides
    public FeedService getFeedService(Retrofit retrofit){
        return retrofit.create(FeedService.class);
    }


}
