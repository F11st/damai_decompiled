package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.yt2;

/* compiled from: Taobao */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes10.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;
    @RetainedWith
    @NullableDecl
    @LazyInit
    private transient ImmutableList<E> asList;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a<E> extends ImmutableCollection.a<E> {
        @VisibleForTesting
        @NullableDecl
        Object[] d;
        private int e;

        public a() {
            super(4);
        }

        private void k(E e) {
            int length = this.d.length - 1;
            int hashCode = e.hashCode();
            int c = z.c(hashCode);
            while (true) {
                int i = c & length;
                Object[] objArr = this.d;
                Object obj = objArr[i];
                if (obj == null) {
                    objArr[i] = e;
                    this.e += hashCode;
                    super.f(e);
                    return;
                } else if (obj.equals(e)) {
                    return;
                } else {
                    c = i + 1;
                }
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: h */
        public a<E> a(E e) {
            du1.p(e);
            if (this.d != null && ImmutableSet.chooseTableSize(this.b) <= this.d.length) {
                k(e);
                return this;
            }
            this.d = null;
            super.f(e);
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> i(E... eArr) {
            if (this.d != null) {
                for (E e : eArr) {
                    a(e);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> j(Iterator<? extends E> it) {
            du1.p(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public ImmutableSet<E> l() {
            ImmutableSet<E> construct;
            int i = this.b;
            if (i != 0) {
                if (i != 1) {
                    if (this.d == null || ImmutableSet.chooseTableSize(i) != this.d.length) {
                        construct = ImmutableSet.construct(this.b, this.a);
                        this.b = construct.size();
                    } else {
                        Object[] copyOf = ImmutableSet.shouldTrim(this.b, this.a.length) ? Arrays.copyOf(this.a, this.b) : this.a;
                        int i2 = this.e;
                        Object[] objArr = this.d;
                        construct = new RegularImmutableSet<>(copyOf, i2, objArr, objArr.length - 1, this.b);
                    }
                    this.c = true;
                    this.d = null;
                    return construct;
                }
                return ImmutableSet.of(this.a[0]);
            }
            return ImmutableSet.of();
        }

        a(int i) {
            super(i);
            this.d = new Object[ImmutableSet.chooseTableSize(i)];
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    @Beta
    public static <E> a<E> builderWithExpectedSize(int i) {
        k.b(i, "expectedSize");
        return new a<>(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static int chooseTableSize(int i) {
        int max = Math.max(i, 2);
        if (max < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        du1.e(max < 1073741824, "collection too large");
        return 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i, Object... objArr) {
        if (i != 0) {
            if (i != 1) {
                int chooseTableSize = chooseTableSize(i);
                Object[] objArr2 = new Object[chooseTableSize];
                int i2 = chooseTableSize - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object a2 = b0.a(objArr[i5], i5);
                    int hashCode = a2.hashCode();
                    int c = z.c(hashCode);
                    while (true) {
                        int i6 = c & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            objArr[i4] = a2;
                            objArr2[i6] = a2;
                            i3 += hashCode;
                            i4++;
                            break;
                        } else if (obj.equals(a2)) {
                            break;
                        } else {
                            c++;
                        }
                    }
                }
                Arrays.fill(objArr, i4, i, (Object) null);
                if (i4 == 1) {
                    return new SingletonImmutableSet(objArr[0], i3);
                }
                if (chooseTableSize(i4) < chooseTableSize / 2) {
                    return construct(i4, objArr);
                }
                if (shouldTrim(i4, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new RegularImmutableSet(objArr, i3, objArr2, i2, i4);
            }
            return of(objArr[0]);
        }
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList == null) {
            ImmutableList<E> createAsList = createAsList();
            this.asList = createAsList;
            return createAsList;
        }
        return immutableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.b(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract yt2<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> of(E e, E e2) {
        return construct(2, e, e2);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3) {
        return construct(3, e, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4) {
        return construct(4, e, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(5, e, e2, e3, e4, e5);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        du1.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().a(next).j(it).l();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            if (length != 1) {
                return construct(eArr.length, (Object[]) eArr.clone());
            }
            return of((Object) eArr[0]);
        }
        return of();
    }
}
