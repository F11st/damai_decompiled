package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.C5238c;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import tb.du1;

/* compiled from: Taobao */
@GwtIncompatible
/* loaded from: classes10.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        SerializedForm(SortedMultiset<E> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (Multiset.Entry<E> entry : sortedMultiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        Object readResolve() {
            int length = this.elements.length;
            C4994a c4994a = new C4994a(this.comparator);
            for (int i = 0; i < length; i++) {
                c4994a.j(this.elements[i], this.counts[i]);
            }
            return c4994a.k();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ImmutableSortedMultiset$a */
    /* loaded from: classes10.dex */
    public static class C4994a<E> extends ImmutableMultiset.C4984b<E> {
        private final Comparator<? super E> d;
        @VisibleForTesting
        E[] e;
        private int[] f;
        private int g;
        private boolean h;

        public C4994a(Comparator<? super E> comparator) {
            super(true);
            this.d = (Comparator) du1.p(comparator);
            this.e = (E[]) new Object[4];
            this.f = new int[4];
        }

        private void s(boolean z) {
            int i = this.g;
            if (i == 0) {
                return;
            }
            E[] eArr = (E[]) Arrays.copyOf(this.e, i);
            Arrays.sort(eArr, this.d);
            int i2 = 1;
            for (int i3 = 1; i3 < eArr.length; i3++) {
                if (this.d.compare((Object) eArr[i2 - 1], (Object) eArr[i3]) < 0) {
                    eArr[i2] = eArr[i3];
                    i2++;
                }
            }
            Arrays.fill(eArr, i2, this.g, (Object) null);
            if (z) {
                int i4 = i2 * 4;
                int i5 = this.g;
                if (i4 > i5 * 3) {
                    eArr = (E[]) Arrays.copyOf(eArr, C5238c.f(i5, (i5 / 2) + 1));
                }
            }
            int[] iArr = new int[eArr.length];
            for (int i6 = 0; i6 < this.g; i6++) {
                int binarySearch = Arrays.binarySearch(eArr, 0, i2, this.e[i6], this.d);
                int[] iArr2 = this.f;
                if (iArr2[i6] >= 0) {
                    iArr[binarySearch] = iArr[binarySearch] + iArr2[i6];
                } else {
                    iArr[binarySearch] = ~iArr2[i6];
                }
            }
            this.e = eArr;
            this.f = iArr;
            this.g = i2;
        }

        private void t() {
            s(false);
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = this.g;
                if (i < i3) {
                    int[] iArr = this.f;
                    if (iArr[i] > 0) {
                        E[] eArr = this.e;
                        eArr[i2] = eArr[i];
                        iArr[i2] = iArr[i];
                        i2++;
                    }
                    i++;
                } else {
                    Arrays.fill(this.e, i2, i3, (Object) null);
                    Arrays.fill(this.f, i2, this.g, 0);
                    this.g = i2;
                    return;
                }
            }
        }

        private void u() {
            int i = this.g;
            E[] eArr = this.e;
            if (i == eArr.length) {
                s(true);
            } else if (this.h) {
                this.e = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.h = false;
        }

        @Override // com.google.common.collect.ImmutableMultiset.C4984b
        @CanIgnoreReturnValue
        /* renamed from: m */
        public C4994a<E> f(E e) {
            return j(e, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.C4984b
        @CanIgnoreReturnValue
        /* renamed from: n */
        public C4994a<E> g(E... eArr) {
            for (E e : eArr) {
                f(e);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.C4984b
        @CanIgnoreReturnValue
        /* renamed from: o */
        public C4994a<E> h(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry<E> entry : ((Multiset) iterable).entrySet()) {
                    j(entry.getElement(), entry.getCount());
                }
            } else {
                for (E e : iterable) {
                    f(e);
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.C4984b
        @CanIgnoreReturnValue
        /* renamed from: p */
        public C4994a<E> i(Iterator<? extends E> it) {
            while (it.hasNext()) {
                f(it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.C4984b
        @CanIgnoreReturnValue
        /* renamed from: q */
        public C4994a<E> j(E e, int i) {
            du1.p(e);
            C5191k.b(i, "occurrences");
            if (i == 0) {
                return this;
            }
            u();
            E[] eArr = this.e;
            int i2 = this.g;
            eArr[i2] = e;
            this.f[i2] = i;
            this.g = i2 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.C4984b
        /* renamed from: r */
        public ImmutableSortedMultiset<E> k() {
            t();
            int i = this.g;
            if (i == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.d);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.d, i, this.e);
            long[] jArr = new long[this.g + 1];
            int i2 = 0;
            while (i2 < this.g) {
                int i3 = i2 + 1;
                jArr[i3] = jArr[i2] + this.f[i2];
                i2 = i3;
            }
            this.h = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.g);
        }
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.j(sortedMultiset.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.C4971a c4971a = new ImmutableList.C4971a(collection.size());
        long[] jArr = new long[collection.size() + 1];
        int i = 0;
        for (Multiset.Entry<E> entry : collection) {
            c4971a.a(entry.getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + entry.getCount();
            i = i2;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(c4971a.j(), comparator), jArr, 0, collection.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> C4994a<E> naturalOrder() {
        return new C4994a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> C4994a<E> orderedBy(Comparator<E> comparator) {
        return new C4994a<>(comparator);
    }

    public static <E extends Comparable<?>> C4994a<E> reverseOrder() {
        return new C4994a<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.SortedMultiset
    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        du1.l(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return tailMultiset((ImmutableSortedMultiset<E>) e, boundType).headMultiset((ImmutableSortedMultiset<E>) e2, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        du1.p(comparator);
        return new C4994a(comparator).i(it).k();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new C4994a(comparator).h(iterable).k();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList l = Lists.l(comparableArr.length + 6);
        Collections.addAll(l, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(l, comparableArr);
        return copyOf(Ordering.natural(), l);
    }
}
