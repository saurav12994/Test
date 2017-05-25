package com.example.sourabh.bookmyticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ItzActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itz);
        WebView webview = (WebView) findViewById(R.id.webView8);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDisplayZoomControls(true);

        webview.loadUrl("https://www.itzcash.com/user/jsp/Login.jsp");
        webview.setWebViewClient(new WebViewClient());
    }
}
