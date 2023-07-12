package tb;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final /* synthetic */ class e61 {
    @NotNull
    public static final CompletableJob a(@Nullable Job job) {
        return new c61(job);
    }

    public static /* synthetic */ CompletableJob b(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return d61.a(job);
    }

    public static final void c(@NotNull CoroutineContext coroutineContext, @Nullable CancellationException cancellationException) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            job.cancel(cancellationException);
        }
    }

    public static /* synthetic */ void d(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        d61.c(coroutineContext, cancellationException);
    }

    @NotNull
    public static final DisposableHandle e(@NotNull Job job, @NotNull DisposableHandle disposableHandle) {
        return job.invokeOnCompletion(new ia0(job, disposableHandle));
    }

    public static final void f(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            d61.g(job);
        }
    }

    public static final void g(@NotNull Job job) {
        if (!job.isActive()) {
            throw job.getCancellationException();
        }
    }

    @NotNull
    public static final Job h(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        if (job != null) {
            return job;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + coroutineContext).toString());
    }

    public static final boolean i(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.Key);
        return job != null && job.isActive();
    }
}
