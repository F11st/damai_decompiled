package android.taobao.windvane.jsbridge;

import android.taobao.windvane.monitor.WVMonitorService;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVAppEvent extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        return true;
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onPause() {
        this.mWebView.fireEvent("WV.Event.APP.Background", "{}");
        if (WVMonitorService.getPerformanceMonitor() != null) {
            WVMonitorService.getPerformanceMonitor().didExitAtTime(this.mWebView.getUrl(), System.currentTimeMillis());
        }
        super.onPause();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onResume() {
        super.onResume();
        String dataOnActive = this.mWebView.getDataOnActive();
        if (TextUtils.isEmpty(dataOnActive)) {
            dataOnActive = "{}";
        }
        this.mWebView.fireEvent("WV.Event.APP.Active", dataOnActive);
        this.mWebView.setDataOnActive(null);
    }
}
