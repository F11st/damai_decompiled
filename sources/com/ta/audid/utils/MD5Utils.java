package com.ta.audid.utils;

import com.youku.upsplayer.util.YKUpsConvert;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class MD5Utils {
    private static final String HMAC_MD5_PK = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn";
    private static final char[] hexChar = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String getHmacMd5Hex(String str) {
        return getHmacMd5Hex(getHmacMd5Key(), str);
    }

    private static String getHmacMd5Key() {
        byte[] bytes = HMAC_MD5_PK.getBytes();
        for (byte b = 0; b < 32; b = (byte) (b + 1)) {
            try {
                bytes[b] = (byte) (bytes[b] + b);
            } catch (Exception unused) {
                return null;
            }
        }
        return toHexString(bytes);
    }

    private static byte[] getHmacSHA256(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        byte[] bArr3 = new byte[64];
        byte[] bArr4 = new byte[64];
        for (int i = 0; i < 64; i++) {
            bArr3[i] = 54;
            bArr4[i] = 92;
        }
        byte[] bArr5 = new byte[64];
        if (bArr.length > 64) {
            bArr = md5(bArr);
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr5[i2] = bArr[i2];
        }
        if (bArr.length < 64) {
            for (int length = bArr.length; length < 64; length++) {
                bArr5[length] = 0;
            }
        }
        byte[] bArr6 = new byte[64];
        for (int i3 = 0; i3 < 64; i3++) {
            bArr6[i3] = (byte) (bArr5[i3] ^ bArr3[i3]);
        }
        byte[] bArr7 = new byte[bArr2.length + 64];
        for (int i4 = 0; i4 < 64; i4++) {
            bArr7[i4] = bArr6[i4];
        }
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            bArr7[i5 + 64] = bArr2[i5];
        }
        byte[] md5 = md5(bArr7);
        byte[] bArr8 = new byte[64];
        for (int i6 = 0; i6 < 64; i6++) {
            bArr8[i6] = (byte) (bArr5[i6] ^ bArr4[i6]);
        }
        byte[] bArr9 = new byte[md5.length + 64];
        for (int i7 = 0; i7 < 64; i7++) {
            bArr9[i7] = bArr8[i7];
        }
        for (int i8 = 0; i8 < md5.length; i8++) {
            bArr9[i8 + 64] = md5[i8];
        }
        return md5(bArr9);
    }

    private static byte[] md5(byte[] bArr) {
        if (bArr != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (Exception e) {
                UtdidLogger.e("", e, new Object[0]);
                return null;
            }
        }
        return null;
    }

    private static String toHexString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            char[] cArr = hexChar;
            sb.append(cArr[(bArr[i] & 240) >>> 4]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }

    private static String getHmacMd5Hex(String str, String str2) {
        try {
            byte[] hmacSHA256 = getHmacSHA256(str.getBytes(), str2.getBytes());
            return hmacSHA256 != null ? toHexString(hmacSHA256) : "0000000000000000";
        } catch (Exception e) {
            UtdidLogger.d("", e);
            return "0000000000000000";
        }
    }
}
