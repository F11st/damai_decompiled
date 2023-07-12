package com.huawei.hmf.tasks;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class CancellationToken {
    public abstract boolean isCancellationRequested();

    public abstract CancellationToken register(Runnable runnable);
}
