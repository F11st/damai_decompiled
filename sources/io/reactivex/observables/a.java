package io.reactivex.observables;

import io.reactivex.annotations.Nullable;
import io.reactivex.d;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class a<K, T> extends d<T> {
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
