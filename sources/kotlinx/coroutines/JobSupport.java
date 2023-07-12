package kotlinx.coroutines;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.am;
import tb.b41;
import tb.b61;
import tb.cn1;
import tb.dg;
import tb.eg;
import tb.f21;
import tb.f61;
import tb.hg0;
import tb.jn1;
import tb.k40;
import tb.kj2;
import tb.la1;
import tb.ma1;
import tb.mi;
import tb.n23;
import tb.n40;
import tb.o40;
import tb.pf2;
import tb.st2;
import tb.wt2;
import tb.xk1;
import tb.zk1;

/* compiled from: Taobao */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
/* loaded from: classes8.dex */
public class JobSupport implements ChildJob, Job, ParentJob, SelectClause0 {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/Job;", "parent", "", "getContinuationCancellationCause", "", "nameString", "Lkotlinx/coroutines/JobSupport;", "job", "Lkotlinx/coroutines/JobSupport;", "Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes8.dex */
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        public AwaitContinuation(@NotNull Continuation<? super T> continuation, @NotNull JobSupport jobSupport) {
            super(continuation, 1);
            this.job = jobSupport;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        public Throwable getContinuationCancellationCause(@NotNull Job job) {
            Throwable d;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof b) || (d = ((b) state$kotlinx_coroutines_core).d()) == null) ? state$kotlinx_coroutines_core instanceof am ? ((am) state$kotlinx_coroutines_core).a : job.getCancellationException() : d;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        @NotNull
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a extends f61<Job> {
        private final JobSupport e;
        private final b f;
        private final mi g;
        private final Object h;

        public a(@NotNull JobSupport jobSupport, @NotNull b bVar, @NotNull mi miVar, @Nullable Object obj) {
            super(miVar.e);
            this.e = jobSupport;
            this.f = bVar;
            this.g = miVar;
            this.h = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ wt2 invoke(Throwable th) {
            t(th);
            return wt2.INSTANCE;
        }

        @Override // tb.cm
        public void t(@Nullable Throwable th) {
            this.e.continueCompleting(this.f, this.g, this.h);
        }

        @Override // tb.ma1
        @NotNull
        public String toString() {
            return "ChildCompletion[" + this.g + AVFSCacheConstants.COMMA_SEP + this.h + jn1.ARRAY_END;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class b implements Incomplete {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        @NotNull
        private final xk1 a;

        public b(@NotNull xk1 xk1Var, boolean z, @Nullable Throwable th) {
            this.a = xk1Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> b() {
            return new ArrayList<>(4);
        }

        private final Object c() {
            return this._exceptionsHolder;
        }

        private final void j(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(@NotNull Throwable th) {
            Throwable d = d();
            if (d == null) {
                k(th);
            } else if (th == d) {
            } else {
                Object c = c();
                if (c == null) {
                    j(th);
                } else if (!(c instanceof Throwable)) {
                    if (c instanceof ArrayList) {
                        ((ArrayList) c).add(th);
                        return;
                    }
                    throw new IllegalStateException(("State is " + c).toString());
                } else if (th == c) {
                } else {
                    ArrayList<Throwable> b = b();
                    b.add(c);
                    b.add(th);
                    wt2 wt2Var = wt2.INSTANCE;
                    j(b);
                }
            }
        }

        @Nullable
        public final Throwable d() {
            return (Throwable) this._rootCause;
        }

        public final boolean e() {
            return d() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean f() {
            return this._isCompleting;
        }

        public final boolean g() {
            kj2 kj2Var;
            Object c = c();
            kj2Var = s.d;
            return c == kj2Var;
        }

        @Override // kotlinx.coroutines.Incomplete
        @NotNull
        public xk1 getList() {
            return this.a;
        }

        @NotNull
        public final List<Throwable> h(@Nullable Throwable th) {
            ArrayList<Throwable> arrayList;
            kj2 kj2Var;
            Object c = c();
            if (c == null) {
                arrayList = b();
            } else if (c instanceof Throwable) {
                ArrayList<Throwable> b = b();
                b.add(c);
                arrayList = b;
            } else if (!(c instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + c).toString());
            } else {
                arrayList = (ArrayList) c;
            }
            Throwable d = d();
            if (d != null) {
                arrayList.add(0, d);
            }
            if (th != null && (!b41.d(th, d))) {
                arrayList.add(th);
            }
            kj2Var = s.d;
            j(kj2Var);
            return arrayList;
        }

        public final void i(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            return d() == null;
        }

        public final void k(@Nullable Throwable th) {
            this._rootCause = th;
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + e() + ", completing=" + f() + ", rootCause=" + d() + ", exceptions=" + c() + ", list=" + getList() + jn1.ARRAY_END;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class c extends ma1.c {
        final /* synthetic */ JobSupport d;
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ma1 ma1Var, ma1 ma1Var2, JobSupport jobSupport, Object obj) {
            super(ma1Var2);
            this.d = jobSupport;
            this.e = obj;
        }

        @Override // tb.v8
        @Nullable
        /* renamed from: k */
        public Object i(@NotNull ma1 ma1Var) {
            if (this.d.getState$kotlinx_coroutines_core() == this.e) {
                return null;
            }
            return la1.a();
        }
    }

    public JobSupport(boolean z) {
        this._state = z ? s.f : s.e;
        this._parentHandle = null;
    }

    private final boolean addLastAtomic(Object obj, xk1 xk1Var, f61<?> f61Var) {
        int s;
        c cVar = new c(f61Var, f61Var, this, obj);
        do {
            s = xk1Var.l().s(f61Var, xk1Var, cVar);
            if (s == 1) {
                return true;
            }
        } while (s != 2);
        return false;
    }

    private final void addSuppressedExceptions(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Throwable m = !k40.d() ? th : pf2.m(th);
        for (Throwable th2 : list) {
            if (k40.d()) {
                th2 = pf2.m(th2);
            }
            if (th2 != th && th2 != m && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                hg0.a(th, th2);
            }
        }
    }

    private final Object cancelMakeCompleting(Object obj) {
        kj2 kj2Var;
        Object tryMakeCompleting;
        kj2 kj2Var2;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).f())) {
                kj2Var = s.a;
                return kj2Var;
            }
            tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new am(createCauseException(obj), false, 2, null));
            kj2Var2 = s.b;
        } while (tryMakeCompleting == kj2Var2);
        return tryMakeCompleting;
    }

    private final boolean cancelParent(Throwable th) {
        if (isScopedCoroutine()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        return (parentHandle$kotlinx_coroutines_core == null || parentHandle$kotlinx_coroutines_core == zk1.INSTANCE) ? z : parentHandle$kotlinx_coroutines_core.childCancelled(th) || z;
    }

    private final void completeStateFinalization(Incomplete incomplete, Object obj) {
        ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core(zk1.INSTANCE);
        }
        if (!(obj instanceof am)) {
            obj = null;
        }
        am amVar = (am) obj;
        Throwable th = amVar != null ? amVar.a : null;
        if (incomplete instanceof f61) {
            try {
                ((f61) incomplete).t(th);
                return;
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
                return;
            }
        }
        xk1 list = incomplete.getList();
        if (list != null) {
            notifyCompletion(list, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueCompleting(b bVar, mi miVar, Object obj) {
        if (k40.a()) {
            if (!(getState$kotlinx_coroutines_core() == bVar)) {
                throw new AssertionError();
            }
        }
        mi nextChild = nextChild(miVar);
        if (nextChild == null || !tryWaitForChild(bVar, nextChild, obj)) {
            afterCompletion(finalizeFinishingState(bVar, obj));
        }
    }

    private final Throwable createCauseException(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            return obj != null ? (Throwable) obj : new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).getChildJobCancellationCause();
    }

    public static /* synthetic */ JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(JobSupport jobSupport, String str, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                th = null;
            }
            if (str == null) {
                str = jobSupport.cancellationExceptionMessage();
            }
            return new JobCancellationException(str, th, jobSupport);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
    }

    private final Object finalizeFinishingState(b bVar, Object obj) {
        boolean e;
        Throwable finalRootCause;
        boolean z = true;
        if (k40.a()) {
            if (!(getState$kotlinx_coroutines_core() == bVar)) {
                throw new AssertionError();
            }
        }
        if (!k40.a() || (!bVar.g())) {
            if (!k40.a() || bVar.f()) {
                am amVar = (am) (!(obj instanceof am) ? null : obj);
                Throwable th = amVar != null ? amVar.a : null;
                synchronized (bVar) {
                    e = bVar.e();
                    List<Throwable> h = bVar.h(th);
                    finalRootCause = getFinalRootCause(bVar, h);
                    if (finalRootCause != null) {
                        addSuppressedExceptions(finalRootCause, h);
                    }
                }
                if (finalRootCause != null && finalRootCause != th) {
                    obj = new am(finalRootCause, false, 2, null);
                }
                if (finalRootCause != null) {
                    if (!cancelParent(finalRootCause) && !handleJobException(finalRootCause)) {
                        z = false;
                    }
                    if (z) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                        ((am) obj).b();
                    }
                }
                if (!e) {
                    onCancelling(finalRootCause);
                }
                onCompletionInternal(obj);
                boolean compareAndSet = _state$FU.compareAndSet(this, bVar, s.g(obj));
                if (!k40.a() || compareAndSet) {
                    completeStateFinalization(bVar, obj);
                    return obj;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final mi firstChild(Incomplete incomplete) {
        mi miVar = (mi) (!(incomplete instanceof mi) ? null : incomplete);
        if (miVar != null) {
            return miVar;
        }
        xk1 list = incomplete.getList();
        if (list != null) {
            return nextChild(list);
        }
        return null;
    }

    private final Throwable getExceptionOrNull(Object obj) {
        if (!(obj instanceof am)) {
            obj = null;
        }
        am amVar = (am) obj;
        if (amVar != null) {
            return amVar.a;
        }
        return null;
    }

    private final Throwable getFinalRootCause(b bVar, List<? extends Throwable> list) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (list.isEmpty()) {
            if (bVar.e()) {
                return new JobCancellationException(cancellationExceptionMessage(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!(((Throwable) obj) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) obj;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                Throwable th3 = (Throwable) next;
                if (th3 == th2 || !(th3 instanceof TimeoutCancellationException)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj2 = next;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj2;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final xk1 getOrPromoteCancellingList(Incomplete incomplete) {
        xk1 list = incomplete.getList();
        if (list != null) {
            return list;
        }
        if (incomplete instanceof l) {
            return new xk1();
        }
        if (incomplete instanceof f61) {
            promoteSingleToNodeList((f61) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    private final boolean isCancelling(Incomplete incomplete) {
        return (incomplete instanceof b) && ((b) incomplete).e();
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    private final Void loopOnState(Function1<Object, wt2> function1) {
        while (true) {
            function1.invoke(getState$kotlinx_coroutines_core());
        }
    }

    private final Object makeCancelling(Object obj) {
        kj2 kj2Var;
        kj2 kj2Var2;
        kj2 kj2Var3;
        kj2 kj2Var4;
        kj2 kj2Var5;
        kj2 kj2Var6;
        Throwable th = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof b) {
                synchronized (state$kotlinx_coroutines_core) {
                    if (((b) state$kotlinx_coroutines_core).g()) {
                        kj2Var2 = s.c;
                        return kj2Var2;
                    }
                    boolean e = ((b) state$kotlinx_coroutines_core).e();
                    if (obj != null || !e) {
                        if (th == null) {
                            th = createCauseException(obj);
                        }
                        ((b) state$kotlinx_coroutines_core).a(th);
                    }
                    Throwable d = e ^ true ? ((b) state$kotlinx_coroutines_core).d() : null;
                    if (d != null) {
                        notifyCancelling(((b) state$kotlinx_coroutines_core).getList(), d);
                    }
                    kj2Var = s.a;
                    return kj2Var;
                }
            } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                kj2Var3 = s.c;
                return kj2Var3;
            } else {
                if (th == null) {
                    th = createCauseException(obj);
                }
                Incomplete incomplete = (Incomplete) state$kotlinx_coroutines_core;
                if (incomplete.isActive()) {
                    if (tryMakeCancelling(incomplete, th)) {
                        kj2Var4 = s.a;
                        return kj2Var4;
                    }
                } else {
                    Object tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new am(th, false, 2, null));
                    kj2Var5 = s.a;
                    if (tryMakeCompleting != kj2Var5) {
                        kj2Var6 = s.b;
                        if (tryMakeCompleting != kj2Var6) {
                            return tryMakeCompleting;
                        }
                    } else {
                        throw new IllegalStateException(("Cannot happen in " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
    }

    private final f61<?> makeNode(Function1<? super Throwable, wt2> function1, boolean z) {
        if (z) {
            b61 b61Var = function1 instanceof b61 ? function1 : null;
            if (b61Var != null) {
                if (k40.a()) {
                    if (b61Var.d == this) {
                        return b61Var;
                    }
                    throw new AssertionError();
                }
                return b61Var;
            }
            return new q(this, function1);
        }
        f61<?> f61Var = function1 instanceof f61 ? function1 : null;
        if (f61Var != null) {
            if (k40.a()) {
                if ((f61Var.d != this || (f61Var instanceof b61)) ? false : false) {
                    return f61Var;
                }
                throw new AssertionError();
            }
            return f61Var;
        }
        return new r(this, function1);
    }

    private final mi nextChild(ma1 ma1Var) {
        while (ma1Var.o()) {
            ma1Var = ma1Var.l();
        }
        while (true) {
            ma1Var = ma1Var.k();
            if (!ma1Var.o()) {
                if (ma1Var instanceof mi) {
                    return (mi) ma1Var;
                }
                if (ma1Var instanceof xk1) {
                    return null;
                }
            }
        }
    }

    private final void notifyCancelling(xk1 xk1Var, Throwable th) {
        onCancelling(th);
        Object j = xk1Var.j();
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (ma1 ma1Var = (ma1) j; !b41.d(ma1Var, xk1Var); ma1Var = ma1Var.k()) {
            if (ma1Var instanceof b61) {
                f61 f61Var = (f61) ma1Var;
                try {
                    f61Var.t(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        hg0.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + f61Var + " for " + this, th2);
                        wt2 wt2Var = wt2.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
        cancelParent(th);
    }

    private final void notifyCompletion(xk1 xk1Var, Throwable th) {
        Object j = xk1Var.j();
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (ma1 ma1Var = (ma1) j; !b41.d(ma1Var, xk1Var); ma1Var = ma1Var.k()) {
            if (ma1Var instanceof f61) {
                f61 f61Var = (f61) ma1Var;
                try {
                    f61Var.t(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        hg0.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + f61Var + " for " + this, th2);
                        wt2 wt2Var = wt2.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    private final /* synthetic */ <T extends f61<?>> void notifyHandlers(xk1 xk1Var, Throwable th) {
        Object j = xk1Var.j();
        Objects.requireNonNull(j, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        CompletionHandlerException completionHandlerException = null;
        for (ma1 ma1Var = (ma1) j; !b41.d(ma1Var, xk1Var); ma1Var = ma1Var.k()) {
            b41.o(3, "T");
            if (ma1Var instanceof ma1) {
                f61 f61Var = (f61) ma1Var;
                try {
                    f61Var.t(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        hg0.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + f61Var + " for " + this, th2);
                        wt2 wt2Var = wt2.INSTANCE;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            handleOnCompletionException$kotlinx_coroutines_core(completionHandlerException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [tb.f21] */
    private final void promoteEmptyToNodeList(l lVar) {
        xk1 xk1Var = new xk1();
        if (!lVar.isActive()) {
            xk1Var = new f21(xk1Var);
        }
        _state$FU.compareAndSet(this, lVar, xk1Var);
    }

    private final void promoteSingleToNodeList(f61<?> f61Var) {
        f61Var.f(new xk1());
        _state$FU.compareAndSet(this, f61Var, f61Var.k());
    }

    private final int startInternal(Object obj) {
        l lVar;
        if (obj instanceof l) {
            if (((l) obj).isActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            lVar = s.f;
            if (atomicReferenceFieldUpdater.compareAndSet(this, obj, lVar)) {
                onStartInternal$kotlinx_coroutines_core();
                return 1;
            }
            return -1;
        } else if (obj instanceof f21) {
            if (_state$FU.compareAndSet(this, obj, ((f21) obj).getList())) {
                onStartInternal$kotlinx_coroutines_core();
                return 1;
            }
            return -1;
        } else {
            return 0;
        }
    }

    private final String stateString(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof Incomplete ? ((Incomplete) obj).isActive() ? "Active" : "New" : obj instanceof am ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.e() ? "Cancelling" : bVar.f() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException toCancellationException$default(JobSupport jobSupport, Throwable th, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = null;
            }
            return jobSupport.toCancellationException(th, str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }

    private final boolean tryFinalizeSimpleState(Incomplete incomplete, Object obj) {
        if (k40.a()) {
            if (!((incomplete instanceof l) || (incomplete instanceof f61))) {
                throw new AssertionError();
            }
        }
        if (!k40.a() || (!(obj instanceof am))) {
            if (_state$FU.compareAndSet(this, incomplete, s.g(obj))) {
                onCancelling(null);
                onCompletionInternal(obj);
                completeStateFinalization(incomplete, obj);
                return true;
            }
            return false;
        }
        throw new AssertionError();
    }

    private final boolean tryMakeCancelling(Incomplete incomplete, Throwable th) {
        if (!k40.a() || (!(incomplete instanceof b))) {
            if (!k40.a() || incomplete.isActive()) {
                xk1 orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
                if (orPromoteCancellingList != null) {
                    if (_state$FU.compareAndSet(this, incomplete, new b(orPromoteCancellingList, false, th))) {
                        notifyCancelling(orPromoteCancellingList, th);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    private final Object tryMakeCompleting(Object obj, Object obj2) {
        kj2 kj2Var;
        kj2 kj2Var2;
        if (!(obj instanceof Incomplete)) {
            kj2Var2 = s.a;
            return kj2Var2;
        } else if (((obj instanceof l) || (obj instanceof f61)) && !(obj instanceof mi) && !(obj2 instanceof am)) {
            if (tryFinalizeSimpleState((Incomplete) obj, obj2)) {
                return obj2;
            }
            kj2Var = s.b;
            return kj2Var;
        } else {
            return tryMakeCompletingSlowPath((Incomplete) obj, obj2);
        }
    }

    private final Object tryMakeCompletingSlowPath(Incomplete incomplete, Object obj) {
        kj2 kj2Var;
        kj2 kj2Var2;
        kj2 kj2Var3;
        xk1 orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
        if (orPromoteCancellingList == null) {
            kj2Var = s.b;
            return kj2Var;
        }
        b bVar = (b) (!(incomplete instanceof b) ? null : incomplete);
        if (bVar == null) {
            bVar = new b(orPromoteCancellingList, false, null);
        }
        synchronized (bVar) {
            if (bVar.f()) {
                kj2Var3 = s.a;
                return kj2Var3;
            }
            bVar.i(true);
            if (bVar != incomplete && !_state$FU.compareAndSet(this, incomplete, bVar)) {
                kj2Var2 = s.b;
                return kj2Var2;
            }
            if (k40.a() && !(!bVar.g())) {
                throw new AssertionError();
            }
            boolean e = bVar.e();
            am amVar = (am) (!(obj instanceof am) ? null : obj);
            if (amVar != null) {
                bVar.a(amVar.a);
            }
            Throwable d = true ^ e ? bVar.d() : null;
            wt2 wt2Var = wt2.INSTANCE;
            if (d != null) {
                notifyCancelling(orPromoteCancellingList, d);
            }
            mi firstChild = firstChild(incomplete);
            if (firstChild != null && tryWaitForChild(bVar, firstChild, obj)) {
                return s.COMPLETING_WAITING_CHILDREN;
            }
            return finalizeFinishingState(bVar, obj);
        }
    }

    private final boolean tryWaitForChild(b bVar, mi miVar, Object obj) {
        while (Job.a.e(miVar.e, false, false, new a(this, bVar, miVar, obj), 1, null) == zk1.INSTANCE) {
            miVar = nextChild(miVar);
            if (miVar == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void afterCompletion(@Nullable Object obj) {
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final ChildHandle attachChild(@NotNull ChildJob childJob) {
        DisposableHandle e = Job.a.e(this, true, false, new mi(this, childJob), 2, null);
        Objects.requireNonNull(e, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle) e;
    }

    @Nullable
    public final Object awaitInternal$kotlinx_coroutines_core(@NotNull Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (state$kotlinx_coroutines_core instanceof am) {
                    Throwable th = ((am) state$kotlinx_coroutines_core).a;
                    if (k40.d()) {
                        if (continuation instanceof CoroutineStackFrame) {
                            throw pf2.a(th, (CoroutineStackFrame) continuation);
                        }
                        throw th;
                    }
                    throw th;
                }
                return s.h(state$kotlinx_coroutines_core);
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    @Nullable
    final /* synthetic */ Object awaitSuspend(@NotNull Continuation<Object> continuation) {
        Continuation c2;
        Object d;
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        AwaitContinuation awaitContinuation = new AwaitContinuation(c2, this);
        dg.a(awaitContinuation, invokeOnCompletion(new u(this, awaitContinuation)));
        Object result = awaitContinuation.getResult();
        d = kotlin.coroutines.intrinsics.b.d();
        if (result == d) {
            n40.c(continuation);
        }
        return result;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    public final boolean cancelCoroutine(@Nullable Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    public final boolean cancelImpl$kotlinx_coroutines_core(@Nullable Object obj) {
        Object obj2;
        kj2 kj2Var;
        kj2 kj2Var2;
        kj2 kj2Var3;
        obj2 = s.a;
        if (getOnCancelComplete$kotlinx_coroutines_core() && (obj2 = cancelMakeCompleting(obj)) == s.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        kj2Var = s.a;
        if (obj2 == kj2Var) {
            obj2 = makeCancelling(obj);
        }
        kj2Var2 = s.a;
        if (obj2 == kj2Var2 || obj2 == s.COMPLETING_WAITING_CHILDREN) {
            return true;
        }
        kj2Var3 = s.c;
        if (obj2 == kj2Var3) {
            return false;
        }
        afterCompletion(obj2);
        return true;
    }

    public void cancelInternal(@NotNull Throwable th) {
        cancelImpl$kotlinx_coroutines_core(th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    public boolean childCancelled(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return cancelImpl$kotlinx_coroutines_core(th) && getHandlesException$kotlinx_coroutines_core();
    }

    @NotNull
    public final JobCancellationException defaultCancellationException$kotlinx_coroutines_core(@Nullable String str, @Nullable Throwable th) {
        if (str == null) {
            str = cancellationExceptionMessage();
        }
        return new JobCancellationException(str, th, this);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) Job.a.c(this, r, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) Job.a.d(this, key);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final CancellationException getCancellationException() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            Throwable d = ((b) state$kotlinx_coroutines_core).d();
            if (d != null) {
                CancellationException cancellationException = toCancellationException(d, o40.a(this) + " is cancelling");
                if (cancellationException != null) {
                    return cancellationException;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (state$kotlinx_coroutines_core instanceof am) {
                return toCancellationException$default(this, ((am) state$kotlinx_coroutines_core).a, null, 1, null);
            }
            return new JobCancellationException(o40.a(this) + " has completed normally", null, this);
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    @Override // kotlinx.coroutines.ParentJob
    @NotNull
    public CancellationException getChildJobCancellationCause() {
        Throwable th;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            th = ((b) state$kotlinx_coroutines_core).d();
        } else if (state$kotlinx_coroutines_core instanceof am) {
            th = ((am) state$kotlinx_coroutines_core).a;
        } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
        } else {
            th = null;
        }
        CancellationException cancellationException = th instanceof CancellationException ? th : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new JobCancellationException("Parent job is " + stateString(state$kotlinx_coroutines_core), th, this);
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final Sequence<Job> getChildren() {
        return kotlin.sequences.d.b(new JobSupport$children$1(this, null));
    }

    @Nullable
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (!(state$kotlinx_coroutines_core instanceof am)) {
                return s.h(state$kotlinx_coroutines_core);
            }
            throw ((am) state$kotlinx_coroutines_core).a;
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    @Nullable
    protected final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof b) {
            Throwable d = ((b) state$kotlinx_coroutines_core).d();
            if (d != null) {
                return d;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            if (state$kotlinx_coroutines_core instanceof am) {
                return ((am) state$kotlinx_coroutines_core).a;
            }
            return null;
        } else {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
    }

    protected final boolean getCompletionCauseHandled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof am) && ((am) state$kotlinx_coroutines_core).a();
    }

    @Nullable
    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
            return getExceptionOrNull(state$kotlinx_coroutines_core);
        }
        throw new IllegalStateException("This job has not completed yet".toString());
    }

    public boolean getHandlesException$kotlinx_coroutines_core() {
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @NotNull
    public final CoroutineContext.Key<?> getKey() {
        return Job.Key;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final SelectClause0 getOnJoin() {
        return this;
    }

    @Nullable
    public final ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle) this._parentHandle;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof cn1)) {
                return obj;
            }
            ((cn1) obj).c(this);
        }
    }

    protected boolean handleJobException(@NotNull Throwable th) {
        return false;
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(@NotNull Throwable th) {
        throw th;
    }

    public final void initParentJobInternal$kotlinx_coroutines_core(@Nullable Job job) {
        if (k40.a()) {
            if (!(getParentHandle$kotlinx_coroutines_core() == null)) {
                throw new AssertionError();
            }
        }
        if (job == null) {
            setParentHandle$kotlinx_coroutines_core(zk1.INSTANCE);
            return;
        }
        job.start();
        ChildHandle attachChild = job.attachChild(this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core(zk1.INSTANCE);
        }
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(@NotNull Function1<? super Throwable, wt2> function1) {
        return invokeOnCompletion(false, true, function1);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).isActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof am) || ((state$kotlinx_coroutines_core instanceof b) && ((b) state$kotlinx_coroutines_core).e());
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof am;
    }

    protected boolean isScopedCoroutine() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    @Nullable
    public final Object join(@NotNull Continuation<? super wt2> continuation) {
        Object d;
        if (!joinInternal()) {
            n23.a(continuation.getContext());
            return wt2.INSTANCE;
        }
        Object joinSuspend = joinSuspend(continuation);
        d = kotlin.coroutines.intrinsics.b.d();
        return joinSuspend == d ? joinSuspend : wt2.INSTANCE;
    }

    @Nullable
    final /* synthetic */ Object joinSuspend(@NotNull Continuation<? super wt2> continuation) {
        Continuation c2;
        Object d;
        c2 = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c2, 1);
        cancellableContinuationImpl.initCancellability();
        dg.a(cancellableContinuationImpl, invokeOnCompletion(new v(this, cancellableContinuationImpl)));
        Object result = cancellableContinuationImpl.getResult();
        d = kotlin.coroutines.intrinsics.b.d();
        if (result == d) {
            n40.c(continuation);
        }
        return result;
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(@Nullable Object obj) {
        Object tryMakeCompleting;
        kj2 kj2Var;
        kj2 kj2Var2;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            kj2Var = s.a;
            if (tryMakeCompleting == kj2Var) {
                return false;
            }
            if (tryMakeCompleting == s.COMPLETING_WAITING_CHILDREN) {
                return true;
            }
            kj2Var2 = s.b;
        } while (tryMakeCompleting == kj2Var2);
        afterCompletion(tryMakeCompleting);
        return true;
    }

    @Nullable
    public final Object makeCompletingOnce$kotlinx_coroutines_core(@Nullable Object obj) {
        Object tryMakeCompleting;
        kj2 kj2Var;
        kj2 kj2Var2;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), obj);
            kj2Var = s.a;
            if (tryMakeCompleting != kj2Var) {
                kj2Var2 = s.b;
            } else {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, getExceptionOrNull(obj));
            }
        } while (tryMakeCompleting == kj2Var2);
        return tryMakeCompleting;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return Job.a.f(this, key);
    }

    @NotNull
    public String nameString$kotlinx_coroutines_core() {
        return o40.a(this);
    }

    protected void onCancelling(@Nullable Throwable th) {
    }

    protected void onCompletionInternal(@Nullable Object obj) {
    }

    public void onStartInternal$kotlinx_coroutines_core() {
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(@NotNull ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return Job.a.g(this, coroutineContext);
    }

    @Override // kotlinx.coroutines.selects.SelectClause0
    public final <R> void registerSelectClause0(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (selectInstance.isSelected()) {
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (selectInstance.trySelect()) {
                    st2.c(function1, selectInstance.getCompletion());
                    return;
                }
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new x(this, selectInstance, function1)));
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (selectInstance.isSelected()) {
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (selectInstance.trySelect()) {
                    if (state$kotlinx_coroutines_core instanceof am) {
                        selectInstance.resumeSelectWithException(((am) state$kotlinx_coroutines_core).a);
                        return;
                    } else {
                        st2.d(function2, s.h(state$kotlinx_coroutines_core), selectInstance.getCompletion());
                        return;
                    }
                }
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        selectInstance.disposeOnSelect(invokeOnCompletion(new w(this, selectInstance, function2)));
    }

    public final void removeNode$kotlinx_coroutines_core(@NotNull f61<?> f61Var) {
        Object state$kotlinx_coroutines_core;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        l lVar;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof f61)) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((Incomplete) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                f61Var.p();
                return;
            } else if (state$kotlinx_coroutines_core != f61Var) {
                return;
            } else {
                atomicReferenceFieldUpdater = _state$FU;
                lVar = s.f;
            }
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, lVar));
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(@NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof am) {
            selectInstance.resumeSelectWithException(((am) state$kotlinx_coroutines_core).a);
        } else {
            eg.d(function2, s.h(state$kotlinx_coroutines_core), selectInstance.getCompletion(), null, 4, null);
        }
    }

    public final void setParentHandle$kotlinx_coroutines_core(@Nullable ChildHandle childHandle) {
        this._parentHandle = childHandle;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int startInternal;
        do {
            startInternal = startInternal(getState$kotlinx_coroutines_core());
            if (startInternal == 0) {
                return false;
            }
        } while (startInternal != 1);
        return true;
    }

    @NotNull
    protected final CancellationException toCancellationException(@NotNull Throwable th, @Nullable String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = cancellationExceptionMessage();
            }
            cancellationException = new JobCancellationException(str, th, this);
        }
        return cancellationException;
    }

    @InternalCoroutinesApi
    @NotNull
    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}';
    }

    @NotNull
    public String toString() {
        return toDebugString() + '@' + o40.b(this);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public /* synthetic */ boolean cancel(@Nullable Throwable th) {
        Throwable jobCancellationException;
        if (th == null || (jobCancellationException = toCancellationException$default(this, th, null, 1, null)) == null) {
            jobCancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(jobCancellationException);
        return true;
    }

    @Override // kotlinx.coroutines.Job
    @NotNull
    public final DisposableHandle invokeOnCompletion(boolean z, boolean z2, @NotNull Function1<? super Throwable, wt2> function1) {
        Throwable th;
        f61<?> f61Var = null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof l) {
                l lVar = (l) state$kotlinx_coroutines_core;
                if (lVar.isActive()) {
                    if (f61Var == null) {
                        f61Var = makeNode(function1, z);
                    }
                    if (_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, f61Var)) {
                        return f61Var;
                    }
                } else {
                    promoteEmptyToNodeList(lVar);
                }
            } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                xk1 list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list == null) {
                    Objects.requireNonNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    promoteSingleToNodeList((f61) state$kotlinx_coroutines_core);
                } else {
                    DisposableHandle disposableHandle = zk1.INSTANCE;
                    if (z && (state$kotlinx_coroutines_core instanceof b)) {
                        synchronized (state$kotlinx_coroutines_core) {
                            th = ((b) state$kotlinx_coroutines_core).d();
                            if (th == null || ((function1 instanceof mi) && !((b) state$kotlinx_coroutines_core).f())) {
                                if (f61Var == null) {
                                    f61Var = makeNode(function1, z);
                                }
                                if (addLastAtomic(state$kotlinx_coroutines_core, list, f61Var)) {
                                    if (th == null) {
                                        return f61Var;
                                    }
                                    disposableHandle = f61Var;
                                }
                            }
                            wt2 wt2Var = wt2.INSTANCE;
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z2) {
                            function1.invoke(th);
                        }
                        return disposableHandle;
                    }
                    if (f61Var == null) {
                        f61Var = makeNode(function1, z);
                    }
                    if (addLastAtomic(state$kotlinx_coroutines_core, list, f61Var)) {
                        return f61Var;
                    }
                }
            } else {
                if (z2) {
                    if (!(state$kotlinx_coroutines_core instanceof am)) {
                        state$kotlinx_coroutines_core = null;
                    }
                    am amVar = (am) state$kotlinx_coroutines_core;
                    function1.invoke(amVar != null ? amVar.a : null);
                }
                return zk1.INSTANCE;
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    public Job plus(@NotNull Job job) {
        return Job.a.h(this, job);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(@Nullable CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cancellationException);
    }
}
