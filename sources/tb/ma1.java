package tb;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* loaded from: classes11.dex */
public class ma1 {
    static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(ma1.class, Object.class, "_next");
    static final AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(ma1.class, Object.class, "_prev");
    private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(ma1.class, Object.class, "_removedRef");
    volatile Object _next = this;
    volatile Object _prev = this;
    private volatile Object _removedRef = null;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class a extends t8 {
        @Override // tb.t8
        public final void a(@NotNull v8<?> v8Var, @Nullable Object obj) {
            boolean z = obj == null;
            ma1 h = h();
            if (h != null) {
                ma1 i = i();
                if (i != null) {
                    if (ma1.a.compareAndSet(h, v8Var, z ? n(h, i) : i) && z) {
                        f(h, i);
                    }
                } else if (k40.a() && !(!z)) {
                    throw new AssertionError();
                }
            } else if (k40.a() && !(!z)) {
                throw new AssertionError();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
            if (tb.k40.a() == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
            if (r4 != null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
            r7 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
            if (r7 == false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
            throw new java.lang.AssertionError();
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0066, code lost:
            return null;
         */
        @Override // tb.t8
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object c(@org.jetbrains.annotations.NotNull tb.v8<?> r7) {
            /*
                r6 = this;
            L0:
                tb.ma1 r0 = r6.m(r7)
                if (r0 == 0) goto L6e
                java.lang.Object r1 = r0._next
                r2 = 0
                if (r1 != r7) goto Lc
                return r2
            Lc:
                boolean r3 = r7.h()
                if (r3 == 0) goto L13
                return r2
            L13:
                boolean r3 = r1 instanceof tb.cn1
                if (r3 == 0) goto L26
                tb.cn1 r1 = (tb.cn1) r1
                boolean r2 = r7.b(r1)
                if (r2 == 0) goto L22
                java.lang.Object r7 = tb.u8.RETRY_ATOMIC
                return r7
            L22:
                r1.c(r0)
                goto L0
            L26:
                java.lang.Object r3 = r6.e(r0)
                if (r3 == 0) goto L2d
                return r3
            L2d:
                boolean r3 = r6.l(r0, r1)
                if (r3 == 0) goto L34
                goto L0
            L34:
                tb.ma1$d r3 = new tb.ma1$d
            */
            //  java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
            /*
                java.util.Objects.requireNonNull(r1, r4)
                r4 = r1
                tb.ma1 r4 = (tb.ma1) r4
                r3.<init>(r0, r4, r6)
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = tb.ma1.a
                boolean r4 = r4.compareAndSet(r0, r1, r3)
                if (r4 == 0) goto L0
                java.lang.Object r4 = r3.c(r0)     // Catch: java.lang.Throwable -> L67
                java.lang.Object r5 = tb.na1.REMOVE_PREPARED     // Catch: java.lang.Throwable -> L67
                if (r4 != r5) goto L52
                goto L0
            L52:
                boolean r7 = tb.k40.a()     // Catch: java.lang.Throwable -> L67
                if (r7 == 0) goto L66
                if (r4 != 0) goto L5c
                r7 = 1
                goto L5d
            L5c:
                r7 = 0
            L5d:
                if (r7 == 0) goto L60
                goto L66
            L60:
                java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L67
                r7.<init>()     // Catch: java.lang.Throwable -> L67
                throw r7     // Catch: java.lang.Throwable -> L67
            L66:
                return r2
            L67:
                r7 = move-exception
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = tb.ma1.a
                r2.compareAndSet(r0, r3, r1)
                throw r7
            L6e:
                java.lang.Object r7 = tb.u8.RETRY_ATOMIC
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.ma1.a.c(tb.v8):java.lang.Object");
        }

        @Nullable
        protected Object e(@NotNull ma1 ma1Var) {
            return null;
        }

        protected abstract void f(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2);

        public abstract void g(@NotNull d dVar);

        @Nullable
        protected abstract ma1 h();

        @Nullable
        protected abstract ma1 i();

        @Nullable
        public Object j(@NotNull d dVar) {
            g(dVar);
            return null;
        }

        public void k(@NotNull ma1 ma1Var) {
        }

        protected abstract boolean l(@NotNull ma1 ma1Var, @NotNull Object obj);

        @Nullable
        protected abstract ma1 m(@NotNull cn1 cn1Var);

        @NotNull
        public abstract Object n(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class b<T extends ma1> extends a {
        private static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_affectedNode");
        private volatile Object _affectedNode;
        @JvmField
        @NotNull
        public final ma1 b;
        @JvmField
        @NotNull
        public final T c;

        public b(@NotNull ma1 ma1Var, @NotNull T t) {
            this.b = ma1Var;
            this.c = t;
            if (k40.a()) {
                if (!(t._next == t && ((ma1) t._prev) == t)) {
                    throw new AssertionError();
                }
            }
            this._affectedNode = null;
        }

        @Override // tb.ma1.a
        protected void f(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2) {
            this.c.i(this.b);
        }

        @Override // tb.ma1.a
        public void g(@NotNull d dVar) {
            d.compareAndSet(this, null, dVar.a);
        }

        @Override // tb.ma1.a
        @Nullable
        protected final ma1 h() {
            return (ma1) this._affectedNode;
        }

        @Override // tb.ma1.a
        @Nullable
        protected final ma1 i() {
            return this.b;
        }

        @Override // tb.ma1.a
        protected boolean l(@NotNull ma1 ma1Var, @NotNull Object obj) {
            return obj != this.b;
        }

        @Override // tb.ma1.a
        @Nullable
        protected final ma1 m(@NotNull cn1 cn1Var) {
            return this.b.g(cn1Var);
        }

        @Override // tb.ma1.a
        @NotNull
        public Object n(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2) {
            T t = this.c;
            ma1.b.compareAndSet(t, t, ma1Var);
            T t2 = this.c;
            ma1.a.compareAndSet(t2, t2, this.b);
            return this.c;
        }
    }

    /* compiled from: Taobao */
    @PublishedApi
    /* loaded from: classes11.dex */
    public static abstract class c extends v8<ma1> {
        @JvmField
        @Nullable
        public ma1 b;
        @JvmField
        @NotNull
        public final ma1 c;

        public c(@NotNull ma1 ma1Var) {
            this.c = ma1Var;
        }

        @Override // tb.v8
        /* renamed from: j */
        public void d(@NotNull ma1 ma1Var, @Nullable Object obj) {
            boolean z = obj == null;
            ma1 ma1Var2 = z ? this.c : this.b;
            if (ma1Var2 != null && ma1.a.compareAndSet(ma1Var, this, ma1Var2) && z) {
                ma1 ma1Var3 = this.c;
                ma1 ma1Var4 = this.b;
                b41.f(ma1Var4);
                ma1Var3.i(ma1Var4);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class d extends cn1 {
        @JvmField
        @NotNull
        public final ma1 a;
        @JvmField
        @NotNull
        public final ma1 b;
        @JvmField
        @NotNull
        public final a c;

        public d(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2, @NotNull a aVar) {
            this.a = ma1Var;
            this.b = ma1Var2;
            this.c = aVar;
        }

        @Override // tb.cn1
        @NotNull
        public v8<?> a() {
            return this.c.b();
        }

        @Override // tb.cn1
        @Nullable
        public Object c(@Nullable Object obj) {
            Object f;
            Object obj2;
            if (k40.a()) {
                if (!(obj == this.a)) {
                    throw new AssertionError();
                }
            }
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            ma1 ma1Var = (ma1) obj;
            Object j = this.c.j(this);
            Object obj3 = na1.REMOVE_PREPARED;
            if (j == obj3) {
                ma1 ma1Var2 = this.b;
                if (ma1.a.compareAndSet(ma1Var, this, ma1Var2.r())) {
                    this.c.k(ma1Var);
                    ma1Var2.g(null);
                }
                return obj3;
            }
            if (j != null) {
                f = a().e(j);
            } else {
                f = a().f();
            }
            if (f == u8.NO_DECISION) {
                obj2 = a();
            } else if (f == null) {
                obj2 = this.c.n(ma1Var, this.b);
            } else {
                obj2 = this.b;
            }
            ma1.a.compareAndSet(ma1Var, this, obj2);
            return null;
        }

        public final void d() {
            this.c.g(this);
        }

        @Override // tb.cn1
        @NotNull
        public String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class e<T> extends a {
        private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_affectedNode");
        private static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "_originalNext");
        private volatile Object _affectedNode = null;
        private volatile Object _originalNext = null;
        @JvmField
        @NotNull
        public final ma1 b;

        public e(@NotNull ma1 ma1Var) {
            this.b = ma1Var;
        }

        @Override // tb.ma1.a
        @Nullable
        protected Object e(@NotNull ma1 ma1Var) {
            if (ma1Var == this.b) {
                return la1.b();
            }
            return null;
        }

        @Override // tb.ma1.a
        protected final void f(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2) {
            ma1Var2.g(null);
        }

        @Override // tb.ma1.a
        public void g(@NotNull d dVar) {
            c.compareAndSet(this, null, dVar.a);
            d.compareAndSet(this, null, dVar.b);
        }

        @Override // tb.ma1.a
        @Nullable
        protected final ma1 h() {
            return (ma1) this._affectedNode;
        }

        @Override // tb.ma1.a
        @Nullable
        protected final ma1 i() {
            return (ma1) this._originalNext;
        }

        @Override // tb.ma1.a
        protected final boolean l(@NotNull ma1 ma1Var, @NotNull Object obj) {
            if (obj instanceof p12) {
                ((p12) obj).a.n();
                return true;
            }
            return false;
        }

        @Override // tb.ma1.a
        @Nullable
        protected final ma1 m(@NotNull cn1 cn1Var) {
            ma1 ma1Var = this.b;
            while (true) {
                Object obj = ma1Var._next;
                if (obj instanceof cn1) {
                    cn1 cn1Var2 = (cn1) obj;
                    if (cn1Var.b(cn1Var2)) {
                        return null;
                    }
                    cn1Var2.c(this.b);
                } else {
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
                    return (ma1) obj;
                }
            }
        }

        @Override // tb.ma1.a
        @NotNull
        public final Object n(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2) {
            return ma1Var2.r();
        }

        public final T o() {
            T t = (T) h();
            b41.f(t);
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
        if (tb.ma1.a.compareAndSet(r3, r2, ((tb.p12) r4).a) != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tb.ma1 g(tb.cn1 r7) {
        /*
            r6 = this;
        L0:
            java.lang.Object r0 = r6._prev
            tb.ma1 r0 = (tb.ma1) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r6) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = tb.ma1.b
            boolean r0 = r1.compareAndSet(r6, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r6.o()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r7) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof tb.cn1
            if (r5 == 0) goto L38
            if (r7 == 0) goto L32
            r0 = r4
            tb.cn1 r0 = (tb.cn1) r0
            boolean r0 = r7.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            tb.cn1 r4 = (tb.cn1) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof tb.p12
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = tb.ma1.a
            tb.p12 r4 = (tb.p12) r4
            tb.ma1 r4 = r4.a
            boolean r2 = r5.compareAndSet(r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            tb.ma1 r2 = (tb.ma1) r2
            goto L7
        L52:
        */
        //  java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            java.util.Objects.requireNonNull(r4, r3)
            tb.ma1 r4 = (tb.ma1) r4
            r3 = r2
            r2 = r4
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ma1.g(tb.cn1):tb.ma1");
    }

    private final ma1 h(ma1 ma1Var) {
        while (ma1Var.o()) {
            ma1Var = (ma1) ma1Var._prev;
        }
        return ma1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(ma1 ma1Var) {
        ma1 ma1Var2;
        do {
            ma1Var2 = (ma1) ma1Var._prev;
            if (j() != ma1Var) {
                return;
            }
        } while (!b.compareAndSet(ma1Var, ma1Var2, this));
        if (o()) {
            ma1Var.g(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p12 r() {
        p12 p12Var = (p12) this._removedRef;
        if (p12Var != null) {
            return p12Var;
        }
        p12 p12Var2 = new p12(this);
        c.lazySet(this, p12Var2);
        return p12Var2;
    }

    public final void d(@NotNull ma1 ma1Var) {
        do {
        } while (!l().e(ma1Var, this));
    }

    @PublishedApi
    public final boolean e(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2) {
        b.lazySet(ma1Var, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(ma1Var, ma1Var2);
        if (atomicReferenceFieldUpdater.compareAndSet(this, ma1Var2, ma1Var)) {
            ma1Var.i(ma1Var2);
            return true;
        }
        return false;
    }

    public final boolean f(@NotNull ma1 ma1Var) {
        b.lazySet(ma1Var, this);
        a.lazySet(ma1Var, this);
        while (j() == this) {
            if (a.compareAndSet(this, this, ma1Var)) {
                ma1Var.i(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Object j() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof cn1)) {
                return obj;
            }
            ((cn1) obj).c(this);
        }
    }

    @NotNull
    public final ma1 k() {
        return la1.c(j());
    }

    @NotNull
    public final ma1 l() {
        ma1 g = g(null);
        return g != null ? g : h((ma1) this._prev);
    }

    public final void m() {
        Object j = j();
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
        ((p12) j).a.g(null);
    }

    @PublishedApi
    public final void n() {
        ma1 ma1Var = this;
        while (true) {
            Object j = ma1Var.j();
            if (!(j instanceof p12)) {
                ma1Var.g(null);
                return;
            }
            ma1Var = ((p12) j).a;
        }
    }

    public boolean o() {
        return j() instanceof p12;
    }

    public boolean p() {
        return q() == null;
    }

    @PublishedApi
    @Nullable
    public final ma1 q() {
        Object j;
        ma1 ma1Var;
        do {
            j = j();
            if (j instanceof p12) {
                return ((p12) j).a;
            }
            if (j == this) {
                return (ma1) j;
            }
            Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            ma1Var = (ma1) j;
        } while (!a.compareAndSet(this, j, ma1Var.r()));
        ma1Var.g(null);
        return null;
    }

    @PublishedApi
    public final int s(@NotNull ma1 ma1Var, @NotNull ma1 ma1Var2, @NotNull c cVar) {
        b.lazySet(ma1Var, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        atomicReferenceFieldUpdater.lazySet(ma1Var, ma1Var2);
        cVar.b = ma1Var2;
        if (atomicReferenceFieldUpdater.compareAndSet(this, ma1Var2, cVar)) {
            return cVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }
}
