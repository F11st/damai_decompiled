package tb;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.C4770a;
import com.efs.sdk.base.a.b.HandlerC4774c;
import com.efs.sdk.base.a.b.InterfaceC4778e;
import com.efs.sdk.base.a.c.a.C4783c;
import com.efs.sdk.base.a.d.C4786a;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class l43 extends p33 {
    @Override // tb.p33
    public final void a(j43 j43Var) {
        InterfaceC4778e a;
        byte[] bArr;
        if (j43Var.b.a) {
            b(j43Var);
            return;
        }
        C4770a a2 = C4770a.C4772b.a();
        if (Constants.LOG_TYPE_WA.equals(j43Var.a.a) || HandlerC4774c.a().a) {
            n33 n33Var = j43Var.a;
            if ((n33Var.c == 0 && ((bArr = j43Var.c) == null || bArr.length == 0)) || (a = a2.c.a(n33Var.b)) == null) {
                return;
            }
            a.a(j43Var);
            return;
        }
        if (!a2.a) {
            n73 a3 = n73.C9462a.a();
            int i = C4783c.a().e.a;
            if (a3.b != null || C4786a.a().d) {
                a3.b.b(a3.a("disk_limit", i));
            }
        }
        a2.a = true;
    }
}
