package android.taobao.windvane.packageapp.zipapp.utils;

import android.taobao.windvane.util.DigestUtils;
import android.taobao.windvane.util.RsaUtil;
import android.taobao.windvane.util.TaoLog;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ZipAppSecurityUtils {
    private static final String TAG = "PackageApp-ZipAppSecurityUtils";
    private static final String key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAr4QTVnTHJ/W1hfBkEfTdWMMAxsQHW22gK0JProk3hmdwwal+Up7Ty/8NUXs+8SKufik2ASXQLFkqeoZu60sXmtlQGZJ+kAezC8pS9MboHZWywO9VJwxRUQuXI/Hn0jjZsA8tZPpN6Ty9wkz80GrQJrRuhjEjT0JAjElhpZUxTXMKIIPqM+ndgcfF55f9wWYFKW+o/Z0Nil0yP1crvLryq3sbSbDTnz7+j4zUE7aCGb0ECyS/ii1o53C08YKyhzpSTICSzILvHMdHFHGeuH1LfrinuLYdyORlC0f6qoSODBSaXO7UI+uHxhb6K3e1YzUYsMRuEjyDUTETeT/b07LIgwIDAQAB";

    public static boolean validConfigFile(String str, String str2) {
        try {
            return RsaUtil.decryptData(str2, RsaUtil.getPublicKey(key)).equals(DigestUtils.md5ToHex(str));
        } catch (Exception e) {
            TaoLog.e(TAG, "decrypt fail: " + e.getMessage());
            return false;
        }
    }
}
