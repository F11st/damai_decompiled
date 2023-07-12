package android.taobao.windvane.monitor;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVJsMonitor implements WVJSBrdigeMonitorInterface {
    @Override // android.taobao.windvane.monitor.WVJSBrdigeMonitorInterface
    public void commitParamParseError(String str, String str2, String str3, String str4) {
        AppMonitorUtil.commitParamParseError(str, str2, str3, str4);
    }

    @Override // android.taobao.windvane.monitor.WVJSBrdigeMonitorInterface
    public void didCallAtURL(String str, String str2, String str3) {
    }

    @Override // android.taobao.windvane.monitor.WVJSBrdigeMonitorInterface
    public void didCallBackAtURL(String str, String str2, String str3, String str4) {
    }

    @Override // android.taobao.windvane.monitor.WVJSBrdigeMonitorInterface
    public void didOccurError(String str, String str2, String str3, String str4) {
    }

    @Override // android.taobao.windvane.monitor.WVJSBrdigeMonitorInterface
    public void onJsBridgeReturn(String str, String str2, String str3, String str4, String str5) {
        AppMonitorUtil.commitJsBridgeReturn(str, str3, str4, str5);
    }
}
