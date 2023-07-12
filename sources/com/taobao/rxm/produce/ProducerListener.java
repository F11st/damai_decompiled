package com.taobao.rxm.produce;

import tb.a22;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ProducerListener<T extends a22> {
    void onEnterIn(T t, Class cls, boolean z, boolean z2);

    void onExitOut(T t, Class cls, boolean z, boolean z2, boolean z3);
}
