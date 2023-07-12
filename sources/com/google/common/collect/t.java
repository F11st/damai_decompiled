package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class t {
    protected abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
