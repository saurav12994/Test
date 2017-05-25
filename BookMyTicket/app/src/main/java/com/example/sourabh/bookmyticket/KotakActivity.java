package com.example.sourabh.bookmyticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class KotakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak);

        WebView webview = (WebView) findViewById(R.id.webView);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDisplayZoomControls(true);
        webview.loadUrl("https://retail.onlinesbi.com/retail/login.htm");
    }

}
