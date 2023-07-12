package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class uy2 {
    @NotNull
    private final String a;
    private final boolean b;

    /* JADX INFO: Access modifiers changed from: protected */
    public uy2(@NotNull String str, boolean z) {
        b41.i(str, "name");
        this.a = str;
        this.b = z;
    }

    @Nullable
    public Integer a(@NotNull uy2 uy2Var) {
        b41.i(uy2Var, "visibility");
        return ty2.INSTANCE.a(this, uy2Var);
    }

    @NotNull
    public String b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }

    @NotNull
    public uy2 d() {
        return this;
    }

    @NotNull
    public final String toString() {
        return b();
    }
}
