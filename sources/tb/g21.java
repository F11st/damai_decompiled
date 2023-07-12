package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class g21<T> {
    private final T a;
    private final T b;
    @NotNull
    private final String c;
    @NotNull
    private final hj d;

    public g21(T t, T t2, @NotNull String str, @NotNull hj hjVar) {
        b41.i(str, "filePath");
        b41.i(hjVar, "classId");
        this.a = t;
        this.b = t2;
        this.c = str;
        this.d = hjVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g21) {
            g21 g21Var = (g21) obj;
            return b41.d(this.a, g21Var.a) && b41.d(this.b, g21Var.b) && b41.d(this.c, g21Var.c) && b41.d(this.d, g21Var.d);
        }
        return false;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.b;
        return ((((hashCode + (t2 != null ? t2.hashCode() : 0)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.a + ", expectedVersion=" + this.b + ", filePath=" + this.c + ", classId=" + this.d + ')';
    }
}
