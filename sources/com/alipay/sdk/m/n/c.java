package com.alipay.sdk.m.n;

import android.text.TextUtils;
import java.security.SecureRandom;
import javax.crypto.Cipher;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class c {
    public static byte[] a(Cipher cipher, String str) {
        SecureRandom secureRandom = new SecureRandom();
        int blockSize = cipher.getBlockSize();
        if (TextUtils.isEmpty(str)) {
            str = String.valueOf(secureRandom.nextDouble());
        }
        int i = blockSize * 2;
        byte[] bArr = new byte[i];
        byte[] bArr2 = new byte[blockSize];
        secureRandom.nextBytes(bArr2);
        for (int i2 = 1; i2 < i; i2++) {
            bArr[i2] = (byte) (str.codePointAt(i2 % str.length()) & 127);
            if (i2 >= blockSize) {
                bArr[i2] = (byte) (bArr[0] & bArr[i2]);
            }
        }
        System.arraycopy(bArr, blockSize, bArr2, 0, blockSize);
        return bArr2;
    }
}
