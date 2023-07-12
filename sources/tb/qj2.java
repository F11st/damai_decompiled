package tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.alibaba.ut.IWebView;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class qj2 implements IWebView {
    private final WebView a;

    public qj2(WebView webView) {
        this.a = webView;
    }

    @Override // com.alibaba.ut.IWebView
    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        this.a.addJavascriptInterface(obj, str);
        mb1.e(null, "mWebview" + this.a);
    }

    @Override // com.alibaba.ut.IWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.evaluateJavascript(str, valueCallback);
            return;
        }
        WebView webView = this.a;
        webView.loadUrl("javascript:" + str);
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
