package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.a.C4062d;
import com.alipay.android.phone.mrpc.core.a.C4063e;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.z */
/* loaded from: classes12.dex */
public final class C4094z {
    public static final ThreadLocal<Object> a = new ThreadLocal<>();
    public static final ThreadLocal<Map<String, Object>> b = new ThreadLocal<>();
    public byte c = 0;
    public AtomicInteger d = new AtomicInteger();
    public C4092x e;

    public C4094z(C4092x c4092x) {
        this.e = c4092x;
    }

    public final Object a(Method method, Object[] objArr) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        boolean z = method.getAnnotation(ResetCookie.class) != null;
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        ThreadLocal<Object> threadLocal = a;
        threadLocal.set(null);
        ThreadLocal<Map<String, Object>> threadLocal2 = b;
        threadLocal2.set(null);
        if (operationType != null) {
            String value = operationType.value();
            int incrementAndGet = this.d.incrementAndGet();
            try {
                if (this.c == 0) {
                    C4063e c4063e = new C4063e(incrementAndGet, value, objArr);
                    if (threadLocal2.get() != null) {
                        c4063e.a(threadLocal2.get());
                    }
                    byte[] a2 = c4063e.a();
                    threadLocal2.set(null);
                    Object a3 = new C4062d(genericReturnType, (byte[]) new C4077j(this.e.a(), method, incrementAndGet, value, a2, z).a()).a();
                    if (genericReturnType != Void.TYPE) {
                        threadLocal.set(a3);
                    }
                }
                return threadLocal.get();
            } catch (RpcException e) {
                e.setOperationType(value);
                throw e;
            }
        }
        throw new IllegalStateException("OperationType must be set.");
    }
}
