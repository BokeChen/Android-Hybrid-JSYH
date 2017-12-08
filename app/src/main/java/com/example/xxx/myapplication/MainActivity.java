package com.example.xxx.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview =(WebView)findViewById(R.id.webview);
         //设置WebView 属性，能够执行Javascript脚本
        webview.getSettings().setJavaScriptEnabled(true);
        //允许访问assets 目录
        webview.getSettings().setAllowFileAccess(true);
        //指向assets文件路径的index.html
        String path = "file:///android_asset/index.html";
        // 加载HTML页面
        webview.loadUrl(path);
        //设置字体不随系统设置变化
//        webview.getSettings().setTextZoom(100);
        //WebViewClient类 作用：处理各种通知 和请求事件
        webview.setWebViewClient(new HelloWebViewClient());
    }
    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        //这个方法，在web页面打开链接时，自动调用android自带的浏览器打开链接
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}
