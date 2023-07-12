package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class pm2 {
    public static final pm2 INSTANCE = new pm2();
    private static final ThreadLocal<kotlinx.coroutines.m> a = new ThreadLocal<>();

    private pm2() {
    }

    @Nullable
    public final kotlinx.coroutines.m a() {
        return a.get();
    }

    @NotNull
    public final kotlinx.coroutines.m b() {
        ThreadLocal<kotlinx.coroutines.m> threadLocal = a;
        kotlinx.coroutines.m mVar = threadLocal.get();
        if (mVar != null) {
            return mVar;
        }
        kotlinx.coroutines.m a2 = zf0.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void c() {
        a.set(null);
    }

    public final void d(@NotNull kotlinx.coroutines.m mVar) {
        a.set(mVar);
    }
}
