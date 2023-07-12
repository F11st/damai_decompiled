package tb;

import app.visly.stretch.Node;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.template.GXTemplateInfo;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tb.qs0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ur0 {
    @NotNull
    public static final ur0 INSTANCE = new ur0();

    private ur0() {
    }

    private final qr0 b(os0 os0Var, qr0 qr0Var, gr0 gr0Var, qs0 qs0Var, GXTemplateInfo gXTemplateInfo) {
        Node c;
        Node c2;
        qr0 qr0Var2 = new qr0();
        qr0Var2.W(qr0Var);
        qr0Var2.R(gr0Var.d());
        qr0Var2.a0(qs0.Companion.i(gr0Var.d(), gXTemplateInfo, qs0Var));
        qr0Var2.Z(js0.Companion.c(os0Var, qr0Var2.o(), qr0Var2.g()));
        for (gr0 gr0Var2 : gr0Var.e()) {
            if (gr0Var2.s()) {
                GXTemplateInfo j = gXTemplateInfo.j(gr0Var2.d());
                if (j != null) {
                    qs0 j2 = qs0.a.j(qs0.Companion, gr0Var2.d(), gXTemplateInfo, null, 4, null);
                    gr0 p = j.p();
                    if (qr0Var2.t() && j.u()) {
                        qr0Var2.a(new GXTemplateEngine.i(os0Var.e(), os0Var.r().a(), p.d()), j2);
                    } else {
                        qr0 b = INSTANCE.b(os0Var, qr0Var2, p, j2, j);
                        b.V(true);
                        if (qr0Var2.d() == null) {
                            qr0Var2.P(new ArrayList());
                        }
                        List<qr0> d = qr0Var2.d();
                        if (d != null) {
                            d.add(b);
                        }
                        Node c3 = b.n().c();
                        if (c3 != null && (c = qr0Var2.n().c()) != null) {
                            c.safeAddChild(c3);
                        }
                    }
                } else {
                    throw new IllegalArgumentException(b41.r("Child template not found, id = ", gr0Var2.d()));
                }
            } else {
                qr0 b2 = INSTANCE.b(os0Var, qr0Var2, gr0Var2, null, gXTemplateInfo);
                if (qr0Var2.d() == null) {
                    qr0Var2.P(new ArrayList());
                }
                List<qr0> d2 = qr0Var2.d();
                if (d2 != null) {
                    d2.add(b2);
                }
                Node c4 = b2.n().c();
                if (c4 != null && (c2 = qr0Var2.n().c()) != null) {
                    c2.safeAddChild(c4);
                }
            }
        }
        return qr0Var2;
    }

    @NotNull
    public final qr0 a(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        qr0 b = b(os0Var, null, os0Var.q().p(), os0Var.s(), os0Var.q());
        b.Y(true);
        vr0.INSTANCE.k(b, new ld2<>(os0Var.n().b(), os0Var.n().a()));
        return b;
    }
}
