package com.google.common.collect;

import com.google.common.base.Supplier;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
enum MultimapBuilder$LinkedListSupplier implements Supplier<List<Object>> {
    INSTANCE;

    public static <V> Supplier<List<V>> instance() {
        return INSTANCE;
    }

    @Override // com.google.common.base.Supplier
    public List<Object> get() {
        return new LinkedList();
    }
}
