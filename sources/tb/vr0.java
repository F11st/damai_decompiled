package tb;

import android.graphics.Rect;
import app.visly.stretch.Node;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.utils.GXGlobalCache;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k80;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class vr0 {
    @NotNull
    public static final vr0 INSTANCE = new vr0();
    @NotNull
    public static final String ITEM_CONFIG = "item-type.config";
    @NotNull
    public static final String ITEM_PATH = "item-type.path";

    private vr0() {
    }

    private final void b(qr0 qr0Var, l81 l81Var) {
        Node c = qr0Var.n().c();
        if (c != null) {
            l81Var.h(c.getId());
            qr0Var.S(l81Var);
            List<qr0> d = qr0Var.d();
            if (d == null) {
                return;
            }
            int i = 0;
            for (Object obj : d) {
                int i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.m.p();
                }
                INSTANCE.b((qr0) obj, l81Var.c().get(i));
                i = i2;
            }
            return;
        }
        throw new IllegalArgumentException("stretch node is null, please check!");
    }

    private final void c(qr0 qr0Var, l81 l81Var) {
        Node c = qr0Var.n().c();
        if (c != null) {
            l81Var.h(c.getId());
            qr0Var.n().g(l81Var);
            List<qr0> d = qr0Var.d();
            if (d == null) {
                return;
            }
            int i = 0;
            for (Object obj : d) {
                int i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.m.p();
                }
                INSTANCE.c((qr0) obj, l81Var.c().get(i));
                i = i2;
            }
            return;
        }
        throw new IllegalArgumentException("stretch node is null, please check!");
    }

    private final ld2<k80> d(os0 os0Var, qr0 qr0Var, l81 l81Var, JSONArray jSONArray) {
        if (l81Var != null) {
            er0 c = qr0Var.o().i().c();
            if (c != null) {
                if (c.n()) {
                    int max = Math.max(1, (int) Math.ceil((jSONArray.size() * 1.0f) / c.a(os0Var)));
                    float d = (l81Var.d() * max) + (c.i() * (max - 1));
                    Rect k = qr0Var.k();
                    return new ld2<>(new k80.c((l81Var.e() - k.left) - k.right), new k80.c(d + k.top + k.bottom));
                }
                c.m();
                return null;
            }
            throw new IllegalArgumentException("Want to computeContainerHeight, but gxGridConfig is null");
        }
        return null;
    }

    private final l81 e(os0 os0Var, qr0 qr0Var, JSONObject jSONObject, int i) {
        Pair pair;
        List<Pair<GXTemplateEngine.i, qs0>> c = qr0Var.c();
        if (c == null || c.isEmpty() || (pair = (Pair) kotlin.collections.k.R(c)) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('-');
        sb.append(jSONObject.hashCode());
        String sb2 = sb.toString();
        ld2<Float> g = g(os0Var, qr0Var);
        GXTemplateEngine.i iVar = (GXTemplateEngine.i) pair.getFirst();
        qs0 qs0Var = (qs0) pair.getSecond();
        if (os0Var.g() == null) {
            os0Var.H(f(os0Var, g, iVar, qs0Var, jSONObject, sb2));
        }
        return os0Var.g();
    }

    private final l81 f(os0 os0Var, ld2<Float> ld2Var, GXTemplateEngine.i iVar, qs0 qs0Var, JSONObject jSONObject, String str) {
        return i(os0Var, iVar, new GXTemplateEngine.f(ld2Var.b(), ld2Var.a()), new GXTemplateEngine.h(jSONObject), qs0Var, str);
    }

    private final ld2<Float> g(os0 os0Var, qr0 qr0Var) {
        l81 h = qr0Var.h();
        Float valueOf = h == null ? null : Float.valueOf(h.e());
        if (valueOf == null) {
            l81 i = qr0Var.i();
            valueOf = i == null ? null : Float.valueOf(i.e());
            if (valueOf == null) {
                throw new IllegalArgumentException("Want to computeItemViewPort, but containerWith is null");
            }
        }
        float floatValue = valueOf.floatValue();
        er0 c = qr0Var.o().i().c();
        if (c != null) {
            if (c.n()) {
                int a = c.a(os0Var);
                int g = c.g() * (a - 1);
                Rect k = qr0Var.k();
                return new ld2<>(Float.valueOf((((floatValue - g) - (k.left + k.right)) * 1.0f) / a), null);
            } else if (c.m()) {
                return new ld2<>(null, null);
            } else {
                return new ld2<>(null, null);
            }
        }
        throw new IllegalArgumentException("Want to computeItemViewPort, but config is null");
    }

    private final l81 i(os0 os0Var, GXTemplateEngine.i iVar, GXTemplateEngine.f fVar, GXTemplateEngine.h hVar, qs0 qs0Var, String str) {
        GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
        os0 a = os0.Companion.a(iVar, fVar, aVar.a().h().b(iVar), qs0Var);
        if (!GXGlobalCache.Companion.a().e(iVar)) {
            aVar.a().l().e(a);
        }
        a.R(hVar);
        qr0 c = aVar.a().l().c(a);
        aVar.a().l().a(a);
        ps0.f(os0Var);
        ps0.k(os0Var, str, c);
        return c.h();
    }

    private final ld2<k80> p(qr0 qr0Var, l81 l81Var, JSONArray jSONArray) {
        if (l81Var != null) {
            fs0 h = qr0Var.o().i().h();
            if (h != null) {
                if (h.j()) {
                    return new ld2<>(new k80.c(l81Var.e()), new k80.c(l81Var.d()));
                }
                if (h.k()) {
                    int max = Math.max(1, (int) Math.ceil(jSONArray.size() * 1.0f));
                    return new ld2<>(new k80.c(l81Var.e()), new k80.c((l81Var.d() * max) + (h.h() * (max - 1))));
                }
                return null;
            }
            throw new IllegalArgumentException("Want to computeContainerHeight, but gxScrollConfig is null");
        }
        return null;
    }

    private final l81 q(os0 os0Var, qr0 qr0Var, int i, JSONObject jSONObject) {
        List<Pair<GXTemplateEngine.i, qs0>> c = qr0Var.c();
        if (c == null || c.isEmpty()) {
            return null;
        }
        ld2<Float> o = o(os0Var, qr0Var);
        if (c.size() == 1) {
            Pair pair = (Pair) kotlin.collections.k.R(c);
            if (pair == null) {
                return null;
            }
            qs0 qs0Var = (qs0) pair.getSecond();
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append('-');
            sb.append(jSONObject.hashCode());
            String sb2 = sb.toString();
            t(os0Var, jSONObject, o, (GXTemplateEngine.i) pair.getFirst(), qs0Var, sb2);
            return ps0.b(os0Var, sb2);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(i);
        sb3.append('-');
        sb3.append(jSONObject.hashCode());
        String sb4 = sb3.toString();
        s(os0Var, qr0Var, c, jSONObject, o, sb4);
        return ps0.b(os0Var, sb4);
    }

    private final l81 r(os0 os0Var, ld2<Float> ld2Var, GXTemplateEngine.i iVar, qs0 qs0Var, JSONObject jSONObject, String str) {
        return i(os0Var, iVar, new GXTemplateEngine.f(ld2Var.b(), ld2Var.a()), new GXTemplateEngine.h(jSONObject), qs0Var, str);
    }

    private final void s(os0 os0Var, qr0 qr0Var, List<Pair<GXTemplateEngine.i, qs0>> list, JSONObject jSONObject, ld2<Float> ld2Var, String str) {
        Object obj;
        qr0Var.o().C();
        JSONObject h = qr0Var.o().h(jSONObject);
        if (h != null) {
            String g = yq0.g(h, b41.r("item-type.config.", yq0.g(h, ITEM_PATH)));
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (b41.d(((GXTemplateEngine.i) ((Pair) obj).getFirst()).d(), g)) {
                    break;
                }
            }
            Pair pair = (Pair) obj;
            if (pair == null) {
                return;
            }
            INSTANCE.t(os0Var, jSONObject, ld2Var, (GXTemplateEngine.i) pair.getFirst(), (qs0) pair.getSecond(), str);
        }
    }

    private final void t(os0 os0Var, JSONObject jSONObject, ld2<Float> ld2Var, GXTemplateEngine.i iVar, qs0 qs0Var, String str) {
        l81 r;
        ps0.e(os0Var);
        if (ps0.g(os0Var, str) || (r = r(os0Var, ld2Var, iVar, qs0Var, jSONObject, str)) == null) {
            return;
        }
        ps0.j(os0Var, str, r);
    }

    private final ld2<Float> u(os0 os0Var, qr0 qr0Var) {
        Object convert;
        fs0 h = qr0Var.o().i().h();
        if (h != null) {
            GXRegisterCenter.GXIExtensionScroll o = GXRegisterCenter.Companion.a().o();
            if (o == null || (convert = o.convert("view-port-width", os0Var, h)) == null) {
                Rect k = qr0Var.k();
                float f = k.left;
                float f2 = k.right;
                Float b = os0Var.n().b();
                if (b == null) {
                    return new ld2<>(null, null);
                }
                return new ld2<>(Float.valueOf((b.floatValue() - f) - f2), null);
            }
            return new ld2<>((Float) convert, null);
        }
        throw new IllegalArgumentException("Want to computeItemViewPort, but gxScrollConfig is null");
    }

    private final ld2<k80> w(l81 l81Var) {
        if (l81Var != null) {
            return new ld2<>(new k80.c(l81Var.e()), new k80.c(l81Var.d()));
        }
        return null;
    }

    private final l81 y(os0 os0Var, ld2<Float> ld2Var, GXTemplateEngine.i iVar, qs0 qs0Var, JSONObject jSONObject, String str) {
        return i(os0Var, iVar, new GXTemplateEngine.f(ld2Var.b(), ld2Var.a()), new GXTemplateEngine.h(jSONObject), qs0Var, str);
    }

    @Nullable
    public final ld2<k80> A(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONArray jSONArray) {
        Pair pair;
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONArray, "gxContainerData");
        List<Pair<GXTemplateEngine.i, qs0>> c = qr0Var.c();
        if (c == null || c.isEmpty() || (pair = (Pair) kotlin.collections.k.R(c)) == null) {
            return null;
        }
        Object R = kotlin.collections.k.R(jSONArray);
        JSONObject jSONObject = R instanceof JSONObject ? (JSONObject) R : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObject;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        sb.append('-');
        sb.append(jSONObject2.hashCode());
        String sb2 = sb.toString();
        ld2<Float> z = z(os0Var, qr0Var);
        GXTemplateEngine.i iVar = (GXTemplateEngine.i) pair.getFirst();
        qs0 qs0Var = (qs0) pair.getSecond();
        if (os0Var.o() == null) {
            os0Var.Q(y(os0Var, z, iVar, qs0Var, jSONObject2, sb2));
        }
        return w(os0Var.o());
    }

    public final void a(@NotNull qr0 qr0Var, @NotNull l81 l81Var) {
        b41.i(qr0Var, "gxNode");
        b41.i(l81Var, "layout");
        qr0Var.T(l81Var);
        List<qr0> d = qr0Var.d();
        if (d == null) {
            return;
        }
        int i = 0;
        for (Object obj : d) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.m.p();
            }
            INSTANCE.a((qr0) obj, l81Var.c().get(i));
            i = i2;
        }
    }

    @Nullable
    public final ld2<k80> h(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONArray jSONArray) {
        Pair pair;
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONArray, "gxContainerData");
        List<Pair<GXTemplateEngine.i, qs0>> c = qr0Var.c();
        if (c == null || c.isEmpty() || (pair = (Pair) kotlin.collections.k.R(c)) == null) {
            return null;
        }
        Object R = kotlin.collections.k.R(jSONArray);
        JSONObject jSONObject = R instanceof JSONObject ? (JSONObject) R : null;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = jSONObject;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        sb.append('-');
        sb.append(jSONObject2.hashCode());
        String sb2 = sb.toString();
        ld2<Float> g = g(os0Var, qr0Var);
        GXTemplateEngine.i iVar = (GXTemplateEngine.i) pair.getFirst();
        qs0 qs0Var = (qs0) pair.getSecond();
        if (os0Var.g() == null) {
            os0Var.H(f(os0Var, g, iVar, qs0Var, jSONObject2, sb2));
        }
        return d(os0Var, qr0Var, os0Var.g(), jSONArray);
    }

    public final void j(@NotNull qr0 qr0Var, @NotNull ld2<Float> ld2Var) {
        b41.i(qr0Var, "gxNode");
        b41.i(ld2Var, "size");
        Node c = qr0Var.n().c();
        if (c != null) {
            b(qr0Var, c.safeComputeLayout(ld2Var));
            return;
        }
        throw new IllegalArgumentException("stretch node is null, please check!");
    }

    public final void k(@NotNull qr0 qr0Var, @NotNull ld2<Float> ld2Var) {
        b41.i(qr0Var, "gxNode");
        b41.i(ld2Var, "size");
        Node c = qr0Var.n().c();
        if (c != null) {
            c(qr0Var, c.safeComputeLayout(ld2Var));
            return;
        }
        throw new IllegalArgumentException("stretch node is null, please check!");
    }

    @Nullable
    public final l81 l(@NotNull os0 os0Var, @NotNull ld2<Float> ld2Var, @NotNull GXTemplateEngine.i iVar, @Nullable qs0 qs0Var, @NotNull JSONObject jSONObject, int i) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(ld2Var, "itemViewPort");
        b41.i(iVar, "gxItemTemplateItem");
        b41.i(jSONObject, "itemData");
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('-');
        sb.append(jSONObject.hashCode());
        return i(os0Var, iVar, new GXTemplateEngine.f(ld2Var.b(), ld2Var.a()), new GXTemplateEngine.h(jSONObject), qs0Var, sb.toString());
    }

    @NotNull
    public final ld2<Float> m(@NotNull os0 os0Var, @NotNull qr0 qr0Var) {
        Object convert;
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        if (qr0Var.G()) {
            fs0 h = qr0Var.o().i().h();
            if (h != null) {
                GXRegisterCenter.GXIExtensionScroll o = GXRegisterCenter.Companion.a().o();
                if (o == null || (convert = o.convert("view-port-width", os0Var, h)) == null) {
                    Rect k = qr0Var.k();
                    float f = k.left;
                    float f2 = k.right;
                    Float b = os0Var.n().b();
                    if (b != null) {
                        return new ld2<>(Float.valueOf((b.floatValue() - f) - f2), null);
                    }
                } else {
                    return new ld2<>((Float) convert, null);
                }
            } else {
                throw new IllegalArgumentException("Want to computeItemViewPort, but gxScrollConfig is null");
            }
        } else if (qr0Var.w()) {
            l81 h2 = qr0Var.h();
            Float valueOf = h2 == null ? null : Float.valueOf(h2.e());
            if (valueOf == null) {
                l81 i = qr0Var.i();
                valueOf = i == null ? null : Float.valueOf(i.e());
                if (valueOf == null) {
                    throw new IllegalArgumentException("Want to computeFooterItemViewPort, but containerWith is null");
                }
            }
            float floatValue = valueOf.floatValue();
            er0 c = qr0Var.o().i().c();
            if (c != null) {
                Rect k2 = qr0Var.k();
                if (c.n()) {
                    return new ld2<>(Float.valueOf(floatValue - (k2.left + k2.right)), null);
                }
                if (c.m()) {
                    return new ld2<>(null, null);
                }
                return new ld2<>(null, null);
            }
            throw new IllegalArgumentException("Want to computeFooterItemViewPort, but gxGridConfig is null");
        }
        return new ld2<>(null, null);
    }

    @Nullable
    public final l81 n(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONObject jSONObject, int i) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONObject, "itemData");
        if (qr0Var.G()) {
            return q(os0Var, qr0Var, i, jSONObject);
        }
        if (qr0Var.w()) {
            return e(os0Var, qr0Var, jSONObject, i);
        }
        return null;
    }

    @NotNull
    public final ld2<Float> o(@NotNull os0 os0Var, @NotNull qr0 qr0Var) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        if (qr0Var.G()) {
            return u(os0Var, qr0Var);
        }
        if (qr0Var.w()) {
            return g(os0Var, qr0Var);
        }
        return new ld2<>(null, null);
    }

    @Nullable
    public final ld2<k80> v(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull JSONArray jSONArray) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(jSONArray, "gxContainerData");
        List<Pair<GXTemplateEngine.i, qs0>> c = qr0Var.c();
        if (c == null || c.isEmpty()) {
            return null;
        }
        ld2<Float> u = u(os0Var, qr0Var);
        char c2 = '-';
        String str = "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject";
        if (c.size() == 1) {
            Pair pair = (Pair) kotlin.collections.k.R(c);
            if (pair == null) {
                return null;
            }
            GXTemplateEngine.i iVar = (GXTemplateEngine.i) pair.getFirst();
            qs0 qs0Var = (qs0) pair.getSecond();
            GXGlobalCache.a aVar = GXGlobalCache.Companion;
            if (aVar.a().f(iVar)) {
                return p(qr0Var, aVar.a().d(iVar), jSONArray);
            }
            int i = 0;
            for (Object obj : jSONArray) {
                int i2 = i + 1;
                if (i < 0) {
                    kotlin.collections.m.p();
                }
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.alibaba.fastjson.JSONObject");
                JSONObject jSONObject = (JSONObject) obj;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                sb.append('-');
                sb.append(jSONObject.hashCode());
                INSTANCE.t(os0Var, jSONObject, u, iVar, qs0Var, sb.toString());
                i = i2;
            }
            l81 c3 = ps0.c(os0Var);
            l81 d = ps0.d(os0Var);
            if (c3 != null && d != null) {
                if ((c3.d() == d.d() ? 1 : 0) != 0) {
                    GXGlobalCache.Companion.a().h(iVar, c3);
                }
            }
            return p(qr0Var, c3, jSONArray);
        }
        for (Object obj2 : jSONArray) {
            int i3 = r3 + 1;
            if (r3 < 0) {
                kotlin.collections.m.p();
            }
            Objects.requireNonNull(obj2, str);
            JSONObject jSONObject2 = (JSONObject) obj2;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(r3);
            sb2.append(c2);
            sb2.append(jSONObject2.hashCode());
            INSTANCE.s(os0Var, qr0Var, c, jSONObject2, u, sb2.toString());
            r3 = i3;
            str = str;
            c2 = '-';
        }
        return p(qr0Var, ps0.c(os0Var), jSONArray);
    }

    @Nullable
    public final l81 x(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull ld2<Float> ld2Var, @NotNull JSONObject jSONObject, int i) {
        Pair pair;
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        b41.i(ld2Var, "itemViewPort");
        b41.i(jSONObject, "itemData");
        List<Pair<GXTemplateEngine.i, qs0>> c = qr0Var.c();
        if (c == null || c.isEmpty() || (pair = (Pair) kotlin.collections.k.R(c)) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('-');
        sb.append(jSONObject.hashCode());
        String sb2 = sb.toString();
        GXTemplateEngine.i iVar = (GXTemplateEngine.i) pair.getFirst();
        qs0 qs0Var = (qs0) pair.getSecond();
        if (os0Var.o() == null) {
            os0Var.Q(y(os0Var, ld2Var, iVar, qs0Var, jSONObject, sb2));
        }
        return os0Var.o();
    }

    @NotNull
    public final ld2<Float> z(@NotNull os0 os0Var, @NotNull qr0 qr0Var) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "gxNode");
        ld2<k80> V = qr0Var.o().b().a().V();
        k80 b = V == null ? null : V.b();
        if (b instanceof k80.c) {
            Float b2 = os0Var.n().b();
            if (b2 != null) {
                return new ld2<>(Float.valueOf(b2.floatValue() * ((k80.c) b).b()), null);
            }
        } else {
            Float b3 = os0Var.n().b();
            if (b3 != null) {
                return new ld2<>(Float.valueOf(b3.floatValue()), null);
            }
        }
        return new ld2<>(null, null);
    }
}
