package kotlinx.coroutines.channels;

import com.taobao.weex.ui.component.AbstractEditComponent;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ba2;
import tb.cg;
import tb.dg;
import tb.eg;
import tb.gz1;
import tb.ha2;
import tb.i32;
import tb.id;
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
import tb.u8;
import tb.wt2;
import tb.yw2;
import tb.zb;
import tb.zj;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class AbstractChannel<E> extends kotlinx.coroutines.channels.a<E> implements Channel<E> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a<E> implements ChannelIterator<E> {
        @Nullable
        private Object a = k1.POLL_FAILED;
        @JvmField
        @NotNull
        public final AbstractChannel<E> b;

        public a(@NotNull AbstractChannel<E> abstractChannel) {
            this.b = abstractChannel;
        }

        private final boolean a(Object obj) {
            if (obj instanceof zj) {
                zj zjVar = (zj) obj;
                if (zjVar.d == null) {
                    return false;
                }
                throw pf2.k(zjVar.A());
            }
            return true;
        }

        @Nullable
        final /* synthetic */ Object b(@NotNull Continuation<? super Boolean> continuation) {
            Continuation c;
            Object d;
            c = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
            CancellableContinuationImpl b = dg.b(c);
            d dVar = new d(this, b);
            while (true) {
                if (this.b.F(dVar)) {
                    this.b.U(b, dVar);
                    break;
                }
                Object P = this.b.P();
                c(P);
                if (P instanceof zj) {
                    zj zjVar = (zj) P;
                    if (zjVar.d == null) {
                        Boolean a = id.a(false);
                        Result.a aVar = Result.Companion;
                        b.resumeWith(Result.m1271constructorimpl(a));
                    } else {
                        Throwable A = zjVar.A();
                        Result.a aVar2 = Result.Companion;
                        b.resumeWith(Result.m1271constructorimpl(i32.a(A)));
                    }
                } else if (P != k1.POLL_FAILED) {
                    Boolean a2 = id.a(true);
                    Function1<E, wt2> function1 = this.b.b;
                    b.resume(a2, function1 != null ? OnUndeliveredElementKt.a(function1, P, b.getContext()) : null);
                }
            }
            Object result = b.getResult();
            d = kotlin.coroutines.intrinsics.b.d();
            if (result == d) {
                n40.c(continuation);
            }
            return result;
        }

        public final void c(@Nullable Object obj) {
            this.a = obj;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Nullable
        public Object hasNext(@NotNull Continuation<? super Boolean> continuation) {
            Object obj = this.a;
            kj2 kj2Var = k1.POLL_FAILED;
            if (obj != kj2Var) {
                return id.a(a(obj));
            }
            Object P = this.b.P();
            this.a = P;
            if (P != kj2Var) {
                return id.a(a(P));
            }
            return b(continuation);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = AbstractEditComponent.ReturnTypes.NEXT)
        @Nullable
        public /* synthetic */ Object next(@NotNull Continuation<? super E> continuation) {
            return ChannelIterator.DefaultImpls.a(this, continuation);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e = (E) this.a;
            if (!(e instanceof zj)) {
                kj2 kj2Var = k1.POLL_FAILED;
                if (e != kj2Var) {
                    this.a = kj2Var;
                    return e;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw pf2.k(((zj) e).A());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class b<E> extends gz1<E> {
        @JvmField
        @NotNull
        public final CancellableContinuation<Object> d;
        @JvmField
        public final int e;

        public b(@NotNull CancellableContinuation<Object> cancellableContinuation, int i) {
            this.d = cancellableContinuation;
            this.e = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e) {
            this.d.completeResume(cg.RESUME_TOKEN);
        }

        @Override // tb.ma1
        @NotNull
        public String toString() {
            return "ReceiveElement@" + o40.b(this) + "[receiveMode=" + this.e + jn1.ARRAY_END;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public kj2 tryResumeReceive(E e, @Nullable ma1.d dVar) {
            Object tryResume = this.d.tryResume(w(e), dVar != null ? dVar.c : null, u(e));
            if (tryResume != null) {
                if (k40.a()) {
                    if (!(tryResume == cg.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                if (dVar != null) {
                    dVar.d();
                }
                return cg.RESUME_TOKEN;
            }
            return null;
        }

        @Override // tb.gz1
        public void v(@NotNull zj<?> zjVar) {
            int i = this.e;
            if (i == 1 && zjVar.d == null) {
                CancellableContinuation<Object> cancellableContinuation = this.d;
                Result.a aVar = Result.Companion;
                cancellableContinuation.resumeWith(Result.m1271constructorimpl(null));
            } else if (i == 2) {
                CancellableContinuation<Object> cancellableContinuation2 = this.d;
                yw2.b bVar = yw2.Companion;
                yw2 a = yw2.a(yw2.b(new yw2.a(zjVar.d)));
                Result.a aVar2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m1271constructorimpl(a));
            } else {
                CancellableContinuation<Object> cancellableContinuation3 = this.d;
                Throwable A = zjVar.A();
                Result.a aVar3 = Result.Companion;
                cancellableContinuation3.resumeWith(Result.m1271constructorimpl(i32.a(A)));
            }
        }

        @Nullable
        public final Object w(E e) {
            if (this.e != 2) {
                return e;
            }
            yw2.b bVar = yw2.Companion;
            return yw2.a(yw2.b(e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class c<E> extends b<E> {
        @JvmField
        @NotNull
        public final Function1<E, wt2> f;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@NotNull CancellableContinuation<Object> cancellableContinuation, int i, @NotNull Function1<? super E, wt2> function1) {
            super(cancellableContinuation, i);
            this.f = function1;
        }

        @Override // tb.gz1
        @Nullable
        public Function1<Throwable, wt2> u(E e) {
            return OnUndeliveredElementKt.a(this.f, e, this.d.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class d<E> extends gz1<E> {
        @JvmField
        @NotNull
        public final a<E> d;
        @JvmField
        @NotNull
        public final CancellableContinuation<Boolean> e;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull a<E> aVar, @NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.d = aVar;
            this.e = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e) {
            this.d.c(e);
            this.e.completeResume(cg.RESUME_TOKEN);
        }

        @Override // tb.ma1
        @NotNull
        public String toString() {
            return "ReceiveHasNext@" + o40.b(this);
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public kj2 tryResumeReceive(E e, @Nullable ma1.d dVar) {
            Object tryResume = this.e.tryResume(Boolean.TRUE, dVar != null ? dVar.c : null, u(e));
            if (tryResume != null) {
                if (k40.a()) {
                    if (!(tryResume == cg.RESUME_TOKEN)) {
                        throw new AssertionError();
                    }
                }
                if (dVar != null) {
                    dVar.d();
                }
                return cg.RESUME_TOKEN;
            }
            return null;
        }

        @Override // tb.gz1
        @Nullable
        public Function1<Throwable, wt2> u(E e) {
            Function1<E, wt2> function1 = this.d.b.b;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e, this.e.getContext());
            }
            return null;
        }

        @Override // tb.gz1
        public void v(@NotNull zj<?> zjVar) {
            Object tryResumeWithException;
            if (zjVar.d == null) {
                tryResumeWithException = CancellableContinuation.a.a(this.e, Boolean.FALSE, null, 2, null);
            } else {
                tryResumeWithException = this.e.tryResumeWithException(zjVar.A());
            }
            if (tryResumeWithException != null) {
                this.d.c(zjVar);
                this.e.completeResume(tryResumeWithException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class e<R, E> extends gz1<E> implements DisposableHandle {
        @JvmField
        @NotNull
        public final AbstractChannel<E> d;
        @JvmField
        @NotNull
        public final SelectInstance<R> e;
        @JvmField
        @NotNull
        public final Function2<Object, Continuation<? super R>, Object> f;
        @JvmField
        public final int g;

        /* JADX WARN: Multi-variable type inference failed */
        public e(@NotNull AbstractChannel<E> abstractChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
            this.d = abstractChannel;
            this.e = selectInstance;
            this.f = function2;
            this.g = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(E e) {
            Object obj;
            Function2<Object, Continuation<? super R>, Object> function2 = this.f;
            if (this.g == 2) {
                yw2.b bVar = yw2.Companion;
                obj = yw2.a(yw2.b(e));
            } else {
                obj = e;
            }
            eg.c(function2, obj, this.e.getCompletion(), u(e));
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (p()) {
                this.d.N();
            }
        }

        @Override // tb.ma1
        @NotNull
        public String toString() {
            return "ReceiveSelect@" + o40.b(this) + jn1.ARRAY_START + this.e + ",receiveMode=" + this.g + jn1.ARRAY_END;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        @Nullable
        public kj2 tryResumeReceive(E e, @Nullable ma1.d dVar) {
            return (kj2) this.e.trySelectOther(dVar);
        }

        @Override // tb.gz1
        @Nullable
        public Function1<Throwable, wt2> u(E e) {
            Function1<E, wt2> function1 = this.d.b;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e, this.e.getCompletion().getContext());
            }
            return null;
        }

        @Override // tb.gz1
        public void v(@NotNull zj<?> zjVar) {
            if (this.e.trySelect()) {
                int i = this.g;
                if (i == 0) {
                    this.e.resumeSelectWithException(zjVar.A());
                } else if (i == 1) {
                    if (zjVar.d == null) {
                        eg.d(this.f, null, this.e.getCompletion(), null, 4, null);
                    } else {
                        this.e.resumeSelectWithException(zjVar.A());
                    }
                } else if (i != 2) {
                } else {
                    Function2<Object, Continuation<? super R>, Object> function2 = this.f;
                    yw2.b bVar = yw2.Companion;
                    eg.d(function2, yw2.a(yw2.b(new yw2.a(zjVar.d))), this.e.getCompletion(), null, 4, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public final class f extends zb {
        private final gz1<?> a;

        public f(@NotNull gz1<?> gz1Var) {
            this.a = gz1Var;
        }

        @Override // tb.bg
        public void a(@Nullable Throwable th) {
            if (this.a.p()) {
                AbstractChannel.this.N();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
            a(th);
            return wt2.INSTANCE;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.a + jn1.ARRAY_END;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class g<E> extends ma1.e<ha2> {
        public g(@NotNull ka1 ka1Var) {
            super(ka1Var);
        }

        @Override // tb.ma1.e, tb.ma1.a
        @Nullable
        protected Object e(@NotNull ma1 ma1Var) {
            if (ma1Var instanceof zj) {
                return ma1Var;
            }
            if (ma1Var instanceof ha2) {
                return null;
            }
            return k1.POLL_FAILED;
        }

        @Override // tb.ma1.a
        @Nullable
        public Object j(@NotNull ma1.d dVar) {
            ma1 ma1Var = dVar.a;
            Objects.requireNonNull(ma1Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
            kj2 w = ((ha2) ma1Var).w(dVar);
            if (w != null) {
                Object obj = u8.RETRY_ATOMIC;
                if (w == obj) {
                    return obj;
                }
                if (k40.a()) {
                    if (w == cg.RESUME_TOKEN) {
                        return null;
                    }
                    throw new AssertionError();
                }
                return null;
            }
            return na1.REMOVE_PREPARED;
        }

        @Override // tb.ma1.a
        public void k(@NotNull ma1 ma1Var) {
            Objects.requireNonNull(ma1Var, "null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
            ((ha2) ma1Var).x();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class h extends ma1.c {
        final /* synthetic */ AbstractChannel d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(ma1 ma1Var, ma1 ma1Var2, AbstractChannel abstractChannel) {
            super(ma1Var2);
            this.d = abstractChannel;
        }

        @Override // tb.v8
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull ma1 ma1Var) {
            if (this.d.K()) {
                return null;
            }
            return la1.a();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class i implements SelectClause1<E> {
        i() {
        }

        @Override // kotlinx.coroutines.selects.SelectClause1
        public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            abstractChannel.T(selectInstance, 0, function2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class j implements SelectClause1<yw2<? extends E>> {
        j() {
        }

        @Override // kotlinx.coroutines.selects.SelectClause1
        public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super yw2<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            abstractChannel.T(selectInstance, 2, function2);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class k implements SelectClause1<E> {
        k() {
        }

        @Override // kotlinx.coroutines.selects.SelectClause1
        public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
            AbstractChannel abstractChannel = AbstractChannel.this;
            Objects.requireNonNull(function2, "null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            abstractChannel.T(selectInstance, 1, function2);
        }
    }

    public AbstractChannel(@Nullable Function1<? super E, wt2> function1) {
        super(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F(gz1<? super E> gz1Var) {
        boolean G = G(gz1Var);
        if (G) {
            O();
        }
        return G;
    }

    private final <R> boolean H(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i2) {
        e eVar = new e(this, selectInstance, function2, i2);
        boolean F = F(eVar);
        if (F) {
            selectInstance.disposeOnSelect(eVar);
        }
        return F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final E R(Object obj) {
        if (obj instanceof zj) {
            Throwable th = ((zj) obj).d;
            if (th == null) {
                return null;
            }
            throw pf2.k(th);
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void T(SelectInstance<? super R> selectInstance, int i2, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (L()) {
                if (H(selectInstance, function2, i2)) {
                    return;
                }
            } else {
                Object Q = Q(selectInstance);
                if (Q == ba2.d()) {
                    return;
                }
                if (Q != k1.POLL_FAILED && Q != u8.RETRY_ATOMIC) {
                    V(function2, selectInstance, i2, Q);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(CancellableContinuation<?> cancellableContinuation, gz1<?> gz1Var) {
        cancellableContinuation.invokeOnCancellation(new f(gz1Var));
    }

    private final <R> void V(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i2, Object obj) {
        Object b2;
        boolean z = obj instanceof zj;
        if (!z) {
            if (i2 == 2) {
                yw2.b bVar = yw2.Companion;
                if (z) {
                    b2 = yw2.b(new yw2.a(((zj) obj).d));
                } else {
                    b2 = yw2.b(obj);
                }
                st2.d(function2, yw2.a(b2), selectInstance.getCompletion());
                return;
            }
            st2.d(function2, obj, selectInstance.getCompletion());
        } else if (i2 == 0) {
            throw pf2.k(((zj) obj).A());
        } else {
            if (i2 != 1) {
                if (i2 == 2 && selectInstance.trySelect()) {
                    yw2.b bVar2 = yw2.Companion;
                    st2.d(function2, yw2.a(yw2.b(new yw2.a(((zj) obj).d))), selectInstance.getCompletion());
                    return;
                }
                return;
            }
            zj zjVar = (zj) obj;
            if (zjVar.d == null) {
                if (selectInstance.trySelect()) {
                    st2.d(function2, null, selectInstance.getCompletion());
                    return;
                }
                return;
            }
            throw pf2.k(zjVar.A());
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: D */
    public final boolean cancel(@Nullable Throwable th) {
        boolean close = close(th);
        M(close);
        return close;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final g<E> E() {
        return new g<>(j());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean G(@NotNull gz1<? super E> gz1Var) {
        int s;
        ma1 l;
        if (J()) {
            ma1 j2 = j();
            do {
                l = j2.l();
                if (!(!(l instanceof ha2))) {
                    return false;
                }
            } while (!l.e(gz1Var, j2));
        } else {
            ma1 j3 = j();
            h hVar = new h(gz1Var, gz1Var, this);
            do {
                ma1 l2 = j3.l();
                if (!(!(l2 instanceof ha2))) {
                    return false;
                }
                s = l2.s(gz1Var, j3, hVar);
                if (s != 1) {
                }
            } while (s != 2);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean I() {
        return j().k() instanceof ReceiveOrClosed;
    }

    protected abstract boolean J();

    protected abstract boolean K();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean L() {
        return !(j().k() instanceof ha2) && K();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(boolean z) {
        zj<?> i2 = i();
        if (i2 != null) {
            Object b2 = r21.b(null, 1, null);
            while (true) {
                ma1 l = i2.l();
                if (l instanceof ka1) {
                    if (b2 == null) {
                        return;
                    }
                    if (!(b2 instanceof ArrayList)) {
                        ((ha2) b2).v(i2);
                        return;
                    }
                    ArrayList arrayList = (ArrayList) b2;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ((ha2) arrayList.get(size)).v(i2);
                    }
                    return;
                } else if (k40.a() && !(l instanceof ha2)) {
                    throw new AssertionError();
                } else {
                    if (!l.p()) {
                        l.m();
                    } else {
                        b2 = r21.c(b2, (ha2) l);
                    }
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    protected void N() {
    }

    protected void O() {
    }

    @Nullable
    protected Object P() {
        while (true) {
            ha2 z = z();
            if (z != null) {
                kj2 w = z.w(null);
                if (w != null) {
                    if (k40.a()) {
                        if (!(w == cg.RESUME_TOKEN)) {
                            throw new AssertionError();
                        }
                    }
                    z.t();
                    return z.u();
                }
                z.x();
            } else {
                return k1.POLL_FAILED;
            }
        }
    }

    @Nullable
    protected Object Q(@NotNull SelectInstance<?> selectInstance) {
        g<E> E = E();
        Object performAtomicTrySelect = selectInstance.performAtomicTrySelect(E);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        E.o().t();
        return E.o().u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.AbstractChannel$b] */
    @Nullable
    final /* synthetic */ <R> Object S(int i2, @NotNull Continuation<? super R> continuation) {
        Continuation c2;
        c cVar;
        Object d2;
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl b2 = dg.b(c2);
        if (this.b == null) {
            Objects.requireNonNull(b2, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
            cVar = new b(b2, i2);
        } else {
            Objects.requireNonNull(b2, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Any?>");
            cVar = new c(b2, i2, this.b);
        }
        while (true) {
            if (F(cVar)) {
                U(b2, cVar);
                break;
            }
            Object P = P();
            if (P instanceof zj) {
                cVar.v((zj) P);
                break;
            } else if (P != k1.POLL_FAILED) {
                b2.resume(cVar.w(P), cVar.u(P));
                break;
            }
        }
        Object result = b2.getResult();
        d2 = kotlin.coroutines.intrinsics.b.d();
        if (result == d2) {
            n40.c(continuation);
        }
        return result;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<E> getOnReceive() {
        return new i();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<yw2<E>> getOnReceiveOrClosed() {
        return new j();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final SelectClause1<E> getOnReceiveOrNull() {
        return new k();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return h() != null && K();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public boolean isEmpty() {
        return L();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @NotNull
    public final ChannelIterator<E> iterator() {
        return new a(this);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public final E poll() {
        Object P = P();
        if (P == k1.POLL_FAILED) {
            return null;
        }
        return R(P);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public final Object receive(@NotNull Continuation<? super E> continuation) {
        Object P = P();
        return (P == k1.POLL_FAILED || (P instanceof zj)) ? S(0, continuation) : P;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @org.jetbrains.annotations.Nullable
    /* renamed from: receiveOrClosed-ZYPwvRU  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo1285receiveOrClosedZYPwvRU(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super tb.yw2<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveOrClosed$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.channels.AbstractChannel r0 = (kotlinx.coroutines.channels.AbstractChannel) r0
            tb.i32.b(r5)
            goto L69
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            tb.i32.b(r5)
            java.lang.Object r5 = r4.P()
            tb.kj2 r2 = tb.k1.POLL_FAILED
            if (r5 == r2) goto L5b
            boolean r0 = r5 instanceof tb.zj
            if (r0 == 0) goto L54
            tb.yw2$b r0 = tb.yw2.Companion
            tb.zj r5 = (tb.zj) r5
            java.lang.Throwable r5 = r5.d
            tb.yw2$a r0 = new tb.yw2$a
            r0.<init>(r5)
            java.lang.Object r5 = tb.yw2.b(r0)
            goto L5a
        L54:
            tb.yw2$b r0 = tb.yw2.Companion
            java.lang.Object r5 = tb.yw2.b(r5)
        L5a:
            return r5
        L5b:
            r2 = 2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r5 = r4.S(r2, r0)
            if (r5 != r1) goto L69
            return r1
        L69:
            tb.yw2 r5 = (tb.yw2) r5
            java.lang.Object r5 = r5.i()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.mo1285receiveOrClosedZYPwvRU(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Nullable
    public final Object receiveOrNull(@NotNull Continuation<? super E> continuation) {
        Object P = P();
        return (P == k1.POLL_FAILED || (P instanceof zj)) ? S(1, continuation) : P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    @Nullable
    public ReceiveOrClosed<E> y() {
        ReceiveOrClosed<E> y = super.y();
        if (y != null && !(y instanceof zj)) {
            N();
        }
        return y;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(o40.a(this) + " was cancelled");
        }
        cancel(cancellationException);
    }
}
