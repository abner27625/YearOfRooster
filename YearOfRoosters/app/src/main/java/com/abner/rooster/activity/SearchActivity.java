package com.abner.rooster.activity;

import com.abner.rooster.R;

import butterknife.ButterKnife;

/**
 * Created by heng on 2017/2/10.
 */

public class SearchActivity extends BaseActivity{
    public boolean isLocalSearch = SEARCH_LOCAL;

    public static String SEARCH_TYPE = "search_type";
    public static boolean SEARCH_RESULT = true;
    //判断是在本地还是服务端搜索
    public static boolean SEARCH_REMOTE = false;
    public static boolean SEARCH_LOCAL = true;

    @Override
    public void init() {
        isLocalSearch = getIntent().getBooleanExtra(SEARCH_TYPE,SEARCH_LOCAL);
    }

    @Override
    public void initView() {
        setContentView(R.layout.search_layout);
        ButterKnife.bind(this);

    }
}
