package com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content;

import android.view.View;

import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.BaseData;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.viewpager.BasePagerCell;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.viewpager.BasePagerViewHolder;

/**
 * Created by huangwei on 2018/9/20.
 */
public abstract class BaseContentCell<DATA extends BaseData> extends BasePagerCell<DATA , BasePagerViewHolder> {
    public BaseContentCell(DATA data) {
        super(data);
    }

    public abstract View getShareElement();
}
