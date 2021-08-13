package com.example.realtimefirebasedb.presentation;

import com.example.realtimefirebasedb.presentation.adapter.IRVContentAdapter;
import com.example.realtimefirebasedb.presentation.adapter.RVContentAdapter;

public class MainPresenter implements IMainPresenter.Presenter {
    private IMainPresenter.View view;
    private IRVContentAdapter contentAdapter;
    private static final String TAG = "MainPresenter";

    public MainPresenter() {}

    @Override
    public void init() {
        contentAdapter = new RVContentAdapter(this, null);
    }

    @Override
    public void onStart(IMainPresenter.View view) { this.view = view; }

    @Override
    public void onStop() { if (view != null) view = null; }
}
