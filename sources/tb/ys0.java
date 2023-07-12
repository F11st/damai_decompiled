package tb;

import android.view.View;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ys0 extends xs0<View> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ys0(@NotNull os0 os0Var, @NotNull qr0 qr0Var) {
        super(os0Var, qr0Var);
        b41.i(os0Var, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(qr0Var, "rootNode");
    }

    @Override // tb.xs0
    @NotNull
    public l81 c(@NotNull qr0 qr0Var) {
        b41.i(qr0Var, "childNode");
        l81 h = qr0Var.h();
        if (h != null) {
            return h;
        }
        throw new IllegalArgumentException("Stretch layout info is null");
    }

    @Override // tb.xs0
    @NotNull
    public l81 e() {
        l81 h = f().h();
        if (h != null) {
            return h;
        }
        throw new IllegalArgumentException(b41.r("Stretch layout info is null gxTemplateContext = ", d()));
    }

    @Override // tb.xs0
    @Nullable
    /* renamed from: i */
    public View g(@NotNull os0 os0Var, @NotNull View view, @NotNull String str, @Nullable String str2, @NotNull qr0 qr0Var, @NotNull l81 l81Var, float f, float f2) {
        View j;
        GXShadowLayout b;
        b41.i(os0Var, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(view, "parentMergeView");
        b41.i(str, "childType");
        b41.i(qr0Var, "childNode");
        b41.i(l81Var, "childLayout");
        View q = qr0Var.q();
        if (q == null) {
            return null;
        }
        if (qr0Var.A() && (b = qr0Var.b()) != null) {
            vs0.INSTANCE.c(b, l81Var, f, f2);
        }
        if (qr0Var.z() && (j = qr0Var.j()) != null) {
            vs0.INSTANCE.c(j, l81Var, f, f2);
        }
        vs0.INSTANCE.c(q, l81Var, f, f2);
        return q;
    }

    @Override // tb.xs0
    @Nullable
    /* renamed from: j */
    public View h(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull l81 l81Var) {
        b41.i(os0Var, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(qr0Var, "node");
        b41.i(l81Var, "layout");
        View q = qr0Var.q();
        if (q == null) {
            return null;
        }
        vs0.INSTANCE.c(q, l81Var, 0.0f, 0.0f);
        return q;
    }
}
