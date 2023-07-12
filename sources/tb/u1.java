package tb;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.SinceKotlin;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.1")
/* loaded from: classes3.dex */
public abstract class u1<E> extends AbstractCollection<E> implements List<E> {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public final void a(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void b(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void c(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            } else if (i <= i2) {
            } else {
                throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
            }
        }

        public final boolean d(@NotNull Collection<?> collection, @NotNull Collection<?> collection2) {
            b41.i(collection, com.huawei.hms.opendevice.c.a);
            b41.i(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!b41.d(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(@NotNull Collection<?> collection) {
            b41.i(collection, com.huawei.hms.opendevice.c.a);
            Iterator<?> it = collection.iterator();
            int i = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i = (i * 31) + (next != null ? next.hashCode() : 0);
            }
            return i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class b implements Iterator<E>, KMappedMarker {
        private int a;

        public b() {
        }

        protected final int a() {
            return this.a;
        }

        protected final void b(int i) {
            this.a = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < u1.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                u1<E> u1Var = u1.this;
                int i = this.a;
                this.a = i + 1;
                return u1Var.get(i);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class c extends u1<E>.b implements ListIterator<E> {
        public c(int i) {
            super();
            u1.Companion.b(i, u1.this.size());
            b(i);
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                u1<E> u1Var = u1.this;
                b(a() - 1);
                return u1Var.get(a());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class d<E> extends u1<E> implements RandomAccess {
        @NotNull
        private final u1<E> a;
        private final int b;
        private int c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull u1<? extends E> u1Var, int i, int i2) {
            b41.i(u1Var, "list");
            this.a = u1Var;
            this.b = i;
            u1.Companion.c(i, i2, u1Var.size());
            this.c = i2 - i;
        }

        @Override // kotlin.collections.AbstractCollection
        public int a() {
            return this.c;
        }

        @Override // tb.u1, java.util.List
        public E get(int i) {
            u1.Companion.a(i, this.c);
            return this.a.get(this.b + i);
        }
    }

    @Override // java.util.List
    public void add(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.d(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.e(this);
    }

    public int indexOf(E e) {
        int i = 0;
        for (E e2 : this) {
            if (b41.d(e2, e)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(E e) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (b41.d(listIterator.previous(), e)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<E> subList(int i, int i2) {
        return new d(this, i, i2);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i) {
        return new c(i);
    }
}
