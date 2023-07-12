package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class md1 {
    @NotNull
    private final String a;
    @NotNull
    private final n31 b;

    public md1(@NotNull String str, @NotNull n31 n31Var) {
        b41.i(str, "value");
        b41.i(n31Var, "range");
        this.a = str;
        this.b = n31Var;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof md1) {
            md1 md1Var = (md1) obj;
            return b41.d(this.a, md1Var.a) && b41.d(this.b, md1Var.b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.a + ", range=" + this.b + ')';
    }
}
