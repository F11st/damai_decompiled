package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.eg;
import tb.f61;
import tb.jn1;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class x<R> extends f61<JobSupport> {
    private final SelectInstance<R> e;
    private final Function1<Continuation<? super R>, Object> f;

    /* JADX WARN: Multi-variable type inference failed */
    public x(@NotNull JobSupport jobSupport, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        super(jobSupport);
        this.e = selectInstance;
        this.f = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
        t(th);
        return wt2.INSTANCE;
    }

    @Override // tb.cm
    public void t(@Nullable Throwable th) {
        if (this.e.trySelect()) {
            eg.b(this.f, this.e.getCompletion());
        }
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "SelectJoinOnCompletion[" + this.e + jn1.ARRAY_END;
    }
}
