package tb;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.GXIContainer;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.template.GXTemplateInfo;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class os0 {
    @NotNull
    public static final C9533a Companion = new C9533a(null);
    public static final int FLAG_EXTEND_FLEXBOX = 1;
    public static final int FLAG_FLEX_GROW_UPDATE = 2;
    @NotNull
    private final Context a;
    @NotNull
    private GXTemplateEngine.C3343f b;
    @NotNull
    private final GXTemplateEngine.C3347i c;
    @NotNull
    private final GXTemplateInfo d;
    @Nullable
    private qs0 e;
    private boolean f;
    private boolean g;
    private int h;
    private boolean i;
    @Nullable
    private Map<String, GXTemplateEngine.C3349k> j;
    @Nullable
    private Set<uq0> k;
    @Nullable
    private Map<Object, l81> l;
    @Nullable
    private l81 m;
    @Nullable
    private l81 n;
    @Nullable
    private Map<Object, qr0> o;
    private boolean p;
    @Nullable
    private View q;
    @Nullable
    private qr0 r;
    @Nullable
    private GXTemplateEngine.C3346h s;
    private int t;
    @Nullable
    private CopyOnWriteArraySet<GXIContainer> u;
    private int v;

    /* compiled from: Taobao */
    /* renamed from: tb.os0$a */
    /* loaded from: classes6.dex */
    public static final class C9533a {
        private C9533a() {
        }

        public /* synthetic */ C9533a(k50 k50Var) {
            this();
        }

        @NotNull
        public final os0 a(@NotNull GXTemplateEngine.C3347i c3347i, @NotNull GXTemplateEngine.C3343f c3343f, @NotNull GXTemplateInfo gXTemplateInfo, @Nullable qs0 qs0Var) {
            b41.i(c3347i, "gxTemplateItem");
            b41.i(c3343f, "gxMeasureSize");
            b41.i(gXTemplateInfo, "gxTemplateInfo");
            return new os0(c3347i.c(), c3343f, c3347i, gXTemplateInfo, qs0Var, null);
        }

        @Nullable
        public final os0 b(@Nullable View view) {
            if (view instanceof GXIRootView) {
                return ((GXIRootView) view).getTemplateContext();
            }
            return null;
        }
    }

    private os0(Context context, GXTemplateEngine.C3343f c3343f, GXTemplateEngine.C3347i c3347i, GXTemplateInfo gXTemplateInfo, qs0 qs0Var) {
        this.a = context;
        this.b = c3343f;
        this.c = c3347i;
        this.d = gXTemplateInfo;
        this.e = qs0Var;
        this.t = -1;
    }

    public /* synthetic */ os0(Context context, GXTemplateEngine.C3343f c3343f, GXTemplateEngine.C3347i c3347i, GXTemplateInfo gXTemplateInfo, qs0 qs0Var, k50 k50Var) {
        this(context, c3343f, c3347i, gXTemplateInfo, qs0Var);
    }

    public final void A() {
        GXTemplateEngine.GXITrackListener f;
        Map<String, GXTemplateEngine.C3349k> map = this.j;
        if (map != null) {
            for (Map.Entry<String, GXTemplateEngine.C3349k> entry : map.entrySet()) {
                GXTemplateEngine.C3346h p = p();
                if (p != null && (f = p.f()) != null) {
                    f.onManualExposureTrackEvent(entry.getValue());
                }
            }
        }
        Map<String, GXTemplateEngine.C3349k> map2 = this.j;
        if (map2 == null) {
            return;
        }
        map2.clear();
    }

    public final void B() {
        this.v = 0;
        this.m = null;
        this.n = null;
        Map<Object, l81> map = this.l;
        if (map != null) {
            map.clear();
        }
        CopyOnWriteArraySet<GXIContainer> copyOnWriteArraySet = this.u;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
        this.p = false;
        Set<uq0> set = this.k;
        if (set != null) {
            set.clear();
        }
        this.k = null;
        this.s = null;
        this.q = null;
        this.e = null;
        qr0 qr0Var = this.r;
        if (qr0Var != null) {
            qr0Var.K();
        }
        this.r = null;
        this.g = false;
    }

    public final void C() {
        this.d.v();
        qr0 qr0Var = this.r;
        if (qr0Var == null) {
            return;
        }
        qr0Var.M(this);
    }

    public final void D(boolean z) {
        this.i = z;
    }

    public final void E(int i) {
        this.h = i;
    }

    public final void F(boolean z) {
        this.p = z;
    }

    public final void G(@Nullable Set<uq0> set) {
        this.k = set;
    }

    public final void H(@Nullable l81 l81Var) {
        this.n = l81Var;
    }

    public final void I(@Nullable Map<String, GXTemplateEngine.C3349k> map) {
        this.j = map;
    }

    public final void J(boolean z) {
        this.f = z;
    }

    public final void K(boolean z) {
        this.g = z;
    }

    public final void L(@Nullable qr0 qr0Var) {
        this.r = qr0Var;
    }

    public final void M(@Nullable View view) {
        this.q = view;
    }

    public final void N(@Nullable Map<Object, l81> map) {
        this.l = map;
    }

    public final void O(@Nullable Map<Object, qr0> map) {
        this.o = map;
    }

    public final void P(@NotNull GXTemplateEngine.C3343f c3343f) {
        b41.i(c3343f, "<set-?>");
        this.b = c3343f;
    }

    public final void Q(@Nullable l81 l81Var) {
        this.m = l81Var;
    }

    public final void R(@Nullable GXTemplateEngine.C3346h c3346h) {
        this.s = c3346h;
    }

    public final void a() {
        this.v |= 1;
    }

    public final void b() {
        this.v |= 2;
    }

    public final int c() {
        return this.h;
    }

    @Nullable
    public final CopyOnWriteArraySet<GXIContainer> d() {
        return this.u;
    }

    @NotNull
    public final Context e() {
        return this.a;
    }

    @Nullable
    public final Set<uq0> f() {
        return this.k;
    }

    @Nullable
    public final l81 g() {
        return this.n;
    }

    public final int h() {
        return this.t;
    }

    @Nullable
    public final Map<String, GXTemplateEngine.C3349k> i() {
        return this.j;
    }

    @Nullable
    public final qr0 j() {
        return this.r;
    }

    @Nullable
    public final View k() {
        return this.q;
    }

    @Nullable
    public final Map<Object, l81> l() {
        return this.l;
    }

    @Nullable
    public final Map<Object, qr0> m() {
        return this.o;
    }

    @NotNull
    public final GXTemplateEngine.C3343f n() {
        return this.b;
    }

    @Nullable
    public final l81 o() {
        return this.m;
    }

    @Nullable
    public final GXTemplateEngine.C3346h p() {
        return this.s;
    }

    @NotNull
    public final GXTemplateInfo q() {
        return this.d;
    }

    @NotNull
    public final GXTemplateEngine.C3347i r() {
        return this.c;
    }

    @Nullable
    public final qs0 s() {
        return this.e;
    }

    public final void t() {
        if (this.u == null) {
            this.u = new CopyOnWriteArraySet<>();
        }
    }

    public final boolean u() {
        return this.i;
    }

    public final boolean v() {
        return this.p;
    }

    public final boolean w() {
        return (this.v & 1) != 0;
    }

    public final boolean x() {
        return (this.v & 2) != 0;
    }

    public final boolean y() {
        return this.f;
    }

    public final boolean z() {
        return this.g;
    }
}
