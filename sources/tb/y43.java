package tb;

import com.efs.sdk.base.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class y43 extends p33 {
    private static boolean c(j43 j43Var) {
        if (!j43Var.g()) {
            n33 n33Var = j43Var.a;
            if ((1 != n33Var.b || j43Var.b.a) && 1 != n33Var.c) {
                return false;
            }
        }
        return true;
    }

    @Override // tb.p33
    public final void a(j43 j43Var) {
        if (c(j43Var)) {
            b(j43Var);
            return;
        }
        byte[] a = w53.a(j43Var.c);
        if (a == null) {
            w63.b(Constants.TAG, "gzip error", null);
        } else {
            j43Var.e(a);
            j43Var.d("gzip");
        }
        b(j43Var);
    }
}
