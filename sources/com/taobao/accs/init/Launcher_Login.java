package com.taobao.accs.init;

import android.app.Application;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Launcher_Login implements Serializable {
    public void init(final Application application, final HashMap<String, Object> hashMap) {
        ALog.i("Launcher_Login", "login", new Object[0]);
        ThreadPoolExecutorFactory.execute(new Runnable() { // from class: com.taobao.accs.init.Launcher_Login.1
            /* JADX WARN: Removed duplicated region for block: B:26:0x0057 A[Catch: all -> 0x0094, TryCatch #0 {all -> 0x0094, blocks: (B:24:0x0051, B:26:0x0057, B:27:0x0060, B:23:0x004a), top: B:32:0x004a }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r7 = this;
                    java.lang.String r0 = "Launcher_Login"
                    r1 = 1
                    r2 = 0
                    r3 = 0
                    java.util.HashMap r4 = r2     // Catch: java.lang.Throwable -> L47
                    java.lang.String r5 = "envIndex"
                    java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L47
                    java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> L47
                    int r4 = r4.intValue()     // Catch: java.lang.Throwable -> L47
                    java.util.HashMap r5 = r2     // Catch: java.lang.Throwable -> L47
                    java.lang.String r6 = "onlineAppKey"
                    java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L47
                    java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L47
                    if (r4 != r1) goto L2d
                    java.util.HashMap r3 = r2     // Catch: java.lang.Throwable -> L2b
                    java.lang.String r4 = "preAppKey"
                    java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L2b
                    java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L2b
                L29:
                    r5 = r3
                    goto L51
                L2b:
                    r3 = move-exception
                    goto L4a
                L2d:
                    r3 = 2
                    if (r4 != r3) goto L32
                    r3 = 1
                    goto L33
                L32:
                    r3 = 0
                L33:
                    r6 = 3
                    if (r4 != r6) goto L38
                    r4 = 1
                    goto L39
                L38:
                    r4 = 0
                L39:
                    r3 = r3 | r4
                    if (r3 == 0) goto L51
                    java.util.HashMap r3 = r2     // Catch: java.lang.Throwable -> L2b
                    java.lang.String r4 = "dailyAppkey"
                    java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L2b
                    java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L2b
                    goto L29
                L47:
                    r4 = move-exception
                    r5 = r3
                    r3 = r4
                L4a:
                    java.lang.String r4 = "login get param error"
                    java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.utl.ALog.e(r0, r4, r3, r6)     // Catch: java.lang.Throwable -> L94
                L51:
                    boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L94
                    if (r3 == 0) goto L60
                    java.lang.String r3 = "login get appkey null"
                    java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.utl.ALog.e(r0, r3, r4)     // Catch: java.lang.Throwable -> L94
                    java.lang.String r5 = "21646297"
                L60:
                    android.app.Application r3 = r3     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.init.Launcher_InitAccs.mContext = r3     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.init.Launcher_InitAccs.mAppkey = r5     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.init.Launcher_InitAccs.mForceBindUser = r1     // Catch: java.lang.Throwable -> L94
                    java.util.HashMap r1 = r2     // Catch: java.lang.Throwable -> L94
                    java.lang.String r3 = "userId"
                    java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L94
                    java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.init.Launcher_InitAccs.mUserId = r1     // Catch: java.lang.Throwable -> L94
                    java.util.HashMap r1 = r2     // Catch: java.lang.Throwable -> L94
                    java.lang.String r3 = "sid"
                    java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L94
                    java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.init.Launcher_InitAccs.mSid = r1     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.ACCSClient r1 = com.taobao.accs.ACCSClient.getAccsClient()     // Catch: java.lang.Throwable -> L94
                    java.util.HashMap r3 = r2     // Catch: java.lang.Throwable -> L94
                    java.lang.String r4 = "ttid"
                    java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L94
                    java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L94
                    com.taobao.accs.IAppReceiver r4 = com.taobao.accs.init.Launcher_InitAccs.mAppReceiver     // Catch: java.lang.Throwable -> L94
                    r1.bindApp(r3, r4)     // Catch: java.lang.Throwable -> L94
                    goto L9c
                L94:
                    r1 = move-exception
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    java.lang.String r3 = "login"
                    com.taobao.accs.utl.ALog.e(r0, r3, r1, r2)
                L9c:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.init.Launcher_Login.AnonymousClass1.run():void");
            }
        });
    }
}
