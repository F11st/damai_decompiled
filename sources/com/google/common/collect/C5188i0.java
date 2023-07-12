package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.math.C5238c;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible
/* renamed from: com.google.common.collect.i0 */
/* loaded from: classes10.dex */
public final class C5188i0<T> {
    private final int a;
    private final Comparator<? super T> b;
    private final T[] c;
    private int d;
    @NullableDecl
    private T e;

    private C5188i0(Comparator<? super T> comparator, int i) {
        this.b = (Comparator) du1.q(comparator, "comparator");
        this.a = i;
        du1.f(i >= 0, "k must be nonnegative, was %s", i);
        this.c = (T[]) new Object[i * 2];
        this.d = 0;
        this.e = null;
    }

    public static <T> C5188i0<T> a(int i, Comparator<? super T> comparator) {
        return new C5188i0<>(comparator, i);
    }

    private int d(int i, int i2, int i3) {
        T[] tArr = this.c;
        T t = tArr[i3];
        tArr[i3] = tArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.b.compare((Object) this.c[i], t) < 0) {
                e(i4, i);
                i4++;
            }
            i++;
        }
        T[] tArr2 = this.c;
        tArr2[i2] = tArr2[i4];
        tArr2[i4] = t;
        return i4;
    }

    private void e(int i, int i2) {
        T[] tArr = this.c;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    private void g() {
        int i = (this.a * 2) - 1;
        int e = C5238c.e(i + 0, RoundingMode.CEILING) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 < i) {
                int d = d(i2, i, ((i2 + i) + 1) >>> 1);
                int i5 = this.a;
                if (d <= i5) {
                    if (d >= i5) {
                        break;
                    }
                    i2 = Math.max(d, i2 + 1);
                    i4 = d;
                } else {
                    i = d - 1;
                }
                i3++;
                if (i3 >= e) {
                    Arrays.sort(this.c, i2, i, this.b);
                    break;
                }
            } else {
                break;
            }
        }
        this.d = this.a;
        this.e = this.c[i4];
        while (true) {
            i4++;
            if (i4 >= this.a) {
                return;
            }
            if (this.b.compare((Object) this.c[i4], (T) this.e) > 0) {
                this.e = this.c[i4];
            }
        }
    }

    public void b(@NullableDecl T t) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        int i2 = this.d;
        if (i2 == 0) {
            this.c[0] = t;
            this.e = t;
            this.d = 1;
        } else if (i2 < i) {
            T[] tArr = this.c;
            this.d = i2 + 1;
            tArr[i2] = t;
            if (this.b.compare(t, (T) this.e) > 0) {
                this.e = t;
            }
        } else if (this.b.compare(t, (T) this.e) < 0) {
            T[] tArr2 = this.c;
            int i3 = this.d;
            int i4 = i3 + 1;
            this.d = i4;
            tArr2[i3] = t;
            if (i4 == this.a * 2) {
                g();
            }
        }
    }

    public void c(Iterator<? extends T> it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public List<T> f() {
        Arrays.sort(this.c, 0, this.d, this.b);
        int i = this.d;
        int i2 = this.a;
        if (i > i2) {
            T[] tArr = this.c;
            Arrays.fill(tArr, i2, tArr.length, (Object) null);
            int i3 = this.a;
            this.d = i3;
            this.e = this.c[i3 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.c, this.d)));
    }
}
