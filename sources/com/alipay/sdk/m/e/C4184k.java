package com.alipay.sdk.m.e;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;
import org.json.alipay.C8885a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.e.k */
/* loaded from: classes10.dex */
public final class C4184k implements InterfaceC4182i {
    @Override // com.alipay.sdk.m.e.InterfaceC4182i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(C8885a.class)) {
            C8885a c8885a = (C8885a) obj;
            HashSet hashSet = new HashSet();
            Class cls = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class;
            for (int i = 0; i < c8885a.a(); i++) {
                hashSet.add(C4178e.a(c8885a.a(i), cls));
            }
            return hashSet;
        }
        return null;
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i, com.alipay.sdk.m.e.InterfaceC4183j
    public final boolean a(Class<?> cls) {
        return Set.class.isAssignableFrom(cls);
    }
}
