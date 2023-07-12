package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.C5742b;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AesGcmKS {
    private static final String a = "GCMKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "AES/GCM/NoPadding";
    private static final String d = "";
    private static final int e = 12;
    private static final int f = 256;
    private static Map<String, SecretKey> g = new HashMap();

    private static SecretKey a(String str) {
        C5742b.c(a, "load key");
        SecretKey secretKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                secretKey = (SecretKey) key;
            } else {
                C5742b.c(a, "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                secretKey = keyGenerator.generateKey();
            }
        } catch (IOException e2) {
            C5742b.b(a, "IOException : " + e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            C5742b.b(a, "InvalidAlgorithmParameterException : " + e3.getMessage());
        } catch (KeyStoreException e4) {
            C5742b.b(a, "KeyStoreException : " + e4.getMessage());
        } catch (NoSuchAlgorithmException e5) {
            C5742b.b(a, "NoSuchAlgorithmException : " + e5.getMessage());
        } catch (NoSuchProviderException e6) {
            C5742b.b(a, "NoSuchProviderException : " + e6.getMessage());
        } catch (UnrecoverableKeyException e7) {
            C5742b.b(a, "UnrecoverableKeyException : " + e7.getMessage());
        } catch (CertificateException e8) {
            C5742b.b(a, "CertificateException : " + e8.getMessage());
        } catch (Exception e9) {
            C5742b.b(a, "Exception: " + e9.getMessage());
        }
        g.put(str, secretKey);
        return secretKey;
    }

    private static SecretKey b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (g.get(str) == null) {
            a(str);
        }
        return g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                C5742b.b(a, "decrypt: UnsupportedEncodingException : " + e2.getMessage());
                return "";
            }
        }
        C5742b.b(a, "alias or encrypt content is null");
        return "";
    }

    public static String encrypt(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                C5742b.b(a, "encrypt: UnsupportedEncodingException : " + e2.getMessage());
                return "";
            }
        }
        C5742b.b(a, "alias or encrypt content is null");
        return "";
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                C5742b.b(a, "sdk version is too low");
                return bArr2;
            } else if (bArr.length <= 12) {
                C5742b.b(a, "Decrypt source data is invalid.");
                return bArr2;
            } else {
                return decrypt(b(str), bArr);
            }
        }
        C5742b.b(a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                C5742b.b(a, "sdk version is too low");
                return bArr2;
            }
            return encrypt(b(str), bArr);
        }
        C5742b.b(a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            C5742b.b(a, "content is null");
            return bArr2;
        } else if (secretKey == null) {
            C5742b.b(a, "secret key is null");
            return bArr2;
        } else if (!a()) {
            C5742b.b(a, "sdk version is too low");
            return bArr2;
        } else {
            try {
                Cipher cipher = Cipher.getInstance(c);
                cipher.init(1, secretKey);
                byte[] doFinal = cipher.doFinal(bArr);
                byte[] iv = cipher.getIV();
                if (iv != null && iv.length == 12) {
                    byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                    System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                    return copyOf;
                }
                C5742b.b(a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e2) {
                C5742b.b(a, "InvalidKeyException : " + e2.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e3) {
                C5742b.b(a, "NoSuchAlgorithmException : " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                C5742b.b(a, "BadPaddingException : " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                C5742b.b(a, "IllegalBlockSizeException : " + e5.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e6) {
                C5742b.b(a, "NoSuchPaddingException : " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                C5742b.b(a, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            C5742b.b(a, "Decrypt secret key is null");
            return bArr2;
        } else if (bArr == null) {
            C5742b.b(a, "content is null");
            return bArr2;
        } else if (!a()) {
            C5742b.b(a, "sdk version is too low");
            return bArr2;
        } else if (bArr.length <= 12) {
            C5742b.b(a, "Decrypt source data is invalid.");
            return bArr2;
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            try {
                Cipher cipher = Cipher.getInstance(c);
                cipher.init(2, secretKey, new GCMParameterSpec(128, copyOf));
                return cipher.doFinal(bArr, 12, bArr.length - 12);
            } catch (InvalidAlgorithmParameterException e2) {
                C5742b.b(a, "InvalidAlgorithmParameterException : " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                C5742b.b(a, "InvalidKeyException : " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                C5742b.b(a, "NoSuchAlgorithmException : " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                C5742b.b(a, "BadPaddingException : " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                C5742b.b(a, "IllegalBlockSizeException : " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                C5742b.b(a, "NoSuchPaddingException : " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                C5742b.b(a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
