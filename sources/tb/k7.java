package tb;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8207h;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractC8641a;
import kotlinx.coroutines.channels.AbstractChannel;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ReceiveOrClosed;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class k7<E> extends AbstractChannel<E> {
    private final ReentrantLock d;
    private Object[] e;
    private int f;
    private final int g;
    private final BufferOverflow h;
    private volatile int size;

    public k7(int i, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, wt2> function1) {
        super(function1);
        this.g = i;
        this.h = bufferOverflow;
        if (i >= 1) {
            this.d = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i, 8)];
            C8207h.k(objArr, k1.EMPTY, 0, 0, 6, null);
            wt2 wt2Var = wt2.INSTANCE;
            this.e = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
    }

    private final void W(int i, E e) {
        if (i < this.g) {
            X(i);
            Object[] objArr = this.e;
            objArr[(this.f + i) % objArr.length] = e;
            return;
        }
        if (k40.a()) {
            if (!(this.h == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.e;
        int i2 = this.f;
        objArr2[i2 % objArr2.length] = null;
        objArr2[(i + i2) % objArr2.length] = e;
        this.f = (i2 + 1) % objArr2.length;
    }

    private final void X(int i) {
        Object[] objArr = this.e;
        if (i >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.g);
            Object[] objArr2 = new Object[min];
            for (int i2 = 0; i2 < i; i2++) {
                Object[] objArr3 = this.e;
                objArr2[i2] = objArr3[(this.f + i2) % objArr3.length];
            }
            C8207h.j(objArr2, k1.EMPTY, i, min);
            this.e = objArr2;
            this.f = 0;
        }
    }

    private final kj2 Y(int i) {
        if (i < this.g) {
            this.size = i + 1;
            return null;
        }
        int i2 = j7.$EnumSwitchMapping$0[this.h.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
            return k1.OFFER_SUCCESS;
        }
        return k1.OFFER_FAILED;
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
        return this.size == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public void M(boolean z) {
        Function1<E, wt2> function1 = this.b;
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.e[this.f];
                if (function1 != null && obj != k1.EMPTY) {
                    undeliveredElementException = OnUndeliveredElementKt.c(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.e;
                int i3 = this.f;
                objArr[i3] = k1.EMPTY;
                this.f = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            wt2 wt2Var = wt2.INSTANCE;
            reentrantLock.unlock();
            super.M(z);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
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
            int i = this.size;
            if (i == 0) {
                Object i2 = i();
                if (i2 == null) {
                    i2 = k1.POLL_FAILED;
                }
                return i2;
            }
            Object[] objArr = this.e;
            int i3 = this.f;
            Object obj = objArr[i3];
            ha2 ha2Var = null;
            objArr[i3] = null;
            this.size = i - 1;
            Object obj2 = k1.POLL_FAILED;
            if (i == this.g) {
                ha2 ha2Var2 = null;
                while (true) {
                    ha2 z = z();
                    if (z == null) {
                        ha2Var = ha2Var2;
                        break;
                    }
                    b41.f(z);
                    kj2 w = z.w(null);
                    if (w != null) {
                        if (k40.a()) {
                            if (!(w == cg.RESUME_TOKEN)) {
                                throw new AssertionError();
                            }
                        }
                        b41.f(z);
                        obj2 = z.u();
                        ha2Var = z;
                        r6 = true;
                    } else {
                        b41.f(z);
                        z.x();
                        ha2Var2 = z;
                    }
                }
            }
            if (obj2 != k1.POLL_FAILED && !(obj2 instanceof zj)) {
                this.size = i;
                Object[] objArr2 = this.e;
                objArr2[(this.f + i) % objArr2.length] = obj2;
            }
            this.f = (this.f + 1) % this.e.length;
            wt2 wt2Var = wt2.INSTANCE;
            if (r6) {
                b41.f(ha2Var);
                ha2Var.t();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009f A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:3:0x0005, B:5:0x0009, B:8:0x0010, B:11:0x0016, B:13:0x002a, B:15:0x0034, B:34:0x0085, B:36:0x0089, B:38:0x008d, B:44:0x00af, B:39:0x0099, B:41:0x009f, B:17:0x0044, B:20:0x0049, B:23:0x004e, B:25:0x0054, B:28:0x0060, B:30:0x0064, B:31:0x0069, B:32:0x0083), top: B:52:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.Object Q(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.d
            r0.lock()
            int r1 = r8.size     // Catch: java.lang.Throwable -> Lc6
            if (r1 != 0) goto L16
            tb.zj r9 = r8.i()     // Catch: java.lang.Throwable -> Lc6
            if (r9 == 0) goto L10
            goto L12
        L10:
            tb.kj2 r9 = tb.k1.POLL_FAILED     // Catch: java.lang.Throwable -> Lc6
        L12:
            r0.unlock()
            return r9
        L16:
            java.lang.Object[] r2 = r8.e     // Catch: java.lang.Throwable -> Lc6
            int r3 = r8.f     // Catch: java.lang.Throwable -> Lc6
            r4 = r2[r3]     // Catch: java.lang.Throwable -> Lc6
            r5 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> Lc6
            int r2 = r1 + (-1)
            r8.size = r2     // Catch: java.lang.Throwable -> Lc6
            tb.kj2 r2 = tb.k1.POLL_FAILED     // Catch: java.lang.Throwable -> Lc6
            int r3 = r8.g     // Catch: java.lang.Throwable -> Lc6
            r6 = 1
            if (r1 != r3) goto L84
        L2a:
            kotlinx.coroutines.channels.AbstractChannel$g r3 = r8.E()     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r7 = r9.performAtomicTrySelect(r3)     // Catch: java.lang.Throwable -> Lc6
            if (r7 != 0) goto L44
            java.lang.Object r2 = r3.o()     // Catch: java.lang.Throwable -> Lc6
            r5 = r2
            tb.ha2 r5 = (tb.ha2) r5     // Catch: java.lang.Throwable -> Lc6
            tb.b41.f(r5)     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r2 = r5.u()     // Catch: java.lang.Throwable -> Lc6
        L42:
            r3 = 1
            goto L85
        L44:
            tb.kj2 r3 = tb.k1.POLL_FAILED     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r3) goto L49
            goto L84
        L49:
            java.lang.Object r3 = tb.u8.RETRY_ATOMIC     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r3) goto L4e
            goto L2a
        L4e:
            java.lang.Object r2 = tb.ba2.d()     // Catch: java.lang.Throwable -> Lc6
            if (r7 != r2) goto L60
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r8.f     // Catch: java.lang.Throwable -> Lc6
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            return r7
        L60:
            boolean r2 = r7 instanceof tb.zj     // Catch: java.lang.Throwable -> Lc6
            if (r2 == 0) goto L69
            r5 = r7
            tb.ha2 r5 = (tb.ha2) r5     // Catch: java.lang.Throwable -> Lc6
            r2 = r7
            goto L42
        L69:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc6
            r9.<init>()     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r1 = "performAtomicTrySelect(describeTryOffer) returned "
            r9.append(r1)     // Catch: java.lang.Throwable -> Lc6
            r9.append(r7)     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc6
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc6
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Lc6
            r1.<init>(r9)     // Catch: java.lang.Throwable -> Lc6
            throw r1     // Catch: java.lang.Throwable -> Lc6
        L84:
            r3 = 0
        L85:
            tb.kj2 r7 = tb.k1.POLL_FAILED     // Catch: java.lang.Throwable -> Lc6
            if (r2 == r7) goto L99
            boolean r7 = r2 instanceof tb.zj     // Catch: java.lang.Throwable -> Lc6
            if (r7 != 0) goto L99
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.e     // Catch: java.lang.Throwable -> Lc6
            int r7 = r8.f     // Catch: java.lang.Throwable -> Lc6
            int r7 = r7 + r1
            int r1 = r9.length     // Catch: java.lang.Throwable -> Lc6
            int r7 = r7 % r1
            r9[r7] = r2     // Catch: java.lang.Throwable -> Lc6
            goto Laf
        L99:
            boolean r9 = r9.trySelect()     // Catch: java.lang.Throwable -> Lc6
            if (r9 != 0) goto Laf
            r8.size = r1     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object[] r9 = r8.e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r8.f     // Catch: java.lang.Throwable -> Lc6
            r9[r1] = r4     // Catch: java.lang.Throwable -> Lc6
            java.lang.Object r9 = tb.ba2.d()     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            return r9
        Laf:
            int r9 = r8.f     // Catch: java.lang.Throwable -> Lc6
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.e     // Catch: java.lang.Throwable -> Lc6
            int r1 = r1.length     // Catch: java.lang.Throwable -> Lc6
            int r9 = r9 % r1
            r8.f = r9     // Catch: java.lang.Throwable -> Lc6
            tb.wt2 r9 = tb.wt2.INSTANCE     // Catch: java.lang.Throwable -> Lc6
            r0.unlock()
            if (r3 == 0) goto Lc5
            tb.b41.f(r5)
            r5.t()
        Lc5:
            return r4
        Lc6:
            r9 = move-exception
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.k7.Q(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC8641a
    @Nullable
    public Object f(@NotNull ha2 ha2Var) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return super.f(ha2Var);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractC8641a
    @NotNull
    protected String g() {
        return "(buffer:capacity=" + this.g + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel, kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return super.isClosedForReceive();
        } finally {
            reentrantLock.unlock();
        }
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

    @Override // kotlinx.coroutines.channels.AbstractC8641a, kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            return r();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractC8641a
    protected final boolean p() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractC8641a
    protected final boolean q() {
        return this.size == this.g && this.h == BufferOverflow.SUSPEND;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC8641a
    @NotNull
    public Object s(E e) {
        ReceiveOrClosed<E> y;
        kj2 tryResumeReceive;
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            int i = this.size;
            zj<?> i2 = i();
            if (i2 != null) {
                return i2;
            }
            kj2 Y = Y(i);
            if (Y != null) {
                return Y;
            }
            if (i == 0) {
                do {
                    y = y();
                    if (y != null) {
                        if (y instanceof zj) {
                            this.size = i;
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
                this.size = i;
                wt2 wt2Var = wt2.INSTANCE;
                reentrantLock.unlock();
                b41.f(y);
                y.completeResumeReceive(e);
                b41.f(y);
                return y.getOfferResult();
            }
            W(i, e);
            return k1.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractC8641a
    @NotNull
    public Object t(E e, @NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            int i = this.size;
            zj<?> i2 = i();
            if (i2 != null) {
                return i2;
            }
            kj2 Y = Y(i);
            if (Y != null) {
                return Y;
            }
            if (i == 0) {
                while (true) {
                    AbstractC8641a.C8645d<E> e2 = e(e);
                    Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(e2);
                    if (performAtomicTrySelect == null) {
                        this.size = i;
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
                        this.size = i;
                        return performAtomicTrySelect;
                    }
                }
            }
            if (!selectInstance.trySelect()) {
                this.size = i;
                return ba2.d();
            }
            W(i, e);
            return k1.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }
}
