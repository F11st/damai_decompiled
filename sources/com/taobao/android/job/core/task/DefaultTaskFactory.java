package com.taobao.android.job.core.task;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DefaultTaskFactory<T, R> implements TaskFactory<T, R> {
    @Override // com.taobao.android.job.core.task.TaskFactory
    public Task<T, R> newRunner(Task<T, R> task) {
        return new LoggerTask(task);
    }
}
