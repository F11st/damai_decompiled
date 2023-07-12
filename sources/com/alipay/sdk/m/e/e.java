package com.alipay.sdk.m.e;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class e {
    public static List<i> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new l());
        a.add(new d());
        a.add(new c());
        a.add(new h());
        a.add(new k());
        a.add(new b());
        a.add(new a());
        a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (i iVar : a) {
            if (iVar.a(com.alipay.sdk.m.f.a.a(type)) && (t = (T) iVar.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    public static final Object a(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith(jn1.ARRAY_START_STR) && trim.endsWith(jn1.ARRAY_END_STR)) {
            bVar = new org.json.alipay.a(trim);
        } else if (!trim.startsWith(jn1.BLOCK_START_STR) || !trim.endsWith("}")) {
            return a((Object) trim, type);
        } else {
            bVar = new org.json.alipay.b(trim);
        }
        return a(bVar, type);
    }
}
