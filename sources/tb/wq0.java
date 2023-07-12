package tb;

import com.alibaba.gaiax.GXRegisterCenter;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class wq0 {
    @NotNull
    public static final wq0 INSTANCE = new wq0();

    private wq0() {
    }

    public final void a(@NotNull Exception exc) {
        b41.i(exc, "msg");
        GXRegisterCenter.GXIExtensionException i = GXRegisterCenter.Companion.a().i();
        if (i != null) {
            i.exception(exc);
        }
        kr0 kr0Var = kr0.INSTANCE;
        if (kr0Var.b()) {
            kr0Var.a(b41.r("GXExceptionHelper.exception ", exc.getMessage()));
        }
    }

    public final boolean b() {
        return GXRegisterCenter.Companion.a().i() != null;
    }
}
