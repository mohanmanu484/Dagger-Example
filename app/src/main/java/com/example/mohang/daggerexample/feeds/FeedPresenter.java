package com.example.mohang.daggerexample.feeds;

import com.example.mohang.daggerexample.data.DataManager;
import com.example.mohang.daggerexample.data.DatafetchCallback;

import java.util.List;

import javax.inject.Inject;

public class FeedPresenter implements FeedContract.Presenter{


    private DataManager dataManager;
    private FeedContract.View view;



    @Inject
    public FeedPresenter(FeedContract.View view,DataManager dataManager) {
        this.dataManager = dataManager;
        this.view=view;
    }

    @Override
    public void fetchFeed() {
        view.showProgress();
        dataManager.fetch(new DatafetchCallback<List<Feed>>() {
            @Override
            public void onFetch(List<Feed> feedList) {
                if(view.isViewAdded() ) {
                    view.hideProgress();
                    if(feedList!=null && feedList.size()>0) {
                        view.updateList(feedList);
                    }else {
                        view.showMessage("Empty feed list");
                    }
                }
            }

            @Override
            public void onFail(Throwable t) {
                if(view.isViewAdded()) {
                    view.hideProgress();
                    view.showMessage(t.getMessage());
                }
            }
        });

    }
}
