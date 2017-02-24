package com.abner.rooster.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;


/**
 * Created by heng on 2017/2/14.
 */

public class NineGridViewAdapter<T> extends BaseQuickAdapter {

    public NineGridViewAdapter(List data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    public void displayImage(Context context, ImageView imageView,T t){

    }
}
