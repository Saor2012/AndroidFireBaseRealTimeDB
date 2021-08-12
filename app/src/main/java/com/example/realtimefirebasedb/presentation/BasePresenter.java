package com.example.realtimefirebasedb.presentation;

public interface BasePresenter<V> {
   void onStart(V view);
   void onStop();
}
