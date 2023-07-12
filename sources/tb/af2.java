package tb;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class af2 {
    public static final ni1 NO_NAME_PROVIDED = ni1.i("<no name provided>");
    public static final ni1 ROOT_PACKAGE = ni1.i("<root package>");
    public static final ni1 DEFAULT_NAME_FOR_COMPANION_OBJECT = ni1.f("Companion");
    public static final ni1 SAFE_IDENTIFIER_FOR_NO_NAME = ni1.f("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
    public static final ni1 ANONYMOUS_FUNCTION = ni1.i("<anonymous>");

    private static /* synthetic */ void a(int i) {
        String str = i != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i != 1 ? 2 : 3];
        if (i != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = "name";
        }
        if (i != 1) {
            objArr[1] = "safeIdentifier";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        }
        if (i == 1) {
            objArr[2] = "isSafeIdentifier";
        }
        String format = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalArgumentException(format);
        }
    }

    public static boolean b(@NotNull ni1 ni1Var) {
        if (ni1Var == null) {
            a(1);
        }
        return (ni1Var.b().isEmpty() || ni1Var.g()) ? false : true;
    }

    @NotNull
    public static ni1 c(@Nullable ni1 ni1Var) {
        if (ni1Var == null || ni1Var.g()) {
            ni1Var = SAFE_IDENTIFIER_FOR_NO_NAME;
        }
        if (ni1Var == null) {
            a(0);
        }
        return ni1Var;
    }
}
