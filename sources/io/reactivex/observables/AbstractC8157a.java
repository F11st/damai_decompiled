package io.reactivex.observables;

import io.reactivex.AbstractC8149d;
import io.reactivex.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: io.reactivex.observables.a */
/* loaded from: classes3.dex */
public abstract class AbstractC8157a<K, T> extends AbstractC8149d<T> {
    final K key;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC8157a(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
