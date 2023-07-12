package android.taobao.windvane.service;

import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWrapWebResourceResponse;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class WVWebViewClientFilter implements WVEventListener {
    @Override // android.taobao.windvane.service.WVEventListener
    public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
        WVEventResult wVEventResult = new WVEventResult(false);
        if (i != 1008) {
            switch (i) {
                case 1001:
                    onPageStarted(wVEventContext.webView, wVEventContext.url);
                    return wVEventResult;
                case 1002:
                    onPageFinished(wVEventContext.webView, wVEventContext.url);
                    return wVEventResult;
                case 1003:
                    wVEventResult.isSuccess = shouldOverrideUrlLoading(wVEventContext.webView, wVEventContext.url);
                    return wVEventResult;
                case 1004:
                    break;
                case 1005:
                    onReceivedError(wVEventContext.webView, ((Integer) objArr[0]).intValue(), (String) objArr[1], (String) objArr[2]);
                    return wVEventResult;
                default:
                    return null;
            }
        }
        WVWrapWebResourceResponse shouldInterceptRequest = shouldInterceptRequest(wVEventContext.webView, wVEventContext.url);
        if (shouldInterceptRequest != null) {
            wVEventResult.isSuccess = true;
            wVEventResult.resultObj = shouldInterceptRequest;
            return wVEventResult;
        }
        return wVEventResult;
    }

    public void onPageFinished(IWVWebView iWVWebView, String str) {
    }

    public void onPageStarted(IWVWebView iWVWebView, String str) {
    }

    public void onReceivedError(IWVWebView iWVWebView, int i, String str, String str2) {
    }

    public WVWrapWebResourceResponse shouldInterceptRequest(IWVWebView iWVWebView, String str) {
        return null;
    }

    public boolean shouldOverrideUrlLoading(IWVWebView iWVWebView, String str) {
        return false;
    }
}
