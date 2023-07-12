package com.uc.webview.export.internal.utility;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.utility.f */
/* loaded from: classes11.dex */
public final class C7331f {
    private ScheduledThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.utility.f$a */
    /* loaded from: classes11.dex */
    static class ThreadFactoryC7332a implements ThreadFactory {
        String a;
        int b = 1;

        ThreadFactoryC7332a(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.a);
            thread.setPriority(this.b);
            return thread;
        }
    }

    public C7331f(String str) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC7332a(str));
        this.a = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setKeepAliveTime(10000L, TimeUnit.MILLISECONDS);
        this.a.allowCoreThreadTimeOut(true);
    }

    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }

    public final void a(Runnable runnable, long j) {
        this.a.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
