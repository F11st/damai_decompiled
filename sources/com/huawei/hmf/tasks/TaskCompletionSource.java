package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.i;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TaskCompletionSource<TResult> {
    private final i<TResult> task = new i<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        cancellationToken.register(new Runnable() { // from class: com.huawei.hmf.tasks.TaskCompletionSource.1
            @Override // java.lang.Runnable
            public void run() {
                TaskCompletionSource.this.task.a();
            }
        });
    }

    public Task<TResult> getTask() {
        return this.task;
    }

    public void setException(Exception exc) {
        this.task.a(exc);
    }

    public void setResult(TResult tresult) {
        this.task.a((i<TResult>) tresult);
    }
}
