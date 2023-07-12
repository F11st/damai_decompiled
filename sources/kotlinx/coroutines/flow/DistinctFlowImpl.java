package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cm1;
import tb.wt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class DistinctFlowImpl<T> implements Flow<T> {
    private final Flow<T> a;
    @JvmField
    @NotNull
    public final Function1<T, Object> b;
    @JvmField
    @NotNull
    public final Function2<Object, Object, Boolean> c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, ? extends Object> function1, @NotNull Function2<Object, Object, Boolean> function2) {
        this.a = flow;
        this.b = function1;
        this.c = function2;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @InternalCoroutinesApi
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = (T) cm1.NULL;
        Object collect = this.a.collect(new DistinctFlowImpl$collect$$inlined$collect$1(this, ref$ObjectRef, flowCollector), continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return collect == d ? collect : wt2.INSTANCE;
    }
}
