package com.taobao.android.task;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.taobao.windvane.cache.WVFileInfo;
import android.util.Log;
import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Coordinator {
    public static final int QUEUE_PRIORITY_DECODE_IMAGE = 27;
    public static final int QUEUE_PRIORITY_EMERGENCY = 10;
    public static final int QUEUE_PRIORITY_IMPORTANT = 20;
    public static final int QUEUE_PRIORITY_LOWER = 50;
    public static final int QUEUE_PRIORITY_NORMAL = 30;
    public static final int QUEUE_PRIORITY_NORMAL_DOWNLOAD = 35;
    public static final int QUEUE_PRIORITY_ON_IDLE = 100;
    public static final int QUEUE_PRIORITY_PATCH_DOWNLOAD = 21;
    public static final int QUEUE_PRIORITY_REQUEST_DATA = 23;
    public static final int QUEUE_PRIORITY_REQUEST_IMAGE = 28;
    public static final int QUEUE_PRIORITY_UNIMPORTANT = 90;
    protected static final String TAG = "Coord";
    protected static final Queue<TaggedRunnable> mIdleTasks = new LinkedList();
    protected static final BlockingQueue<Runnable> mPoolWorkQueue;
    protected static Handler sHandler;
    static ThreadInfoListener sThreadInfoListener;
    static CoordThreadPoolExecutor sThreadPoolExecutor;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class CoordThreadPoolExecutor extends ThreadPoolExecutor {
        public CoordThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
            super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        @TargetApi(11)
        protected void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            if (runnable instanceof StandaloneTask) {
                Runnable runnable2 = ((StandaloneTask) runnable).mRunnable;
                if (runnable2 instanceof TaggedRunnable) {
                    TaggedRunnable taggedRunnable = (TaggedRunnable) runnable2;
                    if (Build.VERSION.SDK_INT >= 14) {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            }
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            if (runnable instanceof StandaloneTask) {
                StandaloneTask standaloneTask = (StandaloneTask) runnable;
                Runnable runnable2 = standaloneTask.mRunnable;
                if (runnable2 instanceof TaggedRunnable) {
                    TaggedRunnable taggedRunnable = (TaggedRunnable) runnable2;
                    thread.setName(taggedRunnable.toString());
                    if (Build.VERSION.SDK_INT >= 14) {
                        TrafficStats.setThreadStatsTag(taggedRunnable.mTraffictag);
                        return;
                    }
                    return;
                }
                thread.setName(standaloneTask.mRunnable + "");
                return;
            }
            thread.setName(runnable + "");
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
    /* loaded from: classes12.dex */
    public static class CoordinatorRejectHandler implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Object[] array = Coordinator.mPoolWorkQueue.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append(jn1.ARRAY_START);
            for (Object obj : array) {
                if (obj.getClass().isAnonymousClass()) {
                    sb.append(Coordinator.getOuterClass(obj));
                    sb.append(WVFileInfo.DIVISION);
                    sb.append(' ');
                } else {
                    sb.append(obj);
                    sb.append('>');
                    sb.append(' ');
                }
            }
            sb.append(jn1.ARRAY_END);
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString() + " in " + sb.toString());
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface PriorityQueue {
        int getQueuePriority();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class StandaloneTask implements PriorityQueue, Runnable {
        int mPriorityQueue = 30;
        final Runnable mRunnable;

        public StandaloneTask(Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // com.taobao.android.task.Coordinator.PriorityQueue
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

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface ThreadInfoListener {
        void threadInfo(int i, String str, long j, long j2, long j3, String str2, int i2, ThreadPoolExecutor threadPoolExecutor);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.task.Coordinator$a */
    /* loaded from: classes12.dex */
    static class ThreadFactoryC6648a implements ThreadFactory {
        ThreadFactoryC6648a() {
            new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            if (runnable instanceof TaggedRunnable) {
                runnable.toString();
            } else {
                runnable.getClass();
            }
            return new Thread(runnable, Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + runnable.getClass().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.task.Coordinator$b */
    /* loaded from: classes12.dex */
    public static class HandlerC6649b extends Handler {
        HandlerC6649b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Coordinator.sThreadPoolExecutor.execute((StandaloneTask) message.obj);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.task.Coordinator$c */
    /* loaded from: classes12.dex */
    static class C6650c implements MessageQueue.IdleHandler {
        C6650c() {
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            Queue<TaggedRunnable> queue = Coordinator.mIdleTasks;
            TaggedRunnable poll = queue.poll();
            if (poll == null) {
                return false;
            }
            Coordinator.postTask(poll);
            return !queue.isEmpty();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.task.Coordinator$d */
    /* loaded from: classes12.dex */
    static class C6651d<Runnable> implements Comparator<Runnable> {
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

    static {
        PriorityBlockingQueue priorityBlockingQueue = new PriorityBlockingQueue(100, new C6651d());
        mPoolWorkQueue = priorityBlockingQueue;
        CoordThreadPoolExecutor coordThreadPoolExecutor = new CoordThreadPoolExecutor(8, 16, 1L, TimeUnit.SECONDS, priorityBlockingQueue, new ThreadFactoryC6648a(), new CoordinatorRejectHandler());
        sThreadPoolExecutor = coordThreadPoolExecutor;
        coordThreadPoolExecutor.allowCoreThreadTimeOut(true);
        SaturativeExecutor.installAsDefaultAsyncTaskExecutor(sThreadPoolExecutor);
    }

    protected static void dumpTask() {
        Object[] array = mPoolWorkQueue.toArray();
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START);
        for (Object obj : array) {
            if (obj.getClass().isAnonymousClass()) {
                sb.append(getOuterClass(obj));
                sb.append(WVFileInfo.DIVISION);
                sb.append(' ');
            } else {
                sb.append(obj);
                sb.append('>');
                sb.append(' ');
            }
        }
        sb.append(jn1.ARRAY_END);
        Log.w(TAG, "Task size:" + array.length + " --" + sb.toString());
    }

    public static void execute(Runnable runnable) {
        sThreadPoolExecutor.execute(runnable, 30);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static Executor getDefaultAsyncTaskExecutor() {
        if (Build.VERSION.SDK_INT >= 11) {
            return AsyncTask.SERIAL_EXECUTOR;
        }
        try {
            Field declaredField = AsyncTask.class.getDeclaredField("sExecutor");
            declaredField.setAccessible(true);
            return (Executor) declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ThreadPoolExecutor getDefaultThreadPoolExecutor() {
        return sThreadPoolExecutor;
    }

    protected static Object getOuterClass(Object obj) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("this$0");
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return obj;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return obj;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return obj;
        }
    }

    @Deprecated
    public static void postIdleTask(TaggedRunnable taggedRunnable) {
        mIdleTasks.add(taggedRunnable);
    }

    @Deprecated
    public static void postTask(TaggedRunnable taggedRunnable) {
        postTask(taggedRunnable, Priority.DEFAULT);
    }

    @Deprecated
    public static void removeDelayTask(TaggedRunnable taggedRunnable) {
        Handler handler = sHandler;
        if (handler == null) {
            return;
        }
        handler.removeMessages(taggedRunnable.hashCode());
    }

    @Deprecated
    public static void runTask(TaggedRunnable taggedRunnable) {
        runWithTiming(taggedRunnable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if ((r18 instanceof com.taobao.android.task.Coordinator.PriorityQueue) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        r16 = ((com.taobao.android.task.Coordinator.PriorityQueue) r18).getQueuePriority();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        r16 = 30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        com.taobao.android.task.Coordinator.sThreadInfoListener.threadInfo(r7, r18.getClass().getName(), r9, r11, r13, r18.getClass().getName(), r16, com.taobao.android.task.Coordinator.sThreadPoolExecutor);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a4, code lost:
        if ((r18 instanceof com.taobao.android.task.Coordinator.PriorityQueue) != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static void runWithTiming(java.lang.Runnable r18) {
        /*
            r1 = r18
            com.taobao.android.task.Coordinator$ThreadInfoListener r0 = com.taobao.android.task.Coordinator.sThreadInfoListener
            r2 = 0
            if (r0 == 0) goto L13
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = android.os.Debug.threadCpuTimeNanos()
            r9 = r2
            r2 = r4
            goto L14
        L13:
            r9 = r2
        L14:
            int r7 = android.os.Process.myTid()
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            android.os.Looper r4 = android.os.Looper.myLooper()
            if (r0 == r4) goto L30
            r0 = 10
            boolean r4 = r1 instanceof com.taobao.android.task.Coordinator.TaggedRunnable
            if (r4 == 0) goto L2d
            r0 = r1
            com.taobao.android.task.Coordinator$TaggedRunnable r0 = (com.taobao.android.task.Coordinator.TaggedRunnable) r0
            int r0 = r0.mThreadPriority
        L2d:
            android.os.Process.setThreadPriority(r0)
        L30:
            r4 = 30
            r5 = 1000000(0xf4240, double:4.940656E-318)
            r18.run()     // Catch: java.lang.Throwable -> L75
            com.taobao.android.task.Coordinator$ThreadInfoListener r0 = com.taobao.android.task.Coordinator.sThreadInfoListener
            if (r0 == 0) goto La7
            long r11 = android.os.Debug.threadCpuTimeNanos()
            long r11 = r11 - r2
            long r13 = r11 / r5
            long r2 = java.lang.System.currentTimeMillis()
            long r11 = r2 - r9
            com.taobao.android.task.Coordinator$ThreadInfoListener r0 = com.taobao.android.task.Coordinator.sThreadInfoListener
            if (r0 == 0) goto La7
            boolean r0 = r1 instanceof com.taobao.android.task.Coordinator.PriorityQueue
            if (r0 == 0) goto L5b
        L51:
            r0 = r1
            com.taobao.android.task.Coordinator$PriorityQueue r0 = (com.taobao.android.task.Coordinator.PriorityQueue) r0
            int r0 = r0.getQueuePriority()
            r16 = r0
            goto L5d
        L5b:
            r16 = 30
        L5d:
            com.taobao.android.task.Coordinator$ThreadInfoListener r6 = com.taobao.android.task.Coordinator.sThreadInfoListener
            java.lang.Class r0 = r18.getClass()
            java.lang.String r8 = r0.getName()
            java.lang.Class r0 = r18.getClass()
            java.lang.String r15 = r0.getName()
            com.taobao.android.task.Coordinator$CoordThreadPoolExecutor r17 = com.taobao.android.task.Coordinator.sThreadPoolExecutor
            r6.threadInfo(r7, r8, r9, r11, r13, r15, r16, r17)
            goto La7
        L75:
            r0 = move-exception
            r8 = r0
            java.lang.String r0 = "Coord"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            r11.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String r12 = "Throwable in "
            r11.append(r12)     // Catch: java.lang.Throwable -> La8
            r11.append(r1)     // Catch: java.lang.Throwable -> La8
            java.lang.String r11 = r11.toString()     // Catch: java.lang.Throwable -> La8
            android.util.Log.w(r0, r11, r8)     // Catch: java.lang.Throwable -> La8
            com.taobao.android.task.Coordinator$ThreadInfoListener r0 = com.taobao.android.task.Coordinator.sThreadInfoListener
            if (r0 == 0) goto La7
            long r11 = android.os.Debug.threadCpuTimeNanos()
            long r11 = r11 - r2
            long r13 = r11 / r5
            long r2 = java.lang.System.currentTimeMillis()
            long r11 = r2 - r9
            com.taobao.android.task.Coordinator$ThreadInfoListener r0 = com.taobao.android.task.Coordinator.sThreadInfoListener
            if (r0 == 0) goto La7
            boolean r0 = r1 instanceof com.taobao.android.task.Coordinator.PriorityQueue
            if (r0 == 0) goto L5b
            goto L51
        La7:
            return
        La8:
            r0 = move-exception
            com.taobao.android.task.Coordinator$ThreadInfoListener r8 = com.taobao.android.task.Coordinator.sThreadInfoListener
            if (r8 == 0) goto Le5
            long r11 = android.os.Debug.threadCpuTimeNanos()
            long r11 = r11 - r2
            long r13 = r11 / r5
            long r2 = java.lang.System.currentTimeMillis()
            long r11 = r2 - r9
            com.taobao.android.task.Coordinator$ThreadInfoListener r2 = com.taobao.android.task.Coordinator.sThreadInfoListener
            if (r2 == 0) goto Le5
            boolean r2 = r1 instanceof com.taobao.android.task.Coordinator.PriorityQueue
            if (r2 == 0) goto Lcc
            r2 = r1
            com.taobao.android.task.Coordinator$PriorityQueue r2 = (com.taobao.android.task.Coordinator.PriorityQueue) r2
            int r2 = r2.getQueuePriority()
            r16 = r2
            goto Lce
        Lcc:
            r16 = 30
        Lce:
            com.taobao.android.task.Coordinator$ThreadInfoListener r6 = com.taobao.android.task.Coordinator.sThreadInfoListener
            java.lang.Class r2 = r18.getClass()
            java.lang.String r8 = r2.getName()
            java.lang.Class r1 = r18.getClass()
            java.lang.String r15 = r1.getName()
            com.taobao.android.task.Coordinator$CoordThreadPoolExecutor r17 = com.taobao.android.task.Coordinator.sThreadPoolExecutor
            r6.threadInfo(r7, r8, r9, r11, r13, r15, r16, r17)
        Le5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.task.Coordinator.runWithTiming(java.lang.Runnable):void");
    }

    @Deprecated
    public static void scheduleIdleTasks() {
        Looper.myQueue().addIdleHandler(new C6650c());
    }

    public static void setThreadInfoListener(ThreadInfoListener threadInfoListener) {
        sThreadInfoListener = threadInfoListener;
    }

    public static void execute(Runnable runnable, int i) {
        sThreadPoolExecutor.execute(runnable, i);
    }

    @Deprecated
    public static void postTask(TaggedRunnable taggedRunnable, Priority priority) {
        sThreadPoolExecutor.execute(new StandaloneTask(taggedRunnable));
    }

    @Deprecated
    public static void execute(TaggedRunnable taggedRunnable, int i, int i2) {
        StandaloneTask standaloneTask = new StandaloneTask(taggedRunnable);
        if (i < 1) {
            i = 1;
        }
        taggedRunnable.mQueuePriority = i;
        if (i2 > 0) {
            Message obtain = Message.obtain();
            obtain.what = taggedRunnable.hashCode();
            obtain.obj = standaloneTask;
            if (sHandler == null) {
                sHandler = new HandlerC6649b(Looper.getMainLooper());
            }
            sHandler.sendMessageDelayed(obtain, i2);
            return;
        }
        sThreadPoolExecutor.execute(standaloneTask);
    }

    @Deprecated
    public static void postTask(TaggedRunnable taggedRunnable, int i) {
        execute(taggedRunnable, 10, i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class TaggedRunnable implements PriorityQueue, Runnable {
        final String mName;
        int mQueuePriority;
        int mThreadPriority;
        int mTraffictag;

        public TaggedRunnable(String str) {
            this.mTraffictag = 0;
            this.mQueuePriority = 30;
            this.mThreadPriority = 10;
            this.mName = str;
        }

        @Override // com.taobao.android.task.Coordinator.PriorityQueue
        public int getQueuePriority() {
            return this.mQueuePriority;
        }

        public void setThreadPriority(int i) {
            if (i < 1) {
                i = 1;
            }
            this.mThreadPriority = i;
        }

        public void setTrafficTag(int i) {
            this.mTraffictag = i;
        }

        public String toString() {
            return getClass().getName() + '@' + this.mName;
        }

        public TaggedRunnable(String str, int i) {
            this.mTraffictag = 0;
            this.mQueuePriority = 30;
            this.mThreadPriority = 10;
            this.mName = str;
            if (i < 0) {
                i = 0;
            } else if (i > 100) {
                i = 100;
            }
            this.mQueuePriority = i;
        }
    }

    @Deprecated
    public static void postTask(TaggedRunnable taggedRunnable, Priority priority, int i) {
        execute(taggedRunnable, 10, i);
    }
}
