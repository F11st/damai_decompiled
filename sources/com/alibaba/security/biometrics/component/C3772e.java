package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.logic.C3775a;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.c.C3800a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.component.e */
/* loaded from: classes8.dex */
public class C3772e {
    private static final String a = "e";
    private static final LinkedHashMap<Class<? extends InterfaceC3771d>, InterfaceC3771d> b = new LinkedHashMap<>();
    private static final List<Class<? extends InterfaceC3771d>> c = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.component.e$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    static class AnonymousClass1 implements Comparator<Class<? extends InterfaceC3771d>> {
        AnonymousClass1() {
        }

        private static int a(Class<? extends InterfaceC3771d> cls, Class<? extends InterfaceC3771d> cls2) {
            if (cls == null || cls2 == null) {
                return 0;
            }
            InterfaceC3773f interfaceC3773f = (InterfaceC3773f) cls.getAnnotation(InterfaceC3773f.class);
            InterfaceC3773f interfaceC3773f2 = (InterfaceC3773f) cls2.getAnnotation(InterfaceC3773f.class);
            if (interfaceC3773f == null && interfaceC3773f2 == null) {
                return 0;
            }
            if (interfaceC3773f == null || interfaceC3773f2 != null) {
                if (interfaceC3773f != null || interfaceC3773f2 == null) {
                    if (interfaceC3773f.a() == interfaceC3773f2.a()) {
                        return 0;
                    }
                    return interfaceC3773f.a() > interfaceC3773f2.a() ? -1 : 1;
                }
                return 1;
            }
            return -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Class<? extends InterfaceC3771d> cls, Class<? extends InterfaceC3771d> cls2) {
            Class<? extends InterfaceC3771d> cls3 = cls;
            Class<? extends InterfaceC3771d> cls4 = cls2;
            if (cls3 == null || cls4 == null) {
                return 0;
            }
            InterfaceC3773f interfaceC3773f = (InterfaceC3773f) cls3.getAnnotation(InterfaceC3773f.class);
            InterfaceC3773f interfaceC3773f2 = (InterfaceC3773f) cls4.getAnnotation(InterfaceC3773f.class);
            if (interfaceC3773f == null && interfaceC3773f2 == null) {
                return 0;
            }
            if (interfaceC3773f == null || interfaceC3773f2 != null) {
                if (interfaceC3773f != null || interfaceC3773f2 == null) {
                    if (interfaceC3773f.a() == interfaceC3773f2.a()) {
                        return 0;
                    }
                    return interfaceC3773f.a() > interfaceC3773f2.a() ? -1 : 1;
                }
                return 1;
            }
            return -1;
        }
    }

    public static <T extends InterfaceC3771d> T a(Class<T> cls) {
        LinkedHashMap<Class<? extends InterfaceC3771d>, InterfaceC3771d> linkedHashMap = b;
        T t = linkedHashMap.containsKey(cls) ? (T) linkedHashMap.get(cls) : null;
        if (t == null) {
            T t2 = (T) b(cls);
            linkedHashMap.put(cls, t2);
            return t2;
        }
        return t;
    }

    public static void b() {
        List<Class<? extends InterfaceC3771d>> list = c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Class<? extends InterfaceC3771d> cls : list) {
            InterfaceC3771d interfaceC3771d = b.get(cls);
            if (interfaceC3771d != null && interfaceC3771d.b()) {
                return;
            }
        }
    }

    public static void c() {
        List<Class<? extends InterfaceC3771d>> list = c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Class<? extends InterfaceC3771d> cls : list) {
            InterfaceC3771d interfaceC3771d = b.get(cls);
            if (interfaceC3771d != null && interfaceC3771d.c()) {
                break;
            }
        }
        b.clear();
    }

    private static void d() {
        LinkedHashMap<Class<? extends InterfaceC3771d>, InterfaceC3771d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(C3770c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(C3774g.class, null);
        linkedHashMap.put(C3775a.class, null);
        linkedHashMap.put(C3769b.class, null);
        for (Map.Entry<Class<? extends InterfaceC3771d>, InterfaceC3771d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new AnonymousClass1());
    }

    private static void e() {
        LinkedHashMap<Class<? extends InterfaceC3771d>, InterfaceC3771d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(C3770c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(C3774g.class, null);
        linkedHashMap.put(C3775a.class, null);
        linkedHashMap.put(C3769b.class, null);
        for (Map.Entry<Class<? extends InterfaceC3771d>, InterfaceC3771d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new AnonymousClass1());
        for (Map.Entry<Class<? extends InterfaceC3771d>, InterfaceC3771d> entry2 : b.entrySet()) {
            Class<? extends InterfaceC3771d> key = entry2.getKey();
            InterfaceC3771d value = entry2.getValue();
            if (value == null) {
                value = b(key);
            }
            b.put(key, value);
        }
    }

    private static void f() {
        b.clear();
    }

    public static void a() {
        List<Class<? extends InterfaceC3771d>> list = c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Class<? extends InterfaceC3771d> cls : list) {
            InterfaceC3771d interfaceC3771d = b.get(cls);
            if (interfaceC3771d != null && interfaceC3771d.a()) {
                return;
            }
        }
    }

    private static <T extends InterfaceC3771d> T b(Class<? extends InterfaceC3771d> cls) {
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException unused) {
            C3800a.b();
            return null;
        } catch (InstantiationException unused2) {
            C3800a.b();
            return null;
        }
    }

    public static boolean a(int i, KeyEvent keyEvent) {
        List<Class<? extends InterfaceC3771d>> list = c;
        if (list == null || list.isEmpty()) {
            return true;
        }
        for (Class<? extends InterfaceC3771d> cls : list) {
            InterfaceC3771d interfaceC3771d = b.get(cls);
            if (interfaceC3771d != null && !interfaceC3771d.a(i, keyEvent)) {
                break;
            }
        }
        return false;
    }

    public static void a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        LinkedHashMap<Class<? extends InterfaceC3771d>, InterfaceC3771d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(C3770c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(C3774g.class, null);
        linkedHashMap.put(C3775a.class, null);
        linkedHashMap.put(C3769b.class, null);
        for (Map.Entry<Class<? extends InterfaceC3771d>, InterfaceC3771d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new AnonymousClass1());
        for (Map.Entry<Class<? extends InterfaceC3771d>, InterfaceC3771d> entry2 : b.entrySet()) {
            Class<? extends InterfaceC3771d> key = entry2.getKey();
            InterfaceC3771d value = entry2.getValue();
            if (value == null) {
                value = b(key);
            }
            b.put(key, value);
        }
        List<Class<? extends InterfaceC3771d>> list = c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Class<? extends InterfaceC3771d> cls : list) {
            InterfaceC3771d interfaceC3771d = b.get(cls);
            if (interfaceC3771d != null && interfaceC3771d.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener)) {
                return;
            }
        }
    }
}
