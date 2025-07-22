package com.example.myandroidtestplat.ui.bottomsheet.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myandroidtestplat.R;


public class BottomSheetMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        findViewById(R.id.picker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetMainActivity.this, PickerActivity.class));
            }
        });

        findViewById(R.id.menu_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetMainActivity.this, MenuActivity.class));
            }
        });

        findViewById(R.id.image_picker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetMainActivity.this, ImagePickerActivity.class));
            }
        });

        findViewById(R.id.bottomsheet_fragment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BottomSheetMainActivity.this, BottomSheetFragmentActivity.class));
            }
        });
    }
}
