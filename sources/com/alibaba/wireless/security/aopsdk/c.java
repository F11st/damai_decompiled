package com.alibaba.wireless.security.aopsdk;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ReflectCache.java */
/* loaded from: classes.dex */
public class c {
    public static Map<String, Method> a;
    public static Map<String, Class> b;

    public static synchronized Map<String, Class> a() {
        Map<String, Class> map;
        synchronized (c.class) {
            if (b == null) {
                b = new HashMap();
            }
            map = b;
        }
        return map;
    }

    public static synchronized Map<String, Method> b() {
        Map<String, Method> map;
        synchronized (c.class) {
            if (a == null) {
                a = new HashMap();
            }
            map = a;
        }
        return map;
    }

    public static void a(String str, Method method) {
        b().put(str, method);
    }

    public static Method b(String str) {
        return b().get(str);
    }

    public static Class a(String str) {
        return a().get(str);
    }

    public static void a(String str, Class cls) {
        a().put(str, cls);
    }

    public static Method a(String str, Class cls, String str2, Class... clsArr) {
        Method b2 = b(str);
        if (b2 == null) {
            try {
                b2 = cls.getDeclaredMethod(str2, clsArr);
            } catch (Throwable th) {
            }
            if (b2 != null) {
                a(str, b2);
            }
        }
        return b2;
    }
}
