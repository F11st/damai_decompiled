package com.huawei.hmf.tasks.a;

import com.huawei.hmf.tasks.CancellationToken;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.huawei.hmf.tasks.a.c */
/* loaded from: classes10.dex */
public final class C5497c extends CancellationToken {
    public final List<Runnable> a = new ArrayList();
    public final Object b = new Object();
    public boolean c = false;

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final boolean isCancellationRequested() {
        return this.c;
    }

    @Override // com.huawei.hmf.tasks.CancellationToken
    public final CancellationToken register(Runnable runnable) {
        synchronized (this.b) {
            if (this.c) {
                runnable.run();
            } else {
                this.a.add(runnable);
            }
        }
        return this;
    }
}
