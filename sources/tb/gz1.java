package tb;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class gz1<E> extends ma1 implements ReceiveOrClosed<E> {
    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    @NotNull
    /* renamed from: t */
    public kj2 getOfferResult() {
        return k1.OFFER_SUCCESS;
    }

    @Nullable
    public Function1<Throwable, wt2> u(E e) {
        return null;
    }

    public abstract void v(@NotNull zj<?> zjVar);
}
