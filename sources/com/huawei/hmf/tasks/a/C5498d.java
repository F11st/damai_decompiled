package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.ExecuteResult;
import com.huawei.hmf.tasks.OnCompleteListener;
import com.huawei.hmf.tasks.Task;
import java.util.concurrent.Executor;

/* compiled from: Taobao */
/* renamed from: com.huawei.hmf.tasks.a.d */
/* loaded from: classes10.dex */
public final class C5498d<TResult> implements ExecuteResult<TResult> {
    Executor a;
    private OnCompleteListener<TResult> b;
    private final Object c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5498d(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.b = onCompleteListener;
        this.a = executor;
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void cancel() {
        synchronized (this.c) {
            this.b = null;
        }
    }

    @Override // com.huawei.hmf.tasks.ExecuteResult
    public final void onComplete(final Task<TResult> task) {
        this.a.execute(new Runnable() { // from class: com.huawei.hmf.tasks.a.d.1
            @Override // java.lang.Runnable
            public final void run() {
                synchronized (C5498d.this.c) {
                    if (C5498d.this.b != null) {
                        C5498d.this.b.onComplete(task);
                    }
                }
            }
        });
    }
}
