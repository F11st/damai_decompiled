package kotlin.reflect.jvm.internal.pcollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class a<E> implements Iterable<E> {
    private static final a<Object> d = new a<>();
    final E a;
    final a<E> b;
    private final int c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.pcollections.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0431a<E> implements Iterator<E> {
        private a<E> a;

        public C0431a(a<E> aVar) {
            this.a = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return ((a) this.a).c > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.a;
            E e = aVar.a;
            this.a = aVar.b;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private a() {
        this.c = 0;
        this.a = null;
        this.b = null;
    }

    public static <E> a<E> b() {
        return (a<E>) d;
    }

    private Iterator<E> c(int i) {
        return new C0431a(g(i));
    }

    private a<E> e(Object obj) {
        if (this.c == 0) {
            return this;
        }
        if (this.a.equals(obj)) {
            return this.b;
        }
        a<E> e = this.b.e(obj);
        return e == this.b ? this : new a<>(this.a, e);
    }

    private a<E> g(int i) {
        if (i < 0 || i > this.c) {
            throw new IndexOutOfBoundsException();
        }
        return i == 0 ? this : this.b.g(i - 1);
    }

    public a<E> d(int i) {
        return e(get(i));
    }

    public a<E> f(E e) {
        return new a<>(e, this);
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

    private a(E e, a<E> aVar) {
        this.a = e;
        this.b = aVar;
        this.c = aVar.c + 1;
    }
}
