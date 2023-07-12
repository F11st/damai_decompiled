package com.meizu.cloud.pushsdk.b.b;

import com.meizu.cloud.pushinternal.DebugLogger;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private final a a;
    private final Class<?>[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, Class<?>... clsArr) {
        this.a = aVar;
        this.b = clsArr;
    }

    public <T> d<T> a(Object... objArr) {
        d<T> dVar = new d<>();
        try {
            Constructor<?> declaredConstructor = this.a.a().getDeclaredConstructor(this.b);
            declaredConstructor.setAccessible(true);
            dVar.b = (T) declaredConstructor.newInstance(objArr);
            dVar.a = true;
        } catch (Exception e) {
            DebugLogger.e("ReflectConstructor", "newInstance", e);
        }
        return dVar;
    }
}
