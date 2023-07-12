package tb;

import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class da0 {
    public static final da0 INSTANCE = new da0();
    @NotNull
    private static final CoroutineDispatcher a = lo.a();
    @NotNull
    private static final CoroutineDispatcher b;

    static {
        kotlinx.coroutines.z zVar = kotlinx.coroutines.z.INSTANCE;
        b = e60.INSTANCE.c();
    }

    private da0() {
    }

    @NotNull
    public static final CoroutineDispatcher a() {
        return a;
    }

    @NotNull
    public static final CoroutineDispatcher b() {
        return b;
    }

    @NotNull
    public static final uc1 c() {
        return vc1.dispatcher;
    }
}
