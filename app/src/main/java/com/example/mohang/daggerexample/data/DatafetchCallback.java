package com.example.mohang.daggerexample.data;

public interface DatafetchCallback<T> {
    void  onFetch(T t);
    void onFail(Throwable t);
}
