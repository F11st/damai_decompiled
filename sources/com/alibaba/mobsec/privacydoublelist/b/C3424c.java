package com.alibaba.mobsec.privacydoublelist.b;

import android.util.Log;
import com.alibaba.mobsec.privacydoublelist.PdlEnvUtils;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.mobsec.privacydoublelist.b.c */
/* loaded from: classes6.dex */
public class C3424c {
    public static final String[] a = {"pdl_orange_namespace"};
    public static boolean b;
    public static Object c;
    public static Class<?> d;
    public static Method e;
    public static Method f;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.mobsec.privacydoublelist.b.c$a */
    /* loaded from: classes6.dex */
    public interface InterfaceC3425a {
    }

    public static Map<String, String> a(String str) {
        Object obj;
        if (!b) {
            a();
        }
        Method method = f;
        if (method == null || (obj = c) == null) {
            return null;
        }
        try {
            return (Map) method.invoke(obj, str);
        } catch (Throwable th) {
            if (PdlEnvUtils.a) {
                Log.e("AOP-OrangeConfigHelper", "getConfigs failed", th);
                return null;
            }
            return null;
        }
    }

    public static void a() {
        try {
            d = OConfigListener.class;
            c = OrangeConfig.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            e = OrangeConfig.class.getDeclaredMethod("registerListener", String[].class, d, Boolean.TYPE);
            f = OrangeConfig.class.getDeclaredMethod("getConfigs", String.class);
            b = true;
        } catch (Throwable th) {
            if (PdlEnvUtils.a) {
                Log.e("AOP-OrangeConfigHelper", "Init orange listener failed", th);
            }
        }
    }
}
