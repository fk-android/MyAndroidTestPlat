package com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.os.Parcelable;
import android.view.View;

import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.BaseData;

import io.noties.shareelements.transition.ShareElementInfo;

/**
 * Created by huangwei on 2018/9/27.
 */
public class ShareContentInfo extends ShareElementInfo<BaseData> {

    public ShareContentInfo(@NonNull View view, @Nullable BaseData data) {
        super(view, data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    protected ShareContentInfo(Parcel in) {
        super(in);
    }

    public static final Parcelable.Creator<ShareContentInfo> CREATOR = new Parcelable.Creator<ShareContentInfo>() {
        @Override
        public ShareContentInfo createFromParcel(Parcel source) {
            return new ShareContentInfo(source);
        }

        @Override
        public ShareContentInfo[] newArray(int size) {
            return new ShareContentInfo[size];
        }
    };
}
