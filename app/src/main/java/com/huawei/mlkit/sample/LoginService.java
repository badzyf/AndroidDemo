package com.huawei.mlkit.sample;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.mlkit.sample.Fragment.Search_Fragment;

public class LoginService extends AppCompatActivity {
    Button login_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login_button=findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("登录","草蘑翁佛");
                Intent intent =new Intent(LoginService.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    /*登录页面的跳转*/
}