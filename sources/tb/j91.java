package tb;

import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class j91<E> extends AbstractChannel<E> {
    public j91(@Nullable Function1<? super E, wt2> function1) {
        super(function1);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean J() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean K() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractC8641a
    protected final boolean p() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractC8641a
    protected final boolean q() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC8641a
    @NotNull
    public Object s(E e) {
        ReceiveOrClosed<?> w;
        do {
            Object s = super.s(e);
            kj2 kj2Var = k1.OFFER_SUCCESS;
            if (s == kj2Var) {
                return kj2Var;
            }
            if (s == k1.OFFER_FAILED) {
                w = w(e);
                if (w == null) {
                    return kj2Var;
                }
            } else if (s instanceof zj) {
                return s;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + s).toString());
            }
        } while (!(w instanceof zj));
        return w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC8641a
    @NotNull
    public Object t(E e, @NotNull SelectInstance<?> selectInstance) {
        Object performAtomicTrySelect;
        while (true) {
            if (I()) {
                performAtomicTrySelect = super.t(e, selectInstance);
            } else {
                performAtomicTrySelect = selectInstance.performAtomicTrySelect(d(e));
                if (performAtomicTrySelect == null) {
                    performAtomicTrySelect = k1.OFFER_SUCCESS;
                }
            }
            if (performAtomicTrySelect == ba2.d()) {
                return ba2.d();
            }
            kj2 kj2Var = k1.OFFER_SUCCESS;
            if (performAtomicTrySelect == kj2Var) {
                return kj2Var;
            }
            if (performAtomicTrySelect != k1.OFFER_FAILED && performAtomicTrySelect != u8.RETRY_ATOMIC) {
                if (performAtomicTrySelect instanceof zj) {
                    return performAtomicTrySelect;
                }
                throw new IllegalStateException(("Invalid result " + performAtomicTrySelect).toString());
            }
        }
    }
}
