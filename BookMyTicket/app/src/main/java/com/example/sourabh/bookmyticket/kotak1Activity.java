package com.example.sourabh.bookmyticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class kotak1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak1);
        WebView webview = (WebView) findViewById(R.id.webView5);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDisplayZoomControls(true);

        webview.loadUrl("http://www.kotak.com/");
        webview.setWebViewClient(new WebViewClient());
    }
}
