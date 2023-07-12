package com.meizu.cloud.pushsdk.b.c;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.c.a */
/* loaded from: classes10.dex */
public class ExecutorC5928a implements Executor {
    private final ThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.b.c.a$a */
    /* loaded from: classes10.dex */
    private static class C5929a {
        private static ExecutorC5928a a = new ExecutorC5928a();
    }

    private ExecutorC5928a() {
        this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new C5934d().a("io-pool-%d").a());
    }

    public static ExecutorC5928a a() {
        return C5929a.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }
}
