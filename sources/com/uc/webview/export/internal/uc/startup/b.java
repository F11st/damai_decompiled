package com.uc.webview.export.internal.uc.startup;

import android.os.SystemClock;
import android.util.Pair;
import com.uc.webview.export.internal.SDKFactory;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class b {
    private static ConcurrentHashMap<Integer, Pair<Long, Long>> a = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<Integer, String> b = new ConcurrentHashMap<>();

    static {
        a(534);
    }

    public static void a() {
        a(1);
        a(2, SystemClock.elapsedRealtime());
        long j = SDKFactory.q;
        long j2 = SDKFactory.r;
        if (a.containsKey(539)) {
            return;
        }
        a.put(539, new Pair<>(Long.valueOf(j), Long.valueOf(j2)));
    }

    public static void b() {
        a(272);
    }

    public static Pair<Object, Object> c() {
        return new Pair<>(a, b);
    }

    public static long d() {
        return System.currentTimeMillis();
    }

    public static void a(int i) {
        if (a.containsKey(Integer.valueOf(i))) {
            return;
        }
        a.put(Integer.valueOf(i), new Pair<>(Long.valueOf(System.currentTimeMillis()), Long.valueOf(SystemClock.currentThreadTimeMillis())));
    }

    public static void a(int i, long j) {
        if (a.containsKey(Integer.valueOf(i))) {
            return;
        }
        a(i, String.valueOf(j));
    }

    public static void a(int i, String str) {
        if (b.containsKey(Integer.valueOf(i))) {
            return;
        }
        b.put(Integer.valueOf(i), str);
    }
}
