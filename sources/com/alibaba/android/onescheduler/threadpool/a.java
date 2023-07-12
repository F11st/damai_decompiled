package com.alibaba.android.onescheduler.threadpool;

import com.alibaba.android.onescheduler.TaskType;
import com.alibaba.android.onescheduler.utils.OneSchedulerException;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import tb.mu1;
import tb.ng0;
import tb.tf0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class a implements ListeningExecutorService {
    private ListeningExecutorService a;
    private ListeningExecutorService b;
    private int c;
    private PriorityBlockingQueue d;
    private TaskType e;
    private int f;

    public a(ng0 ng0Var, TaskType taskType) {
        this.e = taskType;
        this.f = ng0Var.c();
        ThreadFactory e = ng0Var.e() != null ? ng0Var.e() : Executors.defaultThreadFactory();
        this.d = new PriorityBlockingQueue(11, new mu1());
        this.c = ng0Var.d() > 0 ? ng0Var.d() : Integer.MAX_VALUE;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(ng0Var.a(), this.f, ng0Var.b(), TimeUnit.MILLISECONDS, this.d, e);
        threadPoolExecutor.allowCoreThreadTimeOut(ng0Var.f());
        this.a = MoreExecutors.c(threadPoolExecutor);
        this.b = a(e);
    }

    private ListeningExecutorService a(ThreadFactory threadFactory) {
        return MoreExecutors.c(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory));
    }

    private boolean b() {
        return this.d.size() >= this.c;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable != null && (runnable instanceof PriorityFutureTask)) {
            this.a.execute(runnable);
            if (b()) {
                tf0.a().g(this.e, this.f);
                Runnable runnable2 = (Runnable) this.d.poll();
                if (runnable2 != null) {
                    this.b.execute(runnable2);
                    return;
                }
                return;
            }
            return;
        }
        throw new OneSchedulerException("Runnable is not valid");
    }

    @Override // com.google.common.util.concurrent.ListeningExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
        this.b.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        this.b.shutdown();
        return this.a.shutdownNow();
    }

    @Override // com.google.common.util.concurrent.ListeningExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // java.util.concurrent.ExecutorService
    public ListenableFuture<?> submit(Runnable runnable) {
        throw new OneSchedulerException("This api is not implemented");
    }

    @Override // com.google.common.util.concurrent.ListeningExecutorService, java.util.concurrent.ExecutorService
    public <T> ListenableFuture<T> submit(Runnable runnable, T t) {
        throw new OneSchedulerException("This api is not implemented");
    }
}
