package com.real.svg.decrypt;

import android.text.TextUtils;
import com.alipay.ma.util.StringEncodeUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class SvgDecrypt {
    private static boolean a = false;
    private static String b = "1.0";

    static {
        Charset.forName(StringEncodeUtils.UTF8);
        try {
            System.loadLibrary("svg_decrypt");
            a = true;
        } catch (Throwable th) {
            a = false;
            th.printStackTrace();
        }
    }

    public static String a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !a) ? "" : nativeDecryptKey(str, str2, "aes128-ecb");
    }

    public static String b(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !a) ? "" : nativeDecryptSvg(str, str2);
    }

    public static String c() {
        return b;
    }

    public static boolean d(String str, String str2) {
        return e(str).equalsIgnoreCase(str2);
    }

    public static String e(String str) {
        if (str != null && str.length() != 0) {
            try {
                String str2 = "";
                for (byte b2 : MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str2 = str2 + hexString;
                }
                return str2;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private static native String nativeDecryptKey(String str, String str2, String str3);

    private static native String nativeDecryptSvg(String str, String str2);
}
