package com.alibaba.security.realidentity.jsbridge;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.jsbridge.m */
/* loaded from: classes8.dex */
public final class C3912m {
    private static C3912m b;
    HashMap<String, Object> a = new HashMap<>();

    private C3912m() {
    }

    public static C3912m a() {
        if (b == null) {
            b = new C3912m();
        }
        return b;
    }

    private void c() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    public final Set<Map.Entry<String, Object>> b() {
        Set<Map.Entry<String, Object>> entrySet;
        synchronized (this.a) {
            entrySet = this.a.entrySet();
        }
        return entrySet;
    }

    private void a(String str, Object obj) {
        synchronized (this.a) {
            if (str != null && obj != null) {
                this.a.put(str, obj);
            }
        }
    }

    public final void b(String str) {
        synchronized (this.a) {
            if (this.a.containsKey(str)) {
                this.a.remove(str);
            }
        }
    }

    public final Object a(String str) {
        synchronized (this.a) {
            if (this.a.containsKey(str)) {
                return this.a.get(str);
            }
            return null;
        }
    }
}
