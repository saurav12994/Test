package com.example.sourabh.bookmyticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class YpayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ypay);
        WebView webview = (WebView) findViewById(R.id.webView9);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDisplayZoomControls(true);

        webview.loadUrl("http://www.ypaycash.com/login.html");
        webview.setWebViewClient(new WebViewClient());
    }
}
