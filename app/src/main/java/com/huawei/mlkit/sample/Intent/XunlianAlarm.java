package com.huawei.mlkit.sample.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.huawei.mlkit.sample.R;


public class XunlianAlarm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //点击左边返回按钮监听事件
        setContentView(R.layout.activity_clock_alarm);
        InitBar();
        super.onCreate(savedInstanceState);
    }
    public void InitBar() {
        Toolbar toolbar =findViewById(R.id.tb_remind);
        toolbar.setTitleTextColor(Color.BLACK);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
