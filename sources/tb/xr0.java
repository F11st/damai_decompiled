package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.common.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class xr0 {
    @NotNull
    public static final C9938a Companion = new C9938a(null);
    @NotNull
    private final mq0 a;
    @NotNull
    private final mq0 b;
    @NotNull
    private final String c;
    private final boolean d;
    @Nullable
    private mq0 e;
    @Nullable
    private mq0 f;
    @Nullable
    private Boolean g;

    /* compiled from: Taobao */
    /* renamed from: tb.xr0$a */
    /* loaded from: classes6.dex */
    public static final class C9938a {
        private C9938a() {
        }

        public /* synthetic */ C9938a(k50 k50Var) {
            this();
        }

        @NotNull
        public final xr0 a(@NotNull JSONObject jSONObject) {
            b41.i(jSONObject, "data");
            String string = jSONObject.getString("stroke-color");
            mq0 a = string == null ? null : mq0.Companion.a(string);
            if (a == null) {
                a = mq0.Companion.b("#0000FF");
            }
            String string2 = jSONObject.getString("trail-color");
            mq0 a2 = string2 != null ? mq0.Companion.a(string2) : null;
            if (a2 == null) {
                a2 = mq0.Companion.b("#BBBBBB");
            }
            String string3 = jSONObject.getString("progress-type");
            if (string3 == null) {
                string3 = "line";
            }
            Boolean bool = jSONObject.getBoolean(Constants.Name.ANIMATED);
            return new xr0(a, a2, string3, bool == null ? true : bool.booleanValue());
        }
    }

    public xr0(@NotNull mq0 mq0Var, @NotNull mq0 mq0Var2, @NotNull String str, boolean z) {
        b41.i(mq0Var, "strokeColorForTemplate");
        b41.i(mq0Var2, "trailColorForTemplate");
        b41.i(str, "progressTypeForTemplate");
        this.a = mq0Var;
        this.b = mq0Var2;
        this.c = str;
        this.d = z;
    }

    public final boolean a() {
        Boolean bool = this.g;
        return bool == null ? this.d : bool.booleanValue();
    }

    public final boolean b() {
        return this.d;
    }

    @NotNull
    public final String c() {
        return this.c;
    }

    @NotNull
    public final mq0 d() {
        mq0 mq0Var = this.e;
        return mq0Var == null ? this.a : mq0Var;
    }

    @NotNull
    public final mq0 e() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof xr0) {
            xr0 xr0Var = (xr0) obj;
            return b41.d(this.a, xr0Var.a) && b41.d(this.b, xr0Var.b) && b41.d(this.c, xr0Var.c) && this.d == xr0Var.d;
        }
        return false;
    }

    @NotNull
    public final mq0 f() {
        mq0 mq0Var = this.f;
        return mq0Var == null ? this.b : mq0Var;
    }

    @NotNull
    public final mq0 g() {
        return this.b;
    }

    public final void h() {
        this.e = null;
        this.f = null;
        this.g = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final void i(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "extendCssData");
        String string = jSONObject.getString("stroke-color");
        mq0 a = string == null ? null : mq0.Companion.a(string);
        String string2 = jSONObject.getString("trail-color");
        mq0 a2 = string2 != null ? mq0.Companion.a(string2) : null;
        jSONObject.getString("progress-type");
        Boolean bool = jSONObject.getBoolean(Constants.Name.ANIMATED);
        if (a != null) {
            this.e = a;
        }
        if (a2 != null) {
            this.f = a2;
        }
        if (bool != null) {
            this.g = bool;
        }
    }

    @NotNull
    public String toString() {
        return "GXProgressConfig(strokeColorForTemplate=" + this.a + ", trailColorForTemplate=" + this.b + ", progressTypeForTemplate=" + this.c + ", animatedForTemplate=" + this.d + ')';
    }
}
