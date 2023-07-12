package com.alipay.sdk.m.e;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.json.alipay.C8885a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.e.a */
/* loaded from: classes10.dex */
public final class C4174a implements InterfaceC4182i, InterfaceC4183j {
    @Override // com.alipay.sdk.m.e.InterfaceC4183j
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Object[]) obj) {
            arrayList.add(C4179f.b(obj2));
        }
        return arrayList;
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(C8885a.class)) {
            C8885a c8885a = (C8885a) obj;
            if (type instanceof GenericArrayType) {
                throw new IllegalArgumentException("Does not support generic array!");
            }
            Class<?> componentType = ((Class) type).getComponentType();
            int a = c8885a.a();
            Object newInstance = Array.newInstance(componentType, a);
            for (int i = 0; i < a; i++) {
                Array.set(newInstance, i, C4178e.a(c8885a.a(i), componentType));
            }
            return newInstance;
        }
        return null;
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i, com.alipay.sdk.m.e.InterfaceC4183j
    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }
}
