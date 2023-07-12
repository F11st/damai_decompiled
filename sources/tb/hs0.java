package tb;

import android.content.res.Resources;
import android.util.TypedValue;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.C8602m;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k80;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class hs0 {
    @NotNull
    public static final C9228b Companion = new C9228b(null);

    /* compiled from: Taobao */
    /* renamed from: tb.hs0$a */
    /* loaded from: classes6.dex */
    public static final class C9227a extends hs0 {
        @NotNull
        public static final C9227a INSTANCE = new C9227a();

        private C9227a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.hs0$b */
    /* loaded from: classes6.dex */
    public static final class C9228b {
        private C9228b() {
        }

        public /* synthetic */ C9228b(k50 k50Var) {
            this();
        }

        private final float a(String str) {
            return Float.parseFloat(g(str)) / 100.0f;
        }

        private final float b(String str) {
            return Float.parseFloat(h(str));
        }

        private final float c(String str) {
            return e(Float.parseFloat(i(str)));
        }

        private final String g(String str) {
            String substring = str.substring(0, str.length() - 1);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        private final String h(String str) {
            String substring = str.substring(0, str.length() - 2);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        private final String i(String str) {
            String substring = str.substring(0, str.length() - 2);
            b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        @NotNull
        public final hs0 d(@NotNull String str) {
            CharSequence M0;
            boolean p;
            boolean p2;
            boolean p3;
            boolean s;
            Float h;
            Float create;
            b41.i(str, "targetSize");
            M0 = StringsKt__StringsKt.M0(str);
            String obj = M0.toString();
            p = C8604o.p(obj, "px", false, 2, null);
            if (p) {
                return new C9231e(obj, c(obj));
            }
            p2 = C8604o.p(obj, "pt", false, 2, null);
            if (p2) {
                return new C9230d(obj, b(obj));
            }
            p3 = C8604o.p(obj, "%", false, 2, null);
            if (p3) {
                return new C9229c(obj, a(obj));
            }
            if (b41.d(obj, "auto")) {
                return C9227a.INSTANCE;
            }
            s = C8604o.s(obj);
            if (!s) {
                h = C8602m.h(obj);
                if (h == null) {
                    GXRegisterCenter.GXIExtensionSize p4 = GXRegisterCenter.Companion.a().p();
                    if (p4 == null || (create = p4.create(obj)) == null) {
                        return C9232f.INSTANCE;
                    }
                    return new C9231e(obj, create.floatValue());
                }
                return new C9231e(obj, hs0.Companion.e(h.floatValue()));
            }
            return C9232f.INSTANCE;
        }

        public final float e(float f) {
            int b;
            b = qd1.b(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            return b;
        }

        public final float f(float f) {
            int b;
            Float convert;
            es0 es0Var = es0.INSTANCE;
            GXTemplateEngine.C3337a c3337a = GXTemplateEngine.Companion;
            float min = Math.min(es0Var.b(c3337a.a().g()), es0Var.a(c3337a.a().g())) / e(375.0f);
            GXRegisterCenter.GXIExtensionSize p = GXRegisterCenter.Companion.a().p();
            if (p != null && (convert = p.convert(min)) != null) {
                min = convert.floatValue();
            }
            b = qd1.b(e(f) * Math.max(min, 1.0f));
            return b;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.hs0$c */
    /* loaded from: classes6.dex */
    public static final class C9229c extends hs0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9229c(@NotNull String str, float f) {
            super(null);
            b41.i(str, "targetName");
            this.a = str;
            this.b = f;
        }

        @NotNull
        public final String e() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C9229c) {
                C9229c c9229c = (C9229c) obj;
                return b41.d(this.a, c9229c.a) && b41.d(Float.valueOf(this.b), Float.valueOf(c9229c.b));
            }
            return false;
        }

        public final float f() {
            return this.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
        }

        @NotNull
        public String toString() {
            return "PE(targetName=" + this.a + ", targetValue=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.hs0$d */
    /* loaded from: classes6.dex */
    public static final class C9230d extends hs0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9230d(@NotNull String str, float f) {
            super(null);
            b41.i(str, "targetName");
            this.a = str;
            this.b = f;
        }

        @NotNull
        public final String e() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C9230d) {
                C9230d c9230d = (C9230d) obj;
                return b41.d(this.a, c9230d.a) && b41.d(Float.valueOf(this.b), Float.valueOf(c9230d.b));
            }
            return false;
        }

        public final float f() {
            return this.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
        }

        @NotNull
        public String toString() {
            return "PT(targetName=" + this.a + ", targetValue=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.hs0$e */
    /* loaded from: classes6.dex */
    public static final class C9231e extends hs0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9231e(@NotNull String str, float f) {
            super(null);
            b41.i(str, "targetName");
            this.a = str;
            this.b = f;
        }

        @NotNull
        public final String e() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C9231e) {
                C9231e c9231e = (C9231e) obj;
                return b41.d(this.a, c9231e.a) && b41.d(Float.valueOf(this.b), Float.valueOf(c9231e.b));
            }
            return false;
        }

        public final float f() {
            return this.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + Float.floatToIntBits(this.b);
        }

        @NotNull
        public String toString() {
            return "PX(targetName=" + this.a + ", targetValue=" + this.b + ')';
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.hs0$f */
    /* loaded from: classes6.dex */
    public static final class C9232f extends hs0 {
        @NotNull
        public static final C9232f INSTANCE = new C9232f();

        private C9232f() {
            super(null);
        }
    }

    private hs0() {
    }

    public /* synthetic */ hs0(k50 k50Var) {
        this();
    }

    @NotNull
    public final String a() {
        if (this instanceof C9231e) {
            return ((C9231e) this).e();
        }
        if (this instanceof C9229c) {
            return ((C9229c) this).e();
        }
        if (this instanceof C9230d) {
            return ((C9230d) this).e();
        }
        if (this instanceof C9227a) {
            return "Auto";
        }
        if (this instanceof C9232f) {
            return "Undefined";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final k80 b() {
        if (this instanceof C9231e) {
            return new k80.C9339c(((C9231e) this).f());
        }
        if (this instanceof C9229c) {
            return new k80.C9338b(((C9229c) this).f());
        }
        if (this instanceof C9230d) {
            return new k80.C9339c(Companion.f(((C9230d) this).f()));
        }
        if (this instanceof C9227a) {
            return k80.C9337a.INSTANCE;
        }
        if (this instanceof C9232f) {
            return k80.C9340d.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final float c() {
        if (this instanceof C9231e) {
            return ((C9231e) this).f();
        }
        if (this instanceof C9229c) {
            return ((C9229c) this).f();
        }
        if (this instanceof C9230d) {
            return Companion.f(((C9230d) this).f());
        }
        return 0.0f;
    }

    public final int d() {
        float f;
        if (this instanceof C9231e) {
            f = ((C9231e) this).f();
        } else if (this instanceof C9229c) {
            f = ((C9229c) this).f();
        } else if (!(this instanceof C9230d)) {
            return 0;
        } else {
            f = Companion.f(((C9230d) this).f());
        }
        return (int) f;
    }
}
