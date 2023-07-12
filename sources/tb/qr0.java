package tb;

import android.animation.AnimatorSet;
import android.graphics.Rect;
import android.view.View;
import app.visly.stretch.Display;
import app.visly.stretch.Node;
import app.visly.stretch.Style;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.node.GXINodeEvent;
import com.alibaba.gaiax.render.view.GXIRelease;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class qr0 {
    @Nullable
    private AnimatorSet a;
    private boolean b;
    @NotNull
    private String c = "";
    private boolean d;
    @Nullable
    private View e;
    @Nullable
    private GXShadowLayout f;
    @Nullable
    private View g;
    public qs0 h;
    public js0 i;
    @Nullable
    private l81 j;
    @Nullable
    private l81 k;
    @Nullable
    private qr0 l;
    @Nullable
    private List<qr0> m;
    @Nullable
    private GXINodeEvent n;
    @Nullable
    private List<Pair<GXTemplateEngine.i, qs0>> o;

    private final boolean D(qr0 qr0Var) {
        Style style;
        Node c = qr0Var.n().c();
        Display display = null;
        if (c != null && (style = c.getStyle()) != null) {
            display = style.getDisplay();
        }
        if (display == Display.None) {
            return false;
        }
        qr0 qr0Var2 = qr0Var.l;
        if (qr0Var2 == null) {
            return true;
        }
        return D(qr0Var2);
    }

    public final boolean A() {
        return (J() || y()) && o().b().b().m() != null;
    }

    public final boolean B() {
        return this.d;
    }

    public final boolean C() {
        return D(this);
    }

    public final boolean E() {
        return o().v();
    }

    public final boolean F() {
        return o().w();
    }

    public final boolean G() {
        return o().x();
    }

    public final boolean H() {
        return o().y();
    }

    public final boolean I() {
        return o().z();
    }

    public final boolean J() {
        return o().A();
    }

    public final void K() {
        this.b = false;
        View view = this.e;
        if (view instanceof GXIRelease) {
            Objects.requireNonNull(view, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.GXIRelease");
            ((GXIRelease) view).release();
        }
        this.e = null;
        this.f = null;
        n().a();
        List<qr0> list = this.m;
        if (list != null) {
            for (qr0 qr0Var : list) {
                qr0Var.K();
            }
        }
        List<qr0> list2 = this.m;
        if (list2 != null) {
            list2.clear();
        }
        this.l = null;
    }

    public final void L(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        this.k = null;
        o().B();
        n().e(os0Var, this);
    }

    public final void M(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        L(os0Var);
        List<qr0> list = this.m;
        if (list == null) {
            return;
        }
        for (qr0 qr0Var : list) {
            qr0Var.M(os0Var);
        }
    }

    public final void N(boolean z) {
        this.b = z;
    }

    public final void O(@Nullable GXShadowLayout gXShadowLayout) {
        this.f = gXShadowLayout;
    }

    public final void P(@Nullable List<qr0> list) {
        this.m = list;
    }

    public final void Q(@Nullable GXINodeEvent gXINodeEvent) {
        this.n = gXINodeEvent;
    }

    public final void R(@NotNull String str) {
        b41.i(str, "<set-?>");
        this.c = str;
    }

    public final void S(@Nullable l81 l81Var) {
        this.k = l81Var;
    }

    public final void T(@Nullable l81 l81Var) {
        this.j = l81Var;
    }

    public final void U(@Nullable View view) {
        this.g = view;
    }

    public final void V(boolean z) {
        this.d = z;
    }

    public final void W(@Nullable qr0 qr0Var) {
        this.l = qr0Var;
    }

    public final void X(@Nullable AnimatorSet animatorSet) {
        this.a = animatorSet;
    }

    public final void Y(boolean z) {
    }

    public final void Z(@NotNull js0 js0Var) {
        b41.i(js0Var, "<set-?>");
        this.i = js0Var;
    }

    public final void a(@NotNull GXTemplateEngine.i iVar, @NotNull qs0 qs0Var) {
        b41.i(iVar, "templateItem");
        b41.i(qs0Var, "visualTemplateNode");
        if (this.o == null) {
            this.o = new ArrayList();
        }
        List<Pair<GXTemplateEngine.i, qs0>> list = this.o;
        if (list == null) {
            return;
        }
        list.add(new Pair<>(iVar, qs0Var));
    }

    public final void a0(@NotNull qs0 qs0Var) {
        b41.i(qs0Var, "<set-?>");
        this.h = qs0Var;
    }

    @Nullable
    public final GXShadowLayout b() {
        return this.f;
    }

    public final void b0(@Nullable View view) {
        this.e = view;
    }

    @Nullable
    public final List<Pair<GXTemplateEngine.i, qs0>> c() {
        return this.o;
    }

    @Nullable
    public final List<qr0> d() {
        return this.m;
    }

    @Nullable
    public final String e() {
        return o().c();
    }

    @Nullable
    public final GXINodeEvent f() {
        return this.n;
    }

    @NotNull
    public final String g() {
        return this.c;
    }

    @Nullable
    public final l81 h() {
        return this.k;
    }

    @Nullable
    public final l81 i() {
        return this.j;
    }

    @Nullable
    public final View j() {
        return this.g;
    }

    @NotNull
    public final Rect k() {
        return o().b().b().T();
    }

    @Nullable
    public final qr0 l() {
        return this.l;
    }

    @Nullable
    public final AnimatorSet m() {
        return this.a;
    }

    @NotNull
    public final js0 n() {
        js0 js0Var = this.i;
        if (js0Var != null) {
            return js0Var;
        }
        b41.A("stretchNode");
        return null;
    }

    @NotNull
    public final qs0 o() {
        qs0 qs0Var = this.h;
        if (qs0Var != null) {
            return qs0Var;
        }
        b41.A("templateNode");
        return null;
    }

    @NotNull
    public final String p() {
        return o().k();
    }

    @Nullable
    public final View q() {
        return this.e;
    }

    public final void r() {
        if (this.n == null) {
            GXRegisterCenter.GXIExtensionNodeEvent n = GXRegisterCenter.Companion.a().n();
            this.n = n == null ? null : n.create();
        }
    }

    public final boolean s() {
        return this.b;
    }

    public final boolean t() {
        return o().p();
    }

    public final boolean u() {
        return o().q();
    }

    public final boolean v() {
        return o().r();
    }

    public final boolean w() {
        return o().s();
    }

    public final boolean x() {
        return o().t();
    }

    public final boolean y() {
        return o().u();
    }

    public final boolean z() {
        String b;
        boolean q;
        zp0 a = o().a();
        if (a != null && (b = a.b()) != null) {
            q = kotlin.text.o.q(b, f81.TAG, true);
            if (q) {
                return true;
            }
        }
        return false;
    }
}
