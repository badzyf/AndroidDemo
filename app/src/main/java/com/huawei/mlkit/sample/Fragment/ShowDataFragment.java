package com.huawei.mlkit.sample.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.mlkit.sample.R;
import com.huawei.mlkit.sample.views.graphic.GestureGraphic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 修改时间: 2022/1/26
 * 编写人:  Asus
 * 功能描述:    这个模块区别于个人设置模块的数据统计，这里是“我的数据模块”
 * 备注:
 */
public class ShowDataFragment extends AppCompatActivity {
    public static final int total = 30;       //用来固定训练总数，测定组数
    private String[] Title = {"握拳", "前屈", "后伸", "外展"};
    private int[] Images = {R.mipmap.data_woquan, R.mipmap.data_qianqing, R.mipmap.data_houshen, R.mipmap.data_waizhan};
    /**
     * 这里接收训练传过来的参数，用来计算剩余个数和卫生与组数
     */
    int groups = (total - GestureGraphic.count) / 10;    //剩余组数统计,10是每组个数，后面可以修改
    int remain = (total - GestureGraphic.count);
    ;      //剩余个数
    int remain_group = total / 10 - (GestureGraphic.count) / 10;
    private Object[][] databox = {
            {GestureGraphic.count, GestureGraphic.date, remain, remain_group},
            {23, "2021-1-31 09:31", 12, 4},
            {8, "2021-1-31 11:11", 34, 1},
            {22, "2021-2-1 10:01", 33, 4}
    };
    //将数据封装成数据源
    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //点击左边返回按钮监听事件
        setContentView(R.layout.data_show_layout);
        super.onCreate(savedInstanceState);
        //将数据封装成数据源
        for (int i = 0; i < Title.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("title", Title[i]);
            map.put("img", Images[i]);
            map.put("data_finish", databox[i][0]);
            map.put("data_lasttime", databox[i][1]);
            map.put("data_remaincount", databox[i][2]);
            map.put("data_remaingroup", databox[i][3]);
            list.add(map);
        }
        ListView listview = (ListView) this.findViewById(R.id.listView);
        listview.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder mHolder;
            if (convertView == null) {
                view = LayoutInflater.from(ShowDataFragment.this).inflate(R.layout.data_item, null);
                mHolder = new ViewHolder();
                mHolder.card_title = (TextView) view.findViewById(R.id.cardTitle);
                mHolder.card_image = (ImageView) view.findViewById(R.id.cardImg);
                mHolder.data_finish = (TextView) view.findViewById(R.id.data_finish);
                mHolder.data_lasttime = (TextView) view.findViewById(R.id.data_lasttime);
                mHolder.data_remaincount = (TextView) view.findViewById(R.id.data_remaincount);
                mHolder.data_remaingroup = (TextView) view.findViewById(R.id.data_remaingroup);
                view.setTag(mHolder);  //将ViewHolder存储在View中
            } else {
                view = convertView;
                mHolder = (ViewHolder) view.getTag();  //重新获得ViewHolder
            }
            mHolder.card_title.setText(list.get(position).get("title").toString());
            mHolder.card_image.setImageResource((int) list.get(position).get("img"));
            mHolder.data_finish.setText(list.get(position).get("data_finish").toString());
            mHolder.data_lasttime.setText(list.get(position).get("data_lasttime").toString());
            mHolder.data_remaincount.setText(list.get(position).get("data_remaincount").toString());
            mHolder.data_remaingroup.setText(list.get(position).get("data_remaingroup").toString());
            return view;
        }
    }

    class ViewHolder {
        TextView card_title;
        ImageView card_image;
        //card内容参数： 已完成，最近训练时间，剩余个数，剩余组数
        TextView data_finish;
        TextView data_lasttime;
        TextView data_remaincount;
        TextView data_remaingroup;
    }
}