package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class wp0 {
    private final int[] a = new int[256];
    private final int[] b = new int[256];
    private final xp0 c;
    public static final wp0 QR_CODE_FIELD = new wp0(285);
    public static final wp0 DATA_MATRIX_FIELD = new wp0(301);

    private wp0(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 256; i3++) {
            this.a[i3] = i2;
            i2 <<= 1;
            if (i2 >= 256) {
                i2 ^= i;
            }
        }
        for (int i4 = 0; i4 < 255; i4++) {
            this.b[this.a[i4]] = i4;
        }
        this.c = new xp0(this, new int[]{0});
        new xp0(this, new int[]{1});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2) {
        return i ^ i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xp0 b(int i, int i2) {
        if (i >= 0) {
            if (i2 == 0) {
                return this.c;
            }
            int[] iArr = new int[i + 1];
            iArr[0] = i2;
            return new xp0(this, iArr);
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return this.a[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xp0 d() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(int i) {
        if (i != 0) {
            return this.a[255 - this.b[i]];
        }
        throw new ArithmeticException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i) {
        if (i != 0) {
            return this.b[i];
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.b;
        int i3 = iArr[i] + iArr[i2];
        return this.a[(i3 & 255) + (i3 >>> 8)];
    }
}
