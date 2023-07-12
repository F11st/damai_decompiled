package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CancellationTokenSource {
    private c impl = new c();

    public void cancel() {
        c cVar = this.impl;
        if (cVar.c) {
            return;
        }
        synchronized (cVar.b) {
            cVar.c = true;
            for (Runnable runnable : cVar.a) {
                runnable.run();
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
