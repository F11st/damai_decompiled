package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.ali.user.mobile.rpc.safe.AES;
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
import javax.crypto.spec.IvParameterSpec;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AesCbcKS {
    private static final String a = "CBCKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "AES/CBC/PKCS7Padding";
    private static final String d = "";
    private static final int e = 16;
    private static final int f = 256;
    private static Map<String, SecretKey> g = new HashMap();

    private static synchronized SecretKey a(String str) {
        SecretKey secretKey;
        synchronized (AesCbcKS.class) {
            C5742b.c(a, "load key");
            secretKey = null;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                                    keyStore.load(null);
                                    Key key = keyStore.getKey(str, null);
                                    if (key != null && (key instanceof SecretKey)) {
                                        secretKey = (SecretKey) key;
                                    } else {
                                        C5742b.c(a, "generate key");
                                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                                        keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(AES.BLOCK_MODE).setEncryptionPaddings(AES.PADDING).setKeySize(256).build());
                                        secretKey = keyGenerator.generateKey();
                                    }
                                } catch (KeyStoreException e2) {
                                    C5742b.b(a, "KeyStoreException: " + e2.getMessage());
                                } catch (NoSuchAlgorithmException e3) {
                                    C5742b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
                                }
                            } catch (IOException e4) {
                                C5742b.b(a, "IOException: " + e4.getMessage());
                            } catch (Exception e5) {
                                C5742b.b(a, "Exception: " + e5.getMessage());
                            }
                        } catch (UnrecoverableKeyException e6) {
                            C5742b.b(a, "UnrecoverableKeyException: " + e6.getMessage());
                        }
                    } catch (NoSuchProviderException e7) {
                        C5742b.b(a, "NoSuchProviderException: " + e7.getMessage());
                    }
                } catch (InvalidAlgorithmParameterException e8) {
                    C5742b.b(a, "InvalidAlgorithmParameterException: " + e8.getMessage());
                }
            } catch (CertificateException e9) {
                C5742b.b(a, "CertificateException: " + e9.getMessage());
            }
            g.put(str, secretKey);
        }
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
            } catch (UnsupportedEncodingException unused) {
                C5742b.b(a, "encrypt: UnsupportedEncodingException");
                return "";
            }
        }
        C5742b.b(a, "alias or encrypt content is null");
        return "";
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            C5742b.b(a, "encrypt 1 content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            C5742b.b(a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                C5742b.b(a, "sdk version is too low");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(c);
                SecretKey b2 = b(str);
                if (b2 == null) {
                    C5742b.b(a, "encrypt secret key is null");
                    return bArr2;
                }
                cipher.init(1, b2);
                byte[] doFinal = cipher.doFinal(bArr);
                byte[] iv = cipher.getIV();
                if (iv != null && iv.length == 16) {
                    byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                    System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                    return copyOf;
                }
                C5742b.b(a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e2) {
                C5742b.b(a, "InvalidKeyException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e3) {
                C5742b.b(a, "NoSuchAlgorithmException: " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                C5742b.b(a, "BadPaddingException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                C5742b.b(a, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e6) {
                C5742b.b(a, "NoSuchPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                C5742b.b(a, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
        C5742b.b(a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                C5742b.b(a, "sdk version is too low");
                return bArr2;
            } else if (bArr.length <= 16) {
                C5742b.b(a, "Decrypt source data is invalid.");
                return bArr2;
            } else {
                SecretKey b2 = b(str);
                if (b2 == null) {
                    C5742b.b(a, "decrypt secret key is null");
                    return bArr2;
                }
                byte[] copyOf = Arrays.copyOf(bArr, 16);
                try {
                    Cipher cipher = Cipher.getInstance(c);
                    cipher.init(2, b2, new IvParameterSpec(copyOf));
                    return cipher.doFinal(bArr, 16, bArr.length - 16);
                } catch (InvalidAlgorithmParameterException e2) {
                    C5742b.b(a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                    return bArr2;
                } catch (InvalidKeyException e3) {
                    C5742b.b(a, "InvalidKeyException: " + e3.getMessage());
                    return bArr2;
                } catch (NoSuchAlgorithmException e4) {
                    C5742b.b(a, "NoSuchAlgorithmException: " + e4.getMessage());
                    return bArr2;
                } catch (BadPaddingException e5) {
                    C5742b.b(a, "BadPaddingException: " + e5.getMessage());
                    return bArr2;
                } catch (IllegalBlockSizeException e6) {
                    C5742b.b(a, "IllegalBlockSizeException: " + e6.getMessage());
                    return bArr2;
                } catch (NoSuchPaddingException e7) {
                    C5742b.b(a, "NoSuchPaddingException: " + e7.getMessage());
                    return bArr2;
                } catch (Exception e8) {
                    C5742b.b(a, "Exception: " + e8.getMessage());
                    return bArr2;
                }
            }
        }
        C5742b.b(a, "alias or encrypt content is null");
        return bArr2;
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
