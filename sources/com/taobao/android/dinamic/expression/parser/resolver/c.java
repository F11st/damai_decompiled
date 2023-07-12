package com.taobao.android.dinamic.expression.parser.resolver;

import android.util.Log;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class c implements ValueResolver {
    @Override // com.taobao.android.dinamic.expression.parser.resolver.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return obj instanceof List;
    }

    @Override // com.taobao.android.dinamic.expression.parser.resolver.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        try {
            return ((List) obj).get(Integer.parseInt(str));
        } catch (Exception e) {
            Log.w("ListValueResolver", e.getMessage());
            return null;
        }
    }
}
