package tb;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class n23 {
    public static final void a(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null && !job.isActive()) {
            throw job.getCancellationException();
        }
    }

    @Nullable
    public static final Object b(@NotNull Continuation<? super wt2> continuation) {
        Continuation c;
        Object obj;
        Object d;
        Object d2;
        CoroutineContext context = continuation.getContext();
        a(context);
        c = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        if (!(c instanceof DispatchedContinuation)) {
            c = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) c;
        if (dispatchedContinuation != null) {
            if (dispatchedContinuation.dispatcher.isDispatchNeeded(context)) {
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(context, wt2.INSTANCE);
            } else {
                m23 m23Var = new m23();
                CoroutineContext plus = context.plus(m23Var);
                obj = wt2.INSTANCE;
                dispatchedContinuation.dispatchYield$kotlinx_coroutines_core(plus, obj);
                if (m23Var.a) {
                    if (aa0.d(dispatchedContinuation)) {
                        obj = kotlin.coroutines.intrinsics.b.d();
                    }
                }
            }
            obj = kotlin.coroutines.intrinsics.b.d();
        } else {
            obj = wt2.INSTANCE;
        }
        d = kotlin.coroutines.intrinsics.b.d();
        if (obj == d) {
            n40.c(continuation);
        }
        d2 = kotlin.coroutines.intrinsics.b.d();
        return obj == d2 ? obj : wt2.INSTANCE;
    }
}
