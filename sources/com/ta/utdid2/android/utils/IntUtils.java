package com.ta.utdid2.android.utils;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class IntUtils {
    public static byte[] getBytes(int i) {
        byte[] bArr = {(byte) ((r3 >> 8) % 256), (byte) (r3 % 256), (byte) (r3 % 256), (byte) (i % 256)};
        int i2 = i >> 8;
        int i3 = i2 >> 8;
        return bArr;
    }

    public static byte[] getBytes(byte[] bArr, int i) {
        if (bArr.length == 4) {
            bArr[3] = (byte) (i % 256);
            int i2 = i >> 8;
            bArr[2] = (byte) (i2 % 256);
            int i3 = i2 >> 8;
            bArr[1] = (byte) (i3 % 256);
            bArr[0] = (byte) ((i3 >> 8) % 256);
            return bArr;
        }
        return null;
    }
}
