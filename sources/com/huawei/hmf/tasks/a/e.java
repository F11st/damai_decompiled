package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.OnCanceledListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import java.util.concurrent.ExecutionException;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class e<TResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TResult> {
    private final Object a = new Object();
    private final int b;
    private final i<Void> c;
    private int d;
    private Exception e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i, i<Void> iVar) {
        this.b = i;
        this.c = iVar;
    }

    private void a() {
        if (this.d >= this.b) {
            if (this.e != null) {
                this.c.a(new ExecutionException("a task failed", this.e));
            } else if (this.f) {
                this.c.a();
            } else {
                this.c.a((i<Void>) null);
            }
        }
    }

    @Override // com.huawei.hmf.tasks.OnCanceledListener
    public final void onCanceled() {
        synchronized (this.a) {
            this.d++;
            this.f = true;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        synchronized (this.a) {
            this.d++;
            this.e = exc;
            a();
        }
    }

    @Override // com.huawei.hmf.tasks.OnSuccessListener
    public final void onSuccess(TResult tresult) {
        synchronized (this.a) {
            this.d++;
            a();
        }
    }
}
