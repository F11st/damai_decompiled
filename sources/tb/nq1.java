package tb;

import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nq1 {
    public static boolean a(Object obj, boolean z) {
        if (obj == null) {
            return z;
        }
        try {
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                return Boolean.parseBoolean((String) obj);
            }
            String obj2 = obj.toString();
            return TextUtils.isEmpty(obj2) ? z : Boolean.parseBoolean(obj2);
        } catch (Exception unused) {
            return z;
        }
    }

    public static float b(String str, float f) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Float.parseFloat(str);
            }
        } catch (Exception unused) {
        }
        return f;
    }

    public static int c(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Integer.parseInt(str);
            }
        } catch (Exception unused) {
        }
        return i;
    }
}
