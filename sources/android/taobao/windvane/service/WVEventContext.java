package android.taobao.windvane.service;

import android.content.Context;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVEventContext {
    public Context context;
    public String url;
    public IWVWebView webView;

    public WVEventContext() {
        this.webView = null;
        this.url = null;
        this.context = null;
    }

    public WVEventContext(IWVWebView iWVWebView, String str) {
        this.webView = null;
        this.url = null;
        this.context = null;
        this.webView = iWVWebView;
        this.url = str;
    }
}
