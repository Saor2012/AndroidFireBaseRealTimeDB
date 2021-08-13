package com.example.realtimefirebasedb.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realtimefirebasedb.R;
import com.example.realtimefirebasedb.data.RTModel;
import com.example.realtimefirebasedb.presentation.IMainPresenter;

import java.util.List;

import javax.inject.Inject;

public class RVContentAdapter extends RecyclerView.Adapter<ContentViewHolder> implements IRVContentAdapter {
    IMainPresenter.Presenter presenter;
    private List<RTModel> list;

    public RVContentAdapter() {}

    public void setList(List<RTModel> list) { this.list = list; }

    public List<RTModel> getList() { return list; }

    @Override
    public int getListSize() {
        return getItemCount();
    }

    public RVContentAdapter(IMainPresenter.Presenter presenter, List<RTModel> list) {
        if (this.presenter == null && presenter != null) this.presenter = presenter;
        this.list = list;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false), presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        if (list.size() != 0) holder.bind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
