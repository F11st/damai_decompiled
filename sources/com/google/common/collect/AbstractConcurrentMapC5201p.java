package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Taobao */
@GwtCompatible
/* renamed from: com.google.common.collect.p */
/* loaded from: classes10.dex */
public abstract class AbstractConcurrentMapC5201p<K, V> extends AbstractC5202q<K, V> implements ConcurrentMap<K, V> {
    @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
    protected abstract /* bridge */ /* synthetic */ Map delegate();

    @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
    protected abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k, V v) {
        return delegate().putIfAbsent(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k, V v) {
        return delegate().replace(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k, V v, V v2) {
        return delegate().replace(k, v, v2);
    }
}
