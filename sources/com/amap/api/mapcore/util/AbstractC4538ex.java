package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.ey;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.ex */
/* loaded from: classes10.dex */
public abstract class AbstractC4538ex<T extends ey<?>> {
    protected T a;

    protected boolean a(T t) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T extends com.amap.api.mapcore.util.ey<T>] */
    /* JADX WARN: Type inference failed for: r2v0, types: [T extends com.amap.api.mapcore.util.ey<?>, T extends com.amap.api.mapcore.util.ey<T>] */
    public T b(T t) {
        if (t == null) {
            return null;
        }
        while (t != null) {
            ?? r1 = t.f;
            a(t);
            t.f = this.a;
            this.a = t;
            t = r1;
        }
        return null;
    }
}
