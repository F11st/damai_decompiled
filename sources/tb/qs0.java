package tb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.template.GXTemplateInfo;
import com.youku.arch.v3.data.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.pq0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class qs0 {
    @NotNull
    public static final C9621a Companion = new C9621a(null);
    @NotNull
    private final gr0 a;
    @NotNull
    private final pq0 b;
    @Nullable
    private rq0 c;
    @Nullable
    private final vq0 d;
    @Nullable
    private final ss0 e;
    @Nullable
    private final zp0 f;
    @Nullable
    private final qs0 g;
    @Nullable
    private JSONObject h;
    @Nullable
    private JSON i;
    @Nullable
    private JSONObject j;

    /* compiled from: Taobao */
    /* renamed from: tb.qs0$a */
    /* loaded from: classes6.dex */
    public static final class C9621a {
        private C9621a() {
        }

        public /* synthetic */ C9621a(k50 k50Var) {
            this();
        }

        private final pq0 a(pq0 pq0Var) {
            return new pq0(h(pq0Var.b()), b(pq0Var.a()));
        }

        private final br0 b(br0 br0Var) {
            return new br0(br0Var.o(), br0Var.T(), br0Var.m(), br0Var.s(), br0Var.y(), br0Var.L(), br0Var.d(), br0Var.f(), br0Var.b(), br0Var.A(), br0Var.R(), br0Var.D(), br0Var.O(), br0Var.k(), br0Var.u(), br0Var.w(), br0Var.q(), br0Var.W(), br0Var.J(), br0Var.G(), br0Var.h());
        }

        private final er0 c(er0 er0Var) {
            if (er0Var == null) {
                return null;
            }
            return new er0(er0Var.d(), er0Var.c(), er0Var.f(), er0Var.h(), er0Var.j(), er0Var.l());
        }

        private final gr0 d(gr0 gr0Var) {
            return new gr0(gr0Var.d(), gr0Var.a(), gr0Var.k(), gr0Var.j(), gr0Var.b(), f(gr0Var.h()), c(gr0Var.c()), g(gr0Var.i()), e(gr0Var.g()), null, 512, null);
        }

        private final xr0 e(xr0 xr0Var) {
            if (xr0Var == null) {
                return null;
            }
            return new xr0(xr0Var.e(), xr0Var.g(), xr0Var.c(), xr0Var.b());
        }

        private final fs0 f(fs0 fs0Var) {
            if (fs0Var == null) {
                return null;
            }
            return new fs0(fs0Var.a(), fs0Var.c(), fs0Var.i(), fs0Var.e(), fs0Var.g());
        }

        private final is0 g(is0 is0Var) {
            if (is0Var == null) {
                return null;
            }
            return new is0(is0Var.p(), is0Var.n(), is0Var.b(), is0Var.r(), is0Var.j(), is0Var.l(), is0Var.f(), is0Var.h(), is0Var.d());
        }

        private final ls0 h(ls0 ls0Var) {
            return new ls0(ls0Var.B(), ls0Var.v(), ls0Var.J(), ls0Var.z(), ls0Var.t(), ls0Var.H(), ls0Var.D(), ls0Var.d(), ls0Var.f(), ls0Var.P(), ls0Var.R(), ls0Var.p(), ls0Var.L(), ls0Var.U(), ls0Var.l(), ls0Var.h(), ls0Var.j(), ls0Var.x(), ls0Var.F(), ls0Var.N(), ls0Var.n(), ls0Var.b(), ls0Var.r());
        }

        public static /* synthetic */ qs0 j(C9621a c9621a, String str, GXTemplateInfo gXTemplateInfo, qs0 qs0Var, int i, Object obj) {
            if ((i & 4) != 0) {
                qs0Var = null;
            }
            return c9621a.i(str, gXTemplateInfo, qs0Var);
        }

        @NotNull
        public final qs0 i(@NotNull String str, @NotNull GXTemplateInfo gXTemplateInfo, @Nullable qs0 qs0Var) {
            b41.i(str, "viewId");
            b41.i(gXTemplateInfo, Constants.TEMPLATE);
            gr0 g = gXTemplateInfo.g(str);
            if (g != null) {
                pq0 d = gXTemplateInfo.d(str);
                if (d == null) {
                    d = pq0.C9564a.b(pq0.Companion, null, 1, null);
                }
                return new qs0(d(g), a(d), gXTemplateInfo.e(str), gXTemplateInfo.f(str), gXTemplateInfo.i(str), gXTemplateInfo.c(str), qs0Var);
            }
            throw new IllegalArgumentException(b41.r("Not found layer by view id, viewId = ", str));
        }
    }

    public qs0(@NotNull gr0 gr0Var, @NotNull pq0 pq0Var, @Nullable rq0 rq0Var, @Nullable vq0 vq0Var, @Nullable ss0 ss0Var, @Nullable zp0 zp0Var, @Nullable qs0 qs0Var) {
        b41.i(gr0Var, "layer");
        b41.i(pq0Var, "css");
        this.a = gr0Var;
        this.b = pq0Var;
        this.c = rq0Var;
        this.d = vq0Var;
        this.e = ss0Var;
        this.f = zp0Var;
        this.g = qs0Var;
    }

    public final boolean A() {
        return this.a.y();
    }

    public final void B() {
        C();
        is0 i = this.a.i();
        if (i != null) {
            i.s();
        }
        fs0 h = this.a.h();
        if (h != null) {
            h.l();
        }
        er0 c = this.a.c();
        if (c != null) {
            c.o();
        }
        xr0 g = this.a.g();
        if (g != null) {
            g.h();
        }
        this.b.b().X();
        this.b.a().X();
        qs0 qs0Var = this.g;
        if (qs0Var == null) {
            return;
        }
        qs0Var.B();
    }

    public final void C() {
        this.j = null;
        this.i = null;
        this.h = null;
        qs0 qs0Var = this.g;
        if (qs0Var == null) {
            return;
        }
        qs0Var.C();
    }

    public final void D(@Nullable rq0 rq0Var) {
        this.c = rq0Var;
    }

    @Nullable
    public final zp0 a() {
        return this.f;
    }

    @NotNull
    public final pq0 b() {
        return this.b;
    }

    @Nullable
    public final String c() {
        return this.a.b();
    }

    @Nullable
    public final JSONObject d(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "templateData");
        if (this.h == null) {
            rq0 rq0Var = this.c;
            this.h = rq0Var == null ? null : rq0Var.a(jSONObject);
        }
        return this.h;
    }

    @Nullable
    public final rq0 e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof qs0) {
            qs0 qs0Var = (qs0) obj;
            return b41.d(this.a, qs0Var.a) && b41.d(this.b, qs0Var.b) && b41.d(this.c, qs0Var.c) && b41.d(this.d, qs0Var.d) && b41.d(this.e, qs0Var.e) && b41.d(this.f, qs0Var.f) && b41.d(this.g, qs0Var.g);
        }
        return false;
    }

    @Nullable
    public final JSON f(@NotNull JSONObject jSONObject) {
        JSONObject a;
        b41.i(jSONObject, "templateData");
        if (this.i == null) {
            rq0 rq0Var = this.c;
            Object obj = (rq0Var == null || (a = rq0Var.a(jSONObject)) == null) ? null : a.get("value");
            this.i = obj instanceof JSON ? (JSON) obj : null;
        }
        return this.i;
    }

    @Nullable
    public final vq0 g() {
        return this.d;
    }

    @Nullable
    public final JSONObject h(@Nullable JSON json) {
        if (this.j == null) {
            rq0 rq0Var = this.c;
            this.j = rq0Var == null ? null : rq0Var.b(json);
        }
        return this.j;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        rq0 rq0Var = this.c;
        int hashCode2 = (hashCode + (rq0Var == null ? 0 : rq0Var.hashCode())) * 31;
        vq0 vq0Var = this.d;
        int hashCode3 = (hashCode2 + (vq0Var == null ? 0 : vq0Var.hashCode())) * 31;
        ss0 ss0Var = this.e;
        int hashCode4 = (hashCode3 + (ss0Var == null ? 0 : ss0Var.hashCode())) * 31;
        zp0 zp0Var = this.f;
        int hashCode5 = (hashCode4 + (zp0Var == null ? 0 : zp0Var.hashCode())) * 31;
        qs0 qs0Var = this.g;
        return hashCode5 + (qs0Var != null ? qs0Var.hashCode() : 0);
    }

    @NotNull
    public final gr0 i() {
        return this.a;
    }

    @NotNull
    public final String j() {
        return this.a.d();
    }

    @NotNull
    public final String k() {
        return this.a.f();
    }

    @Nullable
    public final ss0 l() {
        return this.e;
    }

    @Nullable
    public final qs0 m() {
        return this.g;
    }

    public final void n(@NotNull os0 os0Var, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2) {
        b41.i(os0Var, "gxTemplateContext");
        rq0 rq0Var = this.c;
        JSONObject b = rq0Var == null ? null : rq0Var.b(jSONObject2);
        if (b != null && (!b.isEmpty())) {
            fs0 h = this.a.h();
            if (h != null) {
                h.m(b);
            }
            er0 c = this.a.c();
            if (c != null) {
                c.p(b);
            }
            is0 i = this.a.i();
            if (i != null) {
                i.t(b);
            }
            xr0 g = this.a.g();
            if (g != null) {
                g.i(b);
            }
            this.b.c(os0Var, b);
        }
        qs0 qs0Var = this.g;
        if (qs0Var == null) {
            return;
        }
        qs0Var.n(os0Var, null, jSONObject);
        b().d(qs0Var.b());
    }

    public final boolean o() {
        return this.a.l();
    }

    public final boolean p() {
        return this.a.m();
    }

    public final boolean q() {
        return this.a.n();
    }

    public final boolean r() {
        return this.a.o();
    }

    public final boolean s() {
        return this.a.p();
    }

    public final boolean t() {
        return this.a.q();
    }

    @NotNull
    public String toString() {
        return "GXTemplateNode(layer=" + this.a + ", css=" + this.b + ", dataBinding=" + this.c + ", eventBinding=" + this.d + ", trackBinding=" + this.e + ", animationBinding=" + this.f + ", visualTemplateNode=" + this.g + ')';
    }

    public final boolean u() {
        return this.a.r();
    }

    public final boolean v() {
        return this.a.t();
    }

    public final boolean w() {
        return this.a.u();
    }

    public final boolean x() {
        return this.a.v();
    }

    public final boolean y() {
        return this.a.w();
    }

    public final boolean z() {
        return this.a.x();
    }
}
