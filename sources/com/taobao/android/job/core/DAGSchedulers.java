package com.taobao.android.job.core;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DAGSchedulers {
    private DAGSchedulers() {
    }

    public static <T, R> DAGScheduler<T, R> with(DAGSchedulerConfig<T, R> dAGSchedulerConfig) {
        return new DAGSchedulerImpl(dAGSchedulerConfig);
    }
}
