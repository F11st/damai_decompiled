package tb;

import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class kq2 {
    @Nullable
    public static final CustomTypeVariable a(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        gu2 f = z71Var.f();
        CustomTypeVariable customTypeVariable = f instanceof CustomTypeVariable ? (CustomTypeVariable) f : null;
        if (customTypeVariable != null && customTypeVariable.isTypeVariable()) {
            return customTypeVariable;
        }
        return null;
    }

    public static final boolean b(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        gu2 f = z71Var.f();
        CustomTypeVariable customTypeVariable = f instanceof CustomTypeVariable ? (CustomTypeVariable) f : null;
        if (customTypeVariable == null) {
            return false;
        }
        return customTypeVariable.isTypeVariable();
    }
}
