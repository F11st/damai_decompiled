package tb;

import com.efs.sdk.base.a.e.HandlerC4788a;
import com.efs.sdk.base.a.e.HandlerC4790b;
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
        HandlerC4788a a2 = HandlerC4788a.a();
        if (!j43Var.b.b || HandlerC4790b.b().e(j43Var.a.a, j43Var.a())) {
            n73.C9462a.a().c.b();
            n73.C9462a.a().c.c();
            a = a2.b.a(j43Var, false);
        } else {
            a = new l01();
            a.c = "flow_limit";
        }
        j43Var.b.c = a;
        b(j43Var);
    }
}
