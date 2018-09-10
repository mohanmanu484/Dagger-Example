package com.example.mohang.daggerexample.feeds;

import java.util.List;

public interface FeedContract {

     interface View {


        void showProgress();

        void hideProgress();

        void updateList(List<Feed> feedList);

        boolean isViewAdded();

        void showMessage(String message);
    }

    interface Presenter {


        void fetchFeed();
    }

}
