package com.example.mohang.daggerexample.di;

import com.example.mohang.daggerexample.data.DataManager;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {NetworkModule.class,DataModule.class})
@Singleton
public interface AppComponet {

    DataManager dataManager();
}
