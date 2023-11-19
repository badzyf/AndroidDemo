package com.huawei.mlkit.sample.Vedio;

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

public class VedioAdapter extends ArrayAdapter {
    private final int resourceId;
    public VedioAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Vedio> objects, int resourceId) {
        super(context, textViewResourceId, objects);
        this.resourceId = resourceId;
    }
    @Override
    public View getView(int positon, View convertView, ViewGroup parent) {
        Vedio vedio=(Vedio) getItem(positon);   //获取当前项目的Vedio案例；
        View view= LayoutInflater.from(getContext()).inflate(resourceId,null);//实例化一个对象，使用Inflater对象来将布局文件解析成一个View
        ImageView vedioImage=(ImageView) view.findViewById(R.id.vedioimage);//获取该布局内的图片视图
        TextView vedioName=(TextView) view.findViewById(R.id.vediotext);//获取该布局内的文本视图
        vedioImage.setImageResource(vedio.getImageId());//为图片视图设置图片资源
        vedioName.setText(vedio.getName());//为图片视图设置名称资源
        return  view;
    }
}
