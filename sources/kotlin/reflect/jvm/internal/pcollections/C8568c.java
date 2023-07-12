package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.pcollections.c */
/* loaded from: classes3.dex */
final class C8568c<V> {
    static final C8568c<Object> f = new C8568c<>();
    private final long a;
    private final V b;
    private final C8568c<V> c;
    private final C8568c<V> d;
    private final int e;

    private C8568c() {
        this.e = 0;
        this.a = 0L;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    private static <V> C8568c<V> c(long j, V v, C8568c<V> c8568c, C8568c<V> c8568c2) {
        int i = ((C8568c) c8568c).e;
        int i2 = ((C8568c) c8568c2).e;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                C8568c<V> c8568c3 = ((C8568c) c8568c).c;
                C8568c<V> c8568c4 = ((C8568c) c8568c).d;
                if (((C8568c) c8568c4).e < ((C8568c) c8568c3).e * 2) {
                    long j2 = ((C8568c) c8568c).a;
                    return new C8568c<>(j2 + j, ((C8568c) c8568c).b, c8568c3, new C8568c(-j2, v, c8568c4.e(((C8568c) c8568c4).a + j2), c8568c2));
                }
                C8568c<V> c8568c5 = ((C8568c) c8568c4).c;
                C8568c<V> c8568c6 = ((C8568c) c8568c4).d;
                long j3 = ((C8568c) c8568c4).a;
                long j4 = ((C8568c) c8568c).a + j3 + j;
                V v2 = ((C8568c) c8568c4).b;
                C8568c c8568c7 = new C8568c(-j3, ((C8568c) c8568c).b, c8568c3, c8568c5.e(((C8568c) c8568c5).a + j3));
                long j5 = ((C8568c) c8568c).a;
                long j6 = ((C8568c) c8568c4).a;
                return new C8568c<>(j4, v2, c8568c7, new C8568c((-j5) - j6, v, c8568c6.e(((C8568c) c8568c6).a + j6 + j5), c8568c2));
            } else if (i2 >= i * 5) {
                C8568c<V> c8568c8 = ((C8568c) c8568c2).c;
                C8568c<V> c8568c9 = ((C8568c) c8568c2).d;
                if (((C8568c) c8568c8).e < ((C8568c) c8568c9).e * 2) {
                    long j7 = ((C8568c) c8568c2).a;
                    return new C8568c<>(j7 + j, ((C8568c) c8568c2).b, new C8568c(-j7, v, c8568c, c8568c8.e(((C8568c) c8568c8).a + j7)), c8568c9);
                }
                C8568c<V> c8568c10 = ((C8568c) c8568c8).c;
                C8568c<V> c8568c11 = ((C8568c) c8568c8).d;
                long j8 = ((C8568c) c8568c8).a;
                long j9 = ((C8568c) c8568c2).a;
                long j10 = j8 + j9 + j;
                V v3 = ((C8568c) c8568c8).b;
                C8568c c8568c12 = new C8568c((-j9) - j8, v, c8568c, c8568c10.e(((C8568c) c8568c10).a + j8 + j9));
                long j11 = ((C8568c) c8568c8).a;
                return new C8568c<>(j10, v3, c8568c12, new C8568c(-j11, ((C8568c) c8568c2).b, c8568c11.e(((C8568c) c8568c11).a + j11), c8568c9));
            }
        }
        return new C8568c<>(j, v, c8568c, c8568c2);
    }

    private C8568c<V> d(C8568c<V> c8568c, C8568c<V> c8568c2) {
        return (c8568c == this.c && c8568c2 == this.d) ? this : c(this.a, this.b, c8568c, c8568c2);
    }

    private C8568c<V> e(long j) {
        return (this.e == 0 || j == this.a) ? this : new C8568c<>(j, this.b, this.c, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V a(long j) {
        if (this.e == 0) {
            return null;
        }
        long j2 = this.a;
        if (j < j2) {
            return this.c.a(j - j2);
        }
        if (j > j2) {
            return this.d.a(j - j2);
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C8568c<V> b(long j, V v) {
        if (this.e == 0) {
            return new C8568c<>(j, v, this, this);
        }
        long j2 = this.a;
        if (j < j2) {
            return d(this.c.b(j - j2, v), this.d);
        }
        if (j > j2) {
            return d(this.c, this.d.b(j - j2, v));
        }
        return v == this.b ? this : new C8568c<>(j, v, this.c, this.d);
    }

    private C8568c(long j, V v, C8568c<V> c8568c, C8568c<V> c8568c2) {
        this.a = j;
        this.b = v;
        this.c = c8568c;
        this.d = c8568c2;
        this.e = c8568c.e + 1 + c8568c2.e;
    }
}
