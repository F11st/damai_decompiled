package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.ty1;
import tb.u1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class b0<T> extends u1<T> implements RandomAccess {
    @NotNull
    private final Object[] a;
    private final int b;
    private int c;
    private int d;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a extends kotlin.collections.a<T> {
        private int c;
        private int d;
        final /* synthetic */ b0<T> e;

        a(b0<T> b0Var) {
            this.e = b0Var;
            this.c = b0Var.size();
            this.d = ((b0) b0Var).c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.a
        protected void a() {
            if (this.c != 0) {
                c(((b0) this.e).a[this.d]);
                this.d = (this.d + 1) % ((b0) this.e).b;
                this.c--;
                return;
            }
            b();
        }
    }

    public b0(@NotNull Object[] objArr, int i) {
        b41.i(objArr, "buffer");
        this.a = objArr;
        if (i >= 0) {
            if (i <= objArr.length) {
                this.b = objArr.length;
                this.d = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + objArr.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }

    @Override // kotlin.collections.AbstractCollection
    public int a() {
        return this.d;
    }

    public final void e(T t) {
        if (!g()) {
            this.a[(this.c + size()) % this.b] = t;
            this.d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final b0<T> f(int i) {
        int d;
        Object[] array;
        int i2 = this.b;
        d = ty1.d(i2 + (i2 >> 1) + 1, i);
        if (this.c == 0) {
            array = Arrays.copyOf(this.a, d);
            b41.h(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[d]);
        }
        return new b0<>(array, size());
    }

    public final boolean g() {
        return size() == this.b;
    }

    @Override // tb.u1, java.util.List
    public T get(int i) {
        u1.Companion.a(i, size());
        return (T) this.a[(this.c + i) % this.b];
    }

    public final void h(int i) {
        if (i >= 0) {
            if (!(i <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
            } else if (i > 0) {
                int i2 = this.c;
                int i3 = (i2 + i) % this.b;
                if (i2 > i3) {
                    h.j(this.a, null, i2, this.b);
                    h.j(this.a, null, 0, i3);
                } else {
                    h.j(this.a, null, i2, i3);
                }
                this.c = i3;
                this.d = size() - i;
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
    }

    @Override // tb.u1, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        b41.i(tArr, "array");
        if (tArr.length < size()) {
            tArr = (T[]) Arrays.copyOf(tArr, size());
            b41.h(tArr, "copyOf(this, newSize)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.c; i2 < size && i3 < this.b; i3++) {
            tArr[i2] = this.a[i3];
            i2++;
        }
        while (i2 < size) {
            tArr[i2] = this.a[i];
            i2++;
            i++;
        }
        if (tArr.length > size()) {
            tArr[size()] = null;
        }
        b41.g(tArr, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return tArr;
    }

    public b0(int i) {
        this(new Object[i], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
