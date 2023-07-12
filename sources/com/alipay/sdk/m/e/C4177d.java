package com.alipay.sdk.m.e;

import java.lang.reflect.Type;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.e.d */
/* loaded from: classes10.dex */
public final class C4177d implements InterfaceC4182i, InterfaceC4183j {
    @Override // com.alipay.sdk.m.e.InterfaceC4183j
    public final Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i
    public final Object a(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i, com.alipay.sdk.m.e.InterfaceC4183j
    public final boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
