package tb;

import android.text.TextUtils;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class oe2 {
    public static boolean a(me2 me2Var) {
        File b;
        if (me2Var == null || (b = oi0.b(me2Var)) == null) {
            return false;
        }
        try {
            if (b.exists() && b.isFile()) {
                return b.length() == me2Var.d();
            }
            return false;
        } catch (Throwable th) {
            ob1.e(th);
            return false;
        }
    }

    public static boolean b(me2 me2Var) {
        File b;
        if (me2Var == null || (b = oi0.b(me2Var)) == null) {
            return false;
        }
        return TextUtils.equals(me2Var.a(), pc1.a(b));
    }

    private static boolean c(ee2 ee2Var) {
        if (ee2Var == null) {
            return false;
        }
        return TextUtils.equals(pc1.a(new File(ee2Var.c())), ee2Var.b());
    }

    public static boolean d(ee2 ee2Var) {
        if (ee2Var == null) {
            return false;
        }
        return c(ee2Var);
    }
}
