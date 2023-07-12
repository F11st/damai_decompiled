package tb;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.container.slider.GXSliderView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.hs0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class is0 {
    @NotNull
    public static final C9282a Companion = new C9282a(null);
    private final long a;
    private final boolean b;
    private final boolean c;
    private final int d;
    @NotNull
    private final mq0 e;
    @NotNull
    private final mq0 f;
    @NotNull
    private final lz1<hs0> g;
    @NotNull
    private final GXSliderView.IndicatorPosition h;
    @Nullable
    private final String i;
    @Nullable
    private Long j;
    @Nullable
    private Boolean k;
    @Nullable
    private Boolean l;
    @Nullable
    private Integer m;
    @Nullable
    private mq0 n;
    @Nullable
    private mq0 o;
    @Nullable
    private lz1<hs0> p;
    @Nullable
    private GXSliderView.IndicatorPosition q;
    @Nullable
    private String r;

    /* compiled from: Taobao */
    /* renamed from: tb.is0$a */
    /* loaded from: classes6.dex */
    public static final class C9282a {
        private C9282a() {
        }

        public /* synthetic */ C9282a(k50 k50Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Boolean c(JSONObject jSONObject, String str) {
            if (jSONObject.containsKey(str)) {
                return jSONObject.getBoolean(str);
            }
            return null;
        }

        @NotNull
        public final is0 b(@NotNull JSONObject jSONObject) {
            lz1<hs0> lz1Var;
            b41.i(jSONObject, "data");
            Long l = jSONObject.getLong("slider-scroll-time-interval");
            long longValue = l == null ? 3000L : l.longValue();
            Boolean c = c(jSONObject, "slider-infinity-scroll");
            boolean booleanValue = c == null ? true : c.booleanValue();
            Boolean c2 = c(jSONObject, "slider-has-indicator");
            boolean booleanValue2 = c2 == null ? true : c2.booleanValue();
            Integer integer = jSONObject.getInteger("slider-selected-index");
            int intValue = integer == null ? 0 : integer.intValue();
            String string = jSONObject.getString("slider-indicator-selected-color");
            mq0 a = string == null ? null : mq0.Companion.a(string);
            if (a == null) {
                a = mq0.Companion.b("#FFFFFF");
            }
            mq0 mq0Var = a;
            String string2 = jSONObject.getString("slider-indicator-unselected-color");
            mq0 a2 = string2 == null ? null : mq0.Companion.a(string2);
            if (a2 == null) {
                a2 = mq0.Companion.b("#BBBBBB");
            }
            mq0 mq0Var2 = a2;
            String string3 = jSONObject.getString("slider-indicator-margin");
            lz1<hs0> b = string3 != null ? oq0.INSTANCE.b(string3) : null;
            if (b == null) {
                hs0.C9232f c9232f = hs0.C9232f.INSTANCE;
                lz1Var = new lz1<>(c9232f, c9232f, c9232f, c9232f);
            } else {
                lz1Var = b;
            }
            return new is0(longValue, booleanValue, booleanValue2, intValue, mq0Var, mq0Var2, lz1Var, GXSliderView.IndicatorPosition.Companion.a(jSONObject.getString("slider-indicator-position")), jSONObject.getString("slider-indicator-class-android"));
        }
    }

    public is0(long j, boolean z, boolean z2, int i, @NotNull mq0 mq0Var, @NotNull mq0 mq0Var2, @NotNull lz1<hs0> lz1Var, @NotNull GXSliderView.IndicatorPosition indicatorPosition, @Nullable String str) {
        b41.i(mq0Var, "indicatorSelectedColorForTemplate");
        b41.i(mq0Var2, "indicatorUnselectedColorForTemplate");
        b41.i(lz1Var, "indicatorMarginForTemplate");
        b41.i(indicatorPosition, "indicatorPositionForTemplate");
        this.a = j;
        this.b = z;
        this.c = z2;
        this.d = i;
        this.e = mq0Var;
        this.f = mq0Var2;
        this.g = lz1Var;
        this.h = indicatorPosition;
        this.i = str;
    }

    public final boolean a() {
        Boolean bool = this.l;
        return bool == null ? this.c : bool.booleanValue();
    }

    public final boolean b() {
        return this.c;
    }

    @Nullable
    public final String c() {
        String str = this.r;
        return str == null ? this.i : str;
    }

    @Nullable
    public final String d() {
        return this.i;
    }

    @NotNull
    public final lz1<hs0> e() {
        lz1<hs0> lz1Var = this.p;
        return lz1Var == null ? this.g : lz1Var;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof is0) {
            is0 is0Var = (is0) obj;
            return this.a == is0Var.a && this.b == is0Var.b && this.c == is0Var.c && this.d == is0Var.d && b41.d(this.e, is0Var.e) && b41.d(this.f, is0Var.f) && b41.d(this.g, is0Var.g) && this.h == is0Var.h && b41.d(this.i, is0Var.i);
        }
        return false;
    }

    @NotNull
    public final lz1<hs0> f() {
        return this.g;
    }

    @NotNull
    public final GXSliderView.IndicatorPosition g() {
        GXSliderView.IndicatorPosition indicatorPosition = this.q;
        return indicatorPosition == null ? this.h : indicatorPosition;
    }

    @NotNull
    public final GXSliderView.IndicatorPosition h() {
        return this.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z = this.b;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.c;
        int hashCode = (((((((((((i3 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        String str = this.i;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public final mq0 i() {
        mq0 mq0Var = this.n;
        return mq0Var == null ? this.e : mq0Var;
    }

    @NotNull
    public final mq0 j() {
        return this.e;
    }

    @NotNull
    public final mq0 k() {
        mq0 mq0Var = this.o;
        return mq0Var == null ? this.f : mq0Var;
    }

    @NotNull
    public final mq0 l() {
        return this.f;
    }

    public final boolean m() {
        Boolean bool = this.k;
        return bool == null ? this.b : bool.booleanValue();
    }

    public final boolean n() {
        return this.b;
    }

    public final long o() {
        Long l = this.j;
        return l == null ? this.a : l.longValue();
    }

    public final long p() {
        return this.a;
    }

    public final int q() {
        Integer num = this.m;
        return num == null ? this.d : num.intValue();
    }

    public final int r() {
        return this.d;
    }

    public final void s() {
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }

    public final void t(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "extendCssData");
        Long l = jSONObject.getLong("slider-scroll-time-interval");
        C9282a c9282a = Companion;
        Boolean c = c9282a.c(jSONObject, "slider-infinity-scroll");
        Boolean c2 = c9282a.c(jSONObject, "slider-has-indicator");
        Integer integer = jSONObject.getInteger("slider-selected-index");
        String string = jSONObject.getString("slider-indicator-selected-color");
        mq0 a = string == null ? null : mq0.Companion.a(string);
        String string2 = jSONObject.getString("slider-indicator-unselected-color");
        mq0 a2 = string2 == null ? null : mq0.Companion.a(string2);
        String string3 = jSONObject.getString("slider-indicator-margin");
        lz1<hs0> b = string3 == null ? null : oq0.INSTANCE.b(string3);
        String string4 = jSONObject.getString("slider-indicator-position");
        GXSliderView.IndicatorPosition a3 = string4 != null ? GXSliderView.IndicatorPosition.Companion.a(string4) : null;
        String string5 = jSONObject.getString("slider-indicator-class-android");
        if (l != null) {
            this.j = l;
        }
        if (c != null) {
            this.k = c;
        }
        if (c2 != null) {
            this.l = c2;
        }
        if (integer != null) {
            this.m = integer;
        }
        if (a != null) {
            this.n = a;
        }
        if (a2 != null) {
            this.o = a2;
        }
        if (b != null) {
            this.p = b;
        }
        if (a3 != null) {
            this.q = a3;
        }
        if (string5 != null) {
            this.r = string5;
        }
    }

    @NotNull
    public String toString() {
        return "GXSliderConfig(scrollTimeIntervalForTemplate=" + this.a + ", infinityScrollForTemplate=" + this.b + ", hasIndicatorForTemplate=" + this.c + ", selectedIndexForTemplate=" + this.d + ", indicatorSelectedColorForTemplate=" + this.e + ", indicatorUnselectedColorForTemplate=" + this.f + ", indicatorMarginForTemplate=" + this.g + ", indicatorPositionForTemplate=" + this.h + ", indicatorClassForTemplate=" + ((Object) this.i) + ')';
    }
}
