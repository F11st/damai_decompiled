package com.alient.oneservice.provider.impl;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class OneContext {
    private static final String TAG = "OneContext";
    private static Application application = null;
    private static Context applicationContext = null;
    public static boolean enableLog = true;

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b7: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:30:0x00b7 */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void checkApplication() {
        /*
            java.lang.String r0 = "OneContext"
            android.app.Application r1 = com.alient.oneservice.provider.impl.OneContext.application
            if (r1 != 0) goto Lbb
            r1 = 0
            r2 = 0
            java.lang.String r3 = "android.app.AppGlobals"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.String r4 = "getInitialApplication"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            java.lang.Object r3 = r3.invoke(r1, r4)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            android.app.Application r3 = (android.app.Application) r3     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L43
            if (r3 == 0) goto L37
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            r4.<init>()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            java.lang.String r5 = "get current application from AppGlobals "
            r4.append(r5)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            r4.append(r3)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            android.util.Log.e(r0, r4)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            com.alient.oneservice.provider.impl.OneContext.application = r3
            goto La5
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            java.lang.String r5 = "Failed to get current application from android.app.AppGlobals.getInitialApplication"
            r4.<init>(r5)     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
            throw r4     // Catch: java.lang.Exception -> L3f java.lang.Throwable -> Lb6
        L3f:
            r4 = move-exception
            goto L45
        L41:
            r0 = move-exception
            goto Lb8
        L43:
            r4 = move-exception
            r3 = r1
        L45:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r5.<init>()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r6 = "Failed to get current application from AppGlobals."
            r5.append(r6)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r6 = r4.getMessage()     // Catch: java.lang.Throwable -> Lb6
            r5.append(r6)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lb6
            android.util.Log.e(r0, r5)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r5 = "android.app.ActivityThread"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> Lb6
            java.lang.String r6 = "currentApplication"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> Lb6
            java.lang.reflect.Method r5 = r5.getMethod(r6, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> Lb6
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> Lb6
            java.lang.Object r1 = r5.invoke(r1, r2)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> Lb6
            android.app.Application r1 = (android.app.Application) r1     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> Lb6
            if (r1 == 0) goto La3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L8b
            r2.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L8b
            java.lang.String r3 = "get current application from android.app.ActivityThread.currentApplication app: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L8b
            r2.append(r1)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L8b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L8b
            android.util.Log.e(r0, r2)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L8b
            goto La3
        L8a:
            r1 = r3
        L8b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41
            r2.<init>()     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = "Failed to get current application from ActivityThread."
            r2.append(r3)     // Catch: java.lang.Throwable -> L41
            java.lang.String r3 = r4.getMessage()     // Catch: java.lang.Throwable -> L41
            r2.append(r3)     // Catch: java.lang.Throwable -> L41
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L41
            android.util.Log.e(r0, r2)     // Catch: java.lang.Throwable -> L41
        La3:
            com.alient.oneservice.provider.impl.OneContext.application = r1
        La5:
            android.app.Application r1 = com.alient.oneservice.provider.impl.OneContext.application
            if (r1 == 0) goto Lb0
            android.content.Context r0 = r1.getApplicationContext()
            com.alient.oneservice.provider.impl.OneContext.applicationContext = r0
            goto Lbb
        Lb0:
            java.lang.String r1 = "sApplication == null"
            android.util.Log.e(r0, r1)
            goto Lbb
        Lb6:
            r0 = move-exception
            r1 = r3
        Lb8:
            com.alient.oneservice.provider.impl.OneContext.application = r1
            throw r0
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alient.oneservice.provider.impl.OneContext.checkApplication():void");
    }

    public static Application getApplication() {
        checkApplication();
        return application;
    }

    public static Context getApplicationContext() {
        checkApplication();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Context applicationContext2 = getApplication().getApplicationContext();
        applicationContext = applicationContext2;
        return applicationContext2;
    }

    public static boolean isDebuggable() {
        if (enableLog) {
            Log.d(TAG, ">>>isDebuggable()");
        }
        return (getApplication().getApplicationInfo().flags & 2) != 0;
    }

    public static void setApplication(Application application2) {
        application = application2;
    }
}
