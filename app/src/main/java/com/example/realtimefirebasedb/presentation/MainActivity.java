package com.example.realtimefirebasedb.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.realtimefirebasedb.R;
import com.example.realtimefirebasedb.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements IMainPresenter.View {
    IMainPresenter.Presenter presenter;
    private static final String TAG = "MainActivity";

    @Override
    protected void initView() {
        presenter = new MainPresenter();
        presenter.init();
        presenter.onStart(this);
    }

    @Override
    protected int getLayoutRes() { return R.layout.activity_main; }

    @Override
    protected void onStartView() {
        getBinding().setEvent(presenter);
    }

    @Override
    protected void onDestroyView() {
        if (presenter != null) {
            presenter.onStop();
            presenter = null;
        }
    }

    @Override
    protected void onResumeView() {
        //TODO NOT USED
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }
}
