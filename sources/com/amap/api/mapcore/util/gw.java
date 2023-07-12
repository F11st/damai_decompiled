package com.amap.api.mapcore.util;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class gw {
    private static byte[] a;
    private static String[] b = {"kp6SsA", "cHE4dQ", "JKekrA", "XBxOHQ", "CSnpKw", "VwcThw", "wkp6Sg", "1cHE4Q"};
    private static int[] c = null;

    public static String a(String str) {
        return gk.b(str);
    }

    private static int b(int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 >> 1) | Integer.MIN_VALUE;
        }
        return (i << i2) | ((i & i3) >>> (32 - i2));
    }

    private static byte[] b() {
        if (a == null) {
            a = gn.c("YAAAAAAAAAAAAAAAAAAAAAA").getBytes();
        }
        return a;
    }

    private static int c(int i) {
        int i2 = 1;
        for (int i3 = 0; i3 < 15; i3++) {
            i2 = (i2 << 2) | 1;
        }
        return ((i & i2) << 1) | (((i2 << 1) & i) >>> 1);
    }

    private static int[] c() {
        int[] iArr = c;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[8];
        int i = 0;
        while (true) {
            String[] strArr = b;
            if (i >= strArr.length) {
                return iArr2;
            }
            iArr2[i] = b(gh.b(strArr[i]));
            i++;
        }
    }

    public static String a() {
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(gn.c("EQUVT"));
            keyGenerator.init(128, secureRandom);
            return gr.a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            return gr.a(a(str.getBytes("UTF-8")));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String b(int i) {
        String str = " ";
        for (int i2 = 0; i2 < 32; i2++) {
            str = str + (((Integer.MIN_VALUE >>> i2) & i) >>> (31 - i2));
        }
        return str;
    }

    public static int b(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    public static byte[] a(byte[] bArr) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(b());
            SecretKeySpec secretKeySpec = new SecretKeySpec(a(c()).getBytes("UTF-8"), gn.c("AQUVT"));
            Cipher cipher = Cipher.getInstance(gn.c("SQUVTL0NCQy9QS0NTNVBhZGRpbmc"));
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                sb.append(a(iArr[i], i));
            }
        }
        return sb.toString();
    }

    private static String a(int i, int i2) {
        return a(b(c(i), i2));
    }

    private static String a(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = (4 - i2) - 1;
            cArr[i3] = (char) ((i >>> (i2 * 8)) & 255);
            b(cArr[i3]);
        }
        return new String(cArr);
    }
}
