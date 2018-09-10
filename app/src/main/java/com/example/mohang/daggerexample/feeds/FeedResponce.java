package com.example.mohang.daggerexample.feeds;

import java.util.List;

public class FeedResponce {

    private List<Feed> data;

    public List<Feed> getFeedList() {
        return data;
    }

    public void setFeedList(List<Feed> feedList) {
        this.data = feedList;
    }
}
