package com.ali.user.open.tbauth.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.mobile.rpc.ApiConstants;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.WebViewOption;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.webview.BaseWebViewActivity;
import com.ali.user.open.tbauth.bridge.SDKBridge;
import com.ali.user.open.tbauth.context.TbAuthContext;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class TbAuthWebViewActivity extends BaseWebViewActivity {
    public static final String TAG = "TbAuthWebViewActivity";
    public static String scene;
    public static String token;

    private boolean overrideCallback(Uri uri) {
        Bundle serialBundle = serialBundle(uri.getQuery());
        if (serialBundle == null) {
            serialBundle = new Bundle();
        }
        String string = serialBundle.getString("action");
        if (!TextUtils.isEmpty(string) && !"quit".equals(string)) {
            if ("relogin".equals(string)) {
                finish();
                return true;
            } else if ("mobile_confirm_login".equals(string) || ApiConstants.ApiField.TRUST_LOGIN.equals(string)) {
                return true;
            } else {
                if ("continueLogin".equals(string)) {
                    serialBundle.putString("aliusersdk_h5querystring", uri.getQuery());
                    serialBundle.putString("token", token);
                    serialBundle.putString("scene", scene);
                    setResult(ResultCode.CHECK.code, getIntent().putExtras(serialBundle));
                    finish();
                    return true;
                } else if ("taobao_auth_token".equals(string)) {
                    Intent intent = new Intent();
                    intent.putExtra("result", serialBundle.getString("top_auth_code"));
                    setResult(ResultCode.SUCCESS.code, intent);
                    finish();
                    return true;
                } else if ("icbu-oauth".equals(string)) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("result", serialBundle.getString("auth_code"));
                    setResult(ResultCode.SUCCESS.code, intent2);
                    finish();
                    return true;
                } else {
                    return false;
                }
            }
        }
        setResult(ResultCode.SUCCESS.code, getIntent().putExtra("iv_token", serialBundle.getString("havana_iv_token")));
        finish();
        return true;
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            getWindow().addFlags(8192);
        } catch (Throwable unused) {
        }
        if (ConfigManager.getInstance().getWebViewOption() == WebViewOption.SYSTEM) {
            this.memberWebView.addBridgeObject(TbAuthContext.sdkBridgeName, new SDKBridge());
        }
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
