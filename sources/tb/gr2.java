package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class gr2 {
    @Nullable
    public static final z71 a(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        if (z71Var instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) z71Var).getEnhancement();
        }
        return null;
    }

    @NotNull
    public static final gu2 b(@NotNull gu2 gu2Var, @NotNull z71 z71Var) {
        b41.i(gu2Var, "<this>");
        b41.i(z71Var, "origin");
        return e(gu2Var, a(z71Var));
    }

    @NotNull
    public static final gu2 c(@NotNull gu2 gu2Var, @NotNull z71 z71Var, @NotNull Function1<? super z71, ? extends z71> function1) {
        b41.i(gu2Var, "<this>");
        b41.i(z71Var, "origin");
        b41.i(function1, "transform");
        z71 a = a(z71Var);
        return e(gu2Var, a == null ? null : function1.invoke(a));
    }

    @NotNull
    public static final z71 d(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        z71 a = a(z71Var);
        return a == null ? z71Var : a;
    }

    @NotNull
    public static final gu2 e(@NotNull gu2 gu2Var, @Nullable z71 z71Var) {
        b41.i(gu2Var, "<this>");
        if (z71Var == null) {
            return gu2Var;
        }
        if (gu2Var instanceof fd2) {
            return new gd2((fd2) gu2Var, z71Var);
        }
        if (gu2Var instanceof ak0) {
            return new ck0((ak0) gu2Var, z71Var);
        }
        throw new NoWhenBranchMatchedException();
    }
}
