package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.ey;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ey<T extends ey<T>> {
    public T f;

    public static <T extends ey<?>> T a(T t, T t2) {
        if (t2.f == null) {
            t2.f = t;
            return t2;
        }
        throw new IllegalArgumentException("'item' is a list");
    }
}
