package mtopsdk.mtop.util;

import android.os.Process;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopSDKThreadPoolExecutorFactory {
    private static final int CALLBACK_CORE_POOL_SIZE = 2;
    private static final int CALLBACK_KEEP_ALIVE_TIME = 20;
    private static final int DEFAULT_CORE_POOL_SIZE = 3;
    private static final int KEEP_ALIVE_TIME = 60;
    private static final int QUEENSIZE = 128;
    private static final int REQUEST_CORE_POOL_SIZE = 4;
    private static final String TAG = "mtopsdk.MtopSDKThreadPoolExecutorFactory";
    private static volatile ThreadPoolExecutor callbackExecutors = null;
    private static volatile ExecutorService[] callbackOldExecutors = null;
    private static int priority = 10;
    private static volatile ThreadPoolExecutor requestExecutor;
    private static volatile ThreadPoolExecutor threadPoolExecutor;

    public static ThreadPoolExecutor createExecutor(int i, int i2, int i3, int i4, ThreadFactory threadFactory) {
        LinkedBlockingQueue linkedBlockingQueue;
        if (i4 > 0) {
            linkedBlockingQueue = new LinkedBlockingQueue(i4);
        } else {
            linkedBlockingQueue = new LinkedBlockingQueue();
        }
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(i, i2, i3, TimeUnit.SECONDS, linkedBlockingQueue, threadFactory);
        if (i3 > 0) {
            threadPoolExecutor2.allowCoreThreadTimeOut(true);
        }
        return threadPoolExecutor2;
    }

    public static ExecutorService[] getCallbackExecutorServices() {
        if (RemoteConfig.getInstance().enableNewExecutor) {
            if (callbackExecutors == null) {
                synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                    if (callbackExecutors == null) {
                        callbackExecutors = createExecutor(2, 2, 20, 0, new MtopSDKThreadFactory(priority, "CallbackPool"));
                    }
                }
            }
            return new ExecutorService[]{callbackExecutors};
        }
        if (callbackOldExecutors == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                if (callbackOldExecutors == null) {
                    ExecutorService[] executorServiceArr = new ExecutorService[2];
                    for (int i = 0; i < 2; i++) {
                        int i2 = priority;
                        executorServiceArr[i] = createExecutor(1, 1, 60, 0, new MtopSDKThreadFactory(i2, "CallbackPool" + i));
                    }
                    callbackOldExecutors = executorServiceArr;
                }
            }
        }
        return callbackOldExecutors;
    }

    public static ThreadPoolExecutor getDefaultThreadPoolExecutor() {
        if (threadPoolExecutor == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = createExecutor(3, 3, 60, 128, new MtopSDKThreadFactory(priority));
                }
            }
        }
        return threadPoolExecutor;
    }

    public static ThreadPoolExecutor getRequestThreadPoolExecutor() {
        if (requestExecutor == null) {
            synchronized (MtopSDKThreadPoolExecutorFactory.class) {
                if (requestExecutor == null) {
                    requestExecutor = createExecutor(4, 4, 60, 0, new MtopSDKThreadFactory(priority, "RequestPool"));
                }
            }
        }
        return requestExecutor;
    }

    public static void setCallbackExecutorServices(ExecutorService[] executorServiceArr) {
        if (executorServiceArr == null || executorServiceArr.length <= 0) {
            return;
        }
        if (RemoteConfig.getInstance().enableNewExecutor) {
            callbackExecutors = (ThreadPoolExecutor) executorServiceArr[0];
        } else {
            callbackOldExecutors = executorServiceArr;
        }
    }

    public static void setDefaultThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor2) {
        if (threadPoolExecutor2 != null) {
            threadPoolExecutor = threadPoolExecutor2;
        }
    }

    public static void setRequestThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor2) {
        if (threadPoolExecutor2 != null) {
            requestExecutor = threadPoolExecutor2;
        }
    }

    public static Future<?> submit(Runnable runnable) {
        try {
            return getDefaultThreadPoolExecutor().submit(runnable);
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[submit]submit runnable to Mtop Default ThreadPool error ---" + th.toString());
            return null;
        }
    }

    public static Future<?> submitCallbackTask(int i, Runnable runnable) {
        Future<?> submit;
        try {
            if (RemoteConfig.getInstance().enableNewExecutor) {
                submit = getCallbackExecutorServices()[0].submit(runnable);
            } else {
                ExecutorService[] callbackExecutorServices = getCallbackExecutorServices();
                submit = callbackExecutorServices[Math.abs(i % callbackExecutorServices.length)].submit(runnable);
            }
            return submit;
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[submitCallbackTask]submit runnable to Mtop Callback ThreadPool error ---" + th.toString());
            return null;
        }
    }

    public static Future<?> submitRequestTask(Runnable runnable) {
        try {
            return getRequestThreadPoolExecutor().submit(runnable);
        } catch (Throwable th) {
            TBSdkLog.e(TAG, "[submitRequestTask]submit runnable to Mtop Request ThreadPool error ---" + th.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class MtopSDKThreadFactory implements ThreadFactory {
        private final AtomicInteger mCount;
        int priority;
        private String type;

        public MtopSDKThreadFactory(int i) {
            this.priority = 10;
            this.mCount = new AtomicInteger();
            this.type = "";
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("MTOPSDK ");
            if (StringUtils.isNotBlank(this.type)) {
                sb.append(this.type);
                sb.append(" ");
            } else {
                sb.append("DefaultPool ");
            }
            sb.append("Thread:");
            sb.append(this.mCount.getAndIncrement());
            return new Thread(runnable, sb.toString()) { // from class: mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory.MtopSDKThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        Process.setThreadPriority(MtopSDKThreadFactory.this.priority);
                    } catch (Throwable th) {
                        TBSdkLog.e(MtopSDKThreadPoolExecutorFactory.TAG, "[run]Thread set thread priority error ---" + th.toString());
                    }
                    try {
                        super.run();
                    } catch (Throwable th2) {
                        TBSdkLog.e(MtopSDKThreadPoolExecutorFactory.TAG, "[run]Thread run error ---" + th2.toString());
                    }
                }
            };
        }

        public MtopSDKThreadFactory(int i, String str) {
            this.priority = 10;
            this.mCount = new AtomicInteger();
            this.type = "";
            this.priority = i;
            this.type = str;
        }
    }
}
