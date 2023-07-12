package kotlinx.coroutines.internal;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractC8699m;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C8968bm;
import tb.aa0;
import tb.b41;
import tb.dm;
import tb.i32;
import tb.jn1;
import tb.k40;
import tb.kj2;
import tb.o40;
import tb.pm2;
import tb.s21;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010C\u001a\u00020B\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bM\u0010NJ\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0019H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010 \u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!JH\u0010&\u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2%\b\b\u0010%\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\"H\u0086\bø\u0001\u0000¢\u0006\u0004\b&\u0010'J!\u0010+\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0013H\u0010¢\u0006\u0004\b)\u0010*J\u001a\u0010-\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0019H\u0086\b¢\u0006\u0004\b-\u0010.J!\u0010/\u001a\u00020\u001f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b/\u0010!J\u001f\u00105\u001a\u00020\u001f2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00028\u0000H\u0000¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108R\u001e\u00109\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b9\u0010:\u0012\u0004\b;\u0010<R$\u0010=\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00198\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\bA\u0010:R\u0016\u0010C\u001a\u00020B8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010ER\u0019\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n8F@\u0006¢\u0006\u0006\u001a\u0004\bF\u0010\u0010R\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058P@\u0010X\u0090\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0016\u00101\u001a\u0002008\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010L\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "requester", "", "isReusable", "(Lkotlinx/coroutines/CancellableContinuationImpl;)Z", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "cause", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "Lkotlin/Result;", "result", "Ltb/wt2;", "resumeWith", "(Ljava/lang/Object;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "state", "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "Lkotlin/coroutines/CoroutineContext;", WPKFactory.INIT_KEY_CONTEXT, "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "()V", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "countOrElement", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlin/coroutines/Continuation;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes11.dex */
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {
    private static final AtomicReferenceFieldUpdater _reusableCancellableContinuation$FU = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;
    @JvmField
    @Nullable
    public Object _state;
    @Nullable
    private final CoroutineStackFrame callerFrame;
    @JvmField
    @NotNull
    public final Continuation<T> continuation;
    @JvmField
    @NotNull
    public final Object countOrElement;
    @JvmField
    @NotNull
    public final CoroutineDispatcher dispatcher;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Continuation<? super T> continuation) {
        super(-1);
        this.dispatcher = coroutineDispatcher;
        this.continuation = continuation;
        this._state = aa0.a();
        this.callerFrame = (CoroutineStackFrame) (continuation instanceof CoroutineStackFrame ? continuation : null);
        this.countOrElement = ThreadContextKt.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    public static /* synthetic */ void get_state$kotlinx_coroutines_core$annotations() {
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th) {
        if (obj instanceof C8968bm) {
            ((C8968bm) obj).b.invoke(th);
        }
    }

    @Nullable
    public final Throwable checkPostponedCancellation(@NotNull CancellableContinuation<?> cancellableContinuation) {
        kj2 kj2Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            kj2Var = aa0.REUSABLE_CLAIMED;
            if (obj != kj2Var) {
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Throwable) {
                    if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!_reusableCancellableContinuation$FU.compareAndSet(this, kj2Var, cancellableContinuation));
        return null;
    }

    @Nullable
    public final CancellableContinuationImpl<T> claimReusableCancellableContinuation() {
        Object obj;
        do {
            obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = aa0.REUSABLE_CLAIMED;
                return null;
            } else if (!(obj instanceof CancellableContinuationImpl)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!_reusableCancellableContinuation$FU.compareAndSet(this, obj, aa0.REUSABLE_CLAIMED));
        return (CancellableContinuationImpl) obj;
    }

    public final void dispatchYield$kotlinx_coroutines_core(@NotNull CoroutineContext coroutineContext, T t) {
        this._state = t;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(coroutineContext, this);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        return this.callerFrame;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    public Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this;
    }

    @Nullable
    public final CancellableContinuationImpl<?> getReusableCancellableContinuation() {
        Object obj = this._reusableCancellableContinuation;
        if (!(obj instanceof CancellableContinuationImpl)) {
            obj = null;
        }
        return (CancellableContinuationImpl) obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final boolean isReusable(@NotNull CancellableContinuationImpl<?> cancellableContinuationImpl) {
        Object obj = this._reusableCancellableContinuation;
        if (obj != null) {
            return !(obj instanceof CancellableContinuationImpl) || obj == cancellableContinuationImpl;
        }
        return false;
    }

    public final boolean postponeCancellation(@NotNull Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            kj2 kj2Var = aa0.REUSABLE_CLAIMED;
            if (b41.d(obj, kj2Var)) {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, kj2Var, th)) {
                    return true;
                }
            } else if (obj instanceof Throwable) {
                return true;
            } else {
                if (_reusableCancellableContinuation$FU.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void resumeCancellableWith(@NotNull Object obj, @Nullable Function1<? super Throwable, wt2> function1) {
        boolean z;
        Object b = dm.b(obj, function1);
        if (this.dispatcher.isDispatchNeeded(getContext())) {
            this._state = b;
            this.resumeMode = 1;
            this.dispatcher.dispatch(getContext(), this);
            return;
        }
        k40.a();
        AbstractC8699m b2 = pm2.INSTANCE.b();
        if (b2.isUnconfinedLoopActive()) {
            this._state = b;
            this.resumeMode = 1;
            b2.dispatchUnconfined(this);
            return;
        }
        b2.incrementUseCount(true);
        try {
            Job job = (Job) getContext().get(Job.Key);
            if (job == null || job.isActive()) {
                z = false;
            } else {
                CancellationException cancellationException = job.getCancellationException();
                cancelCompletedResult$kotlinx_coroutines_core(b, cancellationException);
                Result.C8174a c8174a = Result.Companion;
                resumeWith(Result.m1271constructorimpl(i32.a(cancellationException)));
                z = true;
            }
            if (!z) {
                CoroutineContext context = getContext();
                Object c = ThreadContextKt.c(context, this.countOrElement);
                this.continuation.resumeWith(obj);
                wt2 wt2Var = wt2.INSTANCE;
                s21.b(1);
                ThreadContextKt.a(context, c);
                s21.a(1);
            }
            do {
            } while (b2.processUnconfinedEvent());
            s21.b(1);
        } catch (Throwable th) {
            try {
                handleFatalException$kotlinx_coroutines_core(th, null);
                s21.b(1);
            } catch (Throwable th2) {
                s21.b(1);
                b2.decrementUseCount(true);
                s21.a(1);
                throw th2;
            }
        }
        b2.decrementUseCount(true);
        s21.a(1);
    }

    public final boolean resumeCancelled(@Nullable Object obj) {
        Job job = (Job) getContext().get(Job.Key);
        if (job == null || job.isActive()) {
            return false;
        }
        CancellationException cancellationException = job.getCancellationException();
        cancelCompletedResult$kotlinx_coroutines_core(obj, cancellationException);
        Result.C8174a c8174a = Result.Companion;
        resumeWith(Result.m1271constructorimpl(i32.a(cancellationException)));
        return true;
    }

    public final void resumeUndispatchedWith(@NotNull Object obj) {
        CoroutineContext context = getContext();
        Object c = ThreadContextKt.c(context, this.countOrElement);
        try {
            this.continuation.resumeWith(obj);
            wt2 wt2Var = wt2.INSTANCE;
        } finally {
            s21.b(1);
            ThreadContextKt.a(context, c);
            s21.a(1);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        CoroutineContext context = this.continuation.getContext();
        Object d = dm.d(obj, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = d;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
            return;
        }
        k40.a();
        AbstractC8699m b = pm2.INSTANCE.b();
        if (b.isUnconfinedLoopActive()) {
            this._state = d;
            this.resumeMode = 0;
            b.dispatchUnconfined(this);
            return;
        }
        b.incrementUseCount(true);
        try {
            CoroutineContext context2 = getContext();
            Object c = ThreadContextKt.c(context2, this.countOrElement);
            this.continuation.resumeWith(obj);
            wt2 wt2Var = wt2.INSTANCE;
            ThreadContextKt.a(context2, c);
            do {
            } while (b.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        Object obj = this._state;
        if (k40.a()) {
            if (!(obj != aa0.a())) {
                throw new AssertionError();
            }
        }
        this._state = aa0.a();
        return obj;
    }

    @NotNull
    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + AVFSCacheConstants.COMMA_SEP + o40.c(this.continuation) + jn1.ARRAY_END;
    }
}
