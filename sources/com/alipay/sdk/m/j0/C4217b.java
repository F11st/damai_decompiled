package com.alipay.sdk.m.j0;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.j0.b */
/* loaded from: classes12.dex */
public class C4217b {
    public static final String a = "IdentifierManager";
    public static Object b;
    public static Class<?> c;
    public static Method d;
    public static Method e;
    public static Method f;
    public static Method g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            c = cls;
            b = cls.newInstance();
            d = c.getMethod("getUDID", Context.class);
            e = c.getMethod("getOAID", Context.class);
            f = c.getMethod("getVAID", Context.class);
            g = c.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e(a, "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (c == null || b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, e);
    }

    public static String c(Context context) {
        return a(context, d);
    }

    public static String d(Context context) {
        return a(context, f);
    }

    public static String a(Context context) {
        return a(context, g);
    }

    public static String a(Context context, Method method) {
        Object obj = b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(obj, context);
            if (invoke != null) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e(a, "invoke exception!", e2);
            return null;
        }
    }
}
