package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.C5184h0;
import com.google.common.collect.Multiset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* renamed from: com.google.common.collect.g */
/* loaded from: classes10.dex */
abstract class AbstractC5177g<E> extends AbstractC5165d<E> implements SortedMultiset<E> {
    @GwtTransient
    final Comparator<? super E> comparator;
    @MonotonicNonNullDecl
    private transient SortedMultiset<E> descendingMultiset;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.g$a */
    /* loaded from: classes10.dex */
    public class C5178a extends AbstractC5194m<E> {
        C5178a() {
        }

        @Override // com.google.common.collect.AbstractC5194m
        Iterator<Multiset.Entry<E>> b() {
            return AbstractC5177g.this.descendingEntryIterator();
        }

        @Override // com.google.common.collect.AbstractC5194m
        SortedMultiset<E> c() {
            return AbstractC5177g.this;
        }

        @Override // com.google.common.collect.AbstractC5200o, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return AbstractC5177g.this.descendingIterator();
        }
    }

    AbstractC5177g() {
        this(Ordering.natural());
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    SortedMultiset<E> createDescendingMultiset() {
        return new C5178a();
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
    public AbstractC5177g(Comparator<? super E> comparator) {
        this.comparator = (Comparator) du1.p(comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC5165d
    public NavigableSet<E> createElementSet() {
        return new C5184h0.C5186b(this);
    }

    @Override // com.google.common.collect.AbstractC5165d, com.google.common.collect.Multiset
    public NavigableSet<E> elementSet() {
        return (NavigableSet) super.elementSet();
    }
}
