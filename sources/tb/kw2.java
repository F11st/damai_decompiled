package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kw2 {
    private static long[] a = new long[256];

    static {
        for (int i = 0; i < 256; i++) {
            long j = i;
            for (int i2 = 0; i2 < 8; i2++) {
                j = (j >> 1) ^ ((((int) j) & 1) != 0 ? -7661587058870466123L : 0L);
            }
            a[i] = j;
        }
    }

    public static void a(boolean z) {
        if (!z) {
            throw new AssertionError();
        }
    }

    public static long b(String str) {
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return c(d(str));
    }

    public static long c(byte[] bArr) {
        long j = -1;
        for (byte b : bArr) {
            j = (j >> 8) ^ a[(((int) j) ^ b) & 255];
        }
        return j;
    }

    public static byte[] d(String str) {
        char[] charArray;
        byte[] bArr = new byte[str.length() * 2];
        int i = 0;
        for (char c : str.toCharArray()) {
            int i2 = i + 1;
            bArr[i] = (byte) (c & 255);
            i = i2 + 1;
            bArr[i2] = (byte) (c >> '\b');
        }
        return bArr;
    }
}
