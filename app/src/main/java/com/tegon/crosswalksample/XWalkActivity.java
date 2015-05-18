package com.tegon.crosswalksample;

import android.app.Activity;
import android.os.Bundle;

import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;


public class XWalkActivity extends Activity {
    private XWalkView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xwalk);

        if (BuildConfig.DEBUG) {
            XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);
        }

        mWebView = (XWalkView) findViewById(R.id.webView);
        mWebView.load("https://get.webgl.org", null);
    }

    @Override
    public void onPause() {
        super.onPause();

        if (mWebView != null) {
            mWebView.pauseTimers();
            mWebView.onHide();
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (mWebView != null) {
            mWebView.resumeTimers();
            mWebView.onShow();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mWebView != null) {
            mWebView.load("about:blank", null);
            mWebView.onDestroy();
        }
    }
}