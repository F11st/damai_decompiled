package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class r43 {
    private static int a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i = a;
        int i2 = i - (length % i);
        int i3 = ((length / i) + 1) * i;
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i3) {
            bArr3[length] = (byte) i2;
            length++;
        }
        int[] b = b(bArr3);
        int[] b2 = b(bArr2);
        int length2 = b.length - 1;
        if (length2 > 0) {
            if (b2.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(b2, 0, iArr, 0, b2.length);
                b2 = iArr;
            }
            int i4 = b[length2];
            int i5 = (52 / (length2 + 1)) + 6;
            int i6 = 0;
            while (true) {
                int i7 = i5 - 1;
                if (i5 <= 0) {
                    break;
                }
                i6 -= 1640531527;
                int i8 = (i6 >>> 2) & 3;
                int i9 = 0;
                while (i9 < length2) {
                    int i10 = i9 + 1;
                    int i11 = b[i10];
                    i4 = ((((i4 >>> 5) ^ (i11 << 2)) + ((i11 >>> 3) ^ (i4 << 4))) ^ ((i11 ^ i6) + (i4 ^ b2[(i9 & 3) ^ i8]))) + b[i9];
                    b[i9] = i4;
                    i9 = i10;
                }
                int i12 = b[0];
                i4 = ((((i4 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i4 << 4))) ^ ((i12 ^ i6) + (i4 ^ b2[i8 ^ (i9 & 3)]))) + b[length2];
                b[length2] = i4;
                i5 = i7;
            }
        }
        int length3 = b.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i13 = 0; i13 < length3; i13++) {
            bArr4[i13] = (byte) ((b[i13 >>> 2] >>> ((i13 & 3) << 3)) & 255);
        }
        return bArr4;
    }

    private static int[] b(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr;
    }
}
