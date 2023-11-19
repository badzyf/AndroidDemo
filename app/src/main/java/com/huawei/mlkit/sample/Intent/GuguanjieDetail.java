package com.huawei.mlkit.sample.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.huawei.mlkit.sample.R;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GuguanjieDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //点击左边返回按钮监听事件
        setContentView(R.layout.guanjie_detail);
        /*组件，文章，图片初始化*/
        InitBar();
        InitText();
        InitPic();
        super.onCreate(savedInstanceState);
    }
    public void InitBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("骨关节康复");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.ic_back_16);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("sss", "返回按钮");
                finish();
            }
        });
    }
    public void InitText() {
        TextView text1 = findViewById(R.id.text1);
        TextView text2 = findViewById(R.id.text2);
        String str1="   四肢关节功能康复的主要目的是恢复上肢的灵活抓取功能和下肢的稳定负重行走功能.正规系统的骨关节功能康复要求以骨科医生为主导的多学科、多专业人员组成一个工作团队来进行，叫作“团队康复模式”(图1)。" +
                "国内真正能做到团队式骨关节功能康复的医院不多。中国康复研究中心·北京博爱医院骨科作为全国一流的骨关节功能康复与重建科室,拥有这样的实力，在骨关节功能康复与重建领域" +
                "处于全国领先水平";
//        str1=ToDBC(str1);
//        str1=stringFilter(str1);
        String str2="   广义的围手术期是指从确定手术治疗时起，直到与这次手术有关的治疗基本结束为止。实际工作中，关节的围手术期康复主要强调手术后3周左右，我们把这段时间称为关节功能康复的“黄金时间”。在这个黄金时间里，抓紧机会、使用各种康复手段，减缓肌肉萎缩、防止关节粘连非常重要。常用方法如下图医生辅助下术后当天或第二天开始关节活动范围训练护士或治疗师指导患者床旁康复器械" +
                "辅助康复治疗师手法松解术";
//        str2=ToDBC(str2);
//        str2=stringFilter(str2);
        text1.setText(str1);
        text2.setText(str2);
    }
    public void InitPic() {
        LinearLayout ly = findViewById(R.id.linerlayout1);
        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        List<ImageView> imgs = new ArrayList<ImageView>();         /*用ArrayList存放Imageview的控件*/
        image1.setImageResource(R.drawable.ggjt1);
        image2.setImageResource(R.drawable.ggjt2);
    }
    /**
     * 半角转换为全角
     *
     * @param input
     * @return
     */
    public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }
            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }
    public static String stringFilter(String str) {
        str = str.replaceAll("【", "[").replaceAll("】", "]")
                .replaceAll("！", "!").replaceAll("：", ":").replaceAll("，",",").replaceAll("。",".");// 替换中文标号
        String regEx = "[『』]"; // 清除掉特殊字符
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }
}
