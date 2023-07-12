package tb;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class vs0 {
    @NotNull
    public static final vs0 INSTANCE = new vs0();

    private vs0() {
    }

    public static /* synthetic */ AbsoluteLayout.LayoutParams b(vs0 vs0Var, qr0 qr0Var, l81 l81Var, float f, float f2, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        if ((i & 8) != 0) {
            f2 = 0.0f;
        }
        return vs0Var.a(qr0Var, l81Var, f, f2);
    }

    @NotNull
    public final AbsoluteLayout.LayoutParams a(@NotNull qr0 qr0Var, @Nullable l81 l81Var, float f, float f2) {
        b41.i(qr0Var, "data");
        if (l81Var != null) {
            return new AbsoluteLayout.LayoutParams((int) l81Var.e(), (int) l81Var.d(), ((int) l81Var.f()) + ((int) f), ((int) l81Var.g()) + ((int) f2));
        }
        return new AbsoluteLayout.LayoutParams(-2, -2, 0, 0);
    }

    public final void c(@NotNull View view, @NotNull l81 l81Var, float f, float f2) {
        b41.i(view, "view");
        b41.i(l81Var, "layout");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) l81Var.e();
        layoutParams.height = (int) l81Var.d();
        if (layoutParams instanceof AbsoluteLayout.LayoutParams) {
            AbsoluteLayout.LayoutParams layoutParams2 = (AbsoluteLayout.LayoutParams) layoutParams;
            layoutParams2.x = ((int) l81Var.f()) + ((int) f);
            layoutParams2.y = ((int) l81Var.g()) + ((int) f2);
        }
        view.setLayoutParams(layoutParams);
    }
}
