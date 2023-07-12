package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ty2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class w51 extends uy2 {
    @NotNull
    public static final w51 INSTANCE = new w51();

    private w51() {
        super("package", false);
    }

    @Override // tb.uy2
    @Nullable
    public Integer a(@NotNull uy2 uy2Var) {
        b41.i(uy2Var, "visibility");
        if (this == uy2Var) {
            return 0;
        }
        return ty2.INSTANCE.b(uy2Var) ? 1 : -1;
    }

    @Override // tb.uy2
    @NotNull
    public String b() {
        return "public/*package*/";
    }

    @Override // tb.uy2
    @NotNull
    public uy2 d() {
        return ty2.C9743g.INSTANCE;
    }
}
