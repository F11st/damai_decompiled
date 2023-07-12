package com.meizu.cloud.pushsdk.b.b;

import java.util.HashMap;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.b.a */
/* loaded from: classes10.dex */
public class C5922a {
    private static final HashMap<String, Class<?>> a = new HashMap<>();
    private Class<?> b;
    private String c;
    private Object d;

    private C5922a(Object obj) {
        this.d = obj;
    }

    private C5922a(String str) {
        this.c = str;
    }

    public static C5922a a(Object obj) {
        return new C5922a(obj);
    }

    public static C5922a a(String str) {
        return new C5922a(str);
    }

    public C5923b a(Class<?>... clsArr) {
        return new C5923b(this, clsArr);
    }

    public C5924c a(String str, Class<?>... clsArr) {
        return new C5924c(this, str, clsArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> a() throws ClassNotFoundException {
        Class<?> cls = this.b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.d;
        if (obj != null) {
            return obj.getClass();
        }
        HashMap<String, Class<?>> hashMap = a;
        Class<?> cls2 = hashMap.get(this.c);
        if (cls2 == null) {
            cls2 = Class.forName(this.c);
            hashMap.put(this.c, cls2);
        }
        return cls2;
    }
}
