package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class i21<T> {
    private final int a;
    private final T b;

    public i21(int i, T t) {
        this.a = i;
        this.b = t;
    }

    public final int a() {
        return this.a;
    }

    public final T b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public final T d() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i21) {
            i21 i21Var = (i21) obj;
            return this.a == i21Var.a && b41.d(this.b, i21Var.b);
        }
        return false;
    }

    public int hashCode() {
        int i = this.a * 31;
        T t = this.b;
        return i + (t == null ? 0 : t.hashCode());
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.b + ')';
    }
}
