package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class h<T> implements StateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private final /* synthetic */ StateFlow<? extends T> a;

    public h(@NotNull StateFlow<? extends T> stateFlow) {
        this.a = stateFlow;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @InternalCoroutinesApi
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super wt2> continuation) {
        return this.a.collect(flowCollector, continuation);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    @NotNull
    public Flow<T> fuse(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return m.d(this, coroutineContext, i, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    @NotNull
    public List<T> getReplayCache() {
        return (List<? extends T>) this.a.getReplayCache();
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public T getValue() {
        return this.a.getValue();
    }
}
