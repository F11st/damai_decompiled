package com.loc;

import com.youku.upsplayer.util.YKUpsConvert;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.e73;
import tb.km1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class e1 {
    private static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final byte[] b = {61, 61, 81, 65, 65, 69, 119, 65, 67, 48, 74, 80, 115, 116, 54, 75, 104, 76, 122, 97, 88, 99, 53, 71, 49, 122, 68, 70, 79, 104, 113, 113, 65, 97, 76, 54, 65, 66, 87, 53, 103, 85, 84, 113, 71, 68, 69, 76, 80, 82, 106, 51, 66, 75, 75, 69, 98, 55, 84, 108, 115, 122, 51, 106, 76, 55, 88, 122, 70, 121, 73, 75, 52, 50, km1.OP_MAX_COUNT, 101, 70, 121, 56, 105, 115, 105, 89, 120, 117, 112, 53, 48, 76, 81, 70, 86, 108, 110, 73, 65, 66, 74, 65, 83, 119, 65, 119, 83, 68, 65, 81, 66, 66, 69, 81, 65, 78, 99, 118, 104, 73, 90, 111, 75, 74, 89, 81, 68, 119, 119, 70, 77};
    private static final byte[] c;

    static {
        byte[] bArr = {0, 1, 1, 2, 3, 5, 8, 13, 8, 7, 6, 5, 4, 3, 2, 1};
        c = bArr;
        new IvParameterSpec(bArr);
    }

    public static String a(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    String b2 = b("SHA1", str);
                    return b(MessageDigestAlgorithms.MD5, b2 + str);
                }
            } catch (Throwable th) {
                j1.h(th, "Encrypt", "generatorKey");
            }
        }
        return null;
    }

    public static String b(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        try {
            return i(r1.c(str2.getBytes("UTF-8"), str));
        } catch (Throwable th) {
            j1.h(th, "Encrypt", "encode");
            return null;
        }
    }

    private static byte[] c() {
        return v1.w();
    }

    public static byte[] d(byte[] bArr) throws Exception {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(e73.a(new StringBuilder(new String(b)).reverse().toString().getBytes())));
        Cipher cipher = Cipher.getInstance(v1.v("WUlNBL0VDQi9PQUVQV0lUSFNIQS0xQU5ETUdGMVBBRERJTkc"));
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }

    public static byte[] e(byte[] bArr, String str) {
        try {
            SecretKeySpec f = f(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(c());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, f, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            j1.h(th, "Encrypt", "aesEncrypt");
            return null;
        }
    }

    private static SecretKeySpec f(String str) {
        byte[] bArr;
        if (str == null) {
            str = "";
        }
        StringBuffer stringBuffer = new StringBuffer(16);
        while (true) {
            stringBuffer.append(str);
            if (stringBuffer.length() >= 16) {
                break;
            }
            str = "0";
        }
        if (stringBuffer.length() > 16) {
            stringBuffer.setLength(16);
        }
        try {
            bArr = stringBuffer.toString().getBytes("UTF-8");
        } catch (Throwable th) {
            j1.h(th, "Encrypt", "createKey");
            bArr = null;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    public static byte[] g(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[bArr.length - 16];
            System.arraycopy(bArr, 0, bArr2, 0, 16);
            System.arraycopy(bArr, 16, bArr3, 0, bArr.length - 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, secretKeySpec, new IvParameterSpec(v1.w()));
            return cipher.doFinal(bArr3);
        } catch (Throwable th) {
            j1.h(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(bArr != null ? bArr.length : 0)));
            return null;
        }
    }

    public static byte[] h(byte[] bArr, String str) {
        try {
            SecretKeySpec f = f(str);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(c());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, f, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            j1.h(th, "Encrypt", "aesDecrypt");
            return null;
        }
    }

    private static String i(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            char[] cArr = a;
            sb.append(cArr[(bArr[i] >> 4) & 15]);
            sb.append(cArr[bArr[i] & 15]);
        }
        return sb.toString();
    }
}
