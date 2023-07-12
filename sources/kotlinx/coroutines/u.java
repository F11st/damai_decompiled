package kotlinx.coroutines;

import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.am;
import tb.f61;
import tb.i32;
import tb.jn1;
import tb.k40;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class u<T> extends f61<JobSupport> {
    private final CancellableContinuationImpl<T> e;

    /* JADX WARN: Multi-variable type inference failed */
    public u(@NotNull JobSupport jobSupport, @NotNull CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        super(jobSupport);
        this.e = cancellableContinuationImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        Object state$kotlinx_coroutines_core = ((JobSupport) this.d).getState$kotlinx_coroutines_core();
        if (k40.a() && !(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new AssertionError();
        }
        if (state$kotlinx_coroutines_core instanceof am) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.e;
            Throwable th2 = ((am) state$kotlinx_coroutines_core).a;
            Result.a aVar = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m1271constructorimpl(i32.a(th2)));
            return;
        }
        CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.e;
        Object h = s.h(state$kotlinx_coroutines_core);
        Result.a aVar2 = Result.Companion;
        cancellableContinuationImpl2.resumeWith(Result.m1271constructorimpl(h));
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "ResumeAwaitOnCompletion[" + this.e + jn1.ARRAY_END;
    }
}
