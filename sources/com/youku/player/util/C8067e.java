package com.youku.player.util;

import java.lang.reflect.Method;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.youku.player.util.e */
/* loaded from: classes13.dex */
public class C8067e {
    private static Class<?> a;
    private static Method b;
    private static Method c;
    private static Method d;

    public static int a(String str, int i) {
        a();
        try {
            return ((Integer) d.invoke(a, str, Integer.valueOf(i))).intValue();
        } catch (Exception unused) {
            C8063c.a("SystemUtils", "get key " + str + " failed ");
            return i;
        }
    }

    private static void a() {
        try {
            if (a == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                a = cls;
                b = cls.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class);
                c = a.getDeclaredMethod("set", String.class, String.class);
                d = a.getDeclaredMethod("getInt", String.class, Integer.TYPE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
