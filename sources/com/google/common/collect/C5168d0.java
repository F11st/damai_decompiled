package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

/* compiled from: Taobao */
@GwtCompatible(emulated = true, serializable = true)
/* renamed from: com.google.common.collect.d0 */
/* loaded from: classes10.dex */
class C5168d0<K> extends C5163c0<K> {
    @VisibleForTesting
    transient long[] i;
    private transient int j;
    private transient int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C5168d0(int i) {
        this(i, 1.0f);
    }

    private int E(int i) {
        return (int) (this.i[i] >>> 32);
    }

    private int F(int i) {
        return (int) this.i[i];
    }

    private void G(int i, int i2) {
        long[] jArr = this.i;
        jArr[i] = (jArr[i] & 4294967295L) | (i2 << 32);
    }

    private void H(int i, int i2) {
        if (i == -2) {
            this.j = i2;
        } else {
            I(i, i2);
        }
        if (i2 == -2) {
            this.k = i;
        } else {
            G(i2, i);
        }
    }

    private void I(int i, int i2) {
        long[] jArr = this.i;
        jArr[i] = (jArr[i] & (-4294967296L)) | (i2 & 4294967295L);
    }

    @Override // com.google.common.collect.C5163c0
    public void a() {
        super.a();
        this.j = -2;
        this.k = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.C5163c0
    public int e() {
        int i = this.j;
        if (i == -2) {
            return -1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.C5163c0
    public void n(int i, float f) {
        super.n(i, f);
        this.j = -2;
        this.k = -2;
        long[] jArr = new long[i];
        this.i = jArr;
        Arrays.fill(jArr, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.C5163c0
    public void o(int i, K k, int i2, int i3) {
        super.o(i, k, i2, i3);
        H(this.k, i);
        H(i, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.C5163c0
    public void p(int i) {
        int C = C() - 1;
        H(E(i), F(i));
        if (i < C) {
            H(E(C), i);
            H(i, F(C));
        }
        super.p(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.C5163c0
    public int s(int i) {
        int F = F(i);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.C5163c0
    public int t(int i, int i2) {
        return i == C() ? i2 : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.C5163c0
    public void y(int i) {
        super.y(i);
        long[] jArr = this.i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        this.i = copyOf;
        Arrays.fill(copyOf, length, i, -1L);
    }

    C5168d0(int i, float f) {
        super(i, f);
    }
}
