package com.youku.live.dago.widgetlib.wedome.framework;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLAdapterFactory {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String YKLAdapterFactoryDefaultKey = "default";
    private static YKLAdapterFactory sInstance;
    public Map<Class, Map<String, Class>> adapterClassMapper = new LinkedHashMap();

    public static YKLAdapterFactory getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032857467")) {
            return (YKLAdapterFactory) ipChange.ipc$dispatch("1032857467", new Object[0]);
        }
        YKLAdapterFactory yKLAdapterFactory = sInstance;
        if (yKLAdapterFactory != null) {
            return yKLAdapterFactory;
        }
        YKLAdapterFactory yKLAdapterFactory2 = new YKLAdapterFactory();
        sInstance = yKLAdapterFactory2;
        return yKLAdapterFactory2;
    }

    public <T, A> A createInterface(Class<T> cls) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1933637246") ? (A) ipChange.ipc$dispatch("1933637246", new Object[]{this, cls}) : (A) createInterface(cls, YKLAdapterFactoryDefaultKey, false);
    }

    public boolean setInterface(Class cls, Class cls2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "579732657") ? ((Boolean) ipChange.ipc$dispatch("579732657", new Object[]{this, cls, cls2})).booleanValue() : setInterface(cls, cls2, YKLAdapterFactoryDefaultKey);
    }

    public <T, A> A createInterface(Class<T> cls, String str, boolean z) {
        Map<String, Class> map;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830646436")) {
            return (A) ipChange.ipc$dispatch("-830646436", new Object[]{this, cls, str, Boolean.valueOf(z)});
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
        if (AndroidInstantRuntime.support(ipChange, "58604859")) {
            return ((Boolean) ipChange.ipc$dispatch("58604859", new Object[]{this, cls, cls2, str})).booleanValue();
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
        return AndroidInstantRuntime.support(ipChange, "277627550") ? (A) ipChange.ipc$dispatch("277627550", new Object[]{this, cls, context}) : (A) createInterface(cls, context, YKLAdapterFactoryDefaultKey, false);
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [A, java.lang.Object] */
    public <T, A> A createInterface(Class<T> cls, Context context, String str, boolean z) {
        Map<String, Class> map;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550414532")) {
            return (A) ipChange.ipc$dispatch("-550414532", new Object[]{this, cls, context, str, Boolean.valueOf(z)});
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
