package io.reactivex.flowables;

import io.reactivex.AbstractC8147b;
import io.reactivex.annotations.Nullable;

/* compiled from: Taobao */
/* renamed from: io.reactivex.flowables.a */
/* loaded from: classes3.dex */
public abstract class AbstractC8156a<K, T> extends AbstractC8147b<T> {
    final K key;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC8156a(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
