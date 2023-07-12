package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.s.C4295b;
import com.alipay.sdk.m.u.C4302e;

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
            C4295b.d().a(context);
            long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (elapsedRealtime - a < 600) {
                return false;
            }
            a = elapsedRealtime;
            C4218a.a(context);
            return true;
        } catch (Exception e) {
            C4302e.a(e);
            return false;
        }
    }

    public static void setupLogCallback(ISdkLogCallback iSdkLogCallback) {
        C4302e.a(iSdkLogCallback);
    }
}
