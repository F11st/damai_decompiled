package tb;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.channels.a;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class xm<E> extends AbstractChannel<E> {
    private final ReentrantLock d;
    private Object e;

    public xm(@Nullable Function1<? super E, wt2> function1) {
        super(function1);
        this.d = new ReentrantLock();
        this.e = k1.EMPTY;
    }

    private final UndeliveredElementException W(Object obj) {
        Function1<E, wt2> function1;
        Object obj2 = this.e;
        UndeliveredElementException undeliveredElementException = null;
        if (obj2 != k1.EMPTY && (function1 = this.b) != null) {
            undeliveredElementException = OnUndeliveredElementKt.d(function1, obj2, null, 2, null);
        }
        this.e = obj;
        return undeliveredElementException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean G(@NotNull gz1<? super E> gz1Var) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return super.G(gz1Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean J() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean K() {
        return this.e == k1.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void M(boolean z) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            UndeliveredElementException W = W(k1.EMPTY);
            wt2 wt2Var = wt2.INSTANCE;
            reentrantLock.unlock();
            super.M(z);
            if (W != null) {
                throw W;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    protected Object P() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            Object obj = this.e;
            kj2 kj2Var = k1.EMPTY;
            if (obj != kj2Var) {
                this.e = kj2Var;
                wt2 wt2Var = wt2.INSTANCE;
                return obj;
            }
            Object i = i();
            if (i == null) {
                i = k1.POLL_FAILED;
            }
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    @Nullable
    protected Object Q(@NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            Object obj = this.e;
            kj2 kj2Var = k1.EMPTY;
            if (obj == kj2Var) {
                Object i = i();
                if (i == null) {
                    i = k1.POLL_FAILED;
                }
                return i;
            } else if (!selectInstance.trySelect()) {
                return ba2.d();
            } else {
                Object obj2 = this.e;
                this.e = kj2Var;
                wt2 wt2Var = wt2.INSTANCE;
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    @NotNull
    protected String g() {
        return "(value=" + this.e + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return L();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean p() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean q() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public Object s(E e) {
        ReceiveOrClosed<E> y;
        kj2 tryResumeReceive;
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            zj<?> i = i();
            if (i != null) {
                return i;
            }
            if (this.e == k1.EMPTY) {
                do {
                    y = y();
                    if (y != null) {
                        if (y instanceof zj) {
                            b41.f(y);
                            return y;
                        }
                        b41.f(y);
                        tryResumeReceive = y.tryResumeReceive(e, null);
                    }
                } while (tryResumeReceive == null);
                if (k40.a()) {
                    if (!(tryResumeReceive == cg.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                wt2 wt2Var = wt2.INSTANCE;
                reentrantLock.unlock();
                b41.f(y);
                y.completeResumeReceive(e);
                b41.f(y);
                return y.getOfferResult();
            }
            UndeliveredElementException W = W(e);
            if (W == null) {
                return k1.OFFER_SUCCESS;
            }
            throw W;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @NotNull
    public Object t(E e, @NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            zj<?> i = i();
            if (i != null) {
                return i;
            }
            if (this.e == k1.EMPTY) {
                while (true) {
                    a.d<E> e2 = e(e);
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(e2);
                    if (performAtomicTrySelect == null) {
                        ReceiveOrClosed<? super E> o = e2.o();
                        wt2 wt2Var = wt2.INSTANCE;
                        reentrantLock.unlock();
                        b41.f(o);
                        o.completeResumeReceive(e);
                        b41.f(o);
                        return o.getOfferResult();
                    } else if (performAtomicTrySelect == k1.OFFER_FAILED) {
                        break;
                    } else if (performAtomicTrySelect != u8.RETRY_ATOMIC) {
                        if (performAtomicTrySelect != ba2.d() && !(performAtomicTrySelect instanceof zj)) {
                            throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + performAtomicTrySelect).toString());
                        }
                        return performAtomicTrySelect;
                    }
                }
            }
            if (!selectInstance.trySelect()) {
                return ba2.d();
            }
            UndeliveredElementException W = W(e);
            if (W == null) {
                return k1.OFFER_SUCCESS;
            }
            throw W;
        } finally {
            reentrantLock.unlock();
        }
    }
}
