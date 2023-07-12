package com.taobao.android.job.core.task;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface TaskProvider<T, R> {
    Task<T, R> provideTask(T t);
}
