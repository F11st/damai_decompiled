package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class gr0 {
    @NotNull
    public static final C9184a Companion = new C9184a(null);
    @NotNull
    private final String a;
    @NotNull
    private final String b;
    @NotNull
    private final String c;
    @Nullable
    private final String d;
    @Nullable
    private final String e;
    @Nullable
    private final fs0 f;
    @Nullable
    private final er0 g;
    @Nullable
    private final is0 h;
    @Nullable
    private final xr0 i;
    @NotNull
    private final List<gr0> j;

    /* compiled from: Taobao */
    /* renamed from: tb.gr0$a */
    /* loaded from: classes6.dex */
    public static final class C9184a {
        private C9184a() {
        }

        public /* synthetic */ C9184a(k50 k50Var) {
            this();
        }

        private final gr0 b(JSONObject jSONObject) {
            String string = jSONObject.getString("id");
            if (string != null) {
                String string2 = jSONObject.getString("type");
                if (string2 != null) {
                    gr0 d = d(string, jSONObject.getString("class"), string2, jSONObject.getString("sub-type"), jSONObject.getString("view-class-android"), jSONObject);
                    c(jSONObject, d);
                    return d;
                }
                throw new IllegalArgumentException("Layer must have type property");
            }
            throw new IllegalArgumentException("Layer must have id property");
        }

        private final void c(JSONObject jSONObject, gr0 gr0Var) {
            JSONArray jSONArray = jSONObject.getJSONArray("layers");
            if (jSONArray == null) {
                return;
            }
            for (Object obj : jSONArray) {
                JSONObject jSONObject2 = obj instanceof JSONObject ? (JSONObject) obj : null;
                if (jSONObject2 != null) {
                    gr0Var.e().add(gr0.Companion.b(jSONObject2));
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00cf  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final tb.gr0 d(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.alibaba.fastjson.JSONObject r22) {
            /*
                Method dump skipped, instructions count: 365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.gr0.C9184a.d(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.alibaba.fastjson.JSONObject):tb.gr0");
        }

        private final boolean e(String str, String str2) {
            return b41.d(str, "gaia-template") && b41.d(str2, "grid");
        }

        private final boolean f(String str) {
            return b41.d(str, "progress");
        }

        private final boolean g(String str, String str2) {
            return b41.d(str, "gaia-template") && b41.d(str2, "scroll");
        }

        private final boolean h(String str, String str2) {
            return b41.d(str, "gaia-template") && b41.d(str2, "slider");
        }

        @NotNull
        public final gr0 a(@NotNull JSONObject jSONObject) {
            b41.i(jSONObject, "data");
            return b(jSONObject);
        }
    }

    public gr0(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable fs0 fs0Var, @Nullable er0 er0Var, @Nullable is0 is0Var, @Nullable xr0 xr0Var, @NotNull List<gr0> list) {
        b41.i(str, "id");
        b41.i(str2, "css");
        b41.i(str3, "type");
        b41.i(list, "layers");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = fs0Var;
        this.g = er0Var;
        this.h = is0Var;
        this.i = xr0Var;
        this.j = list;
    }

    @NotNull
    public final String a() {
        return this.b;
    }

    @Nullable
    public final String b() {
        return this.e;
    }

    @Nullable
    public final er0 c() {
        return this.g;
    }

    @NotNull
    public final String d() {
        return this.a;
    }

    @NotNull
    public final List<gr0> e() {
        return this.j;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof gr0) {
            gr0 gr0Var = (gr0) obj;
            return b41.d(this.a, gr0Var.a) && b41.d(this.b, gr0Var.b) && b41.d(this.c, gr0Var.c) && b41.d(this.d, gr0Var.d) && b41.d(this.e, gr0Var.e) && b41.d(this.f, gr0Var.f) && b41.d(this.g, gr0Var.g) && b41.d(this.h, gr0Var.h) && b41.d(this.i, gr0Var.i) && b41.d(this.j, gr0Var.j);
        }
        return false;
    }

    @NotNull
    public final String f() {
        String str = this.d;
        return str != null ? str : this.c;
    }

    @Nullable
    public final xr0 g() {
        return this.i;
    }

    @Nullable
    public final fs0 h() {
        return this.f;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        fs0 fs0Var = this.f;
        int hashCode4 = (hashCode3 + (fs0Var == null ? 0 : fs0Var.hashCode())) * 31;
        er0 er0Var = this.g;
        int hashCode5 = (hashCode4 + (er0Var == null ? 0 : er0Var.hashCode())) * 31;
        is0 is0Var = this.h;
        int hashCode6 = (hashCode5 + (is0Var == null ? 0 : is0Var.hashCode())) * 31;
        xr0 xr0Var = this.i;
        return ((hashCode6 + (xr0Var != null ? xr0Var.hashCode() : 0)) * 31) + this.j.hashCode();
    }

    @Nullable
    public final is0 i() {
        return this.h;
    }

    @Nullable
    public final String j() {
        return this.d;
    }

    @NotNull
    public final String k() {
        return this.c;
    }

    public final boolean l() {
        return !m() && (b41.d("view", this.c) || b41.d(this.c, "gaia-template"));
    }

    public final boolean m() {
        return v() || p() || w();
    }

    public final boolean n() {
        return b41.d(this.c, "custom") && this.e != null;
    }

    public final boolean o() {
        return b41.d("gaia-template", this.c);
    }

    public final boolean p() {
        return b41.d(this.c, "gaia-template") && b41.d(this.d, "grid");
    }

    public final boolean q() {
        return b41.d("iconfont", this.c);
    }

    public final boolean r() {
        return b41.d("image", this.c);
    }

    public final boolean s() {
        GXRegisterCenter.C3334b d = GXRegisterCenter.Companion.a().d();
        return d != null && d.b() ? (b41.d(this.c, "gaia-template") && b41.d(this.d, "custom") && this.e == null) || (b41.d(this.c, "gaia-template") && this.d == null && this.e == null) : b41.d(this.c, "gaia-template") && b41.d(this.d, "custom") && this.e == null;
    }

    public final boolean t() {
        return b41.d("progress", this.c);
    }

    @NotNull
    public String toString() {
        return "GXLayer(id=" + this.a + ", css=" + this.b + ", type=" + this.c + ", subType=" + ((Object) this.d) + ", customNodeClass=" + ((Object) this.e) + ", scrollConfig=" + this.f + ", gridConfig=" + this.g + ", sliderConfig=" + this.h + ", progressConfig=" + this.i + ", layers=" + this.j + ')';
    }

    public final boolean u() {
        return b41.d(WXBasicComponentType.RICHTEXT, this.c);
    }

    public final boolean v() {
        return b41.d(this.c, "gaia-template") && b41.d(this.d, "scroll");
    }

    public final boolean w() {
        return b41.d(this.c, "gaia-template") && b41.d(this.d, "slider");
    }

    public final boolean x() {
        return b41.d("text", this.c);
    }

    public final boolean y() {
        return b41.d("view", this.c) || (b41.d("gaia-template", this.c) && this.d == null);
    }

    public /* synthetic */ gr0(String str, String str2, String str3, String str4, String str5, fs0 fs0Var, er0 er0Var, is0 is0Var, xr0 xr0Var, List list, int i, k50 k50Var) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : fs0Var, (i & 64) != 0 ? null : er0Var, (i & 128) != 0 ? null : is0Var, (i & 256) != 0 ? null : xr0Var, (i & 512) != 0 ? new ArrayList() : list);
    }
}
