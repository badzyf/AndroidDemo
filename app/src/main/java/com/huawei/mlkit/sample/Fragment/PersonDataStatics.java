package com.huawei.mlkit.sample.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.huawei.mlkit.sample.R;
import com.huawei.mlkit.sample.entity.TransDataEntity;
import com.huawei.mlkit.sample.views.graphic.GestureGraphic;

/**
 * @date: 2022/1/26
 * @author: Asus
 * @Description 这块个人设置模块中的数据统计子模块。
 */
public class PersonDataStatics extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mydata_layout = inflater.inflate(R.layout.data_statics, container, false);
        WebView webView = mydata_layout.findViewById(R.id.webview);
        WebView webView2 = mydata_layout.findViewById(R.id.webview2);
        webView.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/index.html");
        webView2.loadUrl("file:///android_asset/index2.html");
        //  js调用安卓
        webView.getSettings().setJavaScriptEnabled(true);//这里必须开启
        //把当前 Mydata_Fragment对象作为androidObject别名传递给js
        //js通过window.androidObject.androidMethod()就可以直接调用安卓的androidMethod方法
        webView.addJavascriptInterface(PersonDataStatics.this, "androidObject");
        return mydata_layout;
    }

    //js调用安卓，必须加@JavascriptInterface注释的方法才可以被js调用
    @JavascriptInterface
    public String androidMethod() {
        TransDataEntity te = new TransDataEntity();   //数据训练实体类
        te.getWoquan();
        int data[] = new int[4]; /*开辟了一个长度为3的数组*/
        data[0] = 10; // 第一个元素
        data[1] = 20; // 第二个元素
        data[2] = 30; // 第三个元素
        data[3] = 770; // 第三个元素
        int trans_data = GestureGraphic.count;
        return trans_data + "";
    }
}
