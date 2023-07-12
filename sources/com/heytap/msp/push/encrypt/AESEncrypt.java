package com.heytap.msp.push.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import tb.z53;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AESEncrypt {
    private static final String ALGORITHM = "AES";
    private static final String IV_CONNECT = "%IV1%";
    private static final int KEY_BYTE_SIZE = 256;
    public static final String SDK_APP_SECRET = "isvrbeT7qUywVEZ1Ia0/aUVA/TcFaeV0wC8qFLc8rg4=";
    private static final String TRANSFORMATION = "AES/CTR/NoPadding";

    public static String decrypt(String str, String str2) {
        String[] split = str2.split(IV_CONNECT);
        byte[] b = C5469a.b(split[0]);
        byte[] b2 = C5469a.b(split[1]);
        SecretKeySpec secretKeySpec = new SecretKeySpec(C5469a.b(str), "AES");
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKeySpec, new IvParameterSpec(b2));
        return new String(cipher.doFinal(b));
    }

    public static String encrypt(String str) {
        try {
            return encrypt(SDK_APP_SECRET, str);
        } catch (Exception e) {
            z53.a(e.getLocalizedMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(C5469a.b(str), "AES");
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKeySpec);
        String d = C5469a.d(cipher.getIV());
        String d2 = C5469a.d(cipher.doFinal(str2.getBytes()));
        return d2 + IV_CONNECT + d;
    }

    public static String genKey() {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        return C5469a.d(keyGenerator.generateKey().getEncoded());
    }
}
