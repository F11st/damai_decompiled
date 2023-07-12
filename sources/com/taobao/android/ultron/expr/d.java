package com.taobao.android.ultron.expr;

import java.util.List;
import tb.vt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class d implements ValueResolver {
    @Override // com.taobao.android.ultron.expr.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return obj instanceof List;
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        try {
            return ((List) obj).get(Integer.parseInt(str));
        } catch (Exception e) {
            vt2.g(e.getMessage(), new String[0]);
            return null;
        }
    }
}
