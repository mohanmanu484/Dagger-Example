package com.example.mohang.daggerexample.di;

import com.example.mohang.daggerexample.data.FeedService;
import com.example.mohang.daggerexample.data.DataManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = NetworkModule.class)
public class DataModule {

    @Provides
    @Singleton
    public DataManager dataManager(FeedService feedService){
        return new DataManager(feedService);
    }



}
