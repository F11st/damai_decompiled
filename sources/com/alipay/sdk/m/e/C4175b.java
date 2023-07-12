package com.alipay.sdk.m.e;

import com.alipay.sdk.m.f.C4187a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import org.json.alipay.C8885a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.e.b */
/* loaded from: classes10.dex */
public final class C4175b implements InterfaceC4182i, InterfaceC4183j {
    public static Collection<Object> a(Class<?> cls, Type type) {
        if (cls == AbstractCollection.class) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (cls.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (cls.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (cls.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (cls.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf(type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class);
        }
        try {
            return (Collection) cls.newInstance();
        } catch (Exception unused) {
            throw new IllegalArgumentException("create instane error, class " + cls.getName());
        }
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4183j
    public final Object a(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (Iterable) obj) {
            arrayList.add(C4179f.b(obj2));
        }
        return arrayList;
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(C8885a.class)) {
            C8885a c8885a = (C8885a) obj;
            Collection<Object> a = a(C4187a.a(type), type);
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                for (int i = 0; i < c8885a.a(); i++) {
                    a.add(C4178e.a(c8885a.a(i), type2));
                }
                return a;
            }
            throw new IllegalArgumentException("Does not support the implement for generics.");
        }
        return null;
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i, com.alipay.sdk.m.e.InterfaceC4183j
    public final boolean a(Class<?> cls) {
        return Collection.class.isAssignableFrom(cls);
    }
}
