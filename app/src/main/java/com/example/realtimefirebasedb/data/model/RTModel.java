package com.example.realtimefirebasedb.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class RTModel {
    private String name;
    private String description;
    private String url;

    public RTModel() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public RTModel(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
