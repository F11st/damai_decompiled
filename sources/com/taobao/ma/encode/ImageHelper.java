package com.taobao.ma.encode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ImageHelper {
    public static Bitmap Bytes2Bitmap(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public static byte[] getPixelData(Bitmap bitmap, int i, int i2, int i3) {
        int i4 = i * i2;
        byte[] bArr = new byte[i3 * i4];
        int[] iArr = new int[i4];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = iArr[i5];
            byte b = (byte) ((i7 >> 24) & 255);
            bArr[i6] = (byte) ((i7 >> 16) & 255);
            bArr[i6 + 1] = (byte) ((i7 >> 8) & 255);
            bArr[i6 + 2] = (byte) (i7 & 255);
            if (i3 == 4) {
                bArr[i6 + 3] = b;
            }
            i5++;
            i6 += i3;
        }
        return bArr;
    }

    public static byte[] getPixelDataRGB(Bitmap bitmap, int i, int i2, int i3) {
        int i4 = i * i2;
        byte[] bArr = new byte[i4 * 3];
        int[] iArr = new int[i4];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int i7 = iArr[i5];
            bArr[i6] = (byte) ((i7 >> 16) & 255);
            bArr[i6 + 1] = (byte) ((i7 >> 8) & 255);
            bArr[i6 + 2] = (byte) (i7 & 255);
            i5++;
            i6 += 3;
        }
        return bArr;
    }
}
