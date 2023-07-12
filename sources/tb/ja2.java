package tb;

import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class ja2<E> extends ia2<E> {
    @JvmField
    @NotNull
    public final Function1<E, wt2> f;

    /* JADX WARN: Multi-variable type inference failed */
    public ja2(E e, @NotNull CancellableContinuation<? super wt2> cancellableContinuation, @NotNull Function1<? super E, wt2> function1) {
        super(e, cancellableContinuation);
        this.f = function1;
    }

    @Override // tb.ma1
    public boolean p() {
        if (super.p()) {
            x();
            return true;
        }
        return false;
    }

    @Override // tb.ha2
    public void x() {
        OnUndeliveredElementKt.b(this.f, u(), this.e.getContext());
    }
}
