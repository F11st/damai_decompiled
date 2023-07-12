package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.h0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
abstract class m<E> extends s<E> implements SortedMultiset<E> {
    @MonotonicNonNullDecl
    private transient Comparator<? super E> a;
    @MonotonicNonNullDecl
    private transient NavigableSet<E> b;
    @MonotonicNonNullDecl
    private transient Set<Multiset.Entry<E>> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a extends Multisets.d<E> {
        a() {
        }

        @Override // com.google.common.collect.Multisets.d
        Multiset<E> a() {
            return m.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Multiset.Entry<E>> iterator() {
            return m.this.b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return m.this.c().entrySet().size();
        }
    }

    Set<Multiset.Entry<E>> a() {
        return new a();
    }

    abstract Iterator<Multiset.Entry<E>> b();

    abstract SortedMultiset<E> c();

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public Comparator<? super E> comparator() {
        Comparator<? super E> comparator = this.a;
        if (comparator == null) {
            Ordering reverse = Ordering.from(c().comparator()).reverse();
            this.a = reverse;
            return reverse;
        }
        return comparator;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> descendingMultiset() {
        return c();
    }

    @Override // com.google.common.collect.s, com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.c;
        if (set == null) {
            Set<Multiset.Entry<E>> a2 = a();
            this.c = a2;
            return a2;
        }
        return set;
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> firstEntry() {
        return c().lastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return c().tailMultiset(e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> lastEntry() {
        return c().firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollFirstEntry() {
        return c().pollLastEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public Multiset.Entry<E> pollLastEntry() {
        return c().pollFirstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        return c().subMultiset(e2, boundType2, e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return c().headMultiset(e, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.t
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.s, com.google.common.collect.o, com.google.common.collect.t
    public Multiset<E> delegate() {
        return c();
    }

    @Override // com.google.common.collect.s, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.b;
        if (navigableSet == null) {
            h0.b bVar = new h0.b(this);
            this.b = bVar;
            return bVar;
        }
        return navigableSet;
    }
}
