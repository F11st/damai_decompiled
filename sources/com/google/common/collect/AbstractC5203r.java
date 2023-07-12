package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible
/* renamed from: com.google.common.collect.r */
/* loaded from: classes10.dex */
public abstract class AbstractC5203r<K, V> extends AbstractC5205t implements Multimap<K, V> {
    public abstract Map<K, Collection<V>> asMap();

    public abstract void clear();

    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return delegate().containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@NullableDecl Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@NullableDecl Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractC5205t
    protected abstract Multimap<K, V> delegate();

    @Override // com.google.common.collect.AbstractC5205t
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    public abstract Collection<Map.Entry<K, V>> entries();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public abstract Collection<V> get(@NullableDecl K k);

    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public abstract Set<K> keySet();

    public abstract Multiset<K> keys();

    @CanIgnoreReturnValue
    public abstract boolean put(K k, V v);

    @CanIgnoreReturnValue
    public abstract boolean putAll(Multimap<? extends K, ? extends V> multimap);

    @CanIgnoreReturnValue
    public abstract boolean putAll(K k, Iterable<? extends V> iterable);

    @CanIgnoreReturnValue
    public abstract boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2);

    @CanIgnoreReturnValue
    public abstract Collection<V> removeAll(@NullableDecl Object obj);

    @CanIgnoreReturnValue
    public abstract Collection<V> replaceValues(K k, Iterable<? extends V> iterable);

    @Override // com.google.common.collect.Multimap
    public int size() {
        return delegate().size();
    }

    public abstract Collection<V> values();
}
