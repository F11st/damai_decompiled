package com.amap.api.col.s;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ao {
    private static volatile ao c;
    private BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private ExecutorService b;

    private ao() {
        this.b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 1L, TimeUnit.SECONDS, this.a, new ThreadPoolExecutor.AbortPolicy());
    }

    public static ao a() {
        if (c == null) {
            synchronized (ao.class) {
                if (c == null) {
                    c = new ao();
                }
            }
        }
        return c;
    }

    public static void b() {
        if (c != null) {
            synchronized (ao.class) {
                if (c != null) {
                    c.b.shutdownNow();
                    c.b = null;
                    c = null;
                }
            }
        }
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService = this.b;
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
