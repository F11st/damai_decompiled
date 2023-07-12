package com.taobao.android.job.core.task;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface TaskFactory<T, R> {
    Task<T, R> newRunner(Task<T, R> task);
}
