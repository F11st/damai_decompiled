package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.y */
/* loaded from: classes12.dex */
public final class C4093y implements InvocationHandler {
    public InterfaceC4074g a;
    public Class<?> b;
    public C4094z c;

    public C4093y(InterfaceC4074g interfaceC4074g, Class<?> cls, C4094z c4094z) {
        this.a = interfaceC4074g;
        this.b = cls;
        this.c = c4094z;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.c.a(method, objArr);
    }
}
