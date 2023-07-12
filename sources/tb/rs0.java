package tb;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import org.jetbrains.annotations.NotNull;
import tb.k80;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class rs0 {
    @NotNull
    public static final rs0 INSTANCE = new rs0();

    private rs0() {
    }

    public final void a(@NotNull lz1<k80> lz1Var, @NotNull lz1<k80> lz1Var2) {
        b41.i(lz1Var, AdvanceSetting.NETWORK_TYPE);
        b41.i(lz1Var2, "targetDimension");
        if (!(lz1Var.c() instanceof k80.d)) {
            lz1Var2.g(lz1Var.c());
        }
        if (!(lz1Var.b() instanceof k80.d)) {
            lz1Var2.f(lz1Var.b());
        }
        if (!(lz1Var.d() instanceof k80.d)) {
            lz1Var2.h(lz1Var.d());
        }
        if (lz1Var.a() instanceof k80.d) {
            return;
        }
        lz1Var2.e(lz1Var.a());
    }

    public final void b(@NotNull ld2<k80> ld2Var, @NotNull ld2<k80> ld2Var2) {
        b41.i(ld2Var, "src");
        b41.i(ld2Var2, "target");
        if (!(ld2Var.b() instanceof k80.d)) {
            ld2Var2.d(ld2Var.b());
        }
        if (ld2Var.a() instanceof k80.d) {
            return;
        }
        ld2Var2.c(ld2Var.a());
    }
}
