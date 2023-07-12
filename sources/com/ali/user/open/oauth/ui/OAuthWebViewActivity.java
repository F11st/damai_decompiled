package com.ali.user.open.oauth.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.webview.BaseWebViewActivity;
import tb.hh1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OAuthWebViewActivity extends BaseWebViewActivity {
    public static final String TAG = "OAuthWebViewActivity";
    private String snsType;

    private boolean overrideCallback(Uri uri) {
        Bundle serialBundle = serialBundle(uri.getQuery());
        if (serialBundle == null) {
            serialBundle = new Bundle();
        }
        if (TextUtils.equals("jiuyou", this.snsType)) {
            String string = serialBundle.getString("service_ticket");
            if (!TextUtils.isEmpty(string)) {
                Intent intent = new Intent();
                intent.putExtra("token", string);
                setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("tokerrorCodeen", "0");
                intent2.putExtra(hh1.DIMEN_MESSAGE, "");
                setResult(0, intent2);
            }
            finish();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    public void loadUrl(String str) {
        if (getIntent() != null) {
            this.CALLBACK = getIntent().getStringExtra("redirectUri");
            this.snsType = getIntent().getStringExtra("snsType");
        }
        super.loadUrl(str);
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    public void onBackHistory() {
        if (this.memberWebView.canGoBack() && (this.memberWebView.getUrl().contains("authorization-notice") || this.memberWebView.getUrl().contains("agreement"))) {
            this.memberWebView.goBack();
            return;
        }
        setResult(ResultCode.USER_CANCEL.code, new Intent());
        finish();
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, com.ali.user.open.core.webview.IWebViewClient
    public void onPageFinished(String str) {
        String str2 = TAG;
        SDKLogger.d(str2, "onPageFinished url=" + str);
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, com.ali.user.open.core.webview.IWebViewClient
    public void onPageStarted(String str) {
        String str2 = TAG;
        SDKLogger.d(str2, "onPageStarted url=" + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    public void setActionBar() {
        super.setActionBar();
        if (getIntent() == null || !getIntent().getBooleanExtra("hideToolBar", false)) {
            return;
        }
        try {
            getActionBar().hide();
        } catch (Throwable unused) {
        }
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, com.ali.user.open.core.webview.IWebViewClient
    public boolean shouldOverrideUrlLoading(String str) {
        String str2 = TAG;
        SDKLogger.d(str2, "shouldOverrideUrlLoading url=" + str);
        Uri parse = Uri.parse(str);
        if (checkWebviewBridge(str)) {
            return overrideCallback(parse);
        }
        this.memberWebView.loadUrl(str);
        return true;
    }
}
