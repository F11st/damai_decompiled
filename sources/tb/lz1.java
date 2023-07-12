package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class lz1<T> {
    private T a;
    private T b;
    private T c;
    private T d;

    public lz1(T t, T t2, T t3, T t4) {
        this.a = t;
        this.b = t2;
        this.c = t3;
        this.d = t4;
    }

    public final T a() {
        return this.d;
    }

    public final T b() {
        return this.b;
    }

    public final T c() {
        return this.a;
    }

    public final T d() {
        return this.c;
    }

    public final void e(T t) {
        this.d = t;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof lz1) {
            lz1 lz1Var = (lz1) obj;
            return b41.d(this.a, lz1Var.a) && b41.d(this.b, lz1Var.b) && b41.d(this.c, lz1Var.c) && b41.d(this.d, lz1Var.d);
        }
        return false;
    }

    public final void f(T t) {
        this.b = t;
    }

    public final void g(T t) {
        this.a = t;
    }

    public final void h(T t) {
        this.c = t;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        int hashCode2 = (hashCode + (t2 == null ? 0 : t2.hashCode())) * 31;
        T t3 = this.c;
        int hashCode3 = (hashCode2 + (t3 == null ? 0 : t3.hashCode())) * 31;
        T t4 = this.d;
        return hashCode3 + (t4 != null ? t4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Rect(start=" + this.a + ", end=" + this.b + ", top=" + this.c + ", bottom=" + this.d + ')';
    }
}
