package com.example.sourabh.bookmyticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ICICActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icic);
        WebView webview = (WebView) findViewById(R.id.webView2);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDisplayZoomControls(true);

        webview.loadUrl("https://www.icicibank.com/Personal-Banking/insta-banking/internet-banking/index.page");
        webview.setWebViewClient(new WebViewClient());
    }
}
