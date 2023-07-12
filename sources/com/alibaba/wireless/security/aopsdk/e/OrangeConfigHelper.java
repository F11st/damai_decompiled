package com.alibaba.wireless.security.aopsdk.e;

import android.util.Log;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.alibaba.wireless.security.aopsdk.i.LogUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.c */
/* loaded from: classes.dex */
public class OrangeConfigHelper {
    private static final String b = "AOP-OrangeConfigHelper";
    private static boolean d;
    private static Object e;
    private static Class f;
    private static Method g;
    private static Method h;
    public static final String a = "secaop_orange_namespace";
    private static String[] c = {a};

    /* compiled from: OrangeConfigHelper.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.e.c$a */
    /* loaded from: classes.dex */
    public static class C3975a implements InvocationHandler {
        public final /* synthetic */ InterfaceC3976b a;

        public C3975a(InterfaceC3976b interfaceC3976b) {
            this.a = interfaceC3976b;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if (ConfigManager.DEBUG) {
                    Log.d(OrangeConfigHelper.b, "In OrangeListener: " + method.getName() + " called");
                }
            } catch (Throwable th) {
                Log.e(OrangeConfigHelper.b, "", th);
            }
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (method.getName().equals("onConfigUpdate")) {
                if (objArr == null || objArr.length < 2) {
                    return null;
                }
                this.a.a((String) objArr[0], (Map) objArr[1]);
            }
            return null;
        }
    }

    /* compiled from: OrangeConfigHelper.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.e.c$b */
    /* loaded from: classes.dex */
    public interface InterfaceC3976b {
        void a(String str, Map<String, String> map);
    }

    public static void a(InterfaceC3976b interfaceC3976b) {
        if (!d) {
            b();
        }
        if (e != null && g != null && f != null) {
            try {
                Map<String, String> a2 = a(a);
                if (a2 != null) {
                    interfaceC3976b.a(a, a2);
                }
            } catch (Throwable th) {
                Log.e(b, "Get config", th);
            }
            try {
                g.invoke(e, c, Proxy.newProxyInstance(f.getClassLoader(), new Class[]{f}, new C3975a(interfaceC3976b)), Boolean.TRUE);
                Log.i(b, "Orange listener register success");
            } catch (Throwable th2) {
                LogUtils.a(b, "Register Method failed", th2);
            }
        } else {
            LogUtils.a(b, "Orange reflect failed");
        }
        if (ConfigManager.DEBUG) {
            Log.e(b, "Finish registerOrangeListener!");
        }
    }

    private static void b() {
        try {
            Class<?> cls = Class.forName("com.taobao.orange.OrangeConfig");
            f = Class.forName("com.taobao.orange.OConfigListener");
            e = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            g = cls.getDeclaredMethod("registerListener", String[].class, f, Boolean.TYPE);
            h = cls.getDeclaredMethod("getConfigs", String.class);
            d = true;
        } catch (Throwable th) {
            LogUtils.a(b, "Init orange listener failed", th);
        }
    }

    public static boolean a() {
        if (!d) {
            b();
        }
        return (e == null || g == null || f == null) ? false : true;
    }

    public static Map<String, String> a(String str) {
        Object obj;
        if (!d) {
            b();
        }
        Method method = h;
        if (method != null && (obj = e) != null) {
            try {
                return (Map) method.invoke(obj, str);
            } catch (Throwable th) {
                LogUtils.a(b, "getConfigs failed", th);
            }
        }
        return null;
    }
}
