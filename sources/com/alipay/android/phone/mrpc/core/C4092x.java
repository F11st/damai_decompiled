package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.x */
/* loaded from: classes12.dex */
public final class C4092x {
    public InterfaceC4074g a;
    public C4094z b = new C4094z(this);

    public C4092x(InterfaceC4074g interfaceC4074g) {
        this.a = interfaceC4074g;
    }

    public final InterfaceC4074g a() {
        return this.a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C4093y(this.a, cls, this.b));
    }
}
