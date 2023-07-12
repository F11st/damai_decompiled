package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ds0 {
    @Nullable
    private hs0 a;
    @Nullable
    private hs0 b;
    @Nullable
    private hs0 c;
    @Nullable
    private hs0 d;

    public ds0(@Nullable hs0 hs0Var, @Nullable hs0 hs0Var2, @Nullable hs0 hs0Var3, @Nullable hs0 hs0Var4) {
        this.a = hs0Var;
        this.b = hs0Var2;
        this.c = hs0Var3;
        this.d = hs0Var4;
    }

    private final float[] j() {
        float[] fArr = new float[8];
        hs0 hs0Var = this.a;
        float c = hs0Var == null ? 0.0f : hs0Var.c();
        hs0 hs0Var2 = this.b;
        float c2 = hs0Var2 == null ? 0.0f : hs0Var2.c();
        hs0 hs0Var3 = this.c;
        float c3 = hs0Var3 == null ? 0.0f : hs0Var3.c();
        hs0 hs0Var4 = this.d;
        float c4 = hs0Var4 != null ? hs0Var4.c() : 0.0f;
        fArr[0] = c;
        fArr[1] = c;
        fArr[2] = c2;
        fArr[3] = c2;
        fArr[4] = c4;
        fArr[5] = c4;
        fArr[6] = c3;
        fArr[7] = c3;
        return fArr;
    }

    @Nullable
    public final hs0 a() {
        return this.c;
    }

    @Nullable
    public final hs0 b() {
        return this.d;
    }

    @Nullable
    public final hs0 c() {
        return this.a;
    }

    @Nullable
    public final hs0 d() {
        return this.b;
    }

    @NotNull
    public final float[] e() {
        return j();
    }

    public final void f(@Nullable hs0 hs0Var) {
        this.c = hs0Var;
    }

    public final void g(@Nullable hs0 hs0Var) {
        this.d = hs0Var;
    }

    public final void h(@Nullable hs0 hs0Var) {
        this.a = hs0Var;
    }

    public final void i(@Nullable hs0 hs0Var) {
        this.b = hs0Var;
    }
}
