package android.taobao.windvane.extra.jsbridge;

import android.taobao.windvane.extra.uc.preRender.PreRenderWebView;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.jsbridge.api.WVReporter;
import android.taobao.windvane.webview.IWVWebView;
import android.util.Log;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVReporterExtra extends WVReporter {
    @Override // android.taobao.windvane.jsbridge.api.WVReporter, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("reportPerformanceCheckResult".equals(str)) {
            reportPerformanceCheckResult(wVCallBackContext, str2);
        } else if (!"reportPrerenderStatus".equals(str)) {
            return false;
        } else {
            reportPrerenderStatus(wVCallBackContext, str2);
        }
        return super.execute(str, str2, wVCallBackContext);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:3:0x0002, B:11:0x003e, B:13:0x0044, B:15:0x004a, B:19:0x005a, B:21:0x0060, B:22:0x0069, B:24:0x006f, B:25:0x008a), top: B:31:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f A[Catch: Exception -> 0x008e, TryCatch #0 {Exception -> 0x008e, blocks: (B:3:0x0002, B:11:0x003e, B:13:0x0044, B:15:0x004a, B:19:0x005a, B:21:0x0060, B:22:0x0069, B:24:0x006f, B:25:0x008a), top: B:31:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reportPerformanceCheckResult(android.taobao.windvane.jsbridge.WVCallBackContext r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L8e
            r1.<init>(r13)     // Catch: java.lang.Exception -> L8e
            java.lang.String r13 = "score"
            r2 = 0
            long r2 = r1.optLong(r13, r2)     // Catch: java.lang.Exception -> L8e
            java.lang.String r13 = "version"
            java.lang.String r8 = r1.optString(r13, r0)     // Catch: java.lang.Exception -> L8e
            java.lang.String r13 = "result"
            java.lang.String r10 = r1.optString(r13, r0)     // Catch: java.lang.Exception -> L8e
            java.lang.String r13 = "detail"
            java.lang.String r13 = r1.optString(r13, r0)     // Catch: java.lang.Exception -> L8e
            android.taobao.windvane.webview.IWVWebView r0 = r11.mWebView     // Catch: java.lang.Exception -> L8e
            java.lang.String r0 = r0.getUrl()     // Catch: java.lang.Exception -> L8e
            r1 = 0
            android.taobao.windvane.webview.IWVWebView r4 = r11.mWebView     // Catch: java.lang.Throwable -> L3e
            boolean r5 = r4 instanceof android.taobao.windvane.webview.WVWebView     // Catch: java.lang.Throwable -> L3e
            if (r5 == 0) goto L36
            android.taobao.windvane.webview.WVWebView r4 = (android.taobao.windvane.webview.WVWebView) r4     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r4.bizCode     // Catch: java.lang.Throwable -> L3e
            goto L3e
        L36:
            boolean r5 = r4 instanceof android.taobao.windvane.extra.uc.WVUCWebView     // Catch: java.lang.Throwable -> L3e
            if (r5 == 0) goto L3e
            android.taobao.windvane.extra.uc.WVUCWebView r4 = (android.taobao.windvane.extra.uc.WVUCWebView) r4     // Catch: java.lang.Throwable -> L3e
            java.lang.String r1 = r4.bizCode     // Catch: java.lang.Throwable -> L3e
        L3e:
            android.net.Uri r4 = android.net.Uri.parse(r0)     // Catch: java.lang.Exception -> L8e
            if (r4 == 0) goto L59
            boolean r5 = r4.isHierarchical()     // Catch: java.lang.Exception -> L8e
            if (r5 == 0) goto L59
            java.lang.String r5 = "wvBizCode"
            java.lang.String r4 = r4.getQueryParameter(r5)     // Catch: java.lang.Exception -> L8e
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L8e
            if (r5 != 0) goto L59
            r9 = r4
            goto L5a
        L59:
            r9 = r1
        L5a:
            android.taobao.windvane.monitor.WVPerformanceMonitorInterface r1 = android.taobao.windvane.monitor.WVMonitorService.getPerformanceMonitor()     // Catch: java.lang.Exception -> L8e
            if (r1 == 0) goto L69
            android.taobao.windvane.monitor.WVPerformanceMonitorInterface r4 = android.taobao.windvane.monitor.WVMonitorService.getPerformanceMonitor()     // Catch: java.lang.Exception -> L8e
            r5 = r0
            r6 = r2
            r4.didPerformanceCheckResult(r5, r6, r8, r9, r10)     // Catch: java.lang.Exception -> L8e
        L69:
            boolean r1 = android.taobao.windvane.util.TaoLog.getLogStatus()     // Catch: java.lang.Exception -> L8e
            if (r1 == 0) goto L8a
            java.lang.String r1 = "WindVaneWebPerfCheck"
            java.lang.String r4 = "WindVaneWebPerfCheck: %s|%d|%s"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L8e
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Exception -> L8e
            r0 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L8e
            r5[r0] = r2     // Catch: java.lang.Exception -> L8e
            r0 = 2
            r5[r0] = r13     // Catch: java.lang.Exception -> L8e
            java.lang.String r13 = java.lang.String.format(r4, r5)     // Catch: java.lang.Exception -> L8e
            android.util.Log.e(r1, r13)     // Catch: java.lang.Exception -> L8e
        L8a:
            r12.success()     // Catch: java.lang.Exception -> L8e
            goto La0
        L8e:
            r13 = move-exception
            android.taobao.windvane.jsbridge.WVResult r0 = new android.taobao.windvane.jsbridge.WVResult
            r0.<init>()
            java.lang.String r13 = r13.getMessage()
            java.lang.String r1 = "msg"
            r0.addData(r1, r13)
            r12.error(r0)
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.jsbridge.WVReporterExtra.reportPerformanceCheckResult(android.taobao.windvane.jsbridge.WVCallBackContext, java.lang.String):void");
    }

    public void reportPrerenderStatus(WVCallBackContext wVCallBackContext, String str) {
        try {
            boolean optBoolean = new JSONObject(str).optBoolean("success", true);
            IWVWebView iWVWebView = this.mWebView;
            if (iWVWebView instanceof PreRenderWebView) {
                ((PreRenderWebView) iWVWebView).setPreRenderSuccess(optBoolean);
            }
            Log.e("reportPrerenderStatus", "setPreRenderSuccess " + optBoolean);
            wVCallBackContext.success();
        } catch (Exception e) {
            WVResult wVResult = new WVResult();
            wVResult.addData("msg", e.getMessage());
            wVCallBackContext.error(wVResult);
        }
    }
}
