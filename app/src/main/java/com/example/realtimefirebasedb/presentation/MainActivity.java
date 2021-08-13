package com.example.realtimefirebasedb.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.realtimefirebasedb.R;
import com.example.realtimefirebasedb.databinding.ActivityMainBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import timber.log.Timber;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements IMainPresenter.View {
    IMainPresenter.Presenter presenter;
    private static final String TAG = "MainActivity";

    @Override
    protected void initView() {
        presenter = new MainPresenter();
        presenter.onStart(this);
        presenter.init();
    }

    @Override
    protected int getLayoutRes() { return R.layout.activity_main; }

    @Override
    protected void onStartView() {
        getBinding().setEvent(presenter);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Test1");

        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Timber.tag(TAG).e("Recive data: %s", value);
            }

            @SuppressLint("ThrowableNotAtBeginning")
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Timber.tag(TAG).e("Error: %s", error.toException());
            }
        });*/

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
