package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b61;
import tb.jn1;
import tb.o40;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.q */
/* loaded from: classes8.dex */
public final class C8703q extends b61<Job> {
    private static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(C8703q.class, "_invoked");
    private volatile int _invoked;
    private final Function1<Throwable, wt2> e;

    /* JADX WARN: Multi-variable type inference failed */
    public C8703q(@NotNull Job job, @NotNull Function1<? super Throwable, wt2> function1) {
        super(job);
        this.e = function1;
        this._invoked = 0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        if (f.compareAndSet(this, 0, 1)) {
            this.e.invoke(th);
        }
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "InvokeOnCancelling[" + o40.a(this) + '@' + o40.b(this) + jn1.ARRAY_END;
    }
}
