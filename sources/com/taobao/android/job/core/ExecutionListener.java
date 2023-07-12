package com.taobao.android.job.core;

import com.taobao.android.job.core.task.ExecutionResult;
import com.taobao.android.job.core.task.Task;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface ExecutionListener<T, R> {
    void onError(Task<T, R> task, ExecutionResult<T, R> executionResult, Throwable th);

    void onSuccess(Task<T, R> task, ExecutionResult<T, R> executionResult);
}
