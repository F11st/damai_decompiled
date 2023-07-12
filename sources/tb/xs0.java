package tb;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class xs0<T> {
    @NotNull
    private final os0 a;
    @NotNull
    private final qr0 b;

    public xs0(@NotNull os0 os0Var, @NotNull qr0 qr0Var) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "rootNode");
        this.a = os0Var;
        this.b = qr0Var;
    }

    private final void b(os0 os0Var, qr0 qr0Var, T t, List<l81> list) {
        Iterator<T> it;
        List<qr0> d = qr0Var.d();
        if (d == null) {
            return;
        }
        Iterator<T> it2 = d.iterator();
        while (it2.hasNext()) {
            qr0 qr0Var2 = (qr0) it2.next();
            qs0 o = qr0Var2.o();
            l81 c = c(qr0Var2);
            String f = o.i().f();
            String b = o.i().b();
            boolean o2 = o.o();
            boolean z = false;
            if (o2 && o.b().b().V() && (o.m() == null || o.m().b().b().V()) && o.a() == null && o.g() == null && o.e() == null && o.l() == null) {
                List<l81> arrayList = new ArrayList<>();
                arrayList.addAll(list);
                arrayList.add(c);
                b(os0Var, qr0Var2, t, arrayList);
                it = it2;
            } else {
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (l81 l81Var : list) {
                    f2 += l81Var.f();
                    f3 += l81Var.g();
                }
                it = it2;
                T g = g(os0Var, t, f, b, qr0Var2, c, f2, f3);
                if (g != null) {
                    List<qr0> d2 = qr0Var2.d();
                    if (d2 != null && (!d2.isEmpty())) {
                        z = true;
                    }
                    if (z) {
                        if (o2) {
                            List<l81> arrayList2 = new ArrayList<>();
                            l81 b2 = l81.b(c, 0.0f, 0.0f, 0.0f, 0.0f, null, null, 63, null);
                            b2.i(0.0f);
                            b2.j(0.0f);
                            arrayList2.add(b2);
                            b(os0Var, qr0Var2, g, arrayList2);
                        } else {
                            List<l81> arrayList3 = new ArrayList<>();
                            arrayList3.addAll(list);
                            b(os0Var, qr0Var2, t, arrayList3);
                        }
                    }
                } else {
                    throw new IllegalArgumentException("Create child view error");
                }
            }
            it2 = it;
        }
    }

    @NotNull
    public final View a() {
        l81 e = e();
        T h = h(this.a, this.b, e);
        if (h != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(e);
            b(this.a, this.b, h, arrayList);
            View q = this.b.q();
            if (q != null) {
                return q;
            }
            throw new IllegalArgumentException(b41.r("Create root view error, not found root view gxTemplateContext = ", this.a));
        }
        throw new IllegalArgumentException(b41.r("Create root view error gxTemplateContext = ", this.a));
    }

    @NotNull
    public abstract l81 c(@NotNull qr0 qr0Var);

    @NotNull
    public final os0 d() {
        return this.a;
    }

    @NotNull
    public abstract l81 e();

    @NotNull
    public final qr0 f() {
        return this.b;
    }

    @Nullable
    public abstract T g(@NotNull os0 os0Var, T t, @NotNull String str, @Nullable String str2, @NotNull qr0 qr0Var, @NotNull l81 l81Var, float f, float f2);

    @Nullable
    public abstract T h(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull l81 l81Var);
}
