package com.huawei.mlkit.sample.Intent;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.huawei.mlkit.sample.R;


public class BalenceDetail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //点击左边返回按钮监听事件
        setContentView(R.layout.banlance_detail);
        Init();
        super.onCreate(savedInstanceState);
    }

    public void Init() {
        Toolbar toolbar = findViewById(R.id.balence_toolbar);
        toolbar.setTitle("平衡康复");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.ic_back_16);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("sss", "返回按钮");
                finish();
            }
        });
        ImageView image1 = findViewById(R.id.image1_balance);
        ImageView image2 = findViewById(R.id.image2_balance);
        ImageView image3 = findViewById(R.id.image3_balance);
        ImageView image4 = findViewById(R.id.image4_balance);
        TextView t1 = findViewById(R.id.text1_balance);
        TextView t2 = findViewById(R.id.text2_balance);
        TextView t3 = findViewById(R.id.text3_balance);
        TextView t4 = findViewById(R.id.text4_balance);
        t1.setText("平衡是人体保持姿势与体位，完成各项日常生活活动，尤其是各种转移动作行走以及跑、跳等复杂运动的基本保证。平衡功能的康复训练是物理疗法专业的重要工作内容，因此平衡功能评定也就成为制定平衡功能计划的重要步骤。1.平衡的测定有定量评定和定性评定两种方法。2.平衡康复训练的原则:（1）支撑面积由大变小（2）稳定极限由大变小（3）从静态平衡到动态平衡（4）逐渐增加训练的复杂性");
        image4.setImageResource(R.drawable.balence_yangwo);
        t2.setText("（1）仰卧式：桥式运动训练：治疗师可将一只手放在患者的患膝上，然后向前下方拉压膝关节，另一只手拍打患侧臀部，刺激臀肌的收缩，帮助患髋伸展。  ");
        image2.setImageResource(R.drawable.balence_zhouxi);
        t2.setText("（2）前臂支撑下的俯卧位：适合截难患者，是上肢和肩部的强化训练及持拐步行前的准备训练。患者取俯卧位，前臂支撑上肢体重，保持静态平衡：然后治疗师向各个方向推动患者的肩部，进行他动态平衡训练；最后进行自动态平衡训练，患者自己向各个方向活动。 ");
        image3.setImageResource(R.drawable.balance_fuwoli);
        t3.setText("肘膝跪位：此种训练体位同样主要适合截瘫患者，也适用于运动失调症和帕金森综合征等具有运动功能障碍的患者。患者取肘膝跪位保持平衡；治疗师向各个方向推动患者；患者自己向各个方向活动或者躯干侧屈或旋转，然后可指示患者将一侧上肢或下肢抬起并保持平衡，随着稳定性的增强，再将一侧上肢和另一侧下肢同时抬起并保持平衡。");
        image1.setImageResource(R.drawable.balence_sxgw);
        t4.setText("站立位:进行站立位的平衡训练，都是为步行做好准备，并最终达到步行的目的。①静态平衡训练;②他动态平衡训练;③自动态平衡训练。");
    }
}
