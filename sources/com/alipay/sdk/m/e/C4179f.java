package com.alipay.sdk.m.e;

import com.alipay.sdk.m.f.C4187a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.alipay.C8885a;
import org.json.alipay.C8886b;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.e.f */
/* loaded from: classes12.dex */
public final class C4179f {
    public static List<InterfaceC4183j> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new C4185l());
        a.add(new C4177d());
        a.add(new C4176c());
        a.add(new C4181h());
        a.add(new C4175b());
        a.add(new C4174a());
        a.add(new C4180g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object b = b(obj);
        if (C4187a.a(b.getClass())) {
            return C8886b.c(b.toString());
        }
        if (Collection.class.isAssignableFrom(b.getClass())) {
            return new C8885a((Collection) ((List) b)).toString();
        }
        if (Map.class.isAssignableFrom(b.getClass())) {
            return new C8886b((Map) b).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + b.getClass());
    }

    public static Object b(Object obj) {
        Object a2;
        if (obj == null) {
            return null;
        }
        for (InterfaceC4183j interfaceC4183j : a) {
            if (interfaceC4183j.a(obj.getClass()) && (a2 = interfaceC4183j.a(obj)) != null) {
                return a2;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
