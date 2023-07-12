package tb;

import android.graphics.Rect;
import com.alibaba.fastjson.JSONObject;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class fs0 {
    @NotNull
    public static final C9146a Companion = new C9146a(null);
    @NotNull
    private final JSONObject a;
    private int b;
    private int c;
    @NotNull
    private Rect d;
    private int e;
    @Nullable
    private Integer f;
    @Nullable
    private Integer g;
    @Nullable
    private Integer h;

    /* compiled from: Taobao */
    /* renamed from: tb.fs0$a */
    /* loaded from: classes6.dex */
    public static final class C9146a {
        private C9146a() {
        }

        public /* synthetic */ C9146a(k50 k50Var) {
            this();
        }

        @NotNull
        public final fs0 a(@NotNull JSONObject jSONObject, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num) {
            b41.i(jSONObject, "data");
            oq0 oq0Var = oq0.INSTANCE;
            if (str == null) {
                str = LiveBundleLayout.TYPE_VERTICAL;
            }
            int a = oq0Var.a(str);
            int d = oq0Var.d(str3);
            Rect c = oq0Var.c(str2);
            if (c == null) {
                c = new Rect(0, 0, 0, 0);
            }
            return new fs0(jSONObject, a, d, c, num == null ? 48 : num.intValue());
        }
    }

    public fs0(@NotNull JSONObject jSONObject, int i, int i2, @NotNull Rect rect, int i3) {
        b41.i(jSONObject, "data");
        b41.i(rect, "edgeInsetsForTemplate");
        this.a = jSONObject;
        this.b = i;
        this.c = i2;
        this.d = rect;
        this.e = i3;
    }

    @NotNull
    public final JSONObject a() {
        return this.a;
    }

    public final int b() {
        Integer num = this.f;
        return num == null ? this.b : num.intValue();
    }

    public final int c() {
        return this.b;
    }

    @NotNull
    public final Rect d() {
        return this.d;
    }

    @NotNull
    public final Rect e() {
        return this.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof fs0) {
            fs0 fs0Var = (fs0) obj;
            return b41.d(this.a, fs0Var.a) && this.b == fs0Var.b && this.c == fs0Var.c && b41.d(this.d, fs0Var.d) && this.e == fs0Var.e;
        }
        return false;
    }

    public final int f() {
        Integer num = this.h;
        return num == null ? this.e : num.intValue();
    }

    public final int g() {
        return this.e;
    }

    public final int h() {
        Integer num = this.g;
        return num == null ? this.c : num.intValue();
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e;
    }

    public final int i() {
        return this.c;
    }

    public final boolean j() {
        return b() == 0;
    }

    public final boolean k() {
        return b() == 1;
    }

    public final void l() {
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public final void m(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "extendCssData");
        String string = jSONObject.getString("item-spacing");
        if (string != null) {
            this.g = Integer.valueOf(oq0.INSTANCE.d(string));
        }
    }

    @NotNull
    public String toString() {
        return "GXScrollConfig(data=" + this.a + ", directionForTemplate=" + this.b + ", itemSpacingForTemplate=" + this.c + ", edgeInsetsForTemplate=" + this.d + ", gravityForTemplate=" + this.e + ')';
    }
}
