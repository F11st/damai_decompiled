package com.alibaba.security.common.d;

import android.util.Base64;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.common.d.c */
/* loaded from: classes8.dex */
public abstract class AbstractC3806c {
    public static final String a = "DES";
    public static final String b = "DES/CBC/PKCS5Padding";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Key a(byte[] bArr) throws Exception {
        return SecretKeyFactory.getInstance(a).generateSecret(new DESKeySpec(bArr));
    }

    private static byte[] b(String str) {
        return Base64.decode(str, 0);
    }

    private static String b(byte[] bArr) {
        return Base64.encodeToString(bArr, 0);
    }

    private static byte[] b(byte[] bArr, String str) throws Exception {
        Key a2 = a(Base64.decode(str, 0));
        Cipher cipher = Cipher.getInstance(b);
        byte[] bArr2 = new byte[8];
        for (int i = 0; i < 8 && i < str.getBytes().length; i++) {
            bArr2[i] = str.getBytes()[i];
        }
        cipher.init(1, a2, new IvParameterSpec(bArr2));
        return cipher.doFinal(bArr);
    }

    @Deprecated
    private static String a() throws Exception {
        return a((String) null);
    }

    public static String a(String str) throws Exception {
        return Base64.encodeToString(SecretKeyFactory.getInstance(a).generateSecret(new DESKeySpec(str.getBytes())).getEncoded(), 0);
    }

    private static byte[] a(byte[] bArr, String str) throws Exception {
        Key a2 = a(Base64.decode(str, 0));
        Cipher cipher = Cipher.getInstance(b);
        byte[] bArr2 = new byte[8];
        for (int i = 0; i < 8 && i < str.getBytes().length; i++) {
            bArr2[i] = str.getBytes()[i];
        }
        cipher.init(2, a2, new IvParameterSpec(bArr2));
        return cipher.doFinal(bArr);
    }
}
