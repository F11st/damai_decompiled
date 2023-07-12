package com.alibaba.appmonitor.pool;

import com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder;
import java.util.HashMap;
import java.util.Map;
import tb.k32;

/* compiled from: Taobao */
/* renamed from: com.alibaba.appmonitor.pool.a */
/* loaded from: classes6.dex */
public class C3316a implements IPool {
    private static C3316a b = new C3316a();
    private Map<Class<? extends Reusable>, k32<? extends Reusable>> a = new HashMap();

    private C3316a() {
    }

    public static C3316a a() {
        return b;
    }

    private synchronized <T extends Reusable> k32<T> b(Class<T> cls) {
        k32<T> k32Var;
        k32Var = (k32<T>) this.a.get(cls);
        if (k32Var == null) {
            k32Var = new k32<>();
            this.a.put(cls, k32Var);
        }
        return k32Var;
    }

    @Override // com.alibaba.appmonitor.pool.IPool
    public <T extends Reusable> void offer(T t) {
        if (t != null) {
            b(t.getClass()).a(t);
        }
    }

    @Override // com.alibaba.appmonitor.pool.IPool
    public <T extends Reusable> T poll(Class<T> cls, Object... objArr) {
        T b2 = b(cls).b();
        if (b2 == null) {
            try {
                b2 = cls.newInstance();
            } catch (Exception e) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, e);
            }
        }
        if (b2 != null) {
            b2.fill(objArr);
        }
        return b2;
    }
}
