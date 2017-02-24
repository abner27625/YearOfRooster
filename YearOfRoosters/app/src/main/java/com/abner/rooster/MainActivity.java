package com.abner.rooster;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;

import com.abner.rooster.activity.BaseActivity;
import com.abner.rooster.activity.SearchActivity;
import com.abner.rooster.adapter.MainAdapter;
import com.abner.rooster.fragment.AddressListFragment;
import com.abner.rooster.fragment.BaseFragment;
import com.abner.rooster.fragment.FriendFragment;
import com.abner.rooster.fragment.MineFragment;
import com.abner.rooster.fragment.WechatFragment;
import com.abner.rooster.utils.PopupWindowFactory;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.main_viewpager)
    ViewPager main_viewpager;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.bottombar)
    BottomBar bottomBar;

    @BindView(R.id.tab_wechat)
    BottomBarTab tab_wechat;
    @BindView(R.id.tab_address_list)
    BottomBarTab tab_address_list;
    @BindView(R.id.tab_mine)
    BottomBarTab tab_mine;
    @BindView(R.id.tab_friends)
    BottomBarTab tab_friends;

    List<BaseFragment> fragments = new ArrayList<>();
    WechatFragment wechatFragment;
    MineFragment mineFragment;
    FriendFragment friendFragment;
    AddressListFragment addressListFragment;

    PopupWindow popupwindow;

    @Override
    public void initView(){
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
    }

    @Override
    public void init() {
        super.init();
    }

    public void initToolbar() {
        //设置ToolBar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("微信");
        mToolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    public void initData() {
        wechatFragment = new WechatFragment();
        mineFragment = new MineFragment();
        friendFragment = new FriendFragment();
        addressListFragment = new AddressListFragment();

        fragments.add(wechatFragment);
        fragments.add(addressListFragment);
        fragments.add(friendFragment);
        fragments.add(mineFragment);

        main_viewpager.setAdapter(new MainAdapter(getSupportFragmentManager(),fragments));
        main_viewpager.setCurrentItem(0);
    }

    @Override
    public void initListener() {
        super.initListener();

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId){
                    case R.id.tab_wechat:
                        main_viewpager.setCurrentItem(0,false);
                        break;
                    case R.id.tab_address_list:
                        main_viewpager.setCurrentItem(1,false);
                        break;
                    case R.id.tab_friends:
                        main_viewpager.setCurrentItem(2,false);
                        break;
                    case R.id.tab_mine:
                        main_viewpager.setCurrentItem(3,false);
                        break;
                }
            }
        });

        main_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position){
                    case 0:
                        main_viewpager.setCurrentItem(0);
                        break;
                    case 1:
                        main_viewpager.setCurrentItem(1);
                        break;
                    case 2:
                        main_viewpager.setCurrentItem(2);
                        break;
                    case 3:
                        main_viewpager.setCurrentItem(3);
                        break;
                }
            }
            @Override
            public void onPageSelected(int position) {
                fragments.get(position).initData();
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSearch:
                Intent intent = new Intent(this, SearchActivity.class);
                intent.putExtra(SearchActivity.SEARCH_TYPE,SearchActivity.SEARCH_RESULT);
                startActivity(intent);
                break;
            case R.id.itemMore:
                showMenu();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showMenu() {
        View view = LayoutInflater.from(this).inflate(R.layout.popup_menu_main,null);
        view.findViewById(R.id.itemCreateGroupCheat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/2/10  发起群聊
                Log.i("abner::::::::::","-------------------》    发起群聊");
            }
        });
        view.findViewById(R.id.itemAddFriend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/2/10  添加朋友
                Log.i("abner::::::::::","-------------------》    添加朋友");
            }
        });
        view.findViewById(R.id.itemScan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/2/10  扫一扫
                Log.i("abner::::::::::","-------------------》    扫一扫");
            }
        });
        view.findViewById(R.id.itemPaymentReceived).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/2/10  收付款
                Log.i("abner::::::::::","-------------------》    收付款");
            }
        });
        view.findViewById(R.id.itemHelpAndFeedback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 2017/2/10  帮助与反馈
                Log.i("abner::::::::::","-------------------》    帮助与反馈");
            }
        });
        popupwindow = PopupWindowFactory.getPopupWindowAtLocation(view,main_viewpager, Gravity.TOP|Gravity.RIGHT,18,mToolbar.getHeight() + getStatusBarHeight());
    }

}
