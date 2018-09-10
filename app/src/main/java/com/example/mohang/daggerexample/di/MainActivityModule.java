package com.example.mohang.daggerexample.di;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mohang.daggerexample.R;
import com.example.mohang.daggerexample.adapter.GenericAdapter;
import com.example.mohang.daggerexample.adapter.ViewholderFactory;
import com.example.mohang.daggerexample.data.DataManager;
import com.example.mohang.daggerexample.feeds.FeedContract;
import com.example.mohang.daggerexample.feeds.FeedPresenter;

import java.util.Collections;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

    FeedContract.View view;

    public MainActivityModule(FeedContract.View view) {
        this.view = view;
    }

    @Provides
    public FeedPresenter mainPresenter(DataManager dataManager){
        return new FeedPresenter(view,dataManager);
    }

    @Provides
    @Named("feedLayout")
    public int feedViewHolder(){
        return R.layout.post_adapter_item;
    }

    @Provides
    @Named("feedAdapter")
    public GenericAdapter genericAdapter(@Named("feedLayout")@LayoutRes final int layout ){
        return new GenericAdapter(Collections.emptyList()) {
            @Override
            public RecyclerView.ViewHolder getViewholder(View view) {
                return ViewholderFactory.create(view);
            }

            @Override
            public int getLayoutFile(Object object, int pos) {
                return layout;
            }
        };
    }






}
