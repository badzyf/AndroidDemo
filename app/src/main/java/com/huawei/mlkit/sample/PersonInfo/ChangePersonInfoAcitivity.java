package com.huawei.mlkit.sample.PersonInfo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.huawei.mlkit.sample.R;


public class ChangePersonInfoAcitivity extends AppCompatActivity {
    private boolean flag = false; //判断用户到底有没有改了信息
    Button modify_personinfo;
    String edittext;        //保存用户更改后的内容字符。用于给person重新赋值。
    TextView change_item;       //保存要修改的属性，后面用于更新信息。
    EditText edit_query;        //编辑框
    PersonInfo person = new PersonInfo();      //将传过来的信息保存在Person类中
    String before;
    String after;
    //保存传过来的是什么属性。然后把这个属性传递给change_item
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chage_personinfo);
        change_item = findViewById(R.id.change_item);       //textView 控件
        modify_personinfo = findViewById(R.id.modify_personinfo);     //修改按钮
        edit_query = findViewById(R.id.edit_query);
        edit_query.setText("个人信息修改");
        change_item.setTextSize(20);
        //可编辑文本框 默认值设定为从个人信息页面中传过来的 原来的信息。
        Intent get = getIntent();
        String property = get.getStringExtra("property");
        String value = "";
        if (property.equals("")) {
            Log.i("测试", "传值为空");
        } else {
            Log.i("非空：", property.toString());
        }
        change_item.setText(property.toString());
        Log.i("textvie值：", change_item.toString());
        if (property.toString().equals("姓名")) {
            value = get.getStringExtra("name");
            Log.i("获取edittext值", value);
            edit_query.setText(value);
            before = value;//用于在后期判断这个用户到底有没有改这个信息，没改就提示。
        } else if (property.toString().equals("年龄")) {
            int age = get.getIntExtra("age", 0);
            edit_query.setText(age + "");
            before =get.getIntExtra("age", 0)+""; //用于在后期判断这个用户到底有没有改这个信息，没改就提示。
        } else if (property.toString().equals("地址")) {
            value=get.getStringExtra("address");
            Log.i("数据传输测试：",value);
            edit_query.setText(value);
            before = value; //用于在后期判断这个用户到底有没有改这个信息，没改就提示。
        } else if (property.toString().equals("性别")) {
            edit_query.setText(get.getStringExtra("sex"));
            before = get.getStringExtra("sex"); //用于在后期判断这个用户到底有没有改这个信息，没改就提示。
        }
        if (property.toString().equals("手机号")) {
            edit_query.setText(get.getStringExtra("phone"));
            before = get.getStringExtra("phone"); //用于在后期判断这个用户到底有没有改这个信息，没改就提示。
        }
        //上面的后期要恢复
        modify_personinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                after=edit_query.getText().toString();
                Log.i("数据字符是否完全一致？","文本内容:"+before.toString()+"文本框的内容："+after.toString());
                if (before.toString().equals(after.toString())) {
                    flag = false;
                    AlertDialog warn_dialog = new AlertDialog.Builder(ChangePersonInfoAcitivity.this)
                            .setTitle("提示")
                            .setMessage("您没有修改信息!请重新校对！")
                            .setIcon(R.mipmap.warn)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(ChangePersonInfoAcitivity.this, "这是确定按钮", Toast.LENGTH_SHORT).show();
                                }
                            })
//                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    Toast.makeText(ChangePersonInfoAcitivity.this, "这是取消按钮", Toast.LENGTH_SHORT).show();
//                                }
//                            })
                            .create();
                    warn_dialog.show();
                } else {     //提交事务
                    //根据当前lable的名称我们就知道他要改的是什么属性
                    String lable = change_item.getText().toString();
                    String get_changed = edit_query.getText().toString();
                    if (lable.toString().equals("姓名")) {
                        person.setName(get_changed);
                    }
                    if (lable.toString().equals("性别")) {
                        person.setSex(get_changed);
                    }
                    if (lable.toString().equals("年龄")) {
                        person.setAge(Integer.parseInt(get_changed));
                    }
                    if (lable.toString().equals("电话")) {
                        person.setPhone(get_changed);
                    }
                    if (lable.toString().equals("地址")) {
                        person.setAddress(get_changed);
                    }
                    //修改成功提示
                    AlertDialog success = new AlertDialog.Builder(ChangePersonInfoAcitivity.this)
                            .setTitle("修改成功")
                            .setMessage("修改成功！")
                            .setIcon(R.mipmap.success)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(ChangePersonInfoAcitivity.this, "这是确定按钮", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create();
                    success.show();
                }
            }
        });
    }
}