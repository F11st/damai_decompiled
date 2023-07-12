package com.alipay.sdk.m.e;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a implements i, j {
    @Override // com.alipay.sdk.m.e.j
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Object[]) obj) {
            arrayList.add(f.b(obj2));
        }
        return arrayList;
    }

    @Override // com.alipay.sdk.m.e.i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(org.json.alipay.a.class)) {
            org.json.alipay.a aVar = (org.json.alipay.a) obj;
            if (type instanceof GenericArrayType) {
                throw new IllegalArgumentException("Does not support generic array!");
            }
            Class<?> componentType = ((Class) type).getComponentType();
            int a = aVar.a();
            Object newInstance = Array.newInstance(componentType, a);
            for (int i = 0; i < a; i++) {
                Array.set(newInstance, i, e.a(aVar.a(i), componentType));
            }
            return newInstance;
        }
        return null;
    }

    @Override // com.alipay.sdk.m.e.i, com.alipay.sdk.m.e.j
    public final boolean a(Class<?> cls) {
        return cls.isArray();
    }
}
