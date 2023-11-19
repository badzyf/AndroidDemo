package com.huawei.mlkit.sample.PersonInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.huawei.mlkit.sample.R;

import java.util.List;

class PersonInfoAdapter extends ArrayAdapter {
    private final int resourceId;
    public PersonInfoAdapter(@NonNull Context context, int textViewResourceId, List<PersonInfo> person_info, int resourceId) {
        super(context, textViewResourceId, person_info);
        this.resourceId = resourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonInfo personInfo = (PersonInfo) getItem(position);//获取当前setting实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);     //实例化对象
        ImageView person_image=(ImageView) view.findViewById(R.id.setting_image);//获取该布局内的图片视图
        TextView person_name=(TextView) view.findViewById(R.id.setting_name);//获取该布局内的文本视图
      //  person_image.setImageResource(personInfo.getImageId());//为图片视图设置图片资源
        person_name.setText(personInfo.getName());//为图片视图设置名称资源
        return  view;
    }
}