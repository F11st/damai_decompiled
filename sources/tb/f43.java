package tb;

import android.text.TextUtils;
import com.heytap.msp.push.encrypt.AESEncrypt;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class f43 {
    public static String a = null;
    public static final String b = "Y29tLm5lYXJtZS5tY3M=";
    public static String c = "";

    private static String a() {
        if (TextUtils.isEmpty(c)) {
            c = new String(x23.l(b));
        }
        byte[] c2 = c(b(c));
        return c2 != null ? new String(c2, Charset.forName("UTF-8")) : "";
    }

    public static byte[] b(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    public static byte[] c(byte[] bArr) {
        int length = bArr.length % 2 == 0 ? bArr.length : bArr.length - 1;
        for (int i = 0; i < length; i += 2) {
            byte b2 = bArr[i];
            int i2 = i + 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b2;
        }
        return bArr;
    }

    public static String d(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = c53.a(str, a());
            z53.a("sdkDecrypt desDecrypt des data " + str2);
            z = true;
        } catch (Exception e) {
            z53.a("sdkDecrypt DES excepiton " + e.toString());
            z = false;
        }
        if (TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            a = "AES";
            u63.f().d(a);
            z53.a("sdkDecrypt desDecrypt aes data " + str2);
            return str2;
        } catch (Exception e2) {
            z53.a("sdkDecrypt AES excepiton " + e2.toString());
            return str2;
        }
    }

    public static String e(String str) {
        boolean z;
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            str2 = AESEncrypt.decrypt(AESEncrypt.SDK_APP_SECRET, str);
            z53.a("sdkDecrypt aesDecrypt aes data " + str2);
            z = true;
        } catch (Exception e) {
            z53.a("sdkDecrypt AES excepiton " + e.toString());
            z = false;
        }
        if (TextUtils.isEmpty(str2) ? false : z) {
            return str2;
        }
        try {
            str2 = c53.a(str, a());
            a = com.alibaba.security.common.d.c.a;
            u63.f().d(a);
            z53.a("sdkDecrypt aesDecrypt des data " + str2);
            return str2;
        } catch (Exception e2) {
            z53.a("sdkDecrypt DES excepiton " + e2.toString());
            return str2;
        }
    }

    public static String f(String str) {
        z53.a("sdkDecrypt start data " + str);
        if (TextUtils.isEmpty(a)) {
            a = u63.f().e();
        }
        if (com.alibaba.security.common.d.c.a.equals(a)) {
            z53.a("sdkDecrypt start DES");
            return d(str);
        }
        z53.a("sdkDecrypt start AES");
        return e(str);
    }
}
