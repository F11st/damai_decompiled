package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class h<TResult> implements ExecuteResult<TResult> {
    private OnSuccessListener<TResult> a;
    private Executor b;
    private final Object c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Executor executor, OnSuccessListener<TResult> onSuccessListener) {
        this.a = onSuccessListener;
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
        if (!task.isSuccessful() || task.isCanceled()) {
            return;
        }
        this.b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.h.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (h.this.c) {
                    if (h.this.a != null) {
                        h.this.a.onSuccess(task.getResult());
                    }
                }
            }
        });
    }
}
