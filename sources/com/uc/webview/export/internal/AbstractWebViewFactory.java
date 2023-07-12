package com.uc.webview.export.internal;

import android.content.Context;
import android.util.AttributeSet;
import com.uc.webview.export.WebView;
import com.uc.webview.export.annotations.Interface;
import com.uc.webview.export.internal.interfaces.IWebView;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public abstract class AbstractWebViewFactory {
    public abstract IWebView createWebView(Context context, AttributeSet attributeSet, WebView webView, boolean z, int[] iArr);
}
