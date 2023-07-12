package com.taobao.android.ultron.expr;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.ultron.expr.f */
/* loaded from: classes12.dex */
class C6670f {
    private static List<ValueResolver> a;

    static {
        ArrayList arrayList = new ArrayList(4);
        a = arrayList;
        arrayList.add(new C6669e());
        a.add(new C6668d());
        a.add(new C6665a());
        a.add(new C6666b());
    }

    public static Object a(Object obj, String str) {
        if (obj != null && str != null) {
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
