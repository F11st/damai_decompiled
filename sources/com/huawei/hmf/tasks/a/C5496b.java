package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* renamed from: com.huawei.hmf.tasks.a.b */
/* loaded from: classes10.dex */
public final class C5496b<TResult> implements ExecuteResult<TResult> {
    private OnCanceledListener a;
    private Executor b;
    private final Object c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5496b(Executor executor, OnCanceledListener onCanceledListener) {
        this.a = onCanceledListener;
        this.b = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.c) {
            this.a = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(Task<TResult> task) {
        if (task.isCanceled()) {
            this.b.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    synchronized (C5496b.this.c) {
                        if (C5496b.this.a != null) {
                            C5496b.this.a.onCanceled();
                        }
                    }
                }
            });
        }
    }
}
