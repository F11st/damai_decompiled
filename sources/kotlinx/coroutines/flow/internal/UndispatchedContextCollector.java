package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class UndispatchedContextCollector<T> implements FlowCollector<T> {
    private final Object a;
    private final Function2<T, Continuation<? super wt2>, Object> b;
    private final CoroutineContext c;

    public UndispatchedContextCollector(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext) {
        this.c = coroutineContext;
        this.a = ThreadContextKt.b(coroutineContext);
        this.b = new UndispatchedContextCollector$emitRef$1(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object b = C8682a.b(this.c, t, this.a, this.b, continuation);
        d = C8234b.d();
        return b == d ? b : wt2.INSTANCE;
    }
}
