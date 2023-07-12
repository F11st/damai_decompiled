package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUI extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("showLoadingBox".equals(str)) {
            showLoading(str2, wVCallBackContext);
            return true;
        } else if ("hideLoadingBox".equals(str)) {
            hideLoading(str2, wVCallBackContext);
            return true;
        } else {
            return false;
        }
    }

    public final void hideLoading(String str, WVCallBackContext wVCallBackContext) {
        this.mWebView.hideLoadingView();
        wVCallBackContext.success();
    }

    public final void showLoading(String str, WVCallBackContext wVCallBackContext) {
        this.mWebView.showLoadingView();
        wVCallBackContext.success();
    }
}
