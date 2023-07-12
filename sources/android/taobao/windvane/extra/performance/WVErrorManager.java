package android.taobao.windvane.extra.performance;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVErrorManager {
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void reportJSError(android.webkit.ConsoleMessage r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.sourceId()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L2b
            android.taobao.windvane.grey.GreyPageManager r1 = android.taobao.windvane.grey.GreyPageManager.getInstance()
            android.taobao.windvane.grey.GreyPageInfo r1 = r1.getGreyPageInfo(r0)
            if (r1 == 0) goto L2c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "found grey page: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "WVErrorManager"
            android.taobao.windvane.util.TaoLog.d(r2, r0)
            goto L2c
        L2b:
            r1 = 0
        L2c:
            android.taobao.windvane.WVPerformanceManager r0 = android.taobao.windvane.WVPerformanceManager.getInstance()
            android.taobao.windvane.WVPerformanceConfig r0 = r0.getConfig()
            java.lang.String r0 = r0.getJsErrorRatio()
            if (r0 == 0) goto L47
            double r2 = java.lang.Math.random()
            double r4 = java.lang.Double.parseDouble(r0)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 < 0) goto L47
            return
        L47:
            java.lang.String r7 = r9.sourceId()
            java.lang.String r0 = r9.message()
            r2 = 2
            java.lang.String r3 = ""
            if (r0 == 0) goto L65
            java.lang.String r4 = "\\+\\+BT\\+\\+"
            java.lang.String[] r4 = r0.split(r4)
            int r5 = r4.length
            if (r5 != r2) goto L65
            r3 = 0
            r3 = r4[r3]
            r5 = 1
            r4 = r4[r5]
            r5 = r3
            goto L67
        L65:
            r4 = r3
            r5 = r4
        L67:
            int r9 = r9.lineNumber()
            java.lang.String r6 = java.lang.String.valueOf(r9)
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "js error: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "msg"
            r9.put(r2, r0)
            if (r1 == 0) goto L96
            java.lang.String r0 = r1.generateOutputString()
            java.lang.String r1 = "wxAirTag"
            r9.put(r1, r0)
        L96:
            java.lang.String r0 = "js_error"
            android.taobao.windvane.ha.WVHAManager.uploadApmStage(r0, r9)
            java.lang.String r2 = "WINDVANE_JS_ERROR"
            r3 = r7
            android.taobao.windvane.ha.WVHAManager.reportJSError(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.extra.performance.WVErrorManager.reportJSError(android.webkit.ConsoleMessage):void");
    }
}
