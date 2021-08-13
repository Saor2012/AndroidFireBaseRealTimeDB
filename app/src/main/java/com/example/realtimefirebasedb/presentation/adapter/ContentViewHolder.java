package com.example.realtimefirebasedb.presentation.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realtimefirebasedb.data.RTModel;
import com.example.realtimefirebasedb.databinding.RvItemBinding;
import com.example.realtimefirebasedb.presentation.IMainPresenter;
import com.example.realtimefirebasedb.presentation.MainPresenter;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class ContentViewHolder extends RecyclerView.ViewHolder {
    private IMainPresenter.Presenter presenter;
    private static final String TAG = "ContentViewHolder";
    private RvItemBinding binding;

    public ContentViewHolder(@NonNull View itemView, IMainPresenter.Presenter presenter) {
        super(itemView);
        if (this.presenter == null && presenter != null) this.presenter = presenter;
        binding = DataBindingUtil.bind(itemView);
        if (binding != null) binding.setEvent(presenter);
    }

    @SuppressLint("SetTextI18n")
    public void bind(RTModel item, int position) {
        if (item != null) {
            binding.itemHeader.setText(item.getName());
            binding.itemContent.setText(item.getDescription());
            //Bitmap img = BitmapFactory.;
            //binding.itemImage.setImageBitmap();
        } else {
            Timber.tag(TAG).e("Item is null");
        }
    }
}
