package com.taobao.android.dinamic.expression.parser.resolver;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class e {
    private static List<ValueResolver> a;

    static {
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        arrayList.add(new d());
        a.add(new c());
        a.add(new a());
        a.add(new b());
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
