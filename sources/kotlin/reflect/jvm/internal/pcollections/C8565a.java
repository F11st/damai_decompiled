package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.pcollections.a */
/* loaded from: classes3.dex */
final class C8565a<E> implements Iterable<E> {
    private static final C8565a<Object> d = new C8565a<>();
    final E a;
    final C8565a<E> b;
    private final int c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.pcollections.a$a */
    /* loaded from: classes3.dex */
    public static class C8566a<E> implements Iterator<E> {
        private C8565a<E> a;

        public C8566a(C8565a<E> c8565a) {
            this.a = c8565a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return ((C8565a) this.a).c > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            C8565a<E> c8565a = this.a;
            E e = c8565a.a;
            this.a = c8565a.b;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private C8565a() {
        this.c = 0;
        this.a = null;
        this.b = null;
    }

    public static <E> C8565a<E> b() {
        return (C8565a<E>) d;
    }

    private Iterator<E> c(int i) {
        return new C8566a(g(i));
    }

    private C8565a<E> e(Object obj) {
        if (this.c == 0) {
            return this;
        }
        if (this.a.equals(obj)) {
            return this.b;
        }
        C8565a<E> e = this.b.e(obj);
        return e == this.b ? this : new C8565a<>(this.a, e);
    }

    private C8565a<E> g(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException();
        }
        return i == 0 ? this : this.b.g(i - 1);
    }

    public C8565a<E> d(int i) {
        return e(get(i));
    }

    public C8565a<E> f(E e) {
        return new C8565a<>(e, this);
    }

    public E get(int i) {
        if (i >= 0 && i <= this.c) {
            try {
                return c(i).next();
            } catch (NoSuchElementException unused) {
                throw new IndexOutOfBoundsException("Index: " + i);
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return c(0);
    }

    public int size() {
        return this.c;
    }

    private C8565a(E e, C8565a<E> c8565a) {
        this.a = e;
        this.b = c8565a;
        this.c = c8565a.c + 1;
    }
}
