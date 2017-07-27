package com.example.hp2.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class newsactivity extends AppCompatActivity {

    WebView webView;
    String url = "http://bookgotruck.com/";

    void initWebView(){
        webView = (WebView)findViewById(R.id.webview);

        // Code to show WebPage in WebView
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true); // webview supports javascript
        webView.loadUrl(url); // Their must be Internet Connection. You must give a permission in the Manifest File for Internet

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsactivity);
        initWebView();

    }
}
