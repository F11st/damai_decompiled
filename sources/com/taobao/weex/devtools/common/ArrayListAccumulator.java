package com.taobao.weex.devtools.common;

import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ArrayListAccumulator<E> extends ArrayList<E> implements Accumulator<E> {
    @Override // com.taobao.weex.devtools.common.Accumulator
    public void store(E e) {
        add(e);
    }
}
