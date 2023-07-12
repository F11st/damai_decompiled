package com.alimm.xadsdk.base.core;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.alimm.xadsdk.AdSdkManager;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.base.utils.LogUtils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AdThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 0;
    private static final int DEFAULT_QUEUE_SIZE = 100;
    private static final int KEEP_ALIVE_SECONDS = 60;
    private static final int MAX_POOL_SIZE = 4;
    private static final String TAG = "AdThreadPoolExecutor";
    private static ThreadPoolExecutor sExecutor;
    private static Handler sHandler;
    private static long sIndex;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadFactory() { // from class: com.alimm.xadsdk.base.core.AdThreadPoolExecutor.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, "AdThread-" + AdThreadPoolExecutor.access$008());
            }
        });
        sExecutor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        sExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler() { // from class: com.alimm.xadsdk.base.core.AdThreadPoolExecutor.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                AdSdkManager.getInstance().getUserTracker().track(19999, AdUtConstants.XAD_ARG1_EXCEPTION, AdThreadPoolExecutor.TAG, "rejectTask");
            }
        });
    }

    static /* synthetic */ long access$008() {
        long j = sIndex;
        sIndex = 1 + j;
        return j;
    }

    public static void post(@NonNull Runnable runnable) {
        try {
            sExecutor.execute(runnable);
        } catch (Throwable th) {
            LogUtils.d(TAG, "post exception", th);
        }
    }

    public static void postDelayed(@NonNull final Runnable runnable, int i) {
        if (i == 0) {
            post(runnable);
        } else if (i > 0) {
            if (sHandler == null) {
                sHandler = new Handler(Looper.getMainLooper());
            }
            sHandler.postDelayed(new Runnable() { // from class: com.alimm.xadsdk.base.core.AdThreadPoolExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    AdThreadPoolExecutor.post(runnable);
                }
            }, i);
        }
    }

    public static void removeTask(@NonNull Runnable runnable) {
        Handler handler = sHandler;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}
