package com.example.realtimefirebasedb.presentation;

import com.example.realtimefirebasedb.data.model.RTModel;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements IMainPresenter.Presenter {
    private IMainPresenter.View view;
    private static final String TAG = "MainPresenter";
    private List<RTModel> list;

    public MainPresenter() {}

    @Override
    public void init() {}

    @Override
    public List<RTModel> getData() {
        return list;
    }

    @Override
    public void updateData(List<RTModel> list) {
        this.list = list;
    }

    @Override
    public void onStart(IMainPresenter.View view) { this.view = view; }

    @Override
    public void onStop() { if (view != null) view = null; }
}
