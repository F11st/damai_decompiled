package com.alipay.sdk.m.w;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    public static final String a = "CDT";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> g;
    public static ExecutorService h = Executors.newFixedThreadPool(16);

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0202a<T, R> {
        R a(T t);
    }

    public static synchronized void a(int i, Object obj) {
        synchronized (a.class) {
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
        synchronized (a.class) {
            g = null;
        }
    }

    public static Context a(Context context) {
        if (context == null) {
            return null;
        }
        return context.getApplicationContext();
    }

    public static <T> T a(int i, long j, TimeUnit timeUnit, InterfaceC0202a<Object, Boolean> interfaceC0202a, Callable<T> callable, boolean z, long j2, TimeUnit timeUnit2, com.alipay.sdk.m.s.a aVar, boolean z2) {
        T call;
        try {
            Pair<Boolean, ?> a2 = a(i, timeUnit, j);
            if (((Boolean) a2.first).booleanValue() && interfaceC0202a.a(a2.second).booleanValue()) {
                e.d("getC", i + " got " + a2.second);
                return (T) a2.second;
            }
            if (z2 && n.h()) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, "ch_get_main", "" + i);
                e.d("getC", i + " skip");
                call = null;
            } else {
                if (z) {
                    call = h.submit(callable).get(j2, timeUnit2);
                } else {
                    call = callable.call();
                }
                a(i, call);
            }
            e.d("getC", i + " new " + call);
            return call;
        } catch (Throwable th) {
            e.a(a, "ch_get_e|" + i, th);
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "ch_get_e|" + i, th);
            e.d("getC", i + " err");
            return null;
        }
    }
}
