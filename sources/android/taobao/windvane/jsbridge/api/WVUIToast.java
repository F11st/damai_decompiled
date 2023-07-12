package android.taobao.windvane.jsbridge.api;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUIToast extends WVApiPlugin {
    private static final String TAG = "WVUIToast";

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("toast".equals(str)) {
            toast(wVCallBackContext, str2);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void toast(android.taobao.windvane.jsbridge.WVCallBackContext r7, java.lang.String r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            android.content.Context r0 = r6.mContext     // Catch: java.lang.Throwable -> L68
            boolean r0 = android.taobao.windvane.jsbridge.utils.WVUtils.isNotificationEnabled(r0)     // Catch: java.lang.Throwable -> L68
            if (r0 != 0) goto L1a
            android.taobao.windvane.jsbridge.WVResult r8 = new android.taobao.windvane.jsbridge.WVResult     // Catch: java.lang.Throwable -> L68
            r8.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r0 = "msg"
            java.lang.String r1 = "no permission"
            r8.addData(r0, r1)     // Catch: java.lang.Throwable -> L68
            r7.error(r8)     // Catch: java.lang.Throwable -> L68
            monitor-exit(r6)
            return
        L1a:
            java.lang.String r0 = ""
            boolean r1 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L68
            r2 = 17
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L4b
            java.lang.String r1 = "utf-8"
            java.lang.String r8 = java.net.URLDecoder.decode(r8, r1)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L68
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L68
            r1.<init>(r8)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L68
            java.lang.String r5 = "message"
            java.lang.String r0 = r1.optString(r5)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L68
            java.lang.String r5 = "duration"
            int r8 = r1.optInt(r5)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> L68
            goto L4c
        L3f:
            android.content.Context r1 = r6.mContext     // Catch: java.lang.Throwable -> L68
            android.widget.Toast r8 = android.widget.Toast.makeText(r1, r8, r3)     // Catch: java.lang.Throwable -> L68
            r8.setGravity(r2, r4, r4)     // Catch: java.lang.Throwable -> L68
            r8.show()     // Catch: java.lang.Throwable -> L68
        L4b:
            r8 = 0
        L4c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L68
            if (r1 != 0) goto L63
            r1 = 3
            if (r8 <= r1) goto L56
            goto L57
        L56:
            r3 = r8
        L57:
            android.content.Context r8 = r6.mContext     // Catch: java.lang.Throwable -> L68
            android.widget.Toast r8 = android.widget.Toast.makeText(r8, r0, r3)     // Catch: java.lang.Throwable -> L68
            r8.setGravity(r2, r4, r4)     // Catch: java.lang.Throwable -> L68
            r8.show()     // Catch: java.lang.Throwable -> L68
        L63:
            r7.success()     // Catch: java.lang.Throwable -> L68
            monitor-exit(r6)
            return
        L68:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.jsbridge.api.WVUIToast.toast(android.taobao.windvane.jsbridge.WVCallBackContext, java.lang.String):void");
    }
}
