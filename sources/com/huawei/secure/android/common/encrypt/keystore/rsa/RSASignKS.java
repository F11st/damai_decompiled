package com.huawei.secure.android.common.encrypt.keystore.rsa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huawei.secure.android.common.encrypt.utils.C5742b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class RSASignKS {
    private static final String a = "RSASignKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "SHA256withRSA/PSS";
    private static final String d = "";
    private static final int e = 2048;
    private static final int f = 3072;

    private static byte[] a(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!isBuildVersionHigherThan22()) {
                C5742b.b(a, "sdk version is too low");
                return bArr2;
            }
            KeyStore.Entry b2 = b(str, z);
            if (!(b2 instanceof KeyStore.PrivateKeyEntry)) {
                C5742b.b(a, "Not an instance of a PrivateKeyEntry");
                return bArr2;
            }
            try {
                Signature signature = Signature.getInstance(c);
                signature.initSign(((KeyStore.PrivateKeyEntry) b2).getPrivateKey());
                signature.update(bArr);
                return signature.sign();
            } catch (InvalidKeyException e2) {
                String str2 = a;
                C5742b.b(str2, "InvalidKeyException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e3) {
                String str3 = a;
                C5742b.b(str3, "NoSuchAlgorithmException: " + e3.getMessage());
                return bArr2;
            } catch (SignatureException e4) {
                String str4 = a;
                C5742b.b(str4, "SignatureException: " + e4.getMessage());
                return bArr2;
            } catch (Exception e5) {
                String str5 = a;
                C5742b.b(str5, "Exception: " + e5.getMessage());
                return bArr2;
            }
        }
        C5742b.b(a, "alias or content is null");
        return bArr2;
    }

    private static KeyStore.Entry b(String str, boolean z) {
        if (!a(str)) {
            a(str, z);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getEntry(str, null);
        } catch (IOException e2) {
            String str2 = a;
            C5742b.b(str2, "IOException: " + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            String str3 = a;
            C5742b.b(str3, "KeyStoreException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            String str4 = a;
            C5742b.b(str4, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (UnrecoverableEntryException e5) {
            String str5 = a;
            C5742b.b(str5, "UnrecoverableEntryException: " + e5.getMessage());
            return null;
        } catch (CertificateException e6) {
            String str6 = a;
            C5742b.b(str6, "CertificateException: " + e6.getMessage());
            return null;
        }
    }

    public static boolean isBuildVersionHigherThan22() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @Deprecated
    public static String sign(String str, String str2) {
        try {
            return Base64.encodeToString(sign(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            Log.e(str3, "sign UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static String signNew(String str, String str2) {
        try {
            return Base64.encodeToString(signNew(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            Log.e(str3, "sign UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    @Deprecated
    public static boolean verifySign(String str, String str2, String str3) {
        try {
            return verifySign(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e2) {
            String str4 = a;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            String str5 = a;
            C5742b.b(str5, "base64 decode Exception" + e3.getMessage());
            return false;
        }
    }

    public static boolean verifySignNew(String str, String str2, String str3) {
        try {
            return verifySignNew(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e2) {
            String str4 = a;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            String str5 = a;
            C5742b.b(str5, "base64 decode Exception" + e3.getMessage());
            return false;
        }
    }

    @Deprecated
    public static byte[] sign(String str, byte[] bArr) {
        return a(str, bArr, false);
    }

    public static byte[] signNew(String str, byte[] bArr) {
        return a(str, bArr, true);
    }

    @Deprecated
    public static boolean verifySign(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, false);
    }

    public static boolean verifySignNew(String str, byte[] bArr, byte[] bArr2) {
        return a(str, bArr, bArr2, true);
    }

    private static boolean a(String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr2 != null) {
            if (!isBuildVersionHigherThan22()) {
                C5742b.b(a, "sdk version is too low");
                return false;
            }
            KeyStore.Entry b2 = b(str, z);
            if (!(b2 instanceof KeyStore.PrivateKeyEntry)) {
                C5742b.b(a, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature signature = Signature.getInstance(c);
                signature.initVerify(((KeyStore.PrivateKeyEntry) b2).getCertificate());
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (InvalidKeyException e2) {
                String str2 = a;
                C5742b.b(str2, "InvalidKeyException: " + e2.getMessage());
                return false;
            } catch (NoSuchAlgorithmException e3) {
                String str3 = a;
                C5742b.b(str3, "NoSuchAlgorithmException: " + e3.getMessage());
                return false;
            } catch (SignatureException e4) {
                String str4 = a;
                C5742b.b(str4, "SignatureException: " + e4.getMessage());
                return false;
            } catch (Exception e5) {
                String str5 = a;
                C5742b.b(str5, "Exception: " + e5.getMessage());
                return false;
            }
        }
        C5742b.b(a, "alias or content or sign value is null");
        return false;
    }

    private static synchronized KeyPair a(String str, boolean z) {
        synchronized (RSASignKS.class) {
            KeyPair keyPair = null;
            if (a(str)) {
                C5742b.b(a, "Key pair exits");
                return null;
            }
            try {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    if (!z) {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests(MessageDigestAlgorithms.SHA_256, MessageDigestAlgorithms.SHA_512).setSignaturePaddings("PSS").setKeySize(2048).build());
                    } else {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests(MessageDigestAlgorithms.SHA_256, MessageDigestAlgorithms.SHA_512).setSignaturePaddings("PSS").setKeySize(f).build());
                    }
                    keyPair = keyPairGenerator.generateKeyPair();
                } catch (InvalidAlgorithmParameterException e2) {
                    String str2 = a;
                    C5742b.b(str2, "InvalidAlgorithmParameterException: " + e2.getMessage());
                } catch (NoSuchProviderException e3) {
                    String str3 = a;
                    C5742b.b(str3, "NoSuchProviderException: " + e3.getMessage());
                }
            } catch (NoSuchAlgorithmException e4) {
                String str4 = a;
                C5742b.b(str4, "NoSuchAlgorithmException: " + e4.getMessage());
            }
            return keyPair;
        }
    }

    private static boolean a(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e2) {
            String str2 = a;
            C5742b.b(str2, "IOException: " + e2.getMessage());
            return false;
        } catch (KeyStoreException e3) {
            String str3 = a;
            C5742b.b(str3, "KeyStoreException: " + e3.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e4) {
            String str4 = a;
            C5742b.b(str4, "NoSuchAlgorithmException: " + e4.getMessage());
            return false;
        } catch (UnrecoverableKeyException e5) {
            String str5 = a;
            C5742b.b(str5, "UnrecoverableKeyException: " + e5.getMessage());
            return false;
        } catch (CertificateException e6) {
            String str6 = a;
            C5742b.b(str6, "CertificateException: " + e6.getMessage());
            return false;
        }
    }
}
