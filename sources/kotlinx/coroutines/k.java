package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.aa0;
import tb.am;
import tb.dm;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class k<T> extends kotlinx.coroutines.internal.a<T> {
    private static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(k.class, "_decision");
    private volatile int _decision;

    public k(@NotNull CoroutineContext coroutineContext, @NotNull Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
        this._decision = 0;
    }

    private final boolean b() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!a.compareAndSet(this, 0, 2));
        return true;
    }

    private final boolean c() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!a.compareAndSet(this, 0, 1));
        return true;
    }

    @Nullable
    public final Object a() {
        Object d;
        if (c()) {
            d = kotlin.coroutines.intrinsics.b.d();
            return d;
        }
        Object h = s.h(getState$kotlinx_coroutines_core());
        if (h instanceof am) {
            throw ((am) h).a;
        }
        return h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.internal.a, kotlinx.coroutines.JobSupport
    public void afterCompletion(@Nullable Object obj) {
        afterResume(obj);
    }

    @Override // kotlinx.coroutines.internal.a, kotlinx.coroutines.a
    protected void afterResume(@Nullable Object obj) {
        Continuation c;
        if (b()) {
            return;
        }
        c = IntrinsicsKt__IntrinsicsJvmKt.c(this.uCont);
        aa0.c(c, dm.a(obj, this.uCont), null, 2, null);
    }
}
