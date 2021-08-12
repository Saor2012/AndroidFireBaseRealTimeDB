package com.example.realtimefirebasedb.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RTModel {
    private String name;
    private String description;
    private String uri;

    public RTModel(String name, String description, String uri) {
        this.name = name;
        this.description = description;
        this.uri = uri;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getUri() {
        return uri;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUri(String uri) {
        this.uri = uri;
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
