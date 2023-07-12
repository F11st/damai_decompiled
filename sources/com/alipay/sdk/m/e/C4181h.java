package com.alipay.sdk.m.e;

import com.alipay.sdk.m.f.C4187a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.alipay.C8886b;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.e.h */
/* loaded from: classes10.dex */
public final class C4181h implements InterfaceC4182i, InterfaceC4183j {
    public static Map<Object, Object> a(Type type) {
        while (type != Properties.class) {
            if (type == Hashtable.class) {
                return new Hashtable();
            }
            if (type == IdentityHashMap.class) {
                return new IdentityHashMap();
            }
            if (type == SortedMap.class || type == TreeMap.class) {
                return new TreeMap();
            }
            if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
                return new ConcurrentHashMap();
            }
            if (type == Map.class || type == HashMap.class) {
                return new HashMap();
            }
            if (type == LinkedHashMap.class) {
                return new LinkedHashMap();
            }
            if (!(type instanceof ParameterizedType)) {
                Class cls = (Class) type;
                if (cls.isInterface()) {
                    throw new IllegalArgumentException("unsupport type " + type);
                }
                try {
                    return (Map) cls.newInstance();
                } catch (Exception e) {
                    throw new IllegalArgumentException("unsupport type " + type, e);
                }
            }
            type = ((ParameterizedType) type).getRawType();
        }
        return new Properties();
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4183j
    public final Object a(Object obj) {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry entry : ((Map) obj).entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException("Map key must be String!");
            }
            treeMap.put((String) entry.getKey(), C4179f.b(entry.getValue()));
        }
        return treeMap;
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i
    public final Object a(Object obj, Type type) {
        if (obj.getClass().equals(C8886b.class)) {
            C8886b c8886b = (C8886b) obj;
            Map<Object, Object> a = a(type);
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type type2 = parameterizedType.getActualTypeArguments()[0];
                Type type3 = parameterizedType.getActualTypeArguments()[1];
                if (String.class == type2) {
                    Iterator a2 = c8886b.a();
                    while (a2.hasNext()) {
                        String str = (String) a2.next();
                        a.put(str, C4187a.a((Class<?>) ((Class) type3)) ? c8886b.a(str) : C4178e.a(c8886b.a(str), type3));
                    }
                    return a;
                }
                throw new IllegalArgumentException("Deserialize Map Key must be String.class");
            }
            throw new IllegalArgumentException("Deserialize Map must be Generics!");
        }
        return null;
    }

    @Override // com.alipay.sdk.m.e.InterfaceC4182i, com.alipay.sdk.m.e.InterfaceC4183j
    public final boolean a(Class<?> cls) {
        return Map.class.isAssignableFrom(cls);
    }
}
