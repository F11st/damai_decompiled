package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.nm1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class Multisets {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class ImmutableEntry<E> extends b<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        @NullableDecl
        private final E element;

        ImmutableEntry(@NullableDecl E e, int i) {
            this.element = e;
            this.count = i;
            k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        }

        @Override // com.google.common.collect.Multiset.Entry
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.Multiset.Entry
        @NullableDecl
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class UnmodifiableMultiset<E> extends s<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multiset<? extends E> delegate;
        @MonotonicNonNullDecl
        transient Set<E> elementSet;
        @MonotonicNonNullDecl
        transient Set<Multiset.Entry<E>> entrySet;

        /* JADX INFO: Access modifiers changed from: package-private */
        public UnmodifiableMultiset(Multiset<? extends E> multiset) {
            this.delegate = multiset;
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Queue
        public boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.o, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        Set<E> createElementSet() {
            return Collections.unmodifiableSet(this.delegate.elementSet());
        }

        @Override // com.google.common.collect.s, com.google.common.collect.Multiset
        public Set<E> elementSet() {
            Set<E> set = this.elementSet;
            if (set == null) {
                Set<E> createElementSet = createElementSet();
                this.elementSet = createElementSet;
                return createElementSet;
            }
            return set;
        }

        @Override // com.google.common.collect.s, com.google.common.collect.Multiset
        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set = this.entrySet;
            if (set == null) {
                Set<Multiset.Entry<E>> unmodifiableSet = Collections.unmodifiableSet(this.delegate.entrySet());
                this.entrySet = unmodifiableSet;
                return unmodifiableSet;
            }
            return set;
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Iterators.x(this.delegate.iterator());
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.o, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s, com.google.common.collect.Multiset
        public int setCount(E e, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s, com.google.common.collect.Multiset
        public int add(E e, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s, com.google.common.collect.Multiset
        public int remove(Object obj, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.s, com.google.common.collect.Multiset
        public boolean setCount(E e, int i, int i2) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.s, com.google.common.collect.o, com.google.common.collect.t
        public Multiset<E> delegate() {
            return (Multiset<? extends E>) this.delegate;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a<E> extends j0<Multiset.Entry<E>, E> {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.j0
        /* renamed from: b */
        public E a(Multiset.Entry<E> entry) {
            return entry.getElement();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class b<E> implements Multiset.Entry<E> {
        @Override // com.google.common.collect.Multiset.Entry
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                return getCount() == entry.getCount() && nm1.a(getElement(), entry.getElement());
            }
            return false;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.Multiset.Entry
        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class c<E> extends Sets.a<E> {
        abstract Multiset<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static abstract class d<E> extends Sets.a<Multiset.Entry<E>> {
        abstract Multiset<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                return entry.getCount() > 0 && a().count(entry.getElement()) == entry.getCount();
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                E e = (E) entry.getElement();
                int count = entry.getCount();
                if (count != 0) {
                    return a().setCount(e, count, 0);
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static final class e<E> implements Iterator<E> {
        private final Multiset<E> a;
        private final Iterator<Multiset.Entry<E>> b;
        @MonotonicNonNullDecl
        private Multiset.Entry<E> c;
        private int d;
        private int e;
        private boolean f;

        e(Multiset<E> multiset, Iterator<Multiset.Entry<E>> it) {
            this.a = multiset;
            this.b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.d > 0 || this.b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.d == 0) {
                    Multiset.Entry<E> next = this.b.next();
                    this.c = next;
                    int count = next.getCount();
                    this.d = count;
                    this.e = count;
                }
                this.d--;
                this.f = true;
                return this.c.getElement();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            k.e(this.f);
            if (this.e == 1) {
                this.b.remove();
            } else {
                this.a.remove(this.c.getElement());
            }
            this.e--;
            this.f = false;
        }
    }

    private static <E> boolean a(Multiset<E> multiset, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(multiset);
        return true;
    }

    private static <E> boolean b(Multiset<E> multiset, Multiset<? extends E> multiset2) {
        if (multiset2 instanceof AbstractMapBasedMultiset) {
            return a(multiset, (AbstractMapBasedMultiset) multiset2);
        }
        if (multiset2.isEmpty()) {
            return false;
        }
        for (Multiset.Entry<? extends E> entry : multiset2.entrySet()) {
            multiset.add(entry.getElement(), entry.getCount());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean c(Multiset<E> multiset, Collection<? extends E> collection) {
        du1.p(multiset);
        du1.p(collection);
        if (collection instanceof Multiset) {
            return b(multiset, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(multiset, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Multiset<T> d(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Iterator<E> e(Iterator<Multiset.Entry<E>> it) {
        return new a(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Multiset<?> multiset, @NullableDecl Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.count(entry.getElement()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> Multiset.Entry<E> g(@NullableDecl E e2, int i) {
        return new ImmutableEntry(e2, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).elementSet().size();
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Iterator<E> i(Multiset<E> multiset) {
        return new e(multiset, multiset.entrySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(Multiset<?> multiset) {
        long j = 0;
        for (Multiset.Entry<?> entry : multiset.entrySet()) {
            j += entry.getCount();
        }
        return Ints.j(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l(Multiset<?> multiset, Collection<?> collection) {
        du1.p(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> int m(Multiset<E> multiset, E e2, int i) {
        k.b(i, AdUtConstants.XAD_UT_ARG_COUNT);
        int count = multiset.count(e2);
        int i2 = i - count;
        if (i2 > 0) {
            multiset.add(e2, i2);
        } else if (i2 < 0) {
            multiset.remove(e2, -i2);
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean n(Multiset<E> multiset, E e2, int i, int i2) {
        k.b(i, "oldCount");
        k.b(i2, "newCount");
        if (multiset.count(e2) == i) {
            multiset.setCount(e2, i2);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Multiset<E> o(Multiset<? extends E> multiset) {
        return ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new UnmodifiableMultiset((Multiset) du1.p(multiset));
    }

    @Beta
    public static <E> SortedMultiset<E> p(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset) du1.p(sortedMultiset));
    }
}
