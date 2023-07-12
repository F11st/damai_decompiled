package com.meizu.cloud.pushsdk.c.a;

import com.meizu.cloud.pushsdk.c.b.C5953a;
import com.meizu.cloud.pushsdk.c.c.C5971k;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.c.a.c */
/* loaded from: classes10.dex */
public class C5950c<T> {
    private final T a;
    private final C5953a b;
    private C5971k c;

    public C5950c(C5953a c5953a) {
        this.a = null;
        this.b = c5953a;
    }

    public C5950c(T t) {
        this.a = t;
        this.b = null;
    }

    public static <T> C5950c<T> a(C5953a c5953a) {
        return new C5950c<>(c5953a);
    }

    public static <T> C5950c<T> a(T t) {
        return new C5950c<>(t);
    }

    public T a() {
        return this.a;
    }

    public void a(C5971k c5971k) {
        this.c = c5971k;
    }

    public boolean b() {
        return this.b == null;
    }

    public C5953a c() {
        return this.b;
    }
}
