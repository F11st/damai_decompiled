package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class MultimapBuilder$ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
    private final int expectedValuesPerKey;

    MultimapBuilder$ArrayListSupplier(int i) {
        this.expectedValuesPerKey = k.b(i, "expectedValuesPerKey");
    }

    @Override // com.google.common.base.Supplier
    public List<V> get() {
        return new ArrayList(this.expectedValuesPerKey);
    }
}
