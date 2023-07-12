package kotlinx.coroutines;

import io.flutter.wpkbridge.WPKFactory;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ag;
import tb.am;
import tb.b41;
import tb.ba0;
import tb.cg;
import tb.dm;
import tb.gg;
import tb.k40;
import tb.kj2;
import tb.li;
import tb.no;
import tb.o40;
import tb.pf2;
import tb.wt2;
import tb.zb;
import tb.zk1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001f\u0012\f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000w\u0012\u0006\u0010+\u001a\u00020%¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0011H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014JB\u0010\u001a\u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\bJB\u0010 \u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b \u0010!J8\u0010#\u001a\u00020\"2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0018H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(JZ\u0010.\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020%2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u00152\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b.\u0010/JH\u00100\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020%2%\b\u0002\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0002¢\u0006\u0004\b0\u00101JJ\u00103\u001a\u0004\u0018\u0001022\b\u0010*\u001a\u0004\u0018\u00010\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u001e2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0002¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0002052\b\u0010*\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\tH\u0002¢\u0006\u0004\b8\u0010\u000bJ\u000f\u00109\u001a\u00020\tH\u0016¢\u0006\u0004\b9\u0010\u000bJ\u000f\u0010:\u001a\u00020\u0006H\u0001¢\u0006\u0004\b:\u0010\bJ\u0017\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016¢\u0006\u0004\b=\u0010>J\u0011\u0010A\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\b?\u0010@J!\u0010E\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\bC\u0010DJ\u0019\u0010F\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\bF\u0010\u0010J\u0017\u0010I\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\bG\u0010HJ\u001f\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\"2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001a\u0010JJ8\u0010K\u001a\u00020\t2!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u00152\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\bK\u0010\u001bJ\u0017\u0010N\u001a\u00020\r2\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bN\u0010OJ\u0011\u0010P\u001a\u0004\u0018\u00010\u001eH\u0001¢\u0006\u0004\bP\u0010@J \u0010S\u001a\u00020\t2\f\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000QH\u0016ø\u0001\u0000¢\u0006\u0004\bS\u0010TJ<\u0010V\u001a\u00020\t2\u0006\u0010U\u001a\u00028\u00002#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016¢\u0006\u0004\bV\u0010WJ8\u0010X\u001a\u00020\t2'\u0010\u0019\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u0015j\u0002`\u0018H\u0016¢\u0006\u0004\bX\u0010YJ\u000f\u0010[\u001a\u00020\tH\u0000¢\u0006\u0004\bZ\u0010\u000bJ#\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010U\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001d\u0010\\JH\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010U\u001a\u00028\u00002\b\u0010-\u001a\u0004\u0018\u00010\u001e2#\u0010,\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001d\u0010]J\u0019\u0010_\u001a\u0004\u0018\u00010\u001e2\u0006\u0010^\u001a\u00020\rH\u0016¢\u0006\u0004\b_\u0010`J\u0017\u0010b\u001a\u00020\t2\u0006\u0010a\u001a\u00020\u001eH\u0016¢\u0006\u0004\bb\u0010TJ\u001b\u0010d\u001a\u00020\t*\u00020c2\u0006\u0010U\u001a\u00028\u0000H\u0016¢\u0006\u0004\bd\u0010eJ\u001b\u0010f\u001a\u00020\t*\u00020c2\u0006\u0010^\u001a\u00020\rH\u0016¢\u0006\u0004\bf\u0010gJ\u001f\u0010j\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bh\u0010iJ\u001b\u0010m\u001a\u0004\u0018\u00010\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0010¢\u0006\u0004\bk\u0010lJ\u000f\u0010o\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pJ\u000f\u0010q\u001a\u00020nH\u0014¢\u0006\u0004\bq\u0010pR\u001c\u0010s\u001a\u00020r8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\"\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000w8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{R*\u0010\u0081\u0001\u001a\u0004\u0018\u00010|2\b\u0010U\u001a\u0004\u0018\u00010|8B@BX\u0082\u000e¢\u0006\r\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e8@@\u0000X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010@R\u0018\u0010\u0083\u0001\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010\bR\u0018\u0010\u0084\u0001\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\bR\u0018\u0010\u0085\u0001\u001a\u00020\u00068V@\u0016X\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010\bR!\u0010\u0088\u0001\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008b\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", "isReusable", "()Z", "Ltb/wt2;", "setupCancellation", "()V", "checkCompleted", "", "cause", "cancelLater", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "callCancelHandler", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "trySuspend", "tryResume", "", "state", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "Ltb/ag;", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Ltb/ag;", "", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/NotCompleted;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Ltb/kj2;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ltb/kj2;", "", "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "detachChildIfNonResuable", "initCancellability", "resetStateReusable", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancel", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "(Ltb/ag;Ljava/lang/Throwable;)V", "callOnCancellation", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "getResult", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "detachChild$kotlinx_coroutines_core", "detachChild", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "token", "completeResume", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "", "toString", "()Ljava/lang/String;", "nameString", "Lkotlin/coroutines/CoroutineContext;", WPKFactory.INIT_KEY_CONTEXT, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/DisposableHandle;", "getParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "setParentHandle", "(Lkotlinx/coroutines/DisposableHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "isActive", "isCompleted", "isCancelled", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
/* loaded from: classes8.dex */
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {
    private static final AtomicIntegerFieldUpdater _decision$FU = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private volatile int _decision;
    private volatile Object _parentHandle;
    private volatile Object _state;
    @NotNull
    private final CoroutineContext context;
    @NotNull
    private final Continuation<T> delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(@NotNull Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        if (k40.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        this.context = continuation.getContext();
        this._decision = 0;
        this._state = C8622b.INSTANCE;
        this._parentHandle = null;
    }

    private final Void alreadyResumedError(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void callCancelHandlerSafely(Function0<wt2> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            CoroutineContext context = getContext();
            no.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    private final boolean cancelLater(Throwable th) {
        if (ba0.c(this.resumeMode)) {
            Continuation<T> continuation = this.delegate;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (dispatchedContinuation != null) {
                return dispatchedContinuation.postponeCancellation(th);
            }
            return false;
        }
        return false;
    }

    private final boolean checkCompleted() {
        Throwable checkPostponedCancellation;
        boolean isCompleted = isCompleted();
        if (ba0.c(this.resumeMode)) {
            Continuation<T> continuation = this.delegate;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (dispatchedContinuation == null || (checkPostponedCancellation = dispatchedContinuation.checkPostponedCancellation(this)) == null) {
                return isCompleted;
            }
            if (!isCompleted) {
                cancel(checkPostponedCancellation);
            }
            return true;
        }
        return isCompleted;
    }

    private final void detachChildIfNonResuable() {
        if (isReusable()) {
            return;
        }
        detachChild$kotlinx_coroutines_core();
    }

    private final void dispatchResume(int i) {
        if (tryResume()) {
            return;
        }
        ba0.a(this, i);
    }

    private final DisposableHandle getParentHandle() {
        return (DisposableHandle) this._parentHandle;
    }

    private final boolean isReusable() {
        Continuation<T> continuation = this.delegate;
        return (continuation instanceof DispatchedContinuation) && ((DispatchedContinuation) continuation).isReusable(this);
    }

    private final ag makeCancelHandler(Function1<? super Throwable, wt2> function1) {
        return function1 instanceof ag ? (ag) function1 : new C8702p(function1);
    }

    private final void multipleHandlersError(Function1<? super Throwable, wt2> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final void resumeImpl(Object obj, int i, Function1<? super Throwable, wt2> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
            } else {
                if (obj2 instanceof gg) {
                    gg ggVar = (gg) obj2;
                    if (ggVar.c()) {
                        if (function1 != null) {
                            callOnCancellation(function1, ggVar.a);
                            return;
                        }
                        return;
                    }
                }
                alreadyResumedError(obj);
                throw new KotlinNothingValueException();
            }
        } while (!_state$FU.compareAndSet(this, obj2, resumedState((NotCompleted) obj2, obj, i, function1, null)));
        detachChildIfNonResuable();
        dispatchResume(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void resumeImpl$default(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 == null) {
            if ((i2 & 4) != 0) {
                function1 = null;
            }
            cancellableContinuationImpl.resumeImpl(obj, i, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }

    private final Object resumedState(NotCompleted notCompleted, Object obj, int i, Function1<? super Throwable, wt2> function1, Object obj2) {
        if (obj instanceof am) {
            if (k40.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (k40.a()) {
                if (function1 == null) {
                    return obj;
                }
                throw new AssertionError();
            }
            return obj;
        } else if (ba0.b(i) || obj2 != null) {
            if (function1 != null || (((notCompleted instanceof ag) && !(notCompleted instanceof zb)) || obj2 != null)) {
                if (!(notCompleted instanceof ag)) {
                    notCompleted = null;
                }
                return new C8692i(obj, (ag) notCompleted, function1, obj2, null, 16, null);
            }
            return obj;
        } else {
            return obj;
        }
    }

    private final void setParentHandle(DisposableHandle disposableHandle) {
        this._parentHandle = disposableHandle;
    }

    private final void setupCancellation() {
        Job job;
        if (checkCompleted() || getParentHandle() != null || (job = (Job) this.delegate.getContext().get(Job.Key)) == null) {
            return;
        }
        DisposableHandle e = Job.C8613a.e(job, true, false, new li(job, this), 2, null);
        setParentHandle(e);
        if (!isCompleted() || isReusable()) {
            return;
        }
        e.dispose();
        setParentHandle(zk1.INSTANCE);
    }

    private final kj2 tryResumeImpl(Object obj, Object obj2, Function1<? super Throwable, wt2> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (obj3 instanceof NotCompleted) {
            } else if (!(obj3 instanceof C8692i) || obj2 == null) {
                return null;
            } else {
                C8692i c8692i = (C8692i) obj3;
                if (c8692i.d == obj2) {
                    if (!k40.a() || b41.d(c8692i.a, obj)) {
                        return cg.RESUME_TOKEN;
                    }
                    throw new AssertionError();
                }
                return null;
            }
        } while (!_state$FU.compareAndSet(this, obj3, resumedState((NotCompleted) obj3, obj, this.resumeMode, function1, obj2)));
        detachChildIfNonResuable();
        return cg.RESUME_TOKEN;
    }

    private final boolean trySuspend() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 1));
        return true;
    }

    public final void callCancelHandler(@NotNull ag agVar, @Nullable Throwable th) {
        try {
            agVar.a(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            no.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void callOnCancellation(@NotNull Function1<? super Throwable, wt2> function1, @NotNull Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            no.a(context, new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean cancel(@Nullable Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof ag;
        } while (!_state$FU.compareAndSet(this, obj, new gg(this, th, z)));
        if (!z) {
            obj = null;
        }
        ag agVar = (ag) obj;
        if (agVar != null) {
            callCancelHandler(agVar, th);
        }
        detachChildIfNonResuable();
        dispatchResume(this.resumeMode);
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof am) {
                    return;
                }
                if (obj2 instanceof C8692i) {
                    C8692i c8692i = (C8692i) obj2;
                    if (!c8692i.c()) {
                        if (_state$FU.compareAndSet(this, obj2, C8692i.b(c8692i, null, null, null, null, th, 15, null))) {
                            c8692i.d(this, th);
                            return;
                        }
                    } else {
                        throw new IllegalStateException("Must be called at most once".toString());
                    }
                } else if (_state$FU.compareAndSet(this, obj2, new C8692i(obj2, null, null, null, th, 14, null))) {
                    return;
                }
            } else {
                throw new IllegalStateException("Not completed".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void completeResume(@NotNull Object obj) {
        if (k40.a()) {
            if (!(obj == cg.RESUME_TOKEN)) {
                throw new AssertionError();
            }
        }
        dispatchResume(this.resumeMode);
    }

    public final void detachChild$kotlinx_coroutines_core() {
        DisposableHandle parentHandle = getParentHandle();
        if (parentHandle != null) {
            parentHandle.dispose();
        }
        setParentHandle(zk1.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        return (CoroutineStackFrame) continuation;
    }

    @Override // kotlin.coroutines.Continuation
    @NotNull
    public CoroutineContext getContext() {
        return this.context;
    }

    @NotNull
    public Throwable getContinuationCancellationCause(@NotNull Job job) {
        return job.getCancellationException();
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @NotNull
    public final Continuation<T> getDelegate$kotlinx_coroutines_core() {
        return this.delegate;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object obj) {
        Throwable exceptionalResult$kotlinx_coroutines_core = super.getExceptionalResult$kotlinx_coroutines_core(obj);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Continuation<T> continuation = this.delegate;
            return (k40.d() && (continuation instanceof CoroutineStackFrame)) ? pf2.a(exceptionalResult$kotlinx_coroutines_core, (CoroutineStackFrame) continuation) : exceptionalResult$kotlinx_coroutines_core;
        }
        return null;
    }

    @PublishedApi
    @Nullable
    public final Object getResult() {
        Job job;
        Object d;
        setupCancellation();
        if (trySuspend()) {
            d = C8234b.d();
            return d;
        }
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof am) {
            Throwable th = ((am) state$kotlinx_coroutines_core).a;
            if (k40.d()) {
                throw pf2.a(th, this);
            }
            throw th;
        } else if (ba0.b(this.resumeMode) && (job = (Job) getContext().get(Job.Key)) != null && !job.isActive()) {
            CancellationException cancellationException = job.getCancellationException();
            cancelCompletedResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core, cancellationException);
            if (k40.d()) {
                throw pf2.a(cancellationException, this);
            }
            throw cancellationException;
        } else {
            return getSuccessfulResult$kotlinx_coroutines_core(state$kotlinx_coroutines_core);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Nullable
    public final Object getState$kotlinx_coroutines_core() {
        return this._state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object obj) {
        return obj instanceof C8692i ? (T) ((C8692i) obj).a : obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void initCancellability() {
        setupCancellation();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void invokeOnCancellation(@NotNull Function1<? super Throwable, wt2> function1) {
        ag makeCancelHandler = makeCancelHandler(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof C8622b) {
                if (_state$FU.compareAndSet(this, obj, makeCancelHandler)) {
                    return;
                }
            } else if (obj instanceof ag) {
                multipleHandlersError(function1, obj);
            } else {
                boolean z = obj instanceof am;
                if (z) {
                    if (!((am) obj).b()) {
                        multipleHandlersError(function1, obj);
                    }
                    if (obj instanceof gg) {
                        if (!z) {
                            obj = null;
                        }
                        am amVar = (am) obj;
                        callCancelHandler(function1, amVar != null ? amVar.a : null);
                        return;
                    }
                    return;
                } else if (obj instanceof C8692i) {
                    C8692i c8692i = (C8692i) obj;
                    if (c8692i.b != null) {
                        multipleHandlersError(function1, obj);
                    }
                    if (makeCancelHandler instanceof zb) {
                        return;
                    }
                    if (c8692i.c()) {
                        callCancelHandler(function1, c8692i.e);
                        return;
                    } else {
                        if (_state$FU.compareAndSet(this, obj, C8692i.b(c8692i, null, makeCancelHandler, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else if (makeCancelHandler instanceof zb) {
                    return;
                } else {
                    if (_state$FU.compareAndSet(this, obj, new C8692i(obj, makeCancelHandler, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isActive() {
        return getState$kotlinx_coroutines_core() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCancelled() {
        return getState$kotlinx_coroutines_core() instanceof gg;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof NotCompleted);
    }

    @NotNull
    protected String nameString() {
        return "CancellableContinuation";
    }

    public final void parentCancelled$kotlinx_coroutines_core(@NotNull Throwable th) {
        if (cancelLater(th)) {
            return;
        }
        cancel(th);
        detachChildIfNonResuable();
    }

    @JvmName(name = "resetStateReusable")
    public final boolean resetStateReusable() {
        if (k40.a()) {
            if (!(this.resumeMode == 2)) {
                throw new AssertionError();
            }
        }
        if (k40.a()) {
            if (!(getParentHandle() != zk1.INSTANCE)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (!k40.a() || (!(obj instanceof NotCompleted))) {
            if ((obj instanceof C8692i) && ((C8692i) obj).d != null) {
                detachChild$kotlinx_coroutines_core();
                return false;
            }
            this._decision = 0;
            this._state = C8622b.INSTANCE;
            return true;
        }
        throw new AssertionError();
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resume(T t, @Nullable Function1<? super Throwable, wt2> function1) {
        resumeImpl(t, this.resumeMode, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatched(@NotNull CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        resumeImpl$default(this, t, (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void resumeUndispatchedWithException(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th) {
        Continuation<T> continuation = this.delegate;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        resumeImpl$default(this, new am(th, false, 2, null), (dispatchedContinuation != null ? dispatchedContinuation.dispatcher : null) == coroutineDispatcher ? 4 : this.resumeMode, null, 4, null);
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(@NotNull Object obj) {
        resumeImpl$default(this, dm.c(obj, this), this.resumeMode, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    @Nullable
    public Object takeState$kotlinx_coroutines_core() {
        return getState$kotlinx_coroutines_core();
    }

    @NotNull
    public String toString() {
        return nameString() + '(' + o40.c(this.delegate) + "){" + getState$kotlinx_coroutines_core() + "}@" + o40.b(this);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T t, @Nullable Object obj) {
        return tryResumeImpl(t, obj, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResumeWithException(@NotNull Throwable th) {
        return tryResumeImpl(new am(th, false, 2, null), null, null);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    @Nullable
    public Object tryResume(T t, @Nullable Object obj, @Nullable Function1<? super Throwable, wt2> function1) {
        return tryResumeImpl(t, obj, function1);
    }

    private final boolean tryResume() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!_decision$FU.compareAndSet(this, 0, 2));
        return true;
    }

    private final void callCancelHandler(Function1<? super Throwable, wt2> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            CoroutineContext context = getContext();
            no.a(context, new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }
}
