package com.alipay.sdk.m.w;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4302e;
import com.alipay.sdk.m.u.C4318n;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.w.a */
/* loaded from: classes10.dex */
public class C4323a {
    public static final String a = "CDT";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> g;
    public static ExecutorService h = Executors.newFixedThreadPool(16);

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.a$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC4324a<T, R> {
        R a(T t);
    }

    public static synchronized void a(int i, Object obj) {
        synchronized (C4323a.class) {
            if (g == null) {
                g = new ConcurrentHashMap<>();
            }
            g.put(Integer.valueOf(i), new Pair<>(Long.valueOf(SystemClock.elapsedRealtime()), obj));
        }
    }

    public static Pair<Boolean, ?> a(int i, TimeUnit timeUnit, long j) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> concurrentHashMap = g;
        if (concurrentHashMap == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Pair<Long, ?> pair = concurrentHashMap.get(Integer.valueOf(i));
        if (pair == null) {
            return new Pair<>(Boolean.FALSE, null);
        }
        Long l = (Long) pair.first;
        Object obj = pair.second;
        if (l != null && SystemClock.elapsedRealtime() - l.longValue() <= TimeUnit.MILLISECONDS.convert(j, timeUnit)) {
            return new Pair<>(Boolean.TRUE, obj);
        }
        return new Pair<>(Boolean.FALSE, null);
    }

    public static synchronized void a() {
        synchronized (C4323a.class) {
            g = null;
        }
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static <T> T a(int i, long j, TimeUnit timeUnit, InterfaceC4324a<Object, Boolean> interfaceC4324a, Callable<T> callable, boolean z, long j2, TimeUnit timeUnit2, C4293a c4293a, boolean z2) {
        T call;
        try {
            Pair<Boolean, ?> a2 = a(i, timeUnit, j);
            if (((Boolean) a2.first).booleanValue() && interfaceC4324a.a(a2.second).booleanValue()) {
                C4302e.d("getC", i + " got " + a2.second);
                return (T) a2.second;
            }
            if (z2 && C4318n.h()) {
                C4218a.b(c4293a, C4226b.l, "ch_get_main", "" + i);
                C4302e.d("getC", i + " skip");
                call = null;
            } else {
                if (z) {
                    call = h.submit(callable).get(j2, timeUnit2);
                } else {
                    call = callable.call();
                }
                a(i, call);
            }
            C4302e.d("getC", i + " new " + call);
            return call;
        } catch (Throwable th) {
            C4302e.a(a, "ch_get_e|" + i, th);
            C4218a.a(c4293a, C4226b.l, "ch_get_e|" + i, th);
            C4302e.d("getC", i + " err");
            return null;
        }
    }
}
