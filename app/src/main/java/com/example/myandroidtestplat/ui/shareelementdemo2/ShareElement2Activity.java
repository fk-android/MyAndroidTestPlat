package com.example.myandroidtestplat.ui.shareelementdemo2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myandroidtestplat.R;
import com.example.myandroidtestplat.ui.shareelementdemo2.advanced.AdvancedListActivity;
import com.example.myandroidtestplat.ui.shareelementdemo2.contacts.ContactsActivity;

import io.noties.shareelements.YcShareElement;

public class ShareElement2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        YcShareElement.enableContentTransition(getApplication());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shareelement_main);

//        findViewById(R.id.simple_fragment_btn).setOnClickListener(this);
        Button contacts=findViewById(R.id.simple_activity_btn);
                contacts.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(ShareElement2Activity.this, ContactsActivity.class));
                    }
                });
        Button video=findViewById(R.id.recyclerview_btn);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareElement2Activity.this, AdvancedListActivity.class));
            }
        });

        Button other=findViewById(R.id.simple_fragment_btn);
        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShareElement2Activity.this, AdvancedListActivity.class));
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.simple_fragment_btn:
//                startActivity(new Intent(this, SimpleFragmentActivity.class));
//                break;
//            case R.id.simple_activity_btn:
//                startActivity(new Intent(this, ContactsActivity.class));
//                break;
//            case R.id.recyclerview_btn:
//                startActivity(new Intent(this, AdvancedListActivity.class));
//                break;
        }
    }
}
