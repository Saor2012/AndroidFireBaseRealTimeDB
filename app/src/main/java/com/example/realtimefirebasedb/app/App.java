package com.example.realtimefirebasedb.app;

import android.app.Application;

import com.example.realtimefirebasedb.BuildConfig;

import timber.log.Timber;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
