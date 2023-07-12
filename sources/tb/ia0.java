package tb;

import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ia0 extends f61<Job> {
    private final DisposableHandle e;

    public ia0(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        super(job);
        this.e = disposableHandle;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        this.e.dispose();
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "DisposeOnCompletion[" + this.e + jn1.ARRAY_END;
    }
}
