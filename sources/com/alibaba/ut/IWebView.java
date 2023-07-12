package com.alibaba.ut;

import android.content.Context;
import android.webkit.ValueCallback;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface IWebView {
    void addJavascriptInterface(Object obj, String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    Context getContext();

    int getDelegateHashCode();

    void loadUrl(String str);

    boolean post(Runnable runnable);
}
