package tb;

import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class v63 extends p33 {
    @Override // tb.p33
    public final void a(j43 j43Var) {
        l01 a;
        if (!j43Var.b.a) {
            b(j43Var);
            return;
        }
        com.efs.sdk.base.a.e.a a2 = com.efs.sdk.base.a.e.a.a();
        if (!j43Var.b.b || com.efs.sdk.base.a.e.b.b().e(j43Var.a.a, j43Var.a())) {
            n73.a.a().c.b();
            n73.a.a().c.c();
            a = a2.b.a(j43Var, false);
        } else {
            a = new l01();
            a.c = "flow_limit";
        }
        j43Var.b.c = a;
        b(j43Var);
    }
}
