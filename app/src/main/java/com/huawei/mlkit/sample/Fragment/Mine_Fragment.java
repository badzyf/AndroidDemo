package com.huawei.mlkit.sample.Fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.huawei.mlkit.sample.AlarmService.AlarmingService;
import com.huawei.mlkit.sample.LoginService;
import com.huawei.mlkit.sample.PersonInfo.PersonInfoActivity;
import com.huawei.mlkit.sample.R;

/**
 * @date: 2022/1/26
 * @author: Asus
 * @Description 底部导航栏：个人主页模块
 */
public class Mine_Fragment extends Fragment {
    private Button bt;                  //退出登录按钮
    public TextView xunlian_alarm;      //训练提醒
    public TextView tv_info;        //个人信息设置模块
    public TextView data_static; //训练数据统计，Echarts报表格式

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mine_layout = inflater.inflate(R.layout.mine_layout, container, false);
        //退出登录按钮响应事件
        bt = mine_layout.findViewById(R.id.logout);
        //个人信息设置响应模块
        tv_info = mine_layout.findViewById(R.id.tv_info);
        xunlian_alarm = mine_layout.findViewById(R.id.remind);
        data_static = mine_layout.findViewById(R.id.data_static);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginService.class);
                startActivity(intent);
            }
        });
        xunlian_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AlarmingService.class);
                startActivity(intent);
            }
        });
        tv_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PersonInfoActivity.class);
                startActivity(intent);
            }
        });
        data_static.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShowDataFragment.class);
                startActivity(intent);
            }
        });
        return mine_layout;
    }
}
