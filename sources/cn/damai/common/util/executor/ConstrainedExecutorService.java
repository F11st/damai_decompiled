package cn.damai.common.util.executor;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class ConstrainedExecutorService extends AbstractExecutorService {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a;
    private final Executor b;
    private volatile int c;
    private final BlockingQueue<Runnable> d;
    private final Worker e;
    private final AtomicInteger f;
    private final AtomicInteger g;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public class Worker implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;

        private Worker() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2109091876")) {
                ipChange.ipc$dispatch("2109091876", new Object[]{this});
                return;
            }
            try {
                Runnable runnable = (Runnable) ConstrainedExecutorService.this.d.poll();
                if (runnable != null) {
                    runnable.run();
                }
            } finally {
                ConstrainedExecutorService.this.f.decrementAndGet();
                if (!ConstrainedExecutorService.this.d.isEmpty()) {
                    ConstrainedExecutorService.this.e();
                }
            }
        }
    }

    public ConstrainedExecutorService(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i > 0) {
            this.a = str;
            this.b = executor;
            this.c = i;
            this.d = blockingQueue;
            this.e = new Worker();
            this.f = new AtomicInteger(0);
            this.g = new AtomicInteger(0);
            return;
        }
        throw new IllegalArgumentException("max concurrency must be > 0");
    }

    public static ConstrainedExecutorService d(String str, int i, int i2, Executor executor) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-551024187") ? (ConstrainedExecutorService) ipChange.ipc$dispatch("-551024187", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), executor}) : new ConstrainedExecutorService(str, i, executor, new LinkedBlockingQueue(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "653858079")) {
            ipChange.ipc$dispatch("653858079", new Object[]{this});
            return;
        }
        int i = this.f.get();
        while (i < this.c) {
            if (this.f.compareAndSet(i, i + 1)) {
                this.b.execute(this.e);
                return;
            }
            i = this.f.get();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1328268963")) {
            return ((Boolean) ipChange.ipc$dispatch("1328268963", new Object[]{this, Long.valueOf(j), timeUnit})).booleanValue();
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1833000166")) {
            ipChange.ipc$dispatch("-1833000166", new Object[]{this, runnable});
            return;
        }
        Objects.requireNonNull(runnable, "runnable parameter is null");
        if (this.d.offer(runnable)) {
            int size = this.d.size();
            int i = this.g.get();
            if (size > i) {
                this.g.compareAndSet(i, size);
            }
            e();
            return;
        }
        throw new RejectedExecutionException(this.a + " queue is full, size=" + this.d.size());
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-595847779")) {
            return ((Boolean) ipChange.ipc$dispatch("-595847779", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "401193008")) {
            return ((Boolean) ipChange.ipc$dispatch("401193008", new Object[]{this})).booleanValue();
        }
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        IpChange ipChange = $ipChange;
        if (!AndroidInstantRuntime.support(ipChange, "-348153309")) {
            throw new UnsupportedOperationException();
        }
        ipChange.ipc$dispatch("-348153309", new Object[]{this});
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "940203670")) {
            return (List) ipChange.ipc$dispatch("940203670", new Object[]{this});
        }
        throw new UnsupportedOperationException();
    }
}
