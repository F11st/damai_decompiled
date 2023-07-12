package com.alibaba.analytics.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UTServerAppStatusTrigger {
    private static boolean a = true;
    private static List<UTServerAppStatusChangeCallback> b = Collections.synchronizedList(new ArrayList());

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public interface UTServerAppStatusChangeCallback {
        void onBackground();

        void onForeground();
    }

    public static void a() {
        c(false);
    }

    public static void b() {
        c(true);
    }

    private static void c(boolean z) {
        Logger.f("UTServerAppStatusTrigger", "postAppStatus mIsAppOnForeground", Boolean.valueOf(a), "isAppOnForeground", Boolean.valueOf(z));
        a = z;
        for (int i = 0; i < b.size(); i++) {
            if (z) {
                b.get(i).onForeground();
            } else {
                b.get(i).onBackground();
            }
        }
    }

    public static void d(UTServerAppStatusChangeCallback uTServerAppStatusChangeCallback) {
        if (b.contains(uTServerAppStatusChangeCallback)) {
            return;
        }
        b.add(uTServerAppStatusChangeCallback);
    }
}
