package com.taobao.android.launcher;

import androidx.annotation.NonNull;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DAGExecutor extends ThreadPoolExecutor {
    private final Interceptor interceptor;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Interceptor {
        boolean adjustParam(@NonNull DAGExecutorParam dAGExecutorParam);
    }

    DAGExecutor(int i) {
        this(i, i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread thread, Runnable runnable) {
        if (this.interceptor != null) {
            DAGExecutorParam dAGExecutorParam = new DAGExecutorParam();
            dAGExecutorParam.maxPoolSize = getMaximumPoolSize();
            dAGExecutorParam.priority = thread.getPriority();
            dAGExecutorParam.coreSize = getCorePoolSize();
            if (this.interceptor.adjustParam(dAGExecutorParam)) {
                setCorePoolSize(dAGExecutorParam.coreSize);
                setMaximumPoolSize(dAGExecutorParam.maxPoolSize);
                thread.setPriority(dAGExecutorParam.priority);
            }
        }
        super.beforeExecute(thread, runnable);
    }

    DAGExecutor(int i, int i2) {
        this(i, i2, null);
    }

    DAGExecutor(int i, int i2, Interceptor interceptor) {
        this(i, i2, interceptor, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DAGExecutor(int i, int i2, Interceptor interceptor, ThreadFactory threadFactory) {
        super(i, i2, 30L, TimeUnit.SECONDS, new LinkedBlockingDeque(), threadFactory);
        allowCoreThreadTimeOut(true);
        this.interceptor = interceptor;
    }
}
