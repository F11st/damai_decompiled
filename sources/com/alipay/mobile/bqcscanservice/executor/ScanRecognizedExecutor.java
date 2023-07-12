package com.alipay.mobile.bqcscanservice.executor;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import androidx.annotation.NonNull;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ScanRecognizedExecutor {
    public static final String TAG = "ScanExecutor";
    private static ThreadPoolExecutor a = null;
    private static HandlerThread b = null;
    private static Handler c = null;
    private static boolean d = true;
    private static volatile long e;
    private static ReentrantLock f = new ReentrantLock();
    private static RecognizeExecutorCallback g;
    public static volatile boolean sUseNewExecutor;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface RecognizeExecutorCallback {
        void onBeforeRecognize();

        void onEndRecognize();
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static class RecognizeRunnable implements Runnable {
        private boolean enableMonitor;
        private Runnable runnable;

        RecognizeRunnable(Runnable runnable, boolean z) {
            this.runnable = runnable;
            this.enableMonitor = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.runnable != null) {
                if (this.enableMonitor) {
                    try {
                        if (ScanRecognizedExecutor.g != null) {
                            ScanRecognizedExecutor.g.onBeforeRecognize();
                        }
                    } catch (Exception e) {
                        MPaasLogger.e("ScanExecutor", new Object[]{"RecognizeRunnable.run()", "startMonitor"}, e);
                    }
                }
                this.runnable.run();
                if (this.enableMonitor) {
                    try {
                        if (ScanRecognizedExecutor.g != null) {
                            ScanRecognizedExecutor.g.onEndRecognize();
                        }
                    } catch (Exception e2) {
                        MPaasLogger.e("ScanExecutor", new Object[]{"RecognizeRunnable.run()", "startMonitor"}, e2);
                    }
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class StateRunnable implements Runnable {
        private RecognizeRunnable mRunnable;

        public StateRunnable(RecognizeRunnable recognizeRunnable) {
            this.mRunnable = recognizeRunnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ScanRecognizedExecutor.f.lock();
            boolean unused = ScanRecognizedExecutor.d = false;
            ScanRecognizedExecutor.f.unlock();
            RecognizeRunnable recognizeRunnable = this.mRunnable;
            if (recognizeRunnable != null) {
                recognizeRunnable.run();
            }
            ScanRecognizedExecutor.f.lock();
            boolean unused2 = ScanRecognizedExecutor.d = true;
            ScanRecognizedExecutor.f.unlock();
        }
    }

    public static void close() {
        if (!sUseNewExecutor) {
            ThreadPoolExecutor threadPoolExecutor = a;
            if (threadPoolExecutor != null && !threadPoolExecutor.isShutdown()) {
                try {
                    a.shutdownNow();
                    MPaasLogger.d("ScanExecutor", new Object[]{"Shutdown Successfully"});
                    a = null;
                } catch (Exception unused) {
                    MPaasLogger.e("ScanExecutor", new Object[]{"Shutdown executor failed"});
                }
            }
        } else {
            if (c != null) {
                b.quitSafely();
            }
            c = null;
            b = null;
            d = true;
        }
        g = null;
    }

    public static void execute(boolean z, Runnable runnable, boolean z2) {
        if (!z) {
            if (!sUseNewExecutor) {
                ThreadPoolExecutor threadPoolExecutor = a;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.execute(new RecognizeRunnable(runnable, z2));
                    return;
                } else {
                    MPaasLogger.w("ScanExecutor", new Object[]{"Executor is dead: ", Boolean.valueOf(sUseNewExecutor)});
                    return;
                }
            }
            Handler handler = c;
            if (handler != null) {
                handler.post(new StateRunnable(new RecognizeRunnable(runnable, z2)));
                return;
            } else {
                MPaasLogger.w("ScanExecutor", new Object[]{"Executor is dead: ", Boolean.valueOf(sUseNewExecutor)});
                return;
            }
        }
        new RecognizeRunnable(runnable, z2).run();
    }

    public static synchronized long getTid() {
        long j;
        synchronized (ScanRecognizedExecutor.class) {
            j = e;
        }
        return j;
    }

    public static boolean isEmpty(boolean z) {
        if (!z) {
            if (!sUseNewExecutor) {
                ThreadPoolExecutor threadPoolExecutor = a;
                if (threadPoolExecutor != null) {
                    boolean z2 = threadPoolExecutor.getActiveCount() == 0;
                    if (z2) {
                        MPaasLogger.w("ScanExecutor", new Object[]{"64: Executor is empty: true"});
                    } else {
                        MPaasLogger.w("ScanExecutor", new Object[]{"64: Executor is empty: false"});
                    }
                    return z2;
                }
                MPaasLogger.w("ScanExecutor", new Object[]{"66: Executor is empty: false"});
                return false;
            } else if (c != null) {
                f.lock();
                boolean z3 = d;
                f.unlock();
                return z3;
            } else {
                MPaasLogger.w("ScanExecutor", new Object[]{"67: Handler is null: false"});
                return false;
            }
        }
        MPaasLogger.w("ScanExecutor", new Object[]{"70: Executor is empty: true"});
        return true;
    }

    public static void open() {
        if (!sUseNewExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
            a = threadPoolExecutor;
            threadPoolExecutor.setThreadFactory(new ThreadFactory() { // from class: com.alipay.mobile.bqcscanservice.executor.ScanRecognizedExecutor.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(@NonNull Runnable runnable) {
                    Thread thread = new Thread(runnable, "ScanRecognize");
                    thread.setPriority(10);
                    return thread;
                }
            });
            a.setKeepAliveTime(1L, TimeUnit.SECONDS);
            a.execute(new Runnable() { // from class: com.alipay.mobile.bqcscanservice.executor.ScanRecognizedExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    long unused = ScanRecognizedExecutor.e = Process.myTid();
                }
            });
        } else {
            HandlerThread handlerThread = new HandlerThread("ScanRecognizeHT", -20);
            b = handlerThread;
            handlerThread.start();
            c = new Handler(b.getLooper());
        }
        MPaasLogger.d("ScanExecutor", new Object[]{"Open Successfully"});
    }

    public static void registerRecognizeCallback(RecognizeExecutorCallback recognizeExecutorCallback) {
        if (!sUseNewExecutor) {
            if (a != null) {
                g = recognizeExecutorCallback;
            }
        } else if (c != null) {
            g = recognizeExecutorCallback;
        }
    }
}
