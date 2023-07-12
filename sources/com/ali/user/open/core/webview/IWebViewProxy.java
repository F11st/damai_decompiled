package com.ali.user.open.core.webview;

import android.view.View;
import android.view.ViewParent;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface IWebViewProxy {
    void addBridgeObject(String str, Object obj);

    boolean canGoBack();

    void destroy();

    ViewParent getParent();

    String getUrl();

    View getWebView();

    void goBack();

    void loadUrl(String str);

    void onResume();

    void removeAllViews();

    void resumeTimers();
}
