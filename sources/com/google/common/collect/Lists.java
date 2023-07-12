package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.math.C5238c;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.nm1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class Lists {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @NullableDecl
        final E first;
        final E[] rest;

        OnePlusArrayList(@NullableDecl E e, E[] eArr) {
            this.first = e;
            this.rest = (E[]) ((Object[]) du1.p(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            du1.n(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return C5238c.f(this.rest.length, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        StringAsImmutableList(String str) {
            this.string = str;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // java.util.List
        public Character get(int i) {
            du1.n(i, size());
            return Character.valueOf(this.string.charAt(i));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i, int i2) {
            du1.v(i, i2, size());
            return Lists.b(this.string.substring(i, i2));
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.Lists$TransformingRandomAccessList$a */
        /* loaded from: classes10.dex */
        class C5019a extends AbstractC5192k0<F, T> {
            C5019a(ListIterator listIterator) {
                super(listIterator);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractC5190j0
            public T a(F f) {
                return TransformingRandomAccessList.this.function.apply(f);
            }
        }

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) du1.p(list);
            this.function = (Function) du1.p(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.function.apply((F) this.fromList.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new C5019a(this.fromList.listIterator(i));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.function.apply((F) this.fromList.remove(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.Lists$TransformingSequentialList$a */
        /* loaded from: classes10.dex */
        class C5020a extends AbstractC5192k0<F, T> {
            C5020a(ListIterator listIterator) {
                super(listIterator);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractC5190j0
            public T a(F f) {
                return TransformingSequentialList.this.function.apply(f);
            }
        }

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) du1.p(list);
            this.function = (Function) du1.p(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new C5020a(this.fromList.listIterator(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        @NullableDecl
        final E first;
        final E[] rest;
        @NullableDecl
        final E second;

        TwoPlusArrayList(@NullableDecl E e, @NullableDecl E e2, E[] eArr) {
            this.first = e;
            this.second = e2;
            this.rest = (E[]) ((Object[]) du1.p(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i != 0) {
                if (i != 1) {
                    du1.n(i, size());
                    return this.rest[i - 2];
                }
                return this.second;
            }
            return this.first;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return C5238c.f(this.rest.length, 2);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Lists$a */
    /* loaded from: classes10.dex */
    private static class C5021a<T> extends AbstractList<List<T>> {
        final List<T> a;
        final int b;

        C5021a(List<T> list, int i) {
            this.a = list;
            this.b = i;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public List<T> get(int i) {
            du1.n(i, size());
            int i2 = this.b;
            int i3 = i * i2;
            return this.a.subList(i3, Math.min(i2 + i3, this.a.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return C5238c.b(this.a.size(), this.b, RoundingMode.CEILING);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.Lists$b */
    /* loaded from: classes10.dex */
    private static class C5022b<T> extends C5021a<T> implements RandomAccess {
        C5022b(List<T> list, int i) {
            super(list, i);
        }
    }

    public static <E> List<E> a(@NullableDecl E e, E[] eArr) {
        return new OnePlusArrayList(e, eArr);
    }

    public static ImmutableList<Character> b(String str) {
        return new StringAsImmutableList((String) du1.p(str));
    }

    @VisibleForTesting
    static int c(int i) {
        C5191k.b(i, "arraySize");
        return Ints.j(i + 5 + (i / 10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(List<?> list, @NullableDecl Object obj) {
        if (obj == du1.p(list)) {
            return true;
        }
        if (obj instanceof List) {
            List list2 = (List) obj;
            int size = list.size();
            if (size != list2.size()) {
                return false;
            }
            if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
                for (int i = 0; i < size; i++) {
                    if (!nm1.a(list.get(i), list2.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return Iterators.g(list.iterator(), list2.iterator());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (nm1.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int f(List<?> list, @NullableDecl Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return h(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (nm1.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int h(List<?> list, @NullableDecl Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> i() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> j(Iterable<? extends E> iterable) {
        du1.p(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(C5193l.a(iterable));
        }
        return k(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> k(Iterator<? extends E> it) {
        ArrayList<E> i = i();
        Iterators.a(i, it);
        return i;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> l(int i) {
        C5191k.b(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> m(int i) {
        return new ArrayList<>(c(i));
    }

    public static <T> List<List<T>> n(List<T> list, int i) {
        du1.p(list);
        du1.d(i > 0);
        return list instanceof RandomAccess ? new C5022b(list, i) : new C5021a(list, i);
    }

    public static <F, T> List<T> o(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }
}
