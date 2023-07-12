package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.b.b */
/* loaded from: classes10.dex */
public class C5923b {
    private final C5922a a;
    private final Class<?>[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5923b(C5922a c5922a, Class<?>... clsArr) {
        this.a = c5922a;
        this.b = clsArr;
    }

    public <T> C5926d<T> a(Object... objArr) {
        C5926d<T> c5926d = new C5926d<>();
        try {
            Constructor<?> declaredConstructor = this.a.a().getDeclaredConstructor(this.b);
            declaredConstructor.setAccessible(true);
            c5926d.b = (T) declaredConstructor.newInstance(objArr);
            c5926d.a = true;
        } catch (Exception e) {
            DebugLogger.e("ReflectConstructor", "newInstance", e);
        }
        return c5926d;
    }
}
