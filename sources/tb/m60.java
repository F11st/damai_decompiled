package tb;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class m60 extends f70 {
    @NotNull
    private final uy2 a;

    public m60(@NotNull uy2 uy2Var) {
        b41.i(uy2Var, "delegate");
        this.a = uy2Var;
    }

    @Override // tb.f70
    @NotNull
    public uy2 b() {
        return this.a;
    }

    @Override // tb.f70
    @NotNull
    public String c() {
        return b().b();
    }

    @Override // tb.f70
    @NotNull
    public f70 f() {
        f70 j = e70.j(b().d());
        b41.h(j, "toDescriptorVisibility(delegate.normalize())");
        return j;
    }
}
