package com.alipay.sdk.m.e;

import java.lang.reflect.Type;
import java.util.Date;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.e.c */
/* loaded from: classes10.dex */
public final class C4176c implements InterfaceC4182i, InterfaceC4183j {
    @Override // com.alipay.sdk.m.e.InterfaceC4183j
    public final Object a(Object obj) {
        return Long.valueOf(((Date) obj).getTime());
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i
    public final Object a(Object obj, Type type) {
        return new Date(((Long) obj).longValue());
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i, com.alipay.sdk.m.e.InterfaceC4183j
    public final boolean a(Class<?> cls) {
        return Date.class.isAssignableFrom(cls);
    }
}
