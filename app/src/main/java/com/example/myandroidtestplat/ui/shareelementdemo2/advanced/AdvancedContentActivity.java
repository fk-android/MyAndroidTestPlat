package com.example.myandroidtestplat.ui.shareelementdemo2.advanced;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidtestplat.R;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list.FrescoShareElementTransitionfactory;

import io.noties.shareelements.YcShareElement;
import io.noties.shareelements.transition.IShareElements;
import io.noties.shareelements.transition.ShareElementInfo;

/**
 * Created by huangwei on 2018/9/18 0018.
 */
public class AdvancedContentActivity extends AppCompatActivity implements IShareElements {

    AdvancedContentFragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        YcShareElement.setEnterTransitions(this, this,true,new FrescoShareElementTransitionfactory());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        getWindow().setBackgroundDrawable(new ColorDrawable(0xFF323232));
        mFragment = new AdvancedContentFragment();
        mFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.simple_container, mFragment).commit();
    }

    @Override
    public void finishAfterTransition() {
        YcShareElement.finishAfterTransition(this, this);
        super.finishAfterTransition();
    }

    @Override
    public ShareElementInfo[] getShareElements() {
        return mFragment.getShareElements();
    }
}
