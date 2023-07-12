package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gx {
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
        return a(a(a(bArr3, true), a(bArr2, false)), false);
    }

    public static int[] a(int[] iArr, int[] iArr2) {
        int length = iArr.length - 1;
        if (length < 1) {
            return iArr;
        }
        if (iArr2.length < 4) {
            int[] iArr3 = new int[4];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr2 = iArr3;
        }
        int i = iArr[length];
        int i2 = iArr[0];
        int i3 = (52 / (length + 1)) + 6;
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return iArr;
            }
            i4 -= 1640531527;
            int i6 = (i4 >>> 2) & 3;
            int i7 = 0;
            while (i7 < length) {
                int i8 = i7 + 1;
                int i9 = iArr[i8];
                i = ((((i >>> 5) ^ (i9 << 2)) + ((i9 >>> 3) ^ (i << 4))) ^ ((i9 ^ i4) + (i ^ iArr2[(i7 & 3) ^ i6]))) + iArr[i7];
                iArr[i7] = i;
                i7 = i8;
            }
            int i10 = iArr[0];
            i = ((((i >>> 5) ^ (i10 << 2)) + ((i10 >>> 3) ^ (i << 4))) ^ ((i10 ^ i4) + (i ^ iArr2[i6 ^ (i7 & 3)]))) + iArr[length];
            iArr[length] = i;
            i3 = i5;
        }
    }

    private static int[] a(byte[] bArr, boolean z) {
        int[] iArr = new int[bArr.length >>> 2];
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr;
    }

    private static byte[] a(int[] iArr, boolean z) {
        int length = iArr.length << 2;
        if (z) {
            int i = iArr[iArr.length - 1];
            if (i > length) {
                return null;
            }
            length = i;
        }
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) ((iArr[i2 >>> 2] >>> ((i2 & 3) << 3)) & 255);
        }
        return bArr;
    }
}
