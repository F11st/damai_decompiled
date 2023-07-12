package tb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class am {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(am.class, "_handled");
    private volatile int _handled;
    @JvmField
    @NotNull
    public final Throwable a;

    public am(@NotNull Throwable th, boolean z) {
        this.a = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return b.compareAndSet(this, 0, 1);
    }

    @NotNull
    public String toString() {
        return o40.a(this) + jn1.ARRAY_START + this.a + jn1.ARRAY_END;
    }

    public /* synthetic */ am(Throwable th, boolean z, int i, k50 k50Var) {
        this(th, (i & 2) != 0 ? false : z);
    }
}
