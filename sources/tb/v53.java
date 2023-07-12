package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class v53 extends p33 {
    private ILogEncryptAction b;

    public v53() {
        this.b = com.efs.sdk.base.a.d.a.a().o == null ? new k43() : com.efs.sdk.base.a.d.a.a().o;
    }

    private static boolean c(j43 j43Var) {
        if (!j43Var.h() && !Constants.LOG_TYPE_WA.equals(j43Var.a.a)) {
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
        byte[] encrypt = this.b.encrypt(com.efs.sdk.base.a.d.a.a().b, j43Var.c);
        if (encrypt != null) {
            j43Var.e(encrypt);
            j43Var.c(this.b.getDeVal());
        }
        b(j43Var);
    }
}
