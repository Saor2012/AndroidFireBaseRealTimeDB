package com.example.realtimefirebasedb.presentation;

public class MainPresenter implements IMainPresenter.Presenter {
    private IMainPresenter.View view;
    private static final String TAG = "MainPresenter";

    public MainPresenter() {}

    @Override
    public void init() {}

    @Override
    public void onStart(IMainPresenter.View view) { this.view = view; }

    @Override
    public void onStop() { if (view != null) view = null; }
}
