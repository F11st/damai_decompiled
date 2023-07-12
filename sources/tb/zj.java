package tb;

import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ma1;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class zj<E> extends ha2 implements ReceiveOrClosed<E> {
    @JvmField
    @Nullable
    public final Throwable d;

    public zj(@Nullable Throwable th) {
        this.d = th;
    }

    @NotNull
    public final Throwable A() {
        Throwable th = this.d;
        return th != null ? th : new ClosedReceiveChannelException(kotlinx.coroutines.channels.b.DEFAULT_CLOSE_MESSAGE);
    }

    @NotNull
    public final Throwable B() {
        Throwable th = this.d;
        return th != null ? th : new ClosedSendChannelException(kotlinx.coroutines.channels.b.DEFAULT_CLOSE_MESSAGE);
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void completeResumeReceive(E e) {
    }

    @Override // tb.ha2
    public void t() {
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "Closed@" + o40.b(this) + jn1.ARRAY_START + this.d + jn1.ARRAY_END;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    @Nullable
    public kj2 tryResumeReceive(E e, @Nullable ma1.d dVar) {
        kj2 kj2Var = cg.RESUME_TOKEN;
        if (dVar != null) {
            dVar.d();
        }
        return kj2Var;
    }

    @Override // tb.ha2
    public void v(@NotNull zj<?> zjVar) {
        if (k40.a()) {
            throw new AssertionError();
        }
    }

    @Override // tb.ha2
    @Nullable
    public kj2 w(@Nullable ma1.d dVar) {
        kj2 kj2Var = cg.RESUME_TOKEN;
        if (dVar != null) {
            dVar.d();
        }
        return kj2Var;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    @NotNull
    /* renamed from: y */
    public zj<E> getOfferResult() {
        return this;
    }

    @Override // tb.ha2
    @NotNull
    /* renamed from: z */
    public zj<E> u() {
        return this;
    }
}
