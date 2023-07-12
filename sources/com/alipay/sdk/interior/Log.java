package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.m.k.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.e;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Log {
    public static long a;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface ISdkLogCallback {
        void onLogLine(String str);
    }

    public static boolean forcedLogReport(Context context) {
        try {
            b.d().a(context);
            long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (elapsedRealtime - a < 600) {
                return false;
            }
            a = elapsedRealtime;
            a.a(context);
            return true;
        } catch (Exception e) {
            e.a(e);
            return false;
        }
    }

    public static void setupLogCallback(ISdkLogCallback iSdkLogCallback) {
        e.a(iSdkLogCallback);
    }
}
