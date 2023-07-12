package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.C5184h0;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* renamed from: com.google.common.collect.m */
/* loaded from: classes10.dex */
abstract class AbstractC5194m<E> extends AbstractC5204s<E> implements SortedMultiset<E> {
    @MonotonicNonNullDecl
    private transient Comparator<? super E> a;
    @MonotonicNonNullDecl
    private transient NavigableSet<E> b;
    @MonotonicNonNullDecl
    private transient Set<Multiset.Entry<E>> c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.m$a */
    /* loaded from: classes10.dex */
    public class C5195a extends Multisets.AbstractC5084d<E> {
        C5195a() {
        }

        @Override // com.google.common.collect.Multisets.AbstractC5084d
        Multiset<E> a() {
            return AbstractC5194m.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Multiset.Entry<E>> iterator() {
            return AbstractC5194m.this.b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractC5194m.this.c().entrySet().size();
        }
    }

    Set<Multiset.Entry<E>> a() {
        return new C5195a();
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

    @Override // com.google.common.collect.AbstractC5204s, com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> set = this.c;
        if (set == null) {
            Set<Multiset.Entry<E>> a = a();
            this.c = a;
            return a;
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

    @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.AbstractC5205t
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractC5204s, com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
    public Multiset<E> delegate() {
        return c();
    }

    @Override // com.google.common.collect.AbstractC5204s, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        NavigableSet<E> navigableSet = this.b;
        if (navigableSet == null) {
            C5184h0.C5186b c5186b = new C5184h0.C5186b(this);
            this.b = c5186b;
            return c5186b;
        }
        return navigableSet;
    }
}
