package com.taobao.android.ultron.expr;

import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.ultron.expr.e */
/* loaded from: classes11.dex */
class C6669e implements ValueResolver {
    @Override // com.taobao.android.ultron.expr.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return obj instanceof Map;
    }

    @Override // com.taobao.android.ultron.expr.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        return ((Map) obj).get(str);
    }
}
