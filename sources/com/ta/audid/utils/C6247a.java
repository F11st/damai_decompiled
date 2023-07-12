package com.ta.audid.utils;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: com.ta.audid.utils.a */
/* loaded from: classes7.dex */
class C6247a {
    private static final AtomicInteger b = new AtomicInteger();
    private ScheduledThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* renamed from: com.ta.audid.utils.a$a */
    /* loaded from: classes7.dex */
    static class ThreadFactoryC6248a implements ThreadFactory {
        ThreadFactoryC6248a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = C6247a.b.getAndIncrement();
            return new Thread(runnable, "UtdidHandlerThread:" + andIncrement);
        }
    }

    public C6247a() {
        this.a = null;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC6248a());
        this.a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(3000L, TimeUnit.MILLISECONDS);
        this.a.allowCoreThreadTimeOut(true);
    }

    public ScheduledFuture b(Runnable runnable, long j) {
        return this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
