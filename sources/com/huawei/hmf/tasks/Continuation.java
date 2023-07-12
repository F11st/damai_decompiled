package com.huawei.hmf.tasks;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface Continuation<TResult, TContinuationResult> {
    TContinuationResult then(Task<TResult> task) throws Exception;
}
