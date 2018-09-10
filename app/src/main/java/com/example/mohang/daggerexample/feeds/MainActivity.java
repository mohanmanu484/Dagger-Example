package com.example.mohang.daggerexample.feeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mohang.daggerexample.R;
import com.example.mohang.daggerexample.Util;

public class MainActivity extends AppCompatActivity {



    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null){
            Util.addFragment(getSupportFragmentManager(),FeedFragment.instance(),R.id.container);
        }

    }
}
