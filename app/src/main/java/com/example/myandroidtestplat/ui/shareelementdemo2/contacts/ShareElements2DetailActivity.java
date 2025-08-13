package com.example.myandroidtestplat.ui.shareelementdemo2.contacts;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myandroidtestplat.R;

import io.noties.shareelements.YcShareElement;
import io.noties.shareelements.transition.IShareElements;
import io.noties.shareelements.transition.ShareElementInfo;
import io.noties.shareelements.transition.TextViewStateSaver;


/**
 * Created by huangwei on 2018/10/6.
 */
public class ShareElements2DetailActivity extends Activity {

    private ImageView mAvatarImg;
    private TextView mNameTxt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mAvatarImg = findViewById(R.id.avatar);
        mNameTxt = findViewById(R.id.name);
        setData();

        YcShareElement.setEnterTransitions(this, new IShareElements() {
            @Override
            public ShareElementInfo[] getShareElements() {
                return new ShareElementInfo[]{new ShareElementInfo(mAvatarImg),
                        new ShareElementInfo(mNameTxt, new TextViewStateSaver())};
            }
        },false);
//        YcShareElement.startTransition(this);
    }

    private void setData(){
        TextView descTxt = findViewById(R.id.desc);
        Contacts item = getIntent().getParcelableExtra(ContactsActivity.KEY_CONTACTS);
        Glide.with(mAvatarImg).load(item.avatarRes).apply(RequestOptions.circleCropTransform()).into(mAvatarImg);
        mNameTxt.setText(item.name);
        descTxt.setText(item.desc);

        ViewCompat.setTransitionName(mAvatarImg,"avatar:"+item.name);
        ViewCompat.setTransitionName(mNameTxt,"name:"+item.name);
    }
}
