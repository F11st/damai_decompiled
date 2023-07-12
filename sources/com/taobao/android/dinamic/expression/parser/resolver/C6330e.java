package com.taobao.android.dinamic.expression.parser.resolver;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamic.expression.parser.resolver.e */
/* loaded from: classes12.dex */
public class C6330e {
    private static List<ValueResolver> a;

    static {
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        arrayList.add(new C6329d());
        a.add(new C6328c());
        a.add(new C6326a());
        a.add(new C6327b());
    }

    public static Object a(Object obj, String str) {
        if (obj != null && str != null) {
            if (str.equals("this")) {
                return obj;
            }
            Class<?> cls = obj.getClass();
            for (ValueResolver valueResolver : a) {
                if (valueResolver.canResolve(obj, cls, str)) {
                    return valueResolver.resolve(obj, cls, str);
                }
            }
        }
        return null;
    }
}
