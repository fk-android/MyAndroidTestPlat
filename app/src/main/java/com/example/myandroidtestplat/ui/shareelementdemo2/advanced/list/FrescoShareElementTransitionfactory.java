package com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list;

import android.transition.TransitionSet;
import android.view.View;

import java.util.List;

import io.noties.shareelements.transition.DefaultShareElementTransitionFactory;

/**
 * Created by huangwei on 2018/10/5.
 */
public class FrescoShareElementTransitionfactory extends DefaultShareElementTransitionFactory {

    @Override
    protected TransitionSet buildShareElementsTransition(List<View> shareViewList) {
        TransitionSet transitionSet =  super.buildShareElementsTransition(shareViewList);
        transitionSet.addTransition(new AdvancedDraweeTransition());
        return transitionSet;
    }
}
