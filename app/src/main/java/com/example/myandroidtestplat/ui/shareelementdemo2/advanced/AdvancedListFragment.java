package com.example.myandroidtestplat.ui.shareelementdemo2.advanced;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myandroidtestplat.R;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.content.BitmapThumbnail;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list.AdvancedListAdapter;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list.BaseListCell;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list.ImageFrescoListCell;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list.ImageListCell;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list.ShareContentInfo;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.list.VideoListCell;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import io.noties.shareelements.YcShareElement;
import io.noties.shareelements.transition.IShareElements;
import io.noties.shareelements.transition.ShareElementInfo;

/**
 * Created by huangwei on 2018/9/18 0018.
 */
public class AdvancedListFragment extends Fragment implements BaseListCell.OnCellClickListener, IShareElements {
    public static final String KEY_DATA = "data";
    public static final String KEY_SELECT = "select";

    static final int REQUEST_CONTENT = 223;

    private RecyclerView mRecyclerView;
    private AdvancedListAdapter mAdapter;
    private ArrayList<Parcelable> mDataList = new ArrayList<>();
    private BaseListCell mTransitionCell;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setBackgroundColor(0xFF323232);
        mAdapter = new AdvancedListAdapter();
        mRecyclerView.setAdapter(mAdapter);
        int divider = getResources().getDimensionPixelSize(R.dimen.divider);
        mRecyclerView.setPadding(divider/2,divider/2,divider/2,divider/2);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);

        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addItemDecoration(new SpaceItemDecoration(divider));
        initCells();
    }

    private void initCells() {
        List<BaseListCell> cellList = new LinkedList<>();
        mDataList.add(new Image("https://bpic.588ku.com/element_origin_min_pic/23/07/11/d32dabe266d10da8b21bd640a2e9b611.jpg!r650", 1024, 738).setShowInFresco(true));
        mDataList.add(new Image("https://ts1.tc.mm.bing.net/th/id/R-C.987f582c510be58755c4933cda68d525?rik=C0D21hJDYvXosw&riu=http%3a%2f%2fimg.pconline.com.cn%2fimages%2fupload%2fupc%2ftx%2fwallpaper%2f1305%2f16%2fc4%2f20990657_1368686545122.jpg&ehk=netN2qzcCVS4ALUQfDOwxAwFcy41oxC%2b0xTFvOYy5ds%3d&risl=&pid=ImgRaw&r=0", 1280, 800));
        mDataList.add(new Video("https://ts3.tc.mm.bing.net/th/id/OIP-C.g9UbVfyVZX-SfD09JcYr5QHaEK?rs=1&pid=ImgDetMain",
                "https://ts1.tc.mm.bing.net/th/id/R-C.32af73b7aea55367e4a3f8763961c894?rik=QUOZ37Lf%2bE7rbw&riu=http%3a%2f%2fimg95.699pic.com%2fphoto%2f50064%2f7148.jpg_wh860.jpg&ehk=00VUYvoTnuinFTJXQYbpLwh3e%2bLPJE9vL7h5ELm0avA%3d&risl=&pid=ImgRaw&r=0",
                720, 1280));
        mDataList.add(new Image("https://phototask.c360dn.com/Fo9D8NQqmbs3AAQASxnkPZRHF5Hv", 720, 1280));
        mDataList.add(new Video("https://phototask.c360dn.com/lm7F9EhP3DVTVtMqOD6rkx7w6TwW",
                "https://phototask.c360dn.com/lm7F9EhP3DVTVtMqOD6rkx7w6TwW-2018040715-preview.webp",
                640, 1138));
        mDataList.add(new Image("https://phototask.c360dn.com/FhGeGKwB9Z6WvuaINQOuc7wm4vvj", 1600, 1280));
        mDataList.add(new Video("https://phototask.c360dn.com/lqYmdnp4cWoz35jp8BTSPXIXfq9s",
                "https://phototask.c360dn.com/lqYmdnp4cWoz35jp8BTSPXIXfq9s-2018082319-preview.webp",
                640, 854));
        mDataList.add(new Image("https://phototask.c360dn.com/Fn8kpRh_rarrSMIoEnnEPadNOuWi", 720, 1280));

        mDataList.add(new Video("https://phototask.c360dn.com/lpNwvBcfABEhJVfEkUvPfPRvA7KF",
                "https://phototask.c360dn.com/lpNwvBcfABEhJVfEkUvPfPRvA7KF-2018082620-preview.webp",
                640, 1138));
        mDataList.add(new Image("https://phototask.c360dn.com/Fn3915H5n7AhYKJdpdlNjSbfPC5e", 1024, 640));
        mDataList.add(new Video("https://phototask.c360dn.com/luqJVmntp51TIcdzGJviz0erj9l9",
                "https://phototask.c360dn.com/luqJVmntp51TIcdzGJviz0erj9l9-2018090108-preview.webp",
                640, 1138));
        mDataList.add(new Image("https://phototask.c360dn.com/FsOmrix9LiKJXKqi4vOU7fbUmlbQ", 1080, 960));

        for (Parcelable data : mDataList) {
            BaseListCell cell = data instanceof Image ?
                    (((Image) data).isShowInFresco()?new ImageFrescoListCell((Image)data):new ImageListCell((Image) data))
                    : new VideoListCell((Video) data);
            cell.setOnCellClickListener(this);
            cellList.add(cell);
        }
        mAdapter.setList(cellList);
    }

    @Override
    public void onCellClick(BaseListCell cell) {
        mTransitionCell = cell;
        Intent intent = new Intent(getActivity(), AdvancedContentActivity.class);
        intent.putParcelableArrayListExtra(KEY_DATA, mDataList);
        intent.putExtra(KEY_SELECT, mDataList.indexOf(cell.getData()));
        Bitmap thumbnail = mTransitionCell.getThumbnail();
        if(thumbnail!=null) {
            BitmapThumbnail.sBitmap = thumbnail;
            BitmapThumbnail.sKey = mTransitionCell.getData().url;
        }
        Bundle options = YcShareElement.buildOptionsBundle(getActivity(), this);
        startActivityForResult(intent, REQUEST_CONTENT, options);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        for (int i = 0; i < mAdapter.getItemCount(); i++) {
            BaseListCell cell = (BaseListCell) mAdapter.getItem(i);
            cell.setOnCellClickListener(null);
        }
    }

    @Override
    public ShareElementInfo[] getShareElements() {
        if (mTransitionCell instanceof VideoListCell) {
            BaseData data = mTransitionCell.getData();
            ShareElementInfo info = new ShareContentInfo(mTransitionCell.getShareElement(), data);
            return new ShareElementInfo[]{info};
        } else if (mTransitionCell instanceof ImageListCell) {
            BaseData data = mTransitionCell.getData();
            ShareElementInfo info;
            if(mTransitionCell instanceof ImageFrescoListCell){
                info = new ShareElementInfo(mTransitionCell.getShareElement(), data, new FrescoViewStateSaver());
            }else{
                info = new ShareContentInfo(mTransitionCell.getShareElement(), data);
            }
            return new ShareElementInfo[]{info};
        }
        return new ShareElementInfo[0];
    }

    public void selectShareElement(ShareElementInfo shareElementInfo) {
        BaseData data = (BaseData) shareElementInfo.getData();
        for (int i = 0; i < mAdapter.getItemCount(); i++) {
            BaseListCell cell = mAdapter.getItem(i);
            if (cell.getData().equals(data)) {
                mTransitionCell = cell;
                GridLayoutManager layoutManager = (GridLayoutManager) mRecyclerView.getLayoutManager();
                layoutManager.scrollToPosition(i);
                return;
            }
        }

    }
}
