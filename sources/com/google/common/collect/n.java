package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import java.util.Iterator;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
public abstract class n<E> implements Iterable<E> {
    private final Optional<Iterable<E>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a extends n<E> {
        final /* synthetic */ Iterable b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.b = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.b.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b<T> extends n<T> {
        final /* synthetic */ Iterable[] b;

        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        class a extends com.google.common.collect.a<Iterator<? extends T>> {
            a(int i) {
                super(i);
            }

            @Override // com.google.common.collect.a
            /* renamed from: b */
            public Iterator<? extends T> a(int i) {
                return b.this.b[i].iterator();
            }
        }

        b(Iterable[] iterableArr) {
            this.b = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.e(new a(this.b.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public n() {
        this.a = Optional.absent();
    }

    @Beta
    public static <T> n<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return b(iterable, iterable2);
    }

    private static <T> n<T> b(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            du1.p(iterable);
        }
        return new b(iterableArr);
    }

    public static <E> n<E> d(Iterable<E> iterable) {
        return iterable instanceof n ? (n) iterable : new a(iterable, iterable);
    }

    private Iterable<E> e() {
        return this.a.or((Optional<Iterable<E>>) this);
    }

    public final n<E> c(Predicate<? super E> predicate) {
        return d(a0.d(e(), predicate));
    }

    public final ImmutableSet<E> f() {
        return ImmutableSet.copyOf(e());
    }

    public String toString() {
        return a0.m(e());
    }

    n(Iterable<E> iterable) {
        du1.p(iterable);
        this.a = Optional.fromNullable(this == iterable ? null : iterable);
    }
}
