package com.alibaba.security.common.d;

import android.text.TextUtils;
import android.util.Base64;
import com.youku.upsplayer.util.YKUpsConvert;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a {
    private static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr == null && bArr2 == null) {
            return null;
        }
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null) {
            return bArr;
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static byte[] b(String str) {
        int length = str.length();
        if ((length & 1) != 1) {
            if (length >= 0) {
                if (length + 0 <= str.length()) {
                    int i = length / 2;
                    byte[] bArr = new byte[i];
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i2 < i) {
                        int i5 = i4 + 1;
                        bArr[i3] = (byte) ((a(str.charAt(i4)) << 4) | a(str.charAt(i5)));
                        i2++;
                        i3++;
                        i4 = i5 + 1;
                    }
                    return bArr;
                }
                throw new IndexOutOfBoundsException("hex2bytes: offset + length > array length.");
            }
            throw new IndexOutOfBoundsException("hex2bytes: length < 0, length is ".concat(String.valueOf(length)));
        }
        throw new IllegalArgumentException("hex2bytes: ( len & 1 ) == 1.");
    }

    private static byte[] a(String str, int i) {
        if ((i & 1) != 1) {
            if (i >= 0) {
                if (i + 0 <= str.length()) {
                    int i2 = i / 2;
                    byte[] bArr = new byte[i2];
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (i3 < i2) {
                        int i6 = i5 + 1;
                        bArr[i4] = (byte) ((a(str.charAt(i5)) << 4) | a(str.charAt(i6)));
                        i3++;
                        i4++;
                        i5 = i6 + 1;
                    }
                    return bArr;
                }
                throw new IndexOutOfBoundsException("hex2bytes: offset + length > array length.");
            }
            throw new IndexOutOfBoundsException("hex2bytes: length < 0, length is ".concat(String.valueOf(i)));
        }
        throw new IllegalArgumentException("hex2bytes: ( len & 1 ) == 1.");
    }

    private static byte a(char c) {
        int i;
        if (c <= '9') {
            i = c - '0';
        } else {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = YKUpsConvert.CHAR_A;
                if (c < 'A' || c > 'F') {
                    throw new IllegalArgumentException("hex string format error [" + c + "].");
                }
            }
            i = (c - c2) + 10;
        }
        return (byte) i;
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.decode(str, 2);
    }

    public static String a(byte[] bArr) {
        return bArr == null ? "" : Base64.encodeToString(bArr, 2);
    }
}
