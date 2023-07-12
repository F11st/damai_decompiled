package tb;

import android.content.res.Resources;
import android.util.TypedValue;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import kotlin.NoWhenBranchMatchedException;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.k80;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public abstract class hs0 {
    @NotNull
    public static final b Companion = new b(null);

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a extends hs0 {
        @NotNull
        public static final a INSTANCE = new a();

        private a() {
            super(null);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k50 k50Var) {
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
            p = kotlin.text.o.p(obj, "px", false, 2, null);
            if (p) {
                return new e(obj, c(obj));
            }
            p2 = kotlin.text.o.p(obj, "pt", false, 2, null);
            if (p2) {
                return new d(obj, b(obj));
            }
            p3 = kotlin.text.o.p(obj, "%", false, 2, null);
            if (p3) {
                return new c(obj, a(obj));
            }
            if (b41.d(obj, "auto")) {
                return a.INSTANCE;
            }
            s = kotlin.text.o.s(obj);
            if (!s) {
                h = kotlin.text.m.h(obj);
                if (h == null) {
                    GXRegisterCenter.GXIExtensionSize p4 = GXRegisterCenter.Companion.a().p();
                    if (p4 == null || (create = p4.create(obj)) == null) {
                        return f.INSTANCE;
                    }
                    return new e(obj, create.floatValue());
                }
                return new e(obj, hs0.Companion.e(h.floatValue()));
            }
            return f.INSTANCE;
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
            GXTemplateEngine.a aVar = GXTemplateEngine.Companion;
            float min = Math.min(es0Var.b(aVar.a().g()), es0Var.a(aVar.a().g())) / e(375.0f);
            GXRegisterCenter.GXIExtensionSize p = GXRegisterCenter.Companion.a().p();
            if (p != null && (convert = p.convert(min)) != null) {
                min = convert.floatValue();
            }
            b = qd1.b(e(f) * Math.max(min, 1.0f));
            return b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class c extends hs0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull String str, float f) {
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
            if (obj instanceof c) {
                c cVar = (c) obj;
                return b41.d(this.a, cVar.a) && b41.d(Float.valueOf(this.b), Float.valueOf(cVar.b));
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
    /* loaded from: classes6.dex */
    public static final class d extends hs0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@NotNull String str, float f) {
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
            if (obj instanceof d) {
                d dVar = (d) obj;
                return b41.d(this.a, dVar.a) && b41.d(Float.valueOf(this.b), Float.valueOf(dVar.b));
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
    /* loaded from: classes6.dex */
    public static final class e extends hs0 {
        @NotNull
        private final String a;
        private final float b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull String str, float f) {
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
            if (obj instanceof e) {
                e eVar = (e) obj;
                return b41.d(this.a, eVar.a) && b41.d(Float.valueOf(this.b), Float.valueOf(eVar.b));
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
    /* loaded from: classes6.dex */
    public static final class f extends hs0 {
        @NotNull
        public static final f INSTANCE = new f();

        private f() {
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
        if (this instanceof e) {
            return ((e) this).e();
        }
        if (this instanceof c) {
            return ((c) this).e();
        }
        if (this instanceof d) {
            return ((d) this).e();
        }
        if (this instanceof a) {
            return "Auto";
        }
        if (this instanceof f) {
            return "Undefined";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final k80 b() {
        if (this instanceof e) {
            return new k80.c(((e) this).f());
        }
        if (this instanceof c) {
            return new k80.b(((c) this).f());
        }
        if (this instanceof d) {
            return new k80.c(Companion.f(((d) this).f()));
        }
        if (this instanceof a) {
            return k80.a.INSTANCE;
        }
        if (this instanceof f) {
            return k80.d.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final float c() {
        if (this instanceof e) {
            return ((e) this).f();
        }
        if (this instanceof c) {
            return ((c) this).f();
        }
        if (this instanceof d) {
            return Companion.f(((d) this).f());
        }
        return 0.0f;
    }

    public final int d() {
        float f2;
        if (this instanceof e) {
            f2 = ((e) this).f();
        } else if (this instanceof c) {
            f2 = ((c) this).f();
        } else if (!(this instanceof d)) {
            return 0;
        } else {
            f2 = Companion.f(((d) this).f());
        }
        return (int) f2;
    }
}
