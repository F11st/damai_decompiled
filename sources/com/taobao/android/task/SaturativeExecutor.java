package com.taobao.android.task;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SaturativeExecutor extends ThreadPoolExecutor {
    private static final boolean DEBUG = false;
    private static final int KEEP_ALIVE = 1;
    private static final int MAX_POOL_SIZE = 128;
    private static final int MIN_THREADS_BEFORE_SATURATION = 3;
    private static final int QUEUE_CAPACITY = 1024;
    static final String TAG = "SatuExec";
    private static SaturationAwareBlockingQueue<Runnable> mQueue;
    private static final Pattern PATTERN_CPU_ENTRIES = Pattern.compile("cpu[0-9]+");
    private static final ThreadFactory sThreadFactory = new ThreadFactoryC6653b();
    private static final HashSet<Thread> mThreads = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CountedTask implements Runnable {
        static final AtomicInteger mNumRunning = new AtomicInteger();
        Runnable mRunnable;

        public CountedTask(Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            AtomicInteger atomicInteger = mNumRunning;
            atomicInteger.incrementAndGet();
            try {
                this.mRunnable.run();
                atomicInteger.decrementAndGet();
            } catch (Throwable th) {
                mNumRunning.decrementAndGet();
                throw th;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    protected static class SaturationAwareBlockingQueue<T> extends LinkedBlockingQueue<T> {
        private static final long serialVersionUID = 1;
        private SaturativeExecutor mExecutor;

        public SaturationAwareBlockingQueue(int i) {
            super(i);
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean add(T t) {
            if (!this.mExecutor.isReallyUnsaturated()) {
                return super.add(t);
            }
            throw new IllegalStateException("Unsaturated");
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(T t) {
            if (this.mExecutor.isReallyUnsaturated()) {
                return false;
            }
            return super.offer(t);
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
        public void put(T t) {
            throw new UnsupportedOperationException();
        }

        void setExecutor(SaturativeExecutor saturativeExecutor) {
            this.mExecutor = saturativeExecutor;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
        public boolean offer(T t, long j, TimeUnit timeUnit) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.task.SaturativeExecutor$a */
    /* loaded from: classes12.dex */
    public static class C6652a implements FileFilter {
        C6652a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return SaturativeExecutor.PATTERN_CPU_ENTRIES.matcher(file.getName()).matches();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.task.SaturativeExecutor$b */
    /* loaded from: classes12.dex */
    static class ThreadFactoryC6653b implements ThreadFactory {
        private final AtomicInteger a = new AtomicInteger(1);

        ThreadFactoryC6653b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "SaturativeThread #" + this.a.getAndIncrement());
            SaturativeExecutor.collectThread(thread);
            return thread;
        }
    }

    public SaturativeExecutor() {
        this(determineBestMinPoolSize());
    }

    protected static void collectThread(Thread thread) {
        HashSet<Thread> hashSet = mThreads;
        synchronized (hashSet) {
            hashSet.add(thread);
        }
    }

    private static int countCpuCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new C6652a()).length;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static int determineBestMinPoolSize() {
        int countCpuCores = countCpuCores();
        return countCpuCores > 0 ? countCpuCores : Runtime.getRuntime().availableProcessors() * 2;
    }

    public static final boolean installAsDefaultAsyncTaskExecutor(ThreadPoolExecutor threadPoolExecutor) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                Field declaredField = AsyncTask.class.getDeclaredField("THREAD_POOL_EXECUTOR");
                declaredField.setAccessible(true);
                declaredField.set(null, threadPoolExecutor);
            } catch (Exception unused) {
                Log.d(TAG, "Failed to install THREAD_POOL_EXECUTOR as default executor of AsyncTask.");
            }
        }
        try {
            try {
                try {
                    Method method = AsyncTask.class.getMethod("setDefaultExecutor", Executor.class);
                    method.setAccessible(true);
                    method.invoke(null, threadPoolExecutor);
                    return true;
                } catch (Exception unused2) {
                    Log.d(TAG, "Failed to install as default executor of AsyncTask.");
                    return false;
                }
            } catch (Exception unused3) {
                Field declaredField2 = AsyncTask.class.getDeclaredField("sExecutor");
                declaredField2.setAccessible(true);
                declaredField2.set(null, threadPoolExecutor);
                return true;
            }
        } catch (Exception unused4) {
            Field declaredField3 = AsyncTask.class.getDeclaredField("sDefaultExecutor");
            declaredField3.setAccessible(true);
            declaredField3.set(null, threadPoolExecutor);
            return true;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        super.execute(new CountedTask(runnable));
    }

    protected boolean isReallyUnsaturated() {
        if (isSaturated()) {
            return false;
        }
        LockSupport.parkNanos(10L);
        return !isSaturated();
    }

    protected boolean isSaturated() {
        int i;
        if (getPoolSize() <= 3) {
            return false;
        }
        int corePoolSize = getCorePoolSize();
        int i2 = CountedTask.mNumRunning.get();
        HashSet<Thread> hashSet = mThreads;
        int size = hashSet.size();
        if (i2 < corePoolSize || i2 < size) {
            return true;
        }
        synchronized (hashSet) {
            Iterator<Thread> it = hashSet.iterator();
            i = 0;
            while (it.hasNext()) {
                Thread.State state = it.next().getState();
                if (state != Thread.State.RUNNABLE && state != Thread.State.NEW) {
                    if (state == Thread.State.TERMINATED) {
                        it.remove();
                    }
                }
                i++;
            }
        }
        return i >= corePoolSize;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SaturativeExecutor(int r10) {
        /*
            r9 = this;
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            com.taobao.android.task.SaturativeExecutor$SaturationAwareBlockingQueue r6 = new com.taobao.android.task.SaturativeExecutor$SaturationAwareBlockingQueue
            r0 = 1024(0x400, float:1.435E-42)
            r6.<init>(r0)
            com.taobao.android.task.SaturativeExecutor.mQueue = r6
            java.util.concurrent.ThreadFactory r7 = com.taobao.android.task.SaturativeExecutor.sThreadFactory
            java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy r8 = new java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy
            r8.<init>()
            r2 = 128(0x80, float:1.8E-43)
            r3 = 1
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r5, r6, r7, r8)
            java.util.concurrent.BlockingQueue r10 = r9.getQueue()
            com.taobao.android.task.SaturativeExecutor$SaturationAwareBlockingQueue r10 = (com.taobao.android.task.SaturativeExecutor.SaturationAwareBlockingQueue) r10
            r10.setExecutor(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.task.SaturativeExecutor.<init>(int):void");
    }
}
