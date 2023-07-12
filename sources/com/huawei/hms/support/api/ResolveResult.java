package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ResolveResult<T> extends Result {
    private T entity;

    public ResolveResult() {
        this.entity = null;
    }

    public T getValue() {
        return this.entity;
    }

    public ResolveResult(T t) {
        this.entity = t;
    }
}
