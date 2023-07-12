package com.alipay.sdk.m.e;

import java.lang.reflect.Type;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class d implements i, j {
    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
