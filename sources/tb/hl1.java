package tb;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class hl1 implements FlowCollector<Object> {
    public static final hl1 INSTANCE = new hl1();

    private hl1() {
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(@Nullable Object obj, @NotNull Continuation<? super wt2> continuation) {
        return wt2.INSTANCE;
    }
}
