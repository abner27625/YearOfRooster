package com.abner.rooster.utils;

import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by heng on 2017/2/13.
 */

public class PopupWindowFactory {

    @NonNull
    private static PopupWindow getPopupWindow(View contentView, int width, int height) {
        PopupWindow popupWindow = new PopupWindow(contentView, width, height, true);
        popupWindow.setOutsideTouchable(false);
        openOutsideTouchable(popupWindow);
        return popupWindow;
    }

    /**
     * 点击popupwindow范围以外的地方时隐藏
     */
    public static void openOutsideTouchable(PopupWindow popupWindow) {
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
    }

    public static PopupWindow getPopupWindowAtLocation(View contentView, View parentView, int gravityType, int xoff, int yoff) {
        return getPopupWindowAtLocation(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, parentView, gravityType, xoff, yoff);
    }

    public static PopupWindow getPopupWindowAtLocation(View contentView, int width, int height, View parentView, int gravityType,int xoff,int yoff ){
        PopupWindow popupWindow = getPopupWindow(contentView,width,height);
        //在parentView中偏移xoff和yoff
        popupWindow.showAtLocation(parentView,gravityType, xoff, yoff);
        return popupWindow;
    }

}
