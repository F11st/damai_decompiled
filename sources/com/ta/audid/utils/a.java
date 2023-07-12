package com.ta.audid.utils;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
class a {
    private static final AtomicInteger b = new AtomicInteger();
    private ScheduledThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* renamed from: com.ta.audid.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static class ThreadFactoryC0275a implements ThreadFactory {
        ThreadFactoryC0275a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int andIncrement = a.b.getAndIncrement();
            return new Thread(runnable, "UtdidHandlerThread:" + andIncrement);
        }
    }

    public a() {
        this.a = null;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC0275a());
        this.a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(3000L, TimeUnit.MILLISECONDS);
        this.a.allowCoreThreadTimeOut(true);
    }

    public ScheduledFuture b(Runnable runnable, long j) {
        return this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
