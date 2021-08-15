package com.example.realtimefirebasedb.presentation;

import com.example.realtimefirebasedb.data.model.RTModel;

import java.util.List;

public interface IMainPresenter {
    interface View {
        void showData(List<RTModel> list);
    }
    interface Presenter extends BasePresenter<View> {
        void init();
        List<RTModel> getData();
        void updateData(List<RTModel> list);
    }
}
