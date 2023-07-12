package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.a;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class l43 extends p33 {
    @Override // tb.p33
    public final void a(j43 j43Var) {
        com.efs.sdk.base.a.b.e a;
        byte[] bArr;
        if (j43Var.b.a) {
            b(j43Var);
            return;
        }
        com.efs.sdk.base.a.b.a a2 = a.b.a();
        if (Constants.LOG_TYPE_WA.equals(j43Var.a.a) || com.efs.sdk.base.a.b.c.a().a) {
            n33 n33Var = j43Var.a;
            if ((n33Var.c == 0 && ((bArr = j43Var.c) == null || bArr.length == 0)) || (a = a2.c.a(n33Var.b)) == null) {
                return;
            }
            a.a(j43Var);
            return;
        }
        if (!a2.a) {
            n73 a3 = n73.a.a();
            int i = com.efs.sdk.base.a.c.a.c.a().e.a;
            if (a3.b != null || com.efs.sdk.base.a.d.a.a().d) {
                a3.b.b(a3.a("disk_limit", i));
            }
        }
        a2.a = true;
    }
}
