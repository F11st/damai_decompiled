package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f61;
import tb.jn1;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class w<T, R> extends f61<JobSupport> {
    private final SelectInstance<R> e;
    private final Function2<T, Continuation<? super R>, Object> f;

    /* JADX WARN: Multi-variable type inference failed */
    public w(@NotNull JobSupport jobSupport, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        super(jobSupport);
        this.e = selectInstance;
        this.f = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        if (this.e.trySelect()) {
            ((JobSupport) this.d).selectAwaitCompletion$kotlinx_coroutines_core(this.e, this.f);
        }
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "SelectAwaitOnCompletion[" + this.e + jn1.ARRAY_END;
    }
}
