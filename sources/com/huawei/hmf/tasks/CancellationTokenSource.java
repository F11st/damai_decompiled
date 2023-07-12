package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.C5497c;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CancellationTokenSource {
    private C5497c impl = new C5497c();

    public void cancel() {
        C5497c c5497c = this.impl;
        if (c5497c.c) {
            return;
        }
        synchronized (c5497c.b) {
            c5497c.c = true;
            for (Runnable runnable : c5497c.a) {
                runnable.run();
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
