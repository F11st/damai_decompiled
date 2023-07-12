package com.meizu.cloud.pushsdk.b.c;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a implements Executor {
    private final ThreadPoolExecutor a;

    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0258a {
        private static a a = new a();
    }

    private a() {
        this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new d().a("io-pool-%d").a());
    }

    public static a a() {
        return C0258a.a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }
}
