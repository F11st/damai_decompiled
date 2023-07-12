package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class d90 {
    public static final String DIMEN_SUFFIX_AP = "ap";
    public static final String DIMEN_SUFFIX_NP = "np";

    public static String a(String str) {
        if (TextUtils.isEmpty(str) || str.contains("ap") || str.contains(DIMEN_SUFFIX_NP)) {
            return str;
        }
        return str + DIMEN_SUFFIX_NP;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (str.contains("ap")) {
                Float.parseFloat(str.replace("ap", ""));
                return true;
            } else if (str.contains(DIMEN_SUFFIX_NP)) {
                Float.parseFloat(str.replace(DIMEN_SUFFIX_NP, ""));
                return true;
            } else {
                Float.parseFloat(str);
                return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }
}
