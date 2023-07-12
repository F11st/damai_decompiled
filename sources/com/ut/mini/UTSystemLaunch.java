package com.ut.mini;

import android.content.Context;
import android.os.SystemClock;
import com.alibaba.analytics.AnalyticsMgr;
import com.ut.mini.UTHitBuilders;
import tb.hl2;
import tb.u6;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTSystemLaunch {
    private static volatile boolean bSend;

    UTSystemLaunch() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void send() {
        long currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("BootTime");
        uTCustomHitBuilder.setProperty("bootTime", "" + currentTimeMillis);
        UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sendBootTime(final Context context) {
        synchronized (UTSystemLaunch.class) {
            if (bSend) {
                return;
            }
            bSend = true;
            hl2.c().f(new Runnable() { // from class: com.ut.mini.UTSystemLaunch.1
                @Override // java.lang.Runnable
                public void run() {
                    Context context2 = context;
                    if (context2 == null || !u6.h(context2)) {
                        return;
                    }
                    UTSystemLaunch.send();
                    try {
                        Thread.sleep(500L);
                        AnalyticsMgr.G();
                        Thread.sleep(500L);
                        AnalyticsMgr.F();
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }
}
