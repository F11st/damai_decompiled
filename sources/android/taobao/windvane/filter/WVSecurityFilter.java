package android.taobao.windvane.filter;

import android.annotation.SuppressLint;
import android.taobao.windvane.service.WVWebViewClientFilter;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.taobao.windvane.webview.WVWrapWebResourceResponse;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVSecurityFilter extends WVWebViewClientFilter {
    @Override // android.taobao.windvane.service.WVWebViewClientFilter
    @SuppressLint({"NewApi", "DefaultLocale"})
    public WVWrapWebResourceResponse shouldInterceptRequest(IWVWebView iWVWebView, String str) {
        if (TaoLog.getLogStatus()) {
            TaoLog.d("WVSecurityFilter", "WVSecurityFilter shouldInterceptRequest url =" + str);
        }
        if (!TextUtils.isEmpty(str) && str.length() > 6 && str.substring(0, 7).toLowerCase().startsWith("file://")) {
            return new WVWrapWebResourceResponse("", "utf-8", null, null);
        }
        return super.shouldInterceptRequest(iWVWebView, str);
    }
}
