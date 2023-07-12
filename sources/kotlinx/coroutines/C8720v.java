package kotlinx.coroutines;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f61;
import tb.jn1;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.v */
/* loaded from: classes8.dex */
public final class C8720v extends f61<Job> {
    private final Continuation<wt2> e;

    /* JADX WARN: Multi-variable type inference failed */
    public C8720v(@NotNull Job job, @NotNull Continuation<? super wt2> continuation) {
        super(job);
        this.e = continuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        Continuation<wt2> continuation = this.e;
        wt2 wt2Var = wt2.INSTANCE;
        Result.C8174a c8174a = Result.Companion;
        continuation.resumeWith(Result.m1271constructorimpl(wt2Var));
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "ResumeOnCompletion[" + this.e + jn1.ARRAY_END;
    }
}
