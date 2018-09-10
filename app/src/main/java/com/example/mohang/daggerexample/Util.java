package com.example.mohang.daggerexample;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.ProgressBar;

public class Util {



    private static AppCompatDialog appCompatDialog;



    public static void addFragment(FragmentManager fragmentManager, android.support.v4.app.Fragment fragment,int container){


        fragmentManager.beginTransaction()
                .add(container,fragment,"feed")
                .commit();
    }

    public static void showProgress(Context context) {


        appCompatDialog=new AppCompatDialog(context);
        appCompatDialog.setContentView(R.layout.progress_bar);
        if(!appCompatDialog.isShowing()){
            appCompatDialog.show();
        }

    }

    public static void hideProgress(){
        if(appCompatDialog!=null && appCompatDialog.isShowing()){
            appCompatDialog.dismiss();
            appCompatDialog=null;
        }
    }

    public static void showSnackbar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
}
