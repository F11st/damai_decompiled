package com.meizu.cloud.pushsdk.b.c;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.c.c */
/* loaded from: classes10.dex */
public class ExecutorC5932c implements Executor {
    private final ThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.b.c.c$a */
    /* loaded from: classes10.dex */
    private static class C5933a {
        private static ExecutorC5932c a = new ExecutorC5932c();
    }

    private ExecutorC5932c() {
        this.a = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new C5934d().a("single-pool-%d").a());
    }

    public static ExecutorC5932c a() {
        return C5933a.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }
}
