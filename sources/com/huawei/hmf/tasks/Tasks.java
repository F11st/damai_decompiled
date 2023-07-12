package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.C5503i;
import com.huawei.hmf.tasks.a.C5504j;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Tasks {
    private static C5504j IMPL = new C5504j();

    public static Task<List<Task<?>>> allOf(Collection<? extends Task<?>> collection) {
        return C5504j.a(collection);
    }

    public static Task<List<Task<?>>> allOf(Task<?>... taskArr) {
        return C5504j.a((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    public static <TResult> TResult await(Task<TResult> task) throws ExecutionException, InterruptedException {
        C5504j.a("await must not be called on the UI thread");
        if (task.isComplete()) {
            return (TResult) C5504j.a((Task<Object>) task);
        }
        C5504j.C5505a c5505a = new C5504j.C5505a();
        task.addOnSuccessListener(c5505a).addOnFailureListener(c5505a);
        c5505a.a.await();
        return (TResult) C5504j.a((Task<Object>) task);
    }

    public static <TResult> TResult await(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C5504j.a("await must not be called on the UI thread");
        if (!task.isComplete()) {
            C5504j.C5505a c5505a = new C5504j.C5505a();
            task.addOnSuccessListener(c5505a).addOnFailureListener(c5505a);
            if (!c5505a.a.await(j, timeUnit)) {
                throw new TimeoutException("Timed out waiting for Task");
            }
        }
        return (TResult) C5504j.a((Task<Object>) task);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> callable) {
        return IMPL.a(TaskExecutors.immediate(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return IMPL.a(TaskExecutors.background(), callable);
    }

    public static <TResult> Task<TResult> callInBackground(Executor executor, Callable<TResult> callable) {
        return IMPL.a(executor, callable);
    }

    public static <TResult> Task<TResult> fromCanceled() {
        C5503i c5503i = new C5503i();
        c5503i.a();
        return c5503i;
    }

    public static <TResult> Task<TResult> fromException(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setException(exc);
        return taskCompletionSource.getTask();
    }

    public static <TResult> Task<TResult> fromResult(TResult tresult) {
        return C5504j.a(tresult);
    }

    public static Task<Void> join(Collection<? extends Task<?>> collection) {
        return C5504j.c(collection);
    }

    public static Task<Void> join(Task<?>... taskArr) {
        return C5504j.c(Arrays.asList(taskArr));
    }

    public static <TResult> Task<List<TResult>> successOf(Collection<? extends Task<TResult>> collection) {
        return C5504j.b(collection);
    }

    public static <TResult> Task<List<TResult>> successOf(Task<?>... taskArr) {
        return C5504j.b(Arrays.asList(taskArr));
    }
}
