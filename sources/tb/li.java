package tb;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class li extends b61<Job> {
    @JvmField
    @NotNull
    public final CancellableContinuationImpl<?> e;

    public li(@NotNull Job job, @NotNull CancellableContinuationImpl<?> cancellableContinuationImpl) {
        super(job);
        this.e = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.e;
        cancellableContinuationImpl.parentCancelled$kotlinx_coroutines_core(cancellableContinuationImpl.getContinuationCancellationCause(this.d));
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "ChildContinuation[" + this.e + jn1.ARRAY_END;
    }
}
