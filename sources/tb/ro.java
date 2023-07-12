package tb;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.C8234b;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.C8694a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ro {
    @NotNull
    public static final CoroutineScope a(@NotNull CoroutineContext coroutineContext) {
        CompletableJob b;
        if (coroutineContext.get(Job.Key) == null) {
            b = e61.b(null, 1, null);
            coroutineContext = coroutineContext.plus(b);
        }
        return new bo(coroutineContext);
    }

    public static final void b(@NotNull CoroutineScope coroutineScope, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineScope.getCoroutineContext().get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + coroutineScope).toString());
    }

    public static /* synthetic */ void c(CoroutineScope coroutineScope, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        b(coroutineScope, cancellationException);
    }

    @Nullable
    public static final <R> Object d(@NotNull Function2<? super CoroutineScope, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super R> continuation) {
        Object d;
        C8694a c8694a = new C8694a(continuation.getContext(), continuation);
        Object e = st2.e(c8694a, c8694a, function2);
        d = C8234b.d();
        if (e == d) {
            n40.c(continuation);
        }
        return e;
    }
}
