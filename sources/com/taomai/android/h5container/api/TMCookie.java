package com.taomai.android.h5container.api;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.api.WVCookie;
import android.taobao.windvane.webview.IWVWebView;
import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.qm;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ&\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/taomai/android/h5container/api/TMCookie;", "Landroid/taobao/windvane/jsbridge/api/WVCookie;", "", "action", "params", "Landroid/taobao/windvane/jsbridge/WVCallBackContext;", WXBridgeManager.METHOD_CALLBACK, "", "execute", "<init>", "()V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public final class TMCookie extends WVCookie {
    @Override // android.taobao.windvane.jsbridge.api.WVCookie, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        qm.C9608a c9608a = qm.Companion;
        IWVWebView iWVWebView = this.mWebView;
        b41.h(iWVWebView, "mWebView");
        if (c9608a.c(iWVWebView.getUrl())) {
            return super.execute(str, str2, wVCallBackContext);
        }
        return true;
    }
}
