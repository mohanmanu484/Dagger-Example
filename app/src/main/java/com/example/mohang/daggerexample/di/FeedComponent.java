package com.example.mohang.daggerexample.di;

import com.example.mohang.daggerexample.feeds.FeedFragment;
import com.example.mohang.daggerexample.feeds.MainActivity;

import dagger.Component;
@ActivityScope
@Component(modules = MainActivityModule.class,dependencies = AppComponet.class)
public interface FeedComponent {

    void inject(FeedFragment feedFragment);

}
