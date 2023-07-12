package tb;

import com.youku.upsplayer.util.YKUpsConvert;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class zh2 {
    private static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str, String str2) {
        return e(str, jg1.SCHEME_SLASH, str2);
    }

    public static String b(byte[] bArr) {
        return bArr == null ? "" : c(bArr, a);
    }

    private static String c(byte[] bArr, char[] cArr) {
        int length = bArr.length;
        char[] cArr2 = new char[length << 1];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return new String(cArr2);
    }

    public static String d(String str, String str2) {
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String e(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + str3.length());
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static boolean f(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean g(String str, String str2) {
        return (str == null && str2 == null) || (str != null && str.equals(str2));
    }

    public static String h(String str) {
        if (str == null) {
            return null;
        }
        try {
            return b(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes("utf-8")));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String i(String str, int i) {
        return str.length() <= i ? str : d(str.substring(0, i), "......");
    }

    public static String j(String str) {
        return str == null ? "" : str;
    }
}
