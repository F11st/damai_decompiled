package com.meizu.cloud.pushsdk.b.c;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.c.b */
/* loaded from: classes10.dex */
public class ExecutorC5930b implements Executor {
    private final ThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.b.c.b$a */
    /* loaded from: classes10.dex */
    private static class C5931a {
        private static ExecutorC5930b a = new ExecutorC5930b();
    }

    private ExecutorC5930b() {
        this.a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new C5934d().a((Integer) 10).a("message-pool-%d").a());
    }

    public static ExecutorC5930b a() {
        return C5931a.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }
}
