package com.example.realtimefirebasedb.presentation;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;

import com.example.realtimefirebasedb.R;
import com.example.realtimefirebasedb.data.model.RTModel;
import com.example.realtimefirebasedb.databinding.ActivityMainBinding;
import com.example.realtimefirebasedb.presentation.adapter.RVContentAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements IMainPresenter.View {
    private IMainPresenter.Presenter presenter;
    private RVContentAdapter contentAdapter;
    private static final String TAG = "MainActivity";

    @Override
    protected void initView() {
        presenter = new MainPresenter();
        presenter.onStart(this);
        presenter.init();
        contentAdapter = new RVContentAdapter(presenter, null, getApplicationContext());
    }

    @Override
    protected int getLayoutRes() { return R.layout.activity_main; }

    @Override
    protected void onStartView() {
        getBinding().setEvent(presenter);
        getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(getBinding().getRoot().getContext(), LinearLayoutManager.VERTICAL, false));
        if (contentAdapter != null) {
            //contentAdapter.updateList(presenter.getData());
            //getBinding().recyclerView.setAdapter(contentAdapter);
        } else {
            Timber.tag(TAG).e("RV have 0 items");
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Test1");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String name, description, url;
                RTModel value;
                List<RTModel> list = new ArrayList<RTModel>();
                for(DataSnapshot item : dataSnapshot.getChildren()) {
                    name = item.child("name").getValue(String.class);
                    description = item.child("description").getValue(String.class);
                    url = item.child("url").getValue(String.class);
                    value = new RTModel(name, description, url);
                    Timber.tag(TAG).e("Recive data: %s", value.toString());
                    list.add(value);
                }
                presenter.updateData(list); //Update current list
                showData(list);
            }

            @SuppressLint("ThrowableNotAtBeginning")
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Timber.tag(TAG).e("Error: %s", error.toException());
            }
        });

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

    @Override
    public void showData(List<RTModel> list) {
        if (list != null) {
            Timber.tag(TAG).e("Receive data: %s", list.toString());
            contentAdapter.updateList(list);
            getBinding().recyclerView.setAdapter(contentAdapter);
        }
    }
}
