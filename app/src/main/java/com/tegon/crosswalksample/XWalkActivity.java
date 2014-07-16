package com.tegon.crosswalksample;

import android.app.Activity;
import android.os.Bundle;

import org.xwalk.core.XWalkView;


public class XWalkActivity extends Activity {
    private XWalkView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xwalk);
        mWebView = (XWalkView) findViewById(R.id.webView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.load("http://google.com", null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.pauseTimers();
        mWebView.onHide();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.resumeTimers();
        mWebView.onShow();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mWebView.load("about:blank", null);
        mWebView.onDestroy();
    }
}