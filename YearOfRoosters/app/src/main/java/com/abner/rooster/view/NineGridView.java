package com.abner.rooster.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by heng on 2017/2/14.
 */

public class NineGridView<T> extends ViewGroup{
    public final static int STYLE_GRID = 0;     // 宫格布局
    public final static int STYLE_FILL = 1;     // 全填充布局

    private int mRowCount;       // 行数
    private int mColumnCount;    // 列数

    private int mMaxSize;        // 最大图片数
    private int mShowStyle;     // 显示风格
    private int mGap;           // 宫格间距
    private int mSingleImgSize; // 单张图片时的尺寸
    private int mGridSize; // 宫格大小,即图片大小

    private List<ImageView> mImageViewList = new ArrayList<>();
    private List<T> mImgDataList;

    private NineGridViewAdapter mAdapter;

    public NineGridView(Context context) {
        this(context,null);
    }

    public NineGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
       /* TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.NineGridView);
        this.mGap = (int) typedArray.getDimension(R.styleable.NineGridView_imgGap,0);
        this.mMaxSize = (int) typedArray.getDimension(R.styleable.NineGridView_maxSize,-1);
        this.mShowStyle = typedArray.getInt(R.styleable.NineGridView_showStyle,STYLE_GRID);
        this.mSingleImgSize = typedArray.getInt(R.styleable.NineGridView_singleImgSize,9);
        typedArray.recycle();*/
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height;
        int totalWidth = width - getPaddingLeft() - getPaddingRight();
        if (mImgDataList != null && mImgDataList.size() > 0) {
            if (mImgDataList.size() == 1 && mSingleImgSize != -1) {
                mGridSize = mSingleImgSize > totalWidth ? totalWidth : mSingleImgSize;
            } else {
                mImageViewList.get(0).setScaleType(ImageView.ScaleType.CENTER_CROP);
                mGridSize = (totalWidth - mGap * (mColumnCount - 1)) / mColumnCount;
            }
            height = mGridSize * mRowCount + mGap * (mRowCount - 1) + getPaddingTop() + getPaddingBottom();
            setMeasuredDimension(width, height);
        } else {
            height = width;
            setMeasuredDimension(width, height);
        }
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        layoutChild();
    }

    public void layoutChild() {
        if(mImgDataList == null){
            return;
        }
        int showImageCount = showImageSize(mImageViewList.size());
        for(int i = 0; i< showImageCount;i++){
            ImageView childrenView = (ImageView) getChildAt(i);
            if (mAdapter != null) {
                mAdapter.displayImage(getContext(), childrenView, mImgDataList.get(i));
            }
            int rowNum = i / mColumnCount;
            int columnNum = i % mColumnCount;
            int left = (mGridSize + mGap) * columnNum + getPaddingLeft();
            int top = (mGridSize + mGap) * rowNum + getPaddingTop();
            int right = left + mGridSize;
            int bottom = top + mGridSize;

            childrenView.layout(left, top, right, bottom);
        }
    }
    /**
     * 展示图片数量
     * */
    public int showImageSize(int size){
        if(mMaxSize < 0 && size > mMaxSize){
            return mMaxSize;
        }else{
            return size;
        }
    }

    public void setImageData(List list){
        if(list == null || list.isEmpty()){
            this.setVisibility(View.GONE);
            return;
        }else{
            this.setVisibility(View.VISIBLE);
        }
        int newShowCount = showImageSize(list.size());

        int[] gridParam = calculate(newShowCount);
        mRowCount = gridParam[0];
        mColumnCount = gridParam[1];
        if (mImgDataList == null) {
            int i = 0;
            while (i < newShowCount) {
                ImageView iv = getImageView(i);
                if (iv == null) {
                    return;
                }
                addView(iv, generateDefaultLayoutParams());
                i++;
            }
        } else {
            int oldShowCount = showImageSize(mImgDataList.size());
            if (oldShowCount > newShowCount) {
                removeViews(newShowCount, oldShowCount - newShowCount);
            } else if (oldShowCount < newShowCount) {
                for (int i = oldShowCount; i < newShowCount; i++) {
                    ImageView iv = getImageView(i);
                    if (iv == null) {
                        return;
                    }
                    addView(iv, generateDefaultLayoutParams());
                }
            }
        }
        mImgDataList = list;
        requestLayout();
    }

    private ImageView getImageView(final int position) {
        if (position < mImageViewList.size()) {
            return mImageViewList.get(position);
        }else{
            return null;
        }
    }

    /**
    * gridParam[0]行数  gridParam[1]列数
    * */
    public int[] calculate(int size){
        int[] gridParam = new int[2];
        if(size < 3){
            gridParam[0] = 1;
            gridParam[1] = size;
        }else if(size <=4){
            gridParam[0] = 2;
            gridParam[1] = 2;
        }else{
            gridParam[0] = 3;
            gridParam[1] = size/3 + (size % 3 == 0 ? 0 : 1);
        }
        return gridParam;
    }

    public void setmGap(int gap){
        mGap = gap;
    }
}
