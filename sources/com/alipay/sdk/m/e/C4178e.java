package com.alipay.sdk.m.e;

import com.alipay.sdk.m.f.C4187a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.alipay.C8885a;
import org.json.alipay.C8886b;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.e.e */
/* loaded from: classes12.dex */
public final class C4178e {
    public static List<InterfaceC4182i> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(new C4185l());
        a.add(new C4177d());
        a.add(new C4176c());
        a.add(new C4181h());
        a.add(new C4184k());
        a.add(new C4175b());
        a.add(new C4174a());
        a.add(new C4180g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (InterfaceC4182i interfaceC4182i : a) {
            if (interfaceC4182i.a(C4187a.a(type)) && (t = (T) interfaceC4182i.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    public static final Object a(String str, Type type) {
        Object c8886b;
        if (str == null || str.length() == 0) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith(jn1.ARRAY_START_STR) && trim.endsWith(jn1.ARRAY_END_STR)) {
            c8886b = new C8885a(trim);
        } else if (!trim.startsWith(jn1.BLOCK_START_STR) || !trim.endsWith("}")) {
            return a((Object) trim, type);
        } else {
            c8886b = new C8886b(trim);
        }
        return a(c8886b, type);
    }
}
