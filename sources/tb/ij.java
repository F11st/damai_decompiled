package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ij {
    @NotNull
    private final hj a;
    private final int b;

    public ij(@NotNull hj hjVar, int i) {
        b41.i(hjVar, "classId");
        this.a = hjVar;
        this.b = i;
    }

    @NotNull
    public final hj a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    @NotNull
    public final hj d() {
        return this.a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ij) {
            ij ijVar = (ij) obj;
            return b41.d(this.a, ijVar.a) && this.b == ijVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int c = c();
        for (int i = 0; i < c; i++) {
            sb.append("kotlin/Array<");
        }
        sb.append(d());
        int c2 = c();
        for (int i2 = 0; i2 < c2; i2++) {
            sb.append(jn1.G);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
