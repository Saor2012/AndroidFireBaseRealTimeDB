package com.example.realtimefirebasedb.presentation.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.realtimefirebasedb.app.App;
import com.example.realtimefirebasedb.data.model.RTModel;
import com.example.realtimefirebasedb.databinding.RvItemBinding;
import com.example.realtimefirebasedb.presentation.IMainPresenter;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import timber.log.Timber;

public class ContentViewHolder extends RecyclerView.ViewHolder {
    private IMainPresenter.Presenter presenter;
    private static final String TAG = "ContentViewHolder";
    private RvItemBinding binding;
    private Context context;

    public ContentViewHolder(@NonNull View itemView, IMainPresenter.Presenter presenter, Context context) {
        super(itemView);
        if (this.presenter == null && presenter != null) this.presenter = presenter;
        binding = DataBindingUtil.bind(itemView);
        if (binding != null) binding.setEvent(presenter);
        this.context = context;
    }

    @SuppressLint("SetTextI18n")
    public void bind(RTModel item, int position) {
        if (item != null) {
            binding.itemHeader.setText(item.getName());
            binding.itemContent.setText(item.getDescription());

            Glide.with(context)
                .load(item.getUrl())
                .into(binding.itemImage);
        } else {
            Timber.tag(TAG).e("Item is null");
        }
    }
}
