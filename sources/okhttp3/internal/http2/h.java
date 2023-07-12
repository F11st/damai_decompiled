package okhttp3.internal.http2;

import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class h {
    private int a;
    private final int[] b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.a = 0;
        Arrays.fill(this.b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return this.b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if ((this.a & 128) != 0) {
            return this.b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(int i) {
        return (this.a & 16) != 0 ? this.b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i) {
        return (this.a & 32) != 0 ? this.b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i) {
        return ((1 << i) & this.a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(h hVar) {
        for (int i = 0; i < 10; i++) {
            if (hVar.g(i)) {
                i(i, hVar.b(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h i(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.a = (1 << i) | this.a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return Integer.bitCount(this.a);
    }
}
