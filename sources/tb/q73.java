package tb;

import com.efs.sdk.base.a.c.a.C4781a;
import com.efs.sdk.base.a.c.a.C4783c;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class q73 extends p33 {
    @Override // tb.p33
    public final void a(j43 j43Var) {
        Double d;
        C4783c a = C4783c.a();
        String str = j43Var.a.a;
        C4781a c4781a = a.e;
        if (C4783c.a.nextDouble() * 100.0d <= ((!c4781a.e.containsKey(str) || (d = c4781a.e.get(str)) == null) ? 100.0d : d.doubleValue())) {
            b(j43Var);
        }
    }
}
