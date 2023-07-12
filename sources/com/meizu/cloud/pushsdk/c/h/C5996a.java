package com.meizu.cloud.pushsdk.c.h;

import android.net.TrafficStats;
import com.meizu.cloud.pushsdk.c.a.C5944a;
import com.meizu.cloud.pushsdk.c.a.C5945b;
import com.meizu.cloud.pushsdk.c.a.EnumC5952e;
import com.meizu.cloud.pushsdk.c.c.C5971k;
import com.meizu.cloud.pushsdk.util.MinSdkChecker;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.h.a */
/* loaded from: classes10.dex */
public final class C5996a {
    public static void a(C5971k c5971k, C5945b c5945b) {
        if (c5945b.f() == EnumC5952e.OK_HTTP_RESPONSE || c5971k == null || c5971k.b() == null || c5971k.b().a() == null) {
            return;
        }
        try {
            try {
                c5971k.b().a().close();
                if (!MinSdkChecker.isSupportNotificationChannel()) {
                    return;
                }
            } catch (Exception unused) {
                C5944a.a("Unable to close source data");
                if (!MinSdkChecker.isSupportNotificationChannel()) {
                    return;
                }
            }
            TrafficStats.clearThreadStatsTag();
        } catch (Throwable th) {
            if (MinSdkChecker.isSupportNotificationChannel()) {
                TrafficStats.clearThreadStatsTag();
            }
            throw th;
        }
    }
}
