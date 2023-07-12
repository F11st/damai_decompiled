package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class i<T> extends AbstractFlow<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super wt2>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull Function2<? super FlowCollector<? super T>, ? super Continuation<? super wt2>, ? extends Object> function2) {
        this.a = function2;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    @Nullable
    public Object a(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object invoke = this.a.invoke(flowCollector, continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return invoke == d ? invoke : wt2.INSTANCE;
    }
}
