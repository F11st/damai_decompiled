package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class e {
    private static final String a = "e";
    private static final LinkedHashMap<Class<? extends d>, d> b = new LinkedHashMap<>();
    private static final List<Class<? extends d>> c = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.component.e$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    static class AnonymousClass1 implements Comparator<Class<? extends d>> {
        AnonymousClass1() {
        }

        private static int a(Class<? extends d> cls, Class<? extends d> cls2) {
            if (cls == null || cls2 == null) {
                return 0;
            }
            f fVar = (f) cls.getAnnotation(f.class);
            f fVar2 = (f) cls2.getAnnotation(f.class);
            if (fVar == null && fVar2 == null) {
                return 0;
            }
            if (fVar == null || fVar2 != null) {
                if (fVar != null || fVar2 == null) {
                    if (fVar.a() == fVar2.a()) {
                        return 0;
                    }
                    return fVar.a() > fVar2.a() ? -1 : 1;
                }
                return 1;
            }
            return -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Class<? extends d> cls, Class<? extends d> cls2) {
            Class<? extends d> cls3 = cls;
            Class<? extends d> cls4 = cls2;
            if (cls3 == null || cls4 == null) {
                return 0;
            }
            f fVar = (f) cls3.getAnnotation(f.class);
            f fVar2 = (f) cls4.getAnnotation(f.class);
            if (fVar == null && fVar2 == null) {
                return 0;
            }
            if (fVar == null || fVar2 != null) {
                if (fVar != null || fVar2 == null) {
                    if (fVar.a() == fVar2.a()) {
                        return 0;
                    }
                    return fVar.a() > fVar2.a() ? -1 : 1;
                }
                return 1;
            }
            return -1;
        }
    }

    public static <T extends d> T a(Class<T> cls) {
        LinkedHashMap<Class<? extends d>, d> linkedHashMap = b;
        T t = linkedHashMap.containsKey(cls) ? (T) linkedHashMap.get(cls) : null;
        if (t == null) {
            T t2 = (T) b(cls);
            linkedHashMap.put(cls, t2);
            return t2;
        }
        return t;
    }

    public static void b() {
        List<Class<? extends d>> list = c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Class<? extends d> cls : list) {
            d dVar = b.get(cls);
            if (dVar != null && dVar.b()) {
                return;
            }
        }
    }

    public static void c() {
        List<Class<? extends d>> list = c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Class<? extends d> cls : list) {
            d dVar = b.get(cls);
            if (dVar != null && dVar.c()) {
                break;
            }
        }
        b.clear();
    }

    private static void d() {
        LinkedHashMap<Class<? extends d>, d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(g.class, null);
        linkedHashMap.put(com.alibaba.security.biometrics.logic.a.class, null);
        linkedHashMap.put(b.class, null);
        for (Map.Entry<Class<? extends d>, d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new AnonymousClass1());
    }

    private static void e() {
        LinkedHashMap<Class<? extends d>, d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(g.class, null);
        linkedHashMap.put(com.alibaba.security.biometrics.logic.a.class, null);
        linkedHashMap.put(b.class, null);
        for (Map.Entry<Class<? extends d>, d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new AnonymousClass1());
        for (Map.Entry<Class<? extends d>, d> entry2 : b.entrySet()) {
            Class<? extends d> key = entry2.getKey();
            d value = entry2.getValue();
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
        List<Class<? extends d>> list = c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Class<? extends d> cls : list) {
            d dVar = b.get(cls);
            if (dVar != null && dVar.a()) {
                return;
            }
        }
    }

    private static <T extends d> T b(Class<? extends d> cls) {
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException unused) {
            com.alibaba.security.common.c.a.b();
            return null;
        } catch (InstantiationException unused2) {
            com.alibaba.security.common.c.a.b();
            return null;
        }
    }

    public static boolean a(int i, KeyEvent keyEvent) {
        List<Class<? extends d>> list = c;
        if (list == null || list.isEmpty()) {
            return true;
        }
        for (Class<? extends d> cls : list) {
            d dVar = b.get(cls);
            if (dVar != null && !dVar.a(i, keyEvent)) {
                break;
            }
        }
        return false;
    }

    public static void a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        LinkedHashMap<Class<? extends d>, d> linkedHashMap = b;
        linkedHashMap.clear();
        c.clear();
        linkedHashMap.put(AudioSettingComponent.class, null);
        linkedHashMap.put(c.class, null);
        linkedHashMap.put(MediaSystemComponent.class, null);
        linkedHashMap.put(g.class, null);
        linkedHashMap.put(com.alibaba.security.biometrics.logic.a.class, null);
        linkedHashMap.put(b.class, null);
        for (Map.Entry<Class<? extends d>, d> entry : linkedHashMap.entrySet()) {
            c.add(entry.getKey());
        }
        Collections.sort(c, new AnonymousClass1());
        for (Map.Entry<Class<? extends d>, d> entry2 : b.entrySet()) {
            Class<? extends d> key = entry2.getKey();
            d value = entry2.getValue();
            if (value == null) {
                value = b(key);
            }
            b.put(key, value);
        }
        List<Class<? extends d>> list = c;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Class<? extends d> cls : list) {
            d dVar = b.get(cls);
            if (dVar != null && dVar.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener)) {
                return;
            }
        }
    }
}
