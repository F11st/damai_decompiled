package com.google.protobuf;

import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class m {
    private static final m d = new m(0, new int[0], new Object[0], false);
    private int a;
    private int[] b;
    private Object[] c;

    private m() {
        this(0, new int[8], new Object[8], true);
    }

    public static m a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m c(m mVar, m mVar2) {
        int i = mVar.a + mVar2.a;
        int[] copyOf = Arrays.copyOf(mVar.b, i);
        System.arraycopy(mVar2.b, 0, copyOf, mVar.a, mVar2.a);
        Object[] copyOf2 = Arrays.copyOf(mVar.c, i);
        System.arraycopy(mVar2.c, 0, copyOf2, mVar.a, mVar2.a);
        return new m(i, copyOf, copyOf2, true);
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            j.c(sb, i, String.valueOf(WireFormat.a(this.b[i2])), this.c[i2]);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof m)) {
            m mVar = (m) obj;
            return this.a == mVar.a && Arrays.equals(this.b, mVar.b) && Arrays.deepEquals(this.c, mVar.c);
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.a) * 31) + Arrays.hashCode(this.b)) * 31) + Arrays.deepHashCode(this.c);
    }

    private m(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
    }
}
