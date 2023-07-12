package tb;

import app.visly.stretch.AlignContent;
import app.visly.stretch.AlignItems;
import app.visly.stretch.AlignSelf;
import app.visly.stretch.Direction;
import app.visly.stretch.Display;
import app.visly.stretch.FlexDirection;
import app.visly.stretch.FlexWrap;
import app.visly.stretch.JustifyContent;
import app.visly.stretch.Node;
import app.visly.stretch.Overflow;
import app.visly.stretch.PositionType;
import app.visly.stretch.Style;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class js0 {
    @NotNull
    public static final C9319a Companion = new C9319a(null);
    @Nullable
    private Node a;
    @Nullable
    private l81 b;

    /* compiled from: Taobao */
    /* renamed from: tb.js0$a */
    /* loaded from: classes6.dex */
    public static final class C9319a {
        private C9319a() {
        }

        public /* synthetic */ C9319a(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Style d(os0 os0Var, qs0 qs0Var) {
            pq0 b;
            br0 br0Var = null;
            Style style = new Style(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, 2097151, null);
            e(os0Var, qs0Var.b().a(), style);
            qs0 m = qs0Var.m();
            if (m != null && (b = m.b()) != null) {
                br0Var = b.a();
            }
            if (br0Var != null) {
                js0.Companion.e(os0Var, br0Var, style);
            }
            style.safeInit();
            return style;
        }

        private final void e(os0 os0Var, br0 br0Var, Style style) {
            Display n = br0Var.n();
            if (n != null) {
                style.setDisplay(n);
            }
            Float g = br0Var.g();
            if (g != null) {
                style.setAspectRatio(Float.valueOf(g.floatValue()));
            }
            Direction l = br0Var.l();
            if (l != null) {
                style.setDirection(l);
            }
            FlexDirection r = br0Var.r();
            if (r != null) {
                style.setFlexDirection(r);
            }
            FlexWrap x = br0Var.x();
            if (x != null) {
                style.setFlexWrap(x);
            }
            Overflow K = br0Var.K();
            if (K != null) {
                style.setOverflow(K);
            }
            AlignItems c = br0Var.c();
            if (c != null) {
                style.setAlignItems(c);
            }
            AlignSelf e = br0Var.e();
            if (e != null) {
                style.setAlignSelf(e);
            }
            AlignContent a = br0Var.a();
            if (a != null) {
                style.setAlignContent(a);
            }
            JustifyContent z = br0Var.z();
            if (z != null) {
                style.setJustifyContent(z);
            }
            PositionType S = br0Var.S();
            if (S != null) {
                style.setPositionType(S);
            }
            lz1<k80> Q = br0Var.Q();
            if (Q != null) {
                style.setPosition(Q);
            }
            lz1<k80> C = br0Var.C();
            if (C != null) {
                style.setMargin(C);
            }
            lz1<k80> N = br0Var.N();
            if (N != null) {
                style.setPadding(N);
            }
            lz1<k80> j = br0Var.j();
            if (j != null) {
                style.setBorder(j);
            }
            Float t = br0Var.t();
            if (t != null) {
                style.setFlexGrow(t.floatValue());
                os0Var.b();
            }
            Float v = br0Var.v();
            if (v != null) {
                style.setFlexShrink(v.floatValue());
            }
            ld2<k80> V = br0Var.V();
            if (V != null) {
                style.setSize(new ld2<>(V.b(), V.a()));
            }
            ld2<k80> I = br0Var.I();
            if (I != null) {
                style.setMinSize(new ld2<>(I.b(), I.a()));
            }
            ld2<k80> F = br0Var.F();
            if (F == null) {
                return;
            }
            style.setMaxSize(new ld2<>(F.b(), F.a()));
        }

        @NotNull
        public final js0 b(@NotNull os0 os0Var, @NotNull qs0 qs0Var, @NotNull String str) {
            b41.i(os0Var, "gxTemplateContext");
            b41.i(qs0Var, "templateNode");
            b41.i(str, "id");
            return new js0(null, null, 3, null);
        }

        @NotNull
        public final js0 c(@NotNull os0 os0Var, @NotNull qs0 qs0Var, @NotNull String str) {
            b41.i(os0Var, "gxTemplateContext");
            b41.i(qs0Var, "gxTemplateNode");
            b41.i(str, "id");
            return new js0(new Node(str, d(os0Var, qs0Var), new ArrayList()), null);
        }
    }

    public js0() {
        this(null, null, 3, null);
    }

    public js0(@Nullable Node node, @Nullable l81 l81Var) {
        this.a = node;
        this.b = l81Var;
    }

    private final void f(os0 os0Var, qr0 qr0Var) {
        js0 n;
        Node c;
        Style d = Companion.d(os0Var, qr0Var.o());
        Node node = this.a;
        if (node == null) {
            Node node2 = new Node(qr0Var.g(), d, new ArrayList());
            this.a = node2;
            qr0 l = qr0Var.l();
            if (l == null || (n = l.n()) == null || (c = n.c()) == null) {
                return;
            }
            c.safeAddChild(node2);
            return;
        }
        Style style = node == null ? null : node.getStyle();
        Node node3 = this.a;
        if (node3 != null) {
            node3.safeSetStyle(d);
        }
        Node node4 = this.a;
        if (node4 != null) {
            node4.safeMarkDirty();
        }
        if (style == null) {
            return;
        }
        style.safeFree();
    }

    public final void a() {
        Node node = this.a;
        if (node == null) {
            return;
        }
        node.safeFree();
    }

    @Nullable
    public final l81 b() {
        return this.b;
    }

    @Nullable
    public final Node c() {
        return this.a;
    }

    public final void d() {
    }

    public final void e(@NotNull os0 os0Var, @NotNull qr0 qr0Var) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        f(os0Var, qr0Var);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof js0) {
            js0 js0Var = (js0) obj;
            return b41.d(this.a, js0Var.a) && b41.d(this.b, js0Var.b);
        }
        return false;
    }

    public final void g(@Nullable l81 l81Var) {
        this.b = l81Var;
    }

    public int hashCode() {
        Node node = this.a;
        int hashCode = (node == null ? 0 : node.hashCode()) * 31;
        l81 l81Var = this.b;
        return hashCode + (l81Var != null ? l81Var.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "GXStretchNode(node=" + this.a + ", layoutByPrepareView=" + this.b + ')';
    }

    public /* synthetic */ js0(Node node, l81 l81Var, int i, k50 k50Var) {
        this((i & 1) != 0 ? null : node, (i & 2) != 0 ? null : l81Var);
    }
}
