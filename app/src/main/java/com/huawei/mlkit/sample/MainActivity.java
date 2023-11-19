package com.huawei.mlkit.sample;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.mlkit.sample.Fragment.Mine_Fragment;
import com.huawei.mlkit.sample.Fragment.PersonDataStatics;
import com.huawei.mlkit.sample.Fragment.Search_Fragment;
import com.huawei.mlkit.sample.Fragment.VedioFragment;
import com.huawei.mlkit.sample.Fragment.XunlianFragment;
import com.huawei.mlkit.sample.Intent.BalenceDetail;
import com.huawei.mlkit.sample.Intent.GuguanjieDetail;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    /*
     * 定义搜索、训练、康复视频、我的数据、个人管理的Fragment
     */
    public Search_Fragment search_fragment;
    public XunlianFragment xunlianFragment;
    public VedioFragment ylmovie_fragment;
    public PersonDataStatics personDataStatics;
    public Mine_Fragment mine_fragment;
    /*
     * 定义搜索、训练、康复视频、我的数据、我的fragment的布局
     */
    private View search_layout;
    private View xunlian_layout;
    private View vedio_layout;
    private View mine_layout;
    private View mydata_layout;
    /*
     * 定义搜索、训练、康复视频、我的数据、个人管理的tab的图标
     */
    private ImageView search_image;
    private ImageView xunlian_image;
    private ImageView vedio_image;
    private ImageView mydata_image;
    private ImageView mine_image;
    /*
     * 定义搜索、训练、康复视频、我的数据、个人管理的tab的文本
     */
    private TextView search_text;
    private TextView xunlian_text;
    private TextView vedio_text;
    private TextView mydata_text;
    private TextView mine_text;

    /*
     * 对Fragment进行管理
     */
    private FragmentManager fragmentManager;
    private Button bt1;
    /*****创建一个ViewFlippe控件******/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_framelayout);
        initViews(); //初始化界面，并我的四个tab的监听
        fragmentManager = getFragmentManager();
        setTabSelection(0); //第一次启动时开启第0个tab
    }
    private void setTabSelection(int index) {
        // TODO Auto-generated method stub
        //清理之前的所有状态
        clearSelection();
        //开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏所有的fragment，防止有多个界面显示在界面上
        hideFragments(transaction);
        switch (index) {
            case 0:
                //当点击消息tab时，改变控件的图片和文字颜色
                search_image.setImageResource(R.drawable.search_press);
                search_text.setTextColor(Color.WHITE);
                //如果messageFragment为空，则创建一个添加到界面上
                if (search_fragment == null) {
                    search_fragment = new Search_Fragment();
                    transaction.add(R.id.content, search_fragment);
                } else {
                    //如果messageFragment不为空，则直接将它显示出来
                    transaction.show(search_fragment);
                }
                break;
            case 1:
                //当点击训练tab时，改变控件的图片和文字颜色
                xunlian_image.setImageResource(R.drawable.task_press);
                xunlian_text.setTextColor(Color.WHITE);
                //如果contactsFragment为空，则创建一个添加到界面上
                if (xunlianFragment == null) {
                    xunlianFragment = new XunlianFragment();
                    transaction.add(R.id.content, xunlianFragment);
                } else {
                    //如果contactsFragment不为空，则直接将它显示出来
                    transaction.show(xunlianFragment);
                }
                break;
            case 2:
                //当点击出行tab时，改变控件的图片和文字颜色
                vedio_image.setImageResource(R.drawable.ylbd_press);
                vedio_text.setTextColor(Color.WHITE);
                //如果newsFragment为空，则创建一个添加到界面上
                if (ylmovie_fragment == null) {
                    ylmovie_fragment = new VedioFragment();
                    transaction.add(R.id.content, ylmovie_fragment);
                } else {
                    transaction.show(ylmovie_fragment);
                }
                break;
            case 3:
                //当点击出行tab时，改变控件的图片和文字颜色
                mydata_image.setImageResource(R.drawable.mydata_press);
                mydata_text.setTextColor(Color.WHITE);
                //如果newsFragment为空，则创建一个添加到界面上
                if (personDataStatics == null) {
                    personDataStatics = new PersonDataStatics();
                    transaction.add(R.id.content, personDataStatics);
                } else {
                    transaction.show(personDataStatics);
                }
                break;
            default:
                //当点击我的tab时，改变控件的图片和文字颜色
                mine_image.setImageResource(R.drawable.mine_press);
                mine_text.setTextColor(Color.WHITE);
                //如果settingFragment为空，则创建一个添加到界面上
                if (mine_fragment == null) {
                    mine_fragment = new Mine_Fragment();
                    transaction.add(R.id.content, mine_fragment);
                } else {
                    transaction.show(mine_fragment);
                }
                break;
        }
        transaction.commit();
    }
    /*
     * 隐藏所有的fragment
     * @param transaction
     *     用于对fragment进行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        // TODO Auto-generated method stub
        if (xunlianFragment != null) {
            transaction.hide(xunlianFragment);
        }
        if (search_fragment != null) {
            transaction.hide(search_fragment);
        }
        if (ylmovie_fragment != null) {
            transaction.hide(ylmovie_fragment);
        }
        if (personDataStatics != null) {
            transaction.hide(personDataStatics);
        }
        if (mine_fragment != null) {
            transaction.hide(mine_fragment);
        }
    }
    /*
     * 清理之前的所有状态
     */
    private void clearSelection() {
        // TODO Auto-generated method stub
        xunlian_image.setImageResource(R.drawable.task);
        xunlian_text.setTextColor(Color.parseColor("#82858b"));
        search_image.setImageResource(R.drawable.search_button);
        search_text.setTextColor(Color.parseColor("#82858b"));
        vedio_image.setImageResource(R.drawable.ylbd);
        xunlian_text.setTextColor(Color.parseColor("#82858b"));
        mine_image.setImageResource(R.drawable.mine_button);
        mine_text.setTextColor(Color.parseColor("#82858b"));
        mydata_image.setImageResource(R.drawable.mydata);
        mydata_text.setTextColor(Color.parseColor("#82858b"));
    }
    /*
     * 初始化界面，并监听我的四个tab的，该方法内设置了四个tab样式。
     */
    private void initViews() {
        // TODO Auto-generated method stub
        xunlian_layout = findViewById(R.id.xunlian_layout);
        vedio_layout = findViewById(R.id.vedio_layout);
        search_layout = findViewById(R.id.search_layout);
        mine_layout = findViewById(R.id.mine_layout);
        mydata_layout = findViewById(R.id.mydata_layout);
        /*Image初始化*/
        search_image = (ImageView) findViewById(R.id.search_image);
        xunlian_image= (ImageView) findViewById(R.id.xunlian_image);
        vedio_image = (ImageView) findViewById(R.id.vedio_image);
        mydata_image = (ImageView) findViewById(R.id.mydata_image);
        mine_image = (ImageView) findViewById(R.id.mine_image);
        /*底部导航text文本*/
        xunlian_text = (TextView) findViewById(R.id.xunlian_text);
        search_text = (TextView) findViewById(R.id.search_text);
        mine_text = (TextView) findViewById(R.id.mine_text);
        mydata_text = (TextView) findViewById(R.id.mydata_text);
        vedio_text=(TextView)findViewById(R.id.vedio_text);
        /*Layout初始化*/
        search_layout.setOnClickListener(this);
        xunlian_layout.setOnClickListener(this);
        mydata_layout.setOnClickListener(this);
        mine_layout.setOnClickListener(this);
        vedio_layout.setOnClickListener(this);
    }
    /*
     * 点击四个tab时的监听
     * @param v
     *     四个控件的view
     */
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.search_layout:
                //点击搜索tab，选中第一个tab
                setTabSelection(0);
                break;
            case R.id.xunlian_layout:
                //点击分享tab，选中第二个tab
                setTabSelection(1);
                break;
            case R.id.vedio_layout:
                //点击出行tab，选中第三个tab
                setTabSelection(2);
                break;
            case R.id.mydata_layout:
                //点击数据tab，选中第四个tab
                setTabSelection(3);
                break;
            case R.id.mine_layout:
                //点击我的tab，选中第五个tab
                setTabSelection(4);
                break;
            default:
                break;
        }
    }
    public void trans(View v)           /*关节训练页面跳转*/ {
        Log.i("关节按钮", "你这个按钮能够响应了哥们！！！");
        Intent intent = new Intent(this, GuguanjieDetail.class);
        startActivity(intent);
    }
    /*平衡训练页面跳转*/
    public void balance_trance(View v) {
        Log.i("平衡训练", "跳转成功");
        Intent intent = new Intent(this, BalenceDetail.class);
        startActivity(intent);
    }
    /*登录页面的跳转*/
    public void login(View v){
        Log.i("登录","草蘑翁佛");
        //开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //隐藏所有的fragment，防止有多个界面显示在界面上
        hideFragments(transaction);
        Intent intent =new Intent(this,Search_Fragment.class);

            startActivity(intent);
    }
    public void test(View v)
    {
   /* Log.i("登录","测试按钮响应！！！！！");
    Intent intent=new Intent(this,TestShared.class);
    startActivity(intent);*/
    }
}