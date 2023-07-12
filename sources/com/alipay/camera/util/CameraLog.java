package com.alipay.camera.util;

import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraLog {
    private static Method a;

    private static void a(Class[] clsArr, Object[] objArr) {
        try {
            if (a == null) {
                a = MPaasLogger.class.getMethod("a", clsArr);
            }
            a.invoke(null, objArr);
        } catch (Throwable unused) {
        }
    }

    public static void d(String str, String str2) {
        a(new Class[]{Character.TYPE, String.class, Object[].class}, new Object[]{'d', str, new Object[]{str2}});
    }

    public static void e(String str, String str2) {
        a(new Class[]{Character.TYPE, String.class, Object[].class}, new Object[]{'e', str, new Object[]{str2}});
    }
}
