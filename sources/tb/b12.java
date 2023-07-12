package tb;

import com.google.common.annotations.Beta;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public final class b12 {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        du1.p(invocationHandler);
        du1.k(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
