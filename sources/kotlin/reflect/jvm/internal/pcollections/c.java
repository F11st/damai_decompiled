package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class c<V> {
    static final c<Object> f = new c<>();
    private final long a;
    private final V b;
    private final c<V> c;
    private final c<V> d;
    private final int e;

    private c() {
        this.e = 0;
        this.a = 0L;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    private static <V> c<V> c(long j, V v, c<V> cVar, c<V> cVar2) {
        int i = ((c) cVar).e;
        int i2 = ((c) cVar2).e;
        if (i + i2 > 1) {
            if (i >= i2 * 5) {
                c<V> cVar3 = ((c) cVar).c;
                c<V> cVar4 = ((c) cVar).d;
                if (((c) cVar4).e < ((c) cVar3).e * 2) {
                    long j2 = ((c) cVar).a;
                    return new c<>(j2 + j, ((c) cVar).b, cVar3, new c(-j2, v, cVar4.e(((c) cVar4).a + j2), cVar2));
                }
                c<V> cVar5 = ((c) cVar4).c;
                c<V> cVar6 = ((c) cVar4).d;
                long j3 = ((c) cVar4).a;
                long j4 = ((c) cVar).a + j3 + j;
                V v2 = ((c) cVar4).b;
                c cVar7 = new c(-j3, ((c) cVar).b, cVar3, cVar5.e(((c) cVar5).a + j3));
                long j5 = ((c) cVar).a;
                long j6 = ((c) cVar4).a;
                return new c<>(j4, v2, cVar7, new c((-j5) - j6, v, cVar6.e(((c) cVar6).a + j6 + j5), cVar2));
            } else if (i2 >= i * 5) {
                c<V> cVar8 = ((c) cVar2).c;
                c<V> cVar9 = ((c) cVar2).d;
                if (((c) cVar8).e < ((c) cVar9).e * 2) {
                    long j7 = ((c) cVar2).a;
                    return new c<>(j7 + j, ((c) cVar2).b, new c(-j7, v, cVar, cVar8.e(((c) cVar8).a + j7)), cVar9);
                }
                c<V> cVar10 = ((c) cVar8).c;
                c<V> cVar11 = ((c) cVar8).d;
                long j8 = ((c) cVar8).a;
                long j9 = ((c) cVar2).a;
                long j10 = j8 + j9 + j;
                V v3 = ((c) cVar8).b;
                c cVar12 = new c((-j9) - j8, v, cVar, cVar10.e(((c) cVar10).a + j8 + j9));
                long j11 = ((c) cVar8).a;
                return new c<>(j10, v3, cVar12, new c(-j11, ((c) cVar2).b, cVar11.e(((c) cVar11).a + j11), cVar9));
            }
        }
        return new c<>(j, v, cVar, cVar2);
    }

    private c<V> d(c<V> cVar, c<V> cVar2) {
        return (cVar == this.c && cVar2 == this.d) ? this : c(this.a, this.b, cVar, cVar2);
    }

    private c<V> e(long j) {
        return (this.e == 0 || j == this.a) ? this : new c<>(j, this.b, this.c, this.d);
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
    public c<V> b(long j, V v) {
        if (this.e == 0) {
            return new c<>(j, v, this, this);
        }
        long j2 = this.a;
        if (j < j2) {
            return d(this.c.b(j - j2, v), this.d);
        }
        if (j > j2) {
            return d(this.c, this.d.b(j - j2, v));
        }
        return v == this.b ? this : new c<>(j, v, this.c, this.d);
    }

    private c(long j, V v, c<V> cVar, c<V> cVar2) {
        this.a = j;
        this.b = v;
        this.c = cVar;
        this.d = cVar2;
        this.e = cVar.e + 1 + cVar2.e;
    }
}
