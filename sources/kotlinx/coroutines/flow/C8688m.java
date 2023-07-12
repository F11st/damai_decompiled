package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import tb.cm1;
import tb.k40;
import tb.kj2;
import tb.zb2;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.flow.m */
/* loaded from: classes11.dex */
public final class C8688m {
    private static final kj2 a = new kj2("NONE");
    private static final kj2 b = new kj2("PENDING");

    @NotNull
    public static final <T> MutableStateFlow<T> a(T t) {
        if (t == null) {
            t = (T) cm1.NULL;
        }
        return new StateFlowImpl(t);
    }

    @NotNull
    public static final <T> Flow<T> d(@NotNull StateFlow<? extends T> stateFlow, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        if (k40.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        return (((i < 0 || 1 < i) && i != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? zb2.a(stateFlow, coroutineContext, i, bufferOverflow) : stateFlow;
    }

    public static final void e(@NotNull MutableStateFlow<Integer> mutableStateFlow, int i) {
        int intValue;
        do {
            intValue = mutableStateFlow.getValue().intValue();
        } while (!mutableStateFlow.compareAndSet(Integer.valueOf(intValue), Integer.valueOf(intValue + i)));
    }
}
