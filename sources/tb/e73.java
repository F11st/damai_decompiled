package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e73 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.e73$a */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC9085a {
        public byte[] a;
        public int b;

        AbstractC9085a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.e73$b */
    /* loaded from: classes10.dex */
    public static class C9086b extends AbstractC9085a {
        private static final int[] f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private int c;
        private int d;
        private final int[] e;

        public C9086b(byte[] bArr) {
            this.a = bArr;
            this.e = f;
            this.c = 0;
            this.d = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:64:0x00f3, code lost:
            if (r1 != 4) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean a(byte[] r18, int r19) {
            /*
                Method dump skipped, instructions count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.e73.C9086b.a(byte[], int):boolean");
        }
    }

    public static byte[] a(byte[] bArr) {
        return b(bArr, bArr.length);
    }

    private static byte[] b(byte[] bArr, int i) {
        C9086b c9086b = new C9086b(new byte[(i * 3) / 4]);
        if (c9086b.a(bArr, i)) {
            int i2 = c9086b.b;
            byte[] bArr2 = c9086b.a;
            if (i2 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i2];
            System.arraycopy(bArr2, 0, bArr3, 0, i2);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
