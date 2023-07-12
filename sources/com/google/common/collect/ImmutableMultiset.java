package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.yt2;

/* compiled from: Taobao */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes10.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
    @LazyInit
    private transient ImmutableList<E> asList;
    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                return entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount();
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, C4983a c4983a) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.IndexedImmutableSet
        public Multiset.Entry<E> get(int i) {
            return ImmutableMultiset.this.getEntry(i);
        }
    }

    /* compiled from: Taobao */
    @GwtIncompatible
    /* loaded from: classes10.dex */
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ImmutableMultiset$a */
    /* loaded from: classes10.dex */
    public class C4983a extends yt2<E> {
        int a;
        @MonotonicNonNullDecl
        E b;
        final /* synthetic */ Iterator c;

        C4983a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.c = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0 || this.c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.a <= 0) {
                Multiset.Entry entry = (Multiset.Entry) this.c.next();
                this.b = (E) entry.getElement();
                this.a = entry.getCount();
            }
            this.a--;
            return this.b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.ImmutableMultiset$b */
    /* loaded from: classes10.dex */
    public static class C4984b<E> extends ImmutableCollection.AbstractC4968b<E> {
        C5163c0<E> a;
        boolean b;
        boolean c;

        public C4984b() {
            this(4);
        }

        @NullableDecl
        static <T> C5163c0<T> l(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return (C5163c0<E>) ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return (C5163c0<E>) ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableCollection.AbstractC4968b
        @CanIgnoreReturnValue
        /* renamed from: f */
        public C4984b<E> a(E e) {
            return j(e, 1);
        }

        @CanIgnoreReturnValue
        public C4984b<E> g(E... eArr) {
            super.b(eArr);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public C4984b<E> h(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                Multiset d = Multisets.d(iterable);
                C5163c0 l = l(d);
                if (l != null) {
                    C5163c0<E> c5163c0 = this.a;
                    c5163c0.d(Math.max(c5163c0.C(), l.C()));
                    for (int e = l.e(); e >= 0; e = l.s(e)) {
                        j(l.i(e), l.k(e));
                    }
                } else {
                    Set<Multiset.Entry<E>> entrySet = d.entrySet();
                    C5163c0<E> c5163c02 = this.a;
                    c5163c02.d(Math.max(c5163c02.C(), entrySet.size()));
                    for (Multiset.Entry<E> entry : d.entrySet()) {
                        j(entry.getElement(), entry.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public C4984b<E> i(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        @CanIgnoreReturnValue
        public C4984b<E> j(E e, int i) {
            if (i == 0) {
                return this;
            }
            if (this.b) {
                this.a = new C5163c0<>((C5163c0<? extends E>) this.a);
                this.c = false;
            }
            this.b = false;
            du1.p(e);
            C5163c0<E> c5163c0 = this.a;
            c5163c0.u(e, i + c5163c0.f(e));
            return this;
        }

        public ImmutableMultiset<E> k() {
            if (this.a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.c) {
                this.a = new C5163c0<>((C5163c0<? extends E>) this.a);
                this.c = false;
            }
            this.b = true;
            return new RegularImmutableMultiset(this.a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4984b(int i) {
            this.b = false;
            this.c = false;
            this.a = C5163c0.c(i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C4984b(boolean z) {
            this.b = false;
            this.c = false;
            this.a = null;
        }
    }

    public static <E> C4984b<E> builder() {
        return new C4984b<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        return new C4984b().g(eArr).k();
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> collection) {
        C4984b c4984b = new C4984b(collection.size());
        for (Multiset.Entry<? extends E> entry : collection) {
            c4984b.j(entry.getElement(), entry.getCount());
        }
        return c4984b.k();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList == null) {
            ImmutableList<E> asList = super.asList();
            this.asList = asList;
            return asList;
        }
        return immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] objArr, int i) {
        yt2<Multiset.Entry<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry<E> next = it.next();
            Arrays.fill(objArr, i, next.getCount() + i, next.getElement());
            i += next.getCount();
        }
        return i;
    }

    @Override // com.google.common.collect.Multiset
    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object obj) {
        return Multisets.f(this, obj);
    }

    abstract Multiset.Entry<E> getEntry(int i);

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return Sets.b(entrySet());
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        C4984b c4984b = new C4984b(Multisets.h(iterable));
        c4984b.h(iterable);
        return c4984b.k();
    }

    public static <E> ImmutableMultiset<E> of(E e) {
        return copyFromElements(e);
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.entrySet;
        if (immutableSet == null) {
            ImmutableSet<Multiset.Entry<E>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return immutableSet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public yt2<E> iterator() {
        return new C4983a(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2) {
        return copyFromElements(e, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3) {
        return copyFromElements(e, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return copyFromElements(e, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return copyFromElements(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        return new C4984b().a(e).a(e2).a(e3).a(e4).a(e5).a(e6).g(eArr).k();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        return new C4984b().i(it).k();
    }
}
