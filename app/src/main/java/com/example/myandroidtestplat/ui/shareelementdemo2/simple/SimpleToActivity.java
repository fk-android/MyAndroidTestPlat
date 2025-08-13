package com.example.myandroidtestplat.ui.shareelementdemo2.simple;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;
import com.example.myandroidtestplat.R;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.BaseData;

import io.noties.shareelements.YcShareElement;
import io.noties.shareelements.transition.IShareElements;
import io.noties.shareelements.transition.ShareElementInfo;

/**
 * Created by huangwei on 2018/9/18 0018.
 */
public class SimpleToActivity extends AppCompatActivity implements IShareElements {

    private ImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        YcShareElement.setEnterTransitions(this, this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to);
        mImageView = findViewById(R.id.s2_img);
        Glide.with(this)
                .load(R.drawable.test)
                .apply(new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .transform(new FitCenter())
                        .placeholder(new ColorDrawable(Color.GRAY)))
                .into(mImageView);
        YcShareElement.postStartTransition(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public ShareElementInfo[] getShareElements() {
        return new ShareElementInfo[]{new ShareElementInfo(mImageView, new BaseData(null, 1024, 768))};
    }
}
