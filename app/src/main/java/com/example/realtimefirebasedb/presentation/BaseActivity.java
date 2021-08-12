package com.example.realtimefirebasedb.presentation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import io.reactivex.annotations.Nullable;

public abstract class BaseActivity<Binding extends ViewDataBinding> extends AppCompatActivity {
    private Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
        initView();
    }

    protected abstract void initView();

    @LayoutRes
    protected abstract int getLayoutRes();

    @Override
    protected void onStart() {
        super.onStart();
        onStartView();
    }

    protected Binding getBinding(){
        return binding;
    }

    @Override
    public void onDestroy() {
        if (getPresenter() != null) {
            onDestroyView();
        }
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        onResumeView();
    }

    protected abstract void onStartView();

    protected abstract void onDestroyView();

    protected abstract void onResumeView();

    protected abstract BasePresenter getPresenter();

    protected void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
