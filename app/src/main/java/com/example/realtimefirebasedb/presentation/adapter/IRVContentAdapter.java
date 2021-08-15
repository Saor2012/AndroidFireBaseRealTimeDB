package com.example.realtimefirebasedb.presentation.adapter;

import com.example.realtimefirebasedb.data.model.RTModel;

import java.util.List;

public interface IRVContentAdapter {
    void updateList(List<RTModel> list);
    int getListSize();
}
