package io.reactivex.flowables;

import io.reactivex.annotations.Nullable;
import io.reactivex.b;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class a<K, T> extends b<T> {
    final K key;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
