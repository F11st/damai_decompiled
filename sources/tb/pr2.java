package tb;

import android.content.Context;
import android.webkit.ValueCallback;
import com.alibaba.ut.IWebView;
import com.uc.webview.export.WebView;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class pr2 implements IWebView {
    WebView a;

    public pr2(WebView webView) {
        this.a = null;
        this.a = webView;
    }

    @Override // com.alibaba.ut.IWebView
    public void addJavascriptInterface(Object obj, String str) {
        this.a.addJavascriptInterface(obj, str);
        mb1.e(null, "mWebview" + this.a);
    }

    @Override // com.alibaba.ut.IWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        this.a.evaluateJavascript(str, valueCallback);
    }

    @Override // com.alibaba.ut.IWebView
    public Context getContext() {
        return this.a.getContext();
    }

    @Override // com.alibaba.ut.IWebView
    public int getDelegateHashCode() {
        return this.a.hashCode();
    }

    @Override // com.alibaba.ut.IWebView
    public void loadUrl(String str) {
        this.a.loadUrl(str);
    }

    @Override // com.alibaba.ut.IWebView
    public boolean post(Runnable runnable) {
        return this.a.post(runnable);
    }
}
