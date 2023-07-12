package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ty2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class x51 extends uy2 {
    @NotNull
    public static final x51 INSTANCE = new x51();

    private x51() {
        super("protected_and_package", true);
    }

    @Override // tb.uy2
    @Nullable
    public Integer a(@NotNull uy2 uy2Var) {
        b41.i(uy2Var, "visibility");
        if (b41.d(this, uy2Var)) {
            return 0;
        }
        if (uy2Var == ty2.C9738b.INSTANCE) {
            return null;
        }
        return Integer.valueOf(ty2.INSTANCE.b(uy2Var) ? 1 : -1);
    }

    @Override // tb.uy2
    @NotNull
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // tb.uy2
    @NotNull
    public uy2 d() {
        return ty2.C9743g.INSTANCE;
    }
}
