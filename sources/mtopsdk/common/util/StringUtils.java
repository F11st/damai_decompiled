package mtopsdk.common.util;

import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StringUtils {
    public static String concatStr(String str, String str2) {
        if (isBlank(str) || isBlank(str2)) {
            return null;
        }
        return str.trim() + "$" + str2.trim();
    }

    public static String concatStr2LowerCase(String str, String str2) {
        if (isBlank(str) || isBlank(str2)) {
            return null;
        }
        return (str.trim() + "$" + str2.trim()).toLowerCase(Locale.US);
    }

    public static boolean isBlank(String str) {
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

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String[] splitString(String str, String str2) {
        if (str == null) {
            return null;
        }
        return isBlank(str2) ? new String[]{str2} : str.split(str2);
    }

    public static String concatStr2LowerCase(String str, String... strArr) {
        if (isBlank(str) || strArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.trim());
        if (strArr.length > 0) {
            for (String str2 : strArr) {
                if (isNotBlank(str2)) {
                    sb.append("$");
                    sb.append(str2.trim());
                }
            }
        }
        return sb.toString().toLowerCase(Locale.US);
    }
}
