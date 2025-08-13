package com.example.myandroidtestplat.ui.shareelementdemo2.advanced;

import android.graphics.Rect;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

/**
 * Created by huangwei on 2018/9/19 0019.
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private int mSpace;

    public SpaceItemDecoration(int space) {
        mSpace = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        lp.topMargin = mSpace/2;
        lp.leftMargin = mSpace/2;
        lp.rightMargin = mSpace/2;
        lp.bottomMargin = mSpace/2;
    }
}
