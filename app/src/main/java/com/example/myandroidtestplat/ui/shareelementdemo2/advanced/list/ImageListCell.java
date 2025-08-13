package com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;
import com.example.myandroidtestplat.R;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.Image;

/**
 * Created by huangwei on 2018/9/19 0019.
 */
public class ImageListCell extends BaseListCell<Image, RecyclerView.ViewHolder> {

    public ImageListCell(Image image) {
        super(image);
    }

    @Override
    protected void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        ImageView imageView = holder.itemView.findViewById(R.id.list_item_img);
        ViewCompat.setTransitionName(imageView, mData.url);
        setSize(holder.itemView);

        Glide.with(imageView)
                .load(mData.url)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .transform(new FitCenter())
                        .placeholder(new ColorDrawable(Color.GRAY)))
                .into(imageView);
    }

    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_image, parent, false);
        return new BaseViewHolder(view);
    }

    protected void setSize(View view) {
        int width = (view.getResources().getDisplayMetrics().widthPixels -
                view.getResources().getDimensionPixelSize(R.dimen.divider) * 2) / 2;
        int height = width;//(int) (mData.height / (float) mData.width * width);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

    @Override
    protected int getType() {
        return 0;
    }

    @Override
    public View getShareElement() {
        return mViewHolder.itemView.findViewById(R.id.list_item_img);
    }

    @Override
    public Bitmap getThumbnail() {
        if (mViewHolder == null || mViewHolder.itemView == null) {
            return null;
        }
        ImageView imageView = mViewHolder.itemView.findViewById(R.id.list_item_img);
        if (imageView.getDrawable() instanceof BitmapDrawable) {
            return ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        }
        return null;
    }
}
