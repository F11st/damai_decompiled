package com.huawei.hmf.tasks;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult tresult) throws Exception;
}
