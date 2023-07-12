package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.am;
import tb.b41;
import tb.ba0;
import tb.hg0;
import tb.i32;
import tb.k40;
import tb.no;
import tb.pf2;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0004H ¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000e\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0016\u001a\u00020\u000bJ#\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001f8 @ X \u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "takenState", "", "cause", "Ltb/wt2;", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "state", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "run", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "handleFatalException", "", "resumeMode", "I", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes8.dex */
public abstract class DispatchedTask<T> extends Task {
    @JvmField
    public int resumeMode;

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public void cancelCompletedResult$kotlinx_coroutines_core(@Nullable Object obj, @NotNull Throwable th) {
    }

    @NotNull
    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    @Nullable
    public Throwable getExceptionalResult$kotlinx_coroutines_core(@Nullable Object obj) {
        if (!(obj instanceof am)) {
            obj = null;
        }
        am amVar = (am) obj;
        if (amVar != null) {
            return amVar.a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getSuccessfulResult$kotlinx_coroutines_core(@Nullable Object obj) {
        return obj;
    }

    public final void handleFatalException$kotlinx_coroutines_core(@Nullable Throwable th, @Nullable Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            hg0.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        b41.f(th);
        no.a(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object m1271constructorimpl;
        Object m1271constructorimpl2;
        if (k40.a()) {
            if (!(this.resumeMode != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.taskContext;
        try {
            Continuation<T> delegate$kotlinx_coroutines_core = getDelegate$kotlinx_coroutines_core();
            if (delegate$kotlinx_coroutines_core != null) {
                DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) delegate$kotlinx_coroutines_core;
                Continuation<T> continuation = dispatchedContinuation.continuation;
                CoroutineContext context = continuation.getContext();
                Object takeState$kotlinx_coroutines_core = takeState$kotlinx_coroutines_core();
                Object c = ThreadContextKt.c(context, dispatchedContinuation.countOrElement);
                Throwable exceptionalResult$kotlinx_coroutines_core = getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                Job job = (exceptionalResult$kotlinx_coroutines_core == null && ba0.b(this.resumeMode)) ? (Job) context.get(Job.Key) : null;
                if (job != null && !job.isActive()) {
                    Throwable cancellationException = job.getCancellationException();
                    cancelCompletedResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core, cancellationException);
                    Result.a aVar = Result.Companion;
                    if (k40.d() && (continuation instanceof CoroutineStackFrame)) {
                        cancellationException = pf2.a(cancellationException, (CoroutineStackFrame) continuation);
                    }
                    continuation.resumeWith(Result.m1271constructorimpl(i32.a(cancellationException)));
                } else if (exceptionalResult$kotlinx_coroutines_core != null) {
                    Result.a aVar2 = Result.Companion;
                    continuation.resumeWith(Result.m1271constructorimpl(i32.a(exceptionalResult$kotlinx_coroutines_core)));
                } else {
                    T successfulResult$kotlinx_coroutines_core = getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
                    Result.a aVar3 = Result.Companion;
                    continuation.resumeWith(Result.m1271constructorimpl(successfulResult$kotlinx_coroutines_core));
                }
                wt2 wt2Var = wt2.INSTANCE;
                ThreadContextKt.a(context, c);
                try {
                    Result.a aVar4 = Result.Companion;
                    taskContext.afterTask();
                    m1271constructorimpl2 = Result.m1271constructorimpl(wt2Var);
                } catch (Throwable th) {
                    Result.a aVar5 = Result.Companion;
                    m1271constructorimpl2 = Result.m1271constructorimpl(i32.a(th));
                }
                handleFatalException$kotlinx_coroutines_core(null, Result.m1274exceptionOrNullimpl(m1271constructorimpl2));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
        } catch (Throwable th2) {
            try {
                Result.a aVar6 = Result.Companion;
                taskContext.afterTask();
                m1271constructorimpl = Result.m1271constructorimpl(wt2.INSTANCE);
            } catch (Throwable th3) {
                Result.a aVar7 = Result.Companion;
                m1271constructorimpl = Result.m1271constructorimpl(i32.a(th3));
            }
            handleFatalException$kotlinx_coroutines_core(th2, Result.m1274exceptionOrNullimpl(m1271constructorimpl));
        }
    }

    @Nullable
    public abstract Object takeState$kotlinx_coroutines_core();
}
