package tb;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class qe {
    public static int a(byte[] bArr) {
        if (bArr == null || bArr.length > 4) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= (bArr[i2] & 255) << (((bArr.length - i2) - 1) * 8);
        }
        return i;
    }

    public static int b(byte[] bArr, int i, int i2) {
        if (bArr == null || i < 0 || i2 < 0 || bArr.length < i + i2) {
            return 0;
        }
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr2[i3] = bArr[i];
            i++;
        }
        return a(bArr2);
    }

    public static byte[] c(int i) {
        return new byte[]{(byte) (i & 255)};
    }

    public static byte[] d(int i) {
        return new byte[]{(byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] e(int i) {
        return new byte[]{(byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] f(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] g(byte[] bArr, int i, int i2) {
        int i3;
        if (bArr == null || i < 0 || i2 < 0 || bArr.length < (i3 = i + i2)) {
            return null;
        }
        byte[] bArr2 = new byte[i2];
        for (int i4 = i; i4 < i3; i4++) {
            bArr2[i4 - i] = bArr[i4];
        }
        return bArr2;
    }
}
