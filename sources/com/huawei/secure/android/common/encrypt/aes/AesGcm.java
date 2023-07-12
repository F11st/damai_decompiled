package com.huawei.secure.android.common.encrypt.aes;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class AesGcm {
    private static final String a = "security:";
    private static final String b = "AES/GCM/NoPadding";
    private static final String c = "AES";
    private static final String d = "GCM";
    private static final String e = "";
    private static final int f = 16;
    private static final int g = 12;
    private static final int h = 2;

    private AesGcm() {
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "encrypt 5 content is null");
            return new byte[0];
        } else if (bArr == null) {
            b.b(d, "encrypt 5 key is null");
            return new byte[0];
        } else if (bArr.length < 16) {
            b.b(d, "encrypt 5 key lengh is not right");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b(d, "encrypt 5 iv is null");
            return new byte[0];
        } else if (bArr2.length < 12) {
            b.b(d, "encrypt 5 iv lengh is not right");
            return new byte[0];
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "encrypt 5 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e2) {
                b.b(d, "GCM encrypt data error" + e2.getMessage());
                return new byte[0];
            }
        }
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 12];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "decrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b(d, "decrypt 1 key is null");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "decrypt 1 build version not higher than 19");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            if (hexStr2ByteArray.length < 16) {
                b.b(d, "decrypt 1 key length is not right");
                return "";
            }
            return decrypt(str, hexStr2ByteArray);
        }
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String c2 = AesCbc.c(str);
            if ("".equals(c2)) {
                return "";
            }
            int indexOf = c2.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(c2.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(c2.substring(0, indexOf)));
            }
            b.b(d, " gcm cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] d2 = AesCbc.d(bArr);
        if (d2.length == 0) {
            return new byte[0];
        }
        int a2 = a(d2);
        if (a2 >= 0) {
            byte[] copyOf = Arrays.copyOf(d2, a2);
            int length = (d2.length - copyOf.length) - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(d2, a2 + 1, bArr3, 0, length);
            return decrypt(bArr3, bArr2, copyOf);
        }
        b.b(d, " gcm cipherText data missing colon");
        return new byte[0];
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "encrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b(d, "encrypt 1 key is null");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "encrypt 1 build version not higher than 19");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            if (hexStr2ByteArray.length < 16) {
                b.b(d, "encrypt 1 key length is not right");
                return "";
            }
            return encrypt(str, hexStr2ByteArray);
        }
    }

    public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] bArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new IvParameterSpec(bArr);
        }
        return new GCMParameterSpec(128, bArr);
    }

    public static boolean isBuildVersionHigherThan19() {
        return Build.VERSION.SDK_INT >= 19;
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        b.b(d, "IV is invalid.");
        return "";
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            b.b(d, "UnsupportedEncodingException");
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "decrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.b(d, "decrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b(d, "decrypt 2 key lengh is not right");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "decrypt 2 build version not higher than 19");
            return "";
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                Cipher cipher = Cipher.getInstance(b);
                String b2 = b(str);
                String a2 = a(str);
                if (TextUtils.isEmpty(b2)) {
                    b.b(d, "decrypt 2 iv is null");
                    return "";
                } else if (TextUtils.isEmpty(a2)) {
                    b.b(d, "decrypt 2 encrypt content is null");
                    return "";
                } else {
                    cipher.init(2, secretKeySpec, getGcmAlgorithmParams(HexUtil.hexStr2ByteArray(b2)));
                    return new String(cipher.doFinal(HexUtil.hexStr2ByteArray(a2)), "UTF-8");
                }
            } catch (UnsupportedEncodingException | GeneralSecurityException e2) {
                b.b(d, "GCM decrypt data exception: " + e2.getMessage());
                return "";
            }
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "encrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            b.b(d, "encrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b(d, "encrypt 2 key lengh is not right");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "encrypt 2 build version not higher than 19");
            return "";
        } else {
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
            byte[] a2 = a(str, bArr, generateSecureRandom);
            if (a2 == null || a2.length == 0) {
                return "";
            }
            String byteArray2HexStr = HexUtil.byteArray2HexStr(generateSecureRandom);
            String byteArray2HexStr2 = HexUtil.byteArray2HexStr(a2);
            return byteArray2HexStr + byteArray2HexStr2;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static String a(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    private static int a(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "encrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b(d, "encrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            b.b(d, "encrypt 3 iv is null");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "encrypt 3 build version not higher than 19");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
            if (hexStr2ByteArray.length < 16) {
                b.b(d, "encrypt 3 key length is not right");
                return "";
            } else if (hexStr2ByteArray2.length < 12) {
                b.b(d, "encrypt 3 iv length is not right");
                return "";
            } else {
                return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
            }
        }
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "decrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            b.b(d, "decrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            b.b(d, "decrypt 3 iv is null");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "decrypt 3 build version not higher than 19");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
            if (hexStr2ByteArray.length < 16) {
                b.b(d, "decrypt 3 key length is not right");
                return "";
            } else if (hexStr2ByteArray2.length < 12) {
                b.b(d, "decrypt 3 iv length is not right");
                return "";
            } else {
                return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
            }
        }
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "encrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            b.b(d, "encrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b(d, "encrypt 4 key lengh is not right");
            return "";
        } else if (bArr2 == null) {
            b.b(d, "encrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 12) {
            b.b(d, "encrypt 4 iv lengh is not right");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "encrypt 4 build version not higher than 19");
            return "";
        } else {
            return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
        }
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            b.b(d, "decrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            b.b(d, "decrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            b.b(d, "decrypt 4 key lengh is not right");
            return "";
        } else if (bArr2 == null) {
            b.b(d, "decrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 12) {
            b.b(d, "decrypt 4 iv lengh is not right");
            return "";
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "decrypt 4 build version not higher than 19");
            return "";
        } else {
            try {
                return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                b.b(d, "GCM decrypt data exception: " + e2.getMessage());
                return "";
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.b(d, "encrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            b.b(d, "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b(d, "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.b(d, "encrypt 6 key length is error");
            return new byte[0];
        } else if (bArr3 == null) {
            b.b(d, "encrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 12) {
            b.b(d, "encrypt 6 iv length is error");
            return new byte[0];
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "encrypt 6 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(1, secretKeySpec, getGcmAlgorithmParams(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e2) {
                b.b(d, "GCM encrypt data error" + e2.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            b.b(d, "decrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            b.b(d, "decrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            b.b(d, "decrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            b.b(d, "decrypt 6 key length is error");
            return new byte[0];
        } else if (bArr3 == null) {
            b.b(d, "decrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 12) {
            b.b(d, "decrypt 6 iv length is error");
            return new byte[0];
        } else if (!isBuildVersionHigherThan19()) {
            b.b(d, "decrypt 6 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(2, secretKeySpec, getGcmAlgorithmParams(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e2) {
                b.b(d, "GCM decrypt data exception: " + e2.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(12);
        return a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(b(bArr), bArr2, c(bArr));
    }
}
