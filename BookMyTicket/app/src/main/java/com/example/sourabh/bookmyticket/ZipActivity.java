package com.example.sourabh.bookmyticket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ZipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip);
        WebView webview = (WebView) findViewById(R.id.webView7);

        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDisplayZoomControls(true);

        webview.loadUrl("https://www.zipcash.in/User/nLogin.aspx");
        webview.setWebViewClient(new WebViewClient());
    }
}
