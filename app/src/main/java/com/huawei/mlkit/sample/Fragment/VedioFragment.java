package com.huawei.mlkit.sample.Fragment;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import com.huawei.mlkit.sample.R;
import com.huawei.mlkit.sample.Vedio.Vedio;
import com.huawei.mlkit.sample.Vedio.VedioPlayer;
import java.util.ArrayList;
public class VedioFragment extends Fragment {
    public ListView listView;
    public  Toolbar vedio_title;
    public String[] data = {"腘绳肌等长收缩", "手部肌张力训练", "关节康复训练", "仰卧位屈髋屈膝训练",
            "下肢抗阻训练", "站立及步行训练", "半蹲及深蹲训练", "半蹲侧向移动训练", "半圆球俯卧训练", "臀桥训练"};
    public String[] url = {
            "https://vd2.bdstatic.com/mda-mgq6yqfuwgnvm6g1/sc/cae_h264/1627189535164561681/mda-mgq6yqfuwgnvm6g1.mp4",
            "https://vd2.bdstatic.com/mda-kkffcfbp8r0xs32i/hd/mda-kkffcfbp8r0xs32i.mp4",
            "https://vd4.bdstatic.com/mda-mavnuxheucqfxqhb/sc/cae_h264_nowatermark/1612247393/mda-mavnuxheucqfxqhb.mp4",
            "https://vd3.bdstatic.com/mda-mi2gyya1d9de1r2u/sc/cae_h264_nowatermark/1630671308399813945/mda-mi2gyya1d9de1r2u.mp4",
            "https://vd4.bdstatic.com/mda-mjfdejb3bq09er1n/sc/cae_h264_nowatermark/1634376752865553888/mda-mjfdejb3bq09er1n.mp4",
            "https://vd3.bdstatic.com/mda-mb5e6je4hysjw5mw/v1-cae/sc/mda-mb5e6je4hysjw5mw.mp4",
            "https://vd3.bdstatic.com/mda-kbuugigwiyg2tg2r/v1-cae/sc/mda-kbuugigwiyg2tg2r.mp4",
            "https://vd4.bdstatic.com/mda-mgvc00xa8gnq0is4/sc/cae_h264/1627634952426933237/mda-mgvc00xa8gnq0is4.mp4",
            "https://vd4.bdstatic.com/mda-igad935w8emizmqm/sc/mda-igad935w8emizmqm.mp4",
            "https://vd2.bdstatic.com/mda-kf8p9n9bt9gtihsw/v1-cae/sc/mda-kf8p9n9bt9gtihsw.mp4"
    };
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vedio_layout = inflater.inflate(R.layout.vedio_layout, null);       //获取fragment所使用的布局文件。不指定容器
        vedio_title=vedio_layout.findViewById(R.id.vedio_title);
        vedio_title.setTitle("训练视频");
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        listView = (ListView) vedio_layout.findViewById(R.id.vedio_listview);
        listView.setAdapter(adapter);
        ArrayList<Vedio> vedios = new ArrayList<Vedio>();
        for (int i = 0; i < data.length; i++) {
            Vedio vedio = new Vedio();
            vedio.setName(data[i].toString());
            vedio.setId(i);
            vedio.setUrl(url[i].toString());
            vedios.add(vedio);
        }
//        for(Vedio v : vedios){
//            Log.i("测试","视频名称："+v.getName().toString()+" 视频id:"+v.getId()+" 视频链接地址："+v.getUrl().toString());
//        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Bundle info = new Bundle();
//                传递数据，包括视频的Url地址，视频的名称（后面作为跳转页面的title，id
                info.putString("url", url[position].toString());
                info.putInt("position", (Integer) position);
                info.putString("name", data[position]);
                Log.i("测试", "你选中了第" + position + "个" + "名字为：" + data[position].toString());
                // Fragment下 的Int
                Intent intent = new Intent(getActivity(), VedioPlayer.class);
                /*Intent intent = new Intent("当前activity.this","需要跳转的activity.class")*/
                intent.putExtras(info);
                startActivity(intent);
            }
        });
        return vedio_layout;
    }

    public void LoadMV() {
        ArrayList<Vedio> vedios = new ArrayList<Vedio>();
        for (int i = 0; i < data.length; i++) {
            Vedio vedio = new Vedio();
            vedio.setName(data[i].toString());
            vedio.setId(i);
            vedio.setUrl(url[i].toString());
            vedios.add(vedio);
        }
        for (Vedio v : vedios) {
            Log.i("测试", "视频名称：" + v.getName().toString() + " 视频id:" + v.getId() + " 视频链接地址：" + v.getUrl().toString());
        }
    }
}
