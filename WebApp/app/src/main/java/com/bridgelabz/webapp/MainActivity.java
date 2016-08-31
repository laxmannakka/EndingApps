package com.bridgelabz.webapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.bridgelabz.webapp.R.id.webview;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = (WebView) findViewById(webview);
       // webView.loadUrl("https://mail.google.com/mail/u/0/#inbox/156938c9bf6300b7");
       // String summary = "<html><body>You scored <b>192</b> points.</body></html>";
     //   webView.loadData(summary, "text/html", null);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        String folderPath = "file:android_asset/gamefiles/";
        String fileName = "index.html";

        // Get the exact file location
        String file = folderPath + fileName;
        webView.loadUrl(file);



    }
}
