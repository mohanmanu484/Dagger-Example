package com.example.mohang.daggerexample.feeds;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohang.daggerexample.App;
import com.example.mohang.daggerexample.R;
import com.example.mohang.daggerexample.Util;
import com.example.mohang.daggerexample.di.DaggerFeedComponent;
import com.example.mohang.daggerexample.adapter.GenericAdapter;
import com.example.mohang.daggerexample.di.MainActivityModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class FeedFragment extends android.support.v4.app.Fragment implements FeedContract.View {


    private RecyclerView feedList;

    @Inject
    FeedPresenter feedPresenter;

    @Named("feedAdapter")
    @Inject
    GenericAdapter feedAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerFeedComponent.builder().mainActivityModule(new MainActivityModule(this)).appComponet(App.getAppComponent()).build().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);
        initRecyclerView(view, container.getContext());
        feedPresenter.fetchFeed();
        return view;
    }

    private void initRecyclerView(View view, Context context) {
        feedList = view.findViewById(R.id.feedList);
        feedList.setHasFixedSize(true);
        feedList.setLayoutManager(new LinearLayoutManager(context));
        feedList.setAdapter(feedAdapter);
    }

    public static android.support.v4.app.Fragment instance() {
        return new FeedFragment();
    }

    @Override
    public void showProgress() {
        Util.showProgress(getActivity());
    }

    @Override
    public void hideProgress() {
        Util.hideProgress();
    }

    @Override
    public void updateList(List<Feed> feedList) {
        feedAdapter.setListItems(new ArrayList<Object>(feedList));
    }

    @Override
    public boolean isViewAdded() {
        return isAdded();
    }

    @Override
    public void showMessage(String message) {
        Util.showSnackbar(getView(), message);
    }
}
