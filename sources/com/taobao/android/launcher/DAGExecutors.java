package com.taobao.android.launcher;

import androidx.annotation.NonNull;
import com.taobao.android.launcher.DAGExecutor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DAGExecutors {
    private DAGExecutors() {
    }

    public static DAGExecutor create(final String str, int i, int i2, final int i3) {
        return new DAGExecutor(i, i2, null, new ThreadFactory() { // from class: com.taobao.android.launcher.DAGExecutors.1
            private AtomicInteger count = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str + "-" + this.count.getAndIncrement());
                thread.setPriority(i3);
                return thread;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ScheduledExecutorService createSingleScheduled(final String str) {
        return Executors.newSingleThreadScheduledExecutor(new ThreadFactory() { // from class: com.taobao.android.launcher.DAGExecutors.3
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                return new Thread(runnable, str + "-scheduled-launcher");
            }
        });
    }

    public static DAGExecutor create(final String str, int i, int i2, final int i3, DAGExecutor.Interceptor interceptor) {
        return new DAGExecutor(i, i2, interceptor, new ThreadFactory() { // from class: com.taobao.android.launcher.DAGExecutors.2
            private AtomicInteger count = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str + "-" + this.count.getAndIncrement());
                thread.setPriority(i3);
                return thread;
            }
        });
    }
}
