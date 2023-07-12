package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.id;
import tb.k40;
import tb.k50;
import tb.la2;
import tb.nk0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ChannelFlowTransformLatest<T, R> extends ChannelFlowOperator<T, R> {
    private final Function3<FlowCollector<? super R>, T, Continuation<? super wt2>, Object> e;

    public /* synthetic */ ChannelFlowTransformLatest(Function3 function3, Flow flow, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, k50 k50Var) {
        this(function3, flow, (i2 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 8) != 0 ? -2 : i, (i2 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    protected ChannelFlow<R> d(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.e, this.d, coroutineContext, i, bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    @Nullable
    public Object k(@NotNull FlowCollector<? super R> flowCollector, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        if (!k40.a() || id.a(flowCollector instanceof la2).booleanValue()) {
            Object a = nk0.a(new ChannelFlowTransformLatest$flowCollect$3(this, flowCollector, null), continuation);
            d = kotlin.coroutines.intrinsics.b.d();
            return a == d ? a : wt2.INSTANCE;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(@NotNull Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super wt2>, ? extends Object> function3, @NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(flow, coroutineContext, i, bufferOverflow);
        this.e = function3;
    }
}
