package com.taobao.android.dinamic.expression.parser.resolver;

import android.util.Log;
import java.lang.reflect.Array;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class a implements ValueResolver {
    @Override // com.taobao.android.dinamic.expression.parser.resolver.ValueResolver
    public boolean canResolve(Object obj, Class<?> cls, String str) {
        return cls.isArray();
    }

    @Override // com.taobao.android.dinamic.expression.parser.resolver.ValueResolver
    public Object resolve(Object obj, Class<?> cls, String str) {
        try {
            return Array.get(obj, Integer.parseInt(str));
        } catch (Exception e) {
            Log.w("ArrayValueResolver", e);
            return null;
        }
    }
}
