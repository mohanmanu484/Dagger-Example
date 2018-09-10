package com.example.mohang.daggerexample;

import android.app.Application;

import com.example.mohang.daggerexample.di.AppComponet;
import com.example.mohang.daggerexample.di.DaggerAppComponet;
import com.example.mohang.daggerexample.di.NetworkModule;

public class App extends Application {


    private static AppComponet appComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        appComponent = DaggerAppComponet.builder()
                .networkModule(new NetworkModule())
                .build();

    }


    public static AppComponet getAppComponent() {
        return appComponent;
    }
}
