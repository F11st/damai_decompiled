package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public final class a0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a<T> extends n<T> {
        final /* synthetic */ Iterable b;
        final /* synthetic */ Predicate c;

        a(Iterable iterable, Predicate predicate) {
            this.b = iterable;
            this.c = predicate;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.k(this.b.iterator(), this.c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b<T> extends n<T> {
        final /* synthetic */ Iterable b;
        final /* synthetic */ Function c;

        b(Iterable iterable, Function function) {
            this.b = iterable;
            this.c = function;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.w(this.b.iterator(), this.c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class c<T> extends n<T> {
        final /* synthetic */ Iterable b;
        final /* synthetic */ int c;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class a implements Iterator<T> {
            boolean a = true;
            final /* synthetic */ Iterator b;

            a(c cVar, Iterator it) {
                this.b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public T next() {
                T t = (T) this.b.next();
                this.a = false;
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                k.e(!this.a);
                this.b.remove();
            }
        }

        c(Iterable iterable, int i) {
            this.b = iterable;
            this.c = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.c), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            Iterators.b(it, this.c);
            return new a(this, it);
        }
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(l.a(iterable));
        }
        return Iterators.a(collection, ((Iterable) du1.p(iterable)).iterator());
    }

    private static <E> Collection<E> b(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.k(iterable.iterator());
    }

    public static <T> Iterable<T> c(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return n.a(iterable, iterable2);
    }

    public static <T> Iterable<T> d(Iterable<T> iterable, Predicate<? super T> predicate) {
        du1.p(iterable);
        du1.p(predicate);
        return new a(iterable, predicate);
    }

    @NullableDecl
    public static <T> T e(Iterable<? extends T> iterable, @NullableDecl T t) {
        return (T) Iterators.m(iterable.iterator(), t);
    }

    public static <T> T f(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return (T) g(list);
            }
            throw new NoSuchElementException();
        }
        return (T) Iterators.l(iterable.iterator());
    }

    private static <T> T g(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T h(Iterable<T> iterable) {
        return (T) Iterators.n(iterable.iterator());
    }

    public static boolean i(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> j(Iterable<T> iterable, int i) {
        du1.p(iterable);
        du1.e(i >= 0, "number to skip cannot be negative");
        return new c(iterable, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] k(Iterable<?> iterable) {
        return b(iterable).toArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] l(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) b(iterable).toArray(tArr);
    }

    public static String m(Iterable<?> iterable) {
        return Iterators.v(iterable.iterator());
    }

    public static <F, T> Iterable<T> n(Iterable<F> iterable, Function<? super F, ? extends T> function) {
        du1.p(iterable);
        du1.p(function);
        return new b(iterable, function);
    }
}
