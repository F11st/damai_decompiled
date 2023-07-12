package com.taobao.opentracing.impl.propagation;

import tb.mm1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface Codec<T> {
    mm1 extract(T t);

    void inject(mm1 mm1Var, T t);
}
