package com.example.myandroidtestplat.ui.bottomsheet.sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.myandroidtestplat.R;
import com.flipboard.bottomsheet.commons.BottomSheetFragment;


public class MyFragment extends BottomSheetFragment {
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my, container, false);
    }
}
