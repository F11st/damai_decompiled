package tb;

import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@SinceKotlin(version = "1.1")
/* loaded from: classes3.dex */
public final class d81 implements Comparable<d81> {
    public static final int MAX_COMPONENT_VALUE = 255;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    @NotNull
    public static final a Companion = new a(null);
    @JvmField
    @NotNull
    public static final d81 CURRENT = e81.a();

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public d81(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = b(i, i2, i3);
    }

    private final int b(int i, int i2, int i3) {
        boolean z = false;
        if (new n31(0, 255).f(i) && new n31(0, 255).f(i2) && new n31(0, 255).f(i3)) {
            z = true;
        }
        if (z) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(@NotNull d81 d81Var) {
        b41.i(d81Var, "other");
        return this.d - d81Var.d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        d81 d81Var = obj instanceof d81 ? (d81) obj : null;
        return d81Var != null && this.d == d81Var.d;
    }

    public int hashCode() {
        return this.d;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('.');
        sb.append(this.b);
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }

    public d81(int i, int i2) {
        this(i, i2, 0);
    }
}
