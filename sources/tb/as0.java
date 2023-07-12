package tb;

import android.view.View;
import com.alibaba.gaiax.render.node.GXNodeTreeUpdate;
import com.alibaba.gaiax.render.view.GXIRootView;
import com.alibaba.gaiax.utils.GXGlobalCache;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class as0 {
    public final void a(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        os0Var.F(false);
        GXNodeTreeUpdate.INSTANCE.a(os0Var);
    }

    public final void b(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        qr0 j = os0Var.j();
        if (j != null) {
            new ys0(os0Var, j).a();
            GXNodeTreeUpdate.INSTANCE.b(os0Var);
            return;
        }
        throw new IllegalArgumentException(b41.r("RootNode is null(bindViewDataOnlyViewTree) gxTemplateContext = ", os0Var));
    }

    @NotNull
    public final qr0 c(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        l81 c = GXGlobalCache.Companion.a().c(os0Var.r());
        if (c != null) {
            qr0 a = tr0.INSTANCE.a(os0Var, c);
            os0Var.L(a);
            return a;
        }
        throw new IllegalArgumentException("root layout is null");
    }

    @NotNull
    public final View d(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        qr0 j = os0Var.j();
        if (j != null) {
            View a = new ws0(os0Var, j).a();
            ((GXIRootView) a).setTemplateContext(os0Var);
            os0Var.M(a);
            View k = os0Var.k();
            if (k != null) {
                return k;
            }
            throw new IllegalArgumentException(b41.r("Create template view exception, gxTemplateContext = ", os0Var));
        }
        throw new IllegalArgumentException(b41.r("Create template view exception, root node null, ", os0Var));
    }

    public final void e(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        qr0 a = ur0.INSTANCE.a(os0Var);
        os0Var.L(a);
        l81 b = a.n().b();
        if (b != null) {
            GXGlobalCache.Companion.a().g(os0Var.r(), b);
        }
        a.K();
    }

    public final void f(@NotNull os0 os0Var) {
        b41.i(os0Var, "gxTemplateContext");
        GXNodeTreeUpdate.INSTANCE.c(os0Var);
    }
}
