package tb;

import android.content.Context;
import android.util.DisplayMetrics;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class j4 {
    private static j4 d;
    public float a;
    public int b;
    public int c;

    public static j4 a(Context context) {
        if (context == null) {
            return null;
        }
        j4 j4Var = d;
        if (j4Var != null) {
            return j4Var;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        j4 j4Var2 = new j4();
        d = j4Var2;
        j4Var2.a = displayMetrics.density;
        j4Var2.c = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
        j4Var2.b = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
        return j4Var2;
    }
}
