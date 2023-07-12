package com.taobao.orange.util;

import android.text.TextUtils;
import com.youku.upsplayer.util.YKUpsConvert;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.qb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MD5Util {
    private static final char[] DIGITS_LOWER = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(encodeHex(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("utf-8"))));
        } catch (Throwable th) {
            OLog.e("MD5Util", "md5", th, new Object[0]);
            return "";
        }
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    protected static char[] encodeHex(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }
}
