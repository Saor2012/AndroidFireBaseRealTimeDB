package com.example.realtimefirebasedb.presentation;

public interface IMainPresenter {
    interface View {

    }
    interface Presenter extends BasePresenter<View> {
        void init();
    }
}
