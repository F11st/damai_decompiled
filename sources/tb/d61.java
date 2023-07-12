package tb;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class d61 {
    @NotNull
    public static final CompletableJob a(@Nullable Job job) {
        return e61.a(job);
    }

    public static final void c(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        e61.c(coroutineContext, cancellationException);
    }

    @NotNull
    public static final DisposableHandle e(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return e61.e(job, disposableHandle);
    }

    public static final void f(@NotNull CoroutineContext coroutineContext) {
        e61.f(coroutineContext);
    }

    public static final void g(@NotNull Job job) {
        e61.g(job);
    }

    @NotNull
    public static final Job h(@NotNull CoroutineContext coroutineContext) {
        return e61.h(coroutineContext);
    }

    public static final boolean i(@NotNull CoroutineContext coroutineContext) {
        return e61.i(coroutineContext);
    }
}
