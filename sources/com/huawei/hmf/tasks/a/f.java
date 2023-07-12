package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f<TResult> implements ExecuteResult<TResult> {
    private OnFailureListener a;
    private Executor b;
    private final Object c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Executor executor, OnFailureListener onFailureListener) {
        this.a = onFailureListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        if (task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.f.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (f.this.c) {
                    if (f.this.a != null) {
                        f.this.a.onFailure(task.getException());
                    }
                }
            }
        });
    }
}
