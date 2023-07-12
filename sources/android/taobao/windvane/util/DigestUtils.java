package android.taobao.windvane.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DigestUtils {
    private static final String MD5 = "MD5";
    private static final String SHA1 = "SHA-1";
    private static final String SHA256 = "SHA-256";

    private static String digest(byte[] bArr, String str) {
        return HexUtil.bytesToHexString(digest2byte(bArr, str));
    }

    private static byte[] digest2byte(byte[] bArr, String str) {
        try {
            return MessageDigest.getInstance(str).digest(bArr);
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Security exception", e);
        }
    }

    public static String md5ToHex(String str) {
        if (str == null) {
            return null;
        }
        try {
            return digest(str.getBytes("utf-8"), "MD5");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] sha1ToByte(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return digest2byte(bArr, "SHA-1");
    }

    public static String sha1ToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return digest(bArr, "SHA-1");
    }

    public static String sha256ToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return digest(bArr, "SHA-256");
    }

    private static String digest(InputStream inputStream, String str) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            byte[] bArr = new byte[1024];
            int read = inputStream.read(bArr, 0, 1024);
            while (read > -1) {
                messageDigest.update(bArr, 0, read);
                read = inputStream.read(bArr, 0, 1024);
            }
            return HexUtil.bytesToHexString(messageDigest.digest());
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("Security exception", e);
        }
    }

    public static String md5ToHex(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return digest(bArr, "MD5");
    }
}
