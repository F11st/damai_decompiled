package com.ali.user.mobile.coordinator;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CoordinatorWrapper<Params> {
    @TargetApi(11)
    public void execute(Runnable runnable) {
        if (runnable != null) {
            try {
                if (ExecutorInjector.getInjectThreadPoolExecutor() != null) {
                    ExecutorInjector.getInjectThreadPoolExecutor().execute(runnable);
                } else {
                    Coordinator.execute(runnable);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        try {
            if (ExecutorInjector.getScheduledExector() != null) {
                ExecutorInjector.getScheduledExector().scheduleAtFixedRate(runnable, j, j2, timeUnit);
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Coordinator.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }

    @SafeVarargs
    public final void execute(AsyncTask asyncTask, Params... paramsArr) {
        if (asyncTask != null) {
            try {
                if (ExecutorInjector.getInjectThreadPoolExecutor() != null) {
                    asyncTask.executeOnExecutor(ExecutorInjector.getInjectThreadPoolExecutor(), paramsArr);
                } else {
                    asyncTask.executeOnExecutor(Coordinator.sThreadPoolExecutor, paramsArr);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
