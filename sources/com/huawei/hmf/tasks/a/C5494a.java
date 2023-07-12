package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.huawei.hmf.tasks.a.a */
/* loaded from: classes10.dex */
public final class C5494a {
    static final int a;
    static final int b;
    private static final C5494a c = new C5494a();
    private static final int e;
    private final Executor d = new ExecutorC5495a((byte) 0);

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hmf.tasks.a.a$a */
    /* loaded from: classes10.dex */
    static class ExecutorC5495a implements Executor {
        private ExecutorC5495a() {
        }

        /* synthetic */ ExecutorC5495a(byte b) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        e = availableProcessors;
        a = availableProcessors + 1;
        b = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return c.d;
    }
}
