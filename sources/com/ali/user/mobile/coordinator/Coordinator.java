package com.ali.user.mobile.coordinator;

import android.os.Looper;
import android.os.Process;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Coordinator {
    private static final int CORE_POOL_SIZE = 4;
    private static final int KEEP_ALIVE = 4;
    private static final int MAXIMUM_POOL_SIZE = 32;
    public static final int QUEUE_PRIORITY_NORMAL = 30;
    protected static final String TAG = "Coordinator";
    protected static final BlockingQueue<Runnable> mPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    public static CoordThreadPoolExecutor sThreadPoolExecutor;
    public static ScheduledExecutorService scheduledExecutorService;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public static class CoordThreadPoolExecutor extends ThreadPoolExecutor {
        public CoordThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
            allowCoreThreadTimeOut(true);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            if (runnable instanceof StandaloneTask) {
                thread.setName("login-" + ((StandaloneTask) runnable).mRunnable + "");
                return;
            }
            thread.setName("login-" + runnable + "");
        }

        public void execute(Runnable runnable, int i) {
            if (runnable instanceof StandaloneTask) {
                super.execute(runnable);
                return;
            }
            StandaloneTask standaloneTask = new StandaloneTask(runnable);
            if (i < 1) {
                i = 1;
            }
            standaloneTask.mPriorityQueue = i;
            super.execute(standaloneTask);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    static class PriorityComparator<Runnable> implements Comparator<Runnable> {
        PriorityComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Runnable runnable, Runnable runnable2) {
            if ((runnable instanceof StandaloneTask) && (runnable2 instanceof StandaloneTask)) {
                StandaloneTask standaloneTask = (StandaloneTask) runnable;
                StandaloneTask standaloneTask2 = (StandaloneTask) runnable2;
                if (standaloneTask.getQueuePriority() > standaloneTask2.getQueuePriority()) {
                    return 1;
                }
                return standaloneTask.getQueuePriority() < standaloneTask2.getQueuePriority() ? -1 : 0;
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface PriorityQueue {
        int getQueuePriority();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class StandaloneTask implements PriorityQueue, Runnable {
        int mPriorityQueue = 30;
        final Runnable mRunnable;

        public StandaloneTask(Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // com.ali.user.mobile.coordinator.Coordinator.PriorityQueue
        public int getQueuePriority() {
            Runnable runnable = this.mRunnable;
            if (runnable instanceof PriorityQueue) {
                return ((PriorityQueue) runnable).getQueuePriority();
            }
            return this.mPriorityQueue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Coordinator.runWithTiming(this.mRunnable);
        }
    }

    static {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(100, new PriorityComparator());
        mPoolWorkQueue = priorityBlockingQueue;
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.ali.user.mobile.coordinator.Coordinator.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "login#" + runnable.getClass().getName());
            }
        };
        sThreadFactory = threadFactory;
        sThreadPoolExecutor = new CoordThreadPoolExecutor(4, 32, 4L, TimeUnit.SECONDS, priorityBlockingQueue, threadFactory, new ThreadPoolExecutor.DiscardPolicy());
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    public static void execute(Runnable runnable) {
        sThreadPoolExecutor.execute(runnable, 30);
    }

    protected static void runWithTiming(Runnable runnable) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Process.setThreadPriority(10);
        }
        try {
            runnable.run();
        } finally {
        }
    }

    public static void scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        scheduledExecutorService.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    public static void execute(Runnable runnable, int i) {
        sThreadPoolExecutor.execute(runnable, i);
    }
}
