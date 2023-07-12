package tb;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.gaiax.render.view.basic.GXShadowLayout;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ws0 extends xs0<View> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ws0(@NotNull os0 os0Var, @NotNull qr0 qr0Var) {
        super(os0Var, qr0Var);
        b41.i(os0Var, "gxTemplateContext");
        b41.i(qr0Var, "rootNode");
    }

    @Override // tb.xs0
    @NotNull
    public l81 c(@NotNull qr0 qr0Var) {
        b41.i(qr0Var, "childNode");
        l81 i = qr0Var.i();
        if (i != null) {
            return i;
        }
        throw new IllegalArgumentException("Stretch layout info is null");
    }

    @Override // tb.xs0
    @NotNull
    public l81 e() {
        l81 i = f().i();
        if (i != null) {
            return i;
        }
        throw new IllegalArgumentException(b41.r("Stretch layout info is null gxTemplateContext = ", d()));
    }

    @Override // tb.xs0
    @NotNull
    /* renamed from: i */
    public View g(@NotNull os0 os0Var, @NotNull View view, @NotNull String str, @Nullable String str2, @NotNull qr0 qr0Var, @NotNull l81 l81Var, float f, float f2) {
        b41.i(os0Var, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(view, "parentMergeView");
        b41.i(str, "childType");
        b41.i(qr0Var, "childNode");
        b41.i(l81Var, "childLayout");
        if (qr0Var.A()) {
            View a = us0.INSTANCE.a(os0Var.e(), "shadow", null);
            a.setLayoutParams(vs0.INSTANCE.a(qr0Var, l81Var, f, f2));
            qr0Var.O((GXShadowLayout) a);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(a);
            }
        }
        us0 us0Var = us0.INSTANCE;
        View a2 = us0Var.a(os0Var.e(), str, str2);
        vs0 vs0Var = vs0.INSTANCE;
        a2.setLayoutParams(vs0Var.a(qr0Var, l81Var, f, f2));
        qr0Var.b0(a2);
        boolean z = view instanceof ViewGroup;
        if (z) {
            ((ViewGroup) view).addView(a2);
        }
        if (qr0Var.z()) {
            View a3 = us0Var.a(os0Var.e(), "lottie", null);
            a3.setLayoutParams(vs0Var.a(qr0Var, l81Var, f, f2));
            qr0Var.U(a3);
            if (z) {
                ((ViewGroup) view).addView(a3);
            }
        }
        return a2;
    }

    @Override // tb.xs0
    @NotNull
    /* renamed from: j */
    public View h(@NotNull os0 os0Var, @NotNull qr0 qr0Var, @NotNull l81 l81Var) {
        b41.i(os0Var, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(qr0Var, "node");
        b41.i(l81Var, "layout");
        View a = us0.INSTANCE.a(os0Var.e(), f().p(), f().e());
        a.setLayoutParams(vs0.b(vs0.INSTANCE, f(), l81Var, 0.0f, 0.0f, 12, null));
        f().b0(a);
        return a;
    }
}
