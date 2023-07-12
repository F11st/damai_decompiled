package org.apache.commons.lang3.concurrent;

import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    private static final int THREAD_POOL_SIZE = 1;
    private int acquireCount;
    private final ScheduledExecutorService executorService;
    private int lastCallsPerPeriod;
    private int limit;
    private final boolean ownExecutor;
    private final long period;
    private long periodCount;
    private boolean shutdown;
    private ScheduledFuture<?> task;
    private long totalAcquireCount;
    private final TimeUnit unit;

    public TimedSemaphore(long j, TimeUnit timeUnit, int i) {
        this(null, j, timeUnit, i);
    }

    private boolean acquirePermit() {
        if (getLimit() <= 0 || this.acquireCount < getLimit()) {
            this.acquireCount++;
            return true;
        }
        return false;
    }

    private void prepareAcquire() {
        if (!isShutdown()) {
            if (this.task == null) {
                this.task = startTimer();
                return;
            }
            return;
        }
        throw new IllegalStateException("TimedSemaphore is shut down!");
    }

    public synchronized void acquire() throws InterruptedException {
        boolean acquirePermit;
        prepareAcquire();
        do {
            acquirePermit = acquirePermit();
            if (!acquirePermit) {
                wait();
                continue;
            }
        } while (!acquirePermit);
    }

    synchronized void endOfPeriod() {
        int i = this.acquireCount;
        this.lastCallsPerPeriod = i;
        this.totalAcquireCount += i;
        this.periodCount++;
        this.acquireCount = 0;
        notifyAll();
    }

    public synchronized int getAcquireCount() {
        return this.acquireCount;
    }

    public synchronized int getAvailablePermits() {
        return getLimit() - getAcquireCount();
    }

    public synchronized double getAverageCallsPerPeriod() {
        long j;
        j = this.periodCount;
        return j == 0 ? 0.0d : this.totalAcquireCount / j;
    }

    protected ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public synchronized int getLastAcquiresPerPeriod() {
        return this.lastCallsPerPeriod;
    }

    public final synchronized int getLimit() {
        return this.limit;
    }

    public long getPeriod() {
        return this.period;
    }

    public TimeUnit getUnit() {
        return this.unit;
    }

    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    public final synchronized void setLimit(int i) {
        this.limit = i;
    }

    public synchronized void shutdown() {
        if (!this.shutdown) {
            if (this.ownExecutor) {
                getExecutorService().shutdownNow();
            }
            ScheduledFuture<?> scheduledFuture = this.task;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.shutdown = true;
        }
    }

    protected ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() { // from class: org.apache.commons.lang3.concurrent.TimedSemaphore.1
            @Override // java.lang.Runnable
            public void run() {
                TimedSemaphore.this.endOfPeriod();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }

    public synchronized boolean tryAcquire() {
        prepareAcquire();
        return acquirePermit();
    }

    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit, int i) {
        Validate.inclusiveBetween(1L, (long) AbsPerformance.LONG_NIL, j, "Time period must be greater than 0!");
        this.period = j;
        this.unit = timeUnit;
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            this.ownExecutor = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.executorService = scheduledThreadPoolExecutor;
            this.ownExecutor = true;
        }
        setLimit(i);
    }
}
