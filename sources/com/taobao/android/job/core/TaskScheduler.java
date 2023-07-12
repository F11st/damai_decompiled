package com.taobao.android.job.core;

import com.taobao.android.job.core.task.ExecutionResult;
import com.taobao.android.job.core.task.Task;
import com.taobao.android.job.core.task.TaskExecutionException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface TaskScheduler<T, R> {
    boolean addExecutionListener(ExecutionListener<T, R> executionListener);

    ExecutionResult<T, R> processResult() throws TaskExecutionException;

    boolean removeExecutionListener(ExecutionListener<T, R> executionListener);

    ExecutionResult<T, R> submit(Task<T, R> task);
}
