package tb;

import android.content.Context;
import com.alibaba.responsive.IConfig;
import com.alibaba.responsive.ISpanCountProcess;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class xe2 {
    private static int a = 400;
    private static double b = 1.67d;
    private static double c = 1.25d;
    private static double d = 2.3d;

    public static int a() {
        return (int) (c() * b);
    }

    public static double b() {
        return d;
    }

    public static int c() {
        IConfig a2 = v22.c().a();
        if (a2 != null && a2.getPhoneStandardWidthDp() > 0) {
            return a2.getPhoneStandardWidthDp();
        }
        return a;
    }

    public static double d() {
        return c;
    }

    public static float e(Context context, float f, int i) {
        if (!d32.i(context) || i <= c()) {
            return f;
        }
        float f2 = (int) f;
        float f3 = f > f2 ? f - f2 : 0.0f;
        int round = Math.round(i / (c() / f2));
        ISpanCountProcess d2 = v22.c().d();
        if (d2 != null) {
            round = d2.getSpanCount(round);
        }
        return round + f3;
    }

    public static int f(Context context, int i) {
        if (d32.i(context)) {
            return (int) e(context, i, w22.d().c(context));
        }
        return i;
    }
}
