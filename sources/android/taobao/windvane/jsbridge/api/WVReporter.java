package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.monitor.WVMonitorService;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVReporter extends WVApiPlugin {
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("reportError".equals(str)) {
            reportError(wVCallBackContext, str2);
            return true;
        } else if ("reportDomLoad".equals(str)) {
            reportDomLoad(wVCallBackContext, str2);
            return true;
        } else {
            return false;
        }
    }

    public synchronized void reportDomLoad(WVCallBackContext wVCallBackContext, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String url = wVCallBackContext.getWebview().getUrl();
            long optLong = jSONObject.optLong("time", 0L);
            long optLong2 = jSONObject.optLong("firstByte", 0L);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("self_")) {
                    Long valueOf = Long.valueOf(jSONObject.optLong(next));
                    if (WVMonitorService.getPerformanceMonitor() != null) {
                        WVMonitorService.getPerformanceMonitor().didPageOccurSelfDefinedEvent(url, next.substring(5), valueOf.longValue());
                    }
                }
            }
            if (WVMonitorService.getPerformanceMonitor() != null) {
                WVMonitorService.getPerformanceMonitor().didPageDomLoadAtTime(url, optLong);
                WVMonitorService.getPerformanceMonitor().didPageReceiveFirstByteAtTime(url, optLong2);
            }
            wVCallBackContext.success();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public synchronized void reportError(WVCallBackContext wVCallBackContext, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String url = wVCallBackContext.getWebview().getUrl();
            if (WVMonitorService.getErrorMonitor() != null) {
                WVMonitorService.getErrorMonitor().didOccurJSError(url, jSONObject.optString("msg"), jSONObject.optString("file"), jSONObject.optString("line"));
            }
            wVCallBackContext.success();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
