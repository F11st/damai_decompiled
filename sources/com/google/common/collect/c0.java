package com.google.common.collect;

import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.nm1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes10.dex */
public class c0<K> {
    transient Object[] a;
    transient int[] b;
    transient int c;
    transient int d;
    private transient int[] e;
    @VisibleForTesting
    transient long[] f;
    private transient float g;
    private transient int h;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a extends Multisets.b<K> {
        @NullableDecl
        final K a;
        int b;

        a(int i) {
            this.a = (K) c0.this.a[i];
            this.b = i;
        }

        void a() {
            int i = this.b;
            if (i == -1 || i >= c0.this.C() || !nm1.a(this.a, c0.this.a[this.b])) {
                this.b = c0.this.m(this.a);
            }
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            a();
            int i = this.b;
            if (i == -1) {
                return 0;
            }
            return c0.this.b[i];
        }

        @Override // com.google.common.collect.Multiset.Entry
        public K getElement() {
            return this.a;
        }
    }

    c0() {
        n(3, 1.0f);
    }

    private void A(int i) {
        if (this.e.length >= 1073741824) {
            this.h = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (i * this.g)) + 1;
        int[] r = r(i);
        long[] jArr = this.f;
        int length = r.length - 1;
        for (int i3 = 0; i3 < this.c; i3++) {
            int h = h(jArr[i3]);
            int i4 = h & length;
            int i5 = r[i4];
            r[i4] = i3;
            jArr[i3] = (h << 32) | (i5 & 4294967295L);
        }
        this.h = i2;
        this.e = r;
    }

    private static long D(long j, int i) {
        return (j & (-4294967296L)) | (i & 4294967295L);
    }

    public static <K> c0<K> b() {
        return new c0<>();
    }

    public static <K> c0<K> c(int i) {
        return new c0<>(i);
    }

    private static int h(long j) {
        return (int) (j >>> 32);
    }

    private static int j(long j) {
        return (int) j;
    }

    private int l() {
        return this.e.length - 1;
    }

    private static long[] q(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] r(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int w(@NullableDecl Object obj, int i) {
        int l = l() & i;
        int i2 = this.e[l];
        if (i2 == -1) {
            return 0;
        }
        int i3 = -1;
        while (true) {
            if (h(this.f[i2]) == i && nm1.a(obj, this.a[i2])) {
                int i4 = this.b[i2];
                if (i3 == -1) {
                    this.e[l] = j(this.f[i2]);
                } else {
                    long[] jArr = this.f;
                    jArr[i3] = D(jArr[i3], j(jArr[i2]));
                }
                p(i2);
                this.c--;
                this.d++;
                return i4;
            }
            int j = j(this.f[i2]);
            if (j == -1) {
                return 0;
            }
            i3 = i2;
            i2 = j;
        }
    }

    private void z(int i) {
        int length = this.f.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i, int i2) {
        du1.n(i, this.c);
        this.b[i] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.c;
    }

    public void a() {
        this.d++;
        Arrays.fill(this.a, 0, this.c, (Object) null);
        Arrays.fill(this.b, 0, this.c, 0);
        Arrays.fill(this.e, -1);
        Arrays.fill(this.f, -1L);
        this.c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        if (i > this.f.length) {
            y(i);
        }
        if (i >= this.h) {
            A(Math.max(2, Integer.highestOneBit(i - 1) << 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.c == 0 ? -1 : 0;
    }

    public int f(@NullableDecl Object obj) {
        int m = m(obj);
        if (m == -1) {
            return 0;
        }
        return this.b[m];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Multiset.Entry<K> g(int i) {
        du1.n(i, this.c);
        return new a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public K i(int i) {
        du1.n(i, this.c);
        return (K) this.a[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(int i) {
        du1.n(i, this.c);
        return this.b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(@NullableDecl Object obj) {
        int d = z.d(obj);
        int i = this.e[l() & d];
        while (i != -1) {
            long j = this.f[i];
            if (h(j) == d && nm1.a(obj, this.a[i])) {
                return i;
            }
            i = j(j);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i, float f) {
        du1.e(i >= 0, "Initial capacity must be non-negative");
        du1.e(f > 0.0f, "Illegal load factor");
        int a2 = z.a(i, f);
        this.e = r(a2);
        this.g = f;
        this.a = new Object[i];
        this.b = new int[i];
        this.f = q(i);
        this.h = Math.max(1, (int) (a2 * f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i, @NullableDecl K k, int i2, int i3) {
        this.f[i] = (i3 << 32) | 4294967295L;
        this.a[i] = k;
        this.b[i] = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i) {
        int C = C() - 1;
        if (i < C) {
            Object[] objArr = this.a;
            objArr[i] = objArr[C];
            int[] iArr = this.b;
            iArr[i] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f;
            long j = jArr[C];
            jArr[i] = j;
            jArr[C] = -1;
            int h = h(j) & l();
            int[] iArr2 = this.e;
            int i2 = iArr2[h];
            if (i2 == C) {
                iArr2[h] = i;
                return;
            }
            while (true) {
                long j2 = this.f[i2];
                int j3 = j(j2);
                if (j3 == C) {
                    this.f[i2] = D(j2, i);
                    return;
                }
                i2 = j3;
            }
        } else {
            this.a[i] = null;
            this.b[i] = 0;
            this.f[i] = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s(int i) {
        int i2 = i + 1;
        if (i2 < this.c) {
            return i2;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(int i, int i2) {
        return i - 1;
    }

    @CanIgnoreReturnValue
    public int u(@NullableDecl K k, int i) {
        k.d(i, AdUtConstants.XAD_UT_ARG_COUNT);
        long[] jArr = this.f;
        Object[] objArr = this.a;
        int[] iArr = this.b;
        int d = z.d(k);
        int l = l() & d;
        int i2 = this.c;
        int[] iArr2 = this.e;
        int i3 = iArr2[l];
        if (i3 == -1) {
            iArr2[l] = i2;
        } else {
            while (true) {
                long j = jArr[i3];
                if (h(j) == d && nm1.a(k, objArr[i3])) {
                    int i4 = iArr[i3];
                    iArr[i3] = i;
                    return i4;
                }
                int j2 = j(j);
                if (j2 == -1) {
                    jArr[i3] = D(j, i2);
                    break;
                }
                i3 = j2;
            }
        }
        if (i2 != Integer.MAX_VALUE) {
            int i5 = i2 + 1;
            z(i5);
            o(i2, k, i, d);
            this.c = i5;
            if (i2 >= this.h) {
                A(this.e.length * 2);
            }
            this.d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @CanIgnoreReturnValue
    public int v(@NullableDecl Object obj) {
        return w(obj, z.d(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int x(int i) {
        return w(this.a[i], h(this.f[i]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i) {
        this.a = Arrays.copyOf(this.a, i);
        this.b = Arrays.copyOf(this.b, i);
        long[] jArr = this.f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1L);
        }
        this.f = copyOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(c0<? extends K> c0Var) {
        n(c0Var.C(), 1.0f);
        int e = c0Var.e();
        while (e != -1) {
            u(c0Var.i(e), c0Var.k(e));
            e = c0Var.s(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(int i) {
        this(i, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(int i, float f) {
        n(i, f);
    }
}
