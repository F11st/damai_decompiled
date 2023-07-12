package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible
/* renamed from: com.google.common.collect.w */
/* loaded from: classes10.dex */
public abstract class AbstractC5208w<K, V> extends AbstractC5202q<K, V> implements SortedMap<K, V> {
    private int unsafeCompare(Object obj, Object obj2) {
        Comparator<? super K> comparator = comparator();
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
    protected abstract /* bridge */ /* synthetic */ Map delegate();

    @Override // com.google.common.collect.AbstractC5202q, com.google.common.collect.AbstractC5205t
    protected abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        return delegate().firstKey();
    }

    public abstract SortedMap<K, V> headMap(K k);

    @Override // java.util.SortedMap
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractC5202q
    @Beta
    protected boolean standardContainsKey(@NullableDecl Object obj) {
        try {
            return unsafeCompare(tailMap(obj).firstKey(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    @Beta
    protected SortedMap<K, V> standardSubMap(K k, K k2) {
        du1.e(unsafeCompare(k, k2) <= 0, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }

    public abstract SortedMap<K, V> subMap(K k, K k2);

    public abstract SortedMap<K, V> tailMap(K k);
}
