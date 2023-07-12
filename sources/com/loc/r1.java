package com.loc;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.y33;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class r1 {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return v1.C(e(str));
    }

    public static String b(byte[] bArr) {
        return v1.C(c(bArr, v1.v("ETUQ1")));
    }

    public static byte[] c(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            y33.e(th, MessageDigestAlgorithms.MD5, "gmb");
            return null;
        }
    }

    public static String d(String str) {
        return v1.D(f(str));
    }

    private static byte[] e(String str) {
        try {
            return g(str);
        } catch (Throwable th) {
            y33.e(th, MessageDigestAlgorithms.MD5, "gmb");
            return new byte[0];
        }
    }

    private static byte[] f(String str) {
        try {
            return g(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] g(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(v1.v("ETUQ1"));
        messageDigest.update(v1.p(str));
        return messageDigest.digest();
    }
}
