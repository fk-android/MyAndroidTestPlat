package com.example.myandroidtestplat.ui.shareelementdemo2.advanced;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.BaseContentCell;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.BitmapThumbnail;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.ImageContentCell;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.ImageFrescoContentCell;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.VideoContentCell;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.viewpager.BasePagerAdapter;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import java.util.ArrayList;
import java.util.List;

import io.noties.shareelements.YcShareElement;
import io.noties.shareelements.transition.ShareElementInfo;

/**
 * Created by huangwei on 2018/9/18 0018.
 */
public class AdvancedContentFragment extends Fragment implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private BasePagerAdapter mAdapter;
    private VideoContentCell mPlayingCell;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new ViewPager(container.getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = (ViewPager) view;
        mAdapter = new BasePagerAdapter();
        mViewPager.addOnPageChangeListener(this);
        initCells();
        YcShareElement.postStartTransition(getActivity());
    }

    private void initCells() {
        ArrayList<Parcelable> dataList = getArguments().getParcelableArrayList(AdvancedListFragment.KEY_DATA);
        int select = getArguments().getInt(AdvancedListFragment.KEY_SELECT, 0);
        List<BaseContentCell> cellList = new ArrayList<>(dataList.size());
        for (int i = 0; i < dataList.size(); i++) {
            Parcelable data = dataList.get(i);
            if (data instanceof Image) {
                BaseContentCell contentCell = ((Image) data).isShowInFresco() ? new ImageFrescoContentCell((Image) data) : new ImageContentCell((Image) data);
                cellList.add(contentCell);
            } else if (data instanceof Video) {
                cellList.add(new VideoContentCell((Video) data));
            }
        }
        mAdapter.addItems(cellList);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(select);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (mPlayingCell != null) {
            try {
                GSYVideoManager.instance().stop();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        if (mAdapter.getItem(position) instanceof VideoContentCell) {
            mPlayingCell = ((VideoContentCell) mAdapter.getItem(position));
            mPlayingCell.startPlay();
        } else {
            mPlayingCell = null;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPause() {
        if (mPlayingCell != null) {
            GSYVideoManager.instance().pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        if (mPlayingCell != null) {
            GSYVideoManager.instance().start();
        }
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public ShareElementInfo[] getShareElements() {
        BaseContentCell item = (BaseContentCell) mAdapter.getItem(mViewPager.getCurrentItem());
        if (item != null) {
            BaseData baseData = (BaseData) item.getData();
            if (item instanceof ImageFrescoContentCell) {
                ShareElementInfo info = new ShareElementInfo(item.getShareElement(), baseData, new FrescoViewStateSaver());
                return new ShareElementInfo[]{info};
            } else {
                return new ShareElementInfo[]{new ShareElementInfo(item.getShareElement(), baseData)};
            }
        }
        return new ShareElementInfo[0];
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        BitmapThumbnail.clear();
    }
}
