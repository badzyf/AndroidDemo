package com.huawei.mlkit.sample.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.drawerlayout.widget.DrawerLayout;

import com.huawei.mlkit.sample.activity.getsture.Gesture2Activity;
import com.huawei.mlkit.sample.R;
import com.huawei.mlkit.sample.activity.skeleton.HumanSkeletonActivity;

public class XunlianFragment extends Fragment {
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private Button bu_1;
    private Button bu_2;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View xunlian_layout = inflater.inflate(R.layout.xunlian, container, false);
        //toolbar初始化
        //这里要谨慎记， 不能直接R.color.white.
       // xunlian_title.setTitleTextColor( getResources().getColor(R.color.white));
        bu_1=xunlian_layout.findViewById(R.id.bu_1);
        bu_2=xunlian_layout.findViewById(R.id.bu_2);
        bu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Gesture2Activity.class);
                startActivity(intent);
            }
        });
        bu_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HumanSkeletonActivity.class);
                startActivity(intent);
            }
        });
        return xunlian_layout;
    }
}
