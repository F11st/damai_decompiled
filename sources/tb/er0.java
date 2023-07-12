package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class er0 {
    @NotNull
    public static final C9111a Companion = new C9111a(null);
    @NotNull
    private final JSONObject a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final boolean f;
    @Nullable
    private Integer g;
    @Nullable
    private Integer h;
    @Nullable
    private Integer i;
    @Nullable
    private Integer j;
    @Nullable
    private Boolean k;

    /* compiled from: Taobao */
    /* renamed from: tb.er0$a */
    /* loaded from: classes6.dex */
    public static final class C9111a {
        private C9111a() {
        }

        public /* synthetic */ C9111a(k50 k50Var) {
            this();
        }

        @NotNull
        public final er0 a(@NotNull JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, int i, boolean z) {
            b41.i(jSONObject, "data");
            int max = Math.max(i, 1);
            oq0 oq0Var = oq0.INSTANCE;
            if (str == null) {
                str = LiveBundleLayout.TYPE_VERTICAL;
            }
            return new er0(jSONObject, max, oq0Var.a(str), oq0Var.d(str2), oq0Var.d(str3), z);
        }
    }

    public er0(@NotNull JSONObject jSONObject, int i, int i2, int i3, int i4, boolean z) {
        b41.i(jSONObject, "data");
        this.a = jSONObject;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = z;
    }

    public final int a(@NotNull os0 os0Var) {
        Object convert;
        b41.i(os0Var, WPKFactory.INIT_KEY_CONTEXT);
        GXRegisterCenter.GXIExtensionGrid l = GXRegisterCenter.Companion.a().l();
        if (l == null || (convert = l.convert("column", os0Var, this)) == null) {
            return b();
        }
        return ((Integer) convert).intValue();
    }

    public final int b() {
        Integer num = this.g;
        return num == null ? this.b : num.intValue();
    }

    public final int c() {
        return this.b;
    }

    @NotNull
    public final JSONObject d() {
        return this.a;
    }

    public final int e() {
        Integer num = this.h;
        return num == null ? this.c : num.intValue();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof er0) {
            er0 er0Var = (er0) obj;
            return b41.d(this.a, er0Var.a) && this.b == er0Var.b && this.c == er0Var.c && this.d == er0Var.d && this.e == er0Var.e && this.f == er0Var.f;
        }
        return false;
    }

    public final int f() {
        return this.c;
    }

    public final int g() {
        Integer num = this.i;
        return num == null ? this.d : num.intValue();
    }

    public final int h() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31;
        boolean z = this.f;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final int i() {
        Integer num = this.j;
        return num == null ? this.e : num.intValue();
    }

    public final int j() {
        return this.e;
    }

    public final boolean k() {
        Boolean bool = this.k;
        return bool == null ? this.f : bool.booleanValue();
    }

    public final boolean l() {
        return this.f;
    }

    public final boolean m() {
        return e() == 0;
    }

    public final boolean n() {
        return e() == 1;
    }

    public final void o() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
    }

    public final void p(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "extendCssData");
        Integer integer = jSONObject.getInteger("column");
        Boolean bool = jSONObject.getBoolean("scroll-enable");
        String string = jSONObject.getString("item-spacing");
        if (string == null) {
            string = jSONObject.getString("line-spacing");
        }
        String string2 = jSONObject.getString("row-spacing");
        if (string2 == null) {
            string2 = jSONObject.getString("interitem-spacing");
        }
        if (integer != null) {
            this.g = Integer.valueOf(Math.max(integer.intValue(), 1));
        }
        if (string != null) {
            this.i = Integer.valueOf(oq0.INSTANCE.d(string));
        }
        if (string2 != null) {
            this.j = Integer.valueOf(oq0.INSTANCE.d(string2));
        }
        if (bool != null) {
            this.k = bool;
        }
    }

    @NotNull
    public String toString() {
        return "GXGridConfig(data=" + this.a + ", columnForTemplate=" + this.b + ", directionForTemplate=" + this.c + ", itemSpacingForTemplate=" + this.d + ", rowSpacingForTemplate=" + this.e + ", scrollEnableForTemplate=" + this.f + ')';
    }
}
