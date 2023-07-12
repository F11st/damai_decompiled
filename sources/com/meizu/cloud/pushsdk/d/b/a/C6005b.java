package com.meizu.cloud.pushsdk.d.b.a;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.b.a.b */
/* loaded from: classes10.dex */
public class C6005b {
    private static ExecutorService a = null;
    private static int b = 2;

    public static ExecutorService a() {
        synchronized (C6005b.class) {
            if (a == null) {
                a = Executors.newScheduledThreadPool(b);
            }
        }
        return a;
    }

    public static Future a(Callable callable) {
        return a().submit(callable);
    }

    public static void a(int i) {
        b = i;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
