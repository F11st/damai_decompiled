package com.real.image.decrypt;

import android.text.TextUtils;
import com.alipay.ma.util.StringEncodeUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ImageDecrypt {
    private static boolean a;

    static {
        Charset.forName(StringEncodeUtils.UTF8);
        try {
            System.loadLibrary("image_decrypt");
            a = true;
        } catch (Throwable th) {
            a = false;
            th.printStackTrace();
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0 || !a) {
            return null;
        }
        return nativeDecryptImage(bArr, str, "aes128-ctr");
    }

    public static String b(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !a) ? "" : nativeDecryptKey(str, str2, "aes128-ecb");
    }

    public static boolean c(byte[] bArr, String str) {
        return d(bArr).equalsIgnoreCase(str);
    }

    public static String d(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            try {
                String str = "";
                for (byte b : MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr)) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str = str + hexString;
                }
                return str;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private static native byte[] nativeDecryptImage(byte[] bArr, String str, String str2);

    private static native String nativeDecryptKey(String str, String str2, String str3);

    private static native String nativeDecryptSvg(String str, String str2);
}
