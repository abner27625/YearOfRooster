package com.abner.rooster.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.abner.rooster.R;

import butterknife.ButterKnife;

/**
 * Created by heng on 2017/2/10.
 */

public class MineFragment extends BaseFragment{
    private View view;
    @Override
    public View initView() {
        view = LayoutInflater.from(getContext()).inflate(R.layout.test,null);
        ButterKnife.bind(this,view);
        return view;
    }
}
