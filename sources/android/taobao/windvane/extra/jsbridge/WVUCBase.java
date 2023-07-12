package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.extra.uc.WVUCWebView;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.util.TaoLog;
import com.uc.webview.export.extension.UCCore;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUCBase extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("onLowMemory".equals(str) && WVUCWebView.getUCSDKSupport()) {
            try {
                UCCore.onLowMemory();
                wVCallBackContext.success();
                return true;
            } catch (Exception e) {
                wVCallBackContext.error("Only UCSDKSupport !");
                TaoLog.d("WVUCBase", "UCCore :: onLowMemory error : " + e.getMessage());
                return false;
            }
        }
        return false;
    }
}
