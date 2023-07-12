package com.uc.sandboxExport.helper;

import java.lang.reflect.Method;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class e {
    private static Class<?> a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Method f;
    private static Method g;

    static {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            a = cls;
            b = cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
            c = a.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class);
            d = a.getMethod("getInt", String.class, Integer.TYPE);
            e = a.getMethod("getLong", String.class, Long.TYPE);
            f = a.getMethod("getBoolean", String.class, Boolean.TYPE);
            g = a.getMethod("set", String.class, String.class);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean a(String str) {
        Method method;
        if (a != null && (method = f) != null) {
            try {
                return ((Boolean) method.invoke(null, str, Boolean.FALSE)).booleanValue();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }
}
