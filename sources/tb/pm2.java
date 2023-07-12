package tb;

import kotlinx.coroutines.AbstractC8699m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class pm2 {
    public static final pm2 INSTANCE = new pm2();
    private static final ThreadLocal<AbstractC8699m> a = new ThreadLocal<>();

    private pm2() {
    }

    @Nullable
    public final AbstractC8699m a() {
        return a.get();
    }

    @NotNull
    public final AbstractC8699m b() {
        ThreadLocal<AbstractC8699m> threadLocal = a;
        AbstractC8699m abstractC8699m = threadLocal.get();
        if (abstractC8699m != null) {
            return abstractC8699m;
        }
        AbstractC8699m a2 = zf0.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void c() {
        a.set(null);
    }

    public final void d(@NotNull AbstractC8699m abstractC8699m) {
        a.set(abstractC8699m);
    }
}
