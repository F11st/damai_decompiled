package com.google.common.collect;

import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class MultimapBuilder$HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
    private final int expectedValuesPerKey;

    MultimapBuilder$HashSetSupplier(int i) {
        this.expectedValuesPerKey = C5191k.b(i, "expectedValuesPerKey");
    }

    @Override // com.google.common.base.Supplier
    public Set<V> get() {
        return C5172e0.d(this.expectedValuesPerKey);
    }
}
