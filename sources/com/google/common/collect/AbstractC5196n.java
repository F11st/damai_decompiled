package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import java.util.Iterator;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* renamed from: com.google.common.collect.n */
/* loaded from: classes10.dex */
public abstract class AbstractC5196n<E> implements Iterable<E> {
    private final Optional<Iterable<E>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.collect.n$a */
    /* loaded from: classes10.dex */
    public static class C5197a extends AbstractC5196n<E> {
        final /* synthetic */ Iterable b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C5197a(Iterable iterable, Iterable iterable2) {
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
    /* renamed from: com.google.common.collect.n$b */
    /* loaded from: classes10.dex */
    public static class C5198b<T> extends AbstractC5196n<T> {
        final /* synthetic */ Iterable[] b;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.collect.n$b$a */
        /* loaded from: classes10.dex */
        class C5199a extends AbstractC5151a<Iterator<? extends T>> {
            C5199a(int i) {
                super(i);
            }

            @Override // com.google.common.collect.AbstractC5151a
            /* renamed from: b */
            public Iterator<? extends T> a(int i) {
                return C5198b.this.b[i].iterator();
            }
        }

        C5198b(Iterable[] iterableArr) {
            this.b = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.e(new C5199a(this.b.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractC5196n() {
        this.a = Optional.absent();
    }

    @Beta
    public static <T> AbstractC5196n<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return b(iterable, iterable2);
    }

    private static <T> AbstractC5196n<T> b(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            du1.p(iterable);
        }
        return new C5198b(iterableArr);
    }

    public static <E> AbstractC5196n<E> d(Iterable<E> iterable) {
        return iterable instanceof AbstractC5196n ? (AbstractC5196n) iterable : new C5197a(iterable, iterable);
    }

    private Iterable<E> e() {
        return this.a.or((Optional<Iterable<E>>) this);
    }

    public final AbstractC5196n<E> c(Predicate<? super E> predicate) {
        return d(C5152a0.d(e(), predicate));
    }

    public final ImmutableSet<E> f() {
        return ImmutableSet.copyOf(e());
    }

    public String toString() {
        return C5152a0.m(e());
    }

    AbstractC5196n(Iterable<E> iterable) {
        du1.p(iterable);
        this.a = Optional.fromNullable(this == iterable ? null : iterable);
    }
}
