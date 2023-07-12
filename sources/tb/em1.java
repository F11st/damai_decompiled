package tb;

import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class em1 {
    @NotNull
    public static final em1 INSTANCE = new em1();

    private em1() {
    }

    public final boolean a(@NotNull gu2 gu2Var) {
        b41.i(gu2Var, "type");
        return a2.INSTANCE.a(xc2.INSTANCE.a(false, true), dk0.c(gu2Var), AbstractTypeCheckerContext.a.b.INSTANCE);
    }
}
