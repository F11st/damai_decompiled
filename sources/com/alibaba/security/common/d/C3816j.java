package com.alibaba.security.common.d;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.common.d.j */
/* loaded from: classes8.dex */
public final class C3816j {
    public static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            if (Build.VERSION.SDK_INT >= 19) {
                messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            } else {
                messageDigest.update(str.getBytes("UTF-8"));
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                sb.append(String.format("%02x", Byte.valueOf(digest[i])));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] b = b(str.getBytes("utf-8"), MessageDigestAlgorithms.MD5);
            StringBuilder sb = new StringBuilder(128);
            if (b != null && b.length > 0) {
                for (byte b2 : b) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() < 2) {
                        sb.append(0);
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }
        } catch (UnsupportedEncodingException unused) {
        }
        return null;
    }

    private static String c(String str) {
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bytes);
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(str.getBytes("UTF-8"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bArr);
            return Base64.encodeToString(messageDigest.digest(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(128);
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static String a(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read > 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        String replace = String.format("%32s", new BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', YKUpsConvert.CHAR_ZERO);
                        fileInputStream.close();
                        try {
                            fileInputStream.close();
                            return replace;
                        } catch (IOException unused) {
                            return null;
                        }
                    }
                } catch (IOException unused2) {
                    fileInputStream.close();
                    return null;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                        throw th;
                    } catch (IOException unused3) {
                        return null;
                    }
                }
            }
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused4) {
        }
    }

    private static byte[] b(byte[] bArr, String str) {
        try {
            return MessageDigest.getInstance(str).digest(bArr);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private static String a(byte[] bArr, String str) {
        byte[] b = b(bArr, str);
        StringBuilder sb = new StringBuilder(128);
        if (b == null || b.length <= 0) {
            return null;
        }
        for (byte b2 : b) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
