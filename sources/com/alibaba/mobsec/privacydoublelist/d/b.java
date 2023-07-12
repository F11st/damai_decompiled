package com.alibaba.mobsec.privacydoublelist.d;

import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTTracker;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class b {
    public static int a;
    public static volatile int b;
    public static Class<?> c;
    public static Constructor<?> d;
    public static Method e;
    public static Method f;
    public static Method g;
    public static Method h;
    public static final boolean i = PdlEnvUtils.a;

    static {
        "0123456789abcdef".toCharArray();
    }

    public static int a() {
        if (b == 0) {
            synchronized (b.class) {
                if (b == 0) {
                    try {
                        int i2 = UTAnalytics.a;
                        c = UTAnalytics.class;
                        int i3 = UTTracker.PAGE_STATUS_CODE_302;
                        try {
                            d = UTOriginalCustomHitBuilder.class.getConstructor(String.class, Integer.TYPE, String.class, String.class, String.class, Map.class);
                            e = UTOriginalCustomHitBuilder.class.getMethod("build", new Class[0]);
                            f = c.getMethod("getInstance", new Class[0]);
                            g = c.getMethod("getTracker", String.class);
                            UTOriginalCustomHitBuilder.class.getMethod("setProperties", Map.class);
                            h = UTTracker.class.getMethod("send", Map.class);
                            if (i) {
                                Log.i("UTMethodJniBridge", "UserTrack is Aviable");
                            }
                            a = 1;
                        } catch (NoSuchMethodException e2) {
                            if (i) {
                                Log.e("UTMethodJniBridge", e2.toString(), e2);
                            }
                        }
                    } catch (ClassNotFoundException e3) {
                        if (i) {
                            Log.e("UTMethodJniBridge", e3.toString(), e3);
                        }
                    }
                    b = 1;
                }
            }
        }
        return a;
    }
}
