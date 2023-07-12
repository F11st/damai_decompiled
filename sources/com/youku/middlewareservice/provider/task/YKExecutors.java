package com.youku.middlewareservice.provider.task;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class YKExecutors {
    private static final long DEFAULT_KEEP_ALIVE = 30000;
    private static final int MAX_POOL_SIZE;
    private static final int MIN_POOL_SIZE = 1;
    private static final int NCPU;
    private static ExecutorService executorService;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    private static class DelegatedExecutorService extends AbstractExecutorService {
        private final ExecutorService executor;

        DelegatedExecutorService(ExecutorService executorService) {
            this.executor = executorService;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.executor.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.executor.execute(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.executor.invokeAll(collection);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            return (T) this.executor.invokeAny(collection);
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            return this.executor.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            return this.executor.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.executor.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            return this.executor.shutdownNow();
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public Future<?> submit(Runnable runnable) {
            return this.executor.submit(runnable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
            return this.executor.invokeAll(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (T) this.executor.invokeAny(collection, j, timeUnit);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Callable<T> callable) {
            return this.executor.submit(callable);
        }

        @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.executor.submit(runnable, t);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        FinalizableDelegatedExecutorService(ExecutorService executorService) {
            super(executorService);
        }

        protected void finalize() {
            super.shutdown();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        NCPU = availableProcessors;
        MAX_POOL_SIZE = (availableProcessors << 1) + 1;
        executorService = new YKExecutorService("default_group", (availableProcessors * 2) + 1, (availableProcessors * 2) + 1, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
    }

    public static ThreadFactory defaultThreadFactory(String str) {
        return new NamedThreadFactory(str);
    }

    public static ExecutorService newCachedThreadPool() {
        return executorService;
    }

    public static ExecutorService newFixedThreadPool(int i) {
        return executorService;
    }

    public static ExecutorService newOptimizedCachedThreadPool() {
        return executorService;
    }

    public static ExecutorService newOptimizedFixedThreadPool(int i) {
        return executorService;
    }

    public static ScheduledExecutorService newOptimizedScheduledThreadPool(int i) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Math.min(Math.max(1, i), MAX_POOL_SIZE), new NamedThreadFactory("default_group"));
        scheduledThreadPoolExecutor.setKeepAliveTime(DEFAULT_KEEP_ALIVE, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    public static ExecutorService newOptimizedSingleThreadExecutor() {
        return executorService;
    }

    public static ScheduledExecutorService newOptimizedSingleThreadScheduledExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("default_group"));
        scheduledThreadPoolExecutor.setKeepAliveTime(DEFAULT_KEEP_ALIVE, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    public static ExecutorService newOptimizedWorkStealingPool() {
        return executorService;
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i) {
        return Executors.newScheduledThreadPool(i, new NamedThreadFactory("default_group"));
    }

    public static ExecutorService newSingleThreadExecutor() {
        return executorService;
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor() {
        return Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("default_group"));
    }

    public static ExecutorService newWorkStealingPool() {
        return executorService;
    }

    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        return executorService;
    }

    public static ExecutorService newFixedThreadPool(int i, ThreadFactory threadFactory) {
        return executorService;
    }

    public static ExecutorService newOptimizedCachedThreadPool(ThreadFactory threadFactory) {
        return executorService;
    }

    public static ExecutorService newOptimizedFixedThreadPool(int i, ThreadFactory threadFactory) {
        return executorService;
    }

    public static ExecutorService newOptimizedSingleThreadExecutor(ThreadFactory threadFactory) {
        return executorService;
    }

    public static ExecutorService newOptimizedWorkStealingPool(int i) {
        return executorService;
    }

    public static ScheduledExecutorService newScheduledThreadPool(int i, ThreadFactory threadFactory) {
        return Executors.newScheduledThreadPool(i, new NamedThreadFactory(threadFactory, "default_group"));
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        return executorService;
    }

    public static ScheduledExecutorService newSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        return Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory(threadFactory, "default_group"));
    }

    public static ExecutorService newWorkStealingPool(int i) {
        return executorService;
    }

    public static ScheduledExecutorService newOptimizedScheduledThreadPool(int i, ThreadFactory threadFactory) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Math.min(Math.max(1, i), MAX_POOL_SIZE), new NamedThreadFactory(threadFactory, "default_group"));
        scheduledThreadPoolExecutor.setKeepAliveTime(DEFAULT_KEEP_ALIVE, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    public static ScheduledExecutorService newOptimizedSingleThreadScheduledExecutor(ThreadFactory threadFactory) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory(threadFactory, "default_group"));
        scheduledThreadPoolExecutor.setKeepAliveTime(DEFAULT_KEEP_ALIVE, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }
}
