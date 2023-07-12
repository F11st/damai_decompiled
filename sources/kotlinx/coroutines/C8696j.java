package kotlinx.coroutines;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ed0;
import tb.n40;
import tb.n50;
import tb.ty1;
import tb.wt2;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.j */
/* loaded from: classes8.dex */
public final class C8696j {
    @Nullable
    public static final Object a(long j, @NotNull Continuation<? super wt2> continuation) {
        Continuation c;
        Object d;
        if (j <= 0) {
            return wt2.INSTANCE;
        }
        c = IntrinsicsKt__IntrinsicsJvmKt.c(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c, 1);
        cancellableContinuationImpl.initCancellability();
        if (j < AbsPerformance.LONG_NIL) {
            b(cancellableContinuationImpl.getContext()).scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        d = C8234b.d();
        if (result == d) {
            n40.c(continuation);
        }
        return result;
    }

    @NotNull
    public static final Delay b(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext.Element element = coroutineContext.get(ContinuationInterceptor.Key);
        if (!(element instanceof Delay)) {
            element = null;
        }
        Delay delay = (Delay) element;
        return delay != null ? delay : n50.a();
    }

    @ExperimentalTime
    public static final long c(double d) {
        long b;
        if (ed0.compareTo-LRDsOJo(d, ed0.Companion.getZERO-UwyO8pc()) > 0) {
            b = ty1.b(ed0.toLongMilliseconds-impl(d), 1L);
            return b;
        }
        return 0L;
    }
}
