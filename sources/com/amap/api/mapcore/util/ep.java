package com.amap.api.mapcore.util;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ep {
    private static volatile ep c;
    private BlockingQueue<Runnable> a = new LinkedBlockingQueue();
    private ExecutorService b;

    private ep() {
        this.b = null;
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        this.b = new ThreadPoolExecutor(availableProcessors, availableProcessors * 2, 10, TimeUnit.SECONDS, this.a, new ed("AMapThreadUtil"), new ThreadPoolExecutor.AbortPolicy());
    }

    public static ep a() {
        if (c == null) {
            synchronized (ep.class) {
                if (c == null) {
                    c = new ep();
                }
            }
        }
        return c;
    }

    public static void b() {
        if (c != null) {
            try {
                c.b.shutdownNow();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            c.b = null;
            c = null;
        }
    }

    public void a(Runnable runnable) {
        ExecutorService executorService = this.b;
        if (executorService != null) {
            try {
                executorService.execute(runnable);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
