package com.example.finalnewsapp;

import android.app.Application;

import com.example.finalnewsapp.database.MyDataBase;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MyDataBase.init(this);
    }
}
