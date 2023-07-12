package tb;

import org.jetbrains.annotations.NotNull;
import tb.ty2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class y51 extends uy2 {
    @NotNull
    public static final y51 INSTANCE = new y51();

    private y51() {
        super("protected_static", true);
    }

    @Override // tb.uy2
    @NotNull
    public String b() {
        return "protected/*protected static*/";
    }

    @Override // tb.uy2
    @NotNull
    public uy2 d() {
        return ty2.C9743g.INSTANCE;
    }
}
