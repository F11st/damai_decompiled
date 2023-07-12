package kotlinx.coroutines.channels;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.ba2;
import tb.cg;
import tb.dg;
import tb.eg;
import tb.gz1;
import tb.ha2;
import tb.hg0;
import tb.i32;
import tb.ia2;
import tb.ja2;
import tb.jn1;
import tb.k1;
import tb.k40;
import tb.ka1;
import tb.kj2;
import tb.la1;
import tb.ma1;
import tb.n40;
import tb.na1;
import tb.o40;
import tb.pf2;
import tb.r21;
import tb.st2;
import tb.tq2;
import tb.u8;
import tb.wt2;
import tb.zj;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class a<E> implements SendChannel<E> {
    private static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "onCloseHandler");
    @JvmField
    @Nullable
    protected final Function1<E, wt2> b;
    @NotNull
    private final ka1 a = new ka1();
    private volatile Object onCloseHandler = null;

    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C0432a<E> extends ha2 {
        @JvmField
        public final E d;

        public C0432a(E e) {
            this.d = e;
        }

        @Override // tb.ha2
        public void t() {
        }

        @Override // tb.ma1
        @NotNull
        public String toString() {
            return "SendBuffered@" + o40.b(this) + '(' + this.d + ')';
        }

        @Override // tb.ha2
        @Nullable
        public Object u() {
            return this.d;
        }

        @Override // tb.ha2
        public void v(@NotNull zj<?> zjVar) {
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
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    private static class b<E> extends ma1.b<C0432a<? extends E>> {
        public b(@NotNull ka1 ka1Var, E e) {
            super(ka1Var, new C0432a(e));
        }

        @Override // tb.ma1.a
        @Nullable
        protected Object e(@NotNull ma1 ma1Var) {
            if (ma1Var instanceof zj) {
                return ma1Var;
            }
            if (ma1Var instanceof ReceiveOrClosed) {
                return k1.OFFER_FAILED;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class c<E, R> extends ha2 implements DisposableHandle {
        private final E d;
        @JvmField
        @NotNull
        public final a<E> e;
        @JvmField
        @NotNull
        public final SelectInstance<R> f;
        @JvmField
        @NotNull
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> g;

        /* JADX WARN: Multi-variable type inference failed */
        public c(E e, @NotNull a<E> aVar, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.d = e;
            this.e = aVar;
            this.f = selectInstance;
            this.g = function2;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (p()) {
                x();
            }
        }

        @Override // tb.ha2
        public void t() {
            eg.d(this.g, this.e, this.f.getCompletion(), null, 4, null);
        }

        @Override // tb.ma1
        @NotNull
        public String toString() {
            return "SendSelect@" + o40.b(this) + '(' + u() + ")[" + this.e + AVFSCacheConstants.COMMA_SEP + this.f + jn1.ARRAY_END;
        }

        @Override // tb.ha2
        public E u() {
            return this.d;
        }

        @Override // tb.ha2
        public void v(@NotNull zj<?> zjVar) {
            if (this.f.trySelect()) {
                this.f.resumeSelectWithException(zjVar.B());
            }
        }

        @Override // tb.ha2
        @Nullable
        public kj2 w(@Nullable ma1.d dVar) {
            return (kj2) this.f.trySelectOther(dVar);
        }

        @Override // tb.ha2
        public void x() {
            Function1<E, wt2> function1 = this.e.b;
            if (function1 != null) {
                OnUndeliveredElementKt.b(function1, u(), this.f.getCompletion().getContext());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class d<E> extends ma1.e<ReceiveOrClosed<? super E>> {
        @JvmField
        public final E e;

        public d(E e, @NotNull ka1 ka1Var) {
            super(ka1Var);
            this.e = e;
        }

        @Override // tb.ma1.e, tb.ma1.a
        @Nullable
        protected Object e(@NotNull ma1 ma1Var) {
            if (ma1Var instanceof zj) {
                return ma1Var;
            }
            if (ma1Var instanceof ReceiveOrClosed) {
                return null;
            }
            return k1.OFFER_FAILED;
        }

        @Override // tb.ma1.a
        @Nullable
        public Object j(@NotNull ma1.d dVar) {
            ma1 ma1Var = dVar.a;
            Objects.requireNonNull(ma1Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveOrClosed<E>");
            kj2 tryResumeReceive = ((ReceiveOrClosed) ma1Var).tryResumeReceive(this.e, dVar);
            if (tryResumeReceive != null) {
                Object obj = u8.RETRY_ATOMIC;
                if (tryResumeReceive == obj) {
                    return obj;
                }
                if (k40.a()) {
                    if (tryResumeReceive == cg.RESUME_TOKEN) {
                        return null;
                    }
                    throw new AssertionError();
                }
                return null;
            }
            return na1.REMOVE_PREPARED;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class e extends ma1.c {
        final /* synthetic */ a d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ma1 ma1Var, ma1 ma1Var2, a aVar) {
            super(ma1Var2);
            this.d = aVar;
        }

        @Override // tb.v8
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull ma1 ma1Var) {
            if (this.d.q()) {
                return null;
            }
            return la1.a();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class f implements SelectClause2<E, SendChannel<? super E>> {
        f() {
        }

        @Override // kotlinx.coroutines.selects.SelectClause2
        public <R> void registerSelectClause2(@NotNull SelectInstance<? super R> selectInstance, E e, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            a.this.v(selectInstance, e, function2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@Nullable Function1<? super E, wt2> function1) {
        this.b = function1;
    }

    private final int c() {
        ka1 ka1Var = this.a;
        Object j = ka1Var.j();
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        int i = 0;
        for (ma1 ma1Var = (ma1) j; !b41.d(ma1Var, ka1Var); ma1Var = ma1Var.k()) {
            if (ma1Var instanceof ma1) {
                i++;
            }
        }
        return i;
    }

    private final String k() {
        String str;
        ma1 k = this.a.k();
        if (k == this.a) {
            return "EmptyQueue";
        }
        if (k instanceof zj) {
            str = k.toString();
        } else if (k instanceof gz1) {
            str = "ReceiveQueued";
        } else if (k instanceof ha2) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + k;
        }
        ma1 l = this.a.l();
        if (l != k) {
            String str2 = str + ",queueSize=" + c();
            if (l instanceof zj) {
                return str2 + ",closedForSend=" + l;
            }
            return str2;
        }
        return str;
    }

    private final void l(zj<?> zjVar) {
        Object b2 = r21.b(null, 1, null);
        while (true) {
            ma1 l = zjVar.l();
            if (!(l instanceof gz1)) {
                l = null;
            }
            gz1 gz1Var = (gz1) l;
            if (gz1Var == null) {
                break;
            } else if (!gz1Var.p()) {
                gz1Var.m();
            } else {
                b2 = r21.c(b2, gz1Var);
            }
        }
        if (b2 != null) {
            if (!(b2 instanceof ArrayList)) {
                ((gz1) b2).v(zjVar);
            } else {
                ArrayList arrayList = (ArrayList) b2;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((gz1) arrayList.get(size)).v(zjVar);
                }
            }
        }
        u(zjVar);
    }

    private final Throwable m(E e2, zj<?> zjVar) {
        UndeliveredElementException d2;
        l(zjVar);
        Function1<E, wt2> function1 = this.b;
        if (function1 != null && (d2 = OnUndeliveredElementKt.d(function1, e2, null, 2, null)) != null) {
            hg0.a(d2, zjVar.B());
            throw d2;
        }
        return zjVar.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Continuation<?> continuation, E e2, zj<?> zjVar) {
        UndeliveredElementException d2;
        l(zjVar);
        Throwable B = zjVar.B();
        Function1<E, wt2> function1 = this.b;
        if (function1 != null && (d2 = OnUndeliveredElementKt.d(function1, e2, null, 2, null)) != null) {
            hg0.a(d2, B);
            Result.a aVar = Result.Companion;
            continuation.resumeWith(Result.m1271constructorimpl(i32.a(d2)));
            return;
        }
        Result.a aVar2 = Result.Companion;
        continuation.resumeWith(Result.m1271constructorimpl(i32.a(B)));
    }

    private final void o(Throwable th) {
        kj2 kj2Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (kj2Var = k1.HANDLER_INVOKED) || !c.compareAndSet(this, obj, kj2Var)) {
            return;
        }
        ((Function1) tq2.e(obj, 1)).invoke(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void v(SelectInstance<? super R> selectInstance, E e2, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (r()) {
                c cVar = new c(e2, this, selectInstance, function2);
                Object f2 = f(cVar);
                if (f2 == null) {
                    selectInstance.disposeOnSelect(cVar);
                    return;
                } else if (!(f2 instanceof zj)) {
                    if (f2 != k1.ENQUEUE_FAILED && !(f2 instanceof gz1)) {
                        throw new IllegalStateException(("enqueueSend returned " + f2 + ' ').toString());
                    }
                } else {
                    throw pf2.k(m(e2, (zj) f2));
                }
            }
            Object t = t(e2, selectInstance);
            if (t == ba2.d()) {
                return;
            }
            if (t != k1.OFFER_FAILED && t != u8.RETRY_ATOMIC) {
                if (t == k1.OFFER_SUCCESS) {
                    st2.d(function2, this, selectInstance.getCompletion());
                    return;
                } else if (t instanceof zj) {
                    throw pf2.k(m(e2, (zj) t));
                } else {
                    throw new IllegalStateException(("offerSelectInternal returned " + t).toString());
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(@Nullable Throwable th) {
        boolean z;
        zj<?> zjVar = new zj<>(th);
        ma1 ma1Var = this.a;
        while (true) {
            ma1 l = ma1Var.l();
            z = true;
            if (!(!(l instanceof zj))) {
                z = false;
                break;
            } else if (l.e(zjVar, ma1Var)) {
                break;
            }
        }
        if (!z) {
            ma1 l2 = this.a.l();
            Objects.requireNonNull(l2, "null cannot be cast to non-null type kotlinx.coroutines.channels.Closed<*>");
            zjVar = (zj) l2;
        }
        l(zjVar);
        if (z) {
            o(th);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ma1.b<?> d(E e2) {
        return new b(this.a, e2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final d<E> e(E e2) {
        return new d<>(e2, this.a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Object f(@NotNull ha2 ha2Var) {
        boolean z;
        ma1 l;
        if (p()) {
            ma1 ma1Var = this.a;
            do {
                l = ma1Var.l();
                if (l instanceof ReceiveOrClosed) {
                    return l;
                }
            } while (!l.e(ha2Var, ma1Var));
            return null;
        }
        ma1 ma1Var2 = this.a;
        e eVar = new e(ha2Var, ha2Var, this);
        while (true) {
            ma1 l2 = ma1Var2.l();
            if (!(l2 instanceof ReceiveOrClosed)) {
                int s = l2.s(ha2Var, ma1Var2, eVar);
                z = true;
                if (s != 1) {
                    if (s == 2) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return l2;
            }
        }
        if (z) {
            return null;
        }
        return k1.ENQUEUE_FAILED;
    }

    @NotNull
    protected String g() {
        return "";
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @NotNull
    public final SelectClause2<E, SendChannel<E>> getOnSend() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final zj<?> h() {
        ma1 k = this.a.k();
        if (!(k instanceof zj)) {
            k = null;
        }
        zj<?> zjVar = (zj) k;
        if (zjVar != null) {
            l(zjVar);
            return zjVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final zj<?> i() {
        ma1 l = this.a.l();
        if (!(l instanceof zj)) {
            l = null;
        }
        zj<?> zjVar = (zj) l;
        if (zjVar != null) {
            l(zjVar);
            return zjVar;
        }
        return null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(@NotNull Function1<? super Throwable, wt2> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (!atomicReferenceFieldUpdater.compareAndSet(this, null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == k1.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        zj<?> i = i();
        if (i == null || !atomicReferenceFieldUpdater.compareAndSet(this, function1, k1.HANDLER_INVOKED)) {
            return;
        }
        function1.invoke(i.d);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean isClosedForSend() {
        return i() != null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ka1 j() {
        return this.a;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public final boolean offer(E e2) {
        Object s = s(e2);
        if (s == k1.OFFER_SUCCESS) {
            return true;
        }
        if (s == k1.OFFER_FAILED) {
            zj<?> i = i();
            if (i == null) {
                return false;
            }
            throw pf2.k(m(e2, i));
        } else if (s instanceof zj) {
            throw pf2.k(m(e2, (zj) s));
        } else {
            throw new IllegalStateException(("offerInternal returned " + s).toString());
        }
    }

    protected abstract boolean p();

    protected abstract boolean q();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean r() {
        return !(this.a.k() instanceof ReceiveOrClosed) && q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Object s(E e2) {
        ReceiveOrClosed<E> y;
        kj2 tryResumeReceive;
        do {
            y = y();
            if (y != null) {
                tryResumeReceive = y.tryResumeReceive(e2, null);
            } else {
                return k1.OFFER_FAILED;
            }
        } while (tryResumeReceive == null);
        if (k40.a()) {
            if (!(tryResumeReceive == cg.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        y.completeResumeReceive(e2);
        return y.getOfferResult();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Nullable
    public final Object send(E e2, @NotNull Continuation<? super wt2> continuation) {
        Object d2;
        if (s(e2) == k1.OFFER_SUCCESS) {
            return wt2.INSTANCE;
        }
        Object x = x(e2, continuation);
        d2 = kotlin.coroutines.intrinsics.b.d();
        return x == d2 ? x : wt2.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public Object t(E e2, @NotNull SelectInstance<?> selectInstance) {
        d<E> e3 = e(e2);
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(e3);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        ReceiveOrClosed<? super E> o = e3.o();
        o.completeResumeReceive(e2);
        return o.getOfferResult();
    }

    @NotNull
    public String toString() {
        return o40.a(this) + '@' + o40.b(this) + '{' + k() + '}' + g();
    }

    protected void u(@NotNull ma1 ma1Var) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ReceiveOrClosed<?> w(E e2) {
        ma1 l;
        ma1 ma1Var = this.a;
        C0432a c0432a = new C0432a(e2);
        do {
            l = ma1Var.l();
            if (l instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) l;
            }
        } while (!l.e(c0432a, ma1Var));
        return null;
    }

    @Nullable
    final /* synthetic */ Object x(E e2, @NotNull Continuation<? super wt2> continuation) {
        Continuation c2;
        Object d2;
        ha2 ja2Var;
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl b2 = dg.b(c2);
        while (true) {
            if (r()) {
                if (this.b == null) {
                    ja2Var = new ia2(e2, b2);
                } else {
                    ja2Var = new ja2(e2, b2, this.b);
                }
                Object f2 = f(ja2Var);
                if (f2 == null) {
                    dg.c(b2, ja2Var);
                    break;
                } else if (f2 instanceof zj) {
                    n(b2, e2, (zj) f2);
                    break;
                } else if (f2 != k1.ENQUEUE_FAILED && !(f2 instanceof gz1)) {
                    throw new IllegalStateException(("enqueueSend returned " + f2).toString());
                }
            }
            Object s = s(e2);
            if (s == k1.OFFER_SUCCESS) {
                wt2 wt2Var = wt2.INSTANCE;
                Result.a aVar = Result.Companion;
                b2.resumeWith(Result.m1271constructorimpl(wt2Var));
                break;
            } else if (s != k1.OFFER_FAILED) {
                if (s instanceof zj) {
                    n(b2, e2, (zj) s);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + s).toString());
                }
            }
        }
        Object result = b2.getResult();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (result == d2) {
            n40.c(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public ReceiveOrClosed<E> y() {
        ma1 ma1Var;
        ma1 q;
        ka1 ka1Var = this.a;
        while (true) {
            Object j = ka1Var.j();
            Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            ma1Var = (ma1) j;
            if (ma1Var != ka1Var && (ma1Var instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) ma1Var) instanceof zj) && !ma1Var.o()) || (q = ma1Var.q()) == null) {
                    break;
                }
                q.n();
            }
        }
        ma1Var = null;
        return (ReceiveOrClosed) ma1Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ha2 z() {
        ma1 ma1Var;
        ma1 q;
        ka1 ka1Var = this.a;
        while (true) {
            Object j = ka1Var.j();
            Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            ma1Var = (ma1) j;
            if (ma1Var != ka1Var && (ma1Var instanceof ha2)) {
                if (((((ha2) ma1Var) instanceof zj) && !ma1Var.o()) || (q = ma1Var.q()) == null) {
                    break;
                }
                q.n();
            }
        }
        ma1Var = null;
        return (ha2) ma1Var;
    }
}
