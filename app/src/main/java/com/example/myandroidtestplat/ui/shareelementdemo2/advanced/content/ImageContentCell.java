package com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import androidx.core.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;
import com.example.myandroidtestplat.R;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.Image;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.viewpager.BasePagerViewHolder;

/**
 * Created by huangwei on 2018/9/20.
 */
public class ImageContentCell extends BaseContentCell<Image> {

    public ImageContentCell(Image image) {
        super(image);
    }

    @Override
    public View getShareElement() {
        return mViewHolder == null ? null : mViewHolder.getView(R.id.content_item_img);
    }

    @Override
    protected BasePagerViewHolder createViewHolder(ViewGroup parent) {
        return createHolderByLayout(R.layout.item_content_image, parent);
    }

    @Override
    protected void onBindViewHolder(BasePagerViewHolder viewHolder) {
        ImageView imageView = viewHolder.getView(R.id.content_item_img);
        ViewCompat.setTransitionName(imageView, mData.url);
        Bitmap thumbnail = mData.url.equals(BitmapThumbnail.sKey)?BitmapThumbnail.sBitmap:null;
        Glide.with(imageView)
                .load(mData.url)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .transform(new FitCenter())
                        .skipMemoryCache(true)
                        .placeholder(thumbnail == null ? new ColorDrawable(Color.GRAY) : new BitmapDrawable(imageView.getResources(), thumbnail)))
                .into(imageView);
    }


    @Override
    protected int getType() {
        return 0;
    }
}
