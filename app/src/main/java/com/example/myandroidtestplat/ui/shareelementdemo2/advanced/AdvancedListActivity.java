package com.example.myandroidtestplat.ui.shareelementdemo2.advanced;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidtestplat.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import io.noties.shareelements.YcShareElement;
import io.noties.shareelements.transition.IShareElementSelector;
import io.noties.shareelements.transition.ShareElementInfo;

/**
 * Created by huangwei on 2018/9/18 0018.
 */
public class AdvancedListActivity extends AppCompatActivity {
    private AdvancedListFragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        YcShareElement.enableContentTransition(getApplication());
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_simple);
        mFragment = new AdvancedListFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.simple_container, mFragment).commit();
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);

        // 触发共享元素转场动画的重入准备
        supportPostponeEnterTransition(); // 延迟转场，等待数据更新完成

        YcShareElement.onActivityReenter(this, resultCode, data, new IShareElementSelector() {
            @Override
            public void selectShareElements(List<ShareElementInfo> list) {
                mFragment.selectShareElement(list.get(0));
            }
        });
    }
}
