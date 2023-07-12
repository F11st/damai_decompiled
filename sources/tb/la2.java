package tb;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* loaded from: classes11.dex */
public final class la2<T> implements FlowCollector<T> {
    private final SendChannel<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public la2(@NotNull SendChannel<? super T> sendChannel) {
        this.a = sendChannel;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull Continuation<? super wt2> continuation) {
        Object d;
        Object send = this.a.send(t, continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return send == d ? send : wt2.INSTANCE;
    }
}
