package com.amap.api.col.s;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class au {
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
        return a(a(a(bArr3), a(bArr2)));
    }

    private static int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length <= 0) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i = iArr[length];
        int i2 = (52 / (length + 1)) + 6;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return iArr;
            }
            i3 -= 1640531527;
            int i5 = (i3 >>> 2) & 3;
            int i6 = 0;
            while (i6 < length) {
                int i7 = i6 + 1;
                int i8 = iArr[i7];
                i = ((((i >>> 5) ^ (i8 << 2)) + ((i8 >>> 3) ^ (i << 4))) ^ ((i8 ^ i3) + (i ^ iArr2[(i6 & 3) ^ i5]))) + iArr[i6];
                iArr[i6] = i;
                i6 = i7;
            }
            int i9 = iArr[0];
            i = ((((i >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i << 4))) ^ ((i9 ^ i3) + (i ^ iArr2[i5 ^ (i6 & 3)]))) + iArr[length];
            iArr[length] = i;
            i2 = i4;
        }
    }

    private static int[] a(byte[] bArr) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr;
    }

    private static byte[] a(int[] iArr) {
        int length = iArr.length << 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ((iArr[i >>> 2] >>> ((i & 3) << 3)) & 255);
        }
        return bArr;
    }
}
