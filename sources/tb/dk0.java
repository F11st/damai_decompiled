package tb;

import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class dk0 {
    @NotNull
    public static final ak0 a(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return (ak0) z71Var.f();
    }

    public static final boolean b(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        return z71Var.f() instanceof ak0;
    }

    @NotNull
    public static final fd2 c(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        gu2 f = z71Var.f();
        if (f instanceof ak0) {
            return ((ak0) f).k();
        }
        if (f instanceof fd2) {
            return (fd2) f;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public static final fd2 d(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        gu2 f = z71Var.f();
        if (f instanceof ak0) {
            return ((ak0) f).l();
        }
        if (f instanceof fd2) {
            return (fd2) f;
        }
        throw new NoWhenBranchMatchedException();
    }
}
