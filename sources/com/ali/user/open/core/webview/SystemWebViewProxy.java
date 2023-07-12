package com.ali.user.open.core.webview;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.util.CommonUtils;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class SystemWebViewProxy implements IWebViewProxy {
    private MemberWebView mWebView;

    public SystemWebViewProxy(Context context) {
        try {
            if (ConfigManager.getInstance().handleWebviewDir) {
                CommonUtils.handleWebviewDir(context);
            }
            this.mWebView = new MemberWebView(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void addBridgeObject(String str, Object obj) {
        MemberWebView memberWebView = this.mWebView;
        if (memberWebView != null) {
            memberWebView.addBridgeObject(str, obj);
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public boolean canGoBack() {
        MemberWebView memberWebView = this.mWebView;
        if (memberWebView != null) {
            return memberWebView.canGoBack();
        }
        return false;
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void destroy() {
        MemberWebView memberWebView = this.mWebView;
        if (memberWebView != null) {
            memberWebView.destroy();
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public ViewParent getParent() {
        MemberWebView memberWebView = this.mWebView;
        if (memberWebView != null) {
            return memberWebView.getParent();
        }
        return null;
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public String getUrl() {
        MemberWebView memberWebView = this.mWebView;
        return memberWebView != null ? memberWebView.getUrl() : "";
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public View getWebView() {
        return this.mWebView;
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void goBack() {
        MemberWebView memberWebView = this.mWebView;
        if (memberWebView != null) {
            memberWebView.goBack();
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void loadUrl(String str) {
        try {
            this.mWebView.loadUrl(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void onResume() {
        MemberWebView memberWebView = this.mWebView;
        if (memberWebView != null) {
            memberWebView.onResume();
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void removeAllViews() {
        MemberWebView memberWebView = this.mWebView;
        if (memberWebView != null) {
            memberWebView.removeAllViews();
        }
    }

    @Override // com.ali.user.open.core.webview.IWebViewProxy
    public void resumeTimers() {
        MemberWebView memberWebView = this.mWebView;
        if (memberWebView != null) {
            memberWebView.resumeTimers();
        }
    }

    public SystemWebViewProxy(Context context, String str) {
        try {
            this.mWebView = new MemberWebView(context);
            if (!CommonUtils.getDarkModeStatus(KernelContext.getApplicationContext()) || TextUtils.isEmpty(str)) {
                return;
            }
            this.mWebView.setBackgroundColor(Color.parseColor(str));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
