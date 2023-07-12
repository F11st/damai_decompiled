package com.taobao.android.ultron.expr;

import java.lang.reflect.Array;
import tb.vt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class a implements ValueResolver {
    @Override // com.taobao.android.ultron.expr.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return cls.isArray();
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        try {
            return Array.get(obj, Integer.parseInt(str));
        } catch (Exception e) {
            vt2.g(e.getMessage(), new String[0]);
            return null;
        }
    }
}
