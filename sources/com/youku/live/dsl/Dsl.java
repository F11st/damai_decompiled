package com.youku.live.dsl;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Dsl {
    private static transient /* synthetic */ IpChange $ipChange;
    private static Map<String, Object> globalDslImplements;
    private static Context sContext;
    private static volatile boolean sDebuggable;

    public static Context getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2005515280") ? (Context) ipChange.ipc$dispatch("-2005515280", new Object[0]) : sContext;
    }

    public static <T> T getDefaultServiceImpl(Class<T> cls) {
        String str;
        Class<?> cls2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1886075524")) {
            return (T) ipChange.ipc$dispatch("1886075524", new Object[]{cls});
        }
        String name = cls.getName();
        if (name.endsWith("Interface")) {
            str = name.replace("Interface", "Imp");
        } else {
            str = name + "Imp";
        }
        T t = null;
        try {
            cls2 = Class.forName(str);
        } catch (Exception e) {
            if (sDebuggable) {
                e.printStackTrace();
            }
            cls2 = null;
        }
        if (cls2 == null) {
            if (name.endsWith("Interface")) {
                str = name.replace("Interface", "VirtualImp");
            } else {
                str = name + "VirtualImp";
            }
        }
        try {
            Class<?> cls3 = Class.forName(str);
            try {
                Method declaredMethod = cls3.getDeclaredMethod("getInstance", new Class[0]);
                if (declaredMethod != null) {
                    t = (T) declaredMethod.invoke(null, new Object[0]);
                }
                if (t != null) {
                    getDslImplments().put(name, t);
                    return t;
                }
                return t;
            } catch (Exception e2) {
                try {
                    return (T) cls3.newInstance();
                } catch (Exception unused) {
                    if (sDebuggable) {
                        e2.printStackTrace();
                        return t;
                    }
                    return t;
                }
            }
        } catch (Exception e3) {
            if (sDebuggable) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    private static Map<String, Object> getDslImplments() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "641711520")) {
            return (Map) ipChange.ipc$dispatch("641711520", new Object[0]);
        }
        Map<String, Object> map = globalDslImplements;
        if (map != null) {
            return map;
        }
        synchronized (Dsl.class) {
            if (globalDslImplements == null) {
                globalDslImplements = new ConcurrentHashMap();
            }
        }
        return globalDslImplements;
    }

    public static <T> T getService(Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1426502841")) {
            return (T) ipChange.ipc$dispatch("-1426502841", new Object[]{cls});
        }
        if (cls == null) {
            return null;
        }
        T t = (T) getDslImplments().get(cls.getName());
        if (t != null) {
            return t;
        }
        T t2 = (T) getDefaultServiceImpl(cls);
        if (t2 != null) {
            return t2;
        }
        return null;
    }

    public static void initWithContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1809100312")) {
            ipChange.ipc$dispatch("-1809100312", new Object[]{context});
        } else {
            sContext = context;
        }
    }

    public static <T> void registerService(Class<T> cls, T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1151625998")) {
            ipChange.ipc$dispatch("-1151625998", new Object[]{cls, t});
        } else if (cls == null || t == null) {
        } else {
            getDslImplments().put(cls.getName(), t);
        }
    }

    public static void setDebuggable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1713297557")) {
            ipChange.ipc$dispatch("-1713297557", new Object[]{Boolean.valueOf(z)});
        } else {
            sDebuggable = z;
        }
    }
}
