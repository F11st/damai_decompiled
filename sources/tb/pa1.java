package tb;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class pa1<E> {
    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    private volatile Object _next = null;
    private volatile long _state = 0;
    private final int a;
    private AtomicReferenceArray b;
    private final int c;
    private final boolean d;
    public static final C9546a Companion = new C9546a(null);
    @JvmField
    @NotNull
    public static final kj2 REMOVE_FROZEN = new kj2("REMOVE_FROZEN");
    private static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(pa1.class, Object.class, "_next");
    private static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(pa1.class, "_state");

    /* compiled from: Taobao */
    /* renamed from: tb.pa1$a */
    /* loaded from: classes11.dex */
    public static final class C9546a {
        private C9546a() {
        }

        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j, int i) {
            return d(j, pa1.HEAD_MASK) | (i << 0);
        }

        public final long c(long j, int i) {
            return d(j, pa1.TAIL_MASK) | (i << 30);
        }

        public final long d(long j, long j2) {
            return j & (~j2);
        }

        public /* synthetic */ C9546a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.pa1$b */
    /* loaded from: classes11.dex */
    public static final class C9547b {
        @JvmField
        public final int a;

        public C9547b(int i) {
            this.a = i;
        }
    }

    public pa1(int i, boolean z) {
        this.c = i;
        this.d = z;
        int i2 = i - 1;
        this.a = i2;
        this.b = new AtomicReferenceArray(i);
        if (!(i2 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i & i2) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final pa1<E> b(long j) {
        pa1<E> pa1Var = new pa1<>(this.c * 2, this.d);
        int i = (int) ((HEAD_MASK & j) >> 0);
        int i2 = (int) ((TAIL_MASK & j) >> 30);
        while (true) {
            int i3 = this.a;
            if ((i & i3) != (i2 & i3)) {
                Object obj = this.b.get(i3 & i);
                if (obj == null) {
                    obj = new C9547b(i);
                }
                pa1Var.b.set(pa1Var.a & i, obj);
                i++;
            } else {
                pa1Var._state = Companion.d(j, 1152921504606846976L);
                return pa1Var;
            }
        }
    }

    private final pa1<E> c(long j) {
        while (true) {
            pa1<E> pa1Var = (pa1) this._next;
            if (pa1Var != null) {
                return pa1Var;
            }
            e.compareAndSet(this, null, b(j));
        }
    }

    private final pa1<E> e(int i, E e2) {
        Object obj = this.b.get(this.a & i);
        if ((obj instanceof C9547b) && ((C9547b) obj).a == i) {
            this.b.set(i & this.a, e2);
            return this;
        }
        return null;
    }

    private final long h() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f.compareAndSet(this, j, j2));
        return j2;
    }

    private final pa1<E> k(int i, int i2) {
        long j;
        C9546a c9546a;
        int i3;
        do {
            j = this._state;
            c9546a = Companion;
            i3 = (int) ((HEAD_MASK & j) >> 0);
            if (k40.a()) {
                if (!(i3 == i)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return i();
            }
        } while (!f.compareAndSet(this, j, c9546a.b(j, i2)));
        this.b.set(this.a & i3, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(@org.jetbrains.annotations.NotNull E r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            tb.pa1$a r14 = tb.pa1.Companion
            int r14 = r14.a(r2)
            return r14
        L12:
            tb.pa1$a r0 = tb.pa1.Companion
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r8 = 0
            long r4 = r4 >> r8
            int r1 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r9 = 30
            long r4 = r4 >> r9
            int r9 = (int) r4
            int r10 = r13.a
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L30
            return r11
        L30:
            boolean r4 = r13.d
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.b
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L4f
            int r0 = r13.c
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4e:
            return r11
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = tb.pa1.f
            long r11 = r0.c(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.b
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L69:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L73
            goto L7e
        L73:
            tb.pa1 r0 = r0.i()
            tb.pa1 r0 = r0.e(r9, r14)
            if (r0 == 0) goto L7e
            goto L69
        L7e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.pa1.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j = this._state;
        return 1073741823 & (((int) ((j & TAIL_MASK) >> 30)) - ((int) ((HEAD_MASK & j) >> 0)));
    }

    public final boolean g() {
        long j = this._state;
        return ((int) ((HEAD_MASK & j) >> 0)) == ((int) ((j & TAIL_MASK) >> 30));
    }

    @NotNull
    public final pa1<E> i() {
        return c(h());
    }

    @Nullable
    public final Object j() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return REMOVE_FROZEN;
            }
            C9546a c9546a = Companion;
            int i = (int) ((HEAD_MASK & j) >> 0);
            int i2 = (int) ((TAIL_MASK & j) >> 30);
            int i3 = this.a;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.b.get(i3 & i);
            if (obj == null) {
                if (this.d) {
                    return null;
                }
            } else if (obj instanceof C9547b) {
                return null;
            } else {
                int i4 = (i + 1) & MAX_CAPACITY_MASK;
                if (f.compareAndSet(this, j, c9546a.b(j, i4))) {
                    this.b.set(this.a & i, null);
                    return obj;
                } else if (this.d) {
                    pa1<E> pa1Var = this;
                    do {
                        pa1Var = pa1Var.k(i, i4);
                    } while (pa1Var != null);
                    return obj;
                }
            }
        }
    }
}
