package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* compiled from: Taobao */
@GwtCompatible(serializable = true)
/* loaded from: classes10.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    /* compiled from: Taobao */
    /* renamed from: com.google.common.base.Optional$a */
    /* loaded from: classes10.dex */
    static class C4826a implements Iterable<T> {
        final /* synthetic */ Iterable a;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.base.Optional$a$a */
        /* loaded from: classes10.dex */
        class C4827a extends AbstractIterator<T> {
            private final Iterator<? extends Optional<? extends T>> c;

            C4827a() {
                this.c = (Iterator) du1.p(C4826a.this.a.iterator());
            }

            @Override // com.google.common.base.AbstractIterator
            protected T a() {
                while (this.c.hasNext()) {
                    Optional<? extends T> next = this.c.next();
                    if (next.isPresent()) {
                        return next.get();
                    }
                }
                return b();
            }
        }

        C4826a(Iterable iterable) {
            this.a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new C4827a();
        }
    }

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T t) {
        return t == null ? absent() : new Present(t);
    }

    public static <T> Optional<T> of(T t) {
        return new Present(du1.p(t));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        du1.p(iterable);
        return new C4826a(iterable);
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(@NullableDecl Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    @Beta
    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t);

    @NullableDecl
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
