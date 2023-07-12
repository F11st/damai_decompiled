package tb;

import com.taobao.weex.ui.component.richtext.node.RichTextNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class l81 {
    @NotNull
    public static final a Companion = new a(null);
    private float a;
    private float b;
    private final float c;
    private final float d;
    @NotNull
    private final List<l81> e;
    @NotNull
    private String f;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final Pair<Integer, l81> a(@NotNull float[] fArr, int i) {
            b41.i(fArr, "args");
            int i2 = i + 1;
            float f = fArr[i];
            int i3 = i2 + 1;
            float f2 = fArr[i2];
            int i4 = i3 + 1;
            float f3 = fArr[i3];
            int i5 = i4 + 1;
            float f4 = fArr[i4];
            int i6 = i5 + 1;
            int i7 = (int) fArr[i5];
            ArrayList arrayList = new ArrayList();
            if (i7 > 0) {
                int i8 = 0;
                do {
                    i8++;
                    Pair<Integer, l81> a = l81.Companion.a(fArr, i6);
                    int intValue = a.getFirst().intValue();
                    arrayList.add(a.getSecond());
                    i6 = intValue;
                } while (i8 < i7);
                return new Pair<>(Integer.valueOf(i6), new l81(f, f2, f3, f4, arrayList, null, 32, null));
            }
            return new Pair<>(Integer.valueOf(i6), new l81(f, f2, f3, f4, arrayList, null, 32, null));
        }
    }

    public l81(float f, float f2, float f3, float f4, @NotNull List<l81> list, @NotNull String str) {
        b41.i(list, RichTextNode.CHILDREN);
        b41.i(str, "id");
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e = list;
        this.f = str;
    }

    public static /* synthetic */ l81 b(l81 l81Var, float f, float f2, float f3, float f4, List list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            f = l81Var.a;
        }
        if ((i & 2) != 0) {
            f2 = l81Var.b;
        }
        float f5 = f2;
        if ((i & 4) != 0) {
            f3 = l81Var.c;
        }
        float f6 = f3;
        if ((i & 8) != 0) {
            f4 = l81Var.d;
        }
        float f7 = f4;
        List<l81> list2 = list;
        if ((i & 16) != 0) {
            list2 = l81Var.e;
        }
        List list3 = list2;
        if ((i & 32) != 0) {
            str = l81Var.f;
        }
        return l81Var.a(f, f5, f6, f7, list3, str);
    }

    @NotNull
    public final l81 a(float f, float f2, float f3, float f4, @NotNull List<l81> list, @NotNull String str) {
        b41.i(list, RichTextNode.CHILDREN);
        b41.i(str, "id");
        return new l81(f, f2, f3, f4, list, str);
    }

    @NotNull
    public final List<l81> c() {
        return this.e;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l81) {
            l81 l81Var = (l81) obj;
            return b41.d(Float.valueOf(this.a), Float.valueOf(l81Var.a)) && b41.d(Float.valueOf(this.b), Float.valueOf(l81Var.b)) && b41.d(Float.valueOf(this.c), Float.valueOf(l81Var.c)) && b41.d(Float.valueOf(this.d), Float.valueOf(l81Var.d)) && b41.d(this.e, l81Var.e) && b41.d(this.f, l81Var.f);
        }
        return false;
    }

    public final float f() {
        return this.a;
    }

    public final float g() {
        return this.b;
    }

    public final void h(@NotNull String str) {
        b41.i(str, "<set-?>");
        this.f = str;
    }

    public int hashCode() {
        return (((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final void i(float f) {
        this.a = f;
    }

    public final void j(float f) {
        this.b = f;
    }

    @NotNull
    public String toString() {
        return "Layout(x=" + this.a + ", y=" + this.b + ", width=" + this.c + ", height=" + this.d + ", id='" + this.f + "')";
    }

    public /* synthetic */ l81(float f, float f2, float f3, float f4, List list, String str, int i, k50 k50Var) {
        this(f, f2, f3, f4, list, (i & 32) != 0 ? "" : str);
    }
}
