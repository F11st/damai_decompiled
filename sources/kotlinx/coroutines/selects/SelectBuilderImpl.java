package kotlinx.coroutines.selects;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.PublishedApi;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.j;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.am;
import tb.b41;
import tb.b61;
import tb.ba2;
import tb.cg;
import tb.cn1;
import tb.dm;
import tb.eg;
import tb.i32;
import tb.jn1;
import tb.k40;
import tb.ka1;
import tb.ma1;
import tb.no;
import tb.oa2;
import tb.pf2;
import tb.st2;
import tb.t8;
import tb.v8;
import tb.wt2;

/* compiled from: Taobao */
@PublishedApi
/* loaded from: classes11.dex */
public final class SelectBuilderImpl<R> extends ka1 implements SelectBuilder<R>, SelectInstance<R>, Continuation<R>, CoroutineStackFrame {
    static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_state");
    static final AtomicReferenceFieldUpdater f = AtomicReferenceFieldUpdater.newUpdater(SelectBuilderImpl.class, Object.class, "_result");
    private volatile Object _parentHandle;
    volatile Object _result;
    volatile Object _state = ba2.e();
    private final Continuation<R> d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a extends v8<Object> {
        private final long b;
        @JvmField
        @NotNull
        public final SelectBuilderImpl<?> c;
        @JvmField
        @NotNull
        public final t8 d;

        public a(@NotNull SelectBuilderImpl<?> selectBuilderImpl, @NotNull t8 t8Var) {
            oa2 oa2Var;
            this.c = selectBuilderImpl;
            this.d = t8Var;
            oa2Var = ba2.e;
            this.b = oa2Var.a();
            t8Var.d(this);
        }

        private final void j(Object obj) {
            boolean z = obj == null;
            if (SelectBuilderImpl.e.compareAndSet(this.c, this, z ? null : ba2.e()) && z) {
                this.c.u();
            }
        }

        private final Object k() {
            SelectBuilderImpl<?> selectBuilderImpl = this.c;
            while (true) {
                Object obj = selectBuilderImpl._state;
                if (obj == this) {
                    return null;
                }
                if (obj instanceof cn1) {
                    ((cn1) obj).c(this.c);
                } else if (obj == ba2.e()) {
                    if (SelectBuilderImpl.e.compareAndSet(this.c, ba2.e(), this)) {
                        return null;
                    }
                } else {
                    return ba2.d();
                }
            }
        }

        private final void l() {
            SelectBuilderImpl.e.compareAndSet(this.c, this, ba2.e());
        }

        @Override // tb.v8
        public void d(@Nullable Object obj, @Nullable Object obj2) {
            j(obj2);
            this.d.a(this, obj2);
        }

        @Override // tb.v8
        public long g() {
            return this.b;
        }

        @Override // tb.v8
        @Nullable
        public Object i(@Nullable Object obj) {
            Object k;
            if (obj != null || (k = k()) == null) {
                try {
                    return this.d.c(this);
                } catch (Throwable th) {
                    if (obj == null) {
                        l();
                    }
                    throw th;
                }
            }
            return k;
        }

        @Override // tb.cn1
        @NotNull
        public String toString() {
            return "AtomicSelectOp(sequence=" + g() + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class b extends ma1 {
        @JvmField
        @NotNull
        public final DisposableHandle d;

        public b(@NotNull DisposableHandle disposableHandle) {
            this.d = disposableHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class c extends cn1 {
        @JvmField
        @NotNull
        public final ma1.d a;

        public c(@NotNull ma1.d dVar) {
            this.a = dVar;
        }

        @Override // tb.cn1
        @Nullable
        public v8<?> a() {
            return this.a.a();
        }

        @Override // tb.cn1
        @Nullable
        public Object c(@Nullable Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectBuilderImpl<*>");
            SelectBuilderImpl selectBuilderImpl = (SelectBuilderImpl) obj;
            this.a.d();
            Object e = this.a.a().e(null);
            SelectBuilderImpl.e.compareAndSet(selectBuilderImpl, this, e == null ? this.a.c : ba2.e());
            return e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public final class d extends b61<Job> {
        public d(@NotNull Job job) {
            super(job);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
            t(th);
            return wt2.INSTANCE;
        }

        @Override // tb.cm
        public void t(@Nullable Throwable th) {
            if (SelectBuilderImpl.this.trySelect()) {
                SelectBuilderImpl.this.resumeSelectWithException(this.d.getCancellationException());
            }
        }

        @Override // tb.ma1
        @NotNull
        public String toString() {
            return "SelectOnCancelling[" + SelectBuilderImpl.this + jn1.ARRAY_END;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        Object obj;
        this.d = continuation;
        obj = ba2.c;
        this._result = obj;
        this._parentHandle = null;
    }

    private final void initCancellability() {
        Job job = (Job) getContext().get(Job.Key);
        if (job != null) {
            DisposableHandle e2 = Job.a.e(job, true, false, new d(job), 2, null);
            y(e2);
            if (isSelected()) {
                e2.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        DisposableHandle v = v();
        if (v != null) {
            v.dispose();
        }
        Object j = j();
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        for (ma1 ma1Var = (ma1) j; !b41.d(ma1Var, this); ma1Var = ma1Var.k()) {
            if (ma1Var instanceof b) {
                ((b) ma1Var).d.dispose();
            }
        }
    }

    private final DisposableHandle v() {
        return (DisposableHandle) this._parentHandle;
    }

    private final void y(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void disposeOnSelect(@NotNull DisposableHandle disposableHandle) {
        b bVar = new b(disposableHandle);
        if (!isSelected()) {
            d(bVar);
            if (!isSelected()) {
                return;
            }
        }
        disposableHandle.dispose();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<R> continuation = this.d;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @NotNull
    public Continuation<R> getCompletion() {
        return this;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.d.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.a.a(this, selectClause2, function2);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean isSelected() {
        while (true) {
            Object obj = this._state;
            if (obj == ba2.e()) {
                return false;
            }
            if (!(obj instanceof cn1)) {
                return true;
            }
            ((cn1) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void onTimeout(long j, @NotNull final Function1<? super Continuation<? super R>, ? extends Object> function1) {
        if (j <= 0) {
            if (trySelect()) {
                st2.c(function1, getCompletion());
                return;
            }
            return;
        }
        disposeOnSelect(j.b(getContext()).invokeOnTimeout(j, new Runnable() { // from class: kotlinx.coroutines.selects.SelectBuilderImpl$onTimeout$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                if (SelectBuilderImpl.this.trySelect()) {
                    eg.b(function1, SelectBuilderImpl.this.getCompletion());
                }
            }
        }, getContext()));
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    @Nullable
    public Object performAtomicTrySelect(@NotNull t8 t8Var) {
        return new a(this, t8Var).c(null);
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public void resumeSelectWithException(@NotNull Throwable th) {
        Object obj;
        Object obj2;
        Object d2;
        Object d3;
        Object obj3;
        Continuation c2;
        if (k40.a() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj4 = this._result;
            obj = ba2.c;
            if (obj4 == obj) {
                Continuation<R> continuation = this.d;
                am amVar = new am((k40.d() && (continuation instanceof CoroutineStackFrame)) ? pf2.a(th, (CoroutineStackFrame) continuation) : th, false, 2, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
                obj2 = ba2.c;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, amVar)) {
                    return;
                }
            } else {
                d2 = kotlin.coroutines.intrinsics.b.d();
                if (obj4 == d2) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f;
                    d3 = kotlin.coroutines.intrinsics.b.d();
                    obj3 = ba2.d;
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, d3, obj3)) {
                        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(this.d);
                        Result.a aVar = Result.Companion;
                        c2.resumeWith(Result.m1271constructorimpl(i32.a(th)));
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        Object obj2;
        Object obj3;
        Object d2;
        Object d3;
        Object obj4;
        if (k40.a() && !isSelected()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj5 = this._result;
            obj2 = ba2.c;
            if (obj5 == obj2) {
                Object d4 = dm.d(obj, null, 1, null);
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
                obj3 = ba2.c;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, d4)) {
                    return;
                }
            } else {
                d2 = kotlin.coroutines.intrinsics.b.d();
                if (obj5 == d2) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f;
                    d3 = kotlin.coroutines.intrinsics.b.d();
                    obj4 = ba2.d;
                    if (atomicReferenceFieldUpdater2.compareAndSet(this, d3, obj4)) {
                        if (Result.m1277isFailureimpl(obj)) {
                            Continuation<R> continuation = this.d;
                            Throwable m1274exceptionOrNullimpl = Result.m1274exceptionOrNullimpl(obj);
                            b41.f(m1274exceptionOrNullimpl);
                            Result.a aVar = Result.Companion;
                            if (k40.d() && (continuation instanceof CoroutineStackFrame)) {
                                m1274exceptionOrNullimpl = pf2.a(m1274exceptionOrNullimpl, (CoroutineStackFrame) continuation);
                            }
                            continuation.resumeWith(Result.m1271constructorimpl(i32.a(m1274exceptionOrNullimpl)));
                            return;
                        }
                        this.d.resumeWith(obj);
                        return;
                    }
                } else {
                    throw new IllegalStateException("Already resumed");
                }
            }
        }
    }

    @Override // tb.ma1
    @NotNull
    public String toString() {
        return "SelectInstance(state=" + this._state + ", result=" + this._result + ')';
    }

    @Override // kotlinx.coroutines.selects.SelectInstance
    public boolean trySelect() {
        Object trySelectOther = trySelectOther(null);
        if (trySelectOther == cg.RESUME_TOKEN) {
            return true;
        }
        if (trySelectOther == null) {
            return false;
        }
        throw new IllegalStateException(("Unexpected trySelectIdempotent result " + trySelectOther).toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
        u();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
        return tb.cg.RESUME_TOKEN;
     */
    @Override // kotlinx.coroutines.selects.SelectInstance
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object trySelectOther(@org.jetbrains.annotations.Nullable tb.ma1.d r4) {
        /*
            r3 = this;
        L0:
            java.lang.Object r0 = r3._state
            java.lang.Object r1 = tb.ba2.e()
            r2 = 0
            if (r0 != r1) goto L37
            if (r4 != 0) goto L18
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.selects.SelectBuilderImpl.e
            java.lang.Object r1 = tb.ba2.e()
            boolean r0 = r0.compareAndSet(r3, r1, r2)
            if (r0 != 0) goto L31
            goto L0
        L18:
            kotlinx.coroutines.selects.SelectBuilderImpl$c r0 = new kotlinx.coroutines.selects.SelectBuilderImpl$c
            r0.<init>(r4)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.selects.SelectBuilderImpl.e
            java.lang.Object r2 = tb.ba2.e()
            boolean r1 = r1.compareAndSet(r3, r2, r0)
            if (r1 != 0) goto L2a
            goto L0
        L2a:
            java.lang.Object r4 = r0.c(r3)
            if (r4 == 0) goto L31
            return r4
        L31:
            r3.u()
            tb.kj2 r4 = tb.cg.RESUME_TOKEN
            return r4
        L37:
            boolean r1 = r0 instanceof tb.cn1
            if (r1 == 0) goto L6b
            if (r4 == 0) goto L65
            tb.v8 r1 = r4.a()
            boolean r2 = r1 instanceof kotlinx.coroutines.selects.SelectBuilderImpl.a
            if (r2 == 0) goto L59
            r2 = r1
            kotlinx.coroutines.selects.SelectBuilderImpl$a r2 = (kotlinx.coroutines.selects.SelectBuilderImpl.a) r2
            kotlinx.coroutines.selects.SelectBuilderImpl<?> r2 = r2.c
            if (r2 == r3) goto L4d
            goto L59
        L4d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Cannot use matching select clauses on the same object"
            java.lang.String r0 = r0.toString()
            r4.<init>(r0)
            throw r4
        L59:
            r2 = r0
            tb.cn1 r2 = (tb.cn1) r2
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L65
            java.lang.Object r4 = tb.u8.RETRY_ATOMIC
            return r4
        L65:
            tb.cn1 r0 = (tb.cn1) r0
            r0.c(r3)
            goto L0
        L6b:
            if (r4 != 0) goto L6e
            return r2
        L6e:
            tb.ma1$a r4 = r4.c
            if (r0 != r4) goto L75
            tb.kj2 r4 = tb.cg.RESUME_TOKEN
            return r4
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectBuilderImpl.trySelectOther(tb.ma1$d):java.lang.Object");
    }

    @PublishedApi
    @Nullable
    public final Object w() {
        Object obj;
        Object obj2;
        Object obj3;
        Object d2;
        Object d3;
        if (!isSelected()) {
            initCancellability();
        }
        Object obj4 = this._result;
        obj = ba2.c;
        if (obj4 == obj) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            obj3 = ba2.c;
            d2 = kotlin.coroutines.intrinsics.b.d();
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj3, d2)) {
                d3 = kotlin.coroutines.intrinsics.b.d();
                return d3;
            }
            obj4 = this._result;
        }
        obj2 = ba2.d;
        if (obj4 != obj2) {
            if (obj4 instanceof am) {
                throw ((am) obj4).a;
            }
            return obj4;
        }
        throw new IllegalStateException("Already resumed");
    }

    @PublishedApi
    public final void x(@NotNull Throwable th) {
        if (trySelect()) {
            Result.a aVar = Result.Companion;
            resumeWith(Result.m1271constructorimpl(i32.a(th)));
        } else if (th instanceof CancellationException) {
        } else {
            Object w = w();
            if (w instanceof am) {
                Throwable th2 = ((am) w).a;
                if (k40.d()) {
                    th2 = pf2.m(th2);
                }
                if (th2 == (!k40.d() ? th : pf2.m(th))) {
                    return;
                }
            }
            no.a(getContext(), th);
        }
    }

    @Override // kotlinx.coroutines.selects.SelectBuilder
    public void invoke(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        selectClause0.registerSelectClause0(this, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <Q> void invoke(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause1.registerSelectClause1(this, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.selects.SelectBuilder
    public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        selectClause2.registerSelectClause2(this, p, function2);
    }
}
