package com.huawei.mlkit.sample.Intent;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.mlkit.sample.R;


public class ShowActivity extends AppCompatActivity {
    VideoView videoView;
    String packageName = getPackageName();
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.guanjie_detail);
    }
}
