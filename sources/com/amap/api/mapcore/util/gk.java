package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gk {
    public static String a(String str) {
        FileInputStream fileInputStream;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                fileInputStream = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            C4573ha.a(th, MessageDigestAlgorithms.MD5, "gfm");
                            return null;
                        } finally {
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e) {
                                    C4573ha.a(e, MessageDigestAlgorithms.MD5, "gfm");
                                }
                            }
                        }
                    }
                }
                String e2 = gn.e(messageDigest.digest());
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    C4573ha.a(e3, MessageDigestAlgorithms.MD5, "gfm");
                }
                return e2;
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        return gn.e(d(str));
    }

    public static String c(String str) {
        return gn.f(e(str));
    }

    public static byte[] d(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            C4573ha.a(th, MessageDigestAlgorithms.MD5, "gmb");
            return new byte[0];
        }
    }

    private static byte[] e(String str) {
        try {
            return f(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        messageDigest.update(gn.a(str));
        return messageDigest.digest();
    }

    private static byte[] b(byte[] bArr) {
        return a(bArr, MessageDigestAlgorithms.MD5);
    }

    public static String a(byte[] bArr) {
        return gn.e(b(bArr));
    }

    public static byte[] a(byte[] bArr, String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            C4573ha.a(th, MessageDigestAlgorithms.MD5, "gmb");
            return null;
        }
    }
}
