package android.taobao.windvane.standardmodal;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.service.WVEventService;
import android.taobao.windvane.webview.IWVWebView;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVStandardEventCenter extends WVApiPlugin {
    public static void postNotificationToJS(IWVWebView iWVWebView, String str, String str2) {
        WVCallBackContext.fireEvent(iWVWebView, str, str2);
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("postNotificationToNative".equals(str)) {
            postNotificationToNative(str2, wVCallBackContext);
            return true;
        }
        return false;
    }

    public void postNotificationToNative(String str, WVCallBackContext wVCallBackContext) {
        WVEventService.getInstance().onEvent(3005, str, wVCallBackContext);
        wVCallBackContext.success();
    }

    public static void postNotificationToJS(String str, String str2) {
        WVEventService.getInstance().onEvent(3006, str, str2);
    }
}
