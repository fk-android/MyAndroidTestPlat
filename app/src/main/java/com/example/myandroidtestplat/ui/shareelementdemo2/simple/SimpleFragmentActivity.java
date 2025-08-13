package com.example.myandroidtestplat.ui.shareelementdemo2.simple;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidtestplat.R;

import io.noties.shareelements.TransitionHelper;

/**
 * Created by huangwei on 2018/9/18 0018.
 */
public class SimpleFragmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TransitionHelper.enableTransition(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        getSupportFragmentManager().beginTransaction().add(R.id.simple_container, new Simple1Fragment()).commit();
    }
}
