package com.loc;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f {
    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(v1.v("EUlNB")).generatePublic(new X509EncodedKeySpec(b.c(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    public static byte[] b(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(v1.v("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
