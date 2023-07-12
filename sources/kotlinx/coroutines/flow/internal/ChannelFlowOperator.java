package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.la2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {
    @JvmField
    @NotNull
    protected final Flow<S> d;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(@NotNull Flow<? extends S> flow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.d = flow;
    }

    static /* synthetic */ Object h(ChannelFlowOperator channelFlowOperator, FlowCollector flowCollector, Continuation continuation) {
        Object d;
        Object d2;
        Object d3;
        if (channelFlowOperator.b == -3) {
            CoroutineContext context = continuation.getContext();
            CoroutineContext plus = context.plus(channelFlowOperator.a);
            if (b41.d(plus, context)) {
                Object k = channelFlowOperator.k(flowCollector, continuation);
                d3 = kotlin.coroutines.intrinsics.b.d();
                return k == d3 ? k : wt2.INSTANCE;
            }
            ContinuationInterceptor.b bVar = ContinuationInterceptor.Key;
            if (b41.d((ContinuationInterceptor) plus.get(bVar), (ContinuationInterceptor) context.get(bVar))) {
                Object j = channelFlowOperator.j(flowCollector, plus, continuation);
                d2 = kotlin.coroutines.intrinsics.b.d();
                return j == d2 ? j : wt2.INSTANCE;
            }
        }
        Object collect = super.collect(flowCollector, continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return collect == d ? collect : wt2.INSTANCE;
    }

    static /* synthetic */ Object i(ChannelFlowOperator channelFlowOperator, ProducerScope producerScope, Continuation continuation) {
        Object d;
        Object k = channelFlowOperator.k(new la2(producerScope), continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return k == d ? k : wt2.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super wt2> continuation) {
        return i(this, producerScope, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super wt2> continuation) {
        return h(this, flowCollector, continuation);
    }

    @Nullable
    final /* synthetic */ Object j(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object c = a.c(coroutineContext, a.a(flowCollector, continuation.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), continuation, 4, null);
        d = kotlin.coroutines.intrinsics.b.d();
        return c == d ? c : wt2.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract Object k(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super wt2> continuation);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public String toString() {
        return this.d + " -> " + super.toString();
    }
}
