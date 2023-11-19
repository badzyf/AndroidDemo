package com.huawei.mlkit.sample.Vedio;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.huawei.mlkit.sample.R;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VedioPlayer extends AppCompatActivity {
    Toolbar kfxlmv_detail;
    TextView kfxlmv_title;
    //声明控件
    String name;        //视频名称
    String url;         //视频url地址
    int id;          //视频号
    private JCVideoPlayerStandard jcVideoPlayerStandard;
    //测试地址 https://vd2.bdstatic.com/mda-kek0qm8562gapzji/hd/mda-kek0qm8562gapzji.mp4
    // https://vd4.bdstatic.com/mda-mg01zkvdqmg834tu/sc/cae_h264_nowatermark/1625103039632594717/mda-mg01zkvdqmg834tu.mp4
    //String s1="https://vd2.bdstatic.com/mda-mgq6yqfuwgnvm6g1/sc/cae_h264/1627189535164561681/mda-mgq6yqfuwgnvm6g1.mp4";
   /* https://txmov2.a.yximgs.com/upic/2017/12/19/19/BMjAxNzEyMTkxOTAxMDBfNzAyMzQ4Ml80Mjc0MDY2MDAzXzJfMw==_b_A11ffeb3a68cd7402684c6d13ef59fe04.mp4*/
    // @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_media);
        kfxlmv_detail=findViewById(R.id.kfxlmv_detail);//康复训练详情（仅仅是Toolbar）
        kfxlmv_title=findViewById(R.id.kfxlmv_title);        //康复训练详情（仅仅是title）
         /* getmsg=findViewById(R.id.getmsg);
        //得到传递过来的intent参数 */
        Bundle b = getIntent().getExtras();
            int id=b.getInt("position");
         url=b.getString("url");
        Log.i("测试",url);
         name=b.getString("name");
         //title内容和颜色设置
        kfxlmv_detail.setTitle(name.toString());
        kfxlmv_detail.setTitleTextColor(this.getResources().getColor(R.color.white));
        //设置标题 有需要的可以试一下
        //getSupportActionBar().setTitle("jiecaovideoplayer的使用");
        //找控件
        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.jiecao_Player);
        //设置视频上显示的文字
        jcVideoPlayerStandard.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, name);
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
    public void InitBar(){
    }
}
/*getmsg=findViewById(R.id.getmsg);
        //得到传递过来的intent参数
        Bundle b = getIntent().getExtras();
        Integer id=b.getInt("position");
        String str=id.toString();
        *//*传过来的值赋值给了str*//*
        getmsg.setText(str);
        "http://rbv01.ku6.com/omtSn0z_PTREtneb3GRtGg.mp4"
        */
