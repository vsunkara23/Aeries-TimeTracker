package com.sourcey.TimeTracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    String User;
    String Pass;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            User = b.getString("Username");
            Pass = b.getString("Password");
        }

        String postData = "login=" + User + "&password=" + Pass;
        String url = "http://52.66.181.122/timetracker/login.php?".concat(postData);
        webview.loadUrl(url);
        webview.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView webview , String url){
                webview.loadUrl("javascript:document.getElementById('btn_login').click()");
            }
        });
    }
}
