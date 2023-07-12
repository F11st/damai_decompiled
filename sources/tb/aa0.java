package tb;

import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.ThreadContextKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class aa0 {
    private static final kj2 a = new kj2("UNDEFINED");
    @JvmField
    @NotNull
    public static final kj2 REUSABLE_CLAIMED = new kj2("REUSABLE_CLAIMED");

    @InternalCoroutinesApi
    public static final <T> void b(@NotNull Continuation<? super T> continuation, @NotNull Object obj, @Nullable Function1<? super Throwable, wt2> function1) {
        boolean z;
        if (continuation instanceof DispatchedContinuation) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Object b = dm.b(obj, function1);
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(dispatchedContinuation.getContext())) {
                dispatchedContinuation._state = b;
                dispatchedContinuation.resumeMode = 1;
                dispatchedContinuation.dispatcher.dispatch(dispatchedContinuation.getContext(), dispatchedContinuation);
                return;
            }
            k40.a();
            kotlinx.coroutines.m b2 = pm2.INSTANCE.b();
            if (b2.isUnconfinedLoopActive()) {
                dispatchedContinuation._state = b;
                dispatchedContinuation.resumeMode = 1;
                b2.dispatchUnconfined(dispatchedContinuation);
                return;
            }
            b2.incrementUseCount(true);
            try {
                Job job = (Job) dispatchedContinuation.getContext().get(Job.Key);
                if (job == null || job.isActive()) {
                    z = false;
                } else {
                    CancellationException cancellationException = job.getCancellationException();
                    dispatchedContinuation.cancelCompletedResult$kotlinx_coroutines_core(b, cancellationException);
                    Result.a aVar = Result.Companion;
                    dispatchedContinuation.resumeWith(Result.m1271constructorimpl(i32.a(cancellationException)));
                    z = true;
                }
                if (!z) {
                    CoroutineContext context = dispatchedContinuation.getContext();
                    Object c = ThreadContextKt.c(context, dispatchedContinuation.countOrElement);
                    dispatchedContinuation.continuation.resumeWith(obj);
                    wt2 wt2Var = wt2.INSTANCE;
                    ThreadContextKt.a(context, c);
                }
                do {
                } while (b2.processUnconfinedEvent());
            } finally {
                try {
                    return;
                } finally {
                }
            }
            return;
        }
        continuation.resumeWith(obj);
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }

    public static final boolean d(@NotNull DispatchedContinuation<? super wt2> dispatchedContinuation) {
        wt2 wt2Var = wt2.INSTANCE;
        k40.a();
        kotlinx.coroutines.m b = pm2.INSTANCE.b();
        if (b.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (b.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = wt2Var;
            dispatchedContinuation.resumeMode = 1;
            b.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        b.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (b.processUnconfinedEvent());
        } finally {
            try {
                return false;
            } finally {
            }
        }
        return false;
    }
}
