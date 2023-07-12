package com.taobao.monitor.impl.common;

import android.app.ActivityManager;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Observer;
import tb.gn1;
import tb.ki0;
import tb.pb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a {
    public static void a(List<Observer> list) {
        Object a;
        Log.d("ActivityManagerHook", "start Hook IActivityManager...");
        try {
            Class<?> cls = Class.forName("android.app.ActivityManagerNative");
            if (Build.VERSION.SDK_INT >= 26) {
                a = ki0.a(null, ActivityManager.class.getDeclaredField("IActivityManagerSingleton"));
            } else {
                a = ki0.a(null, cls.getDeclaredField("gDefault"));
            }
            Class<?> cls2 = Class.forName("android.util.Singleton");
            try {
                Method declaredMethod = cls2.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(a, new Object[0]);
            } catch (Exception unused) {
            }
            Field declaredField = cls2.getDeclaredField("mInstance");
            Object a2 = ki0.a(a, declaredField);
            if (a2 == null) {
                return;
            }
            Class<?> cls3 = Class.forName("android.app.IActivityManager");
            b bVar = new b(a2);
            for (Observer observer : list) {
                bVar.addObserver(observer);
            }
            ki0.b(a, declaredField, a2, Proxy.newProxyInstance(a.class.getClassLoader(), new Class[]{cls3}, bVar));
            pb1.a("ActivityManagerHook", "Hook IActivityManager success");
        } catch (Exception unused2) {
            pb1.a("ActivityManagerHook", "Hook IActivityManager failed");
        }
    }
}
