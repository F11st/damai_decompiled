package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.h0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
abstract class g<E> extends d<E> implements SortedMultiset<E> {
    @GwtTransient
    final Comparator<? super E> comparator;
    @MonotonicNonNullDecl
    private transient SortedMultiset<E> descendingMultiset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class a extends m<E> {
        a() {
        }

        @Override // com.google.common.collect.m
        Iterator<Multiset.Entry<E>> b() {
            return g.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.m
        SortedMultiset<E> c() {
            return g.this;
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return g.this.descendingIterator();
        }
    }

    g() {
        this(Ordering.natural());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    SortedMultiset<E> createDescendingMultiset() {
        return new a();
    }

    abstract Iterator<Multiset.Entry<E>> descendingEntryIterator();

    Iterator<E> descendingIterator() {
        return Multisets.i(descendingMultiset());
    }

    public SortedMultiset<E> descendingMultiset() {
        SortedMultiset<E> sortedMultiset = this.descendingMultiset;
        if (sortedMultiset == null) {
            SortedMultiset<E> createDescendingMultiset = createDescendingMultiset();
            this.descendingMultiset = createDescendingMultiset;
            return createDescendingMultiset;
        }
        return sortedMultiset;
    }

    public Multiset.Entry<E> firstEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            return entryIterator.next();
        }
        return null;
    }

    public Multiset.Entry<E> lastEntry() {
        Iterator<Multiset.Entry<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            return descendingEntryIterator.next();
        }
        return null;
    }

    public Multiset.Entry<E> pollFirstEntry() {
        Iterator<Multiset.Entry<E>> entryIterator = entryIterator();
        if (entryIterator.hasNext()) {
            Multiset.Entry<E> next = entryIterator.next();
            Multiset.Entry<E> g = Multisets.g(next.getElement(), next.getCount());
            entryIterator.remove();
            return g;
        }
        return null;
    }

    public Multiset.Entry<E> pollLastEntry() {
        Iterator<Multiset.Entry<E>> descendingEntryIterator = descendingEntryIterator();
        if (descendingEntryIterator.hasNext()) {
            Multiset.Entry<E> next = descendingEntryIterator.next();
            Multiset.Entry<E> g = Multisets.g(next.getElement(), next.getCount());
            descendingEntryIterator.remove();
            return g;
        }
        return null;
    }

    public SortedMultiset<E> subMultiset(@NullableDecl E e, BoundType boundType, @NullableDecl E e2, BoundType boundType2) {
        du1.p(boundType);
        du1.p(boundType2);
        return tailMultiset(e, boundType).headMultiset(e2, boundType2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Comparator<? super E> comparator) {
        this.comparator = (Comparator) du1.p(comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    public NavigableSet<E> createElementSet() {
        return new h0.b(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
