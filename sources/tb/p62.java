package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p62 {
    private static int a = -1;
    private static float b = -1.0f;

    private static float a(Context context) {
        if (b < 0.0f) {
            b = context.getResources().getDisplayMetrics().density;
        }
        return b;
    }

    public static int b(Context context, Object obj, int i) {
        if (obj == null) {
            return i;
        }
        String lowerCase = String.valueOf(obj).toLowerCase();
        if (TextUtils.isEmpty(lowerCase)) {
            if (com.taobao.android.dinamic.b.e()) {
                DinamicLog.a(com.taobao.android.dinamic.b.TAG, "size属性为空字符串");
            }
            return i;
        }
        try {
            int c = c(context);
            float a2 = a(context);
            if (lowerCase.contains(d90.DIMEN_SUFFIX_NP)) {
                return (int) (Float.valueOf(Float.parseFloat(lowerCase.replace(d90.DIMEN_SUFFIX_NP, ""))).floatValue() * a2);
            }
            if (lowerCase.contains("ap")) {
                return Math.round(c * (Float.valueOf(Float.parseFloat(lowerCase.replace("ap", ""))).floatValue() / 375.0f));
            }
            return Math.round(c * (Float.parseFloat(lowerCase) / 375.0f));
        } catch (NumberFormatException unused) {
            if (com.taobao.android.dinamic.b.e()) {
                DinamicLog.j(com.taobao.android.dinamic.b.TAG, (String) obj, "写法错误，解析出错");
            }
            return i;
        }
    }

    public static int c(Context context) {
        if (a < 0) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            a = Math.min(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
        }
        return a;
    }
}
