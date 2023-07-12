package tb;

import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class e60 extends ug0 {
    public static final e60 INSTANCE;
    @NotNull
    private static final CoroutineDispatcher f;

    static {
        int a;
        int d;
        e60 e60Var = new e60();
        INSTANCE = e60Var;
        a = ty1.a(64, nj2.a());
        d = pj2.d("kotlinx.coroutines.io.parallelism", a, 0, 0, 12, null);
        f = new b91(e60Var, d, "Dispatchers.IO", 1);
    }

    private e60() {
        super(0, 0, null, 7, null);
    }

    @NotNull
    public final CoroutineDispatcher c() {
        return f;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @NotNull
    public String toString() {
        return ml2.DEFAULT_DISPATCHER_NAME;
    }
}
