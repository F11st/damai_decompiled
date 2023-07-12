package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Logger {
    private static boolean sDisablePushLog;
    private static LoggerInterface sUserLogger;

    public static void disablePushFileLog(Context context) {
        sDisablePushLog = true;
        setPushLog(context);
    }

    public static void enablePushFileLog(Context context) {
        sDisablePushLog = false;
        setPushLog(context);
    }

    @Deprecated
    public static File getLogFile(String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static LoggerInterface getUserLogger() {
        return sUserLogger;
    }

    private static boolean hasWritePermission(Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void setLogger(Context context, LoggerInterface loggerInterface) {
        sUserLogger = loggerInterface;
        setPushLog(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (hasWritePermission(r4) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void setPushLog(android.content.Context r4) {
        /*
            com.xiaomi.channel.commonutils.logger.LoggerInterface r0 = com.xiaomi.mipush.sdk.Logger.sUserLogger
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8
            r0 = 1
            goto L9
        L8:
            r0 = 0
        L9:
            boolean r3 = com.xiaomi.mipush.sdk.Logger.sDisablePushLog
            if (r3 == 0) goto Le
            goto L16
        Le:
            boolean r3 = hasWritePermission(r4)
            r2 = r0
            if (r3 == 0) goto L16
            goto L17
        L16:
            r1 = 0
        L17:
            com.xiaomi.push.di r0 = new com.xiaomi.push.di
            r3 = 0
            if (r2 == 0) goto L1f
            com.xiaomi.channel.commonutils.logger.LoggerInterface r2 = com.xiaomi.mipush.sdk.Logger.sUserLogger
            goto L20
        L1f:
            r2 = r3
        L20:
            if (r1 == 0) goto L26
            com.xiaomi.push.dj r3 = com.xiaomi.push.dj.a(r4)
        L26:
            r0.<init>(r2, r3)
            com.xiaomi.channel.commonutils.logger.b.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.Logger.setPushLog(android.content.Context):void");
    }

    @Deprecated
    public static void uploadLogFile(Context context, boolean z) {
    }
}
