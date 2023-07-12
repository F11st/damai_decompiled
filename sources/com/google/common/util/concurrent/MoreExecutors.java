package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.h;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class MoreExecutors {

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.MoreExecutors$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ListenableFuture val$future;
        final /* synthetic */ BlockingQueue val$queue;

        AnonymousClass1(BlockingQueue blockingQueue, ListenableFuture listenableFuture) {
            this.val$queue = blockingQueue;
            this.val$future = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$queue.add(this.val$future);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.util.concurrent.MoreExecutors$5  reason: invalid class name */
    /* loaded from: classes10.dex */
    static class AnonymousClass5 implements Executor {
        boolean a = true;
        final /* synthetic */ Executor b;
        final /* synthetic */ AbstractFuture c;

        AnonymousClass5(Executor executor, AbstractFuture abstractFuture) {
            this.b = executor;
            this.c = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(final Runnable runnable) {
            try {
                this.b.execute(new Runnable() { // from class: com.google.common.util.concurrent.MoreExecutors.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass5.this.a = false;
                        runnable.run();
                    }
                });
            } catch (RejectedExecutionException e) {
                if (this.a) {
                    this.c.setException(e);
                }
            }
        }
    }

    /* compiled from: Taobao */
    @GwtIncompatible
    /* loaded from: classes10.dex */
    private static final class ScheduledListeningDecorator extends d implements ListeningScheduledExecutorService {
        final ScheduledExecutorService b;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        @GwtIncompatible
        /* loaded from: classes10.dex */
        public static final class NeverSuccessfulListenableFutureTask extends AbstractFuture.g<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable runnable) {
                this.delegate = (Runnable) du1.p(runnable);
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.delegate.run();
                } catch (Throwable th) {
                    setException(th);
                    throw com.google.common.base.i.e(th);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public static final class a<V> extends h.a<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> b;

            public a(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.b = scheduledFuture;
            }

            @Override // java.lang.Comparable
            /* renamed from: c */
            public int compareTo(Delayed delayed) {
                return this.b.compareTo(delayed);
            }

            @Override // com.google.common.util.concurrent.g, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                boolean cancel = super.cancel(z);
                if (cancel) {
                    this.b.cancel(z);
                }
                return cancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.b.getDelay(timeUnit);
            }
        }

        ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.b = (ScheduledExecutorService) du1.p(scheduledExecutorService);
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new a(neverSuccessfulListenableFutureTask, this.b.scheduleAtFixedRate(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            NeverSuccessfulListenableFutureTask neverSuccessfulListenableFutureTask = new NeverSuccessfulListenableFutureTask(runnable);
            return new a(neverSuccessfulListenableFutureTask, this.b.scheduleWithFixedDelay(neverSuccessfulListenableFutureTask, j, j2, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(runnable, null);
            return new a(create, this.b.schedule(create, j, timeUnit));
        }

        @Override // java.util.concurrent.ScheduledExecutorService
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask create = TrustedListenableFutureTask.create(callable);
            return new a(create, this.b.schedule(create, j, timeUnit));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements Executor {
        final /* synthetic */ Executor a;
        final /* synthetic */ Supplier b;

        a(Executor executor, Supplier supplier) {
            this.a = executor;
            this.b = supplier;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.a.execute(Callables.b(runnable, this.b));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b extends s {
        final /* synthetic */ Supplier c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ScheduledExecutorService scheduledExecutorService, Supplier supplier) {
            super(scheduledExecutorService);
            this.c = supplier;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.r
        public Runnable a(Runnable runnable) {
            return Callables.b(runnable, this.c);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.util.concurrent.r
        public <T> Callable<T> b(Callable<T> callable) {
            return Callables.c(callable, this.c);
        }
    }

    /* compiled from: Taobao */
    @VisibleForTesting
    @GwtIncompatible
    /* loaded from: classes10.dex */
    static class c {
    }

    /* compiled from: Taobao */
    @GwtIncompatible
    /* loaded from: classes10.dex */
    private static class d extends com.google.common.util.concurrent.b {
        private final ExecutorService a;

        d(ExecutorService executorService) {
            this.a = (ExecutorService) du1.p(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.a.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.a.shutdownNow();
        }
    }

    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }

    @GwtIncompatible
    private static boolean b() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @GwtIncompatible
    public static ListeningExecutorService c(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) executorService) : new d(executorService);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static Thread d(String str, Runnable runnable) {
        du1.p(str);
        du1.p(runnable);
        Thread newThread = e().newThread(runnable);
        try {
            newThread.setName(str);
        } catch (SecurityException unused) {
        }
        return newThread;
    }

    @Beta
    @GwtIncompatible
    public static ThreadFactory e() {
        if (!b()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
        } catch (InvocationTargetException e4) {
            throw com.google.common.base.i.e(e4.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor f(Executor executor, AbstractFuture<?> abstractFuture) {
        du1.p(executor);
        du1.p(abstractFuture);
        return executor == a() ? executor : new AnonymousClass5(executor, abstractFuture);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static Executor g(Executor executor, Supplier<String> supplier) {
        du1.p(executor);
        du1.p(supplier);
        return b() ? executor : new a(executor, supplier);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @GwtIncompatible
    public static ScheduledExecutorService h(ScheduledExecutorService scheduledExecutorService, Supplier<String> supplier) {
        du1.p(scheduledExecutorService);
        du1.p(supplier);
        return b() ? scheduledExecutorService : new b(scheduledExecutorService, supplier);
    }
}
