package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C5742b;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class AesCbc {
    private static final String a = "security:";
    private static final String b = "AES/CBC/PKCS5Padding";
    private static final String c = "AES";
    private static final String d = "CBC";
    private static final String e = "";
    private static final int f = 16;
    private static final int g = 16;

    private AesCbc() {
    }

    private static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "encrypt 5 content is null");
            return new byte[0];
        } else if (bArr == null) {
            C5742b.b("CBC", "encrypt 5 key is null");
            return new byte[0];
        } else if (bArr.length < 16) {
            C5742b.b("CBC", "encrypt 5 key lengh is not right");
            return new byte[0];
        } else if (bArr2 == null) {
            C5742b.b("CBC", "encrypt 5 iv is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            C5742b.b("CBC", "encrypt 5 iv lengh is not right");
            return new byte[0];
        } else {
            try {
                return encrypt(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e2) {
                C5742b.b("CBC", " cbc encrypt data error" + e2.getMessage());
                return new byte[0];
            }
        }
    }

    private static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] d(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C5742b.b("CBC", "stripCryptHead: exception : " + e2.getMessage());
            str = "";
        }
        if (str.startsWith(a)) {
            if (bArr.length > 9) {
                int length = bArr.length - 9;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 9, bArr2, 0, length);
                return bArr2;
            }
            return new byte[0];
        }
        return new byte[0];
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "decrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            C5742b.b("CBC", "decrypt 1 key is null");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            if (hexStr2ByteArray.length < 16) {
                C5742b.b("CBC", "decrypt 1 key length is not right");
                return "";
            }
            return decrypt(str, hexStr2ByteArray);
        }
    }

    public static String decryptWithCryptHead(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String c2 = c(str);
            if ("".equals(c2)) {
                return "";
            }
            int indexOf = c2.indexOf(58);
            if (indexOf >= 0) {
                return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(c2.substring(indexOf + 1))), bArr, HexUtil.hexStr2ByteArray(c2.substring(0, indexOf)));
            }
            C5742b.b("CBC", " cbc cipherText data missing colon");
        }
        return "";
    }

    public static byte[] decryptWithCryptHeadReturnByte(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] d2 = d(bArr);
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
        C5742b.b("CBC", " cbc cipherText data missing colon");
        return new byte[0];
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "encrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            C5742b.b("CBC", "encrypt 1 key is null");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            if (hexStr2ByteArray.length < 16) {
                C5742b.b("CBC", "encrypt 1 key length is not right");
                return "";
            }
            return encrypt(str, hexStr2ByteArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf(a) == -1) ? "" : str.substring(9);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e2) {
            C5742b.b("CBC", "getIv exception : " + e2.getMessage());
            return "";
        }
    }

    public static String decrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "decrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            C5742b.b("CBC", "decrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            C5742b.b("CBC", "decrypt 2 key lengh is not right");
            return "";
        } else {
            String b2 = b(str);
            String a2 = a(str);
            if (TextUtils.isEmpty(b2)) {
                C5742b.b("CBC", "decrypt 2 iv is null");
                return "";
            } else if (TextUtils.isEmpty(a2)) {
                C5742b.b("CBC", "decrypt 2 encrypt content is null");
                return "";
            } else {
                return decrypt(a2, bArr, HexUtil.hexStr2ByteArray(b2));
            }
        }
    }

    public static String decryptWithCryptHead(byte[] bArr, byte[] bArr2) {
        try {
            return new String(decryptWithCryptHeadReturnByte(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            C5742b.b("CBC", "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static String encrypt(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "encrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            C5742b.b("CBC", "encrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            C5742b.b("CBC", "encrypt 2 key lengh is not right");
            return "";
        } else {
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
            byte[] a2 = a(str, bArr, generateSecureRandom);
            return (a2 == null || a2.length == 0) ? "" : a(HexUtil.byteArray2HexStr(generateSecureRandom), HexUtil.byteArray2HexStr(a2));
        }
    }

    private static String a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e2) {
                C5742b.b("CBC", "mix exception: " + e2.getMessage());
            }
        }
        return "";
    }

    public static String encrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "encrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            C5742b.b("CBC", "encrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            C5742b.b("CBC", "encrypt 3 iv is null");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
            if (hexStr2ByteArray.length < 16) {
                C5742b.b("CBC", "encrypt 3 key length is not right");
                return "";
            } else if (hexStr2ByteArray2.length < 16) {
                C5742b.b("CBC", "encrypt 3 iv length is not right");
                return "";
            } else {
                return encrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
            }
        }
    }

    public static String decrypt(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "decrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            C5742b.b("CBC", "decrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            C5742b.b("CBC", "decrypt 3 iv is null");
            return "";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str2);
            byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str3);
            if (hexStr2ByteArray.length < 16) {
                C5742b.b("CBC", "decrypt 3 key length is not right");
                return "";
            } else if (hexStr2ByteArray2.length < 16) {
                C5742b.b("CBC", "decrypt 3 iv length is not right");
                return "";
            } else {
                return decrypt(str, hexStr2ByteArray, hexStr2ByteArray2);
            }
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e2) {
            C5742b.b("CBC", "get encryptword exception : " + e2.getMessage());
            return "";
        }
    }

    private static int a(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }

    public static String encrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "encrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            C5742b.b("CBC", "encrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            C5742b.b("CBC", "encrypt 4 key lengh is not right");
            return "";
        } else if (bArr2 == null) {
            C5742b.b("CBC", "encrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 16) {
            C5742b.b("CBC", "encrypt 4 iv lengh is not right");
            return "";
        } else {
            return HexUtil.byteArray2HexStr(a(str, bArr, bArr2));
        }
    }

    public static String decrypt(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            C5742b.b("CBC", "decrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            C5742b.b("CBC", "decrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            C5742b.b("CBC", "decrypt 4 key lengh is not right");
            return "";
        } else if (bArr2 == null) {
            C5742b.b("CBC", "decrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 16) {
            C5742b.b("CBC", "decrypt 4 iv lengh is not right");
            return "";
        } else {
            try {
                return new String(decrypt(HexUtil.hexStr2ByteArray(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                C5742b.b("CBC", " cbc decrypt data error" + e2.getMessage());
                return "";
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            C5742b.b("CBC", "encrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            C5742b.b("CBC", "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            C5742b.b("CBC", "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            C5742b.b("CBC", "encrypt 6 key length is error");
            return new byte[0];
        } else if (bArr3 == null) {
            C5742b.b("CBC", "encrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 16) {
            C5742b.b("CBC", "encrypt 6 iv length is error");
            return new byte[0];
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            try {
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e2) {
                C5742b.b("CBC", "InvalidAlgorithmParameterException: " + e2.getMessage());
                return new byte[0];
            } catch (InvalidKeyException e3) {
                C5742b.b("CBC", "InvalidKeyException: " + e3.getMessage());
                return new byte[0];
            } catch (NoSuchAlgorithmException e4) {
                C5742b.b("CBC", "NoSuchAlgorithmException: " + e4.getMessage());
                return new byte[0];
            } catch (BadPaddingException e5) {
                C5742b.b("CBC", "BadPaddingException: " + e5.getMessage());
                return new byte[0];
            } catch (IllegalBlockSizeException e6) {
                C5742b.b("CBC", "IllegalBlockSizeException: " + e6.getMessage());
                return new byte[0];
            } catch (NoSuchPaddingException e7) {
                C5742b.b("CBC", "NoSuchPaddingException: " + e7.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            C5742b.b("CBC", "decrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            C5742b.b("CBC", "decrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            C5742b.b("CBC", "decrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            C5742b.b("CBC", "decrypt 6 key length is error");
            return new byte[0];
        } else if (bArr3 == null) {
            C5742b.b("CBC", "decrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 16) {
            C5742b.b("CBC", "decrypt 6 iv length is error");
            return new byte[0];
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            try {
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e2) {
                C5742b.b("CBC", "InvalidAlgorithmParameterException: " + e2.getMessage());
                return new byte[0];
            } catch (InvalidKeyException e3) {
                C5742b.b("CBC", "InvalidKeyException: " + e3.getMessage());
                return new byte[0];
            } catch (NoSuchAlgorithmException e4) {
                C5742b.b("CBC", "NoSuchAlgorithmException: " + e4.getMessage());
                return new byte[0];
            } catch (BadPaddingException e5) {
                C5742b.b("CBC", "BadPaddingException: " + e5.getMessage());
                C5742b.b("CBC", "key is not right");
                return new byte[0];
            } catch (IllegalBlockSizeException e6) {
                C5742b.b("CBC", "IllegalBlockSizeException: " + e6.getMessage());
                return new byte[0];
            } catch (NoSuchPaddingException e7) {
                C5742b.b("CBC", "NoSuchPaddingException: " + e7.getMessage());
                return new byte[0];
            }
        }
    }

    public static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(16);
        return a(generateSecureRandom, encrypt(bArr, bArr2, generateSecureRandom));
    }

    public static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(b(bArr), bArr2, c(bArr));
    }
}
