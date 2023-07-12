package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import tb.oh;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final /* synthetic */ class f {
    @NotNull
    public static final <T> Flow<T> a(@NotNull Flow<? extends T> flow, int i, @NotNull BufferOverflow bufferOverflow) {
        int i2;
        BufferOverflow bufferOverflow2;
        boolean z = true;
        if (i >= 0 || i == -2 || i == -1) {
            if (i == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
                z = false;
            }
            if (z) {
                if (i == -1) {
                    bufferOverflow2 = BufferOverflow.DROP_OLDEST;
                    i2 = 0;
                } else {
                    i2 = i;
                    bufferOverflow2 = bufferOverflow;
                }
                return flow instanceof FusibleFlow ? FusibleFlow.a.a((FusibleFlow) flow, null, i2, bufferOverflow2, 1, null) : new oh(flow, null, i2, bufferOverflow2, 2, null);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
        }
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i).toString());
    }

    public static /* synthetic */ Flow b(Flow flow, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return c.b(flow, i, bufferOverflow);
    }
}
