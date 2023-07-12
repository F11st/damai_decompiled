package com.youku.live.dago.widgetlib.ailpbaselib.framework;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPAdapterFactory {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String YKLAdapterFactoryDefaultKey = "default";
    private static AILPAdapterFactory sInstance;
    public Map<Class, Map<String, Class>> adapterClassMapper = new LinkedHashMap();

    public static AILPAdapterFactory getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-496509093")) {
            return (AILPAdapterFactory) ipChange.ipc$dispatch("-496509093", new Object[0]);
        }
        AILPAdapterFactory aILPAdapterFactory = sInstance;
        if (aILPAdapterFactory != null) {
            return aILPAdapterFactory;
        }
        AILPAdapterFactory aILPAdapterFactory2 = new AILPAdapterFactory();
        sInstance = aILPAdapterFactory2;
        return aILPAdapterFactory2;
    }

    public <T, A> A createInterface(Class<T> cls) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "820277829") ? (A) ipChange.ipc$dispatch("820277829", new Object[]{this, cls}) : (A) createInterface(cls, YKLAdapterFactoryDefaultKey, false);
    }

    public boolean setInterface(Class cls, Class cls2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-661752246") ? ((Boolean) ipChange.ipc$dispatch("-661752246", new Object[]{this, cls, cls2})).booleanValue() : setInterface(cls, cls2, YKLAdapterFactoryDefaultKey);
    }

    public <T, A> A createInterface(Class<T> cls, String str, boolean z) {
        Map<String, Class> map;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1086824501")) {
            return (A) ipChange.ipc$dispatch("1086824501", new Object[]{this, cls, str, Boolean.valueOf(z)});
        }
        Map<Class, Map<String, Class>> map2 = this.adapterClassMapper;
        if (map2 == null || (map = map2.get(cls)) == null) {
            return null;
        }
        Class cls2 = map.get(str);
        if (cls2 == null && z) {
            cls2 = map.get(YKLAdapterFactoryDefaultKey);
        }
        if (cls2 == null) {
            return null;
        }
        try {
            return (A) cls2.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean setInterface(Class cls, Class cls2, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501092500")) {
            return ((Boolean) ipChange.ipc$dispatch("1501092500", new Object[]{this, cls, cls2, str})).booleanValue();
        }
        Map<String, Class> map = this.adapterClassMapper.get(cls);
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        map.put(str, cls2);
        this.adapterClassMapper.put(cls, map);
        return true;
    }

    public <T, A> A createInterface(Class<T> cls, Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1154956105") ? (A) ipChange.ipc$dispatch("-1154956105", new Object[]{this, cls, context}) : (A) createInterface(cls, context, YKLAdapterFactoryDefaultKey, false);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [A, java.lang.Object] */
    public <T, A> A createInterface(Class<T> cls, Context context, String str, boolean z) {
        Map<String, Class> map;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1690272899")) {
            return (A) ipChange.ipc$dispatch("1690272899", new Object[]{this, cls, context, str, Boolean.valueOf(z)});
        }
        Map<Class, Map<String, Class>> map2 = this.adapterClassMapper;
        if (map2 == null || (map = map2.get(cls)) == null) {
            return null;
        }
        Class cls2 = map.get(str);
        if (cls2 == null && z) {
            cls2 = map.get(YKLAdapterFactoryDefaultKey);
        }
        if (cls2 == null) {
            return null;
        }
        try {
            Constructor<T> declaredConstructor = cls2.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(context);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
