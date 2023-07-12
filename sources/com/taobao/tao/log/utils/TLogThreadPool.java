package com.taobao.tao.log.utils;

import com.taobao.tao.log.utils.TLogThreadPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TLogThreadPool {
    private ThreadPoolExecutor executor;
    private ThreadPoolExecutor uploadExecutor;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class SingletonHolder {
        private static final TLogThreadPool INSTANCE = new TLogThreadPool();

        private SingletonHolder() {
        }
    }

    public static TLogThreadPool getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$1(Runnable runnable) {
        return new Thread(runnable, "tlog-thread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Thread lambda$new$2(Runnable runnable) {
        return new Thread(runnable, "tlog-thread");
    }

    public void execute(Runnable runnable) {
        this.executor.execute(runnable);
    }

    public void executeUpload(Runnable runnable) {
        this.uploadExecutor.execute(runnable);
    }

    private TLogThreadPool() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.uploadExecutor = new ThreadPoolExecutor(1, 1, 1L, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() { // from class: tb.nk2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread lambda$new$1;
                lambda$new$1 = TLogThreadPool.lambda$new$1(runnable);
                return lambda$new$1;
            }
        });
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 1L, timeUnit, new LinkedBlockingQueue(), new ThreadFactory() { // from class: tb.mk2
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread lambda$new$2;
                lambda$new$2 = TLogThreadPool.lambda$new$2(runnable);
                return lambda$new$2;
            }
        });
        this.executor = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.uploadExecutor.allowCoreThreadTimeOut(true);
    }
}
