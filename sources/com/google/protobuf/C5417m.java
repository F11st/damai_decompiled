package com.google.protobuf;

import java.util.Arrays;

/* compiled from: Taobao */
/* renamed from: com.google.protobuf.m */
/* loaded from: classes10.dex */
public final class C5417m {
    private static final C5417m d = new C5417m(0, new int[0], new Object[0], false);
    private int a;
    private int[] b;
    private Object[] c;

    private C5417m() {
        this(0, new int[8], new Object[8], true);
    }

    public static C5417m a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C5417m c(C5417m c5417m, C5417m c5417m2) {
        int i = c5417m.a + c5417m2.a;
        int[] copyOf = Arrays.copyOf(c5417m.b, i);
        System.arraycopy(c5417m2.b, 0, copyOf, c5417m.a, c5417m2.a);
        Object[] copyOf2 = Arrays.copyOf(c5417m.c, i);
        System.arraycopy(c5417m2.c, 0, copyOf2, c5417m.a, c5417m2.a);
        return new C5417m(i, copyOf, copyOf2, true);
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.a; i2++) {
            C5407j.c(sb, i, String.valueOf(WireFormat.a(this.b[i2])), this.c[i2]);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof C5417m)) {
            C5417m c5417m = (C5417m) obj;
            return this.a == c5417m.a && Arrays.equals(this.b, c5417m.b) && Arrays.deepEquals(this.c, c5417m.c);
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.a) * 31) + Arrays.hashCode(this.b)) * 31) + Arrays.deepHashCode(this.c);
    }

    private C5417m(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
    }
}
