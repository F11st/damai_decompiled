package com.uc.webview.export.internal.android;

import android.webkit.WebView;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.android.r */
/* loaded from: classes11.dex */
final class C7238r implements WebView.FindListener {
    final /* synthetic */ WebView.FindListener a;
    final /* synthetic */ WebViewAndroid b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C7238r(WebViewAndroid webViewAndroid, WebView.FindListener findListener) {
        this.b = webViewAndroid;
        this.a = findListener;
    }

    @Override // android.webkit.WebView.FindListener
    public final void onFindResultReceived(int i, int i2, boolean z) {
        this.a.onFindResultReceived(i, i2, z);
    }
}
