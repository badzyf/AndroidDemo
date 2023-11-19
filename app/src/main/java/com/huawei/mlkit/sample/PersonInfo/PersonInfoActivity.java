package com.huawei.mlkit.sample.PersonInfo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.huawei.mlkit.sample.R;


public class PersonInfoActivity extends AppCompatActivity {
    private String[] infolist = {"姓名", "性别", "年龄", "地址", "手机号"};
    private ListView psersoninfo_list;
    private EditText list_edittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PersonInfo person = new PersonInfo(); //创建一个人对象，作为一个数据传输的例子。
        person.setAddress("浙江省杭州市余杭区");
        person.setName("张三");
        person.setAge(21);
        person.setPhone("17729932299");
        person.setSex("男");
        Log.i("集合", person.toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personinfo_layout);
        Init();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                PersonInfoActivity.this, android.R.layout.simple_list_item_1, infolist);
        psersoninfo_list = (ListView) findViewById(R.id.psersoninfo_list);
        psersoninfo_list.setAdapter(adapter);
        psersoninfo_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                /*Intent intent = new Intent("当前activity.this","需要跳转的activity.class")*/
                /*把人的整个信息都传过去*/
                Intent intent = new Intent(PersonInfoActivity.this, ChangePersonInfoAcitivity.class);
                //这个是用户点击了什么item，就传过去这个item名，作为后面修改的属性，例如，我要改名字，那么就把“姓名”这个属性value传递到修改属性。
                //表示这个修改的是一个人的哪方面的信息。
                intent.putExtra("property", infolist[position].toString());
                Log.i("cesi", "你点中了第" + position + "的  " + infolist[position]);
                //上面先传属性，后面接收的页面先接收属性，那么这个系统就知道用户要改什么属性内容了
                if (infolist[position].toString().equals("姓名")) {
                    intent.putExtra("name", person.getName());
                    Log.i("ce", "执行了");
                }
                if (infolist[position].toString().equals("性别")) {
                    intent.putExtra("sex", person.getSex());
                }
                if (infolist[position].toString().equals("地址")) {
                    intent.putExtra("address", person.getAddress());
                }
                if (infolist[position].toString().equals("手机号")) {
                    intent.putExtra("phone", person.getPhone());
                }
                if (infolist[position].toString().equals("年龄")) {
                    intent.putExtra("age", person.getAge());
                }
                startActivity(intent);
            }
        });
    }
    public void Init() {
        Toolbar toolbar = findViewById(R.id.list_edittext);
        toolbar.setTitle("个人信息");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("sss", "返回按钮");
                finish();
            }
        });
    }
}
