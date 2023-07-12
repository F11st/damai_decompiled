package com.uploader.export;

import android.content.Context;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ConcurrentHashMap;
import tb.ze0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploaderGlobal {
    public static final int DEFAULT_INSTANCE_TYPE = 0;
    private static volatile Context a;
    private static final ConcurrentHashMap<Integer, ze0> b;
    private static final ConcurrentHashMap<Integer, ze0> c;
    private static final ConcurrentHashMap<Integer, ze0> d;
    private static final ConcurrentHashMap<Integer, IUploaderDependency> e;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes11.dex */
    public @interface Definition {
    }

    static {
        ConcurrentHashMap<Integer, ze0> concurrentHashMap = new ConcurrentHashMap<>();
        b = concurrentHashMap;
        ConcurrentHashMap<Integer, ze0> concurrentHashMap2 = new ConcurrentHashMap<>();
        c = concurrentHashMap2;
        ConcurrentHashMap<Integer, ze0> concurrentHashMap3 = new ConcurrentHashMap<>();
        d = concurrentHashMap3;
        e = new ConcurrentHashMap<>();
        concurrentHashMap.put(0, new ze0(0, "21646297", "arup.m.taobao.com", "106.11.53.94"));
        concurrentHashMap2.put(0, new ze0(1, "21646297", "pre-arup.m.taobao.com", "140.205.173.180"));
        concurrentHashMap3.put(0, new ze0(2, "4272", "daily.arup.m.alibaba.net", "100.69.167.214"));
    }

    public static IUploaderDependency a(Integer num) {
        return e.get(num);
    }

    public static ze0 b(int i, int i2) {
        if (i != 1) {
            if (i != 2) {
                return b.get(Integer.valueOf(i2));
            }
            return d.get(Integer.valueOf(i2));
        }
        return c.get(Integer.valueOf(i2));
    }

    public static IUploaderDependency c(@NonNull IUploaderDependency iUploaderDependency) {
        return e.put(Integer.valueOf(iUploaderDependency.getEnvironment().getInstanceType()), iUploaderDependency);
    }

    public static ze0 d(int i, int i2, String str) {
        ConcurrentHashMap<Integer, ze0> concurrentHashMap;
        ze0 put;
        if (i == 1) {
            concurrentHashMap = c;
        } else if (i != 2) {
            concurrentHashMap = b;
        } else {
            concurrentHashMap = d;
        }
        synchronized (concurrentHashMap) {
            ze0 ze0Var = concurrentHashMap.get(Integer.valueOf(i2));
            put = concurrentHashMap.put(Integer.valueOf(i2), new ze0(i, str, ze0Var.c, ze0Var.d, ze0Var.e));
        }
        return put;
    }

    public static ze0 e(int i, String str) {
        return d(i, 0, str);
    }

    public static Context f() {
        if (a != null) {
            return a;
        }
        synchronized (UploaderGlobal.class) {
            if (a != null) {
                return a;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                a = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return a;
        }
    }

    public static void g(Context context) {
        if (context == null) {
            return;
        }
        a = context.getApplicationContext();
    }
}
