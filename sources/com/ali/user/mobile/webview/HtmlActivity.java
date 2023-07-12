package com.ali.user.mobile.webview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class HtmlActivity extends WebViewActivity {
    protected void closeWebView() {
        runOnUiThread(new Runnable() { // from class: com.ali.user.mobile.webview.HtmlActivity.1
            @Override // java.lang.Runnable
            public void run() {
                HtmlActivity.this.finish();
            }
        });
    }

    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.ali.user.mobile.webview.WebViewActivity
    @SuppressLint({"NewApi"})
    protected boolean overrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        if (parse == null || parse.getScheme().equals("http") || parse.getScheme().equals("https") || parse.getScheme().equals("file")) {
            return false;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", parse));
            closeWebView();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
