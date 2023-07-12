package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ld2<T> {
    private T a;
    private T b;

    public ld2(T t, T t2) {
        this.a = t;
        this.b = t2;
    }

    public final T a() {
        return this.b;
    }

    public final T b() {
        return this.a;
    }

    public final void c(T t) {
        this.b = t;
    }

    public final void d(T t) {
        this.a = t;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ld2) {
            ld2 ld2Var = (ld2) obj;
            return b41.d(this.a, ld2Var.a) && b41.d(this.b, ld2Var.b);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        return hashCode + (t2 != null ? t2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Size(width=" + this.a + ", height=" + this.b + ')';
    }
}
