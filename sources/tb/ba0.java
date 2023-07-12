package tb;

import java.util.Objects;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ba0 {
    public static final int MODE_ATOMIC = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_CANCELLABLE_REUSABLE = 2;
    public static final int MODE_UNDISPATCHED = 4;
    public static final int MODE_UNINITIALIZED = -1;

    public static final <T> void a(@NotNull DispatchedTask<? super T> dispatchedTask, int i) {
        if (k40.a()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> delegate$kotlinx_coroutines_core = dispatchedTask.getDelegate$kotlinx_coroutines_core();
        boolean z = i == 4;
        if (!z && (delegate$kotlinx_coroutines_core instanceof DispatchedContinuation) && b(i) == b(dispatchedTask.resumeMode)) {
            CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) delegate$kotlinx_coroutines_core).dispatcher;
            CoroutineContext context = delegate$kotlinx_coroutines_core.getContext();
            if (coroutineDispatcher.isDispatchNeeded(context)) {
                coroutineDispatcher.dispatch(context, dispatchedTask);
                return;
            } else {
                e(dispatchedTask);
                return;
            }
        }
        d(dispatchedTask, delegate$kotlinx_coroutines_core, z);
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final <T> void d(@NotNull DispatchedTask<? super T> dispatchedTask, @NotNull Continuation<? super T> continuation, boolean z) {
        Object successfulResult$kotlinx_coroutines_core;
        Object takeState$kotlinx_coroutines_core = dispatchedTask.takeState$kotlinx_coroutines_core();
        Throwable exceptionalResult$kotlinx_coroutines_core = dispatchedTask.getExceptionalResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        if (exceptionalResult$kotlinx_coroutines_core != null) {
            Result.a aVar = Result.Companion;
            successfulResult$kotlinx_coroutines_core = i32.a(exceptionalResult$kotlinx_coroutines_core);
        } else {
            Result.a aVar2 = Result.Companion;
            successfulResult$kotlinx_coroutines_core = dispatchedTask.getSuccessfulResult$kotlinx_coroutines_core(takeState$kotlinx_coroutines_core);
        }
        Object m1271constructorimpl = Result.m1271constructorimpl(successfulResult$kotlinx_coroutines_core);
        if (z) {
            Objects.requireNonNull(continuation, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T>");
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            CoroutineContext context = dispatchedContinuation.getContext();
            Object c = ThreadContextKt.c(context, dispatchedContinuation.countOrElement);
            try {
                dispatchedContinuation.continuation.resumeWith(m1271constructorimpl);
                wt2 wt2Var = wt2.INSTANCE;
                return;
            } finally {
                ThreadContextKt.a(context, c);
            }
        }
        continuation.resumeWith(m1271constructorimpl);
    }

    private static final void e(DispatchedTask<?> dispatchedTask) {
        kotlinx.coroutines.m b = pm2.INSTANCE.b();
        if (b.isUnconfinedLoopActive()) {
            b.dispatchUnconfined(dispatchedTask);
            return;
        }
        b.incrementUseCount(true);
        try {
            d(dispatchedTask, dispatchedTask.getDelegate$kotlinx_coroutines_core(), true);
            do {
            } while (b.processUnconfinedEvent());
        } finally {
            try {
            } finally {
            }
        }
    }
}
