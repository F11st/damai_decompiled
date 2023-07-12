package tb;

import com.alibaba.fastjson.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class pq0 {
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    private final ls0 a;
    @NotNull
    private final br0 b;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        public static /* synthetic */ pq0 b(a aVar, JSONObject jSONObject, int i, Object obj) {
            if ((i & 1) != 0) {
                jSONObject = new JSONObject();
            }
            return aVar.a(jSONObject);
        }

        @NotNull
        public final pq0 a(@NotNull JSONObject jSONObject) {
            b41.i(jSONObject, "data");
            return new pq0(ls0.Companion.a(jSONObject), br0.Companion.a(jSONObject));
        }
    }

    public pq0(@NotNull ls0 ls0Var, @NotNull br0 br0Var) {
        b41.i(ls0Var, "style");
        b41.i(br0Var, "flexBox");
        this.a = ls0Var;
        this.b = br0Var;
    }

    @NotNull
    public final br0 a() {
        return this.b;
    }

    @NotNull
    public final ls0 b() {
        return this.a;
    }

    public final void c(@NotNull os0 os0Var, @NotNull JSONObject jSONObject) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(jSONObject, "extendCssData");
        this.a.v0(jSONObject);
        this.b.t0(os0Var, jSONObject);
    }

    public final void d(@Nullable pq0 pq0Var) {
        if (pq0Var != null) {
            this.a.w0(pq0Var.a);
            this.b.u0(pq0Var.b);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof pq0) {
            pq0 pq0Var = (pq0) obj;
            return b41.d(this.a, pq0Var.a) && b41.d(this.b, pq0Var.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @NotNull
    public String toString() {
        return "GXCss(style=" + this.a + ", flexBox=" + this.b + ')';
    }
}
