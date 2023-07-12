package tb;

import java.lang.Comparable;
import java.util.Arrays;
import kotlin.PublishedApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@InternalCoroutinesApi
/* loaded from: classes11.dex */
public class sm2<T extends ThreadSafeHeapNode & Comparable<? super T>> {
    private volatile int _size = 0;
    private T[] a;

    private final T[] f() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        } else if (c() >= tArr.length) {
            Object[] copyOf = Arrays.copyOf(tArr, c() * 2);
            b41.h(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            T[] tArr3 = (T[]) ((ThreadSafeHeapNode[]) copyOf);
            this.a = tArr3;
            return tArr3;
        } else {
            return tArr;
        }
    }

    private final void j(int i) {
        this._size = i;
    }

    private final void k(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= c()) {
                return;
            }
            T[] tArr = this.a;
            b41.f(tArr);
            int i3 = i2 + 1;
            if (i3 < c()) {
                T t = tArr[i3];
                b41.f(t);
                T t2 = tArr[i2];
                b41.f(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            b41.f(t3);
            T t4 = tArr[i2];
            b41.f(t4);
            if (((Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    private final void l(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            b41.f(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            b41.f(t);
            T t2 = tArr[i];
            b41.f(t2);
            if (((Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            m(i, i2);
            i = i2;
        }
    }

    private final void m(int i, int i2) {
        T[] tArr = this.a;
        b41.f(tArr);
        T t = tArr[i2];
        b41.f(t);
        T t2 = tArr[i];
        b41.f(t2);
        tArr[i] = t;
        tArr[i2] = t2;
        t.setIndex(i);
        t2.setIndex(i2);
    }

    @PublishedApi
    public final void a(@NotNull T t) {
        if (k40.a()) {
            if (!(t.getHeap() == null)) {
                throw new AssertionError();
            }
        }
        t.setHeap(this);
        T[] f = f();
        int c = c();
        j(c + 1);
        f[c] = t;
        t.setIndex(c);
        l(c);
    }

    @PublishedApi
    @Nullable
    public final T b() {
        T[] tArr = this.a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        return c() == 0;
    }

    @Nullable
    public final T e() {
        T b;
        synchronized (this) {
            b = b();
        }
        return b;
    }

    public final boolean g(@NotNull T t) {
        boolean z;
        synchronized (this) {
            z = true;
            if (t.getHeap() == null) {
                z = false;
            } else {
                int index = t.getIndex();
                if (k40.a()) {
                    if (!(index >= 0)) {
                        throw new AssertionError();
                    }
                }
                h(index);
            }
        }
        return z;
    }

    @PublishedApi
    @NotNull
    public final T h(int i) {
        if (k40.a()) {
            if (!(c() > 0)) {
                throw new AssertionError();
            }
        }
        T[] tArr = this.a;
        b41.f(tArr);
        j(c() - 1);
        if (i < c()) {
            m(i, c());
            int i2 = (i - 1) / 2;
            if (i > 0) {
                T t = tArr[i];
                b41.f(t);
                T t2 = tArr[i2];
                b41.f(t2);
                if (((Comparable) t).compareTo(t2) < 0) {
                    m(i, i2);
                    l(i2);
                }
            }
            k(i);
        }
        T t3 = tArr[c()];
        b41.f(t3);
        if (k40.a()) {
            if (!(t3.getHeap() == this)) {
                throw new AssertionError();
            }
        }
        t3.setHeap(null);
        t3.setIndex(-1);
        tArr[c()] = null;
        return t3;
    }

    @Nullable
    public final T i() {
        T h;
        synchronized (this) {
            h = c() > 0 ? h(0) : null;
        }
        return h;
    }
}
